package com.yd.org.sellpopularizesystem.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ReceiptBean;
import com.yd.org.sellpopularizesystem.javaBean.SaleOrderBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

public class DepositActivity extends BaseActivity {
    private TextView tvName, tvProperty, tvMoneyy, tvDown, edDate;
    private SaleOrderBean.ResultBean resultBean;


    @Override
    protected int setContentView() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getResources().getString(R.string.sale_list));
        resultBean = (SaleOrderBean.ResultBean) getIntent().getExtras().getSerializable("keys");
        tvName = getViewById(R.id.tvName);
        tvProperty = getViewById(R.id.tvProperty);
        tvMoneyy = getViewById(R.id.tvMoneyy);
        tvDown = getViewById(R.id.tvDown);
        edDate = getViewById(R.id.edDate);


        try {


            tvName.setText(resultBean.getCustomer_surname() + getString(R.string.single_blank_space) + resultBean.getCustomer_first_name());
            tvProperty.setText(resultBean.getProduct_name().getProduct_name() + "-" + resultBean.getProduct_info().getProduct_childs_lot_number() + "-" + resultBean.getProduct_info().getProduct_childs_unit_number());

            if (resultBean.getPayment_method() == 6 || resultBean.getPayment_method() == 7) {

                if (resultBean.getProduct_info().getCate_id() == 1) {
                    tvMoneyy.setText("￥" + getString(R.string.single_blank_space) + "1000.00");
                } else {
                    tvMoneyy.setText("￥" + getString(R.string.single_blank_space) + "2000.00");
                }


            } else {
                if (resultBean.getProduct_info().getCate_id() == 1) {
                    tvMoneyy.setText("$" + getString(R.string.single_blank_space) + "150.00");
                } else {
                    tvMoneyy.setText("$" + getString(R.string.single_blank_space) + "300.00");
                }

            }


            //落款时间
            edDate.setText(MyUtils.getInstance().date2String("yyyy/MM/dd", Long.parseLong(resultBean.getAdd_time() + "000")));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void getInfo() {

        EasyHttp.get(Contants.RECEIPT_INFO)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("order_id", resultBean.getProduct_orders_id() + "")
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        ToasShow.showToast(DepositActivity.this, getResources().getString(R.string.network_error));
                    }

                    @Override
                    public void onSuccess(String json) {
                        closeDialog();


                        try {
                            Gson gs = new Gson();
                            ReceiptBean receiptBean = gs.fromJson(json, ReceiptBean.class);
                            if (receiptBean.getCode().equals("1")) {
                                tvName.setText(receiptBean.getResult().getUser_name());
                                tvProperty.setText(receiptBean.getResult().getProduct());
                                tvMoneyy.setText(receiptBean.getResult().getNumber());
                                //落款时间
                                edDate.setText(MyUtils.getInstance().date2String("dd/MM/yyyy", Long.parseLong(receiptBean.getResult().getCheck_time() + "000")));

                            } else {
                                ToasShow.showToastCenter(DepositActivity.this, receiptBean.getMsg());
                            }

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    @Override
    public void setListener() {

        tvDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    //截取真个屏幕
                    //View decorView = getWindow().getDecorView();
                    //截取部分view
                    View decorView = getViewById(R.id.mainRelat);
                    Bitmap screenBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(screenBitmap);
                    decorView.draw(canvas);

                    //保存图片的相册
                    String uriString = MediaStore.Images.Media.insertImage(getContentResolver(), screenBitmap, "收据:" + System.currentTimeMillis(), "收据截图");
                    if (!TextUtils.isEmpty(uriString)) {
                        ToasShow.showToastBottom(DepositActivity.this, getResources().getString(R.string.save_suss));
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }


}
