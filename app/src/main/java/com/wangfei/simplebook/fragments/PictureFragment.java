package com.wangfei.simplebook.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wangfei.simplebook.CommentActivity;
import com.wangfei.simplebook.R;
import com.wangfei.simplebook.adapters.PicAdapter;
import com.wangfei.simplebook.domain.PicBean;
import com.wangfei.simplebook.utils.NhHttpUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements Callback<PicBean>, View.OnClickListener {

    private List<PicBean.ItemsEntity> list;
    private List<PicBean.ItemsEntity> items;
    private PicAdapter adapter;
    public PictureFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_picture, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        Context context = getContext();
        list = new ArrayList<>();
        adapter = new PicAdapter(context, list);
        adapter.setOnClickListener(this);
        String type ="image";
        recyclerView.setAdapter(adapter);
        Call<PicBean> itemsEntityCall = NhHttpUtils.getService().getPic(type, 1);
        itemsEntityCall.enqueue(this);
    }

    @Override
    public void onResponse(Response<PicBean> response) {
        items = response.body().getItems();
        adapter.MyAddAll(items);
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "网络问题", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        int tag = (int)v.getTag();
        int checkedId = v.getId();
        PicBean.ItemsEntity itemsEntity = items.get(tag);
        switch (checkedId){
            case R.id.support:
                boolean support = itemsEntity.isSupport();
                itemsEntity.setSupport(!support);
                itemsEntity.setUnsupport(false);
                int up = itemsEntity.getVotes().getUp();
                itemsEntity.getVotes().setUp(up + 1);
                break;
            case R.id.unsupport:
                boolean unsupport = itemsEntity.isUnsupport();
                itemsEntity.setUnsupport(!unsupport);
                itemsEntity.setSupport(false);
                int down = itemsEntity.getVotes().getDown();
                itemsEntity.getVotes().setDown(down-1);
                break;
            case R.id.comment:
                Intent intent = new Intent(getContext(), CommentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",tag);
                bundle.putSerializable("item",itemsEntity);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
                break;
            case R.id.shary:
                break;
        }
        adapter.notifyItemChanged(tag);
    }
}
