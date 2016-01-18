package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.domain.PicCommentBen;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 24054 on 2016/1/12.
 */
public class CommentAdapter extends BaseAdapter {
    private Context context;
    private List<PicCommentBen.ItemsEntity> list;

    public CommentAdapter(Context context, List<PicCommentBen.ItemsEntity> list) {
        this.context = context;
        this.list = list;
    }
    public void addAll(Collection<? extends  PicCommentBen.ItemsEntity> itemsEntities){
        list.addAll(itemsEntities);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView == null){
             view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false);
        }else{
            view = convertView;
        }
        MyViewHolder viewHolder = (MyViewHolder)view.getTag();
        PicCommentBen.ItemsEntity itemsEntity = list.get(position);
        if(viewHolder == null){
            viewHolder = new MyViewHolder(view);
        }
        viewHolder.icon.setImageURI(Uri.parse(getIconUrl(itemsEntity.getUser())));
        int created_at = itemsEntity.getCreated_at();
        long timeMillis = System.currentTimeMillis()/1000;
        Log.d("dldlll", "getView() returned: " + created_at+",,,,"+timeMillis);
        viewHolder.name.setText(itemsEntity.getUser().getLogin());
        viewHolder.time.setText(getTime(((int) (timeMillis - created_at))));
        viewHolder.content.setText(itemsEntity.getContent());
        viewHolder.supportcount.setText(String.valueOf(itemsEntity.getLike_count()));
        return view;
    }
    public String getTime(int created_at){
        int minute = created_at / 60;
        int hours = created_at / 60 / 60;
        int date = created_at / 60 / 60 / 24;
        if(date>1){
            return  date+"天前";
        }else if(hours>1){
            return hours+"小时前";
        }else if(minute>1){
            return minute+"分钟前";
        }else{
            return "1分钟前";
        }
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
    public String getIconUrl(PicCommentBen.ItemsEntity.UserEntity user){
        if (user != null) {
            return String.format(ICON_URL, user.getId() / 10000, user.getId(), user.getIcon());
        } else {
            return null;
        }
    }
    public static class MyViewHolder{
        private  TextView name;
        private  TextView time;
        private  TextView content;
        private  TextView supportcount;
        private  SimpleDraweeView icon;
        public MyViewHolder(View view) {
            icon = ((SimpleDraweeView) view.findViewById(R.id.image_icon));
            name = ((TextView) view.findViewById(R.id.name_text));
            time = ((TextView) view.findViewById(R.id.time));
            content = ((TextView) view.findViewById(R.id.content_text));
            supportcount = ((TextView) view.findViewById(R.id.suport_count));
        }
    }
}
