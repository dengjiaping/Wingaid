package com.yd.org.sellpopularizesystem.activity;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.ViewPagerAdapter;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private int currentItem;
    private TextView tvSkip;
    // 引导图片资源
    private static final int[] pics = {R.mipmap.guild1, R.mipmap.guild2, R.mipmap.guild3};


    @Override
    protected int setContentView() {
        return R.layout.activity_guide;


    }

    @Override
    public void initView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        hideBaseTab();



        tvSkip = getViewById(R.id.tvSkip);

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitySkip.forward(GuideActivity.this, LoginActivity.class);
                finish();
            }
        });


        views = new ArrayList<>();
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        // 初始化引导图片列表
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setBackgroundResource(pics[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            views.add(iv);
        }
        vp = (ViewPager) findViewById(R.id.viewpager);
        // 初始化Adapter
        vpAdapter = new ViewPagerAdapter(GuideActivity.this, views);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(this);

        vp.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startY;
            float endX;
            float endY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        endY = event.getY();
                        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width = size.x;
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if (currentItem == (views.size() - 1) && startX - endX > 0 && startX - endX >= (width / 4)) {
                            ActivitySkip.forward(GuideActivity.this, LoginActivity.class);
                            finish();

                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void setListener() {

    }


    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        currentItem = arg0;
    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        // 设置底部小点选中状态
    }



}
