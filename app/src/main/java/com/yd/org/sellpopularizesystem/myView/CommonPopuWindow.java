package com.yd.org.sellpopularizesystem.myView;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.yd.org.sellpopularizesystem.R;

/**
 * Created by hejin on 2017/3/30.
 */

public abstract class CommonPopuWindow extends PopupWindow {
    private View mView;

    public CommonPopuWindow(Activity context) {
        super(context);
        mView = LayoutInflater.from(context).inflate(getLayoutId(), null);
        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置点击屏幕其它地方弹出框消失
        this.setOutsideTouchable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    protected abstract int getLayoutId();
}
