package com.yd.org.sellpopularizesystem.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;

import com.umeng.socialize.UMShareAPI;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;

/**
 * 设置中心
 */
public class SettingActivity extends BaseActivity {
    private TextView cancelLoginTv, versionTv, tvUserName;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                //注销登录
                case R.id.cancelLoginTv:
                    logOut();
                    break;

            }
        }
    };

    @Override
    protected int setContentView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        setTitle(getResources().getString(R.string.home_setting));
        hideRightImagview();
        cancelLoginTv = getViewById(R.id.cancelLoginTv);
        versionTv = getViewById(R.id.versionTv);


        //正式版
        if (Contants.DOMAIN.contains("https://www.wingaid.com")) {
            versionTv.setText(getVersion() + "");
        } else {
            versionTv.setText(getVersion() + "(Beta)");
        }


    }


    @Override
    public void setListener() {

        cancelLoginTv.setOnClickListener(mOnClickListener);

    }

    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return " " + version;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    private void logOut() {
        SharedPreferencesHelps.clearUserID();
        SharedPreferencesHelps.cleaAccount();
        SharedPreferencesHelps.clearUserPassword();
        ActivitySkip.forward(SettingActivity.this, LoginActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

    }


}
