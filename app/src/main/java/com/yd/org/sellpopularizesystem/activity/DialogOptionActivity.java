package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.view.WheelOptions;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.javaBean.SubscribeListBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ObjectSaveUtil;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DialogOptionActivity extends AppCompatActivity {
    private EditText etReserTime, etRemindTime, etReserContent, etVistTitle, etVistContent;
    private TextView tvSubmit, tvVistTime, tvVisitSubmit, tvResDes;
    private int intType;
    private FrameLayout flOperate;
    private OptionsPickerView pvCustomTime;
    private WheelOptions wheelOptions;
    private List weeks = new ArrayList<String>();
    private List hours = new ArrayList<String>();
    private List minutes = new ArrayList<String>();
    private long reserverTime = 0;
    private long reminderTime = 0;
    private String strFlag;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private String resTime, remindTime, strContent;
    private SubscribeListBean.ResultBean slbRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_oprate_popwin_view);
        Bundle bundle = getIntent().getExtras();
        slbRb = (SubscribeListBean.ResultBean) bundle.getSerializable("subrb");
        if (slbRb != null) {
            resTime = MyUtils.date2String("MM/dd HH:mm", slbRb.getOrder_time() * 1000);
            remindTime = MyUtils.date2String("MM/dd HH:mm", slbRb.getCue_time() * 1000);
            strContent = slbRb.getContent();
        }
        flOperate = (FrameLayout) findViewById(R.id.flOprate);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.x = MyUtils.getStatusBarHeight(this);
        getWindow().setAttributes(lp);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.TOP);
        strFlag = getIntent().getExtras().getString("cora");
        if (strFlag != null) {
            if (strFlag.equals("reserver")) {
                initReserverViews();
            } else if (strFlag.equals("visit")) {
                initVisitViews();
            }
        }
        if (slbRb != null) {
            initReserverViews();
        }
        //初始化自定义选择器的数据
        MyUtils.getInstance().getOptionData(DialogOptionActivity.this, weeks, hours, minutes);
        //初始化自定义选择器
        initOptionPicker();
        setListener();
    }

    //初始化拜访界面控件
    private void initVisitViews() {
        View view = LayoutInflater.from(this).inflate(R.layout.visit_operate_view, null);
        etVistTitle = (EditText) view.findViewById(R.id.etVistTitle);
        tvVistTime = (TextView) view.findViewById(R.id.tvVisitTime);
        Calendar tvCa = Calendar.getInstance();
        tvVistTime.setText(String.format("%02d", tvCa.get(Calendar.MONTH) + 1) + "/" + String.format("%02d", tvCa.get(Calendar.DAY_OF_MONTH))
                + getString(R.string.blank_space) + tvCa.get(Calendar.HOUR_OF_DAY) + ":" + tvCa.get(Calendar.MINUTE));
        etVistContent = (EditText) view.findViewById(R.id.etVistContent);
        tvVisitSubmit = (TextView) view.findViewById(R.id.tvVisitSubmit);
        flOperate.addView(view);
    }

    private void initReserverViews() {
        View view = LayoutInflater.from(this).inflate(R.layout.reserver_operate_view, null);
        tvResDes = (TextView) view.findViewById(R.id.tvResDes);
        etReserTime = (EditText) view.findViewById(R.id.etReserTime);
        etReserTime.requestFocus();
        intType = etReserTime.getInputType();
        etRemindTime = (EditText) view.findViewById(R.id.etRemindTime);
        etReserContent = (EditText) view.findViewById(R.id.etRemarkContent);
        tvSubmit = (TextView) view.findViewById(R.id.tvSubmit);
        if (slbRb != null) {
            tvResDes.setText(R.string.details);
            etReserTime.setText(resTime);
            etRemindTime.setText(remindTime);
            etReserContent.setText(strContent);
        }
        flOperate.addView(view);
    }

    private Calendar cal;

    private void initOptionPicker() {
        cal = Calendar.getInstance();
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                setText(cal, options1, options2, options3);
            }
        }).setTitleText(getString(R.string.doneinpecifi)).setTitleColor(R.color.black)
                .setCyclic(true, true, true)/*.setOutSideCancelable(false)*/
                .setSelectOptions(weeks.indexOf(getString(R.string.today)), hours.indexOf(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))), minutes.indexOf(String.format("%02d", cal.get(Calendar.MINUTE))))
                .isDialog(true);

        builder.setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
            @Override
            public void customLayout(View v) {
                TextView tvFinish = (TextView) v.findViewById(R.id.tv_finish);
                ImageView ivUp = (ImageView) v.findViewById(R.id.ivUp);
                ImageView ivDown = (ImageView) v.findViewById(R.id.ivDown);
                TextView tvTitle = (TextView) v.findViewById(R.id.tvTitle);
                if (strFlag != null) {
                    if (strFlag.equals("visit")) {
                        tvTitle.setVisibility(View.GONE);
                    }
                }
                tvFinish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (strFlag != null) {
                            if (strFlag.equals("reserver")) {
                                if (!TextUtils.isEmpty(etReserTime.getText()) && !TextUtils.isEmpty(etReserTime.getText())) {
                                    Log.e("TAG", "onClick: " + "已经执行");
                                    pvCustomTime.returnData();
                                } else {
                                    pvCustomTime.returnData();
                                    pvCustomTime.show();
                                }
                            } else {
                                pvCustomTime.returnData();
                            }
                        }
                    }
                });

                ivUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (strFlag != null) {
                            if (strFlag.equals("reserver")) {
                                if (etReserTime.isFocused()) {
                                    etReserContent.requestFocus();
                                } else if (etRemindTime.isFocused()) {
                                    etReserTime.requestFocus();
                                } else if (etReserContent.isFocused()) {
                                    etRemindTime.requestFocus();
                                }
                            }
                        }
                    }
                });

                ivDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (strFlag != null) {
                            if (strFlag.equals("reserver")) {
                                if (etReserTime.isFocused()) {
                                    etRemindTime.requestFocus();
                                } else if (etRemindTime.isFocused()) {
                                    etReserContent.requestFocus();
                                } else if (etReserContent.isFocused()) {
                                    etReserTime.requestFocus();
                                }
                            }
                        }
                    }
                });
            }
        });
        pvCustomTime = new OptionsPickerView(builder);
        View view = LayoutInflater.from(this).inflate(R.layout.pickerview_custom_time, null);
        LinearLayout llOptionPicker = (LinearLayout) view.findViewById(R.id.optionspicker);
        wheelOptions = new WheelOptions(llOptionPicker, false);
        pvCustomTime.setNPicker(weeks, hours, minutes);
        if (strFlag != null) {
            if (strFlag.equals("reserver")) {
                //让控件延时显示
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pvCustomTime.show();
                    }
                }, 200);
            }
        }
    }

    private void setText(Calendar cal, int options1, int options2, int options3) {
        Calendar ca = Calendar.getInstance();
        String str1 = (String) weeks.get(options1);
        String str2 = (String) hours.get(options2);
        String str3 = (String) minutes.get(options3);
                /*Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(str);
                m.find();
                String newStr = m.group();*/
        String[] nums = new String[2];

        if (str1.equals(getString(R.string.today)) || str1 == getString(R.string.today)) {
            nums[0] = String.format("%02d", cal.get(Calendar.MONTH) + 1);
            nums[1] = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
            Log.e("date", "setText: " + str1 + nums[0] + nums[1]);
        } else {
            nums = str1.split("\\D+");
            Log.e("date", "setText: " + str1 + str1.equals(R.string.today));
        }
        ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DAY_OF_MONTH), ca.get(Calendar.HOUR_OF_DAY), ca.get(Calendar.MINUTE), 0);
        long currentTime = ca.getTimeInMillis();
        Log.e("tag", "currentTime: " + currentTime);
        if (strFlag != null) {
            if (strFlag.equals("reserver")) {
                if (etReserTime.isFocused()) {
                    Log.e("etReserTime", "setText: " + str1 + nums[0] + nums[1]);
                    if (!TextUtils.isEmpty(etRemindTime.getText())) {
                        reminderTime = MyUtils.getInstance().getTimeMillis(etRemindTime);
                    }
                    ca.set(ca.get(Calendar.YEAR), Integer.parseInt(nums[0]) - 1, Integer.parseInt(nums[1]), Integer.parseInt(str2), Integer.parseInt(str3), 0);
                    Log.e("TAG", "setText: " + ca.getTime());
                    reserverTime = ca.getTimeInMillis();
                    String str = sdf.format(ca.getTime());
                    Log.e("tag", "reserverTime: " + reserverTime + "\n" + str);
                    if (reserverTime < currentTime) {
                        ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.datetimemust));
                    } else {
                        etReserTime.setText(String.format("%02d", Integer.parseInt(nums[0])) + "/"
                                + String.format("%02d", Integer.parseInt(nums[1])) + getString(R.string.blank_space) + str2 + ":" + str3);
                        etReserTime.setInputType(intType);
                        etReserTime.setSelection(etReserTime.getText().length());
                        etRemindTime.requestFocus();
                    }

                } else if (etRemindTime.isFocused()) {
                    Log.e("etRemindTime", "setText: " + str1 + nums[0] + nums[1]);
                    ca.set(ca.get(Calendar.YEAR), Integer.parseInt(nums[0]) - 1, Integer.parseInt(nums[1]), Integer.parseInt(str2), Integer.parseInt(str3), 0);
                    reminderTime = ca.getTimeInMillis();
                    Log.e("TAG", "setText: " + ca.getTime() + ca.getTimeInMillis());
                    if (!TextUtils.isEmpty(etReserTime.getText())) {
                        reserverTime = MyUtils.getInstance().getTimeMillis(etReserTime);
                        if (reminderTime > reserverTime) {
                            Log.e("tag", "currentTime: " + reminderTime);
                            Log.e("tag", "reminderTime: " + reserverTime);
                            ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.datetimemustlarge));
                        } else if (reminderTime < currentTime) {
                            Log.e("tag", "currentTime: " + reminderTime);
                            Log.e("tag", "reminderTime: " + currentTime);
                            ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.datetimemustlarge));
                        } else {
                            etRemindTime.setText(String.format("%02d", Integer.parseInt(nums[0])) + "/"
                                    + String.format("%02d", Integer.parseInt(nums[1])) + getString(R.string.blank_space) + str2 + ":" + str3);
                            etRemindTime.setInputType(intType);
                            etRemindTime.setSelection(etRemindTime.getText().length());
                        }
                    }
                }
            } else {
                tvVistTime.setText(String.format("%02d", Integer.parseInt(nums[0])) + "/"
                        + String.format("%02d", Integer.parseInt(nums[1])) + getString(R.string.blank_space) + str2 + ":" + str3);
            }
        }
    }

    View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.etReserTime:
                    etReserTime.requestFocus();
                    if (TextUtils.isEmpty(etReserTime.getText())) {
                        etReserTime.setInputType(InputType.TYPE_NULL);
                    }
                    pvCustomTime.setSelectOptions(weeks.indexOf(getString(R.string.today)), hours.indexOf(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))), minutes.indexOf(String.format("%02d", cal.get(Calendar.MINUTE))));
                    pvCustomTime.show();
                    break;
                case R.id.etRemindTime:
                    etRemindTime.requestFocus();
                    if (TextUtils.isEmpty(etRemindTime.getText())) {
                        etRemindTime.setInputType(InputType.TYPE_NULL);
                    }
                    pvCustomTime.setSelectOptions(weeks.indexOf(getString(R.string.today)), hours.indexOf(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))), minutes.indexOf(String.format("%02d", cal.get(Calendar.MINUTE))));
                    pvCustomTime.show();
                    break;
                case R.id.tvVisitTime:
                    pvCustomTime.show();
                    break;
                //提交拜访记录
                case R.id.tvVisitSubmit:
                    submitVisit();
                    break;
                case R.id.tvSubmit:
                    if (strFlag != null) {
                        if (TextUtils.isEmpty(etReserTime.getText().toString())) {
                            ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.setdatetime));
                        } else if (TextUtils.isEmpty(etRemindTime.getText().toString())) {
                            ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.setremindertime));
                        } else {
                            MyUtils.getInstance().submitToCalendar(DialogOptionActivity.this, reserverTime, reminderTime, etReserContent.getText().toString());
                            submitReserver();
                        }
                    } else if (slbRb != null) {
                        if (etReserTime.getText().toString().equals(MyUtils.date2String("MM/dd HH:mm", slbRb.getOrder_time() * 1000))
                                && etRemindTime.getText().toString().equals(MyUtils.date2String("MM/dd HH:mm", slbRb.getCue_time() * 1000))
                                && etReserContent.getText().toString().equals(slbRb.getContent())) {
                            ToasShow.showToastCenter(DialogOptionActivity.this, getString(R.string.tips));
                        } else {
                            updateReseverInfo();
                        }
                    }
                    //ToasShow.showToastCenter(DialogOptionActivity.this, "提交成功");
                    break;
            }
        }
    };

    private void submitReserver() {


        EasyHttp.post(Contants.NEW_RESERVER_RECORDER)
                .cacheMode(CacheMode.NO_CACHE)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("customer_id", ((CustomBean.ResultBean) ObjectSaveUtil.readObject(DialogOptionActivity.this, "custome")).getCustomer_id() + "")
                .params("title", "")
                .params("content", etReserContent.getText().toString())
                .params("is_tixing", "")
                .params("cue_time", MyUtils.getInstance().getTimeMillis(etRemindTime) + "")
                .params("cue_every_time", 3600 + "")
                .params("order_time", MyUtils.getInstance().getTimeMillis(etReserTime) + "")
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(ApiException e) {


                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);


                        if (!TextUtils.isEmpty(json)) {

                            try {

                                Gson gson = new Gson();
                                ErrorBean userBean = gson.fromJson(json, ErrorBean.class);
                                if (userBean.getCode().equals("1")) {
                                    ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                                    CusOprateRecordActivity.cusOprateRecordActivity.handler.sendEmptyMessage(ExtraName.UPDATE);
                                } else {
                                    ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                                }
                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }


                        }


                    }
                });


    }

    private void updateReseverInfo() {

        EasyHttp.post(Contants.UPDATE_RESERVER_RECORDER)
                .cacheMode(CacheMode.NO_CACHE)
                .params("o_log_id", slbRb.getO_log_id() + "")
                .params("customer_id", ((CustomBean.ResultBean) ObjectSaveUtil.readObject(DialogOptionActivity.this, "custome")).getCustomer_id() + "")
                .params("title", slbRb.getTitle())
                .params("content", etReserContent.getText().toString())
                .params("cue_time", MyUtils.getInstance().getTimeMillis(etReserTime) + "")
                .params("cue_every_time", MyUtils.getInstance().getTimeMillis(etRemindTime) + "")

                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onError(ApiException e) {


                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);


                        try {
                            Gson gson = new Gson();
                            ErrorBean userBean = gson.fromJson(json, ErrorBean.class);
                            if (userBean.getCode().equals("1")) {
                                ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                                CusOprateRecordActivity.cusOprateRecordActivity.handler.sendEmptyMessage(ExtraName.UPDATE);
                                finish();
                            } else {
                                ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    private void submitVisit() {
        if (TextUtils.isEmpty(etVistTitle.getText().toString())) {
            ToasShow.showToastBottom(DialogOptionActivity.this, getString(R.string.writetitle));
            return;
        } else {
            EasyHttp.post(Contants.NEW_VISIT_RECORDER)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("user_id", SharedPreferencesHelps.getUserID())
                    .params("customer_id", ((CustomBean.ResultBean) ObjectSaveUtil.readObject(DialogOptionActivity.this, "custome")).getCustomer_id() + "")
                    .params("title", etVistTitle.getText().toString())
                    .params("content", etVistContent.getText().toString())
                    .params("visit_time", tvVistTime.getText().toString())
                    .timeStamp(true)
                    .execute(new SimpleCallBack<String>() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onError(ApiException e) {


                            Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                        }

                        @Override
                        public void onSuccess(String json) {
                            Log.e("onSuccess***", "UserBean:" + json);


                            if (!TextUtils.isEmpty(json)) {

                                try {

                                    Gson gson = new Gson();
                                    ErrorBean userBean = gson.fromJson(json, ErrorBean.class);
                                    if (userBean.getCode().equals("1")) {
                                        ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                                        CusOprateRecordActivity.cusOprateRecordActivity.handler.sendEmptyMessage(ExtraName.UPDATE);
                                        finish();
                                        finish();
                                    } else {
                                        ToasShow.showToastCenter(DialogOptionActivity.this, userBean.getMsg());
                                    }
                                } catch (JsonSyntaxException e) {
                                    e.printStackTrace();
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }


                            }


                        }
                    });


        }

    }

    private void setListener() {
        if (strFlag != null) {
            if (strFlag.equals("reserver")) {
                etReserTime.setOnClickListener(mOnclickListener);
                etRemindTime.setOnClickListener(mOnclickListener);
                tvSubmit.setOnClickListener(mOnclickListener);
            } else if (strFlag.equals("visit")) {
                tvVistTime.setOnClickListener(mOnclickListener);
                tvVisitSubmit.setOnClickListener(mOnclickListener);
            }
        } else if (slbRb != null) {
            etReserTime.setOnClickListener(mOnclickListener);
            etRemindTime.setOnClickListener(mOnclickListener);
            tvSubmit.setOnClickListener(mOnclickListener);
        }
    }
}
