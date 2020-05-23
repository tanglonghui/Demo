package com.example.administrator.demo.android_base.recycleview.xrecycleview_test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2019/12/3.
 */

public class XrecycleviewTestAdapter extends XRecyclerView.Adapter {
    private List<String> mList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_easy, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvText.setText(""+position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setmList(List<String> mList) {
        this.mList = mList;
    }
}
