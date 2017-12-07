package com.yd.org.sellpopularizesystem.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

public class LawyerAddActivity extends BaseActivity {
    private EditText etLawyerName, etAddress, etFirstName, etLastName, etTel, etEmail;
    private String strName;
    private String strAdress;
    private String strFirst;
    private String strLast;
    private String strTel;
    private String strEmail;

    @Override
    protected int setContentView() {

        return R.layout.activity_lawyer_add;
    }

    @Override
    public void initView() {
        setTitle(getString(R.string.lawyerinformation));
        setRightTitle(R.string.customdetaild_save, mSaveOnClickListener);
        etLawyerName = getViewById(R.id.etLawyerName);
        etAddress = getViewById(R.id.etAddress);
        etFirstName = getViewById(R.id.etFirstName);
        etLastName = getViewById(R.id.etLastName);
        etTel = getViewById(R.id.etTel);
        etEmail = getViewById(R.id.etEmail);
    }

    View.OnClickListener mSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            strName = etLawyerName.getText().toString();
            strAdress = etAddress.getText().toString();
            strFirst = etAddress.getText().toString();
            strLast = etAddress.getText().toString();
            strTel = etAddress.getText().toString();
            strEmail = etAddress.getText().toString();
            if (!TextUtils.isEmpty(strName) && !TextUtils.isEmpty(strAdress) && !TextUtils.isEmpty(strFirst)
                    && !TextUtils.isEmpty(strFirst) && !TextUtils.isEmpty(strLast) && !TextUtils.isEmpty(strTel) && !TextUtils.isEmpty(strEmail)) {
                save();
            } else {
                ToasShow.showToastCenter(LawyerAddActivity.this, getString(R.string.complete_hint));
            }
        }
    };

    private void save() {
        EasyHttp.post(Contants.NEW_LAWYER)
                .cacheMode(CacheMode.NO_CACHE)
                .params("law_firm", strName)
                .params("street_address_1", strAdress)
                .params("first_name", strFirst)
                .params("surname", strLast)
                .params("lawyer_tel", strTel)
                .params("lawyer_email", strEmail)
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
                    public void onSuccess(String s) {


                        try {
                            JSONObject json = new JSONObject(s);
                            if (json.getString("code").equals("1")) {
                                ToasShow.showToastCenter(LawyerAddActivity.this, json.getString("msg"));
                                LawyerActivity.lawyerActivity.handler.sendEmptyMessage(ExtraName.UPDATE);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });

    }

    @Override
    public void setListener() {

    }
}
