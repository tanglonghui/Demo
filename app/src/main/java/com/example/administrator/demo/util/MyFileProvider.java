package com.example.administrator.demo.util;

import android.support.v4.content.FileProvider;

/**
 * @author TangLongHui
 * @data created on 2019/1/23.
 * @describe TODO  安卓 7.0 继承FileProvider，防止与takephoto共用FileProvider冲突
 */

public class MyFileProvider extends FileProvider {
    public MyFileProvider() {
        super();
    }
}
