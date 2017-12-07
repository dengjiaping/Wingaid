package com.yd.org.sellpopularizesystem.utils;

import com.yd.org.sellpopularizesystem.javaBean.Lawyer;

import java.util.Comparator;

/**
 * Created by hejin on 2017/4/26.
 */

public class LawyerComparator implements Comparator<Lawyer.ResultBean.LawyerListBean> {
    @Override
    public int compare(Lawyer.ResultBean.LawyerListBean o1, Lawyer.ResultBean.LawyerListBean o2) {
        if (o1.getLaw_firm().equals("@") || o2.getLaw_firm().equals("#")) {
            return -1;
        } else if (o1.getLaw_firm().equals("#") || o2.getLaw_firm().equals("@")) {
            return 1;
        } else {
            if (!o1.getLaw_firm().equals("")||!o2.getLaw_firm().equals("")){
                return o1.getLaw_firm().substring(0, 1).compareToIgnoreCase(o2.getLaw_firm().substring(0, 1));
            }
            return -1;
        }
    }
}
