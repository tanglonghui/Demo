package com.example.administrator.demo.viewEventDispatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

/**
 * @author TangLongHui
 * @data created on 2019/9/2
 * @describe   学习事件分发
 */

public class ViewEventDispatchActivity extends AppCompatActivity {
    private String TAG = "VEDispatchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_dispatch);
    }

    public void doOnclick() {
        T.ss("点击事件");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(this.getClass().getSimpleName(), " dispatchTouchEvent--");
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(this.getClass().getSimpleName(), " onTouchEvent--");
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
