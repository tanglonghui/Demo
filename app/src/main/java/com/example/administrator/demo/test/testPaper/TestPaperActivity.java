package com.example.administrator.demo.test.testPaper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

public class TestPaperActivity extends AppCompatActivity {
    private TextView tvNext;
    private TextView tvAdd;
    private FrameLayout flFragment;
    private boolean aBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paper);

        tvNext = (TextView) findViewById(R.id.tv_next);
        tvAdd = (TextView) findViewById(R.id.tv_add);
        flFragment = (FrameLayout) findViewById(R.id.fl_fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, TestPaper1Fragment.newInstance("1", "1")).commit();

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, TestPaper1Fragment.newInstance("1", "1")).commit();
                    aBoolean = false;
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, BlankFragment.newInstance("2", "2")).commit();
                    aBoolean = true;
                }
            }
        });
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment fragment= getSupportFragmentManager().findFragmentById(R.id.fl_fragment);
                if (fragment instanceof BlankFragment){
                    BlankFragment fragment1= (BlankFragment) fragment;
                   T.ss( fragment1.getArgParam1());
                }
            }
        });
    }
}
