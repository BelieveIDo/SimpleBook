package com.wangfei.simplebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.wangfei.simplebook.adapters.VideoDetailBodyAdapter;
import com.wangfei.simplebook.domain.VideoBean;
import com.wangfei.simplebook.domain.VideoCommentBean;
import com.wangfei.simplebook.domain.VideoDetailBean;
import com.wangfei.simplebook.utils.HttpUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoDetailActivity extends AppCompatActivity implements Callback<VideoCommentBean>, PtrHandler {

    private ListView listView;
    private List<VideoCommentBean.ItemsEntity> commentList;
    private VideoDetailBean detailbean;
    private VideoBean.ItemsEntity entity;
    private VideoDetailBodyAdapter adapter;
    private PtrClassicFrameLayout mPtrClassicFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        setContentView(R.layout.activity_video_detail);
        listView = (ListView) findViewById(R.id.video_details_listview);
        mPtrClassicFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.ptr_class);
        mPtrClassicFrameLayout.setPtrHandler(this);
   }

    private int id;//视频id

    private void initData() {
//        初始化变量和数据
        commentList=new ArrayList<>();
        detailbean=new VideoDetailBean();
        adapter = new VideoDetailBodyAdapter(this,detailbean);
        listView.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            id=extras.getInt("id");
            entity = (VideoBean.ItemsEntity) extras.get("item");
        }
        toHttp(page);
    }

    private int page=1;
    public void toHttp(int page){
        //     请求网络获取相关评论信息
        HttpUtils.getVedioService().getComments(id,page).enqueue(this);
    }

    private void initListener() {
    }

    @Override
    public void onResponse(Response<VideoCommentBean> response) {
       if(response.body().getItems()!=null){
           addAll(response.body().getItems());
       }

        detailbean.setCommentList(commentList);
        detailbean.setItemsEntity(entity);

        adapter.notifyDataSetChanged();

    }
//添加数据
    public void addAll(Collection<? extends VideoCommentBean.ItemsEntity> collection){
        commentList.addAll(collection);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this,"网络失败",Toast.LENGTH_SHORT).show();
    }



    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        page=1;
        toHttp(page);
//        刷新完成
        mPtrClassicFrameLayout.refreshComplete();
    }
}
