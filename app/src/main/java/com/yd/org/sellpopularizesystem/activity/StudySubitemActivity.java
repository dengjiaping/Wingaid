package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.StyudyAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.StudyBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

public class StudySubitemActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private List<StudyBean.ResultBean> productData = new ArrayList<>();
    private StyudyAdapter adapter;
    private TextView tvNoMessage;
    private String type_id;

    @Override
    protected int setContentView() {
        return R.layout.activity_study_subitem;
    }

    @Override
    public void initView() {
        hideRightImagview();
        //下拉加载
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);
        tvNoMessage = getViewById(R.id.noInfomation);
        type_id = getIntent().getExtras().getString("type_id");

        Log.e("type_id***", "type_id:" + type_id);
        if (type_id.equals("6")) {
            //玩转平台
            setTitle(R.string.playplatform);
            getStudyListData(true, page, type_id);
            //成功原理
        } else if (type_id.equals("5")) {
            setTitle(R.string.successlaw);
            getStudyListData(true, page, type_id);

            //基础知识
        } else if (type_id.equals("3")) {
            setTitle(R.string.basic_konwledge);
            getStudyListData(true, page, type_id);
        } else if (type_id.equals("4")) {
            //销售秘籍
            setTitle(R.string.sales_techniques);
            getStudyListData(true, page, type_id);
        } else if (type_id.equals("1")) {
            //项目
            setTitle(R.string.project);
            getStudyListData(true, page, type_id);
        }
    }

    private void getStudyListData(final boolean b, int page, String type_id) {
        EasyHttp.get(Contants.STUDY_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("type_id", type_id)
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

                        closeDialog();
                        jsonParse(json, b);
                    }
                });


    }

    private void jsonParse(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            StudyBean product = gson.fromJson(json, StudyBean.class);
            if (product.getCode().equals("1")) {
                productData = product.getResult();

            }
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }


        if (isRefresh) {

            if (productData.size() == 0) {
                tvNoMessage.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else {
                tvNoMessage.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }


            adapter = new StyudyAdapter(StudySubitemActivity.this);
            listView.setAdapter(adapter);
        }

        adapter.addData(productData);

    }

    @Override
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StyudyAdapter.HolderView holderView = (StyudyAdapter.HolderView) view.getTag();
                StudyBean.ResultBean resultBean = holderView.productListBean;

                if (resultBean.getCan_study() == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("study", resultBean);
                    ActivitySkip.forward(StudySubitemActivity.this, StudyDetailaActivity.class, bundle);
                }

            }
        });
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getStudyListData(true, page, type_id);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getStudyListData(false, page, type_id);
    }
}
