package com.example.administrator.demo.json;

import com.example.librarytest.utils.T;

/**
 * @author TangLongHui
 * @data created on 2019/6/26.
 * @describe TODO
 */
public class TestGenericBean<T> {
    private T t;

    public TestGenericBean(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
