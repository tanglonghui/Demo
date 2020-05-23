package com.example.administrator.demo.view.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawableActivity extends AppCompatActivity {

    @BindView(R.id.tv_test1)
    TextView tvTest1;
    @BindView(R.id.tv_test2)
    TextView tvTest2;
    @BindView(R.id.tv_test3)
    TextView tvTest3;
    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_test4)
    TextView tvTest4;
    @BindView(R.id.tv_test5)
    TextView tvTest5;
    @BindView(R.id.tv_test6)
    TextView tvTest6;
    @BindView(R.id.tv_test7)
    TextView tvTest7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_test1, R.id.tv_test2, R.id.tv_test3, R.id.tv_test4, R.id.tv_test5, R.id.tv_test6, R.id.tv_test7, R.id.iv_img, R.id.tv_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test1:
                //方式一
                ivImg.setImageResource(R.drawable.img1);
                break;
            case R.id.tv_test2:
                //方式二 过时不推荐
                ivImg.setImageDrawable(getResources().getDrawable(R.drawable.img2));
                break;
            case R.id.tv_test3:
                //方式三 不兼容 大于21 版本才能使用 否则闪退
                if (Build.VERSION.SDK_INT >= 21) {
                    ivImg.setImageDrawable(getDrawable(R.drawable.img3));
                } else {
                    ivImg.setImageDrawable(getResources().getDrawable(R.drawable.img3));
                }
                break;
            case R.id.tv_test4:
                //方式四 兼容 推荐
                ivImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.img4));
                break;
            case R.id.tv_test5:
                // 代码设置 drawableTop 资源 未设置宽高 不显示
                tvText.setCompoundDrawables(null, ContextCompat.getDrawable(this, R.drawable.img1), null, null);
                break;
            case R.id.tv_test6:
                // 代码设置 drawableTop 资源
                Drawable drawable=ContextCompat.getDrawable(this, R.drawable.img2);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());
                tvText.setCompoundDrawables(null,drawable , null, null);
                break;
            case R.id.tv_test7:
                // 代码设置 drawableTop 资源
                Drawable drawable1=ContextCompat.getDrawable(this, R.drawable.img2);
                drawable1.setBounds(0, 0, 100,100);
                tvText.setCompoundDrawables(null,drawable1 , null, null);
                break;
            case R.id.iv_img:
                break;
            case R.id.tv_text:
                break;
        }
    }
}
