package com.example.administrator.demo.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.demo.R;

import java.io.Serializable;
import java.util.List;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        getTestInfo();
        getListInfo();
    }

    void getTestInfo() {
        TestInfo testInfo = (TestInfo) getIntent().getSerializableExtra("testInfo");
    }
    void getListInfo() {
        List<TestInfo> list = (List) getIntent().getSerializableExtra("list");
    }


    public static void lunch(Activity activity, TestInfo testInfo) {
        Intent intent = new Intent(activity, Test2Activity.class);
        intent.putExtra("testInfo", testInfo);
        activity.startActivity(intent);
    }
    public static void lunch(Activity activity, List<TestInfo> list) {
        Intent intent = new Intent(activity, Test2Activity.class);
        intent.putExtra("list", (Serializable) list);
        activity.startActivity(intent);
    }
}
