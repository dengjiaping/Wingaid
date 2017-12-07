package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.fragment.LastFragmentView;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.yd.org.sellpopularizesystem.javaBean.StudyBean;
import com.yd.org.sellpopularizesystem.javaBean.StudyInfoBean;
import com.yd.org.sellpopularizesystem.viewpage.HackyViewPager;
import com.yd.org.sellpopularizesystem.viewpage.PhotoViewFragment;
import com.yd.org.sellpopularizesystem.viewpage.ViewpagerAdapter;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习详情页面
 */
public class StudyDetailaActivity extends FragmentActivity {
    private StudyBean.ResultBean resultBean;
    private List<StudyInfoBean.ResultBean> picList = new ArrayList<>();
    private ImageView backImageView;
    private HackyViewPager viewPager;
    private ViewpagerAdapter vpAdapter;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ImageView[] tips;
    private ViewGroup group;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.backImageView:
                    finish();
                    break;
            }

        }
    };
    private ProductDetailBean.ResultBean prs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_detaila);
        initView();


    }


    public void initView() {

        Bundle bundle = getIntent().getExtras();
        resultBean = (StudyBean.ResultBean) bundle.getSerializable("study");
        prs = (ProductDetailBean.ResultBean) bundle.getSerializable("prs");


        backImageView = (ImageView) findViewById(R.id.backImageView);
        backImageView.setOnClickListener(onClickListener);
        //
        viewPager = (HackyViewPager) findViewById(R.id.viewPager);
        vpAdapter = new ViewpagerAdapter(getSupportFragmentManager(), fragmentList, null);
        viewPager.setAdapter(vpAdapter);
        viewPager.setCurrentItem(0);

        group = (ViewGroup) findViewById(R.id.viewGroup);


        getInfo(resultBean.getStudy_id());


        //事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                setImageBackground(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setViewPager(List<Fragment> fragmentLists) {


        vpAdapter = new ViewpagerAdapter(getSupportFragmentManager(), fragmentLists, null);
        viewPager.setAdapter(vpAdapter);
        viewPager.setCurrentItem(0);

        //设置小圆点
        tips = new ImageView[fragmentLists.size()];
        for (int i = 0; i < tips.length; i++) {
            ImageView imageView = new ImageView(this);
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.mipmap.dian_true);
            } else {
                tips[i].setBackgroundResource(R.mipmap.dian_false);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            group.addView(imageView, layoutParams);
        }


    }

    /**
     * 设置选中的tip的背景
     *
     * @param selectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.mipmap.dian_true);
            } else {
                tips[i].setBackgroundResource(R.mipmap.dian_false);
            }
        }
    }

    private void getInfo(String study_id) {


        EasyHttp.get(Contants.STUDY_INFO).cacheMode(CacheMode.DEFAULT).headers("Cache-Control", "max-age=0").timeStamp(true).params("study_id", study_id)

                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {

                        try {

                            Gson gson = new Gson();
                            StudyInfoBean studyBean = gson.fromJson(json, StudyInfoBean.class);

                            if (studyBean.getCode().equals("1")) {
                                picList = studyBean.getResult();
                                for (int i = 0; i < picList.size() + 1; i++) {
                                    if (i == picList.size()) {
                                        if (resultBean != null) {
                                            fragmentList.add(i, LastFragmentView.getInstnce(ExtraName.INVISIBILITY, resultBean.getStudy_id()));
                                        } else if (prs != null) {
                                            fragmentList.add(i, LastFragmentView.getInstnce(ExtraName.VISIBILITY, prs.getStudy_id()));
                                        }
                                    } else {
                                        fragmentList.add(PhotoViewFragment.getInstnce(Contants.DOMAIN + "/" + picList.get(i).getUrl(), studyBean.getResult().get(i).getDetail_title()));
                                    }
                                }

                                setViewPager(fragmentList);
                            }

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                            Log.e("解析异常", "e:" + e.getMessage());
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

}
