package com.example.administrator.demo.string;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StringTestActivity extends AppCompatActivity {
    public static String TAG = "StringTest";
    @BindView(R.id.tv_easy)
    TextView tvEasy;
    @BindView(R.id.tv_easy2)
    TextView tvEasy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_easy, R.id.tv_easy2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_easy:
                String imgUrl = "http://127.0.0.1:8080/cms/ReadAddress/1479805098158.jpg";
                T.ss("" + imgUrl.lastIndexOf("."));
                String image = imgUrl.substring(0,imgUrl.lastIndexOf("."));
                Log.e(TAG, image);
                break;
            case R.id.tv_easy2:
                break;
        }
    }
}
