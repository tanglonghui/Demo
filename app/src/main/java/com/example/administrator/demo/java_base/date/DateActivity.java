package com.example.administrator.demo.java_base.date;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DateActivity extends AppCompatActivity {


    @BindView(R.id.tv_date_to_string)
    TextView tvDateToString;
    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_date_to_string, R.id.tv_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_date_to_string:
                Log.e("DateActivity", "-------------------演示结果---------------------------");
                Date date = new Date();
                Log.e("1", date.toString());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatResult1 = simpleDateFormat.format(date);
                Log.e("2", formatResult1);
                String myDateStr = "2019-4-21";
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String formatResult2 = "";
                try {
                    Date dateResult2 = simpleDateFormat1.parse(myDateStr);
                    Log.e("3", dateResult2.toString());
                    formatResult2 = simpleDateFormat.format(dateResult2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Log.e("4", formatResult2);
                Log.e("DateActivity", "------------------------------------------------------");
                break;
            case R.id.tv_test:
                String myDateStr1 = "2019-4-21";
                Log.e("DateActivity", "-------------------演示结果---------------------------");
                Log.e("1",myDateStr1);
                Log.e("2", DateUtil.dateTransform(myDateStr1,DateUtil.Format.ymdFormat1,DateUtil.Format.ymdFormat2));
                Log.e("DateActivity", "------------------------------------------------------");
                Log.e("DateActivity", "--------------------------测试2----------------------------");
                Log.e("2", DateUtil.stampTransform(""+System.currentTimeMillis(),DateUtil.Format.ymdFormat1));
                Log.e("DateActivity", "--------------------------测试3----------------------------");
                Log.e("DateActivity", "--------------------------测试4----------------------------");
                Log.e("2",""+DateUtil.getStamp("2019-4-21",DateUtil.Format.ymdFormat1));
                Log.e("2","date > 今天？"+(DateUtil.getStamp("2019-5-31",DateUtil.Format.ymdFormat1)>System.currentTimeMillis()));
                break;
        }
    }
}
