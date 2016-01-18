package com.wangfei.simplebook.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.wangfei.simplebook.R;
import com.wangfei.simplebook.adapters.RecommandDetailAdapter;
import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.domain.RecommandBean;
import com.wangfei.simplebook.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/1/12.
 */
public class RecommandDetailFragment extends Fragment implements PtrHandler, Callback<RecommandBean> {

    public static final String EXTRA_BEAN = "extra_bean";
    private Recommand.ItemsEntity mBean;
    private ListView mListView;
    private PtrClassicFrameLayout mPtrFrame;
    private RecommandDetailAdapter mAdapter;


    public static RecommandDetailFragment newInstance(Recommand.ItemsEntity bean) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_BEAN, bean);
        RecommandDetailFragment fragment = new RecommandDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBean = (Recommand.ItemsEntity) getArguments().getSerializable(EXTRA_BEAN);
        mAdapter = new RecommandDetailAdapter(getActivity());
        List<Object> objects = new ArrayList<Object>();
        objects.add(mBean);
        mAdapter.addAll(objects);

       getData(mBean.getId()+"",1);
    }

    /**
     * 根据糗事Id获取对应的评论
     *
     * @param id
     * @return
     */
    public void getData(String id, int page) {

        HttpUtils.getVedioService().getReComments(id, page).enqueue(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommand_detail_fragmnet, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_detail);
        mPtrFrame = (PtrClassicFrameLayout) view.findViewById(R.id.comments_ptr_frame);
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.setTextColor(Color.BLACK);
        header.initWithString("loading");
        mPtrFrame.setKeepHeaderWhenRefresh(true);

        mPtrFrame.setPtrHandler(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView.setAdapter(mAdapter);
    }



    @Override
    public void onResponse(Response<RecommandBean> response) {
       List<RecommandBean.ItemsEntity> items = response.body().getItems();
        mAdapter.addAll(items);
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getActivity(),"网络错误" , Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return false;
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {

    }
}
