package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.domain.PicBean;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 24054 on 2016/1/11.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.PicViewHolder> {

    private Context context;
    private List<PicBean.ItemsEntity> list;
    private RadioButton.OnClickListener onClickListener;
    public PicAdapter(Context context, List<PicBean.ItemsEntity> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(RadioButton.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pic_item,parent,false);
        PicViewHolder viewHolder = new PicViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(PicViewHolder holder, int position) {
        PicBean.ItemsEntity entity = list.get(position);
        if(entity.getUser()==null){
            holder.imgIcon.setImageResource(R.mipmap.ic_discovery_default_avatar);
            holder.name.setText("匿名用户");
        }else{
            holder.imgIcon.setImageURI(Uri.parse(getIconUrl(entity.getUser())));
            holder.name.setText(entity.getUser().getLogin());
        }
        holder.contentImg.setImageURI(Uri.parse(getImageUrl(entity.getImage())));
        List<Integer> s = entity.getImage_size().getS();
        holder.contentImg.setAspectRatio(1.0f * s.get(0) / s.get(1));
        holder.content.setText(entity.getContent());
        holder.supportCount.setText(String.valueOf(entity.getVotes().getUp()));
        holder.unsupportCount.setText(String.valueOf(entity.getVotes().getDown()));
        holder.commentCount.setText(String.valueOf(entity.getComments_count()));
        holder.sharyCount.setText(String.valueOf(entity.getShare_count()));
        holder.group.setTag(position);
        for (int i = 0; i < 4; i++) {
            holder.group.getChildAt(i).setOnClickListener(onClickListener);
            holder.group.getChildAt(i).setTag(position);
        }
        holder.group.getChildAt(0).setSelected(entity.isSupport());
        holder.group.getChildAt(1).setSelected(entity.isUnsupport());
        holder.group.getChildAt(2).setSelected(entity.isComment());
        holder.group.getChildAt(3).setSelected(entity.isShary());
    }
    private static final Pattern pattern = Pattern.compile("(\\d+)\\d{4}");
    private static final String IMAGE_URL = "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
    private static final String ICON_URL = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
    public String getImageUrl(String image){
        if (image != null) {
            Matcher matcher = pattern.matcher(image);
            matcher.find();
            return String.format(IMAGE_URL, matcher.group(1), matcher.group(), "small", image);
        } else {
            return null;
        }
    }
    public String getIconUrl(PicBean.ItemsEntity.UserEntity user){
        if (user != null) {
            return String.format(ICON_URL, user.getId() / 10000, user.getId(), user.getIcon());
        } else {
            return null;
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public void clear(){
        int size = list.size();
        list.clear();
        notifyItemRangeRemoved(0,size);
    }
    public  void MyAddAll(Collection<? extends PicBean.ItemsEntity> collection){
        int size = list.size();
        list.addAll(collection);
        notifyItemRangeInserted(size,collection.size());
    }
    public static class PicViewHolder extends RecyclerView.ViewHolder{
        private  TextView supportCount;
        private  TextView unsupportCount;
        private  TextView commentCount;
        private  TextView sharyCount;
        private  RadioGroup group;
        private  TextView name;
        private  TextView content;
        private  SimpleDraweeView contentImg;
        private  SimpleDraweeView imgIcon;
        public PicViewHolder(View itemView) {
            super(itemView);
            imgIcon = ((SimpleDraweeView) itemView.findViewById(R.id.image_icon));
            content = ((TextView) itemView.findViewById(R.id.content_text));
            contentImg = ((SimpleDraweeView) itemView.findViewById(R.id.content_image));
            name = ((TextView) itemView.findViewById(R.id.name_text));
            supportCount = ((TextView) itemView.findViewById(R.id.text_support));
            unsupportCount = ((TextView) itemView.findViewById(R.id.text_unsupport));
            commentCount = ((TextView) itemView.findViewById(R.id.text_comment));
            sharyCount = ((TextView) itemView.findViewById(R.id.text_shary));
//            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources());
//            imgIcon.setProgressBarImage(new ProgressBarDrawable()).build();
            imgIcon.setAspectRatio(1f);
            group = ((RadioGroup) itemView.findViewById(R.id.radio_group));
        }
    }
}
