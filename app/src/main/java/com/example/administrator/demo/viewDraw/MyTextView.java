package com.example.administrator.demo.viewDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2019/12/31.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Paint paint = new Paint();

    /**
     * @describe 重写 父类构造器 并在此处执行初始化画笔的方法
     */
    public MyTextView(Context context) {
        super(context);
        initPaint();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * @describe 初始化 画笔
     */
    private void initPaint() {
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(4.5f);
    }

    /**
     * @describe 一般在此方法写自定义的代码（绘制逻辑）
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawLine(0, height / 2, width, height / 2, paint);
    }
}
