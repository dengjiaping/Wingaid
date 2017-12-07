package com.yd.org.sellpopularizesystem.activity;


import android.os.Bundle;
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
import com.yd.org.sellpopularizesystem.fragment.ExamineFragment;
import com.yd.org.sellpopularizesystem.fragment.StudyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习园地
 */
public class LearningGardenActivity extends FragmentActivity {
    private LinearLayout studyLineaLayout, checkLineaLayout;
    private RadioButton studyRadion, checkRadion;
    private View studyView, checkView;
    private ViewPager studyViewPager;
    private FragAdapter adapter;
    private ImageView backLinearLayout, rightSearchLinearLayout;
    private TextView tvTitle, tvStudyNum;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //返回
                case R.id.backLinearLayout:
                    finish();
                    break;
                //园地
                case R.id.studyRadion:
                    selectRadio(0);
                    studyViewPager.setCurrentItem(0);

                    break;
                //考核
                case R.id.checkRadion:
                    selectRadio(1);
                    studyViewPager.setCurrentItem(1);

                    break;

            }
        }
    };
    private String studyNum;
    private String unchecknum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_garden);
        initView();
        initViewPage();
    }


    private void initView() {
        studyNum = getIntent().getExtras().getString("studynum");
        unchecknum = getIntent().getExtras().getString("unchecknum");
        //返回
        backLinearLayout = (ImageView) findViewById(R.id.backLinearLayout);
        backLinearLayout.setOnClickListener(mOnClickListener);

        //隐藏右边搜按钮
        rightSearchLinearLayout = (ImageView) findViewById(R.id.rightSearchLinearLayout);
        rightSearchLinearLayout.setVisibility(View.GONE);

        //标题
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvStudyNum = (TextView) findViewById(R.id.tvStudyNum);
        tvTitle.setText(getString(R.string.home_study));
        tvStudyNum.setText(getString(R.string.studydes1) + studyNum + getString(R.string.studymaterialdes) +
                getString(R.string.checkdes1) + unchecknum + getString(R.string.checkdes));

        //图标,字体
        studyRadion = (RadioButton) findViewById(R.id.studyRadion);
        checkRadion = (RadioButton) findViewById(R.id.checkRadion);
        studyRadion.setOnClickListener(mOnClickListener);
        checkRadion.setOnClickListener(mOnClickListener);
        //viewpager
        studyViewPager = (ViewPager) findViewById(R.id.studyViewPager);


    }

    private void initViewPage() {

        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new StudyFragment());
        fragments.add(new ExamineFragment());

        adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        studyViewPager.setAdapter(adapter);
        studyViewPager.setCurrentItem(0);
        studyViewPager.setOnPageChangeListener(new MyVPageChangeListener());

    }

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

        }
    }

    private void selectRadio(int type) {

        if (type == 0) {
            studyRadion.setChecked(true);
            checkRadion.setChecked(false);

        } else {
            studyRadion.setChecked(false);
            checkRadion.setChecked(true);
        }

    }

}
