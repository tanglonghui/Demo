package com.example.administrator.demo.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2020/1/9.
 */

public class TestInfo implements Serializable{
    private String name;
    private List<MyBean> list;

    public TestInfo() {
        int j=new Random().nextInt(4);
        name="tName"+j;
        list = new ArrayList<>();
        for (int i=0;i<=j;i++){
            list.add(new MyBean());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyBean> getList() {
        return list;
    }

    public void setList(List<MyBean> list) {
        this.list = list;
    }

    public class MyBean implements Serializable{
        private String name;
        private String job;

        public MyBean() {
            name="name"+new Random().nextInt(10);
            job="job"+new Random().nextInt(10);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }
    }
}
