package com.yd.org.sellpopularizesystem.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.ChangePassWordActivity;
import com.yd.org.sellpopularizesystem.activity.CommissionActivity;
import com.yd.org.sellpopularizesystem.activity.EOIActivity;
import com.yd.org.sellpopularizesystem.activity.InviteQRActivity;
import com.yd.org.sellpopularizesystem.activity.LoginActivity;
import com.yd.org.sellpopularizesystem.activity.MyInfoActivity;
import com.yd.org.sellpopularizesystem.activity.MyTeamActivity;
import com.yd.org.sellpopularizesystem.activity.SaleRecordActivity;
import com.yd.org.sellpopularizesystem.activity.SettingActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.myView.BindAcountPopupWindow;
import com.yd.org.sellpopularizesystem.myView.CircleImageView;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by hejin on 2017/4/10.
 */

public class MeFragment extends BaseFragmentView {
    private RelativeLayout changePassWordRel, bindAccountRel, saleRecord, rlTeam, rlSetting,
            relCertificate, saleEOI;
    private TextView tvUserName, tvQr, tvDepositCount;
    private BindAcountPopupWindow acountPopupWindow;
    private CircleImageView ivCustomePhoto;
    private RelativeLayout rlCommission;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //修改密码
                case R.id.changePassWordRel:
                    ActivitySkip.forward(getActivity(), ChangePassWordActivity.class);
                    break;
                //绑定账号
                case R.id.bindAccountRel:
                    bindAccountRel();
                    break;
                //销售记录
                case R.id.saleRecord:
                    ActivitySkip.forward(getActivity(), SaleRecordActivity.class);
                    break;
                //我的佣金
                case R.id.rlCommission:
                    ActivitySkip.forward(getActivity(), CommissionActivity.class);
                    break;
                //我的团队
                case R.id.rlTeam:
                    ActivitySkip.forward(getActivity(), MyTeamActivity.class);
                    break;
                //设置
                case R.id.rlSetting:
                    ActivitySkip.forward(getActivity(), SettingActivity.class);
                    break;

                //我的信息
                case R.id.relCertificate:
                    ActivitySkip.forward(getActivity(), MyInfoActivity.class);
                    break;

                //推荐码
                case R.id.tvQr:
                    ActivitySkip.forward(getActivity(), InviteQRActivity.class);
                    break;

                //我的信息
                case R.id.ivCustomePhoto:
                    ActivitySkip.forward(getActivity(), MyInfoActivity.class);
                    break;

                //EOI记录
                case R.id.saleEOI:
                    Bundle bundle = new Bundle();
                    bundle.putString("select", "me");
                    bundle.putString("customerID", "null");
                    ActivitySkip.forward(getActivity(), EOIActivity.class, bundle);


