package com.example.administrator.demo.io;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IOActivity extends AppCompatActivity {

    @BindView(R.id.tv_easy)
    TextView tvEasy;
    @BindView(R.id.tv_easy2)
    TextView tvEasy2;
    @BindView(R.id.tv_easy3)
    TextView tvEasy3;
    @BindView(R.id.tv_easy4)
    TextView tvEasy4;
    @BindView(R.id.tv_easy5)
    TextView tvEasy5;
    @BindView(R.id.tv_easy6)
    TextView tvEasy6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_easy, R.id.tv_easy2, R.id.tv_easy3, R.id.tv_easy4, R.id.tv_easy5, R.id.tv_easy6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_easy:
                /**
                 * 通过Environment获取
                 */
//获得根目录/data内部存储路径
                System.out.println("Environment.getDataDirectory(): " + Environment.getDataDirectory().getPath());
//获得缓存目录/cache
                System.out.println("Environment.getDownloadCacheDirectory(): " + Environment.getDownloadCacheDirectory().getPath());
//获得SD卡目录/mnt/sdcard（获取的是手机外置sd卡的路径）
                System.out.println("Environment.getExternalStorageDirectory(): " + Environment.getExternalStorageDirectory().getPath());
//获得系统目录/system
                System.out.println("Environment.getRootDirectory(): " + Environment.getRootDirectory().getPath());

/**
 * 通过Context获取
 */
//用于获取APP的cache目录 /data/data/<application
                System.out.println("getCacheDir(): " + getCacheDir().getPath());
//用于获取APP的在SD卡中的cache目
                System.out.println("getExternalCacheDir(): " + getExternalCacheDir().getPath());
//用于获取APP的files目录 /data/data/<application
                System.out.println("getFilesDir(): " + getFilesDir());
//用于获取APPSDK中的obb目录
                System.out.println("getObbDir: " + getObbDir().getPath());
//用于获取APP的所在包目录
                System.out.println("getPackageName: " + getPackageName());
//来获得当前应用程序对应的 apk 文件的路径
                System.out.println("getPackageCodePath: " + getPackageCodePath());
//获取该程序的安装包路径
                System.out.println("getPackageResourcePath: " + getPackageResourcePath());
                Log.e("Tag", "--------------------------2--------------------------");
                //获取/data/data/package/files
                File file1 = getFilesDir();
                //获取/data/data/package/cache
                File file2 = getCacheDir();
                //获取/data/data/package/下的指定名称的文件夹File对象，如果该文件夹不存在则用指定名称创建一个新的文件夹。
                File file3 = getDir("com.example.administrator.downloaddemo", MODE_PRIVATE);
                //获取/data/data/package/files下所有的文件名
                String[] fileList = fileList();
                //删除/data/data/package/files/test文件
                String name = "test";
                deleteFile(name);
                //获取/storage/emulated/0/Android/data/pacakge/cache
                File file4 = getExternalCacheDir();
                //获取SD路径 /storage/emulated/0
                File file5 = Environment.getExternalStorageDirectory();
                //在SD路径创建文件夹
                String path = file5.getPath() + "/mkdirDemo";
                File mkdir = new File(path);
                mkdir.mkdir();

                if (mkdir.exists()) {
                    Log.e("Tag", "createNewFile: " + "redfinger.log");
                    //在path下创建文件
                    try {
                        File mfile = new File(path + "/redfinger.log");
                        mfile.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Log.e("Tag", "file: " + file1.toString());
                Log.e("Tag", "file2: " + file2.toString());
                Log.e("Tag", "file3: " + file3.toString());
                Log.e("Tag", "file4: " + file4.toString());
                Log.e("Tag", "file5: " + file5.toString());
                break;
            case R.id.tv_easy2:
                Queue linkedList=new LinkedList();
                linkedList.add(1);
                linkedList.poll();
                linkedList.add(2);
//                File file =new File();
                break;
            case R.id.tv_easy3:
                break;
            case R.id.tv_easy4:
                break;
            case R.id.tv_easy5:
                break;
            case R.id.tv_easy6:
                break;
        }
    }
}
