package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.VideoDetailActivity;
import com.wangfei.simplebook.domain.VideoBean;
import com.wangfei.simplebook.utils.ImageUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.VideoViewHolder> implements
        View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener  {

//    声明成员变量
    private Context context;
    private List<VideoBean.ItemsEntity> list;
    private MediaPlayer player;

//    构造初始化数据
    public VideoRecyclerAdapter(Context context, List<VideoBean.ItemsEntity> list) {
        this.context = context;
        this.list = list;
        player = new MediaPlayer();
    }



    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false);

        VideoViewHolder holder = new VideoViewHolder(view);
        holder.pic.setOnClickListener(this);
        holder.pic.setTag(holder);
        holder.video_item_imagecomment.setOnClickListener(this);
        holder.video_item_imagecomment.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        resetHolder(holder);
        VideoBean.ItemsEntity entity = list.get(position);
        holder.content.setText(entity.getContent());
        holder.pic.setImageURI(Uri.parse(entity.getPic_url()));
        holder.video_item_content_num.setText(
                "好笑 " + entity.getVotes().getUp() +
                        "  评论 " + entity.getComments_count() +
                        "  分享 " + entity.getShare_count() +
                        "  无聊 " + Math.abs(Integer.parseInt(entity.getVotes().getDown() + ""))
        );
        if(entity.getUser()!=null){
            holder.video_item_username.setText(entity.getUser().getLogin());
            holder.video_item_userimage.setImageURI(Uri.parse(
                    ImageUtils.getUserImageUrl(entity.getUser().getId()+"",entity.getUser().getIcon()) ));
        }else{
            holder.video_item_username.setText("无名");
            holder.video_item_userimage.setImageResource(R.mipmap.ic_header);
        }

        if(entity.getType()!=null){
            if(!(entity.getType().equals("hot"))){
                holder.video_item_hot.setVisibility(View.INVISIBLE);
            }
        }

    }

    @Override
    public void onViewDetachedFromWindow(VideoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (lastHolder != null && lastHolder.equals(holder)) {
            player.reset();
            lastHolder = null;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addAll(Collection<? extends VideoBean.ItemsEntity> collection){
        int size = list.size();
           list.addAll(collection);
           notifyItemRangeInserted(size, collection.size());
    }

    public void clear() {
        int size = list.size();
        list.clear();
        notifyItemRangeRemoved(list.size(), size);
    }

    private VideoViewHolder lastHolder;

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        lastHolder.pic.setVisibility(View.INVISIBLE);
        lastHolder.progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
        mp.start();
    }
    private void resetHolder(VideoViewHolder holder) {
        holder.pic.setVisibility(View.VISIBLE);
        holder.play.setVisibility(View.VISIBLE);
        holder.progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_item_pic:
                videoPlay(v);
                break;
            case R.id.video_item_imagecomment:
                start2Activity(v);
                break;
        }

    }
//    跳转页面
    public void start2Activity(View v){
        VideoViewHolder tag = (VideoViewHolder) v.getTag();
        int id = tag.getAdapterPosition();
        VideoBean.ItemsEntity entity = list.get(id);
        Intent intent=new Intent(context, VideoDetailActivity.class);
        intent.putExtra("id",entity.getId());
        intent.putExtra("item",entity);
        context.startActivity(intent);
    }

//    控制视频播放
    public void videoPlay(View v){
        if (lastHolder != null) {
            resetHolder(lastHolder);
        }
        VideoViewHolder tag = (VideoViewHolder) v.getTag();
        try {
            player.reset();
            player.setDataSource(list.get(tag.getAdapterPosition()).getLow_url());
            player.setDisplay(tag.video.getHolder());
            player.prepareAsync();
            player.setOnPreparedListener(this);
            player.setOnCompletionListener(this);
            tag.play.setVisibility(View.INVISIBLE);
            tag.progress.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lastHolder = tag;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{

        private TextView content,video_item_username,video_item_content_num;
        private SimpleDraweeView pic,video_item_userimage;
        private SurfaceView video;
        private ImageView play,video_item_hot,video_item_imagecomment;
        private ProgressBar progress;


        public VideoViewHolder(View itemView) {
            super(itemView);
            content = ((TextView) itemView.findViewById(R.id.video_item_content));
            video_item_username = ((TextView) itemView.findViewById(R.id.video_item_username));
            video_item_content_num = ((TextView) itemView.findViewById(R.id.video_item_content_num));
            video_item_hot=(ImageView)itemView.findViewById(R.id.video_item_hot);
            video_item_imagecomment=(ImageView)itemView.findViewById(R.id.video_item_imagecomment);

            pic = ((SimpleDraweeView) itemView.findViewById(R.id.video_item_pic));
            video_item_userimage=((SimpleDraweeView) itemView.findViewById(R.id.video_item_userimage));
            video = ((SurfaceView) itemView.findViewById(R.id.video_item_video));
            play = ((ImageView) itemView.findViewById(R.id.video_item_play));
            progress = ((ProgressBar) itemView.findViewById(R.id.video_item_progress));
//           分层加载图片的进度条
            pic.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
//            pic.setAspectRatio(1);
        }
    }
}
