package com.yd.org.sellpopularizesystem.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/2/23.
 * <p/>
 * 集中要常用的activity跳转
 */
public class ActivitySkip {


    /**
     * 跳转至某activity
     *
     * @param cls
     */
    public static void forward(Activity activity, Class<?> cls) {
        forward(activity, cls, null, -1);
    }

    /**
     * 带参跳转至某activity
     *
     * @param cls
     * @param bundle
     */
    public static void
    forward(Activity activity, Class<?> cls, Bundle bundle) {
        forward(activity, cls, bundle, -1);
    }

    /**
     * 带参和Intent.FLAG跳转至某activity
     *
     * @param cls
     * @param bundle
     * @param flags
     */
    public static void forward(Activity activity, Class<?> cls, Bundle bundle, int flags) {
        if (cls == null) {
            return;
        }
        Intent intent = new Intent(activity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (flags > 0) {
            intent.addFlags(flags);
        }
        activity.startActivity(intent);
    }

    public static void forward(Activity activity, Class<?> cls,  int flags) {
        if (cls == null) {
            return;
        }
        Intent intent = new Intent(activity, cls);
        if (flags > 0) {
            intent.addFlags(flags);
        }
        activity.startActivity(intent);
    }

    /**
     * 带参和Intent.FLAG跳转至某activity
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public static void forward(Activity activity, Class<?> cls, int requestCode, Bundle bundle) {
        if (cls == null) {
            return;
        }
        Intent intent = new Intent(activity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, requestCode);
    }


}
