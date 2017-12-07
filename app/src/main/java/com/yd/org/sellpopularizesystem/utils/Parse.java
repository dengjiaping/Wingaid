package com.yd.org.sellpopularizesystem.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bai on 2017/1/10.
 */

public class Parse {

    public static Parse parse;

    /**
     * 私有构造函数，保证单例模式
     */
    private Parse() {

    }

    public static synchronized Parse getInstance() {
        if (parse == null) {
            parse = new Parse();
        }
        return parse;
    }

    /**
     * 判断Map中的值是否为空
     *
     * @param obj
     * @return String
     */
    public String isNull(Object obj) {
        if (obj == null) {
            System.out.println("从服务器获取的字段为Null。。。");
            obj = "";
        }
        System.out.println("value：" + obj.toString());
        return obj.toString();
    }

    /**
     * 将Object对象转换成Map
     *
     * @param obj
     * @return ArrayList
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> parseMap(Object obj) {
        Map<String, Object> map = null;
        if (obj == null) {
            map = new HashMap<String, Object>();
            return map;
        }
        try {
            map = (Map<String, Object>) obj;
        } catch (Exception e) {
            // TODO: handle exception
            map = new HashMap<String, Object>();
        }
        return map;
    }

    /**
     * 将Object对象转换成ArrayList
     *
     * @param obj
     * @return ArrayList
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Map<String, Object>> parseList(Object obj) {
        ArrayList<Map<String, Object>> list = null;
        if (obj == null) {
            list = new ArrayList<Map<String, Object>>();
            return list;
        }
        try {
            list = (ArrayList<Map<String, Object>>) obj;
        } catch (Exception e) {
            // TODO: handle exception
            list = new ArrayList<Map<String, Object>>();
        }
        return list;
    }

    /**
     * 转成float类型
     *
     * @param obj
     * @return float
     */
    public float parseFloat(Object obj) {
        float fl;
        String str = isNull(obj);
        if ("".equals(str)) {
            return 0.0f;
        } else {
            try {
                fl = Float.parseFloat(str);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将服务器数据转成float类型异常。。。原数据是：" + str);
                return 0.0f;
            }
        }
        return fl;
    }

    /**
     * 转成double类型
     *
     * @param obj
     * @return double
     */
    public double parseDouble(Object obj) {
        double db;
        String str = isNull(obj);
        if ("".equals(str)) {
            return 0;
        } else {
            try {
                db = Double.parseDouble(str);
                return db;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将服务器数据转成double类型异常。。。原数据是：" + str);
                return 0;
            }
        }
    }

    /**
     * 转成double类型,保留小数点后多少位（四舍五入）
     *
     * @param obj
     * @param num 例：保留后两位"#.##";保留后三位"#.###"……
     * @return double
     */
    public double parseDouble(Object obj, String num) {
        double db;
        String str = isNull(obj);
        if ("".equals(str)) {
            return 0;
        } else {
            try {
                String numLength = num.replace("#.", "");
                db = Double.parseDouble(str)
                        + Math.pow(0.1, numLength.length() + 1);
                db = Double.parseDouble(new DecimalFormat(num).format(db));
                return db;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将服务器数据转成double类型异常。。。原数据是：" + str);
                return 0;
            }
        }
    }

    /**
     * 转成int类型
     *
     * @param obj
     * @return int
     */
    public int parseInt(Object obj) {
        int in;
        String str = isNull(obj);
        if ("".equals(str)) {
            return 0;
        } else {
            try {
                in = Integer.parseInt(str);
                return in;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将服务器数据转成int类型异常。。。原数据是：" + str);
                return 0;
            }
        }
    }

    /**
     * 转成int类型
     *
     * @param obj
     * @return int
     */
    public long parseLong(Object obj) {
        long lo;
        String str = isNull(obj);
        if ("".equals(str)) {
            return 0;
        } else {
            try {
                lo = Long.parseLong(str);
                return lo;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将服务器数据转成Long类型异常。。。原数据是：" + str);
                return 0;
            }
        }
    }

    /**
     * 转成boolean类型
     *
     * @param obj
     * @return boolean
     */
    public boolean parseBool(Object obj) {
        boolean bool;
        String str = isNull(obj);
        if ("".equals(str)) {
            bool = false;
        } else {
            try {
                bool = Boolean.parseBoolean(str);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("将数据转成boolean类型异常。。。原数据是：" + str);
                bool = false;
            }
        }
        return bool;
    }

    /**
     * 去掉字符串中的\r\n,多余的空格
     *
     * @param str
     * @return
     */
    public String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
