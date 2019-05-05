package com.example.librarytest;

import android.content.Context;

/**
 * Created by Administrator on 2019/4/22.
 */

public  class LibrarytestManager {
    private   static Context context;

    public static Context getContext() {
        return context;
    }

    public static void init(Context context) {
        LibrarytestManager.context = context;
    }


}
