package com.example.administrator.demo.android_base.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferencesActivity extends AppCompatActivity {

    @BindView(R.id.tv_test1)
    TextView tvTest1;
    @BindView(R.id.tv_test2)
    TextView tvTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_test1, R.id.tv_test2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test1:
                SharedPreferences sharedPreferences = this.getSharedPreferences("config", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", "晓");
                Log.e(this.getClass().getSimpleName(), "id: name, putString: 晓");
                editor.commit();
//                清除
//                editor.clear();
//                editor.commit();
                break;
            case R.id.tv_test2:
                SharedPreferences sharedPreferences2 = this.getSharedPreferences("config", Context.MODE_PRIVATE);
                String name = sharedPreferences2.getString("name", "");
                Log.e(this.getClass().getSimpleName(), "id: name, getString: " + name);
                break;
        }
    }
}
