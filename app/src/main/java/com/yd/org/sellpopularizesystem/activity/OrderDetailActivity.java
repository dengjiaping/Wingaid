package com.yd.org.sellpopularizesystem.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.OrderDetailBean;
import com.yd.org.sellpopularizesystem.javaBean.SaleOrderBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

public class OrderDetailActivity extends BaseActivity {
    TextView tvOrderDes, tvOrderNum, tvtype, tvFirb, tvSale, tvCus, tvCusAdd, tvLawyer, tvGoal, tvPrice, tvComplete, tvReason;

    @Override
    protected int setContentView() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getString(R.string.order_detail));
        SaleOrderBean.ResultBean saleOrderBean = (SaleOrderBean.ResultBean) getIntent().getExtras().get("order");
        initWidgets();
        if (saleOrderBean != null) {
            getOrderDetail(saleOrderBean.getProduct_orders_id());
        }
    }

    private void getOrderDetail(int product_orders_id) {
        EasyHttp.get(Contants.ORDER_DETAIL).cacheMode(CacheMode.DEFAULT).headers("Cache-Control", "max-age=0").timeStamp(true).params("order_id", product_orders_id + "").execute(new SimpleCallBack<String>() {
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

                try {

                    Gson gson = new Gson();
                    OrderDetailBean orderDetailBean = gson.fromJson(json, OrderDetailBean.class);
                    if (orderDetailBean.getCode().equals("1")) {
                        initData(orderDetailBean.getResult());
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    private void initData(OrderDetailBean.ResultBean result) {

        try {


            tvOrderNum.setText(result.getProduct_orders_id() + "");
            if (result.getProduct_info() != null) {
                if (result.getProduct_info().getCate_id() != 0) {
                    if (result.getProduct_info().getCate_id() == 1) {
                        tvtype.setText(getString(R.string.house_land));
                        tvOrderDes.setText(getString(R.string.house_land) + "-" + result.getProduct_name() + "-" + result.getProduct_info().getProduct_childs_unit_number());
                    } else if (result.getProduct_info().getCate_id() == 2) {
                        tvtype.setText(getString(R.string.land));
                        tvOrderDes.setText(getString(R.string.land) + "-" + result.getProduct_name() + "-" + result.getProduct_info().getProduct_childs_unit_number());
                    } else {
                        tvtype.setText(getString(R.string.apt));
                        tvOrderDes.setText(getString(R.string.apt) + "-" + result.getProduct_name() + "-" + result.getProduct_info().getProduct_childs_unit_number());
                    }

                }


                tvFirb.setText(result.getIs_firb() == 0 ? getString(R.string.yes) : getString(R.string.bushi));
                tvSale.setText(SharedPreferencesHelps.getSurName() + " " + SharedPreferencesHelps.getFirstName() + "");
                tvCus.setText(result.getCustomer_surname() + " " + result.getCustomer_first_name() + "");
                tvReason.setText(result.getCo_purchaser() + "");
                tvCusAdd.setText(result.getCustomer_info().getCountry() + getString(R.string.single_blank_space) + result.getCustomer_info().getProvince() + getString(R.string.single_blank_space) + result.getCustomer_info().getAddress() + getString(R.string.single_blank_space) + result.getCustomer_info().getZip_code());
                tvLawyer.setText(result.getLawyer_name() + "");
                tvGoal.setText(String.valueOf(result.getPurchaseReason() + ""));
                tvPrice.setText("$ " + MyUtils.addComma(result.getPrice().split("\\.")[0]));
            }
        } catch (NullPointerException e) {

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    private void initWidgets() {
        tvOrderDes = getViewById(R.id.tvOrderDes);
        tvOrderNum = getViewById(R.id.tvOrderNum);
        tvtype = getViewById(R.id.tvtype);
        tvFirb = getViewById(R.id.tvFirb);
        tvSale = getViewById(R.id.tvSale);
        tvCus = getViewById(R.id.tvCus);
        tvCusAdd = getViewById(R.id.tvCusAdd);
        tvLawyer = getViewById(R.id.tvLawyer);
        tvGoal = getViewById(R.id.tvGoal);
        tvPrice = getViewById(R.id.tvPrice);
        tvComplete = getViewById(R.id.tvComplete);
        tvReason = getViewById(R.id.tvReason);
    }

    @Override
    public void setListener() {
        tvComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
