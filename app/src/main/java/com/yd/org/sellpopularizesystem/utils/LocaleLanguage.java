package com.yd.org.sellpopularizesystem.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import com.yd.org.sellpopularizesystem.activity.HomeActivity;

import java.util.Locale;

/**
 * Created by e-dot on 2017/11/17.
 */

public class LocaleLanguage {


    public static void getLocaleLanguage(Activity mActivity) {

        String LAN = SharedPreferencesHelps.getLanguage();
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Log.e("语言————————", language);
        if (!language.equals("")) {
            if (!LAN.equals(language)) {
                freshView(mActivity);//重新启动HomeActivity

            }
        }
        showLanguage(language, mActivity);

    }

    /**
     * 设置语言
     *
     * @param language
     */
    public static void showLanguage(String language, Activity mActivity) {
        //设置应用语言类型
        Resources resources = mActivity.getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (language.equals("zh")) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        } else if (language.equals("ko")) {
            config.locale = Locale.ENGLISH;
        } else {
            config.locale = Locale.ENGLISH;
        }
        Log.e("language", "language::::" + language);
        resources.updateConfiguration(config, dm);
        //保存设置语言的类型
        SharedPreferencesHelps.setLanguage(language);
    }

    /**
     * 重新启动,更新系统语言
     */
    public static void freshView(Activity mActivity) {
        Intent intent = new Intent(mActivity, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mActivity.startActivity(intent);

    }

}
