package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.FragAdapter;
import com.yd.org.sellpopularizesystem.fragment.EoiFragment;

import java.util.ArrayList;
import java.util.List;

public class EOIActivity extends FragmentActivity {
    private FragAdapter adapter;
    private RadioButton rbNotUse, rbAlreadyUsed, rbRefunded;
    private ViewPager vpEoi;
    private EoiFragment notUseFragment, alreadyUsedFragment, refundedFragment;

    private ImageView backLinearLayout, rightSearchLinearLayout;
    private TextView tvTitle;
    //select代表从哪里来,customerID
    private String select, customerID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eoi);
        initView();
        initViewPage();
    }

    public void initView() {



        select = getIntent().getStringExtra("select");
        customerID = getIntent().getStringExtra("customerID");


        //返回
        backLinearLayout = (ImageView) findViewById(R.id.backLinearLayout);
        backLinearLayout.setOnClickListener(mOnClickListener);

        //隐藏右边搜按钮
        rightSearchLinearLayout = (ImageView) findViewById(R.id.rightSearchLinearLayout);
        rightSearchLinearLayout.setVisibility(View.GONE);

        //标题
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(R.string.my_eoi);
        rbNotUse = (RadioButton) findViewById(R.id.rbNotUse);
        rbAlreadyUsed = (RadioButton) findViewById(R.id.rbAlreadyUsed);
        rbRefunded = (RadioButton) findViewById(R.id.rbRefunded);
        vpEoi = (ViewPager) findViewById(R.id.vpEoi);
        rbNotUse.setOnClickListener(mOnClickListener);
        rbAlreadyUsed.setOnClickListener(mOnClickListener);
        rbRefunded.setOnClickListener(mOnClickListener);

    }

    private void initViewPage() {
        List<Fragment> fragments = new ArrayList<Fragment>();

        //未使用
        notUseFragment = EoiFragment.getInstnce(1, select, customerID);
        //已使用
        alreadyUsedFragment = EoiFragment.getInstnce(2, select, customerID);
        //已退款
        refundedFragment = EoiFragment.getInstnce(3, select, customerID);
        fragments.add(notUseFragment);
        fragments.add(alreadyUsedFragment);
        fragments.add(refundedFragment);
        adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        vpEoi.setAdapter(adapter);
        vpEoi.setCurrentItem(0);
        vpEoi.addOnPageChangeListener(new MyVPageChangeListener());
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                //返回
                case R.id.backLinearLayout:
                    finish();
                    break;

                //未使用
                case R.id.rbNotUse:
                    selectRadio(1);
                    vpEoi.setCurrentItem(0);
                    break;

                //已使用
                case R.id.rbAlreadyUsed:
                    selectRadio(2);
                    vpEoi.setCurrentItem(1);
                    break;
                //已退款
                case R.id.rbRefunded:
                    selectRadio(3);
                    vpEoi.setCurrentItem(2);
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

            case 2:
                selectRadio(2);
                break;
            default:
                break;
        }
    }

    private void selectRadio(int type) {

        if (type == 0) {
            rbNotUse.setChecked(true);
            rbAlreadyUsed.setChecked(false);
            rbRefunded.setChecked(false);
        } else if (type == 1) {
            rbNotUse.setChecked(false);
            rbAlreadyUsed.setChecked(true);
            rbRefunded.setChecked(false);
        } else {
            rbNotUse.setChecked(false);
            rbAlreadyUsed.setChecked(false);
            rbRefunded.setChecked(true);
        }

    }

}
