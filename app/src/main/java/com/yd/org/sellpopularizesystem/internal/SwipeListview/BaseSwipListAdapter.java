package com.yd.org.sellpopularizesystem.internal.SwipeListview;

import android.widget.BaseAdapter;

/**
 * Created by hejin on 2017/5/9.
 */

public abstract class BaseSwipListAdapter extends BaseAdapter {
    public boolean getSwipEnableByPosition(int position){
        return true;
    }
}
