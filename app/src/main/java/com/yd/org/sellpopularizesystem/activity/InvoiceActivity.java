
package com.yd.org.sellpopularizesystem.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.InvoiceDetailBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 发票
 */

public class InvoiceActivity extends BaseActivity {
    private TextView consentTextView, resoluteTextView, subButton, tvInvoiceNo, tvAbn, tvPhone, tvAddress, tvTotal, tvAccountName,
            tvDate, tvBillTO, tvAcn, tvAbcPtyLtd, tvFor, tvDescription, tvAmountIncl, tvSubtotal, tvGst, tvOtherGST, tvSubtotalGST, tvAbnRegisterd, tvOther,
            tvFinalDes, tvStatus, tvBsb, tvAccountNum;
    private EditText moneyEdit, memoEdit;
    private RelativeLayout rlFirb;
    private View firbPwView;
    private PopupWindow firbSelectPopWindow;


    private String memoString;


    private InvoiceDetailBean.ResultBean rb;
    private String status;
    private String moneyString;


    @Override
    protected int setContentView() {
        return R.layout.activity_invoice;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getString(R.string.invoice));

        consentTextView = getViewById(R.id.consentTextView);
        resoluteTextView = getViewById(R.id.resoluteTextView);
        tvInvoiceNo = getViewById(R.id.tvInvoiceNo);
        tvStatus = getViewById(R.id.tvStatus);
        tvAbn = getViewById(R.id.tvAbn);
        tvPhone = getViewById(R.id.tvPhone);
        tvAddress = getViewById(R.id.tvAddress);
        tvDate = getViewById(R.id.tvDate);
        tvBillTO = getViewById(R.id.tvBillTO);
        tvAcn = getViewById(R.id.tvAcn);
        tvAbcPtyLtd = getViewById(R.id.tvAbcPtyLtd);
        tvFor = getViewById(R.id.tvFor);
        tvDescription = getViewById(R.id.tvDescription);
        tvAmountIncl = getViewById(R.id.tvAmountIncl);
        tvSubtotal = getViewById(R.id.tvSubtotal);
        tvGst = getViewById(R.id.tvGst);
        tvAbnRegisterd = getViewById(R.id.tvAbnRegisterd);
        tvOther = getViewById(R.id.tvOther);
        tvTotal = getViewById(R.id.tvTotal);
        tvAccountName = getViewById(R.id.accountName);
        tvFinalDes = getViewById(R.id.tvFinalDes);
        tvBsb = getViewById(R.id.tvBsb);
        tvAccountNum = getViewById(R.id.tvAccountNumber);

        tvOtherGST = getViewById(R.id.tvOtherGST);
        tvSubtotalGST = getViewById(R.id.tvSubtotalGST);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            rb = (InvoiceDetailBean.ResultBean) bundle.getSerializable("bean");
            status = bundle.getString("status");
            setInfo();
        }

        showReasonInfo();

    }

    private void setInfo() {
        try {


            tvInvoiceNo.setText(rb.getInvoice_no());
            tvAbcPtyLtd.setText(rb.getAccount_name());
            if (rb.getStatus() == 1) {
                tvStatus.setText("-");
            } else if (rb.getStatus() == 2) {
                tvStatus.setText("Accept");
            } else {
                tvStatus.setText("Reject");
            }

            tvAbn.setText(rb.getAbn() + "");
            tvPhone.setText(rb.getPhone() + "");
            tvAddress.setText(rb.getAddress() + "");
            tvDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(String.valueOf(rb.getDate()) + "000")));
            tvFor.setText(rb.getFors() + "");
            tvDescription.setText(rb.getDescription() + "");
            tvAmountIncl.setText(rb.getAmount() + "");
            tvSubtotal.setText(rb.getSubtotal() + "");
            tvAbnRegisterd.setText(rb.getIs_gst() == 1 ? "No" : "Yes");
            tvOther.setText(rb.getOther() + "");
            tvTotal.setText(rb.getTotal() + "");
            tvAccountName.setText(rb.getAccount_name() + "");
            tvFinalDes.setText(Html.fromHtml(getResources().getString(R.string.deposit_declare)));
            tvBsb.setText(rb.getBsb() + "");
            tvAccountNum.setText(rb.getAccount_number() + "");
            if (!status.equals("1")) {
                getViewById(R.id.invoiceBottomLinear).setVisibility(View.GONE);
            } else {
                getViewById(R.id.invoiceBottomLinear).setVisibility(View.VISIBLE);
            }
            tvGst.setText(rb.getGst() + "");

            tvOtherGST.setText(rb.getOther_gst() + "");
            tvSubtotalGST.setText(rb.getSubtotal_other() + "");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setListener() {
        consentTextView.setOnClickListener(mOnClick);
        resoluteTextView.setOnClickListener(mOnClick);
    }

    private View.OnClickListener mOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                //同意
                case R.id.consentTextView:
                    AgreeOrReject("2");
                    break;

                //拒绝
                case R.id.resoluteTextView:
                    firbSelectPopWindow.showAtLocation(InvoiceActivity.this.findViewById(R.id.primaryLinear), Gravity.BOTTOM, 0, 0);
                    break;
                default:
                    break;

            }
        }
    };

    private void AgreeOrReject(final String flag) {

        if (flag.equals("2")) {
            memoString = "";
            moneyString = "";
        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("invoice_id", rb.getInvoice_id() + "");//发票编号
        httpParams.put("status", flag);//2：同意  3：拒绝
        httpParams.put("sales_submit_amount", moneyString);//销售提交金额
        httpParams.put("reject_reason", memoString);//拒绝原因
        EasyHttp.post(Contants.APPROVE_OR_REFUSE_INVOICE)
                .timeStamp(true)//是否需要追加时间戳
                .params(httpParams)
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        ToasShow.showToast(InvoiceActivity.this, getResources().getString(R.string.network_error));
                    }

                    @Override
                    public void onSuccess(String s) {
                        closeDialog();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            ToasShow.showToastCenter(InvoiceActivity.this, jsonObject.getString("msg"));
                            if (flag.equals("2")) {
                                EventBus.getDefault().post("ok");
                            }
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    private void showReasonInfo() {
        firbPwView = LayoutInflater.from(this).inflate(R.layout.invoce_layout, null);
        rlFirb = (RelativeLayout) firbPwView.findViewById(R.id.mainRelat);

        //金额
        moneyEdit = (EditText) firbPwView.findViewById(R.id.moneyEdit);
        //备注
        memoEdit = (EditText) firbPwView.findViewById(R.id.memoEdit);
        subButton = (TextView) firbPwView.findViewById(R.id.subButton);

        firbSelectPopWindow = new PopupWindow(firbPwView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        firbSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable firb = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        firbSelectPopWindow.setBackgroundDrawable(firb);


        //提交数据
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // firbSelectPopWindow.dismiss();
                moneyString = moneyEdit.getText().toString().trim();
                memoString = memoEdit.getText().toString().trim();
                if (TextUtils.isEmpty(moneyString)) {
                    ToasShow.showToastCenter(InvoiceActivity.this, getString(R.string.input_money));
                    return;
                }

                if (TextUtils.isEmpty(memoString)) {
                    ToasShow.showToastCenter(InvoiceActivity.this, getString(R.string.reject_reason));
                    return;
                }
                firbSelectPopWindow.dismiss();
                AgreeOrReject("3");

            }
        });

        //点击外面取消
        rlFirb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });


    }


}
