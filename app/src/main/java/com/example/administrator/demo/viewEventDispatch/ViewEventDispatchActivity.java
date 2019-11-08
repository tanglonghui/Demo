package com.example.administrator.demo.viewEventDispatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author TangLongHui
 * @data created on 2019/9/2
 * @describe 学习事件分发
 */

public class ViewEventDispatchActivity extends AppCompatActivity {
    @BindView(R.id.view)
    ViewEventDispatchTextView view;
    @BindView(R.id.view_group)
    ViewEventDispatchLinearLayout viewGroup;
    private String TAG = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_dispatch);
        ButterKnife.bind(this);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                T.ss("view 点击事件");
//            }
//        });
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.ss("viewGroup 点击事件");
            }
        });
    }

    public void doOnclick() {
        T.ss("点击事件");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, " dispatchTouchEvent--");
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, " ACTION_CANCEL--");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, " onTouchEvent--");
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return super.onTouchEvent(ev);
    }


    private void Log(String s) {
        Log.e(TAG, s);
    }

}
