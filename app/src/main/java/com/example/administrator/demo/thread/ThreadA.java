package com.example.administrator.demo.thread;

import android.util.Log;

/**
 * @author TangLongHui
 * @data created on 2019/8/9.
 * @describe TODO
 */
public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Log.e("ThrandA "+getName()+" 打印：", "" + i);
        }
    }
}
