package com.example.administrator.demo.test_box.model;

/**
 * Created by Administrator on 2019/5/5.
 */

public class EasyModel {
    private String text;
    private Class clazz;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public EasyModel(String text, Class clazz) {
        this.text = text;
        this.clazz = clazz;
    }
}
