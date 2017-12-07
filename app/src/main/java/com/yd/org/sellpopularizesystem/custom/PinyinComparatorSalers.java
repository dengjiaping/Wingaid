package com.yd.org.sellpopularizesystem.custom;

import com.yd.org.sellpopularizesystem.javaBean.ReferUserBean;

import java.util.Comparator;

/**
 * Created by e-dot on 2017/8/29.
 */

public class PinyinComparatorSalers implements Comparator<ReferUserBean.ResultBean> {

    public int compare(ReferUserBean.ResultBean o1, ReferUserBean.ResultBean o2) {
        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }
}
