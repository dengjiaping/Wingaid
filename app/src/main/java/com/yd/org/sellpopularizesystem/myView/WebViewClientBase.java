package com.yd.org.sellpopularizesystem.myView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yd.org.sellpopularizesystem.R;

/**
 * Created by e-dot on 2017/5/15.
 */

public class WebViewClientBase extends WebViewClient {
    private CustomProgressDialog loading_Dialog;
    private Activity activity;
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();  // 接受所有网站的证书
        super.onReceivedSslError(view, handler, error);
    }

    public WebViewClientBase(Activity activity) {
        this.activity=activity;
        loading_Dialog = new CustomProgressDialog(activity, R.style.customLoadDialog);

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (!activity.isFinishing()) {
            loading_Dialog.show();
        }

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (!activity.isFinishing()) {
            loading_Dialog.dismiss();
        }
    }


}
