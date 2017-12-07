package com.yd.org.sellpopularizesystem.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;

import java.util.Locale;

public class RegisterAgreementActivity extends BaseActivity {
    private String docPath = Environment.getExternalStorageDirectory().getPath();//"/mnt/sdcard/documents/"
    private String docName = "agreetment.doc";
    private String savePath = Environment.getExternalStorageDirectory().getPath();

    @Override
    protected int setContentView() {
        setTitle(getString(R.string.agreement));
        hideRightImagview();
        return R.layout.activity_register_agreement;
    }

    @Override
    public void initView() {
        Log.e("TAG", "initView: "+docPath+"-"+savePath);
        //WebView加载显示本地html文件
        WebView webView = (WebView)this.findViewById(R.id.wvAgreetment);
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        webSettings.setSupportZoom(true);//支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
       // webView.loadUrl("file:/"+savePath+name+".html");
        //根据语言判断是否重启HomeActivity
        String LAN = SharedPreferencesHelps.getLanguage();
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        if (!language.equals("")) {
            Log.e("TAG", "initView: "+"*****"+language );
            if (language.equals("zh")) {
                Log.e("TAG", "zh: "+"*****"+language );
               // freshView();//重新启动HomeActivity
                webView.loadUrl("file:///android_asset/AgreementCN.html");
            }else if (language.equals("en")){
                Log.e("TAG", "en: "+"*****"+language );
                webView.loadUrl("file:///android_asset/AgreementEN.html");
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        //根据语言判断是否重启HomeActivity
        String LAN = SharedPreferencesHelps.getLanguage();
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Log.e("语言————————", language);
        if (!language.equals("zh")) {
            if (!LAN.equals(language)) {
               // freshView();//重新启动HomeActivity

            }
        }
       // showLanguage(language);

    }

    private void showLanguage(String language) {
        //设置应用语言类型
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (language.equals("zh")) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        } else {
            config.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(config, dm);
        //保存设置语言的类型
        SharedPreferencesHelps.setLanguage(language);
    }

    /**
     * 重新启动,更新系统语言
     */
    private void freshView() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }



    @Override
    public void setListener() {

    }
}
