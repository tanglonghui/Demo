package com.example.administrator.demo.thread;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * @author TangLongHui
 * @data created on 2019/9/16.
 * @describe TODO
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
