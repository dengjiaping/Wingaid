package com.yd.org.sellpopularizesystem.activity;

import android.view.View;
import android.widget.Button;

import com.yd.org.sellpopularizesystem.R;

public class DeclareActivity extends BaseActivity {
    private Button argeButton;


    @Override
    protected int setContentView() {
        return R.layout.activity_declare;


    }

    @Override
    public void initView() {

        hideRightImagview();
        setTitle(getString(R.string.declaretitle_01));
        argeButton=getViewById(R.id.argge);

    }

    @Override
    public void setListener() {
        argeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReserveActivity.reserveActivity.mHan.sendEmptyMessage(0x001);
                finish();

            }
        });
    }
}
