package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.internal.Pullable;

/**
 * Created by hejin on 2017/5/8.
 */

public class SlidingItemListView extends ListView implements Pullable {
    //前一个视图
    private View mPreItemView;
    //侧滑要显示的视图
    private View mCurrentItemView;
    //当前手指滑动时的x坐标
    private float mFirstX;
    //当前手指滑动时的y坐标
    private float mFirstY;
    //侧滑内容宽度
    private int mRightViewWidth;
    //侧滑内容是否显示默认不显示
    private boolean mIsShown;
    //是否水平滑动
    private Boolean mIsHorizontal;

    public SlidingItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.slidingitemlistview);
        mRightViewWidth = (int) typedArray.getDimension(
                R.styleable.slidingitemlistview_right_width, 50);
        typedArray.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float lastX = ev.getX();
        float lastY = ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "onTouchEvent---->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = lastX - mFirstX;
                float dy = lastY - mFirstY;
                Log.i("TAG", "onTouchEvent---->ACTION_MOVE");

                if (mIsHorizontal == null) {
                    if (!judgeScrollDirection(dx, dy)) {
                        // 没判断出方向
                        break;
                    }
                }

                if (mIsHorizontal) {
                    if (mIsShown && mPreItemView != mCurrentItemView) {
                        //正在展示，前视图不等于后视图
                        //则隐藏前视图
                        hideRightView(mPreItemView);
                    }

                    // 在mPreItemView！=mCurrentItemView执行 显示隐藏的宽度
                    if (dx < 0 && dx > -mRightViewWidth) {
                        Log.i("TAG", "onTouchEvent---->MOVE   -dx=" + -dx);
                        mCurrentItemView.scrollTo((int) (-dx), 0);
                    }
//				 return true;
                } else {
                    if (mIsShown) {
                        //竖直方向滚动
                        //则隐藏前视图
                        hideRightView(mPreItemView);
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                if (mIsShown) {
                    //点击时如果有在显示的View
                    //则隐藏前视图
                    Log.i("TAG", "MotionEvent.ACTION_UP 隐藏前视图");
//				hideRightView(mCurrentItemView);
                    hideRightView(mPreItemView);
                }

                if (mIsHorizontal != null && mIsHorizontal) {
                    if (mFirstX - lastX > mRightViewWidth / 2) {
                        showRight(mCurrentItemView);
                    } else {
                        // 不到一半则隐藏
                        hideRightView(mCurrentItemView);
                    }
                    Log.i("TAG", "成功接管OnTouchEvent  CANCLE return TRUE");
                    return true;
                }
                break;

            default:
                break;
        }

        return super.onTouchEvent(ev);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float lastX = ev.getX();
        float lastY = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIsHorizontal = null;
                mFirstX = lastX;
                mFirstY = lastY;

                int position = pointToPosition((int) mFirstX, (int) mFirstY);

                if (position >= 0) {
                    View view = getChildAt(position - getFirstVisiblePosition());
                    mPreItemView = mCurrentItemView;
                    mCurrentItemView = view;

                }
                Log.i("TAG", "onInterceptTouchEvent----->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "onInterceptTouchEvent----->ACTION_UP");
                /**点击隐藏布局会执行MotionEvent.ACTION_UP*/
                if (mIsShown) {
                    hideRightView(mCurrentItemView);
                }
                break;

            default:
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 展示隐藏的布局
     *
     * @param mCurrentItemView2
     */
    private void showRight(View mCurrentItemView2) {
        mCurrentItemView2.scrollTo(mRightViewWidth, 0);
        mIsShown = true;
    }

    /**
     * 隐藏布局
     */
    private void hideRightView(View mCurrentItemView2) {

        mCurrentItemView2.scrollTo(0, 0);

        mIsShown = false;

    }

    /**
     * @param 水平距离差
     * @param 竖直距离差
     * @return 水平滑动或者竖直滑动都返回true 没有判断出滑动方向则返回false
     */
    private boolean judgeScrollDirection(float dx, float dy) {

        if (Math.abs(dx) > 30 && Math.abs(dx) > Math.abs(dy) * 2) {
            mIsHorizontal = true;
            return true;
        }
        if (Math.abs(dy) > 30 && Math.abs(dy) > Math.abs(dx) * 2) {
            mIsHorizontal = false;
            return true;
        }

        return false;
    }

    public int getRightViewWidth() {
        return mRightViewWidth;
    }

    public void setRightViewWidth(int mRightViewWidth) {
        this.mRightViewWidth = mRightViewWidth;
    }

    @Override
    public boolean canPullDown() {
        if (getCount() == 0) {
            // 没有item的时候也可以下拉刷新
            return true;
        } else if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0) {
            // 滑到ListView的顶部了
            return true;
        } else return false;
    }

    @Override
    public boolean canPullUp() {
        if (getCount() == 0) {
            // 没有item的时候也可以上拉加载
            return true;
        } else if (getLastVisiblePosition() == (getCount() - 1)) {
            // 滑到底部了
            if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
                return true;
        }
        return false;
    }
}
