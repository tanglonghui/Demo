package com.example.administrator.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.administrator.demo.adapter.EasyAdapter;
import com.example.administrator.demo.model.EasyModel;
import com.example.administrator.demo.res.SelectorActivity;
import com.example.administrator.demo.res.ShapeActivity;
import com.example.administrator.demo.retrofit.RetrofitActivity;
import com.example.administrator.demo.web.WebActivity;
import com.example.librarytest.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_Test)
    TextView tvTest;
    @BindView(R.id.rv_recycler)
    RecyclerView rvRecycler;
    EasyAdapter easyAdapter;
    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (mList == null) {
            mList = new ArrayList();
        } else {
            mList.clear();
        }
        initMList();
        easyAdapter = new EasyAdapter();
        easyAdapter.setMList(mList);
        easyAdapter.setListener(new EasyAdapter.itemOnClickListener() {
            @Override
            public void onClick(Class clazz) {
                Intent intent = new Intent(MainActivity.this, clazz);
                startActivity(intent);
            }
        });
        rvRecycler.setLayoutManager(new LinearLayoutManager(this));
        rvRecycler.setAdapter(easyAdapter);

    }

    void initMList() {
        mList.add(new EasyModel("RetrofitDemo", RetrofitActivity.class));
        mList.add(new EasyModel("webDemo", WebActivity.class));
        mList.add(new EasyModel("Selector", SelectorActivity.class));
        mList.add(new EasyModel("Shape", ShapeActivity.class));
    }

    @OnClick(R.id.tv_Test)
    public void onViewClicked() {
        T.ss("测试");
    }
}
