package com.yd.org.sellpopularizesystem.utils;

import com.yd.org.sellpopularizesystem.javaBean.CustomBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by hejin on 2017/9/14.
 */

public class GetCustomerNameSort {
    CharacterParserUtil characterParser = CharacterParserUtil.getInstance();

    String chReg = "[\\u4E00-\\u9FA5]+";// 中文字符串匹配

    /***
     * 将名字转化为拼音并获得首字母
     *
     * @param name
     * @return
     */
    public String getSortLetter(String name) {
        String letter = "#";
        if (name == null) {
            return letter;
        }
        // 汉字转换成拼音
        String pinyin = characterParser.getSelling(name);
        String sortString = pinyin.substring(0, 1).toUpperCase(Locale.CHINESE);

        // 正则表达式，判断首字母是否是英文字母
        if (sortString.matches("[A-Z]")) {
            letter = sortString.toUpperCase(Locale.CHINESE);
        }
        return letter;
    }

    /***
     * 取首字母
     *
     * @param sortKey
     * @return
     */
    public String getSortLetterBySortKey(String sortKey) {
        if (sortKey == null || "".equals(sortKey.trim())) {
            return null;
        }
        String letter = "#";
        // 汉字转换成拼音
        String sortString = sortKey.trim().substring(0, 1).toUpperCase(Locale.CHINESE);
        // 正则表达式，判断首字母是否是英文字母
        if (sortString.matches("[A-Z]")) {
            letter = sortString.toUpperCase(Locale.CHINESE);
        }
        return letter;
    }

    /***
     * 根据输入内容进行查询
     *
     * @param str
     *            输入内容
     * @param list
     *            需要查询的List
     * @return 查询结果
     */
    public List<CustomBean.ResultBean> search(String str, List<CustomBean.ResultBean> list) {
        List<CustomBean.ResultBean> filterList = new ArrayList<CustomBean.ResultBean>();// 过滤后的list
        // if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
        if (str.matches("^([0-9]|[/+]).*")) {// 正则表达式 匹配以数字或者加号开头的字符串(包括了带空格及-分割的号码)
            String simpleStr = str.replaceAll("\\-|\\s", "");
            for (CustomBean.ResultBean contact : list) {
                if (contact.getSurname() != null && contact.getFirst_name() != null) {
                    if (contact.getSurname().toLowerCase().contains(simpleStr.toLowerCase())
                            || contact.getFirst_name().contains(simpleStr)) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        } else {
            for (CustomBean.ResultBean contact : list) {
                if (contact.getSurname() != null && contact.getFirst_name() != null) {
                    if (contact.getSurname().indexOf(str) != -1 ||
                            CharacterParserUtil.getInstance().getSelling(contact.getSurname().toLowerCase())
                                    .startsWith(str.toLowerCase())) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        }
        return filterList;
    }

    /***
     * 根据输入内容进行查询
     *
     * @param str
     *            输入内容
     * @param list
     *            需要查询的List
     * @return 查询结果
     */
    public List<CustomBean.ResultBean> search_(String str, List<CustomBean.ResultBean> list) {
        List<CustomBean.ResultBean> filterList = new ArrayList<CustomBean.ResultBean>();// 过滤后的list
        // if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
        if (str.matches("^([0-9]|[/+]).*")) {// 正则表达式 匹配以数字或者加号开头的字符串(包括了带空格及-分割的号码)
            String simpleStr = str.replaceAll("\\-|\\s", "");
            for (CustomBean.ResultBean contact : list) {
                if (contact.getSurname() != null ) {
                    if (contact.getSurname().toLowerCase().contains(simpleStr.toLowerCase())) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        } else {
            for (CustomBean.ResultBean contact : list) {
                if (contact.getSurname() != null) {
                    if (contact.getSurname().indexOf(str) != -1 ||
                            CharacterParserUtil.getInstance().getSelling(contact.getSurname().toLowerCase())
                                    .startsWith(str.toLowerCase())) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        }
        return filterList;
    }
}
