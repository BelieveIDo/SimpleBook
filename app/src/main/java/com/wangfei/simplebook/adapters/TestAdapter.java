package com.wangfei.simplebook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangfei.simplebook.R;

import java.util.List;

/**
 * Created by Administrator on 2016/1/11.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TextViewHolder>{

    private Context context;
    private List<String> list;

    public TestAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