                    break;
            }
        }
    };

    private void bindAccountRel() {
        if (acountPopupWindow != null) {
            acountPopupWindow = new BindAcountPopupWindow(getActivity(), mItemClick);
        }
        acountPopupWindow.showAtLocation(getActivity().findViewById(R.id.bindAccountRel), Gravity
                .BOTTOM, 50, 50);
    }

    View.OnClickListener mItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bindAcount:
                    if (UMShareAPI.get(getActivity()).isInstall(getActivity(), SHARE_MEDIA
                            .WEIXIN)) {//判断是否安装微信
                        acountPopupWindow.dismiss();
                        UMShareAPI.get(getActivity()).doOauthVerify(getActivity(), SHARE_MEDIA
                                .WEIXIN, authListener);
                    } else {
                        ToasShow.showToastCenter(getActivity(), getString(R.string.check_we));
                        return;
                    }

                    break;
                case R.id.cancelButton:
                    acountPopupWindow.dismiss();
                    break;
            }
        }
    };

    private void logOut() {
        //先取消上次的微信授权
        UMShareAPI.get(getActivity()).deleteOauth(getActivity(), SHARE_MEDIA.WEIXIN, null);

        //清除用户数据
        SharedPreferencesHelps.clearUserID();
        SharedPreferencesHelps.getCompanyId();
        SharedPreferencesHelps.cleaAccount();
        SharedPreferencesHelps.clearUserPassword();
        ActivitySkip.forward(getActivity(), LoginActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
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
            String access_token = data.get("access_token");
            SharedPreferencesHelps.setOpenId(openId);

            Log.e("data***", "openId:" + openId + "\naccess_token:" + access_token);


            getWeiXinInfo(access_token, openId);


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ToasShow.showToastBottom(getActivity(), t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            // ToasShow.showToastBottom(getActivity(), "已取消授权");
        }
    };


    /**
     * 获取微信用户信息  unionid
     *
     * @param access_token
     * @param opendid
     */
    public void getWeiXinInfo(String access_token, final String opendid) {
        EasyHttp.get("https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + access_token +
                "&openid=" + opendid).timeStamp(true).cacheMode(CacheMode.DEFAULT).headers
                ("Cache-Control", "max-age=0").execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();

            }

            @Override
            public void onError(ApiException e) {

                Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                try {
                    JSONObject UseJson = new JSONObject(json);
                    if (!TextUtils.isEmpty(UseJson.optString("unionid"))) {
                        sendBindAccount(opendid, UseJson.optString("unionid"));
                    } else {
                        ToasShow.showToastCenter(getContext(), getString(R.string.binding_f));
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void sendBindAccount(String openId, String unionid) {
        EasyHttp.post(Contants.BINDING_THIRD)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("type", "wechat")
                .params("openid", openId)
                .params("unionid", unionid)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        dismissLoadingDialog();
                        ToasShow.showToastCenter(getActivity(), e.getMessage());
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        dismissLoadingDialog();
                        try {
                            JSONObject json = new JSONObject(s);
                            ToasShow.showToastCenter(getActivity(), json.getString("msg"));
                            if (json.getString("code").equals("1")) {
                                logOut();
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
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_me);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), 0, null);
        initWidget();
    }

    private void initWidget() {

        //注册事件
        EventBus.getDefault().register(this);
        tvQr = getViewById(R.id.tvQr);
        relCertificate = getViewById(R.id.relCertificate);

        rlCommission = getViewById(R.id.rlCommission);
        tvDepositCount = getViewById(R.id.tvDepositCount);
        rlCommission.setOnClickListener(mOnClickListener);
        rlTeam = getViewById(R.id.rlTeam);
        saleRecord = getViewById(R.id.saleRecord);
        rlTeam.setOnClickListener(mOnClickListener);
        ivCustomePhoto = getViewById(R.id.ivCustomePhoto);
        rlSetting = getViewById(R.id.rlSetting);
        rlSetting.setOnClickListener(mOnClickListener);
        changePassWordRel = getViewById(R.id.changePassWordRel);
        bindAccountRel = getViewById(R.id.bindAccountRel);
        tvUserName = getViewById(R.id.tvCustomeName);
        tvUserName.setText(SharedPreferencesHelps.getSurName() + "  " + SharedPreferencesHelps
                .getFirstName() + "\n" + "ID: " + SharedPreferencesHelps.getUserID());
        acountPopupWindow = new BindAcountPopupWindow(getActivity(), mItemClick);

        if (Integer.parseInt(SharedPreferencesHelps.getDeposit_num()) > 0) {
            tvDepositCount.setVisibility(View.VISIBLE);
            tvDepositCount.setText(SharedPreferencesHelps.getDeposit_num());
        } else {
            tvDepositCount.setVisibility(View.GONE);
        }

        if (!SharedPreferencesHelps.getUserImage().equals("null")) {
            Picasso.with(getActivity()).load(Contants.DOMAIN + "/" + SharedPreferencesHelps
                    .getUserImage()).
                    config(Bitmap.Config.RGB_565).error(R.mipmap.settingbt).placeholder(R.mipmap
                    .settingbt).fit().into(ivCustomePhoto);
        } else {
            ivCustomePhoto.setImageDrawable(getResources().getDrawable(R.mipmap.settingbt));
        }

        saleEOI = getViewById(R.id.saleEOI);
        saleEOI.setOnClickListener(mOnClickListener);


        //销售
        if (SharedPreferencesHelps.getType() == 1) {
            saleRecord.setVisibility(View.VISIBLE);
            rlTeam.setVisibility(View.VISIBLE);
            saleEOI.setVisibility(View.VISIBLE);

            //推荐人
        } else if (SharedPreferencesHelps.getType() == 2) {
            saleRecord.setVisibility(View.GONE);
            rlTeam.setVisibility(View.GONE);
            saleEOI.setVisibility(View.GONE);

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        tvUserName = getViewById(R.id.tvCustomeName);
        ivCustomePhoto = getViewById(R.id.ivCustomePhoto);
        rlTeam = getViewById(R.id.rlTeam);
        saleRecord = getViewById(R.id.saleRecord);
        saleEOI = getViewById(R.id.saleEOI);

        tvUserName.setText(SharedPreferencesHelps.getSurName() + "  " + SharedPreferencesHelps
                .getFirstName() + "\n" + "ID: " + SharedPreferencesHelps.getUserID());


        //销售
        if (SharedPreferencesHelps.getType() == 1) {
            saleRecord.setVisibility(View.VISIBLE);
            rlTeam.setVisibility(View.VISIBLE);
            saleEOI.setVisibility(View.VISIBLE);

            //推荐人
        } else if (SharedPreferencesHelps.getType() == 2) {
            saleRecord.setVisibility(View.GONE);
            rlTeam.setVisibility(View.GONE);
            saleEOI.setVisibility(View.GONE);

        }

        if (!SharedPreferencesHelps.getUserImage().equals("null")) {
            Picasso.with(getActivity()).load(Contants.DOMAIN + "/" + SharedPreferencesHelps
                    .getUserImage()).
                    config(Bitmap.Config.RGB_565).error(R.mipmap.settingbt).placeholder(R.mipmap
                    .settingbt).fit().into(ivCustomePhoto);
        } else {
            ivCustomePhoto.setImageDrawable(getResources().getDrawable(R.mipmap.settingbt));
        }

    }

    @Override
    protected void setListener() {
        changePassWordRel.setOnClickListener(mOnClickListener);
        bindAccountRel.setOnClickListener(mOnClickListener);
        saleRecord.setOnClickListener(mOnClickListener);
        relCertificate.setOnClickListener(mOnClickListener);
        tvQr.setOnClickListener(mOnClickListener);
        ivCustomePhoto.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }

    public String getVersion() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            String version = info.versionName;
            return "Ver: " + version;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNumEvent(Message message) {
        Log.e("TAG", "mefragment: " + message.arg1);
        if (message.arg1 > 0) {
            Log.e("TAG", "mefragmentnum: " + SharedPreferencesHelps.getDeposit_num());
            tvDepositCount.setVisibility(View.VISIBLE);
            tvDepositCount.setText(message.arg1 + "");

        } else {
            tvDepositCount.setVisibility(View.GONE);
        }

    }

}
