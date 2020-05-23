package com.example.administrator.demo.java_base.regular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.util.log.MKLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author TangLongHui
 * @data created on 2019/11/18
 * @describe 正则学习
 */

public class RegularActivity extends AppCompatActivity {

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                String test1 = "123214124124";
                MKLog.d("" + test1.matches("1"));
                break;
            case R.id.tv_2:
                break;
            case R.id.tv_3:
                break;
        }
    }
}
