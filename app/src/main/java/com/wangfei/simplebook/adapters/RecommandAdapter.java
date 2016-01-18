package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.utils.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/1/11.
 */
public class RecommandAdapter extends RecyclerView.Adapter<RecommandAdapter.ReViewHolder> implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    private Context context;
    private List<Recommand.ItemsEntity> list;
    private MediaPlayer player;
    private RecyclerView recyclerView;
    private OnChildClickListener listener;

    public RecommandAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        // 初始化播放器
        player = new MediaPlayer();
    }

    public void setListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ReViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recommand_item, parent, false);
        //RecyclerView点击事件
        view.setOnClickListener(this);
        ReViewHolder holder = new ReViewHolder(view);
        holder.image.setOnClickListener(this);
        holder.image.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReViewHolder holder, int position) {
        Recommand.ItemsEntity entity = list.get(position);
        Recommand.ItemsEntity.UserEntity user = entity.getUser();
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
                holder.image.setAspectRatio(1.0f * entity.getPic_size().get(0)/entity.getPic_size().get(1));
                holder.image.setImageURI(Uri.parse(entity.getPic_url()));
                holder.play.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 获取到当前的RecyclerView
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    /**
     * 初始视频条目
     *
     * @param holder
     */
    private void resetHolder(ReViewHolder holder) {
        holder.image.setVisibility(View.VISIBLE);
        holder.play.setVisibility(View.VISIBLE);
        holder.progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(Collection<? extends Recommand.ItemsEntity> collection) {
        int size = list.size();
        list.addAll(collection);
        notifyItemRangeInserted(size, collection.size());
    }

    public void clear() {
        int size = list.size();
        list.clear();
        notifyItemRangeRemoved(list.size(), size);
    }

    private ReViewHolder lastHolder;

    /**
     * 视频图片的点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        if (v instanceof SimpleDraweeView) {
            if (lastHolder != null) {
                resetHolder(lastHolder);
            }
            ReViewHolder tag = (ReViewHolder) v.getTag();
            int position = tag.getAdapterPosition();
            Recommand.ItemsEntity itemsEntity = list.get(position);
            if (!itemsEntity.getFormat().equals("video")) {
                return;
            }
            try {
                player.reset();
                player.setDataSource(list.get(tag.getAdapterPosition()).getLow_url());
                player.setDisplay(tag.surfaceView.getHolder());
                player.prepareAsync();
                player.setOnPreparedListener(this);
                player.setOnCompletionListener(this);
                tag.play.setVisibility(View.INVISIBLE);
                tag.progressbar.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            lastHolder = tag;
        } else if (v instanceof LinearLayout) {
            // 在ItemAnimator执行时不执行点击事件
            if (!recyclerView.getItemAnimator().isRunning() && listener != null) {
                //获取到点击的View在RecylerView中的位置
                int position = recyclerView.getChildAdapterPosition(v);
                //调用接口
                if (position >= 0) {
                    listener.onChildClick(v, position, list.get(position));
                }
            }
        }
    }

    /**
     * 准备
     *
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        lastHolder.image.setVisibility(View.INVISIBLE);
        lastHolder.progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onViewDetachedFromWindow(ReViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (lastHolder != null && lastHolder.equals(holder)) {
            player.reset();
            lastHolder = null;
        }
    }

    /**
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
        mp.start();
    }

    public static class ReViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView iv_down;
        private final ImageView iv_command;
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

        public ReViewHolder(View itemView) {
            super(itemView);
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

            iv_down.setOnClickListener(this);
            iv_up.setOnClickListener(this);
            iv_command.setOnClickListener(this);
            iv_share.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }

    //定义点击事件的接口
    public interface OnChildClickListener {
        //参数根据需求来定义

        /**
         * @param view     视图
         * @param position 位置
         * @param data     数据
         */
        void onChildClick(View view, int position, Recommand.ItemsEntity data);
    }
}
