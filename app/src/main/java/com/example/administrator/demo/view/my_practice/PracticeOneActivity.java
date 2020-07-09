package com.example.administrator.demo.view.my_practice;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2020/6/23
 * @describe 一个涉及了安卓诸多UI知识的练习活动
 */
public class PracticeOneActivity extends AppCompatActivity {
    private Toolbar tlToolbar;
    private RecyclerView rvRecycler;
    PracticeOneAdapter adapter;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_one);
        setStatusBar();
        initView();
        registerListener();
    }

    /**
     * 初始化控件
     */
    void initView() {
        tlToolbar = (Toolbar) findViewById(R.id.tl_toolbar);
        rvRecycler = (RecyclerView) findViewById(R.id.rv_recycler);
        adapter = new PracticeOneAdapter();
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("" + i);
        }
        adapter.setData(data);
        rvRecycler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rvRecycler.setAdapter(adapter);
    }

    void registerListener() {
        //设置滑动监听
        rvRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
        //设置toolbar返回监听
        tlToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    /**
     * 设置沉浸式状态栏
     */
    private void setStatusBar() {
        // sdk 小于 19 不支持沉浸式状态栏
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        // 获得 window 对象
        Window window = getWindow();
        // 判断 sdk
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //sdk >= 21
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            window.getDecorView().setSystemUiVisibility(option);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            // 19 <= sdk < 21
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
