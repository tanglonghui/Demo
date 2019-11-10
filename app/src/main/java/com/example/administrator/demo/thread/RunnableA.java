package com.example.administrator.demo.thread;

import android.util.Log;

/**
 * @author TangLongHui
 * @data created on 2019/9/16.
 * @describe
 */
public class RunnableA implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Log.e("当前线程：" + Thread.currentThread().getName() + " 打印：", "" + i);
        }
    }
}
