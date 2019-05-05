package com.example.librarytest.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.librarytest.LibrarytestManager;


/**
 * Created by yang on 2016/7/25 0025.
 */
public class T {
    private static Context mContext;
    private static Toast mToast;

    private T() {
        mContext = LibrarytestManager.getContext();
    }

    public static void ss(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(LibrarytestManager.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void sl(String msg) {
        if (mToast == null) {
            Toast.makeText(LibrarytestManager.getContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
}
