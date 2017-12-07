package com.yd.org.sellpopularizesystem.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by ${bai} on 17/2/9.
 */

public class ToasShow {


    /**
     * 顶部
     *
     * @param context 上下文
     * @param msg     提示文字
     */
    public static   void showToastTop(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    /**
     * 顶部（自定义位置）
     *
     * @param context 上下文
     * @param msg     提示文字
     * @param x       横向位置
     * @param y       纵向位置
     */
    public static void showToastTop(Context context, String msg, int x, int y) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, x, y);
        toast.show();
    }

    /**
     * 中间
     *
     * @param context 上下文
     * @param msg     提示文字
     */
    public static void showToastCenter(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 中间（自定义位置）
     *
     * @param context 上下文
     * @param msg     提示文字
     * @param x       横向位置
     * @param y       纵向位置
     */
    public static void showToastCenter(Context context, String msg, int x, int y) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }

    /**
     * 底部
     *
     * @param context 上下文
     * @param msg     提示文字
     */
    public static void showToastBottom(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 底部（自定义位置）
     *
     * @param context 上下文
     * @param msg     提示文字
     * @param x       横向位置
     * @param y       纵向位置
     */
    public static void showToastBottom(Context context, String msg, int x, int y) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }

    /**
     * 默认Toast
     *
     * @param context 上下文
     * @param msg     提示文字
     */

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
