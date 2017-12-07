package com.yd.org.sellpopularizesystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;

public class InformationContentActivity extends BaseActivity {
    private TextView tvInformContent,tvInfoTitle;

    @Override
    protected int setContentView() {
        return R.layout.activity_information_content;
    }

    @Override
    public void initView() {
        setTitle(getString(R.string.notic_info));
        hideRightImagview();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String str = bundle.getString("data", getString(R.string.novalue));
        String title = bundle.getString("title");
        String notice_id = bundle.getString("notice_id", "null");
        tvInfoTitle=getViewById(R.id.tvInfoTitle);
        tvInformContent = getViewById(R.id.tvInformContent);

        tvInfoTitle.setText(title);
        tvInformContent.setText(str);


    }


    @Override
    public void setListener() {

    }
}
