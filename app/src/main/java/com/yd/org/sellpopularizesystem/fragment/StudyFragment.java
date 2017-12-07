package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.StudySubitemActivity;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;


/**
 * 学习园地
 */
public class StudyFragment extends BaseFragmentView {
    private TextView tvPlayPlatform, tvSuccess, tvBasic, tvSaleSecrete, tvProject;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_study);
        tvPlayPlatform = getViewById(R.id.tvPlayPlatform);
        tvSuccess = getViewById(R.id.tvSuccess);
        tvBasic = getViewById(R.id.tvBasic);
        tvSaleSecrete = getViewById(R.id.tvSaleTec);
        tvProject = getViewById(R.id.tvProject);
    }

    @Override
    protected void setListener() {
        tvPlayPlatform.setOnClickListener(mOnClickListener);
        tvSuccess.setOnClickListener(mOnClickListener);
        tvBasic.setOnClickListener(mOnClickListener);
        tvSaleSecrete.setOnClickListener(mOnClickListener);
        tvProject.setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        Bundle bundle = new Bundle();

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //玩转平台
                case R.id.tvPlayPlatform:
                    bundle.putString("type_id", "6");
                    ActivitySkip.forward(getActivity(), StudySubitemActivity.class, bundle);
                    break;
                //成功原理
                case R.id.tvSuccess:
                    bundle.putString("type_id", "5");
                    ActivitySkip.forward(getActivity(), StudySubitemActivity.class, bundle);
                    break;
                //基础知识
                case R.id.tvBasic:
                    bundle.putString("type_id", "3");
                    ActivitySkip.forward(getActivity(), StudySubitemActivity.class, bundle);
                    break;
                //  //销售秘籍
                case R.id.tvSaleTec:
                    bundle.putString("type_id", "4");
                    ActivitySkip.forward(getActivity(), StudySubitemActivity.class, bundle);
                    break;
                case R.id.tvProject:
                    //项目
                    bundle.putString("type_id", "1");
                    ActivitySkip.forward(getActivity(), StudySubitemActivity.class, bundle);
                    break;
            }
        }
    };

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

}
