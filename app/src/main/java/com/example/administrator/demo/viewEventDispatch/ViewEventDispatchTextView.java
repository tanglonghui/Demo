package com.example.administrator.demo.viewEventDispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * @author TangLongHui
 * @data created on 2019/9/2.
 * @describe   学习事件分发
 */
public class ViewEventDispatchTextView extends android.support.v7.widget.AppCompatTextView {
    private String TAG = "VEDispatchTextView";

    public ViewEventDispatchTextView(Context context) {
        super(context);
    }

    public ViewEventDispatchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewEventDispatchTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(this.getClass().getSimpleName(), " dispatchTouchEvent--" );
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
                Log.e(this.getClass().getSimpleName(), " onTouchEvent--" );
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
