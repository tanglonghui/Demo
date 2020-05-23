package com.example.administrator.demo.view.viewLocation;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

public class ViewLocationActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView tv1;
    private TextView tv2;
    private int sx;
    private int sy;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        sp = this.getSharedPreferences("config", Context.MODE_PRIVATE);
        tv1 = (TextView) this.findViewById(R.id.tv_1);
        tv2 = (TextView) this.findViewById(R.id.tv_2);
        sp = this.getSharedPreferences("config", Context.MODE_PRIVATE);
        tv1.setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            // 如果手指放在imageView上拖动
            case R.id.tv_1:
                // event.getRawX(); //获取手指第一次接触屏幕在x方向的坐标
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
                        sx = (int) event.getRawX();
                        sy = (int) event.getRawY();
//                        tv1.setImageResource(R.drawable.t);
                        break;
                    case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件
                        int x = (int) event.getRawX();
                        int y = (int) event.getRawY();
                        // 获取手指移动的距离
                        int dx = x - sx;
                        int dy = y - sy;
                        // 得到imageView最开始的各顶点的坐标
                        int l = tv1.getLeft();
                        int r = tv1.getRight();
                        int t = tv1.getTop();
                        int b = tv1.getBottom();
                        // 更改imageView在窗体的位置
                        tv1.layout(l + dx, t + dy, r + dx, b + dy);
                        // 获取移动后的位置
                        sx = (int) event.getRawX();
                        sy = (int) event.getRawY();

                        //获得坐标测试
                        Point p = new Point();
                        p.offset(-100,-100);

                        Rect globalVisibleRect =new  Rect();
                        if (tv1.getGlobalVisibleRect(globalVisibleRect)) {
                            T.ss("在屏幕中");
                        }else {
                            T.ss("不在屏幕中");
                        }

                        Rect localVisibleRect = new  Rect();

                        tv1.getLocalVisibleRect(localVisibleRect);

                        Log.e("ViewLocationActivity", "test globalVisibleRect::" + globalVisibleRect);

                        Log.e("ViewLocationActivity", "test localVisibleRect::" + localVisibleRect);
//                        //判断是否离开指定view
//                        Point p = new Point();
//
//                        int[] location = new int[2];
//                        tv2.getLocationInWindow(location);
////                myHeadView.getLocationOnScreen(location);
//                        if (tv1.getGlobalVisibleRect(location)) {
//// 控件在屏幕可见区域
//                            T.ss("修改状态栏1");
//                        } else {
//// 控件已不在屏幕可见区域（已滑出屏幕）
//                            T.ss("修改状态栏");
//                        }
                        break;
                    case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件
                        // 记录最后图片在窗体的位置
                        int lasty = tv1.getTop();
                        int lastx = tv1.getLeft();
//                        tv1.setImageResource(R.drawable.next);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("lasty", lasty);
                        editor.putInt("lastx", lastx);
                        editor.commit();
                        break;
                }
                break;
        }
        return true;// 不会中断触摸事件的返回
    }

}
