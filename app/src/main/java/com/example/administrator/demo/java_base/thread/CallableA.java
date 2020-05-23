package com.example.administrator.demo.java_base.thread;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * @author TangLongHui
 * @data created on 2019/9/16.
 * @describe   与 Runnable 类似，区别是，这个接口带返回结果
 */
public class CallableA implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Log.e("当前线程：" + Thread.currentThread().getName() + " 打印：", "" + i);
        }
        return "结束时间:" + System.currentTimeMillis();
    }
}
