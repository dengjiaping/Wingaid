package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
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
import com.yd.org.sellpopularizesystem.javaBean.LicenceBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyCertificateActivity extends BaseActivity {
    private TextView stateTextView, dataTextView_01, dataTextView_02, zhTypeTextView, subButton;
    private EditText zhEdTextView, remarkEdit;
    private ImageView srcImageView, pointImageView;
    private String picPath = "", licence_type = "1";
    private String type = "0";
    private PopupWindow firbSelectPopWindow;
    private View firbPwView;
    private Button btUnknown, btSure, btFalse;
    private File file = null;
    private static final int REQUEST_CAMERA_CODE = 10;
    private ArrayList<String> imagePaths = new ArrayList<>();
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
                    firbSelectPopWindow.showAtLocation(MyCertificateActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);


                    break;

                case R.id.pointImageView:
                    firbSelectPopWindow.showAtLocation(MyCertificateActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);


                    break;

                //选择
                case R.id.srcImageView:


                    Acp.getInstance(MyCertificateActivity.this).request(new AcpOptions.Builder()
                                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                            , Manifest.permission.READ_EXTERNAL_STORAGE
                                    ).build(),
                            new AcpListener() {
                                @Override
                                public void onGranted() {
                                    PhotoPickerIntent intent = new PhotoPickerIntent(MyCertificateActivity.this);
                                    intent.setSelectModel(SelectModel.SINGLE);
                                    intent.setShowCarema(true); // 是否显示拍照
                                    // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                                    startActivityForResult(intent, REQUEST_CAMERA_CODE);


                                }

                                @Override
                                public void onDenied(List<String> permissions) {
                                    ToasShow.showToastCenter(MyCertificateActivity.this, permissions.toString() + "权限拒绝");
                                }
                            });
                    break;
                //提交
                case R.id.subButton:


                    //推荐人
                    if (SharedPreferencesHelps.getType() == 2) {
                        commintInfo();

                        //销售
                    } else if (SharedPreferencesHelps.getType() == 1) {
                        commintInfo();
                    }


                    break;
            }
        }
    };


    @Override
    protected int setContentView() {
        return R.layout.activity_my_certificate;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getResources().getString(R.string.certificate));
        stateTextView = getViewById(R.id.stateTextView);
        dataTextView_01 = getViewById(R.id.dataTextView_01);
        dataTextView_02 = getViewById(R.id.dataTextView_02);
        zhTypeTextView = getViewById(R.id.zhTypeTextView);
        zhEdTextView = getViewById(R.id.zhEdTextView);
        srcImageView = getViewById(R.id.srcImageView);
        pointImageView = getViewById(R.id.pointImageView);
        subButton = getViewById(R.id.subButton);
        remarkEdit = getViewById(R.id.remarkEdit);


        setTimePicker();
        showZh();

        getInfo();


    }

    @Override
    public void setListener() {
        dataTextView_01.setOnClickListener(mOn);
        dataTextView_02.setOnClickListener(mOn);
        zhTypeTextView.setOnClickListener(mOn);
        subButton.setOnClickListener(mOn);
        srcImageView.setOnClickListener(mOn);
        pointImageView.setOnClickListener(mOn);
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
                        ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.current_time));
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
        Picasso.with(MyCertificateActivity.this).load("file://" + picPath).fit().into(srcImageView);

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
                int progress = (int) (bytesRead * 100 / contentLength);


            }
        };


        String sTime = "", endTime = "", licence_number = "", licence_name = "", remarkString;


        if ((dataTextView_01.getText().toString()).equals(getString(R.string.commencement_date))) {
            ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.select_valid_date));
            return;

        } else {
            sTime = String.valueOf(MyUtils.getInstance().string2Date("yyyy/MM/dd", dataTextView_01.getText().toString()));

        }

        if ((dataTextView_02.getText().toString()).equals(getString(R.string.maturity_date))) {
            ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.select_due_date));
            return;

        } else {
            endTime = String.valueOf(MyUtils.getInstance().string2Date("yyyy/MM/dd", dataTextView_02.getText().toString()));

        }


        if (TextUtils.isEmpty(zhEdTextView.getText().toString().trim())) {
            ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.Fill_id_number));
            return;
        } else {
            licence_number = zhEdTextView.getText().toString().trim();
        }

        if ((zhTypeTextView.getText().toString().trim()).equals(getString(R.string.certificate_type))) {
            ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.select_certificate_type));
            return;
        } else {
            licence_name = zhTypeTextView.getText().toString().trim();
        }

        remarkString = remarkEdit.getText().toString().trim();


        HttpParams httpParams = new HttpParams();


        //销售
        if (SharedPreferencesHelps.getType() == 1) {
            httpParams.put("user_id", SharedPreferencesHelps.getUserID());
            url = Contants.UPLOAD_LICENCE;

            //推荐人
        } else if (SharedPreferencesHelps.getType() == 2) {
            httpParams.put("refer_id", SharedPreferencesHelps.getUserID());
            url = Contants.Upgrade;
        }

        httpParams.put("licence_type", licence_type);
        httpParams.put("licence_number", licence_number);
        httpParams.put("effective_date", sTime.substring(0, sTime.length() - 3));
        httpParams.put("expiry_date", endTime.substring(0, endTime.length() - 3));
        httpParams.put("licence_name", licence_name);
        httpParams.put("request_notes", remarkString);
        httpParams.put("abn", "");
        httpParams.put("acn", "");
        httpParams.put("is_gst", "");


        if (TextUtils.isEmpty(picPath) || picPath == "") {
            ToasShow.showToastCenter(MyCertificateActivity.this, getString(R.string.upload_certificate));
            return;
        } else {

            if (!picPath.contains(Contants.DOMAIN)) {
                file = new File(picPath);
                httpParams.put("file", file, mUIProgressResponseCallBack);

            } else {
               // httpParams.put("file", file, mUIProgressResponseCallBack);
            }

        }


        EasyHttp.post(url)
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
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);

                        closeDialog();


                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            if (jsonObject.getString("code").equals("1")) {
                                ToasShow.showToastCenter(MyCertificateActivity.this, jsonObject.getString("msg"));
                                finish();
                            } else {
                                ToasShow.showToastCenter(MyCertificateActivity.this, jsonObject.getString("msg"));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });

    }


    private void getInfo() {
        EasyHttp.get(Contants.LICENCE_INFO)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onError", "onError:" + json);
                        closeDialog();

                        try {

                            Gson gson = new Gson();
                            LicenceBean lb = gson.fromJson(json, LicenceBean.class);

                            if (lb.getCode() == 1) {

                                if (lb.getResult().getStatus() == 0) {
                                    stateTextView.setText(R.string.state_approval);
                                } else if (lb.getResult().getStatus() == 1) {
                                    stateTextView.setText(R.string.valid_state);
                                } else if (lb.getResult().getStatus() == 2) {
                                    stateTextView.setText(R.string.state_refused);
                                } else if (lb.getResult().getStatus() == 3) {
                                    stateTextView.setText(R.string.State_overdue);
                                }

                                dataTextView_01.setText(MyUtils.getInstance().date2String("yyyy/MM/dd", Long.parseLong(lb.getResult().getEffective_date().split("\\.")[0] + "000")));
                                dataTextView_02.setText(MyUtils.getInstance().date2String("yyyy/MM/dd", Long.parseLong(lb.getResult().getExpiry_date().split("\\.")[0] + "000")));
                                zhEdTextView.setText(lb.getResult().getLicence_number());

                                if (lb.getResult().getLicence_type() == 1) {
                                    zhTypeTextView.setText("Certificate of Registration");
                                } else {
                                    zhTypeTextView.setText("Corporation Licence");
                                }

                                remarkEdit.setText(lb.getResult().getRequest_notes());
                                Picasso.with(MyCertificateActivity.this).load(Contants.DOMAIN + "/" + lb.getResult().getLicence_file()).skipMemoryCache().config(Bitmap.Config.RGB_565).fit().into(srcImageView);
                                picPath = Contants.DOMAIN + "/" + lb.getResult().getLicence_file();
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
