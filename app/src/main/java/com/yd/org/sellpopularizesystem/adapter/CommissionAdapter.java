package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.CommissionActivity;
import com.yd.org.sellpopularizesystem.activity.InvoiceActivity;
import com.yd.org.sellpopularizesystem.activity.OrderDetailActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.CommissionsBean;
import com.yd.org.sellpopularizesystem.javaBean.InvoiceDetailBean;
import com.yd.org.sellpopularizesystem.javaBean.SaleOrderBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-dot on 2017/5/2.
 */

public class CommissionAdapter extends BaseAdapter {
    private List<CommissionsBean.ResultBean.DatasBean> datas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mLayou;
    private int temp = 0;

    public CommissionAdapter(Context mContext) {
        this.mContext = mContext;
        this.mLayou = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    public void addMore(List<CommissionsBean.ResultBean.DatasBean> data) {
        this.datas.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoler viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHoler();
            convertView = mLayou.inflate(R.layout.commission_item, null);
            viewHolder.commissionID = (TextView) convertView.findViewById(R.id.commissionID);
            viewHolder.titleCommission = (TextView) convertView.findViewById(R.id.titleCommission);
            viewHolder.sumCommission = (TextView) convertView.findViewById(R.id.sumCommission);

            viewHolder.commissionRel = (RelativeLayout) convertView.findViewById(R.id.commissionRel);
            viewHolder.commissionLinear = (LinearLayout) convertView.findViewById(R.id.commissionLinear);
            viewHolder.rlFirstCommisstion = (RelativeLayout) convertView.findViewById(R.id.rlFistCommisstion);
            viewHolder.rlSecondCommisstion = (RelativeLayout) convertView.findViewById(R.id.rlSecondCommisstion);
            viewHolder.rlThirdCommisstion = (RelativeLayout) convertView.findViewById(R.id.rlThirdCommisstion);

            viewHolder.firstCommissionSum = (TextView) convertView.findViewById(R.id.firstCommissionSum);
            viewHolder.firstCommissionDate = (TextView) convertView.findViewById(R.id.firstCommissionDate);
            viewHolder.secondCommissionSum = (TextView) convertView.findViewById(R.id.secondCommissionSum);
            viewHolder.secondCommissionDate = (TextView) convertView.findViewById(R.id.secondCommissionDate);
            viewHolder.thirdCommissionSum = (TextView) convertView.findViewById(R.id.thirdCommissionSum);
            viewHolder.thirdCommissionDate = (TextView) convertView.findViewById(R.id.thirdCommissionDate);

            viewHolder.nameCommission = (TextView) convertView.findViewById(R.id.nameCommission);


            viewHolder.commissionRightImageView = (ImageView) convertView.findViewById(R.id.commissionRightImageView);
            viewHolder.moreImageView = (ImageView) convertView.findViewById(R.id.moreImageView);


            //发票个数
            viewHolder.notifText = (TextView) convertView.findViewById(R.id.notifText);

            //是否查看
            viewHolder.firstView = convertView.findViewById(R.id.firstView);
            viewHolder.secondView = convertView.findViewById(R.id.secondView);
            viewHolder.thirdView = convertView.findViewById(R.id.thirdView);


            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHoler) convertView.getTag();
        }


        viewHolder.resultBean = datas.get(position);


