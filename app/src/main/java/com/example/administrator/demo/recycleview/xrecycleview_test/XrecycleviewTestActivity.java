package com.example.administrator.demo.recycleview.xrecycleview_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XrecycleviewTestActivity extends AppCompatActivity {
    XrecycleviewTestAdapter adapter;
    @BindView(R.id.x_recycler)
    XRecyclerView xRecycler;

    private List<String> list;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecycleview_test);
        ButterKnife.bind(this);
        adapter = new XrecycleviewTestAdapter();
        if (list != null) {
            list.clear();
        } else {
            list = new ArrayList<>();
            getData(30);
        }
        adapter.setmList(list);
        xRecycler.setAdapter(adapter);
        xRecycler.setLayoutManager(new LinearLayoutManager(XrecycleviewTestActivity.this));
        xRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 0;
                getData(30);
            }

            @Override
            public void onLoadMore() {
                page++;
                getData(30);
            }
        });
    }

    private void getData(int rows) {
        if (page < 5) {
            for (int i = 0; i < rows; i++) {
                list.add("" + i);
            }
            adapter.notifyDataSetChanged();
            xRecycler.reset();
        } else {
            xRecycler.setNoMore(true);
        }
    }

}
