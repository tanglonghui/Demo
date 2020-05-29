package com.example.administrator.demo.android_base.junit4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.demo.R;

/**
 * 怎么对UI进行单元测试？
 */
public class UITestActivity extends AppCompatActivity {
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);
        tv1 = (TextView) findViewById(R.id.tv_1);
    }
}
