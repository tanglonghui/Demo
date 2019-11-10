package com.example.administrator.demo.viewEventDispatch;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


/**
 * @author TangLongHui
 * @data created on 2019/9/2.
 * @describe 学习事件分发
 */
public class ViewEventDispatchLinearLayout extends LinearLayoutCompat {
    private String TAG = "ViewGroup";

    public ViewEventDispatchLinearLayout(Context context) {
        super(context);
    }

    public ViewEventDispatchLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewEventDispatchLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
                Log.e(TAG, " ACTION_CANCEL--");
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean result = super.onInterceptTouchEvent(ev);
        Log.e(TAG, " onInterceptTouchEvent--");
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_UP:
//                return true;
//            case MotionEvent.ACTION_DOWN:
//                return true;
////            case MotionEvent.ACTION_CANCEL:
////                return true;
//        }
        return super.onInterceptTouchEvent(ev);
    }

    private void Log(String s) {
        Log.e(TAG, s);
    }
}
