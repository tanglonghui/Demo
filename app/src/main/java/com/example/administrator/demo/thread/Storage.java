package com.example.administrator.demo.thread;

import java.util.ArrayList;

/**
 * @author TangLongHui
 * @data created on 2019/9/16.
 * @describe TODO
 */
public class Storage {
    public ArrayList<Integer> list;

    public Storage() {
        list = new ArrayList<>();
    }

    //锁住的是调用这个方法的实例对象
    synchronized Integer read(int index) {
        if (list.size() <= index) {
            try {
                this.wait();//当前线程进入阻塞状态，释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.get(index);

    }

    synchronized void write(Integer integer) {
        list.add(integer);
        this.notify();//唤醒该锁上的一个等待（对象的）线程并使该线程开始执行
    }
}
