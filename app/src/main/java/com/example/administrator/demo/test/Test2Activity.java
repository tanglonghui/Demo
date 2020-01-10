package com.example.administrator.demo.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.demo.R;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        getTestInfo();
        getListInfo();
        getListArray();
        getListMap();
    }

    void getTestInfo() {
        TestInfo testInfo = (TestInfo) getIntent().getSerializableExtra("testInfo");
    }
    void getListInfo() {
        List<TestInfo> list = (List) getIntent().getSerializableExtra("list");
    }
    void getListArray() {
        TestInfo[] array = (TestInfo[]) getIntent().getSerializableExtra("array");
    }
    void getListMap() {
        Map<String, String> message = (Map<String, String>) getIntent().getSerializableExtra("message");
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
    public static void lunch2(Activity activity, List<TestInfo> list) {
        Intent intent = new Intent(activity, Test2Activity.class);
        TestInfo[] array=new TestInfo[list.size()];
        list.toArray(array);
        intent.putExtra("array", array);
        activity.startActivity(intent);
    }

    public static void lunch(Activity activity) {
        Intent intent = new Intent(activity, Test2Activity.class);
        Map<String, String> message = new HashMap<String, String>();
        message.put("name", "name");
        message.put("time", "time");
        intent.putExtra("message", (Serializable) message);
        activity.startActivity(intent);
    }
}
