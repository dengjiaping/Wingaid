package com.yd.org.sellpopularizesystem.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.PayBean;
import com.yd.org.sellpopularizesystem.javaBean.WXpayBean;
import com.yd.org.sellpopularizesystem.utils.MD5Util;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.PayResult;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class PaymentQrActivity extends BaseActivity {

    private WebView wvQr;
    private String strId;
    private String qrcodeUrl, payment_method;
    private TextView tvPaymentMethod, payTextView;
    private String url, playUrl = "";


    public final String RESULTStatus = "9000";
    public final String RESULTStatus_FINSH = "8000";
    private IWXAPI api;
    private int code;
    private String des;
    /*****
     * 支付返回支付状态
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (msg.obj != null) {


                        PayResult payResult = new PayResult((String) msg.obj);
                        String resultStatus = payResult.getResultStatus();
                        Log.e("resultStatus***", "resultStatus:" + resultStatus);
                        // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                        if (!TextUtils.isEmpty(resultStatus) && resultStatus.equals(RESULTStatus)) {
                            ToasShow.showToastCenter(PaymentQrActivity.this, getString(R.string.pay_su));

                        } else {
                            // 判断resultStatus 为非“9000”则代表可能支付失败
                            // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                            if (TextUtils.equals(resultStatus, RESULTStatus_FINSH)) {
                                ToasShow.showToastCenter(PaymentQrActivity.this, getString(R.string.pay_fail));

                            } else {
                                ToasShow.showToastCenter(PaymentQrActivity.this, getString(R.string.pay_error));


                            }
                        }
                    }

                    break;

            }
        }
    };

    @Override
    protected int setContentView() {

        api = WXAPIFactory.createWXAPI(this, Contants.WEXIN_APP_ID);
        api.registerApp(Contants.WEXIN_APP_ID);

        return R.layout.activity_alipay_qr;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getString(R.string.payment));


        strId = getIntent().getExtras().getString("payurlId");
        payment_method = getIntent().getExtras().getString("payment_method");

        Log.e("strId**", "strId:" + strId + "payment_method:" + payment_method);
        wvQr = getViewById(R.id.wvQr);
        tvPaymentMethod = getViewById(R.id.tvPaymentMethod);
        payTextView = getViewById(R.id.payTextView);

        if (payment_method.equals("6")) {
            tvPaymentMethod.setText(R.string.scanalipayqr);
            url = Contants.ALIPAY_INTERFACE;
            playUrl = Contants.AIL_APPPAY;
        } else if (payment_method.equals("7")) {
            tvPaymentMethod.setText(R.string.scanalipayqrwx);
            url = Contants.WEICHAT_INTERFACE;
            playUrl = Contants.WXAPP_PAY;
        }
        getQrcodeUrl(strId);
    }

    private void getQrcodeUrl(String strId) {
        EasyHttp.post(url)
                .cacheMode(CacheMode.NO_CACHE)
                .params("trust_account_id", strId)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
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
                    public void onSuccess(String s) {


                        closeDialog();
                        try {
                            JSONObject json = new JSONObject(s);
                            code = Integer.parseInt(json.getString("code"));
                            des = json.getString("msg");
                            if (json.getString("code").equals("1")) {
                                qrcodeUrl = json.getString("qrcode");
                                MyUtils.getInstance().showWebView(PaymentQrActivity.this, wvQr, qrcodeUrl);
                                Log.e("WebViewe*", "qrcodeUrl:" + qrcodeUrl);
                            } else {
                                ToasShow.showToastCenter(PaymentQrActivity.this, json.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                });


    }

    @Override
    public void setListener() {
        payTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (code == 0) {
                    ToasShow.showToastCenter(PaymentQrActivity.this, des);
                    return;
                }
                //支付宝支付
                if (payment_method.equals("6")) {
                    goPay(strId);

                    //微信支付
                } else if (payment_method.equals("7")) {


                    //先判断是否安装微信
                    if (isWeixinAvilible(PaymentQrActivity.this)) {
                        goPay(strId);
                    } else {
                        ToasShow.showToastCenter(PaymentQrActivity.this, "检查是否安装微信");
                    }


                }


            }
        });
    }

    public boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 去付款
     */
    public void Payment(final String payInfo) {

        // 完整的符合支付宝参数规范的订单信息
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PaymentQrActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo);

                if (result != null && result.length() > 0) {
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                }

            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }


    /*****************微信支付*********/


    public void WeiXinPlay(WXpayBean wXpayBean) {
        if (api != null) {

            PayReq req = new PayReq();
            req.appId = Contants.WEXIN_APP_ID;
            req.partnerId = wXpayBean.getResult().getMch_id();
            req.prepayId = wXpayBean.getResult().getPrepay_id();
            req.packageValue = "Sign=WXPay";
            req.nonceStr = wXpayBean.getResult().getNonce_str();
            req.timeStamp = (System.currentTimeMillis() / 1000) + "";
            //***********
            // 把参数的值传进去SortedMap集合里面
            SortedMap<Object, Object> parameters = new TreeMap<>();
            parameters.put("appid", req.appId);
            parameters.put("noncestr", req.nonceStr);
            parameters.put("package", req.packageValue);
            parameters.put("partnerid", req.partnerId);
            parameters.put("prepayid", req.prepayId);
            parameters.put("timestamp", req.timeStamp);
            String mySign = createSign("UTF-8", parameters);
            req.sign = mySign;
            api.sendReq(req);


        }


    }


    /**
     * 微信支付签名算法sign
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    public static String createSign(String characterEncoding,
                                    SortedMap<Object, Object> parameters) {

        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + Contants.API_KEY); //KEY是商户秘钥
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
                .toUpperCase();
        return sign;
    }

    private void goPay(String strId) {
        EasyHttp.post(playUrl)
                .cacheMode(CacheMode.NO_CACHE)
                .params("trust_account_id", strId)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
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
                    public void onSuccess(String s) {


                        closeDialog();

                        try {

                            Gson gson = new Gson();
                            if (payment_method.equals("6")) {
                                PayBean payBean = gson.fromJson(s, PayBean.class);
                                if (payBean.getCode().equals("1")) {
                                    Payment(payBean.getResult());
                                }

                            } else if (payment_method.equals("7")) {
                                WXpayBean wXpayBean = gson.fromJson(s, WXpayBean.class);

                                if (wXpayBean.getCode().equals("1")) {

                                    if (wXpayBean.getResult().getResult_code().equals("FAIL")) {
                                        ToasShow.showToastCenter(PaymentQrActivity.this, getString(R.string.pay_error));
                                    } else {
                                        WeiXinPlay(wXpayBean);
                                    }

                                }
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }
}
