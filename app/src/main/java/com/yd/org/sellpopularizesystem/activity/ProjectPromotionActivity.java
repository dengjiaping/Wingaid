package com.yd.org.sellpopularizesystem.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CommonAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ViewHolder;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectPromotionActivity extends BaseActivity {
    private LinearLayout llAll;
    private TextView tvHotSale, tvLookHouse, tvMore, tvBuildingNum;
    private GridView gvHouse;
    private CommonAdapter mCommonAdapter;
    private List<ProductListBean.ResultBean> productData = new ArrayList<>();
    private List<ProductListBean.ResultBean> promoteDatas = new ArrayList<>();
    private String space = "", price = "", house = "", area = "";
    private ImageView backImageView;


    @Override
    protected int setContentView() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        return R.layout.activity_project_promotion;
    }

    @Override
    public void initView() {

        hideBaseTab();
        backImageView = (ImageView) findViewById(R.id.backImageView);
        llAll = (LinearLayout) findViewById(R.id.llAll);
        tvBuildingNum = (TextView) findViewById(R.id.tvBuildingNum);
        tvHotSale = (TextView) findViewById(R.id.tvHotSale);
        tvLookHouse = (TextView) findViewById(R.id.tvLookHouse);
        tvMore = (TextView) findViewById(R.id.tvMore);
        gvHouse = (GridView) findViewById(R.id.gvHouse);

        getProductListData(true, space, price, house, area);

    }


    @Override
    public void setListener() {
        llAll.setOnClickListener(mOnClickListener);
        tvHotSale.setOnClickListener(mOnClickListener);
        tvLookHouse.setOnClickListener(mOnClickListener);
        tvMore.setOnClickListener(mOnClickListener);

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        gvHouse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductListBean.ResultBean item = (ProductListBean.ResultBean) mCommonAdapter
                        .getItem(position);

                if (item.getIs_can_sale() != null && item.getIs_can_sale().equals("1")) {

                    //对应的学习项目
                    ToasShow.showToastCenter(ProjectPromotionActivity.this, getString(R.string
                            .sale_toas) + item.getProduct_name());
                    Bundle bundle = new Bundle();
                    bundle.putString("type_id", String.valueOf(item.getStudy_type_id()));
                    ActivitySkip.forward(ProjectPromotionActivity.this, StudySubitemActivity
                            .class, bundle);

                } else {

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bean", item);
                    bundle.putString("productName", item.getProduct_name());
                    bundle.putString("productId", item.getProduct_id() + "");
                    ActivitySkip.forward(ProjectPromotionActivity.this, ProductItemDetailActivity
                            .class, bundle);
                }


            }
        });

    }


    private void getProductListData(final boolean boool, String space, String price, String
            house, String area) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());
        httpParams.put("page", String.valueOf(1));
        httpParams.put("number", "500");
        httpParams.put("cate_id", area);
        httpParams.put("search_key", "");
        httpParams.put("area", "");
        httpParams.put("house", house);
        httpParams.put("space", space);
        httpParams.put("price", price);
        httpParams.put("is_hot_sale", "");
        httpParams.put("is_promote", "");
        httpParams.put("is_old_product", "1");
        EasyHttp.get(Contants.PRODUCT_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params(httpParams)
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

                        jsonParse(json, boool);
                    }
                });


    }

    private void jsonParse(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            ProductListBean product = gson.fromJson(json, ProductListBean.class);
            if (product.getCode().equals("1")) {
                productData = product.getResult();
                if (product.getTotal_number() == 0) {
                    tvBuildingNum.setVisibility(View.GONE);
                } else {
                    tvBuildingNum.setVisibility(View.VISIBLE);
                    tvBuildingNum.setText(product.getTotal_number() + "");
                }

            }

            if (productData.size() > 0) {
                for (int i = 0; i < productData.size(); i++) {
                    if (productData.get(i).getIs_promote() == 1) {
                        promoteDatas.add(productData.get(i));
                    }
                    if (promoteDatas.size() == 6) {
                        break;
                    }
                }
            }


            setAdapter();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();

            Log.e("解析异常", "e:" + e.getMessage());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void setAdapter() {
        mCommonAdapter = new CommonAdapter<ProductListBean.ResultBean>(ProjectPromotionActivity
                .this, promoteDatas, R.layout.gv_item_house_suggest) {
            @Override
            public void convert(ViewHolder holder, ProductListBean.ResultBean item) {

                Log.e("Agent", "AgentNotes:" + item.getAgent_notes());


                try {

                    if (null != item.getAgent_notes() && !TextUtils.isEmpty(item.getAgent_notes())) {
                        holder.setLinear_Gone(R.id.agentsLin);
                        double agents = Integer.parseInt(item.getAgent_notes());
                        int agentsSize = (int) Math.ceil(agents / 0.5);
                        if (agentsSize > 7) {
                            agentsSize = 7;
                        }
                        for (int i = 0; i < agentsSize; i++) {

                            //每0.5显示一颗星星
                            ImageView imageView = new ImageView(ProjectPromotionActivity.this);
                            imageView.setImageResource(R.mipmap.agents);
                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            imageView.setPadding(4, 4, 4, 4);
                            holder.addLinearView(R.id.agentsLin, imageView);

                        }


                    } else {
                        holder.setLinear_Gone(R.id.agentsLin);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    holder.setLinear_Gone(R.id.agentsLin);
                    Log.e("异常处理", "e:" + e.getMessage());

                }


                try {

                    holder.setText(R.id.tvName, item.getProduct_name());
                    holder.setText(R.id.tvLocation, item.getState() + "-" + item.getAddress_suburb());

                    if (null != item.getIs_can_sale() && item.getIs_can_sale().equals("1")) {
                        holder.getView(R.id.ivIslock).setVisibility(View.VISIBLE);
                    } else {
                        holder.getView(R.id.ivIslock).setVisibility(View.GONE);
                    }


                    holder.setImageByUrl(R.id.ivHousePic, Contants.DOMAIN + "/" + item.getThumb());

                    if (null != item.getChilds().get(0).getMin_price() || !TextUtils.isEmpty(item
                            .getChilds().get(0).getMin_price())) {
                        holder.setText(R.id.tvHousePrice, getString(R.string.totalprice) + "$" +

                                MyUtils.addComma(String.valueOf(Math.ceil(Double.parseDouble(item
                                        .getChilds().get(0).getMin_price())) / 1000).split("\\.")[0])
                                + "k" +
                                getString(R.string.perset));
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


            }

        };

        gvHouse.setAdapter(mCommonAdapter);
    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //所有楼盘
                case R.id.llAll:
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "all");
                    bundle.putSerializable("data", (Serializable) productData);
                    ActivitySkip.forward(ProjectPromotionActivity.this, ScaleActivity.class,
                            bundle);
                    break;
                //热销
                case R.id.tvHotSale:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("type", "hot");
                    bundle1.putSerializable("data", (Serializable) productData);
                    ActivitySkip.forward(ProjectPromotionActivity.this, ScaleActivity.class,
                            bundle1);
                    break;
                //地图找房
                case R.id.tvLookHouse:
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("data", (Serializable) productData);
                    ActivitySkip.forward(ProjectPromotionActivity.this, MapActivity.class, bundle2);
                    break;
                //更多
                case R.id.tvMore:
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("type", "promote");
                    bundle3.putSerializable("data", (Serializable) productData);
                    ActivitySkip.forward(ProjectPromotionActivity.this, ScaleActivity.class,
                            bundle3);
                    break;
            }
        }
    };


    private void showAlertDialog() {
        new AlertDialog.Builder(ProjectPromotionActivity.this)
                .setMessage(R.string.exit_scale)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除推广记录数据
                        SharedPreferencesHelps.clearTime();
                        SharedPreferencesHelps.clearData();
                        finish();
                    }
                }).setNegativeButton(R.string.cancel, null).create().show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showAlertDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

}
