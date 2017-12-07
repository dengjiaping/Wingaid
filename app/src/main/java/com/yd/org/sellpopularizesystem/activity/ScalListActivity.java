package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.ScaleListItemAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.javaBean.ScaleListBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户推广
 */
public class ScalListActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private ProductListBean.ResultBean resultBean;
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private List<ScaleListBean.ResultBean> baseData = new ArrayList<>();
    private ScaleListItemAdapter scaleListItemAdapter;

    @Override
    protected int setContentView() {
        return R.layout.activity_scal_list;
    }

    @Override
    public void initView() {
        hideRightImagview();

        Bundle bundle = getIntent().getExtras();
        resultBean = (ProductListBean.ResultBean) bundle.getSerializable("scale");

        Log.e("resultBean**", "resultBean:" + resultBean.getAddress());
        setTitle(resultBean.getProduct_name());


        //下拉加载
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);
        listView.setDividerHeight(0);

        getProductListData(true, page);

    }

    private void getProductListData(final boolean boool, int page) {

        EasyHttp.get(Contants.SCALE_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("product_name", resultBean.getProduct_name())
                .params("provice", resultBean.getProvice())
                .params("city", resultBean.getCity())
                .params("town", resultBean.getTown())
                .params("address", resultBean.getAddress())
                .params("bedroom", "")
                .params("bathroom", "")
                .params("price", "0-100000000")
                .params("car_space", "")
                .params("has_study", "")
                .params("ensuite", "")
                .params("internal", "0-100000000")
                .params("external", "0-100000000")
                .params("building_area", "0-100000000")
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
                        jsonParse(json, boool);
                    }
                });


    }

    private void jsonParse(String json, boolean isRefresh) {


        try {
            Gson gson = new Gson();
            ScaleListBean product = gson.fromJson(json, ScaleListBean.class);
            if (product.getCode().equals("1")) {
                baseData = product.getResult();
            }
            if (isRefresh) {

                scaleListItemAdapter = new ScaleListItemAdapter(ScalListActivity.this);
                listView.setAdapter(scaleListItemAdapter);
            }
            scaleListItemAdapter.addData(baseData);

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void setListener() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivitySkip.forward(ScalListActivity.this, ScaleDeltaileActivity.class);
            }
        });
    }

    /**
     * 上下拉相关
     *
     * @param pullToRefreshLayout
     */
    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        // 千万别忘了告诉控件刷新完毕了哦！
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getProductListData(true, page);


    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        // 千万别忘了告诉控件刷新完毕了哦！

        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getProductListData(false, page);

    }

}
