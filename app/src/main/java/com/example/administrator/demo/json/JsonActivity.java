package com.example.administrator.demo.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.librarytest.utils.T;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JsonActivity extends AppCompatActivity {

    @BindView(R.id.tv_gson)
    TextView tvGson;
    String Tag1 = "Gson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_gson)
    public void onViewClicked() {
        //to json
        Gson gson = new Gson();
        String result = "";
        Log.e(Tag1, "-------------  to json  ------------------");

        //对象转 json
        Log.e(Tag1, gson.toJson(new TestGenericBean<TestBean>()));
      //  TestGenericBean<TestBean> testGenericBean = gson.fromJson(gson.toJson(new TestGenericBean<TestBean>()), TestGenericBean.class);
        TestGenericBean<TestBean> testGenericBean = gson.fromJson(gson.toJson(new TestGenericBean<TestBean>()),new TypeToken<TestGenericBean<TestBean>>() {
        }.getType());
        Log.e(Tag1, testGenericBean.getT().toString());
        Log.e(Tag1, "-------------  to json  ------------------");
//        TestBean bean=new TestBean();
//        Log.e(Tag1,gson.toJson(bean));
//        TestBean bean2=gson.fromJson(gson.toJson(bean),TestBean.class);
//        Log.e(Tag1,bean2.getName());
//        String mapStr="{\"name\":\"1\",\"age\":\"19\"}";
//        HashMap<String,String> map=new HashMap<>();
//        map.put("name","年龄");
//        map.put("age","性别");
//        String str=gson.toJson(map);
//        Log.e(Tag1,str);
//        HashMap map1=gson.fromJson(str,new TypeToken<HashMap<String,String>>() {
//        }.getType());
//        Log.e(Tag1,map1.get("name").toString());
        String[] strings={"1","1","2"};
        Log.e(Tag1,gson.toJson(strings));
        String[] strings1 =gson.fromJson(gson.toJson(strings),strings.getClass());
        Log.e(Tag1,gson.toJson(strings1[0]));

    }
}
