package com.example.administrator.demo.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.tv_1)
    TextView tv1;
    Boolean aBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        cbCheck.setChecked(aBoolean);
        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                T.ss("触发了" + isChecked+"aBoolean"+aBoolean);
//                cbCheck.setChecked(isChecked);
            }
        });
    }

    @OnClick(R.id.tv_1)
    public void onViewClicked() {
        aBoolean=false;
        cbCheck.setChecked(aBoolean);
    }
}
