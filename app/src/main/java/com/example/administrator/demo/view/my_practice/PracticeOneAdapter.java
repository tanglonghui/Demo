package com.example.administrator.demo.view.my_practice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2020/6/23.
 */

public class PracticeOneAdapter extends RecyclerView.Adapter<PracticeOneAdapter.ViewHolder> {

    private List<String> data;

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_practice_one, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(data.get(position).toString());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);

        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
