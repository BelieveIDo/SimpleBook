package com.wangfei.simplebook.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.wangfei.simplebook.R;
import com.wangfei.simplebook.RecommandDetailActivity;
import com.wangfei.simplebook.adapters.RecommandAdapter;
import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.utils.HttpUtils;

import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/1/11.
 * 精华页面
 */
public class TextFragment extends Fragment implements Callback<Recommand>, PtrHandler {

    private List<Recommand.ItemsEntity> mList;
    private RecyclerView mRecyclerView;
    private RecommandAdapter mRecommandAdapter;
    private PtrClassicFrameLayout mPtrFragmentLayout;
    private ImageView image;
    private int mCurPage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommand, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mPtrFragmentLayout = (PtrClassicFrameLayout) view.findViewById(R.id.ptr_frame);

        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.setTextColor(Color.BLACK);
        //        header.setPadding(0, 200, 0, 0);

        header.initWithString("loader");
        mPtrFragmentLayout.setKeepHeaderWhenRefresh(true);
        mPtrFragmentLayout.addPtrUIHandler(header);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecommandAdapter = new RecommandAdapter(getActivity());
        mRecyclerView.setAdapter(mRecommandAdapter);

       mRecommandAdapter.setListener(new RecommandAdapter.OnChildClickListener() {
           @Override
           public void onChildClick(View view, int position, Recommand.ItemsEntity data) {
               //点击事件

               Intent intent = new Intent(getActivity(), RecommandDetailActivity.class);
               intent.putExtra(RecommandDetailFragment.EXTRA_BEAN, data);
               startActivity(intent);
           }
       });

        //下拉刷新的实现
        mPtrFragmentLayout.setPtrHandler(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HttpUtils.getVedioService().getData("text",1).enqueue(this);
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                getData(++mCurPage);
            }
        });
    }

    /**
     * 请求网络加载数据
     */
    private void getData(int page) {
        HttpUtils.getVedioService().getData("text", page).enqueue(this);
    }
    @Override
    public void onResponse(Response<Recommand> response) {
        if (mList != null){
            mList.clear();
        }
        if (mCurPage ==1){
            mRecommandAdapter.clear();
        }
        mList = response.body().getItems();
       mRecommandAdapter.addAll(mList);
        Toast.makeText(getActivity(), mList.get(0).getContent(), Toast.LENGTH_SHORT).show();
        mPtrFragmentLayout.refreshComplete();
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        mPtrFragmentLayout.refreshComplete();
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }

    /**
     * 检查是否可以下拉刷新
     * @param frame
     * @param content
     * @param header
     * @return
     */

    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    /**
     * 下拉刷新开始，需要加载数据时触发
     * @param frame
     */

    public void onRefreshBegin(PtrFrameLayout frame) {
        mCurPage = 1;
        getData(1);
    }

    public abstract class EndlessRecyclerOnScrollListener extends
            RecyclerView.OnScrollListener{
        private int previousTotal = 0;
        private boolean loading = true;
        int firstVisibleItem, visibleItemCount, totalItemCount;

        private int currentPage = 1;

        private LinearLayoutManager mLinearLayoutManager;

        public EndlessRecyclerOnScrollListener(
                LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = recyclerView.getChildCount();
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
