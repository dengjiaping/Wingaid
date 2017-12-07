package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by hejin on 2017/3/9.
 */

public class ChildListView extends ListView {

    public ChildListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public ChildListView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ChildListView(Context context) {
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
