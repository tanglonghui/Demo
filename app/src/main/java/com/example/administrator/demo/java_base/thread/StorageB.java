package com.example.administrator.demo.java_base.thread;

import java.util.ArrayList;

/**
 * @author TangLongHui
 * @data created on 2019/9/16.
 * @describe
 */
public class StorageB {
    public ArrayList<Integer> list;
    public Object lock;

    public StorageB() {
        list = new ArrayList<>();
        lock = new Object();
    }

    Integer read(int index) {
        //锁住的是 lock 对象
        synchronized (lock) {
            if (list.size() <= index) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return list.get(index);
        }


    }

    synchronized void write(Integer integer) {
        synchronized (lock) {
            list.add(integer);
            lock.notify();
        }
    }
}
