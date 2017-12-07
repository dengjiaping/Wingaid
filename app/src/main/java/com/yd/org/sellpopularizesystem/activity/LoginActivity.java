package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.igexin.sdk.PushManager;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.fragment.LoginFragment;
import com.yd.org.sellpopularizesystem.fragment.RegisterFragment;
import com.yd.org.sellpopularizesystem.getui.IntentService;
import com.yd.org.sellpopularizesystem.getui.PushService;
import com.yd.org.sellpopularizesystem.myView.ViewPagerIndicator;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 登陆页面
 * Created by bai on 207/1/11.
 */

public class LoginActivity extends FragmentActivity {
    public  static  LoginActivity loginActivity;
    private Class userPushService = PushService.class;
    private ViewPagerIndicator vpi;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;// ViewPager适配器
    private List<String> mTitles;
    private List<Fragment> fragments = new ArrayList<>();

    //注册成功默认显示登录也
    public Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what==0){
                vpi.setViewPager(mViewPager, 0);
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginActivity=this;
        setContentView(R.layout.login_activty);
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        mTitles = Arrays.asList(getResources().getString(R.string.login), getResources().getString(R.string.register));
        initView();
        initData();
        //动态设置tab
        vpi.setVisibleTabCount(2);
        vpi.setTabItemTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        vpi.setViewPager(mViewPager, 0);
    }

    private void initView() {
        vpi = (ViewPagerIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.lrViewPager);
        startGeTui();
    }

    private void initData() {
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
    }


    //启动个推服务
    private void startGeTui() {
        // 注册 intentService 后 PushDemoReceiver 无效, sdk 会使用 IntentService 传递数据,
        // AndroidManifest 对应保留一个即可(如果注册 IntentService, 可以去掉 PushDemoReceiver, 如果注册了
        // IntentService, 必须在 AndroidManifest 中声明)
        PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), IntentService.class);


    }
}
