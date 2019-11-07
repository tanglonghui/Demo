package com.example.administrator.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.model.EasyModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author TangLongHui
 * @data created on 2019/5/5
 * @describe   一个简单的适配器
 */

public class EasyAdapter extends RecyclerView.Adapter<EasyAdapter.ViewHolder> {

    private List<EasyModel> mList;
    private itemOnClickListener listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_easy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final EasyModel model = mList.get(position);
        holder.tvText.setText(model.getText());
        holder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(model.getClazz());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setMList(List<EasyModel> mList) {
        this.mList = mList;
    }

    public interface itemOnClickListener {
        void onClick(Class clazz);
    }

    public void setListener(itemOnClickListener listener) {
        this.listener = listener;
    }
}