        try {

            if (!TextUtils.isEmpty(datas.get(position).getProduct_name())) {
                //项目名称
                viewHolder.titleCommission.setText(datas.get(position).getProduct_name() + "  / " + datas.get(position).getProduct_childs_unit_number());

            } else {
                //项目名称
                viewHolder.titleCommission.setText("- " + datas.get(position).getProduct_childs_unit_number());

            }


            //订单号
            viewHolder.commissionID.setText(mContext.getString(R.string.order_id) + ":" + datas.get(position).getOrder_id() + " / " + MyUtils.date2String("yyyy/MM/dd", Long.parseLong(viewHolder.resultBean.getUpdate_time() + "000")));


            //总金额
            String total = datas.get(position).getTotal();

            if (total.contains(".")) {
                viewHolder.sumCommission.setText(MyUtils.addComma(total.split("\\.")[0]) + "." + total.split("\\.")[1]);
            } else {
                viewHolder.sumCommission.setText(MyUtils.addComma(total));
            }


            //sale_id拿钱的人 user_id下单的人
            if (viewHolder.resultBean.getSale_id() != viewHolder.resultBean.getUser_id()) {
                viewHolder.nameCommission.setVisibility(View.VISIBLE);
                viewHolder.nameCommission.setText(viewHolder.resultBean.getUser_surname() + " " + viewHolder.resultBean.getUser_first_name());
            } else {
                viewHolder.nameCommission.setVisibility(View.GONE);
            }


            //消息数
            if (viewHolder.resultBean.getInvoice_number() > 0) {
                viewHolder.notifText.setVisibility(View.VISIBLE);
                viewHolder.notifText.setText(viewHolder.resultBean.getInvoice_number() + "");
            } else {
                viewHolder.notifText.setVisibility(View.GONE);
            }


            //佣金1是否显示红点
            if (viewHolder.resultBean.getFirst_invoice_status() == 1) {
                viewHolder.firstView.setVisibility(View.VISIBLE);
                viewHolder.rlFirstCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            } else {
                viewHolder.firstView.setVisibility(View.GONE);
            }

            //佣金2是否显示红点
            if (viewHolder.resultBean.getSecond_invoice_status() == 1) {
                viewHolder.secondView.setVisibility(View.VISIBLE);
                viewHolder.rlSecondCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            } else {
                viewHolder.secondView.setVisibility(View.GONE);
            }

            //佣金3是否显示红点
            if (viewHolder.resultBean.getThird_invoice_status() == 1) {
                viewHolder.thirdView.setVisibility(View.VISIBLE);
                viewHolder.rlThirdCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            } else {
                viewHolder.thirdView.setVisibility(View.GONE);
            }

            //佣金1是否可点击
            if (viewHolder.resultBean.getOne_invoice_status() != 4) {
                viewHolder.rlFirstCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            }
            //佣金2是否可点击
            if (viewHolder.resultBean.getTwo_invoice_status() != 4) {
                viewHolder.rlSecondCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            }
            //佣金3是否可点击
            if (viewHolder.resultBean.getThree_invoice_status() != 4) {
                viewHolder.rlThirdCommisstion.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
            }
            //佣金1已发放
            if (viewHolder.resultBean.getFirst_status() == 1) {
                viewHolder.firstCommissionSum.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
                //viewHolder.firstCommissionDate.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
            } else {
                viewHolder.firstCommissionSum.setTextColor(mContext.getResources().getColor(R.color.gray));
                //viewHolder.firstCommissionDate.setTextColor(mContext.getResources().getColor(R.color.gray));
            }


            //佣金2已发放
            if (viewHolder.resultBean.getSecond_status() == 1) {
                viewHolder.secondCommissionSum.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
                //viewHolder.secondCommissionDate.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
            } else {
                viewHolder.secondCommissionSum.setTextColor(mContext.getResources().getColor(R.color.gray));
                //viewHolder.secondCommissionDate.setTextColor(mContext.getResources().getColor(R.color.gray));
            }


            //佣金3已发放
            if (viewHolder.resultBean.getThird_status() == 1) {
                viewHolder.thirdCommissionSum.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
                //viewHolder.thirdCommissionDate.setTextColor(mContext.getResources().getColor(R.color.scale_tab5));
            } else {
                viewHolder.thirdCommissionSum.setTextColor(mContext.getResources().getColor(R.color.gray));
                // viewHolder.thirdCommissionDate.setTextColor(mContext.getResources().getColor(R.color.gray));
            }


            //佣金1
            viewHolder.firstCommissionSum.setText(add(viewHolder.resultBean.getFirst_money(), viewHolder.resultBean.getFirst_gst()));

            if (viewHolder.resultBean.getFirst_status() == 1) {

                if (null == viewHolder.resultBean.getFirst_time() + "" || TextUtils.isEmpty(viewHolder.resultBean.getFirst_time() + "")) {
                    viewHolder.firstCommissionDate.setText("-");
                } else {

                    viewHolder.firstCommissionDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(viewHolder.resultBean.getFirst_time() + "000")));
                }
            } else {
                viewHolder.firstCommissionDate.setText("-");
            }
            //佣金2
            viewHolder.secondCommissionSum.setText(add(viewHolder.resultBean.getSecond_money(), viewHolder.resultBean.getSecond_gst()));


            if (viewHolder.resultBean.getSecond_status() == 1) {


                if (null == viewHolder.resultBean.getSecond_time() + "" || TextUtils.isEmpty(viewHolder.resultBean.getSecond_time() + "")) {
                    viewHolder.secondCommissionDate.setText("-");
                } else {
                    viewHolder.secondCommissionDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(viewHolder.resultBean.getSecond_time() + "000")));
                }


            } else {
                viewHolder.secondCommissionDate.setText("-");
            }

            //佣金3
            viewHolder.thirdCommissionSum.setText(add(viewHolder.resultBean.getThird_money(), viewHolder.resultBean.getThird_gst()));


            if (viewHolder.resultBean.getThird_status() == 1) {


                if (null == viewHolder.resultBean.getThird_time() + "" || TextUtils.isEmpty(viewHolder.resultBean.getThird_time() + "")) {
                    viewHolder.thirdCommissionDate.setText("-");
                } else {
                    viewHolder.thirdCommissionDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(viewHolder.resultBean.getThird_time() + "000")));
                }

            } else {
                viewHolder.thirdCommissionDate.setText("-");
            }


            //查看订单
            if (null == viewHolder.resultBean.getOrder_id() + "" || TextUtils.isEmpty(viewHolder.resultBean.getOrder_id() + "")) {
                viewHolder.commissionRightImageView.setVisibility(View.GONE);
            } else {
                viewHolder.commissionRightImageView.setVisibility(View.VISIBLE);
                viewHolder.commissionRightImageView.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));

            }


            viewHolder.commissionRel.setOnClickListener(new OnClick(viewHolder.resultBean, viewHolder.moreImageView, viewHolder.commissionLinear));
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    private String add(String str1, String str2) {

        try {
            BigDecimal bd1 = BigDecimal.valueOf(Double.parseDouble(str1));
            BigDecimal bd2 = BigDecimal.valueOf(Double.parseDouble(str2));
            String value = String.valueOf(bd1.add(bd2).doubleValue());

            if (value.contains(".")) {
                return MyUtils.addComma(value.split("\\.")[0]) + "." + value.split("\\.")[1];
            } else {
                return MyUtils.addComma(value);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";

    }

    class OnClick implements View.OnClickListener {
        private ImageView imageView;
        private LinearLayout linearLayout;
        private CommissionsBean.ResultBean.DatasBean resultBean;


        public OnClick(CommissionsBean.ResultBean.DatasBean resultBean, ImageView imageView, LinearLayout linearLayout) {
            this.imageView = imageView;
            this.linearLayout = linearLayout;
            this.resultBean = resultBean;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {


                //右边按钮事件
                case R.id.commissionRightImageView:

                    SaleOrderBean.ResultBean bean = new SaleOrderBean.ResultBean();
                    bean.setProduct_orders_id(Integer.parseInt(resultBean.getOrder_id() + ""));

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("order", bean);
                    ActivitySkip.forward(CommissionActivity.commissionActivity, OrderDetailActivity.class, bundle);
                    break;


                //查看更多
                case R.id.commissionRel:

                    if (temp == 0) {
                        linearLayout.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.mipmap.more_top);
                        temp = 1;
                    } else {
                        linearLayout.setVisibility(View.GONE);
                        imageView.setImageResource(R.mipmap.more);
                        temp = 0;
                    }

                    break;
                case R.id.rlFistCommisstion:
                    getDepositDetails(resultBean, "1");
                    break;

                case R.id.rlSecondCommisstion:
                    getDepositDetails(resultBean, "2");
                    break;

                case R.id.rlThirdCommisstion:
                    getDepositDetails(resultBean, "3");
                    break;
            }
        }
    }

    private void getDepositDetails(final CommissionsBean.ResultBean.DatasBean resultBean, final String step) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());
        httpParams.put("commossion_id", resultBean.getId() + "");
        httpParams.put("step", step);
        EasyHttp.get(Contants.DEPOSIT_DETAILS)
                .timeStamp(true)//是否需要追加时间戳
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .params(httpParams)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        ToasShow.showToast(mContext, mContext.getResources().getString(R.string.network_error));
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("TAG", "onSuccess: " + json);
                        jsonParse(json, resultBean, step);
                    }
                });

    }

    private void jsonParse(String json, CommissionsBean.ResultBean.DatasBean resultBean, String step) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            if ((jsonObject.getInt("code")) == 0 || jsonObject.get("code").equals("0")) {
                ToasShow.showToastCenter(mContext, jsonObject.getString("msg"));
                return;
            } else {
                if ((jsonObject.getInt("code")) == 1) {

                    Gson gson = new Gson();
                    InvoiceDetailBean detailBean = gson.fromJson(json, InvoiceDetailBean.class);
                    InvoiceDetailBean.ResultBean rb = detailBean.getResult();

                    Bundle bun = new Bundle();
                    bun.putSerializable("bean", rb);
                    bun.putString("for", jsonObject.getJSONObject("result").getString("for"));


                    if (step.equals("1")) {
                        bun.putString("status", resultBean.getOne_invoice_status() + "");
                    } else if (step.equals("2")) {
                        bun.putString("status", resultBean.getTwo_invoice_status() + "");
                    } else {
                        bun.putString("status", resultBean.getThree_invoice_status() + "");
                    }

                    ActivitySkip.forward(CommissionActivity.commissionActivity, InvoiceActivity.class, bun);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public class ViewHoler {
        private TextView notifText, commissionID, nameCommission,
                titleCommission, sumCommission, firstCommissionSum, firstCommissionDate, secondCommissionSum, secondCommissionDate, thirdCommissionSum, thirdCommissionDate;
        private RelativeLayout commissionRel, rlFirstCommisstion, rlSecondCommisstion, rlThirdCommisstion;
        private LinearLayout commissionLinear;
        private ImageView commissionRightImageView, moreImageView;
        public CommissionsBean.ResultBean.DatasBean resultBean;
        private View firstView, secondView, thirdView;

    }
}
