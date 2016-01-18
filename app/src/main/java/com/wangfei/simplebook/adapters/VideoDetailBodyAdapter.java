package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.domain.VideoBean;
import com.wangfei.simplebook.domain.VideoCommentBean;
import com.wangfei.simplebook.domain.VideoDetailBean;
import com.wangfei.simplebook.utils.DateUtils;
import com.wangfei.simplebook.utils.ImageUtils;

import java.io.IOException;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/12
 * Email : wangfeijn@163.com
 */
public class VideoDetailBodyAdapter extends BaseAdapter implements
        View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener   {

    //    声明成员变量
    private Context context;
    private VideoDetailBean bean;
    private MediaPlayer player;

    public VideoDetailBodyAdapter(Context context, VideoDetailBean bean) {
        this.context = context;
        this.bean = bean;
        player = new MediaPlayer();
    }

    @Override
    public int getCount() {
        int ret=0;
        if(bean.getCommentList()!=null){
            ret= bean.getCommentList().size() + 2;
        }
        return ret;
    }
    private void resetHolder(ViewHolder holder) {
        holder.video_item_pic.setVisibility(View.VISIBLE);
        holder.video_item_play.setVisibility(View.VISIBLE);
        holder.video_item_progress.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
        mp.start();
    }

    private ViewHolder lastHolder;



    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        lastHolder.video_item_pic.setVisibility(View.INVISIBLE);
        lastHolder.video_item_progress.setVisibility(View.INVISIBLE);
    }
    @Override
    public Object getItem(int position) {
        return bean.getCommentList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
//        0-1-2 三种布局
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        int type = getItemViewType(position);
        if(type==0){
//            加载视频布局
            if(convertView==null){
                holder=new ViewHolder();

                convertView=LayoutInflater.from(context).inflate(R.layout.video_details_headeritem,parent,false);

                holder.video_item_userimage= (SimpleDraweeView) convertView.findViewById(R.id.video_item_userimage);
                holder.video_item_pic= (SimpleDraweeView) convertView.findViewById(R.id.video_item_pic);
                holder.video_item_pic.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
                holder.video_item_pic.setOnClickListener(this);
                holder.video_item_pic.setTag(holder);

                holder.video_item_username= (TextView) convertView.findViewById(R.id.video_item_username);
                holder.video_item_content= (TextView) convertView.findViewById(R.id.video_item_content);
                holder.video_item_content_num= (TextView) convertView.findViewById(R.id.video_item_content_num);
                holder.video_item_hot=(ImageView) convertView.findViewById(R.id.video_item_hot);
                holder.video_item_play=(ImageView) convertView.findViewById(R.id.video_item_play);
                holder.video_item_imagefun=(ImageView) convertView.findViewById(R.id.video_item_imagefun);
                holder.video_item_imagenotfun=(ImageView) convertView.findViewById(R.id.video_item_imagenotfun);
                holder.video_item_imagecomment=(ImageView) convertView.findViewById(R.id.video_item_imagecomment);
                holder.video_item_imageshare=(ImageView) convertView.findViewById(R.id.video_item_imageshare);
                holder.video_item_video=(SurfaceView) convertView.findViewById(R.id.video_item_video);
                holder.video_item_progress=(ProgressBar) convertView.findViewById(R.id.video_item_progress);
                convertView.setTag(holder);
            }
                holder= (ViewHolder) convertView.getTag();
                VideoBean.ItemsEntity entity = bean.getItemsEntity();
//                赋值
                holder.video_item_imagecomment.setVisibility(View.GONE);
                if(entity.getUser()!=null){
                    holder.video_item_userimage.setImageURI(Uri.parse(
                            ImageUtils.getUserImageUrl(entity.getUser().getId() + "", entity.getUser().getIcon())));
                    holder.video_item_username.setText(entity.getUser().getLogin());
                }else{
                    holder.video_item_userimage.setImageResource(R.mipmap.ic_header);
                    holder.video_item_username.setText("无名");
                }
                holder.video_item_content.setText(entity.getContent());
                holder.video_item_pic.setImageURI(Uri.parse(entity.getPic_url()));
                holder.video_item_content_num.setText(
                        "好笑 " + entity.getVotes().getUp() +
                                "  评论 " + entity.getComments_count() +
                                "  分享 " + entity.getShare_count() +
                                "  无聊 " + Math.abs(Integer.parseInt(entity.getVotes().getDown() + ""))
                );
                if(entity.getType()!=null){
                    if(!(entity.getType().equals("hot"))){
                        holder.video_item_hot.setVisibility(View.INVISIBLE);
                    }
                }

            return convertView;
        }else if(type==1){
//            加载评论条目选择布局
            if(convertView==null){
                holder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.video_details_bodyitem,parent,false);
                holder.video_details_all= (TextView) convertView.findViewById(R.id.video_details_all);
                holder.video_details_hot= (TextView) convertView.findViewById(R.id.video_details_hot);
                holder.view_indicator= (View) convertView.findViewById(R.id.view_indicator);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
//                TODO: 写监听事件 评论数据根据分类动态刷新
            }
            return convertView;
        }else{
//            加载评论布局
            if(convertView==null){
                holder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.video_details_bodycomment_item,parent,false);
                holder.simpleDrawee= (SimpleDraweeView) convertView.findViewById(R.id.simpleDrawee);
                holder.comment_username= (TextView) convertView.findViewById(R.id.comment_username);
                holder.comment_ellipsis= (TextView) convertView.findViewById(R.id.comment_ellipsis);
                holder.comment_num= (TextView) convertView.findViewById(R.id.comment_num);
                holder.comment_body= (TextView) convertView.findViewById(R.id.comment_body);

                holder.comment_time= (TextView) convertView.findViewById(R.id.comment_time);
                holder.comment_praise_image= (ImageView) convertView.findViewById(R.id.comment_praise_image);
                convertView.setTag(holder);
            }
                holder= (ViewHolder) convertView.getTag();
