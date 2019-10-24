package com.example.administrator.demo.rich_text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author TangLongHui
 * @data created on 2019/10/24
 * @describe TODO: 富文本练习 demo
 */
public class RichTextActivity extends AppCompatActivity {

    @BindView(R.id.tv_test1)
    TextView tvTest1;
    @BindView(R.id.tv_test2)
    TextView tvTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text);
        ButterKnife.bind(this);
    }
}
