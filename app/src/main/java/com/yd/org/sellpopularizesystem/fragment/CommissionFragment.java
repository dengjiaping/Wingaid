package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CommissionAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.CommissionsBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/11/10.
 */

public class CommissionFragment extends BaseFragmentView implements PullToRefreshLayout
        .OnRefreshListener {
    private int cate_id, page = 1;
    private List<CommissionsBean.ResultBean> datas = new ArrayList<>();
    private PullToRefreshLayout ptrl;
    private PullableListView listView;
    private CommissionAdapter commissionAdapter;
    private LinearLayout nitLinear;

    private TextView tvTotalMoney, tvSureSum, tvUnsureSum;

    public  static CommissionFragment sCommissionFragment;


    @Override
    protected void initView(Bundle savedInstanceState) {

        setContentView(R.layout.fragment_notific);
        sCommissionFragment=this;
        initViews();
    }

    private void initViews() {


        //金额
        tvTotalMoney = getViewById(R.id.tvTotalMoney);
        tvSureSum = getViewById(R.id.tvSureSum);
        tvUnsureSum = getViewById(R.id.tvUnsureSum);


        cate_id = getArguments().getInt("cate_id");
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);

        nitLinear = getViewById(R.id.nitLinear);
        nitLinear.setVisibility(View.GONE);


        //getInfo(1, true, cate_id);
        getInfo(1, true);
    }

//    private void getInfo(int i, final boolean isRefresh, int cate_id) {
//        EasyHttp.get(Contants.COMMOSSION_LIST).
//                cacheMode(CacheMode.DEFAULT)
//                .headers("Cache-Control", "max-age=0")
//                .timeStamp(true).params("sale_id", SharedPreferencesHelps.getUserID())//销售的id
//                .params("type", cate_id + "")//佣金类型 / optional default 0 / 0:所有佣金 1:个人佣金 2： 领导拥金
//                .params("page", page + "")
//                .params("number", "100")
//                .execute(new SimpleCallBack<String>() {
//                    @Override
//                    public void onStart() {
//                        super.onStart();
//                        showLoadingDialog();
//
//                    }
//
//                    @Override
//                    public void onError(ApiException e) {
//                        dismissLoadingDialog();
//                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(String json) {
//                        dismissLoadingDialog();
//                        paserJSON(json, isRefresh);
//
//                    }
//                });
//
//    }

    private void getInfo(int page, final boolean isRefresh) {
        EasyHttp.get(Contants.COMMOSSION_LIST).cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("customer_id", "")
                .params("page", page + "")
                .params("number", "100").execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                showLoadingDialog();
            }

            @Override
            public void onError(ApiException e) {
                dismissLoadingDialog();
            }

            @Override
            public void onSuccess(String json) {
                dismissLoadingDialog();
                paserJSON(json, isRefresh);
            }
        });

    }


    private void paserJSON(String json, boolean isRefresh) {
        CommissionsBean commission = null;

        try {
            Gson s = new Gson();
            commission = s.fromJson(json, CommissionsBean.class);
            if (commission.getCode() == 1) {
                datas = commission.getResult();
            }
            if (isRefresh) {

                if (datas.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    //设置金额
                    //  tvTotalMoney.setText(commission.getResult().getAmount() + "");
                    // tvSureSum.setText(commission.getResult().getChecked() + "");
                    //tvUnsureSum.setText(commission.getResult().getUnchecked() + "");


                    //初始化ListView
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);


                }
                commissionAdapter = new CommissionAdapter(getActivity());
                listView.setAdapter(commissionAdapter);
            }

            if (commissionAdapter != null) {
                if (datas.size() > 0) {
                    commissionAdapter.addMore(datas);
                }
            }


        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    /**
     * 创建实体类
     *
     * @param cate_id
     * @return
     */
    public static CommissionFragment getInstnce(int cate_id) {
        CommissionFragment notificFragmen = new CommissionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cate_id", cate_id);
        notificFragmen.setArguments(bundle);
        return notificFragmen;
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        //getInfo(page, true, cate_id);
        getInfo(page, true);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        // getInfo(page, false, cate_id);
        getInfo(page, false);

    }

}
