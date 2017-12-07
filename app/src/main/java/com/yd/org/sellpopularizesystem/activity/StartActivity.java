package com.yd.org.sellpopularizesystem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;

public class StartActivity extends Activity {
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 800;

    /**
     * Handler:跳转到不同界面
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }


    public void initView() {
        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (SharedPreferencesHelps.getIsFirstLauncher()) {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, 0);
            SharedPreferencesHelps.setIsFirstLauncher(false);
        } else {
            // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
        }
    }


    private boolean isLogining() {
        if (TextUtils.isEmpty(SharedPreferencesHelps.getUserID()) || "null".equals(SharedPreferencesHelps.getUserID())) {
            return false;
        } else {
            return true;
        }
    }

    private void goHome() {
        if (isLogining()) {
            ActivitySkip.forward(StartActivity.this, HomeActivity.class);
        } else {
            ActivitySkip.forward(StartActivity.this, LoginActivity.class);
        }
        finish();
    }

    private void goGuide() {
        ActivitySkip.forward(StartActivity.this, GuideActivity.class);
        finish();
    }
}
