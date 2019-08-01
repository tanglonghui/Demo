package com.example.administrator.demo.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author TangLongHui
 * @data created on 2019/8/1
 * @describe TODO ~~
 */

public class ThreadActivity extends AppCompatActivity {

    @BindView(R.id.tv_easy)
    TextView tvEasy;
    @BindView(R.id.tv_easy2)
    TextView tvEasy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_easy, R.id.tv_easy2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_easy:
                ExecutorService executorService = Executors.newFixedThreadPool(4);
                break;
            case R.id.tv_easy2:
                break;
        }
    }
}
