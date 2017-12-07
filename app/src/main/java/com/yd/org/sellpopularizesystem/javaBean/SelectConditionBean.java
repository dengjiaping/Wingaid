package com.yd.org.sellpopularizesystem.javaBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hejin on 2017/9/14.
 */

public class SelectConditionBean {

    /**
     * code : 1
     * msg : 获取成功
     * result : {"product_area":{"1":"区域一","2":"区域二","3":"区域三","4":"区域四","5":"区域五"},"product_house":{"1":"一室","2":"二室","3":"三室","4":"四室","5":"五室","6":"五室以上"},"product_space1":{"1":"公寓","2":"别墅"},"product_space":{"0~30":"0~30","30~40":"30~40","40~60":"40~60","60~80":"60~80","80~100":"80~100","100~120":"100~120","120~140":"120~140","140~200":"140~200","200~99999":"200~不限"},"product_price":{"0~650000":"0k~650k","650000~800000":"650k~800k","800000~950000":"800k~950k","950000~1100000":"950k~1100k","1100000~300000":"1100k~不限"},"product_cate":{"1":"House&Land","2":"Land","3":"APT"}}
     */

    private String code;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * product_area : {"1":"区域一","2":"区域二","3":"区域三","4":"区域四","5":"区域五"}
         * product_house : {"1":"一室","2":"二室","3":"三室","4":"四室","5":"五室","6":"五室以上"}
         * product_space1 : {"1":"公寓","2":"别墅"}
         * product_space : {"0~30":"0~30","30~40":"30~40","40~60":"40~60","60~80":"60~80","80~100":"80~100","100~120":"100~120","120~140":"120~140","140~200":"140~200","200~99999":"200~不限"}
         * product_price : {"0~650000":"0k~650k","650000~800000":"650k~800k","800000~950000":"800k~950k","950000~1100000":"950k~1100k","1100000~300000":"1100k~不限"}
         * product_cate : {"1":"House&Land","2":"Land","3":"APT"}
         */

        private ProductAreaBean product_area;
        private ProductHouseBean product_house;
        private ProductSpace1Bean product_space1;
        private ProductSpaceBean product_space;
        private ProductPriceBean product_price;
        private ProductCateBean product_cate;

        public ProductAreaBean getProduct_area() {
            return product_area;
        }

        public void setProduct_area(ProductAreaBean product_area) {
            this.product_area = product_area;
        }

        public ProductHouseBean getProduct_house() {
            return product_house;
        }

        public void setProduct_house(ProductHouseBean product_house) {
            this.product_house = product_house;
        }

        public ProductSpace1Bean getProduct_space1() {
            return product_space1;
        }

        public void setProduct_space1(ProductSpace1Bean product_space1) {
            this.product_space1 = product_space1;
        }

        public ProductSpaceBean getProduct_space() {
            return product_space;
        }

        public void setProduct_space(ProductSpaceBean product_space) {
            this.product_space = product_space;
        }

        public ProductPriceBean getProduct_price() {
            return product_price;
        }

        public void setProduct_price(ProductPriceBean product_price) {
            this.product_price = product_price;
        }

        public ProductCateBean getProduct_cate() {
            return product_cate;
        }

        public void setProduct_cate(ProductCateBean product_cate) {
            this.product_cate = product_cate;
        }

        public static class ProductAreaBean {
            /**
             * 1 : 区域一
             * 2 : 区域二
             * 3 : 区域三
             * 4 : 区域四
             * 5 : 区域五
             */

            @SerializedName("1")
            private String value1;
            @SerializedName("2")
            private String value2;
            @SerializedName("3")
            private String value3;
            @SerializedName("4")
            private String value4;
            @SerializedName("5")
            private String value5;

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }

            public String getValue3() {
                return value3;
            }

            public void setValue3(String value3) {
                this.value3 = value3;
            }

            public String getValue4() {
                return value4;
            }

            public void setValue4(String value4) {
                this.value4 = value4;
            }

            public String getValue5() {
                return value5;
            }

