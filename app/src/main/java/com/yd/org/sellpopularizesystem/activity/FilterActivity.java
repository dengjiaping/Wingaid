package com.yd.org.sellpopularizesystem.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;

public class FilterActivity extends BaseActivity {
    private TextView tvSelect, tvSelectType, tvHouseType, tvSelectPrice, tvProductSearch;
    private ImageView ivSearch;
    //获取到筛选条件内容对应代号如1,2,3等
    private String selectStrTag;
    //获取到筛选条件内容
    private String selectContent;
    private RelativeLayout rlType, rlHouseType, rlPrice;

    @Override
    protected int setContentView() {
        return R.layout.activity_filter;
    }

    @Override
    public void initView() {
        initSetting();
        initViews();
    }

    private void initViews() {
        rlType = getViewById(R.id.rlType);
        tvSelectType = getViewById(R.id.tvSelectType);
        rlHouseType = getViewById(R.id.rlHouseType);
        tvHouseType = getViewById(R.id.tvHouseType);
        rlPrice = getViewById(R.id.rlPrice);
        tvSelectPrice = getViewById(R.id.tvSelectPrice);
        tvProductSearch = getViewById(R.id.tvProductSearch);
    }

    private void initSetting() {
        setTitle(R.string.select);
        setRightTitleBackground(new ColorDrawable(Color.WHITE), Color.RED);
        setRightTitle(R.string.reset, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetText();
            }
        });
        changeLeftImageView(R.mipmap.close, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, R.anim.out_anim);
            }
        });
        ivSearch = getViewById(R.id.rightSearchLinearLayout);
        ivSearch.setVisibility(View.GONE);
    }

    @Override
    public void setListener() {
        rlType.setOnClickListener(mOnClickListener);
        rlHouseType.setOnClickListener(mOnClickListener);
        rlPrice.setOnClickListener(mOnClickListener);
        tvProductSearch.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle bun = new Bundle();
            switch (v.getId()) {

                //类型
                case R.id.rlType:
                    bun.putString("fatosca", "type");
                    ActivitySkip.forward(FilterActivity.this, SelectConditionActivity.class, ExtraName.TYPE, bun);
                    break;
                //房型
                case R.id.rlHouseType:
                    bun.putString("fatosca", "housetype");
                    ActivitySkip.forward(FilterActivity.this, SelectConditionActivity.class, ExtraName.HOURSE, bun);
                    break;
                //价格
                case R.id.rlPrice:
                    bun.putString("fatosca", "price");
                    ActivitySkip.forward(FilterActivity.this, SelectConditionActivity.class, ExtraName.PRICE, bun);
                    break;
                //点击搜索
                case R.id.tvProductSearch:


                    try {
                        Message message = ScaleActivity.scaleActivity.handler.obtainMessage();

                        ScaleActivity.scaleActivity.psu.setArea(tvSelectType.getText().toString().equals(getString(R.string.unlimited_)) ? "" : selectStrTag);
                        ScaleActivity.scaleActivity.psu.setHouse(tvHouseType.getText().toString().equals(getString(R.string.unlimited_)) ? "" : selectStrTag);

                        //ScaleActivity.scaleActivity.psu.setSpace(tvSelectType.getText().toString().equals("不限")?"":selectStrTag);

                        ScaleActivity.scaleActivity.psu.setPrice(tvSelectPrice.getText().toString().equals(getString(R.string.unlimited_)) ? "" : selectStrTag);

                        message.obj = ScaleActivity.scaleActivity.psu;
                        ScaleActivity.scaleActivity.handler.handleMessage(message);

                        String strArea = tvSelectType.getText().toString().equals(getString(R.string.unlimited_)) ? "" : tvSelectType.getText().toString();
                        String strHt = tvHouseType.getText().toString().equals(getString(R.string.unlimited_)) ? "" : tvHouseType.getText().toString();
                        String strPrice = tvSelectPrice.getText().toString().equals(getString(R.string.unlimited_)) ? "" : tvSelectPrice.getText().toString();

                        selectContent = strArea + strHt + strPrice;
                        ScaleActivity.scaleActivity.strSelect = selectContent;
                        finish();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

    private void resetText() {
        if (!tvSelectType.getText().equals(getString(R.string.unlimited_))) {
            tvSelectType.setText(getString(R.string.unlimited_));
        }
        if (!tvHouseType.getText().equals(getString(R.string.unlimited_))) {
            tvHouseType.setText(getString(R.string.unlimited_));
        }
        if (!tvSelectPrice.getText().equals(getString(R.string.unlimited_))) {
            tvSelectPrice.setText(getString(R.string.unlimited_));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ExtraName.TYPE:
                    tvSelectType.setText(TextUtils.isEmpty(data.getStringExtra("selectextra")) ? getString(R.string.unlimited_) : data.getStringExtra("selectextra"));
                    selectStrTag = TextUtils.isEmpty(data.getStringExtra("selecttagextra")) ? "" : data.getStringExtra("selecttagextra");
                    break;
                case ExtraName.HOURSE:
                    tvHouseType.setText(TextUtils.isEmpty(data.getStringExtra("selectextra")) ? getString(R.string.unlimited_) : data.getStringExtra("selectextra"));
                    selectStrTag = TextUtils.isEmpty(data.getStringExtra("selecttagextra")) ? "" : data.getStringExtra("selecttagextra");
                    break;
                case ExtraName.PRICE:
                    tvSelectPrice.setText(TextUtils.isEmpty(data.getStringExtra("selectextra")) ? getString(R.string.unlimited_) : data.getStringExtra("selectextra"));
                    selectStrTag = TextUtils.isEmpty(data.getStringExtra("selecttagextra")) ? "" : data.getStringExtra("selecttagextra");
                    break;
            }
        }
    }
}
