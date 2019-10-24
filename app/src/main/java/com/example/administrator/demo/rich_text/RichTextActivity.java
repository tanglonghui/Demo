package com.example.administrator.demo.rich_text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
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
    @BindView(R.id.tv_test3)
    TextView tvTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text);
        ButterKnife.bind(this);
        testOne();
        testTwo();
    }

    /**
     * @describe 通过 html 实现
     */
    void testOne() {
        String str = "<html><head></head><body>哈哈哈 <a href=\"http://m.baidu.com/u/10001\" class=\"referer\">@天天</a>我赞你了哦</body></html>";
        // Spanned : 块 (类似<span></span>和<div></div>),将字符串str解析成一个一个的块
        Spanned spanned = Html.fromHtml(str);
        tvTest1.setText(spanned);

        String content = getBlueText("盖聂, 卫庄, 张良, 天明") + "等 <font color=\"#FF0000\">88人</font>觉得很赞";
        tvTest2.setText(Html.fromHtml(content));
    }

    /**
     * 为字符串加蓝色
     *
     * @param string
     * @return
     */
    private String getBlueText(String string) {
        return String.format("<font color=\"#0000FF\">%s</font>", string); // string 会替换 %s
    }

    /**
     * @describe 通过SpannableString 实现
     */
    void testTwo() {
        SpannableString span3 = new SpannableString("我如果爱你我如果我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你爱你我如果爱你我如果爱你我如果爱你我如果爱你我如果爱你");
        ImageSpan image = new ImageSpan(this, R.mipmap.prompt, DynamicDrawableSpan.ALIGN_BOTTOM);
//        span3.setSpan(image, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(image, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tvTest3.setText(span3);
    }


}
