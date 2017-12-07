package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.permission.Acp;
import com.lidong.photopicker.permission.AcpListener;
import com.lidong.photopicker.permission.AcpOptions;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.SaleRecordAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.javaBean.SaleOrderBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 订单列表
 */
public class SaleRecordActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private PullableListView lvSaleRecord;
    private PullToRefreshLayout ptrlSaleRecord;
    private int page = 1;
    private List<SaleOrderBean.ResultBean> sobRbData = new ArrayList<>();
    private SaleRecordAdapter saleAdapter;
    public static SaleRecordActivity saleRecordActivity;
    //上传合同首页还是首付款标志
    private String flag;
    private SaleOrderBean.ResultBean rBean;
    private static final int REQUEST_CAMERA_CODE = 10;
    private ArrayList<String> imagePaths = new ArrayList<>();

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getSaleData(page, true);
        }
    };

    @Override
    protected int setContentView() {
        return R.layout.activity_sale_record;
    }

    @Override
    public void initView() {
        saleRecordActivity = this;
        hideRightImagview();
        setTitle(getString(R.string.sale_list));
        lvSaleRecord = getViewById(R.id.content_view);
        ptrlSaleRecord = getViewById(R.id.refresh_view);
        ptrlSaleRecord.setOnRefreshListener(this);
        //加载数据
        getSaleData(page, true);


    }


    private void getSaleData(int page, final boolean isRefresh) {
        EasyHttp.get(Contants.INQUIRE_ORDER_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("company_id", SharedPreferencesHelps.getCompanyId())
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("page", page + "")
                .params("number", "50")
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
                        parseJson(json, isRefresh);
                    }
                });


    }


    /**
     * 获取数据
     *
     * @param json
     * @param isRefresh
     */
    private void parseJson(String json, boolean isRefresh) {

        try {

            Gson gson = new Gson();
            SaleOrderBean saleOrderBean = gson.fromJson(json, SaleOrderBean.class);

            if (saleOrderBean.getCode() == 1) {
                sobRbData = saleOrderBean.getResult();

            }

            if (isRefresh) {
                if (sobRbData.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    lvSaleRecord.setVisibility(View.GONE);
                } else {
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    lvSaleRecord.setVisibility(View.VISIBLE);
                }

                saleAdapter = new SaleRecordAdapter(this);
                lvSaleRecord.setAdapter(saleAdapter);


            }
            if (saleAdapter != null) {
                saleAdapter.addMore(sobRbData);
            }
            locatedOrderIdPos();

        } catch (JsonSyntaxException e) {
            e.printStackTrace();

            getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
            lvSaleRecord.setVisibility(View.GONE);

            Log.e("解析异常", "e:" + e.getMessage());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void locatedOrderIdPos() {
        if (getIntent().getExtras() != null && getIntent().getExtras().getString("orderid") != null) {
            for (int i = 0; i < sobRbData.size(); i++) {
                if (sobRbData.get(i).getProduct_orders_id() == Integer.parseInt(getIntent().getExtras().getString("orderid"))) {
                    lvSaleRecord.setSelection(i);
                    Log.e("TAG", "initView: " + i);
                    return;
                }
            }
        }
    }


    public void startPhotos(SaleOrderBean.ResultBean resultBeans, String type) {
        rBean = resultBeans;
        flag = type;


        Acp.getInstance(SaleRecordActivity.this).request(new AcpOptions.Builder().setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                /*以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/.build(), new AcpListener() {
            @Override
            public void onGranted() {
                PhotoPickerIntent intent = new PhotoPickerIntent(SaleRecordActivity.this);
                intent.setSelectModel(SelectModel.SINGLE);
                intent.setShowCarema(true); // 是否显示拍照
                // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                startActivityForResult(intent, REQUEST_CAMERA_CODE);


            }

            @Override
            public void onDenied(List<String> permissions) {
                ToasShow.showToastCenter(SaleRecordActivity.this, permissions.toString() + "权限拒绝");
            }
        });

    }

    /**
     * 取消订单
     *
     * @param orderId
     */
    public void canceOrder(int orderId) {

        EasyHttp.post(Contants.ORDER_CANCEL).cacheMode(CacheMode.NO_CACHE).params("order_id", orderId + "").params("user_id", SharedPreferencesHelps.getUserID()).timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                showDialog();
            }

            @Override
            public void onError(ApiException e) {
                closeDialog();
                Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess***", "UserBean:" + json);
                closeDialog();


                try {

                    Gson gson = new Gson();
                    ErrorBean errorBean = gson.fromJson(json, ErrorBean.class);
                    if (errorBean.getCode().equals("1")) {
                        ToasShow.showToastCenter(SaleRecordActivity.this, errorBean.getMsg());
                    } else {
                        ToasShow.showToastCenter(SaleRecordActivity.this, errorBean.getMsg());
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    @Override
    public void setListener() {
        lvSaleRecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SaleRecordAdapter.ViewHolder viewHolder = (SaleRecordAdapter.ViewHolder) view.getTag();
                SaleOrderBean.ResultBean resultBean = viewHolder.resultBean;
                Bundle bundle = new Bundle();
                bundle.putSerializable("order", resultBean);
                ActivitySkip.forward(SaleRecordActivity.this, OrderDetailActivity.class, bundle);

            }
        });


    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrlSaleRecord.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getSaleData(page, true);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrlSaleRecord.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getSaleData(page, false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    loadAdpater(list);
                    break;

            }

        }

    }

    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        String picPath = imagePaths.get(0);
        setPicPath(picPath, rBean);

    }


    /**
     * 支付意向金
     *
     * @param resultBean
     */
    public void payMoney(SaleOrderBean.ResultBean resultBean) {
        Bundle bun = new Bundle();
        bun.putString("payurlId", resultBean.getOrder_money_url());
        bun.putString("payment_method", resultBean.getPayment_method() + "");
        ActivitySkip.forward(SaleRecordActivity.this, PaymentQrActivity.class, bun);

    }

    /**
     * 上传支付凭证
     *
     * @param picPath
     */
    private void setPicPath(String picPath, SaleOrderBean.ResultBean resultBean) {

        UIProgressResponseCallBack mUIProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {


            }
        };
        String strUrl = "";
        File picFile = null;

        HttpParams httpParams = new HttpParams();

        if (flag.equals("1")) {
            //合同首页
            strUrl = Contants.UPLOAD_CONTRACT_PHOTO;
            httpParams.put("order_id", resultBean.getProduct_orders_id() + "");
            if (null != picPath && !picPath.equals("")) {
                picFile = new File(picPath);
                httpParams.put("file", picFile, mUIProgressResponseCallBack);
            }


        } else {
            //支付房款-上传凭证或在线支付
            strUrl = Contants.UPLOAD_FIRST_COMMISSION;
            httpParams.put("order_id", resultBean.getProduct_orders_id() + "");
            httpParams.put("user_id", SharedPreferencesHelps.getUserID());
            httpParams.put("customer_id", resultBean.getClient() + "");
            if (null != picPath && !picPath.equals("")) {
                picFile = new File(picPath);
                httpParams.put("image[]", picFile, mUIProgressResponseCallBack);
            }
        }


        EasyHttp.post(strUrl).params(httpParams).cacheMode(CacheMode.NO_CACHE).params(httpParams).timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                showDialog();
            }

            @Override
            public void onError(ApiException e) {
                closeDialog();
                Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess***", "UserBean:" + json);
                closeDialog();


                try {

                    Gson gson = new Gson();
                    ErrorBean errorBean = gson.fromJson(json, ErrorBean.class);
                    if (errorBean.getCode().equals("1")) {
                        ToasShow.showToastCenter(SaleRecordActivity.this, getResources().getString(R.string.su));
                    } else {
                        ToasShow.showToastCenter(SaleRecordActivity.this, errorBean.getMsg());
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    public void askntractO(SaleOrderBean.ResultBean resultBeans, String type) {
        SaleRecordActivity.saleRecordActivity.startPhotos(resultBeans, type);
    }
}
