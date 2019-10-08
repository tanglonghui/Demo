package com.example.administrator.demo.testPaper.questions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.demo.testPaper.bean.FlippedClassroomTestPaperInfo;
import com.example.administrator.demo.testPaper.bean.StudentQuestionBean;

/**
 * @author TangLongHui
 * @data created on 2019/10/8
 * @describe TODO 翻转课堂问题基类
 */
public abstract class BaseQuestionFragment extends Fragment {


    protected View mRootView = null;

    protected String trContentId; //问题id
    protected String type; //问题类型
    protected FlippedClassroomTestPaperInfo.ListEntity listEntity; //问题
    protected StudentQuestionBean bean;//问题具体内容
    protected String answer = ""; //答案

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = layoutId();
        Log.e("", "" + i);
        mRootView = inflater.inflate(layoutId(), container, false);
        initViews();
        init();
        initData();
        registerEvents();

        return mRootView;
    }

    //获取布局文件ID
    protected abstract int layoutId();

    //初始化视图
    protected abstract void initViews();

    protected abstract void init();

    protected abstract void initData();

    //登记监听事件
    protected abstract void registerEvents();

    //答案
    protected abstract String getAnswer();

    //题型
    protected abstract String getType();

    //当前题目id
    protected abstract String getTrContentId();

    /**
     * findViewId
     */

    protected <T extends View> T findView(int viewId) {
        return (T) mRootView.findViewById(viewId);
    }


}
