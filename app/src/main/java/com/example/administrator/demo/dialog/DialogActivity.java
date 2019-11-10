package com.example.administrator.demo.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(DialogActivity.this);
                // 设置提示框的标题
                builder.setTitle("提示").
                        setMessage("sssssss").// 设置要显示的信息
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {// 设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setCancelable(false); //强制更新 则 弹出框不消失
                alertDialog = builder.create();
                builder.show();
                break;
            case R.id.tv_2:
                android.support.v7.app.AlertDialog.Builder builder1 = new android.support.v7.app.AlertDialog.Builder(DialogActivity.this);
                // 设置提示框的标题
                builder1.setTitle("提示").
                        setMessage("sssssss").// 设置要显示的信息
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {// 设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //监听导航键返回
                builder1.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                        if (keyCode == KeyEvent.KEYCODE_BACK) {
//                         finish();
//                        }
                        return false;
                    }
                });
                builder1.setCancelable(true); //强制更新 则 弹出框不消失
                alertDialog = builder1.create();
                builder1.show();
                break;
            case R.id.tv_3:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                LayoutInflater inflateradd = LayoutInflater.from(this);
                View inflateclazzs = inflateradd.inflate(R.layout.dialog_test, null);
                TextView tv_target = inflateclazzs.findViewById(R.id.tv_target);
                TextView tv_bt_ok = inflateclazzs.findViewById(R.id.tv_bt_ok);

                tv_target.setText("asfdsgasdgadsgasdgasdg");


                final Dialog dialog = builder2.create();
                dialog.show();

                //监听
                tv_bt_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setContentView(inflateclazzs);//自定义布局应该在这里添加，要在dialog.show()的后面
                //给AlertDialog设置4个圆角
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.shape_1);
                break;
        }
    }
}
