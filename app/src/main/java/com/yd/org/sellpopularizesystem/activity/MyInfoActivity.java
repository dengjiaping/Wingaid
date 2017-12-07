package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.myView.CircleImageView;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 我的信息
 */
public class MyInfoActivity extends BaseActivity implements View.OnClickListener {
    private CircleImageView myHeadIm;
    private EditText myFirstNameEdit;
    private EditText myLastNameEdit;
    private EditText myPhoneEdit;
    private EditText myEmailEdit;
    private EditText registeredGST;
    private TextView myAdressTv;
    private TextView myBankTV;
    private TextView myCompanyAdressTV;
    private TextView myCertificate;
    private TextView myCertificateTV;
    private TextView companyTV;
    private RelativeLayout wechatRelative;
    private ImageView wechatImageView;

    private View firbPwView;
    //firb选择相关
    private Button btUnknown, btSure, btFalse;
    private PopupWindow firbSelectPopWindow;


    private String imagePath = "", wechat_qrcode = "";
    private MyUserInfo myUserInfo;
    private int type = 0;//0销售头像,1微信二维码


    @Override
    protected int setContentView() {
        return R.layout.activity_my_info;

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.myinfo));
        companyTV = getViewById(R.id.companyTV);

        myHeadIm = getViewById(R.id.myHeadIm);
        myFirstNameEdit = getViewById(R.id.myFirstNameEdit);
        myLastNameEdit = getViewById(R.id.myLastNameEdit);
        myPhoneEdit = getViewById(R.id.myPhoneEdit);
        myEmailEdit = getViewById(R.id.myEmailEdit);
        myAdressTv = getViewById(R.id.myAdressTv);
        myBankTV = getViewById(R.id.myBankTV);
        myCompanyAdressTV = getViewById(R.id.myCompanyAdressTV);
        myCertificate = getViewById(R.id.myCertificate);
        myCertificateTV = getViewById(R.id.myCertificateTV);

        wechatRelative = getViewById(R.id.wechatRelative);
        wechatImageView = getViewById(R.id.wechatImageView);
        registeredGST = getViewById(R.id.registeredGST);


        if (SharedPreferencesHelps.getType() == 1) {
            myCertificate.setText(R.string.mycertificate);
        } else if (SharedPreferencesHelps.getType() == 2) {
            myCertificate.setText(R.string.besale);

        }
        getView();
        getInfo();
    }

    private void getView() {

        //FIRB选择视图
        firbPwView = LayoutInflater.from(this).inflate(R.layout.firb_popuwindow, null);
        RelativeLayout rlFirb = (RelativeLayout) firbPwView.findViewById(R.id.rlFirb);
        btUnknown = (Button) firbPwView.findViewById(R.id.btUnknown);
        btSure = (Button) firbPwView.findViewById(R.id.btSure);
        btFalse = (Button) firbPwView.findViewById(R.id.btFalse);
        firbSelectPopWindow = new PopupWindow(firbPwView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        firbSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable firb = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        firbSelectPopWindow.setBackgroundDrawable(firb);

        btUnknown.setText("YES");
        btSure.setText("NO");
        btFalse.setText("Cancel");


        rlFirb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });


        btUnknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registeredGST.setText("YES");
                firbSelectPopWindow.dismiss();


                Drawable drawable = getResources().getDrawable(R.mipmap.xinghao);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//对图片进行压缩
                companyTV.setCompoundDrawables(null, null, drawable, null);


            }
        });

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registeredGST.setText("NO");
                firbSelectPopWindow.dismiss();


                // Drawable drawable = getResources().getDrawable(R.mipmap.xinghao);
                //drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());//对图片进行压缩
                companyTV.setCompoundDrawables(null, null, null, null);

            }
        });

        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });


    }


    @Override
    public void setListener() {
        myHeadIm.setOnClickListener(this);
        myAdressTv.setOnClickListener(this);
        myBankTV.setOnClickListener(this);
        myCompanyAdressTV.setOnClickListener(this);
        myCertificateTV.setOnClickListener(this);
        wechatRelative.setOnClickListener(this);
        registeredGST.setOnClickListener(this);


        setRightTitle(R.string.customdetaild_save, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateUserInfo();


            }
        });
    }

    private void getInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());

        EasyHttp.get(Contants.USER_INFO)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .params(httpParams)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError***", "onError:" + e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("onSuccess***", "onSuccess:" + s);
                        closeDialog();

                        try {

                            Gson gson = new Gson();
                            myUserInfo = gson.fromJson(s, MyUserInfo.class);
                            if (myUserInfo.getCode().equals("1")) {
                                if (myUserInfo.getResult() != null) {
                                    setUseInfo(myUserInfo);
                                }

                            } else {
                                ToasShow.showToastCenter(MyInfoActivity.this, myUserInfo.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });
    }

    //设置信息
    private void setUseInfo(MyUserInfo myUserInfo) {
        try {


            BaseApplication.getInstance().myUserInfo = myUserInfo;


            //更新头像
            if (!TextUtils.isEmpty(myUserInfo.getResult().getHead_img())) {
                SharedPreferencesHelps.setUserImage(myUserInfo.getResult().getHead_img());

            }

            //姓名
            if (!TextUtils.isEmpty(myUserInfo.getResult().getFirst_name())) {
                SharedPreferencesHelps.setFirstName(myUserInfo.getResult().getFirst_name());

            }
            //姓名
            if (!TextUtils.isEmpty(myUserInfo.getResult().getSurname())) {
                SharedPreferencesHelps.setSurName(myUserInfo.getResult().getSurname());

            }


            //设置头像
            if (!TextUtils.isEmpty(myUserInfo.getResult().getHead_img())) {

                Picasso.with(this).load(Contants.DOMAIN + "/" + myUserInfo.getResult().getHead_img()).
                        config(Bitmap.Config.RGB_565).placeholder(R.mipmap.settingbt).into(myHeadIm);
            }

            //设置微信二维码
            if (!TextUtils.isEmpty(myUserInfo.getResult().getWechat_qrcode())) {
                Picasso.with(this).load(Contants.DOMAIN + "/" + myUserInfo.getResult().getWechat_qrcode()).
                        config(Bitmap.Config.RGB_565).fit().into(wechatImageView);
            }

            //姓
            myFirstNameEdit.setText(myUserInfo.getResult().getSurname());
            //名
            myLastNameEdit.setText(myUserInfo.getResult().getFirst_name());
            //手机号
            myPhoneEdit.setText(myUserInfo.getResult().getMobile());
            //邮箱
            myEmailEdit.setText(myUserInfo.getResult().getE_mail());


            if (myUserInfo.getResult().getIs_gst() == 0) {
                registeredGST.setText("Unknown");
            } else if (myUserInfo.getResult().getIs_gst() == 1) {
                registeredGST.setText("NO");
            } else if (myUserInfo.getResult().getIs_gst() == 2) {
                registeredGST.setText("YES");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


    private void updateUserInfo() {


        try {
            String first_name, surname, mobile, e_mail;

            UIProgressResponseCallBack mUIProgressResponseCallBack = new UIProgressResponseCallBack() {
                @Override
                public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                    int progress = (int) (bytesRead * 100 / contentLength);


                }
            };


            //姓
            if (TextUtils.isEmpty(myFirstNameEdit.getText().toString().trim())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.xingshi_empty));
                return;
            } else {
                surname = myFirstNameEdit.getText().toString().trim();
            }

            //名
            if (TextUtils.isEmpty(myLastNameEdit.getText().toString().trim())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.name_empty));
                return;
            } else {
                first_name = myLastNameEdit.getText().toString().trim();
            }

            //电话
            mobile = myPhoneEdit.getText().toString();


            //邮箱

            if (TextUtils.isEmpty(myEmailEdit.getText().toString().trim())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.email_hint));
                return;
            } else {
                e_mail = myEmailEdit.getText().toString().trim();
            }

            //-------------------------基本信息---------------------
            HttpParams httpParams = new HttpParams();
            httpParams.put("user_id", SharedPreferencesHelps.getUserID());
            httpParams.put("first_name", first_name);
            httpParams.put("surname", surname);
            httpParams.put("mobile", mobile);
            httpParams.put("e_mail", e_mail);
            // httpParams.put("is_gst", registeredGST.getText().toString().trim());
            //头像
            if (!TextUtils.isEmpty(imagePath)) {
                Log.e("TAG", "updateUserInfo: " + imagePath);
                httpParams.put("head_img", new File(imagePath), mUIProgressResponseCallBack);
            }
            //微信二维码
            if (!TextUtils.isEmpty(wechat_qrcode)) {
                httpParams.put("wechat_qrcode", new File(wechat_qrcode), mUIProgressResponseCallBack);
            }


            //----------------------我的地址----------------------


            if (TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getCountry())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getStreet_address_line_1())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getPostcode())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.complete_my_address));
                return;
            }


            httpParams.put("country", BaseApplication.getInstance().myUserInfo.getResult().getCountry());
            httpParams.put("unit_number", BaseApplication.getInstance().myUserInfo.getResult().getUnit_number());
            httpParams.put("street_number", BaseApplication.getInstance().myUserInfo.getResult().getStreet_number());
            httpParams.put("suburb", BaseApplication.getInstance().myUserInfo.getResult().getSuburb());
            httpParams.put("state", BaseApplication.getInstance().myUserInfo.getResult().getState());
            httpParams.put("street_address_line_1", BaseApplication.getInstance().myUserInfo.getResult().getStreet_address_line_1());
            httpParams.put("street_address_line_2", BaseApplication.getInstance().myUserInfo.getResult().getStreet_address_line_2());
            httpParams.put("postcode", BaseApplication.getInstance().myUserInfo.getResult().getPostcode());


            //-------------------银行信息--------

            if (TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getAccount_name())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getAccount_number())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getBank_name())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.complete_information));
                return;
            }


            httpParams.put("account_name", BaseApplication.getInstance().myUserInfo.getResult().getAccount_name());
            httpParams.put("account_number", BaseApplication.getInstance().myUserInfo.getResult().getAccount_number());
            httpParams.put("bank_name", BaseApplication.getInstance().myUserInfo.getResult().getBank_name());
            httpParams.put("bsb", BaseApplication.getInstance().myUserInfo.getResult().getBsb());


            //--------------------公司地址------------


            if (TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getBusiness_name())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getCompany_country())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getCompany_street_address_line_1())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getCompany_postcode())
                    || TextUtils.isEmpty(BaseApplication.getInstance().myUserInfo.getResult().getSales_logo())) {
                ToasShow.showToastCenter(MyInfoActivity.this, getString(R.string.company_information));
                return;
            }


            //公司logi
            if (!BaseApplication.getInstance().myUserInfo.getResult().getSales_logo().contains("public/uploads/user_logo/")) {
                httpParams.put("logo", new File(BaseApplication.getInstance().myUserInfo.getResult().getSales_logo()), mUIProgressResponseCallBack);
            }

            httpParams.put("company_country", BaseApplication.getInstance().myUserInfo.getResult().getCompany_country());
            httpParams.put("company_unit_number", BaseApplication.getInstance().myUserInfo.getResult().getCompany_unit_number());
            httpParams.put("company_street_number", BaseApplication.getInstance().myUserInfo.getResult().getCompany_street_number());
            httpParams.put("company_suburb", BaseApplication.getInstance().myUserInfo.getResult().getCompany_suburb());
            httpParams.put("company_state", BaseApplication.getInstance().myUserInfo.getResult().getCompany_state());
            httpParams.put("company_street_address_line_1", BaseApplication.getInstance().myUserInfo.getResult().getCompany_street_address_line_1());
            httpParams.put("company_street_address_line_2", BaseApplication.getInstance().myUserInfo.getResult().getCompany_street_address_line_2());
            httpParams.put("company_postcode", BaseApplication.getInstance().myUserInfo.getResult().getCompany_postcode());

            //---------------公司信息
            httpParams.put("business_name", BaseApplication.getInstance().myUserInfo.getResult().getBusiness_name());
            httpParams.put("abn", BaseApplication.getInstance().myUserInfo.getResult().getAbn());
            httpParams.put("acn", BaseApplication.getInstance().myUserInfo.getResult().getAcn());


            EasyHttp.post(Contants.UPDATE_USER)
                    .params(httpParams)
                    .timeStamp(true)
                    .cacheMode(CacheMode.NO_CACHE)
                    .execute(new SimpleCallBack<String>() {
                        @Override
                        public void onStart() {
                            super.onStart();
                            showDialog();
                        }

                        @Override
                        public void onError(ApiException e) {
                            closeDialog();
                            Log.e("onError***", "onError:" + e.getMessage());
                        }

                        @Override
                        public void onSuccess(String s) {
                            closeDialog();
                            Log.e("onSuccess***", "onSuccess:" + s);


                            try {

                                Gson gson = new Gson();
                                ErrorBean errorBean = gson.fromJson(s, ErrorBean.class);
                                ToasShow.showToastCenter(MyInfoActivity.this, errorBean.getMsg());
                                if (errorBean.getCode().equals("1")) {
                                    finish();
                                }

                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();
                            }


                        }
                    });

        } catch (NullPointerException e) {
            e.printStackTrace();
            Log.e("e", "e:" + e.getMessage());
        }

    }


    /**
     * 拍照上传
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
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
        if (type == 0) {
            imagePath = imagePaths.get(0);
            Picasso.with(MyInfoActivity.this).load("file://" + imagePath).fit().into(myHeadIm);
        } else if (type == 1) {
            wechat_qrcode = imagePaths.get(0);
            Picasso.with(MyInfoActivity.this).load("file://" + wechat_qrcode).fit().into(wechatImageView);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //我的头像
            case R.id.myHeadIm:
                type = 0;
                getImagePath();
                break;
            //我的地址
            case R.id.myAdressTv:
                Bundle bundle = new Bundle();
                bundle.putString("type", "1");
                bundle.putSerializable("userkey", myUserInfo);
                ActivitySkip.forward(MyInfoActivity.this, UserAdressActivity.class, bundle);

                break;
            //银行账号
            case R.id.myBankTV:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("userkey", myUserInfo);
                ActivitySkip.forward(MyInfoActivity.this, BankActivity.class, bundle2);

                break;
            //公司地址
            case R.id.myCompanyAdressTV:
                Bundle bundle1 = new Bundle();
                bundle1.putString("type", "2");
                bundle1.putSerializable("userkey", myUserInfo);
                ActivitySkip.forward(MyInfoActivity.this, ComPanyActivity.class, bundle1);

                break;
            //我的证书
            case R.id.myCertificateTV:
                ActivitySkip.forward(MyInfoActivity.this, MyCertificateActivity.class);
                break;


            //上传微信二维码
            case R.id.wechatRelative:
                type = 1;
                getImagePath();
                break;

            case R.id.registeredGST:
                firbSelectPopWindow.showAtLocation(MyInfoActivity.this.findViewById(R.id.myInfoCon), Gravity.BOTTOM, 0, 0);
                break;
        }
    }

    private static final int REQUEST_CAMERA_CODE = 10;
    private ArrayList<String> imagePaths = new ArrayList<>();

    private void getImagePath() {


        Acp.getInstance(MyInfoActivity.this).request(new AcpOptions.Builder().setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .build(), new AcpListener() {
            @Override
            public void onGranted() {
                PhotoPickerIntent intent = new PhotoPickerIntent(MyInfoActivity.this);
                intent.setSelectModel(SelectModel.SINGLE);
                intent.setShowCarema(true); // 是否显示拍照
                // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                startActivityForResult(intent, REQUEST_CAMERA_CODE);


            }

            @Override
            public void onDenied(List<String> permissions) {
                ToasShow.showToastCenter(MyInfoActivity.this, permissions.toString() + "权限拒绝");
            }
        });
    }
}
