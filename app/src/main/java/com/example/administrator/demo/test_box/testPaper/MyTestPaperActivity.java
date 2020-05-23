package com.example.administrator.demo.test_box.testPaper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.test_box.testPaper.questions.ShortAnswerQuestionFragment;
import com.example.librarytest.utils.T;

public class MyTestPaperActivity extends AppCompatActivity {
    private FrameLayout flFragment;
    private LinearLayout llBar;
    private TextView tvProgress;
    private TextView tvNext;
    private String type = "1";
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_paper);
        flFragment = (FrameLayout) findViewById(R.id.fl_fragment);
        llBar = (LinearLayout) findViewById(R.id.ll_bar);
        tvProgress = (TextView) findViewById(R.id.tv_progress);
        tvNext = (TextView) findViewById(R.id.tv_next);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type) {
                    case "1":
                        fragment= getSupportFragmentManager().findFragmentById(R.id.fl_fragment);
                        if (fragment instanceof ShortAnswerQuestionFragment){
                            ShortAnswerQuestionFragment fragment1= (ShortAnswerQuestionFragment) fragment;
                            T.ss( fragment1.getAnswer());
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, new ShortAnswerQuestionFragment()).commit();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                }
            }
        });
    }
}
