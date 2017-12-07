package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.igexin.sdk.PushManager;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.fragment.HomeFragment;
import com.yd.org.sellpopularizesystem.fragment.MeFragment;
import com.yd.org.sellpopularizesystem.fragment.NotificationFragment;
import com.yd.org.sellpopularizesystem.getui.IntentService;
import com.yd.org.sellpopularizesystem.getui.PushService;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.LocaleLanguage;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    public static HomeActivity homeActiviyt;
    private long mExitTime = 0;
    private TextView tvHome, tvMessage, tvSetting, tvMessageCount, tvMeCount;
    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private MeFragment meFragment;
    private LinearLayout tabLinearHome;
    private RelativeLayout tabLinearNotific, tabLinearSeeting;
    private Class userPushService = PushService.class;


    //主页消息数是否显示,更新,根据消息页面发送消息个数做决定
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //有消息
                if (msg.arg1 > 0) {
                    tvMessageCount.setVisibility(View.VISIBLE);
                    tvMessageCount.setText(msg.arg1 + "");
                    //没有有新的消息
                } else {
                    tvMessageCount.setVisibility(View.GONE);

                }
            } else if (msg.what == 2) {
                if (msg.arg1 > 0) {
                    tvMeCount.setVisibility(View.VISIBLE);
                    tvMeCount.setText(msg.arg1 + "");

                } else {
                    tvMeCount.setVisibility(View.GONE);
                }

            }

        }
    };


    //提示消息,个推提示
    public Handler showToasHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String mess = (String) msg.obj;
            showToas(mess);

            //设备在别的手机登录提示,并退出当前登录
            if (mess.equals(getResources().getString(R.string.login_toas))) {
                showLoginToas();
            }

        }
    };


    //推广记录提交,在退出推广的时候发送消息用于提交记录
    public Handler recordHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x001) {
                addRecord();
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeActiviyt = this;
        setContentView(R.layout.activity_home_activiyt);
        inintView();
        setSelect(0);

    }


    private void inintView() {
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvSetting = (TextView) findViewById(R.id.tvSetting);
        tvMessageCount = (TextView) findViewById(R.id.tvMessageCount);
        tvMeCount = (TextView) findViewById(R.id.tvMeCount);
        tvMessageCount.setVisibility(View.GONE);

        tabLinearHome = (LinearLayout) findViewById(R.id.tabLinearHome);

        tabLinearSeeting = (RelativeLayout) findViewById(R.id.tabLinearSeeting);

        tabLinearNotific = (RelativeLayout) findViewById(R.id.tabLinearNotific);


        tabLinearHome.setOnClickListener(this);
        tabLinearSeeting.setOnClickListener(this);
        tabLinearNotific.setOnClickListener(this);
    }

    public void setUnselected() {
        tvHome.setSelected(false);
        tvMessage.setSelected(false);
        tvSetting.setSelected(false);
    }


    @Override
    public void onClick(View v) {
        setUnselected();
        switch (v.getId()) {
            case R.id.tabLinearHome:
                StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
                setSelect(0);
                break;
            case R.id.tabLinearNotific:
                // StatusBarUtil.setColor(this, getResources().getColor(R.color.white), 20);

                setSelect(1);
                break;
            case R.id.tabLinearSeeting:
                StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);

                setSelect(2);
                break;

        }

    }

    private void setSelect(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (i) {
            case 0:
                tvHome.setSelected(true);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.flContent, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case 1:
                tvMessage.setSelected(true);
                if (notificationFragment == null) {
                    notificationFragment = new NotificationFragment();
                    transaction.add(R.id.flContent, notificationFragment);
                }
                transaction.show(notificationFragment);

                break;
            case 2:
                tvSetting.setSelected(true);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.flContent, meFragment);
                }
                transaction.show(meFragment);

                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (notificationFragment != null) {
            transaction.hide(notificationFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        LocaleLanguage.getLocaleLanguage(this);
        //启动get服务
        PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);

    }


    private void showToas(String message) {
        ToasShow.showToastCenter(this, message);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                showToas(getResources().getString(R.string.app_exit));
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
                System.exit(0);// 否则退出程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


    private void addRecord() {
        EasyHttp.post(Contants.ADD_SALE_LOG)
                .cacheMode(CacheMode.NO_CACHE)
                .params("data", SharedPreferencesHelps.getData())
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(ApiException e) {


                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);


                    }
                });


    }

    private void showLoginToas() {
        ToasShow.showToastCenter(HomeActivity.this, getResources().getString(R.string.home_reminder));
        logOut();
    }


    //退出程序清除数据
    private void logOut() {
        SharedPreferencesHelps.clearUserID();
        SharedPreferencesHelps.cleaAccount();
        SharedPreferencesHelps.clearUserPassword();
        ActivitySkip.forward(HomeActivity.this, LoginActivity.class);
        finish();
    }


}
