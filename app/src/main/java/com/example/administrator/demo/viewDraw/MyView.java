package com.example.administrator.demo.viewDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Administrator on 2020/1/8.
 */

public class MyView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyView(Context context) {
        super(context);
        initPaint();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    /**
     * @describe 初始化 画笔
     */
    private void initPaint() {
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(4.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * @describe 一般在此方法写自定义的代码（绘制逻辑）
     * @param canvas 画布对象
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获得 layout 中 该 view 设置的边距等属性，这里是左边距，其他同理。
        int paddingLeft = getPaddingLeft();
        //获得画布的宽高
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        //画矩形
        canvas.drawRect(0 + paddingLeft, 0, width, height, paint);
    }
}
