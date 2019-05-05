package com.example.administrator.demo;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;

import com.example.librarytest.LibrarytestManager;

/**
 * Created by Administrator on 2019/4/22.
 */

public class app extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LibrarytestManager.init(this);
    }
}
