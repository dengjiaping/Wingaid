package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.CustomeActivity;
import com.yd.org.sellpopularizesystem.activity.HomeActivity;
import com.yd.org.sellpopularizesystem.activity.LearningGardenActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.javaBean.HomeDataBean;
import com.yd.org.sellpopularizesystem.myView.Gradient;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/4/10.
 */

public class HomeFragment extends BaseFragmentView {
    public static HomeFragment homeFragment;
    private RelativeLayout rlBefore;
    private LinearLayout saleLinearLayyout, customLinerLayout, studyLinearLayout;
    private TextView tvNotCompleteCount;
    private Gradient homeGradient;
    private List<ImageView> imageViews = new ArrayList<>();
    private HomeDataBean homeDataBean;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //销售推广
                case R.id.saleLinearLayyout:
                    SharedPreferencesHelps.setProjectStatus("new");
                    Bundle bundle = new Bundle();
                    bundle.putString(ExtraName.SCALETOCUSTOME, ExtraName.SCALETOCUSTOME);
                    ActivitySkip.forward(getActivity(), CustomeActivity.class, bundle);
                    getActivity().overridePendingTransition(R.anim.downtoup_in_anim, 0);
                    break;
                //客户管理
                case R.id.customLinerLayout:
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(ExtraName.SCALETOCUSTOME, ExtraName.TOCUSTOME);
                    ActivitySkip.forward(getActivity(), CustomeActivity.class, bundle2);
                    break;
                //学习园地
                case R.id.studyLinearLayout:
                    Bundle bundle3 = new Bundle();
                    if (homeDataBean != null) {
                        bundle3.putString("studynum", homeDataBean.getResult().getTotal_study() + "");
                        bundle3.putString("unchecknum", homeDataBean.getResult().getUncheck() + "");
                    } else {
                        bundle3.putString("studynum", 0 + "");
                    }
                    ActivitySkip.forward(getActivity(), LearningGardenActivity.class, bundle3);
                    break;
                //往期项目
                case R.id.rlBefore:
                    SharedPreferencesHelps.setProjectStatus("old");
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(ExtraName.SCALETOCUSTOME, ExtraName.OLDPROTOCUSTOME);
                    ActivitySkip.forward(getActivity(), CustomeActivity.class, bundle4);
                    getActivity().overridePendingTransition(R.anim.downtoup_in_anim, 0);
                    break;
            }
        }
    };

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    getHomeData();
                    break;

            }
        }
    };


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.home_fragment);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), 0, null);
        homeFragment = this;
        //注册事件
        EventBus.getDefault().register(this);
        initWidget();
        getHomeData();
        getDepositData();

    }


    @Override
    public void onResume() {
        super.onResume();
        //唤醒界面的时候加载数据,用于准确的更新消息
        getHomeData();
    }


    private void initWidget() {
        //消息管理
        rlBefore = getViewById(R.id.rlBefore);
        //资料
        saleLinearLayyout = getViewById(R.id.saleLinearLayyout);
        //客户管理
        customLinerLayout = getViewById(R.id.customLinerLayout);
        //学习园地
        studyLinearLayout = getViewById(R.id.studyLinearLayout);
        tvNotCompleteCount = getViewById(R.id.tvNotCompleteCount);

        //渐变动画
        // homeGradient = getViewById(R.id.homeGradient);

        //初始化imageview
//        ImageView imageView = new ImageView(getActivity());
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView.setImageResource(R.mipmap.homebg);

//        ImageView imageViewOne = new ImageView(getActivity());
//        imageViewOne.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageViewOne.setImageResource(R.mipmap.home);

        //添加要渐变的ImageView
//        imageViews.add(imageView);
//        imageViews.add(imageViewOne);
//        //设置ImageView集合
//        homeGradient.setImageViews(imageViews);


    }

    @Override
    protected void setListener() {
        rlBefore.setOnClickListener(mOnClickListener);
        saleLinearLayyout.setOnClickListener(mOnClickListener);
        customLinerLayout.setOnClickListener(mOnClickListener);
        studyLinearLayout.setOnClickListener(mOnClickListener);
    }


    private void getHomeData() {

        EasyHttp.get(Contants.HOME_DAA)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .execute(new SimpleCallBack<String>() {
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

                            Gson gson = new Gson();
                            homeDataBean = gson.fromJson(json, HomeDataBean.class);
                            if (homeDataBean.getCode() == 1) {
                                tvNotCompleteCount.setVisibility(View.INVISIBLE);
                                //如果首次进去有消息条数.则通知显示
                                if (homeDataBean.getResult().getUnread() > 0) {

                                    Message message = new Message();
                                    message.what = 1;
                                    message.arg1 = homeDataBean.getResult().getUnread();


                                    //通知主页面显示消息条目
                                    HomeActivity.homeActiviyt.handler.sendMessage(message);
                                    //通知App icon显示未读消息
                                    // BadgeUtil.setBadgeCount(getActivity(), homeDataBean.getResult().getUnread());

                                } else {
                                    Message message = new Message();
                                    message.what = 1;
                                    message.arg1 = 0;
                                    //通知主页面显示消息条目
                                    HomeActivity.homeActiviyt.handler.sendMessage(message);
                                    //清楚消息,
                                    // BadgeUtil.resetBadgeCount(getActivity());
                                }

                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void getDepositData() {
        EasyHttp.get(Contants.DEPOSIT_DAA)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .execute(new SimpleCallBack<String>() {
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
                            JSONObject jsonObject = new JSONObject(json);
                            if (jsonObject.getString("code").equals("1")) {
                                int num = jsonObject.getInt("result");
                                SharedPreferencesHelps.setDeposit_num(String.valueOf(num));
                                Message message = new Message();
                                message.what = 2;
                                message.arg1 = num;
                                EventBus.getDefault().post(message);
                                //通知主页面显示消息条目
                                HomeActivity.homeActiviyt.handler.sendMessage(message);
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
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100)
    public void onMoonEvent(String message) {
        Log.e("TAG", "onMoonEvent: " + message);
        if (message.equals("ok")) {
            getDepositData();
        }

    }
}
