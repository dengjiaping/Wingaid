package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by hejin on 2017/3/9.
 */

public class MyGridView extends GridView {

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyGridView(Context context) {
        super(context);

    }
//将 onInterceptTouchEvent的返回值设置为false，取消其对触摸事件的处理，将事件分发给子view

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
