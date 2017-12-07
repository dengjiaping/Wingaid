package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.yd.org.sellpopularizesystem.R;

/**
 * Created by hejin on 2017/2/27.
 */

public class ExpandView extends FrameLayout {
    private Animation mExpandAnimation;
    private Animation mCollapseAnimation;
    private boolean mIsExpand = true;

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initExpandView();
    }

    private void initExpandView() {
        LayoutInflater.from(getContext()).inflate(R.layout.expandview_layout, this, true);
        mExpandAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.expand_anim);
        mExpandAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mCollapseAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.collapse_anim);
        mCollapseAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void collapse() {
        if (mIsExpand) {
            mIsExpand = false;
            clearAnimation();
            startAnimation(mCollapseAnimation);
        }
    }

    public void expand() {
        if (!mIsExpand) {
            mIsExpand = true;
            clearAnimation();
            startAnimation(mExpandAnimation);
        }
    }

    public boolean ismIsExpand() {
        return mIsExpand;
    }

    public void setmIsExpand(boolean mIsExpand) {
        this.mIsExpand = mIsExpand;
    }

    public boolean isExpand() {
        return mIsExpand;
    }

    public void setContentView() {
        View view = null;
        view = LayoutInflater.from(getContext()).inflate(R.layout.expandview_layout, null);
        removeAllViews();
        addView(view);
    }
}
