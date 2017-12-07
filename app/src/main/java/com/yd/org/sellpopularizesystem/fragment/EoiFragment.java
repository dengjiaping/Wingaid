package com.yd.org.sellpopularizesystem.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CommonAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ViewHolder;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.EoiBean;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/11/13.
 */

public class EoiFragment extends BaseFragmentView implements PullToRefreshLayout.OnRefreshListener {
    private int cate_id, page = 1;
    private PullToRefreshLayout ptrl;
    private PullableListView listView;
    private List<EoiBean.ResultBean> eoiList = new ArrayList<>();
    private CommonAdapter eoiAdapter;
    private String eoi_ID = "";
    private PopupWindow firbSelectPopWindow;
    private Button btUnknown, btSure, btFalse;
    private View firbPwView;
    //select代表从哪里来,customerID
    private String select, customerID;


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_notific);
        initViews();
    }

    private void initViews() {
        cate_id = getArguments().getInt("cate_id");
        select = getArguments().getString("select");
        customerID = getArguments().getString("customerID");
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);
        showZh();
        getEOIData(1, true);
    }

    private void getEOIData(int page, final boolean isRefresh) {


        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());//销售id／need);

        if (select.equals("me")) {
            httpParams.put("customer_id", "");//客户id / need ／销售id、客户id、productid必有其一
        } else {
            httpParams.put("customer_id", customerID + "");//客户id / need ／销售id、客户id、productid必有其一

        }

        //httpParams.put("project_id", "");//项目id / need / 销售id、客户id、productid必有其一
        httpParams.put("type", cate_id + "");//eoi状态 / optional   默认 0 ／ 0：待处理 1:未使用 2：已使用 3：已退款
        //httpParams.put("sort", "1");//返回结果按eoi申请时间排序 / optional  默认 0 ／0：最新的在前 1：最新的在后
        httpParams.put("page", page + "");
        httpParams.put("number", "100");

        EasyHttp.get(Contants.EOI_LIST).cacheMode(CacheMode.DEFAULT).headers("Cache-Control",
                "max-age=0").
                timeStamp(true).params(httpParams).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                showLoadingDialog();
            }

            @Override
            public void onError(ApiException e) {
                dismissLoadingDialog();
                Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess", "onSuccess:" + json);

                dismissLoadingDialog();

                try {

                    Gson gson = new Gson();
                    EoiBean eoiBean = gson.fromJson(json, EoiBean.class);
                    eoiList = eoiBean.getResult();


                    if (isRefresh) {

                        if (eoiList.size() == 0) {
                            getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);
                        } else {
                            getViewById(R.id.noInfomation).setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                        }


                        eoiAdapter = new CommonAdapter<EoiBean.ResultBean>(getActivity(), eoiList, R
                                .layout.eoi_item_layout) {

                            @Override
                            public void convert(ViewHolder holder, EoiBean.ResultBean item) {

                                //销售名
                                holder.setText(R.id.eoiID, "EOI ID:" + item.getEoi_id());

                                //销售名
                                holder.setText(R.id.tvCusName, ": " + item.getCustomer_info().getSurname()
                                        + " " + item.getCustomer_info().getFirst_name());
                                //标题
                                holder.setText(R.id.tvProjectName, " " + item.getProduct_info().getProduct_name());
                                holder.setText(R.id.tvUnitNum, ": " + item.getProduct_childs_info().getProduct_childs_unit_number());

                                //支付方式：1、现金   2、信用卡   3、直接存款    4、转账    5、支票  6、支付宝  7、微信 9、其他
                                if (item.getPay_method() == 6 || item.getPay_method() == 7) {
                                    holder.setText(R.id.eoi_moeny, "¥ " + "2000.00");
                                } else {
                                    holder.setText(R.id.eoi_moeny, "$ " + "300.00");
                                }


                                // 0:已充值，待审核    1：审核成功，排队中  2：已使用  3：退款中  4：退款成功   5:财务审核拒绝   6已确认


                                //eoi状态 / optional  默认 0 ／ 0：待处理 1:未使用 2：已使用 3：已退款
                                if (item.getPay_info().getEoi_money_status() == 0) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.pending));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.apply_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getAdd_time() +
                                                    "000")));
                                } else if (item.getPay_info().getEoi_money_status() == 1) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.unused));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.apply_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));
                                } else if (item.getPay_info().getEoi_money_status() == 2) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.used));
                                    holder.setText(R.id.tvTime, getString(R.string.used_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));


                                } else if (item.getPay_info().getEoi_money_status() == 3) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.refing));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.ref_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));

                                } else if (item.getPay_info().getEoi_money_status() == 4) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.refunded));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.refunded_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));

                                } else if (item.getPay_info().getEoi_money_status() == 5) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.refused));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.refused_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));


                                } else if (item.getPay_info().getEoi_money_status() == 6) {
                                    holder.setText(R.id.tvState, getResources().getString(R.string.confirmed));
                                    holder.setText(R.id.tvTime, getResources().getString(R.string.confirmed_time) + MyUtils.date2String
                                            ("yyyy/MM/dd", Long.parseLong(item.getCheck_time() +
                                                    "000")));


                                }
                            }
                        };

                        listView.setAdapter(eoiAdapter);
                    } else {
                        eoiAdapter.addMore(eoiList);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();

                }

            }
        });


    }

    /**
     * 申请退款
     */
    private void showZh() {
        firbPwView = LayoutInflater.from(getContext()).inflate(R.layout.firb_popuwindow, null);
        RelativeLayout rlFirb = (RelativeLayout) firbPwView.findViewById(R.id.rlFirb);
        btUnknown = (Button) firbPwView.findViewById(R.id.btUnknown);
        btUnknown.setVisibility(View.GONE);
        btSure = (Button) firbPwView.findViewById(R.id.btSure);
        btSure.setText(getString(R.string.eoi_refund));
        btFalse = (Button) firbPwView.findViewById(R.id.btFalse);
        btFalse.setText(getString(R.string.cancel));
        firbSelectPopWindow = new PopupWindow(firbPwView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        firbSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable firb = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        firbSelectPopWindow.setBackgroundDrawable(firb);
        rlFirb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
                cancel_eoi(eoi_ID);
            }
        });

        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });


    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EoiBean.ResultBean eoilistBean = (EoiBean.ResultBean) eoiAdapter.getItem(position);
                eoi_ID = eoilistBean.getEoi_id() + "";


                //如果是未使用可以退款
                if (eoilistBean.getPay_info().getEoi_money_status() == 0 || eoilistBean.getPay_info().getEoi_money_status() == 1 || eoilistBean.getPay_info().getEoi_money_status() == 5) {
                    firbSelectPopWindow.showAtLocation(getActivity().findViewById(R.id.flContent)
                            , Gravity.BOTTOM, 0, 0);
                }
            }
        });
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
    public static EoiFragment getInstnce(int cate_id, String select, String customerID) {
        EoiFragment eoiFragmen = new EoiFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cate_id", cate_id);
        bundle.putString("select", select);
        bundle.putString("customerID", customerID);
        eoiFragmen.setArguments(bundle);
        return eoiFragmen;
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getEOIData(page, true);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        page++;
        getEOIData(page, false);
    }

    /**
     * 退款
     *
     * @param eoi_id
     */
    private void cancel_eoi(String eoi_id) {

        EasyHttp.get(Contants.EOI_REFUND).cacheMode(CacheMode.NO_CACHE).params("eoi_id", eoi_id)
                .timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                showLoadingDialog();
            }

            @Override
            public void onError(ApiException e) {
                dismissLoadingDialog();
                Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess***", "UserBean:" + json);
                dismissLoadingDialog();
                if (!TextUtils.isEmpty(json)) {

                    try {
                        Gson gson = new Gson();
                        ErrorBean userBean = gson.fromJson(json, ErrorBean.class);
                        ToasShow.showToastCenter(getActivity(), userBean.getMsg());
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }


                }


            }
        });


    }
}
