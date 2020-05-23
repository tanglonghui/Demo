package com.example.administrator.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.demo.bug_box.AndroidBug5497.AndroidBug5479Activity;
import com.example.administrator.demo.view.AddViewByCodeActivity;
import com.example.administrator.demo.view.PopupWindow.PopupWindowActivity;
import com.example.administrator.demo.view.PopupWindow.popupwindowFromGitHup.activity.PopuWindowDemoActivity;
import com.example.administrator.demo.android_base.SharedPreferences.SharedPreferencesActivity;
import com.example.administrator.demo.android_base.adapter.EasyAdapter;
import com.example.administrator.demo.java_base.date.DateActivity;
import com.example.administrator.demo.android_base.dialog.DialogActivity;
import com.example.administrator.demo.view.drawable.DrawableActivity;
import com.example.administrator.demo.open_source_framework.echarts.EchartsActivity;
import com.example.administrator.demo.java_base.enum_demo.EnumActivity;
import com.example.administrator.demo.android_base.io.IOActivity;
import com.example.administrator.demo.java_base.json.JsonActivity;
import com.example.administrator.demo.test_box.model.EasyModel;
import com.example.administrator.demo.android_base.recycleview.CitySelect.CityPickerActivity;
import com.example.administrator.demo.android_base.recycleview.OpenRecordActivity;
import com.example.administrator.demo.android_base.recycleview.ViewRecycle.ViewActivity;
import com.example.administrator.demo.android_base.recycleview.xrecycleview_test.XrecycleviewTestActivity;
import com.example.administrator.demo.java_base.regular.RegularActivity;
import com.example.administrator.demo.ui.res.SelectorActivity;
import com.example.administrator.demo.ui.res.ShapeActivity;
import com.example.administrator.demo.open_source_framework.retrofit.RetrofitActivity;
import com.example.administrator.demo.android_base.rich_text.RichTextActivity;
import com.example.administrator.demo.open_source_framework.rxjava.RxJavaActivity;
import com.example.administrator.demo.java_base.string.StringTestActivity;
import com.example.administrator.demo.test_box.test.TestActivity;
import com.example.administrator.demo.test_box.test.testPaper.TestPaperActivity;
import com.example.administrator.demo.test_box.testPaper.MyTestPaperActivity;
import com.example.administrator.demo.java_base.thread.ThreadActivity;
import com.example.administrator.demo.android_base.video.AndroidVideoActivity;
import com.example.administrator.demo.view.viewDraw.ViewDrawActivity;
import com.example.administrator.demo.view.viewEventDispatch.ViewEventDispatchActivity;
import com.example.administrator.demo.view.viewLocation.ViewLocationActivity;
import com.example.administrator.demo.android_base.web.WebActivity;
import com.example.administrator.kotlin.HelloKotlinActivity;
import com.example.librarytest.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_Test)
    TextView tvTest;
    @BindView(R.id.rv_recycler)
    RecyclerView rvRecycler;
    EasyAdapter easyAdapter;
    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (mList == null) {
            mList = new ArrayList();
        } else {
            mList.clear();
        }
        initMList();
        easyAdapter = new EasyAdapter();
        easyAdapter.setMList(mList);
        easyAdapter.setListener(new EasyAdapter.itemOnClickListener() {
            @Override
            public void onClick(Class clazz) {
                Intent intent = new Intent(MainActivity.this, clazz);
                startActivity(intent);
            }
        });
        rvRecycler.setLayoutManager(new LinearLayoutManager(this));
        rvRecycler.setAdapter(easyAdapter);

    }

    void initMList() {
        mList.add(new EasyModel("RetrofitDemo", RetrofitActivity.class));
        mList.add(new EasyModel("webDemo", WebActivity.class));
        mList.add(new EasyModel("Selector", SelectorActivity.class));
        mList.add(new EasyModel("Shape", ShapeActivity.class));
        mList.add(new EasyModel("RxJava2", RxJavaActivity.class));
        mList.add(new EasyModel("Date", DateActivity.class));
        mList.add(new EasyModel("AndroidBug5479及键盘顶飞问题", AndroidBug5479Activity.class));
        mList.add(new EasyModel("单个list多中item view", OpenRecordActivity.class));
        mList.add(new EasyModel("dialog", DialogActivity.class));
        mList.add(new EasyModel("PopuWindowDemoActivity", PopuWindowDemoActivity.class));
        mList.add(new EasyModel("PopupWindowActivity", PopupWindowActivity.class));
        mList.add(new EasyModel("ViewActivity", ViewActivity.class));
        mList.add(new EasyModel("城市选择", CityPickerActivity.class));
        mList.add(new EasyModel("json", JsonActivity.class));
        mList.add(new EasyModel("Echarts", EchartsActivity.class));
        mList.add(new EasyModel(" Thread 线程", ThreadActivity.class));
        mList.add(new EasyModel(" Drawable 常见控件属性设置", DrawableActivity.class));
        mList.add(new EasyModel("安卓事件分发机制学习Demo", ViewEventDispatchActivity.class));
        mList.add(new EasyModel("安卓事件自定义View学习Demo", ViewDrawActivity.class));
        mList.add(new EasyModel("SharedPreferencesDemo", SharedPreferencesActivity.class));
        mList.add(new EasyModel("文件操作 IO 流", IOActivity.class));
        mList.add(new EasyModel("view 的移动与定位", ViewLocationActivity.class));
        mList.add(new EasyModel("关于试卷开发的想法,草稿", TestPaperActivity.class));
        mList.add(new EasyModel("关于试卷开发的想法,具体一点", MyTestPaperActivity.class));
        mList.add(new EasyModel("kotlin hello", HelloKotlinActivity.class));
        mList.add(new EasyModel("富文本，图文混排", RichTextActivity.class));
        mList.add(new EasyModel("视频播放合集", AndroidVideoActivity.class));
        mList.add(new EasyModel("StringTest", StringTestActivity.class));
        mList.add(new EasyModel("正则简单学习了解", RegularActivity.class));
        mList.add(new EasyModel("Test", TestActivity.class));
        mList.add(new EasyModel("Enum 学习", EnumActivity.class));
        mList.add(new EasyModel("XrecycleviewTest", XrecycleviewTestActivity.class));
        mList.add(new EasyModel("使用代码添加 view", AddViewByCodeActivity.class));

    }

    @OnClick(R.id.tv_Test)
    public void onViewClicked() {
        T.ss("测试");
    }
}
