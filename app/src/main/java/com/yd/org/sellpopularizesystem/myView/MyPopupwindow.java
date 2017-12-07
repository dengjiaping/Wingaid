
package com.yd.org.sellpopularizesystem.myView;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.yd.org.sellpopularizesystem.R;


/**
 * Created by bai on 2017/1/12.
 */


public class MyPopupwindow extends PopupWindow {

    private static final String TAG = "FinishProjectPopupWindows";

    private View mView;
    public Button photoAlbumButton, photoButton, cancelButton;

    public MyPopupwindow(Activity context, View.OnClickListener itemsOnClick) {
        super(context);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.popuwindow, null);

        cancelButton = (Button) mView.findViewById(R.id.cancelButton);
        photoButton = (Button) mView.findViewById(R.id.photoButton);
        //photoAlbumButton=(Button) mView.findViewById(R.id.photoAlbumButton);
        photoButton.setOnClickListener(itemsOnClick);
        //photoAlbumButton.setOnClickListener(itemsOnClick);
        cancelButton.setOnClickListener(itemsOnClick);


        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

}
