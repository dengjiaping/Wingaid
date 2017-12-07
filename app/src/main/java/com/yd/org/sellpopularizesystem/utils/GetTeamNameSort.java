package com.yd.org.sellpopularizesystem.utils;

/**
 * Created by hejin on 2017/5/17.
 */

import com.yd.org.sellpopularizesystem.javaBean.Lawyer;
import com.yd.org.sellpopularizesystem.javaBean.TeamBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 取姓名首字母及模糊匹配查询
 * <p>
 * <p>
 * 类详细描述
 * </p>
 *
 * @author duanbokan
 */
public class GetTeamNameSort {
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
    public List<TeamBean.ResultBean.SubBeanX> search(String str, List<TeamBean.ResultBean.SubBeanX> list) {
        List<TeamBean.ResultBean.SubBeanX> filterList = new ArrayList<TeamBean.ResultBean.SubBeanX>();// 过滤后的list
        // if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
        if (str.matches("^([0-9]|[/+]).*")) {// 正则表达式 匹配以数字或者加号开头的字符串(包括了带空格及-分割的号码)
            String simpleStr = str.replaceAll("\\-|\\s", "");
            for (TeamBean.ResultBean.SubBeanX contact : list) {
                if (contact.getId() + "" != null) {
                    /*if (contact.getSub() != null) {
                        for (int i = 0; i < contact.getSub().size(); i++) {
                            if (contact.getSub().get(i).getId() == Integer.parseInt(simpleStr)) {
                                if (!filterList.contains(contact)) {
                                    filterList.add(contact);
                                }
                                //continue;
                            }
                        }
                    }*/
                    if (contact.getId() == Integer.parseInt(simpleStr)) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        } else {
            for (TeamBean.ResultBean.SubBeanX contact : list) {
                if (contact.getSurname() != null || contact.getFirstname() != null) {
                    if (contact.getFirstname().indexOf(str) != -1 || contact.getSurname().indexOf(str) != -1 ||
                            CharacterParserUtil.getInstance().getSelling(contact.getFirstname()).startsWith(str)
                            || CharacterParserUtil.getInstance().getSelling(contact.getSurname()).startsWith(str)) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                    /*if (contact.getSub() != null) {
                        for (int i = 0; i < contact.getSub().size(); i++) {
                            if (contact.getSub().get(i).getFirstname().indexOf(str) != -1 || contact.getSub().get(i).getSurname().indexOf(str) != -1
                                    || CharacterParserUtil.getInstance().getSelling(contact.getSub().get(i).getFirstname()).startsWith(str)
                                    || CharacterParserUtil.getInstance().getSelling(contact.getSub().get(i).getSurname()).startsWith(str)) {
                                if (!filterList.contains(contact)) {
                                    filterList.add(contact);
                                }
                               //continue;
                            }
                        }
                    }*/
                    // 姓名全匹配,姓名首字母简拼匹配,姓名全字母匹配
                    if (contact.getFirstname().toLowerCase(Locale.CHINESE).contains(
                            str.toLowerCase(Locale.CHINESE))) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                    if (contact.getCommission().indexOf(str) != -1) {
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
