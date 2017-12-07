package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;



public class VideoActivity extends BaseActivity {
    private JCVideoPlayerStandard playerStandard;
    private ProductDetailBean.ResultBean prs;


    @Override
    protected int setContentView() {
        return R.layout.activity_video;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(R.string.video);
        playerStandard = (JCVideoPlayerStandard) findViewById(R.id.video);
        Bundle bundle = getIntent().getExtras();
        prs = (ProductDetailBean.ResultBean) bundle.getSerializable("prs");
        String videoUrl = Contants.DOMAIN + "/" + prs.getVideo_url();
        //设置视频地址
        playerStandard.setUp(videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, getString(R.string.vp));
        //直接进入全屏
        playerStandard.startFullscreen(this, JCVideoPlayerStandard.class, videoUrl, "");
        //点击播放按钮播放
        playerStandard.startButton.performClick();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
