package com.example.administrator.demo.video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author TangLongHui
 * @data created on 2019/11/6
 * @describe 安卓系统本身的播放器
 */

public class AndroidVideoActivity extends AppCompatActivity {

    @BindView(R.id.vv_video)
    VideoView vvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_video);
        ButterKnife.bind(this);
        vvVideo.setVideoPath("http://gslb.miaopai.com/stream/3D~8BM-7CZqjZscVBEYr5g__.mp4");
        MediaController controller = new MediaController(this);
//        controller.setAnchorView(vvVideo);//注意，媒体控制器，弹出点在锚点的父布局的底部。
        vvVideo.setMediaController(controller);
        vvVideo.start();
    }
}