            public void setValue5(String value5) {
                this.value5 = value5;
            }
        }

        public static class ProductHouseBean {
            /**
             * 1 : 一室
             * 2 : 二室
             * 3 : 三室
             * 4 : 四室
             * 5 : 五室
             * 6 : 五室以上
             */

            @SerializedName("1")
            private String value1;
            @SerializedName("2")
            private String value2;
            @SerializedName("3")
            private String value3;
            @SerializedName("4")
            private String value4;
            @SerializedName("5")
            private String value5;
            @SerializedName("6")
            private String value6;

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }

            public String getValue3() {
                return value3;
            }

            public void setValue3(String value3) {
                this.value3 = value3;
            }

            public String getValue4() {
                return value4;
            }

            public void setValue4(String value4) {
                this.value4 = value4;
            }

            public String getValue5() {
                return value5;
            }

            public void setValue5(String value5) {
                this.value5 = value5;
            }

            public String getValue6() {
                return value6;
            }

            public void setValue6(String value6) {
                this.value6 = value6;
            }
        }

        public static class ProductSpace1Bean {
            /**
             * 1 : 公寓
             * 2 : 别墅
             */

            @SerializedName("1")
            private String value1;
            @SerializedName("2")
            private String value2;

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }
        }

        public static class ProductSpaceBean {
            @SerializedName("0~30")
            private String value1; // FIXME check this code
            @SerializedName("30~40")
            private String value2; // FIXME check this code
            @SerializedName("40~60")
            private String value3; // FIXME check this code
            @SerializedName("60~80")
            private String value4; // FIXME check this code
            @SerializedName("80~100")
            private String value5; // FIXME check this code
            @SerializedName("100~120")
            private String value6; // FIXME check this code
            @SerializedName("120~140")
            private String value7; // FIXME check this code
            @SerializedName("140~200")
            private String value8; // FIXME check this code
            @SerializedName("200~99999")
            private String value9; // FIXME check this code

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }

            public String getValue3() {
                return value3;
            }

            public void setValue3(String value3) {
                this.value3 = value3;
            }

            public String getValue4() {
                return value4;
            }

            public void setValue4(String value4) {
                this.value4 = value4;
            }

            public String getValue5() {
                return value5;
            }

            public void setValue5(String value5) {
                this.value5 = value5;
            }

            public String getValue6() {
                return value6;
            }

            public void setValue6(String value6) {
                this.value6 = value6;
            }

            public String getValue7() {
                return value7;
            }

            public void setValue7(String value7) {
                this.value7 = value7;
            }

            public String getValue8() {
                return value8;
            }

            public void setValue8(String value8) {
                this.value8 = value8;
            }

            public String getValue9() {
                return value9;
            }

            public void setValue9(String value9) {
                this.value9 = value9;
            }
        }

        public static class ProductPriceBean {
            @SerializedName("0~650000")
            private String value1; // FIXME check this code
            @SerializedName("650000~800000")
            private String value2; // FIXME check this code
            @SerializedName("800000~950000")
            private String value3; // FIXME check this code
            @SerializedName("950000~1100000")
            private String value4; // FIXME check this code
            @SerializedName("1100000~300000")
            private String value5; // FIXME check this code

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }

            public String getValue3() {
                return value3;
            }

            public void setValue3(String value3) {
                this.value3 = value3;
            }

            public String getValue4() {
                return value4;
            }

            public void setValue4(String value4) {
                this.value4 = value4;
            }

            public String getValue5() {
                return value5;
            }

            public void setValue5(String value5) {
                this.value5 = value5;
            }
        }

        public static class ProductCateBean {
            /**
             * 1 : House&Land
             * 2 : Land
             * 3 : APT
             */

            @SerializedName("1")
            private String value1;
            @SerializedName("2")
            private String value2;
            @SerializedName("3")
            private String value3;

            public String getValue1() {
                return value1;
            }

            public void setValue1(String value1) {
                this.value1 = value1;
            }

            public String getValue2() {
                return value2;
            }

            public void setValue2(String value2) {
                this.value2 = value2;
            }

            public String getValue3() {
                return value3;
            }

            public void setValue3(String value3) {
                this.value3 = value3;
            }
        }
    }
}
