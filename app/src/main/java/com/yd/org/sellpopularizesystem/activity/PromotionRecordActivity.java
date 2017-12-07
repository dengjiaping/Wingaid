package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.PromotionRecordAdapter;
import com.yd.org.sellpopularizesystem.adapter.PromotionRecordAdapter_Pr;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.PromotionRecord;
import com.yd.org.sellpopularizesystem.javaBean.PromotionRecordBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;


/**
 * 推广记录
 */
public class PromotionRecordActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private Bundle bundle;
    private String flag;
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private CustomBean.ResultBean resultBean;
    private List<PromotionRecordBean.ResultBean> datas = new ArrayList<>();
    private List<PromotionRecord.ResultBean> prDatas = new ArrayList<>();
    private PromotionRecordAdapter pradapter;
    private PromotionRecordAdapter_Pr promotionRecordAdapter_pr;
    private LinearLayout saleRecprdRel;
    private String cacheKey = "";

    @Override
    protected int setContentView() {
        return R.layout.activity_promotion_record;
    }

    @Override
    public void initView() {
        hideRightImagview();
        //接收数据
        bundle = getIntent().getExtras();
        flag = bundle.getString("custocora");
        resultBean = (CustomBean.ResultBean) bundle.getSerializable("customer_id");

        //下拉加载
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);


        saleRecprdRel = getViewById(R.id.saleRecprdRel);


        //推广记录
        if (flag.equals("custoexpand")) {
            cacheKey = this.getClass().getSimpleName() + "1";
            saleRecprdRel.setVisibility(View.VISIBLE);
            setTitle(getString(R.string.expandre));
            getExpandReData(page, true);


            //购房记录
        } else if (flag.equals("custopurchase")) {
            cacheKey = this.getClass().getSimpleName() + "2";
            saleRecprdRel.setVisibility(View.GONE);
            setTitle(getString(R.string.housepurchase));
            getHouseurchase(page, true);

        }


    }

    @Override
    public void setListener() {

    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        if (flag.equals("custoexpand")) {
            getExpandReData(page, true);
        } else {
            getHouseurchase(page, true);
        }


    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        if (flag.equals("custoexpand")) {
            getExpandReData(page, false);

            //购房记录
        } else {
            getHouseurchase(page, false);
        }


    }

    private void getExpandReData(int page, final boolean isRefresh) {
        EasyHttp.get(Contants.SALE_LOG_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", "")
                .params("company_id", SharedPreferencesHelps.getCompanyId())
                .params("client", resultBean.getCustomer_id() + "")
                .params("page", String.valueOf(page))
                .params("status", "11")
                .params("number", "100")
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
                        Log.e("onSuccess**", "onSuccess:" + json);

                        closeDialog();
                        paseJSON(json, isRefresh);
                    }
                });


    }

    private void prPaseJson(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            PromotionRecord pb = gson.fromJson(json, PromotionRecord.class);

            if (pb.getCode() == 1) {
                prDatas = pb.getResult();
            }

            if (isRefresh) {
                if (prDatas.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }
                promotionRecordAdapter_pr = new PromotionRecordAdapter_Pr(PromotionRecordActivity.this);
                listView.setAdapter(promotionRecordAdapter_pr);
            }

            promotionRecordAdapter_pr.addMore(prDatas);

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void paseJSON(String json, boolean isRefresh) {
        try {

            Gson gson = new Gson();
            PromotionRecordBean pb = gson.fromJson(json, PromotionRecordBean.class);

            if (pb.getCode() == 1) {
                datas = pb.getResult();
            }

            if (isRefresh) {
                if (datas.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }

                pradapter = new PromotionRecordAdapter(PromotionRecordActivity.this);
                listView.setAdapter(pradapter);
            }

            pradapter.addMore(datas);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void getHouseurchase(int page, final boolean isRefresh) {
        EasyHttp.get(Contants.ORDER_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("company_id", SharedPreferencesHelps.getCompanyId())
                .params("client", resultBean.getCustomer_id() + "")
                .params("status", "11")
                .params("page", String.valueOf(page))
                .params("number", "100")
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
                        Log.e("onSuccess", "onSuccess:" + json);
                        closeDialog();
                        prPaseJson(json, isRefresh);
                    }
                });


    }
}