package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.InvestigationActivity;
import com.yd.org.sellpopularizesystem.activity.ScaleActivity;

import java.util.List;

/**
 * Created by bai on 2017/1/13.
 */

public class ViewPagerAdapter extends PagerAdapter {

    // 界面列表
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(Context context, List<View> views) {
        this.context = context;
        this.views = views;
    }

    // 销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {

    }

    // 获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }

        return 0;
    }

    // 初始化arg1位置的界面
    @Override
    public Object instantiateItem(View view, int position) {
        ((ViewPager) view).addView(views.get(position), 0);
        if (position == views.size()) {
            TextView tvStart = (TextView) view.findViewById(R.id.tvStartInvestigation);
            TextView tvEnd = (TextView) view.findViewById(R.id.tvEndInvestigation);
            tvStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context.getApplicationContext(), InvestigationActivity.class);
                    context.startActivity(intent);
                }
            });
            tvEnd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context.getApplicationContext(), ScaleActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        return views.get(position);
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));//释放滑动过后的前一页
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {

    }


}
