package com.yd.org.sellpopularizesystem.utils;

import com.yd.org.sellpopularizesystem.javaBean.TeamBean;

import java.util.Comparator;

/**
 * Created by hejin on 2017/5/17.
 */

public class TeamComparator implements Comparator<TeamBean.ResultBean.SubBeanX.SubBean>{
    @Override
    public int compare(TeamBean.ResultBean.SubBeanX.SubBean o1, TeamBean.ResultBean.SubBeanX.SubBean o2) {
        if (o1.getSurname().equals("@") || o2.getSurname().equals("#"))
        {
            return -1;
        }
        else if (o1.getSurname().equals("#") || o2.getSurname().equals("@"))
        {
            return 1;
        }
        else
        {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
}
