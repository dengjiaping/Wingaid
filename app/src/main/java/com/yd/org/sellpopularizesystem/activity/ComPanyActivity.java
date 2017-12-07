package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.permission.Acp;
import com.lidong.photopicker.permission.AcpListener;
import com.lidong.photopicker.permission.AcpOptions;
import com.squareup.picasso.Picasso;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.ToasShow;

import java.util.ArrayList;
import java.util.List;

public class ComPanyActivity extends BaseActivity {

    private EditText companyEdit, abnEdit, acnEdit;
    private LinearLayout acomAdrLinnear;
    private RelativeLayout compaanyRelative;
    private ImageView logoImageView;
    private MyUserInfo myUserInfo;
    private String imagePath = "";
    private static final int REQUEST_CAMERA_CODE = 10;
    private ArrayList<String> imagePaths = new ArrayList<>();

    private View.OnClickListener mOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                //公司地址
                case R.id.acomAdrLinnear:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("type", "2");
                    bundle1.putSerializable("userkey", myUserInfo);
                    ActivitySkip.forward(ComPanyActivity.this, UserAdressActivity.class, bundle1);
                    break;


                //公司logo
                case R.id.compaanyRelative:


                    Acp.getInstance(ComPanyActivity.this).request(new AcpOptions.Builder()
                                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                            , Manifest.permission.READ_EXTERNAL_STORAGE
                                    )
                                    .build(),
                            new AcpListener() {
                                @Override
                                public void onGranted() {

                                    PhotoPickerIntent intent = new PhotoPickerIntent(ComPanyActivity.this);
                                    intent.setSelectModel(SelectModel.SINGLE);
                                    intent.setShowCarema(true); // 是否显示拍照
                                    // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                                    startActivityForResult(intent, REQUEST_CAMERA_CODE);

                                }

                                @Override
                                public void onDenied(List<String> permissions) {
                                    ToasShow.showToastCenter(ComPanyActivity.this,permissions.toString() + "权限拒绝");
                                }
                            });




                    break;

            }
        }
    };


    @Override
    protected int setContentView() {
        return R.layout.activity_com_pany;
    }


    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getResources().getString(R.string.con_in));

        myUserInfo = (MyUserInfo) getIntent().getSerializableExtra("userkey");

        companyEdit = getViewById(R.id.companyEdit);
        abnEdit = getViewById(R.id.abnEdit);
        acnEdit = getViewById(R.id.acnEdit);
        acomAdrLinnear = getViewById(R.id.acomAdrLinnear);
        compaanyRelative = getViewById(R.id.compaanyRelative);
        logoImageView = getViewById(R.id.logoImageView);
        setInfo(myUserInfo);

    }


    private void setInfo(MyUserInfo myUserInfo) {
        if (myUserInfo!=null){
            //公司名称
            companyEdit.setText((null == myUserInfo.getResult().getBusiness_name() || TextUtils.isEmpty(myUserInfo.getResult().getBusiness_name())) ? "" : myUserInfo.getResult().getBusiness_name());
            abnEdit.setText((null == myUserInfo.getResult().getAbn() || TextUtils.isEmpty(myUserInfo.getResult().getAbn())) ? "" : myUserInfo.getResult().getAbn());
            acnEdit.setText((null == myUserInfo.getResult().getAcn() || TextUtils.isEmpty(myUserInfo.getResult().getAcn())) ? "" : myUserInfo.getResult().getAcn());


            //公司logo
            if (!TextUtils.isEmpty(myUserInfo.getResult().getSales_logo())) {
                Picasso.with(this).load(Contants.DOMAIN + "/" + myUserInfo.getResult().getSales_logo()).
                        config(Bitmap.Config.RGB_565).fit().into(logoImageView);
            }
        }


    }

    @Override
    public void setListener() {
        acomAdrLinnear.setOnClickListener(mOnClick);
        compaanyRelative.setOnClickListener(mOnClick);

    }

    private void getInfo() {

        String business_name, abn, acn;

        //公司名称
        business_name = companyEdit.getText().toString();
        if( BaseApplication.getInstance().myUserInfo.getResult()!=null){
            BaseApplication.getInstance().myUserInfo.getResult().setBusiness_name(business_name);
            //abn
            abn = abnEdit.getText().toString();
            BaseApplication.getInstance().myUserInfo.getResult().setAbn(abn);
            //acn
            acn = acnEdit.getText().toString();
            BaseApplication.getInstance().myUserInfo.getResult().setAcn(acn);
            //logo
            BaseApplication.getInstance().myUserInfo.getResult().setSales_logo(imagePath);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        getInfo();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    //String string=data.getStringExtra(PhotoPickerActivity.EXTRA_RESULT);
                    Log.d("TAG", "list: " + "list = [" + list.size());
                    loadAdpater(list);
                    break;

            }

        }

    }

    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        imagePath = imagePaths.get(0);

        Picasso.with(ComPanyActivity.this).load("file://" + imagePath).fit().into(logoImageView);

    }
}
