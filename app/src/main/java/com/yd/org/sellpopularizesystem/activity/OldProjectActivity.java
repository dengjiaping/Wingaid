package com.yd.org.sellpopularizesystem.activity;

import android.view.View;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;

import java.util.List;

public class OldProjectActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {

    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private TextView noInfomation;
    private String space = "", search_key = "", price = "", house = "", area = "", cate_id = "";
    private List<ProductListBean.ResultBean> productData ;
    @Override
    protected int setContentView() {
        return R.layout.activity_old_project;


    }


    @Override
    public void initView() {
        setTitle(getString(R.string.old_pr));
        hideRightImagview();
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);


        noInfomation = getViewById(R.id.noInfomation);
        /*noInfomation.setVisibility(View.VISIBLE);
        ptrl.setVisibility(View.GONE);*/
       // getProductListData(true, page, space, price, house, area);
    }

    private void getProductListData(boolean b, int page, String space, String price, String house, String area) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        page = 1;
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);

    }
}
