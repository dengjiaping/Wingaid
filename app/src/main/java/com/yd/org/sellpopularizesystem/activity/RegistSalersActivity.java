package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
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
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistSalersActivity extends BaseActivity {
    private TextView stateTextView, dataTextView_01, dataTextView_02, zhTypeTextView, subButton, tvIsRead;
    private EditText zhEdTextView, remarkEdit;
    private ImageView srcImageView, pointImageView;
    private String picPath = "", licence_type = "1";
    private String type = "0";
    private PopupWindow firbSelectPopWindow;
    private View firbPwView;
    private Button btUnknown, btSure, btFalse;
    private static final int REQUEST_CAMERA_CODE = 10;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private CheckBox check_box;
    /**
     * 与日期选择相关
     */
    private TimePickerView pvTime;

    private View.OnClickListener mOn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //日期
                case R.id.dataTextView_01:
                    type = "0";
                    pvTime.show();
                    break;
                //结束时间
                case R.id.dataTextView_02:
                    type = "1";
                    pvTime.show();
                    break;
                //证件类型
                case R.id.zhTypeTextView:
                    firbSelectPopWindow.showAtLocation(RegistSalersActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);


                    break;

                case R.id.pointImageView:
                    firbSelectPopWindow.showAtLocation(RegistSalersActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);


                    break;

                //选择
                case R.id.srcImageView:


                    Acp.getInstance(RegistSalersActivity.this).request(new AcpOptions.Builder()
                                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                            , Manifest.permission.READ_EXTERNAL_STORAGE
                                    )
                                    .build(),
                            new AcpListener() {
                                @Override
                                public void onGranted() {
                                    PhotoPickerIntent intent = new PhotoPickerIntent(RegistSalersActivity.this);
                                    intent.setSelectModel(SelectModel.SINGLE);
                                    intent.setShowCarema(true); // 是否显示拍照
                                    // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                                    startActivityForResult(intent, REQUEST_CAMERA_CODE);


                                }

                                @Override
                                public void onDenied(List<String> permissions) {
                                    ToasShow.showToastCenter(RegistSalersActivity.this, permissions.toString() + "权限拒绝");
                                }
                            });
                    break;
                //协议
                case R.id.isRead:
                    ActivitySkip.forward(RegistSalersActivity.this, RegisterAgreementActivity.class);
                    break;
                //提交
                case R.id.subButton:
                    if (check_box.isChecked()) {
                        //  showAlertDialog();
                        commintInfo();
                    } else {
                        ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.dingjin));
                        return;
                    }


                    break;
            }
        }
    };


    @Override
    protected int setContentView() {
        return R.layout.activity_regist_salers;
    }

    @Override
    public void initView() {
        setTitle(getResources().getString(R.string.register));
        hideRightImagview();

        stateTextView = getViewById(R.id.stateTextView);
        dataTextView_01 = getViewById(R.id.dataTextView_01);
        dataTextView_02 = getViewById(R.id.dataTextView_02);
        zhTypeTextView = getViewById(R.id.zhTypeTextView);
        zhEdTextView = getViewById(R.id.zhEdTextView);
        srcImageView = getViewById(R.id.srcImageView);
        pointImageView = getViewById(R.id.pointImageView);
        subButton = getViewById(R.id.subButton);
        remarkEdit = getViewById(R.id.remarkEdit);
        check_box = getViewById(R.id.check_box);
        tvIsRead = getViewById(R.id.isRead);
        setTimePicker();
        showZh();


    }

    @Override
    public void setListener() {

        dataTextView_01.setOnClickListener(mOn);
        dataTextView_02.setOnClickListener(mOn);
        zhTypeTextView.setOnClickListener(mOn);
        subButton.setOnClickListener(mOn);
        srcImageView.setOnClickListener(mOn);
        pointImageView.setOnClickListener(mOn);
        tvIsRead.setOnClickListener(mOn);
        check_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    subButton.setBackgroundColor(getResources().getColor(R.color.scale_tab5));
                    subButton.setClickable(true);
                    subButton.setEnabled(true);
                } else {
                    subButton.setBackgroundColor(getResources().getColor(R.color.gray_g));
                    subButton.setClickable(false);
                    subButton.setEnabled(false);
                }
            }
        });

    }

    private void setTimePicker() {
        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {


                if (type.equals("0")) {
                    //生效日期
                    dataTextView_01.setText(MyUtils.getTime("yyyy/MM/dd", date));
                } else {

                    //结束日期
                    if (date.getTime() < (new Date()).getTime()) {
                        ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.current_time));
                    } else {
                        dataTextView_02.setText(MyUtils.getTime("yyyy/MM/dd", date));
                    }
                }


            }
        });
        builder.setType(TimePickerView.Type.YEAR_MONTH_DAY);
        //时间选择器
        pvTime = new TimePickerView(builder);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                // 选择照片
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
        picPath = imagePaths.get(0);
        Picasso.with(RegistSalersActivity.this).load("file://" + picPath).fit().into(srcImageView);

    }

    private void showZh() {
        firbPwView = LayoutInflater.from(this).inflate(R.layout.firb_popuwindow, null);
        RelativeLayout rlFirb = (RelativeLayout) firbPwView.findViewById(R.id.rlFirb);
        btUnknown = (Button) firbPwView.findViewById(R.id.btUnknown);
        btUnknown.setVisibility(View.GONE);
        btSure = (Button) firbPwView.findViewById(R.id.btSure);
        btSure.setText("Certificate of Registration");
        btFalse = (Button) firbPwView.findViewById(R.id.btFalse);
        btFalse.setText("Corporation Licence");
        firbSelectPopWindow = new PopupWindow(firbPwView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        firbSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable firb = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        firbSelectPopWindow.setBackgroundDrawable(firb);
        rlFirb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licence_type = "1";
                zhTypeTextView.setText("Certificate of Registration");
                firbSelectPopWindow.dismiss();
            }
        });

        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licence_type = "2";
                zhTypeTextView.setText("Corporation Licence");
                firbSelectPopWindow.dismiss();
            }
        });


    }

    private void commintInfo() {
        String url = null;

        UIProgressResponseCallBack mUIProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {


            }
        };


        String sTime = "", endTime = "", licence_number = "", licence_name = "", remarkString;


        if ((dataTextView_01.getText().toString()).equals(getString(R.string.commencement_date))) {
            ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.select_valid_date));
            return;

        } else {
            sTime = String.valueOf(MyUtils.getInstance().string2Date("yyyy/MM/dd", dataTextView_01.getText().toString()));

        }

        if ((dataTextView_02.getText().toString()).equals(getString(R.string.maturity_date))) {
            ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.select_due_date));
            return;

        } else {
            endTime = String.valueOf(MyUtils.getInstance().string2Date("yyyy/MM/dd", dataTextView_02.getText().toString()));

        }


        if (TextUtils.isEmpty(zhEdTextView.getText().toString().trim())) {
            ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.Fill_id_number));
            return;
        } else {
            licence_number = zhEdTextView.getText().toString().trim();
        }

        if ((zhTypeTextView.getText().toString().trim()).equals(getString(R.string.certificate_type))) {
            ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.select_certificate_type));
            return;
        } else {
            licence_name = zhTypeTextView.getText().toString().trim();
        }

        remarkString = remarkEdit.getText().toString().trim();


        HttpParams httpParams = new HttpParams();


        if (TextUtils.isEmpty(picPath) || picPath == "") {
            ToasShow.showToastCenter(RegistSalersActivity.this, getString(R.string.upload_certificate));
            return;
        } else {
            File file = new File(picPath);
            httpParams.put("file", file, mUIProgressResponseCallBack);

        }

        httpParams.put("licence_type", licence_type);
        httpParams.put("licence_number", licence_number);
        httpParams.put("effective_date", sTime.substring(0, sTime.length() - 3));
        httpParams.put("expiry_date", endTime.substring(0, endTime.length() - 3));
        httpParams.put("request_notes", remarkString);
        //推荐码
        httpParams.put("team_leader_1", getIntent().getStringExtra("refer_code"));
        httpParams.put("first_name", getIntent().getStringExtra("first_name"));
        httpParams.put("surname", getIntent().getStringExtra("surname"));
        httpParams.put("en_name", getIntent().getStringExtra("en_name"));
        httpParams.put("e_mail", getIntent().getStringExtra("e_mail"));
        httpParams.put("mobile", getIntent().getStringExtra("mobile"));
        httpParams.put("password", getIntent().getStringExtra("password"));

        EasyHttp.post(Contants.REGISTER_USER)
                .cacheMode(CacheMode.NO_CACHE)
                .params(httpParams)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        ToasShow.showToastCenter(RegistSalersActivity.this, e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        closeDialog();
                        Log.e("注册销售", "s:" + s);


                        try {

                            Gson gson = new Gson();
                            ErrorBean errorBean = gson.fromJson(s, ErrorBean.class);
                            if (errorBean.getCode().equals("1")) {
                                ToasShow.showToastCenter(RegistSalersActivity.this, errorBean.getMsg());
                                LoginActivity.loginActivity.mHandler.sendEmptyMessage(0);
                                finish();


                            } else {
                                ToasShow.showToastCenter(RegistSalersActivity.this, errorBean.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }


}
