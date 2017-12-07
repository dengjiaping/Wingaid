package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.igexin.sdk.PushManager;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.HomeActivity;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.getui.IntentService;
import com.yd.org.sellpopularizesystem.getui.PushService;
import com.yd.org.sellpopularizesystem.javaBean.UserBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.Map;


/**
 * Created by hejin on 2017/6/12.
 * transmissiontype设置成2，就不会直接启动应用
 */

public class LoginFragment extends BaseFragmentView {
    private EditText useName, usePassword;
    private TextView tvLogin;
    private RelativeLayout rlloginWechat;
    private String client_id = "";
    private Class userPushService = PushService.class;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_login);
        initWidget();
    }

    private void initWidget() {

        useName = getViewById(R.id.useName);
        usePassword = getViewById(R.id.usePassword);
        tvLogin = getViewById(R.id.tvLogin);
        rlloginWechat = getViewById(R.id.loginWechat);
        startGeTui();
    }

    private void startGeTui() {
        PushManager.getInstance().initialize(getActivity().getApplicationContext(), userPushService);
        PushManager.getInstance().registerPushIntentService(getActivity().getApplicationContext(), IntentService.class);
    }

    @Override
    protected void setListener() {
        tvLogin.setOnClickListener(mOnClickListener);
        rlloginWechat.setOnClickListener(mOnClickListener);
        /*
         * 键盘是完成按钮的功能,直接登陆
          */
        usePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    getUserInfo();
                }
                return false;
            }
        });
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //登陆
                case R.id.tvLogin:
                    getUserInfo();
                    break;

                //微信登陆
                case R.id.loginWechat:

                    if (UMShareAPI.get(getActivity()).isInstall(getActivity(), SHARE_MEDIA.WEIXIN)) {//判断是否安装微信
                        UMShareAPI.get(getActivity()).doOauthVerify(getActivity(), SHARE_MEDIA.WEIXIN, authListener);
                    } else {
                        ToasShow.showToastCenter(getActivity(), getString(R.string.check_wechat_install));
                        return;
                    }
                    break;
            }
        }
    };

    private void getUserInfo() {
        String name = useName.getText().toString().trim();
        String password = usePassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            ToasShow.showToastCenter(getActivity(), getResources().getString(R.string.login_usename));
            return;

        } else {
            if (TextUtils.isEmpty(BaseApplication.getInstance().cid) || BaseApplication.getInstance().cid == "") {
                client_id = PushManager.getInstance().getClientid(getActivity());
            } else {
                client_id = BaseApplication.getInstance().cid;

            }
            getLogin(name, password, client_id);
        }

    }

    private void getLogin(String name, String password, String client_id) {


        EasyHttp.post(Contants.HOME_LOGIN)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params("account", name)
                .params("password", password)
                //个推识别码
                .params("client_id", client_id)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        dismissLoadingDialog();
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);

                        dismissLoadingDialog();
                        if (!TextUtils.isEmpty(json)) {

                            try {

                                Gson gson = new Gson();
                                UserBean userBean = gson.fromJson(json, UserBean.class);
                                if (userBean.getCode().equals("1")) {
                                    ToasShow.showToastCenter(getActivity(), userBean.getMsg());

                                    //id
                                    SharedPreferencesHelps.setUserID(userBean.getResult().getUser_id() + "");
                                    //公司
                                    SharedPreferencesHelps.setCompanyId(userBean.getResult().getCompany_id() + "");
                                    //
                                    SharedPreferencesHelps.setType(userBean.getResult().getType());
                                    SharedPreferencesHelps.setAccount(userBean.getResult().getAccount());
                                    SharedPreferencesHelps.setUserImage(userBean.getResult().getHead_img());
                                    SharedPreferencesHelps.setFirstName(userBean.getResult().getFirst_name());
                                    SharedPreferencesHelps.setSurName(userBean.getResult().getSurname());
                                    SharedPreferencesHelps.setUserPassword(userBean.getResult().getPassword());
                                    //推荐人id
                                    SharedPreferencesHelps.setReferCode(userBean.getResult().getRefer_code());
                                    ActivitySkip.forward(getActivity(), HomeActivity.class);
                                    getActivity().finish();
                                } else {
                                    ToasShow.showToastCenter(getActivity(), userBean.getMsg());
                                }
                            }catch (JsonSyntaxException e){
                                e.printStackTrace();
                            }catch (NullPointerException e){
                                e.printStackTrace();
                            }





                        }


                    }
                });


    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            showLoadingDialog();
            Log.e("开始授权", "platform:" + platform);
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            dismissLoadingDialog();
            Log.e("授权成功", "platform:" + platform);
            String openId = data.get("openid");
            SharedPreferencesHelps.setOpenId(openId);
            String temp = "";
            third_login(openId);


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ToasShow.showToastBottom(getActivity(), t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

        }
    };

    private void third_login(String openid) {

        EasyHttp.post(Contants.WEIXIN_LOGIN)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params("type", "wechat")
                .params("openid", openid)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        dismissLoadingDialog();
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);

                        dismissLoadingDialog();
                        if (!TextUtils.isEmpty(json)) {

                            try {

                                Gson gson = new Gson();
                                UserBean userBean = gson.fromJson(json, UserBean.class);
                                if (userBean.getCode().equals("1")) {


                                    ToasShow.showToastCenter(getActivity(), userBean.getMsg());

                                    //先取消上次的授权
                                    UMShareAPI.get(getActivity()).deleteOauth(getActivity(), SHARE_MEDIA.WEIXIN, null);
                                    //id
                                    SharedPreferencesHelps.setUserID(userBean.getResult().getUser_id() + "");
                                    //公司
                                    SharedPreferencesHelps.setCompanyId(userBean.getResult().getCompany_id() + "");
                                    //
                                    SharedPreferencesHelps.setType(userBean.getResult().getType());
                                    SharedPreferencesHelps.setAccount(userBean.getResult().getAccount());
                                    SharedPreferencesHelps.setUserImage(userBean.getResult().getHead_img());
                                    SharedPreferencesHelps.setFirstName(userBean.getResult().getFirst_name());
                                    SharedPreferencesHelps.setSurName(userBean.getResult().getSurname());
                                    SharedPreferencesHelps.setUserPassword(userBean.getResult().getPassword());
                                    //推荐人id
                                    SharedPreferencesHelps.setReferCode(userBean.getResult().getRefer_code());
                                    ActivitySkip.forward(getActivity(), HomeActivity.class);
                                    getActivity().finish();
                                } else {
                                    ToasShow.showToastCenter(getActivity(), userBean.getMsg());
                                }
                            }catch (JsonSyntaxException e){
                                e.printStackTrace();
                            }




                        }


                    }
                });


    }
}
