package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.domain.RecommandBean;
import com.wangfei.simplebook.utils.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/12/29.
 */
public class RecommandDetailAdapter extends BaseAdapter implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {


    private static final int TYPT_1 = 0;
    private static final int TYPT_2 = 1;
    private Context context;
    private List<Object> list = null;
    private MediaPlayer player;
    private ViewHolder holder;

    public RecommandDetailAdapter(Context context) {
        this.context = context;
        list = new ArrayList<Object>();
        player = new MediaPlayer();
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {

        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public void addAll(Collection<? extends Object> collection) {
        Log.d("ItemAdapter", "addAll " + collection.size());
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear() {
        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && list.get(i) instanceof Recommand.ItemsEntity) {
                list.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPT_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.recommand_item, parent, false);
                    holder = new ViewHolder(convertView);
                    holder.image.setOnClickListener(this);
                    convertView.setTag(holder);
                    break;
                case TYPT_2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.recommand_comment_item, parent, false);
                    convertView.setTag(new CommentViewholder(convertView));
                    break;
            }
        }
        switch (type) {
            case TYPT_1: {
                Recommand.ItemsEntity entity = (Recommand.ItemsEntity) list.get(position);
                Recommand.ItemsEntity.UserEntity user = entity.getUser();
                ViewHolder holder = (ViewHolder) convertView.getTag();
                if (user != null) {
                    holder.userIcon.setImageURI(Uri.parse(ImageUtils.getUserImageUrl(user.getId() + "", user.getIcon())));
                    holder.userName.setText(user.getLogin());
                } else {
                    holder.userIcon.setImageResource(R.mipmap.ic_launcher);
                    holder.userName.setText("匿名");
                }
                holder.tv_joke.setText("好笑 " + entity.getVotes().getUp());
                holder.tv_command.setText(".评论 " + entity.getComments_count());
                if (entity.getShare_count() > 0) {
                    holder.tv_share.setText("分享" + entity.getShare_count());
                }

                holder.content.setText(entity.getContent());
                //根据类别加载
                String format = entity.getFormat();
                switch (format) {
                    case "word":
                        //纯文字
                        holder.contentLayout.setVisibility(View.GONE);
                        break;
                    case "image":

                        holder.contentLayout.setVisibility(View.VISIBLE);
                        holder.play.setVisibility(View.GONE);
                        holder.progressbar.setVisibility(View.GONE);
                        String imageUrl = (String) entity.getImage();
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) holder.image.getLayoutParams();
                        //设置图片宽高比
                        holder.image.setAspectRatio(1.0f * entity.getImage_size().getM().get(0) / entity.getImage_size().getS().get(0));
                        holder.image.setImageURI(Uri.parse(ImageUtils.getImageUrl(imageUrl, "small")));
                        break;
                    case "video":
                        resetHolder(holder);
                        holder.contentLayout.setVisibility(View.VISIBLE);
                        //视频
                        holder.image.setAspectRatio(1.0f * entity.getPic_size().get(0) / entity.getPic_size().get(1));
                        holder.image.setImageURI(Uri.parse(entity.getPic_url()));
                        holder.play.setVisibility(View.VISIBLE);
                        break;
                }
            }
            break;
            case TYPT_2:
                CommentViewholder viewHolder2 = (CommentViewholder) convertView.getTag();
                RecommandBean.ItemsEntity bean = (RecommandBean.ItemsEntity) list.get(position);
                viewHolder2.userNmae.setText(bean.getUser().getLogin());
                viewHolder2.content.setText(bean.getContent());
                viewHolder2.userIcon.setImageURI(Uri.parse(ImageUtils.getUserImageUrl(bean.getUser().getId() + "", bean.getUser().getIcon())));
                break;
        }

        return convertView;
    }

    private void resetHolder(ViewHolder holder) {
        holder.image.setVisibility(View.VISIBLE);
        holder.play.setVisibility(View.VISIBLE);
        holder.progressbar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {
        try {
            player.reset();
            Recommand.ItemsEntity bean = (Recommand.ItemsEntity) list.get(0);
            player.setDataSource(bean.getLow_url());
            player.setDisplay(holder.surfaceView.getHolder());
            player.prepareAsync();
            player.setOnPreparedListener(this);
            player.setOnCompletionListener(this);
            holder.play.setVisibility(View.INVISIBLE);
            holder.progressbar.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        holder.image.setVisibility(View.INVISIBLE);
        holder.progressbar.setVisibility(View.INVISIBLE);
    }

    ViewHolder lastHolder;

    @Override
    public void onCompletion(MediaPlayer mp) {

        mp.seekTo(0);
        mp.start();
    }


    private static class CommentViewholder {
        SimpleDraweeView userIcon;
        TextView userNmae;
        TextView content;

        public CommentViewholder(View view) {
            userIcon = (SimpleDraweeView) view.findViewById(R.id.iv_comment_icon);
            userNmae = (TextView) view.findViewById(R.id.tv_user_name);
            content = (TextView) view.findViewById(R.id.tv_comment_content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPT_1;
        } else {
            return TYPT_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private static class ViewHolder {

        private ImageView iv_down;
        private ImageView iv_command;
        private SimpleDraweeView userIcon;
        private TextView userName;
        private TextView content;
        private FrameLayout contentLayout;
        private SimpleDraweeView image;
        private SurfaceView surfaceView;
        private ImageView play;
        private ProgressBar progressbar;
        private TextView tv_joke;
        private TextView tv_command;
        private TextView tv_share;
        private ImageView iv_up;
        private ImageView iv_share;

        public ViewHolder(View itemView) {
            userIcon = (SimpleDraweeView) itemView.findViewById(R.id.iv_icon_recommand);
            userName = (TextView) itemView.findViewById(R.id.tv_name_recommand);
            content = (TextView) itemView.findViewById(R.id.tv_content_recommand);
            contentLayout = (FrameLayout) itemView.findViewById(R.id.fl_content_recommand);
            image = (SimpleDraweeView) itemView.findViewById(R.id.iv_image_recommand);
            surfaceView = (SurfaceView) itemView.findViewById(R.id.sv_video_recommand);
            play = (ImageView) itemView.findViewById(R.id.play);
            progressbar = (ProgressBar) itemView.findViewById(R.id.video_item_progress);
            tv_joke = (TextView) itemView.findViewById(R.id.joke);
            tv_command = (TextView) itemView.findViewById(R.id.command);
            tv_share = (TextView) itemView.findViewById(R.id.share);
            iv_up = (ImageView) itemView.findViewById(R.id.iv_item_up);
            iv_down = (ImageView) itemView.findViewById(R.id.iv_item_down);
            iv_command = (ImageView) itemView.findViewById(R.id.iv_item_comment);
            iv_share = (ImageView) itemView.findViewById(R.id.iv_item_share);

        }
    }
}