//                评论人头像
                position=position-2;
                VideoCommentBean.ItemsEntity.UserEntity user = bean.getCommentList().get(position).getUser();
                if(user!=null){
                    holder.simpleDrawee.setImageURI(Uri.parse(
                            ImageUtils.getUserImageUrl(user.getId() + "", user.getIcon())));
                    holder.comment_username.setText(user.getLogin());
                }else{
                    holder.simpleDrawee.setImageResource(R.mipmap.ic_header);
                    holder.comment_username.setText("无名");
                }

                holder.comment_num.setText(bean.getCommentList().get(position).getLike_count()+"");
                holder.comment_body.setText(bean.getCommentList().get(position).getContent()+"");
                holder.comment_time.setText(DateUtils.getDataString(bean.getCommentList().get(position).getCreated_at()));
//                TODO: 点赞和分享处理

            return convertView;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_item_pic:
                videoPlay(v);
                break;
        }
    }
    //    控制视频播放
    public void videoPlay(View v){
        if (lastHolder != null) {
            resetHolder(lastHolder);
        }
        ViewHolder tag = (ViewHolder) v.getTag();
        try {
            player.reset();
            player.setDataSource(bean.getItemsEntity().getLow_url());
            player.setDisplay(tag.video_item_video.getHolder());
            player.prepareAsync();
            player.setOnPreparedListener(this);
            player.setOnCompletionListener(this);
            tag.video_item_play.setVisibility(View.INVISIBLE);
            tag.video_item_progress.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lastHolder = tag;
    }

    public static class ViewHolder {

//        评论布局
        private SimpleDraweeView simpleDrawee;
        private TextView comment_username,comment_ellipsis,comment_num,
                        comment_body,comment_time;
        private ImageView comment_praise_image;
//        中间条目布局
        private TextView video_details_all,video_details_hot;
        private View view_indicator;
//        视频布局
        private SimpleDraweeView video_item_userimage,video_item_pic;
        private TextView video_item_username,video_item_content,video_item_content_num;
        private ImageView video_item_hot,video_item_play,video_item_imagefun,
                             video_item_imagenotfun,video_item_imagecomment,video_item_imageshare;
        private SurfaceView video_item_video;
        private ProgressBar video_item_progress;

    }
}
