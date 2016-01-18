package com.wangfei.simplebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wangfei.simplebook.adapters.CommentAdapter;
import com.wangfei.simplebook.domain.PicBean;
import com.wangfei.simplebook.domain.PicCommentBen;
import com.wangfei.simplebook.utils.NhHttpUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity implements Callback<PicCommentBen> {

    private ListView listView;
    private Intent intent;
    private List<PicCommentBen.ItemsEntity> list;
    private CommentAdapter adapter;
    private PicBean.ItemsEntity entity;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        listView = (ListView)findViewById(R.id.comment_list);
        list = new ArrayList<>();
        intent = getIntent();
        bundle = intent.getBundleExtra("bundle");
        entity =(PicBean.ItemsEntity)bundle.getSerializable("item");
        View view = getLayoutInflater().inflate(R.layout.comment_head, null);
        initHeadView(view);
        adapter = new CommentAdapter(this,list);
        listView.addHeaderView(view);
        listView.setAdapter(adapter);
        Call<PicCommentBen> call = NhHttpUtils.getService().getPicComment(entity.getId(), 1);
        call.enqueue(this);
    }
    public void initHeadView(View itemView){
        SimpleDraweeView imgIcon = ((SimpleDraweeView) itemView.findViewById(R.id.image_icon));
        TextView content = ((TextView) itemView.findViewById(R.id.content_text));
        SimpleDraweeView contentImg = ((SimpleDraweeView) itemView.findViewById(R.id.content_image));
        TextView name = ((TextView) itemView.findViewById(R.id.name_text));
        TextView supportCount = ((TextView) itemView.findViewById(R.id.text_support));
        TextView unsupportCount = ((TextView) itemView.findViewById(R.id.text_unsupport));
        TextView commentCount = ((TextView) itemView.findViewById(R.id.text_comment));
        TextView sharyCount = ((TextView) itemView.findViewById(R.id.text_shary));
//            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(getResources());
//            imgIcon.setProgressBarImage(new ProgressBarDrawable()).build();
        RadioGroup group = ((RadioGroup) itemView.findViewById(R.id.radio_group));
        imgIcon.setImageURI(Uri.parse(getIconUrl(entity.getUser())));
        imgIcon.setAspectRatio(1f);
        contentImg.setImageURI(Uri.parse(getImageUrl(entity.getImage())));
        List<Integer> s = entity.getImage_size().getS();
        contentImg.setAspectRatio(1.0f * s.get(0) / s.get(1));
        content.setText(entity.getContent());
        name.setText(entity.getUser().getLogin());
        supportCount.setText(String.valueOf(entity.getVotes().getUp()));
        unsupportCount.setText(String.valueOf(entity.getVotes().getDown()));
        commentCount.setText(String.valueOf(entity.getComments_count()));
        sharyCount.setText(String.valueOf(entity.getShare_count()));
        int position = bundle.getInt("position");
        group.setTag(position);
        for (int i = 0; i < 4; i++) {
//            group.getChildAt(i).setOnClickListener(onClickListener);
            group.getChildAt(i).setTag(position);
        }
        group.getChildAt(0).setSelected(entity.isSupport());
        group.getChildAt(1).setSelected(entity.isUnsupport());
        group.getChildAt(2).setSelected(entity.isComment());
        group.getChildAt(3).setSelected(entity.isShary());
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
    public void onResponse(Response<PicCommentBen> response) {
        List<PicCommentBen.ItemsEntity> items = response.body().getItems();
        adapter.addAll(items);
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
    }
}
