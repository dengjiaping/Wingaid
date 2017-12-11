package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.FragAdapter;
import com.yd.org.sellpopularizesystem.fragment.CommissionFragment;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的佣金
 */
public class CommissionActivity extends FragmentActivity {

    public static CommissionActivity commissionActivity;
    private TextView tvPersonalSum, tvLeaderSum;
    private ImageView backLinearLayout, rightSearchLinearLayout;
    private RadioButton rbSaleCommission, rbLeaderAward;
    private ViewPager vpCommission;
    private FragAdapter adapter;
    private CommissionFragment saleFragment, leaderFragment;
    private TextView tvTitle;
    private LinearLayout commissonLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission);
        initView();
    }

    public void initView() {
        commissionActivity = this;
        //注册事件
        EventBus.getDefault().register(this);
        initWedget();
        initViewPage();

    }

    private void initWedget() {
        commissonLinear = (LinearLayout) findViewById(R.id.commissonLinear);


        //推荐人
        if (SharedPreferencesHelps.getType() == 2) {
            commissonLinear.setVisibility(View.GONE);
        } else {
            commissonLinear.setVisibility(View.VISIBLE);
            //以前版本,新版本改掉
            commissonLinear.setVisibility(View.GONE);
        }

        //返回
        backLinearLayout = (ImageView) findViewById(R.id.backLinearLayout);
        backLinearLayout.setOnClickListener(mOnClickListener);

        //隐藏右边搜按钮
        rightSearchLinearLayout = (ImageView) findViewById(R.id.rightSearchLinearLayout);
        rightSearchLinearLayout.setVisibility(View.GONE);

        //标题
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(R.string.commission);

        rbSaleCommission = (RadioButton) findViewById(R.id.rbPersonalCom);
        tvPersonalSum = (TextView) findViewById(R.id.tvPersonalSum);

        rbLeaderAward = (RadioButton) findViewById(R.id.rbLeaderAward);
        tvLeaderSum = (TextView) findViewById(R.id.tvLeaderAwardSum);

        vpCommission = (ViewPager) findViewById(R.id.vpCommission);

        rbSaleCommission.setOnClickListener(mOnClickListener);
        rbLeaderAward.setOnClickListener(mOnClickListener);


    }

    private void initViewPage() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        //佣金类型 / optional default 0 / 0:所有佣金 1:个人佣金 2： 领导拥金
//        if (SharedPreferencesHelps.getType() == 2) {
//            leaderFragment = CommissionFragment.getInstnce(2);
//            fragments.add(leaderFragment);
//        } else {
//            saleFragment = CommissionFragment.getInstnce(1);
//            leaderFragment = CommissionFragment.getInstnce(2);
//            fragments.add(saleFragment);
//            fragments.add(leaderFragment);
//        }

        //以前版本
        saleFragment = CommissionFragment.getInstnce(1);
        fragments.add(saleFragment);


        adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        vpCommission.setAdapter(adapter);
        vpCommission.setCurrentItem(0);
        vpCommission.setOffscreenPageLimit(1);
        vpCommission.addOnPageChangeListener(new MyVPageChangeListener());
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                //返回
                case R.id.backLinearLayout:
                    finish();
                    break;

                //个人销售金
                case R.id.rbPersonalCom:
                    selectRadio(0);
                    vpCommission.setCurrentItem(0);
                    break;

                //销售领导奖励
                case R.id.rbLeaderAward:
                    selectRadio(1);
                    vpCommission.setCurrentItem(1);
                    break;

                default:
                    break;

            }
        }
    };

    private class MyVPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int location) {
            changeTextColor(location);
        }

    }

    private void changeTextColor(int location) {
        switch (location) {
            case 0:
                selectRadio(0);
                break;

            case 1:
                selectRadio(1);
                break;

            default:
                break;
        }
    }

    private void selectRadio(int type) {

        if (type == 0) {
            rbSaleCommission.setChecked(true);
            rbLeaderAward.setChecked(false);

        } else {
            rbSaleCommission.setChecked(false);
            rbLeaderAward.setChecked(true);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(String message) {
        Log.e("TAG", "onMoonEvent: " + message);
        if (message.equals("ok")) {

        }

    }

}
