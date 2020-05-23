package com.example.administrator.demo.java_base.thread;

import android.util.Log;

/**
 * @author TangLongHui
 * @data created on 2019/8/9.
 * @describe
 */
public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Log.e("当前线程：" + Thread.currentThread() + " 参数：" + getName() + " 打印：", "" + i);
        }
    }
}
