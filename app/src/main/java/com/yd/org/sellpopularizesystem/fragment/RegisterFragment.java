package com.yd.org.sellpopularizesystem.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.LoginActivity;
import com.yd.org.sellpopularizesystem.activity.RegistSalersActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.StringUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;


/**
 * Created by hejin on 2017/6/12.
 * 注册
 */

public class RegisterFragment extends BaseFragmentView {

    private EditText recommendIdEdit, familyNameEdit, lastNameEdit, phoneEdit, regsterEmailEdit,
            userIdEdit, enNameEdit, surePasswordEdit, passwordEdit;
    private TextView regsterText;
    private int temp = 0;
    private ImageView showPassword;
    private RadioGroup radioId;
    private RadioButton radio_01, radio_02;
    private int userType = 1;//1销售人员,2推荐建
    private LinearLayout userEnLinaer;
    private View userEnView;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_register);
        initViews();
    }

    private void initViews() {
        recommendIdEdit = getViewById(R.id.recommendIdEdit);
        familyNameEdit = getViewById(R.id.familyNameEdit);
        lastNameEdit = getViewById(R.id.lastNameEdit);
        phoneEdit = getViewById(R.id.phoneEdit);
        regsterEmailEdit = getViewById(R.id.regsterEmailEdit);
        passwordEdit = getViewById(R.id.passwordEdit);
        showPassword = getViewById(R.id.showPassword);
        regsterText = getViewById(R.id.regsterText);
        // userIdEdit = getViewById(R.id.userIdEdit);
        enNameEdit = getViewById(R.id.enNameEdit);
        surePasswordEdit = getViewById(R.id.surePasswordEdit);

        radioId = getViewById(R.id.radioId);
        radio_01 = getViewById(R.id.radio_01);
        radio_02 = getViewById(R.id.radio_02);
        userEnLinaer = getViewById(R.id.userEnLinaer);
        userEnView = getViewById(R.id.userEnView);

        if (userType == 1) {
            regsterText.setText(getResources().getString(R.string.next));
        } else {
            regsterText.setText(getResources().getString(R.string.register));
        }

        clearInfo();


    }


    //注册推荐人
    private void getInfo() {
        String recommendIdString, familyNameString, lastNameString, phoneString,
                regsterEmailString, passwordString;

        //推荐码
        if (TextUtils.isEmpty(recommendIdEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.codeerror));
            return;
        } else {
            recommendIdString = recommendIdEdit.getText().toString().trim();
        }

        //姓氏
        if (TextUtils.isEmpty(familyNameEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.surenameerror));
            return;
        } else {
            familyNameString = familyNameEdit.getText().toString().trim();
        }
        //名字
        if (TextUtils.isEmpty(lastNameEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.nameerror));
            return;
        } else {
            lastNameString = lastNameEdit.getText().toString().trim();
        }

        phoneString = phoneEdit.getText().toString().trim();


        //邮箱

        if (TextUtils.isEmpty(regsterEmailEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.email_hint));
            return;
        } else {
            if (StringUtils.isEmail(regsterEmailEdit.getText().toString().trim())) {
                regsterEmailString = regsterEmailEdit.getText().toString().trim();
            } else {
                ToasShow.showToastCenter(getActivity(), getString(R.string.email_hint));
                return;
            }

        }


        //密码

        if (TextUtils.isEmpty(passwordEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.hintpass));
            return;
        } else {
            passwordString = passwordEdit.getText().toString().trim();
        }


        HttpParams httpParams = new HttpParams();
        //推荐码
        httpParams.put("refer_code", recommendIdString);
        httpParams.put("first_name", familyNameString);
        httpParams.put("surname", lastNameString);
        httpParams.put("mobile", phoneString);
        httpParams.put("e_mail", regsterEmailString);
        httpParams.put("password", passwordString);

        EasyHttp.post(Contants.REGISTER_REFER).cacheMode(CacheMode.NO_CACHE).params(httpParams)
                .timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                showLoadingDialog();
            }

            @Override
            public void onError(ApiException e) {
                dismissLoadingDialog();


            }

            @Override
            public void onSuccess(String s) {
                dismissLoadingDialog();
                Log.e("注册推荐人", "s:" + s);


                try {
                    Gson gson = new Gson();
                    ErrorBean errorBean = gson.fromJson(s, ErrorBean.class);
                    if (errorBean.getCode().equals("1")) {
                        new AlertDialog.Builder(getActivity()).setMessage(getResources()
                                .getString(R.string.hint_toas)).setMessage(getResources()
                                .getString(R.string.em_hit)).setNegativeButton(getResources()
                                .getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LoginActivity.loginActivity.mHandler.sendEmptyMessage(0);

                            }
                        }).create().show();

                    } else {
                        ToasShow.showToastCenter(getActivity(), errorBean.getMsg());
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });

    }


    //注册销售
    private void getSalInf() {

        String team_leader_1 = "", first_name, surname, en_name, mobile, e_mail, password,
                refer_code;

        //推荐码
        if (TextUtils.isEmpty(recommendIdEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.codeerror));
            return;
        } else {
            refer_code = recommendIdEdit.getText().toString().trim();
        }

        //姓氏
        if (TextUtils.isEmpty(familyNameEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.surenameerror));
            return;
        } else {
            first_name = familyNameEdit.getText().toString().trim();
        }
        //名字
        if (TextUtils.isEmpty(lastNameEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.nameerror));
            return;
        } else {
            surname = lastNameEdit.getText().toString().trim();
        }


        //英文名

        if (TextUtils.isEmpty(enNameEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.en_hint));
            return;
        } else {
            en_name = enNameEdit.getText().toString().trim();
        }

        //手机号码
        if (TextUtils.isEmpty(phoneEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.tel_hint));
            return;
        } else {


            mobile = phoneEdit.getText().toString().trim();

        }


        //邮箱

        if (TextUtils.isEmpty(regsterEmailEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.email_hint));
            return;
        } else {
            if (StringUtils.isEmail(regsterEmailEdit.getText().toString().trim())) {
                e_mail = regsterEmailEdit.getText().toString().trim();
            } else {
                ToasShow.showToastCenter(getActivity(), getString(R.string.email_hint));
                return;
            }

        }


        //密码

        if (TextUtils.isEmpty(passwordEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.hintpass));
            return;
        } else {
            password = passwordEdit.getText().toString().trim();
        }

        //确认密码
        if (TextUtils.isEmpty(surePasswordEdit.getText().toString().trim())) {
            ToasShow.showToastCenter(getActivity(), getString(R.string.sure_password_en));
            return;
        } else {
            if (!surePasswordEdit.getText().toString().trim().equals(password)) {
                ToasShow.showToastCenter(getActivity(), getString(R.string.sure_change));
                return;
            }
        }


        Bundle bundle = new Bundle();
        bundle.putString("team_leader_1", team_leader_1);
        bundle.putString("refer_code", refer_code);
        bundle.putString("first_name", first_name);
        bundle.putString("surname", surname);
        bundle.putString("en_name", en_name);
        bundle.putString("mobile", mobile);
        bundle.putString("e_mail", e_mail);
        bundle.putString("password", password);


        ActivitySkip.forward(getActivity(), RegistSalersActivity.class, bundle);


    }


    @Override
    protected void setListener() {
        showPassword.setOnClickListener(mOnClickListener);
        regsterText.setOnClickListener(mOnClickListener);

        radioId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


                switch (checkedId) {
                    //Referral人员
                    case R.id.radio_01:
                        getViewById(R.id.llConfirmpass).setVisibility(View.GONE);
                        recommendIdEdit.setHint(getResources().getString(R.string
                                .referral_code_hint));
                        clearInfo();
                        userEnLinaer.setVisibility(View.GONE);
                        userEnView.setVisibility(View.GONE);

                        radio_01.setChecked(true);
                        radio_02.setChecked(false);
                        userType = 2;
                        regsterText.setText(getResources().getString(R.string.register));
                        break;


                    //销售人员
                    case R.id.radio_02:
                        getViewById(R.id.llConfirmpass).setVisibility(View.VISIBLE);
                        recommendIdEdit.setHint(getResources().getString(R.string.input_recode));
                        clearInfo();
                        userEnLinaer.setVisibility(View.VISIBLE);
                        userEnView.setVisibility(View.VISIBLE);

                        radio_01.setChecked(false);
                        radio_02.setChecked(true);
                        userType = 1;
                        regsterText.setText(getResources().getString(R.string.next));
                        break;

                }
            }
        });

    }

    private void clearInfo() {
        recommendIdEdit.setText("");
        familyNameEdit.setText("");
        lastNameEdit.setText("");
        phoneEdit.setText("");
        regsterEmailEdit.setText("");
        enNameEdit.setText("");
        passwordEdit.setText("");
        surePasswordEdit.setText("");
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //是否显示密码
                case R.id.showPassword:
                    //隐藏密码
                    if (temp == 0) {
                        passwordEdit.setTransformationMethod(PasswordTransformationMethod
                                .getInstance());
                        temp = 1;
                    } else {
                        //显示密码
                        passwordEdit.setTransformationMethod(HideReturnsTransformationMethod
                                .getInstance());
                        temp = 0;
                    }
                    break;

                //注册
                case R.id.regsterText:

                    //销售注册
                    if (userType == 1) {
                        getSalInf();
                        //推荐人
                    } else if (userType == 2) {
                        getInfo();
                    }

                    break;
            }
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
