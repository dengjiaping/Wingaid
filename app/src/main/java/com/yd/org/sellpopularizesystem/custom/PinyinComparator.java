package com.yd.org.sellpopularizesystem.custom;

import com.yd.org.sellpopularizesystem.javaBean.CustomBean;

import java.util.Comparator;

/**
 * @author xiaanming
 */
public class PinyinComparator implements Comparator<CustomBean.ResultBean> {

    public int compare(CustomBean.ResultBean o1, CustomBean.ResultBean o2) {

        try {
            if (o1.getSortLetters().equals("@")
                    || o2.getSortLetters().equals("#")) {
                return -1;
            } else if (o1.getSortLetters().equals("#")
                    || o2.getSortLetters().equals("@")) {
                return 1;
            } else {
                return o1.getSortLetters().compareTo(o2.getSortLetters());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return -1;
    }

}
