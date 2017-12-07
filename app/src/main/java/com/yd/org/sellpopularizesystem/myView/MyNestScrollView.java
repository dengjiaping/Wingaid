package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by hejin on 2017/9/8.
 */

public class MyNestScrollView extends NestedScrollView {
    private ScrollViewListener scrollViewListener;//提供外部调用的接口

    private OnScrollToBottomListener mOnScrollToBottomListener;

    public MyNestScrollView(Context context) {
        super(context);
    }

    public MyNestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener){
        this.scrollViewListener = scrollViewListener;
    }

    //定义一个接口
    public interface ScrollViewListener{
        void onScrollChanged(int x, int y, int oldx, int oldy);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // 滑动的距离加上本身的高度与子View的高度对比
        Log.e("TAG", "onScrollChanged: "+ getChildAt(0).getMeasuredHeight());
        if(t + getHeight() >=  getChildAt(0).getMeasuredHeight()){
            // ScrollView滑动到底部
            if(mOnScrollToBottomListener != null) {
                mOnScrollToBottomListener.onScrollToBottom();
            }
        } else {
            if(mOnScrollToBottomListener != null) {
                mOnScrollToBottomListener.onNotScrollToBottom();
            }
        }
    }

    public void setScrollToBottomListener(OnScrollToBottomListener listener) {
        this.mOnScrollToBottomListener = listener;
    }

    public interface OnScrollToBottomListener {
        void onScrollToBottom();
        void onNotScrollToBottom();
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
