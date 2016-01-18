package com.wangfei.simplebook.fragments;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangfei.simplebook.R;
import com.wangfei.simplebook.adapters.VideoRecyclerAdapter;
import com.wangfei.simplebook.domain.VideoBean;
import com.wangfei.simplebook.utils.HttpUtils;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements Callback<VideoBean>, PtrHandler {
    private RecyclerView recyclerview;
    private VideoRecyclerAdapter adapter;
    private PtrClassicFrameLayout mPtrFragmentLayout;


    public VideoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.video_recyclerview);
//        刷新
        mPtrFragmentLayout = (PtrClassicFrameLayout) view.findViewById(R.id.ptr_fram);

        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("loader");
        header.setTextColor(Color.BLUE);
        mPtrFragmentLayout.setKeepHeaderWhenRefresh(true);
        mPtrFragmentLayout.addPtrUIHandler(header);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPtrFragmentLayout.setPtrHandler(this);
        adapter = new VideoRecyclerAdapter(getContext(), new ArrayList<VideoBean.ItemsEntity>());
        recyclerview.setAdapter(adapter);
//        添加分割线
        recyclerview.addItemDecoration(new MyItemDecoration());
        toHttp(page);//初次默认请求第一页
    }

    int page=1;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerview.getLayoutManager();
        recyclerview.addOnScrollListener(new RecyclerViewScrollDetector(layoutManager) {

            @Override
            public void onLoadMore(int currentPage) {
                toHttp(++page);
            }
        });
    }

    private void toHttp(int page) {
        HttpUtils.getVedioService().getVideo(page).enqueue(this);
    }

//    检查是否可用刷新
    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
//       是否可以刷新
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);

    }

//    开始刷新
    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        page=1;
        toHttp(page);
    }

    private class MyItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(1, 1, 1, 1);
        }
    }

    @Override
    public void onResponse(Response<VideoBean> response) {
        if(page==1){
//            清空重新加载
            System.out.println("清空加载:" + "");
            adapter.clear();
            adapter.addAll(response.body().getItems());
        }else{
            System.out.println("继续加载:" + "");
            adapter.addAll(response.body().getItems());
        }

        mPtrFragmentLayout.refreshComplete();
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        mPtrFragmentLayout.refreshComplete();
    }


    abstract class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {

        private int previousTotal = 0;
        private boolean loading = true;
        int firstVisibleItem, visibleItemCount, totalItemCount;

        private int currentPage = 1;

        private LinearLayoutManager mLinearLayoutManager;

        public RecyclerViewScrollDetector(
                LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = recyclerView.getChildCount();

            RecyclerView.Adapter adapter = recyclerView.getAdapter();
//            最后一个视图
            View view = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
            int position = recyclerView.getChildAdapterPosition(view);
            if(position==adapter.getItemCount()-1){
                if(view.getBottom()<=recyclerView.getHeight()){
                    System.out.println("到底部了:" + "可以加载数据了");
                }
            }

            totalItemCount = mLinearLayoutManager.getItemCount();
            firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }
            if (!loading
                    && (totalItemCount - visibleItemCount) <= firstVisibleItem) {
                currentPage++;
                onLoadMore(currentPage);
                loading = true;
            }
        }
        public abstract void onLoadMore(int currentPage);
    }

}
