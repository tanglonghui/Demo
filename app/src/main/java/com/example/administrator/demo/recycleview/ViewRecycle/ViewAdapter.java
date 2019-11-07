package com.example.administrator.demo.recycleview.ViewRecycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.demo.R;

import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2019/5/8
 * @describe    考勤统计适配器
 */

public class ViewAdapter<T> extends RecyclerView.Adapter {
    private List<T> myList;
    private OnClickListener onClickListener;

    public void setMyList(List<T> myList) {
        this.myList = myList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }

    public interface OnClickListener {
        void OnClick(int position);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
