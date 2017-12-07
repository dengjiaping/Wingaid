package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.HorizontalScrollView;

/**
 * Created by hejin on 2017/4/12.
 */

public class BouncyHScrollView extends HorizontalScrollView {
    private static final int MAX_X_OVERSCROLL_DISTANCE = 200;
    private Context mContext;
    private int mMaxXOverscrollDistance;

    public BouncyHScrollView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        mContext = context;
        initBounceDistance();
    }

    public BouncyHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        mContext = context;
        initBounceDistance();
    }

    public BouncyHScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        mContext = context;
        initBounceDistance();
    }

    private void initBounceDistance() {
        final DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        mMaxXOverscrollDistance = (int) (metrics.density * MAX_X_OVERSCROLL_DISTANCE);
    }

    /**
     * @param deltaX         scrollx 变化量
     * @param deltaY         scrolly 变化量
     * @param scrollX        在应用 deltaX 之前的当前 scrollX 值
     * @param scrollY        在应用 deltay 之前的当前 scrolly 值
     * @param scrollRangeX   scrollX 的最大滚动范围
     * @param scrollRangeY   scrollY 的最大滚动范围
     * @param maxOverScrollX scrollX 的最大超出值
     * @param maxOverScrollY scrollY 的最大超出值
     * @param isTouchEvent   是否正在触摸
     * @return
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        //这块是关键性代码
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, mMaxXOverscrollDistance, maxOverScrollY, isTouchEvent);
    }
}
