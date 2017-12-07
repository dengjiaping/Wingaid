package com.yd.org.sellpopularizesystem.application;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.myView.ChildListView;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

/**
 * Created by ${bai} on 17/2/13.
 */

public class ViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context context;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.context = context;
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);

    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为Button设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setButtonText(int viewId, String text) {
        Button view = getView(viewId);
        view.setText(text);
        return this;
    }

    //为某个view设置背景颜色
    public ViewHolder setView(int viewId, int v) {
        View view = getView(viewId);
        view.setBackgroundColor(v);
        return this;
    }

    //显示
    public ViewHolder visibility(int viewId) {
        ImageView view = getView(viewId);
        view.setVisibility(View.VISIBLE);
        return this;
    }


    //隐藏按钮
    public ViewHolder goneImageView(int viewId) {
        ImageView view = getView(viewId);
        view.setVisibility(View.GONE);
        return this;
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public ViewHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public ListView setListView(int viewId) {
        ChildListView view = getView(viewId);
        return view;
    }


    public ViewHolder addLinearView(int viewId, ImageView imageView) {
        LinearLayout linearLayout = getView(viewId);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.addView(imageView);
        return this;
    }


    public ViewHolder setText(int viewId, String text, View.OnClickListener click) {
        TextView view = getView(viewId);
        if (!TextUtils.isEmpty(text)) {
            view.setText(text);
        }
        view.setOnClickListener(click);
        return this;
    }

    public ViewHolder setRadioButton(int viewId, String text, View.OnClickListener click) {
        RadioButton view = getView(viewId);
        view.setText(text);
        view.setOnClickListener(click);
        return this;
    }

    public ViewHolder setText(int viewId, int res, String text, View.OnClickListener click) {
        TextView view = getView(viewId);
        view.setText(text);
        view.setBackgroundResource(res);
        view.setOnClickListener(click);
        return this;
    }

    public ViewHolder setText(int tvVisitTime, int viewId) {
        TextView view = getView(viewId);
        view.setVisibility(View.GONE);
        return this;
    }

    /**
     * 设置线性布局隐藏
     *
     * @param tvVisitTime
     * @return
     */

    public ViewHolder setLinear(int tvVisitTime) {
        LinearLayout view = getView(tvVisitTime);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    public ViewHolder setLinear_Gone(int tvVisitTime) {
        LinearLayout view = getView(tvVisitTime);
        view.removeAllViews();
        view.setVisibility(View.GONE);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setImageByUrl(int viewId, String url) {
        BitmapUtil.loadImageView(context, url, (ImageView) getView(viewId));


        return this;
    }

    /**
     * @param viewId
     * @param url
     * @param click
     * @return
     */
    public ViewHolder setImageByUrl(int viewId, String url, View.OnClickListener click) {
        ImageView imageView = (ImageView) getView(viewId);

        BitmapUtil.loadImageView(context, url, imageView);


        imageView.setOnClickListener(click);
        return this;
    }


    public int getPosition() {
        return mPosition;
    }

}
