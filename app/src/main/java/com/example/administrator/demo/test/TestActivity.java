package com.example.administrator.demo.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.tv_1)
    TextView tv1;
    Boolean aBoolean = false;
    @BindView(R.id.tv_2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        cbCheck.setChecked(aBoolean);
        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                T.ss("触发了" + isChecked + "aBoolean" + aBoolean);
//                cbCheck.setChecked(isChecked);
            }
        });
    }

    @OnClick({R.id.tv_1, R.id.tv_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                aBoolean = false;
                cbCheck.setChecked(aBoolean);
                break;
            case R.id.tv_2:
                Test2Activity.lunch(TestActivity.this,new TestInfo());
//                ArrayList list=new ArrayList();
//                list.add(new TestInfo());
//                list.add(new TestInfo());
//                Test2Activity.lunch2(TestActivity.this,list);
//                Test2Activity.lunch(TestActivity.this);
                break;
        }
    }
}
