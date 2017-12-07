package com.yd.org.sellpopularizesystem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.ImagePagerAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ImageContent;

import java.util.ArrayList;
import java.util.List;

public class ImageShowActivity extends Activity {
    /**
     * 图片展示
     */
    private ViewPager image_pager;

    private TextView page_number;
    /**
     * 图片下载按钮
     */
    private ImageView download;
    /**
     * 图片列表
     */
    private List<ImageContent> imgContent;
    private List<String> imgUrls = new ArrayList<>();
    /**
     * PagerAdapter
     */
    private ImagePagerAdapter mAdapter;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        initView();

    }


    public void initView() {

        image_pager = (ViewPager ) findViewById(R.id.image_pager);
        page_number = (TextView) findViewById(R.id.page_number);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        initData();
        initViewPager();
        setListener();
    }


    private void initViewPager() {
        if (imgUrls.size() > 0) {
            mAdapter = new ImagePagerAdapter(getApplicationContext(), imgUrls);
            image_pager.setAdapter(mAdapter);
        }
    }

    private void initData() {
        imgContent = (List<ImageContent>) getIntent().getSerializableExtra("img_content");
        if (imgContent != null && imgContent.size() > 0) {

            for (int i = 0; i < imgContent.size(); i++) {
                imgUrls.add(Contants.DOMAIN + "/" + imgContent.get(i).getUrl());
            }
            page_number.setText("1" + "/" + imgUrls.size());
        }

    }

    public void setListener() {
        image_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page_number.setText((position + 1) + "/" + imgUrls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
