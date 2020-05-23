package com.example.administrator.demo.java_base.json;

/**
 * @author TangLongHui
 * @data created on 2019/6/26.
 * @describe
 */
public class TestGenericBean<T> {
    private T t;

    public TestGenericBean(T t) {
        this.t = t;
    }
    public TestGenericBean() {
        this.t = (T) new TestBean();
    }


    public T getT() {
        return t;
    }
}
