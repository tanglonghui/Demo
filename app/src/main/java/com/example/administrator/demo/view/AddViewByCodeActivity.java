package com.example.administrator.demo.view;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

/**
 * @author TangLongHui
 * @data created on 2020/5/23
 * @describe 动手试下代码添加 view
 */
public class AddViewByCodeActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private FrameLayout flContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view_by_code);

        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        flContent = (FrameLayout) findViewById(R.id.fl_content);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试一
                LinearLayout linearLayout = new LinearLayout(AddViewByCodeActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setBackgroundColor(Color.RED);
//                linearLayout.setId(View.generateViewId()); // 17 以上
                linearLayout.setId(R.id.my_view);
                flContent.addView(linearLayout);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试二
                LinearLayout linearLayout = null;
                for (int i = 0; i < flContent.getChildCount(); i++) {
                    if (flContent.getChildAt(i) instanceof LinearLayout) {
                        linearLayout = (LinearLayout) flContent.getChildAt(i);
                        break;
                    }
                }
                if (null == linearLayout) {
                    T.ss("未找到对应容器，请先做测试一");
                } else {

                    TextView textView = new TextView(AddViewByCodeActivity.this);
                    textView.setText("my test1 ");
                    linearLayout.addView(textView);
                }

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 测试一
                flContent.getLayoutParams();
                flContent.getHeight();
                flContent.getWidth();
                //context的方法，获取windowManager
                WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                //获取屏幕对象
                Display defaultDisplay = windowManager.getDefaultDisplay();
                //获取屏幕的宽、高，单位是像素
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
//获取资源对象
                Resources resources = getResources();
                //获取屏幕数据
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                //获取屏幕宽高，单位是像素
                int widthPixels = displayMetrics.widthPixels;
                int heightPixels = displayMetrics.heightPixels;
                //获取屏幕密度倍数
                float density = displayMetrics.density;

                View view = new View(AddViewByCodeActivity.this);
                ViewGroup.LayoutParams params =new ViewGroup.LayoutParams(100,200);
                view.setLayoutParams(params);
                view.setBackgroundColor(Color.RED);
                flContent.addView(view);
            }
        });
    }
}
