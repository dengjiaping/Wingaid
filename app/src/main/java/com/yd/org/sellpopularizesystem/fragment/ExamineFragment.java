package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.ExamineAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.ExamlineBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bai on 2017/1/19.
 */

public class ExamineFragment extends BaseFragmentView implements PullToRefreshLayout.OnRefreshListener {
    public static ExamineFragment examineFragment;
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private List<ExamlineBean.ResultBean> productData = new ArrayList<>();
    private ExamineAdapter adapter;
    private TextView tvNoMessage;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                getStudyListData(true, page);
            }
        }
    };


    @Override
    protected void initView(Bundle savedInstanceState) {
        examineFragment = this;
        setContentView(R.layout.activity_study_subitem);
        initView();
        getStudyListData(true, page);

    }

    private void initView() {
        //下拉加载
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        tvNoMessage = getViewById(R.id.noInfomation);
        listView = getViewById(R.id.content_view);
        listView.setDividerHeight(10);

    }

    private void getStudyListData(final boolean b, int page) {
        EasyHttp.get(Contants.CHECK_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("page", String.valueOf(page))
                .params("number", "100")
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
                        jsonParse(json, b);
                    }
                });

    }

    private void jsonParse(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            ExamlineBean product = gson.fromJson(json, ExamlineBean.class);
            if (product.getCode().equals("1")) {
                productData = product.getResult();
            }
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }


        if (isRefresh) {
            adapter = new ExamineAdapter(getActivity());
            listView.setAdapter(adapter);
        }

        adapter.addData(productData);

    }


    @Override
    protected void setListener() {


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getStudyListData(true, page);

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getStudyListData(false, page);

    }
}
