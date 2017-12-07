package com.yd.org.sellpopularizesystem.javaBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bai on 2017/1/17.
 */

public class CityBean extends Domine {


    /**
     * code : 1
     * msg : 获取成功
     * result : {"product_area":{"1":"区域一","2":"区域二","3":"区域三","4":"区域四","5":"区域五"},"product_house":{"1":"一室","2":"二室","3":"三室","4":"四室","5":"五室","6":"五室以上"},"product_space":{"1":"公寓","2":"别墅"},"product_space1":{"1":"0~30","2":"30~40","3":"40~60","4":"60~80","5":"80~100","6":"100~120","7":"120~140","8":"140~200","9":"200~500"},"product_price":{"0~300000":"0~30","300000~400000":"30~40","400000~600000":"40~60","600000~800000":"60~80","800000~1000000":"80~100","1000000~1200000":"100~120","1200000~1400000":"120~140","1400000~2000000":"140~200","2000000~5000000":"200~500","5000000~10000000":"500~1000","10000000~20000000":"1000~2000"},"product_cate":{"1":"jsdkhsdklgha'gja'gjae'og","2":"这是韩语","3":"rrrb","4":"俩小鸟","5":"两个小黄","12":"两只黄鹂鸣翠柳","16":"醉里挑灯看剑","17":"白日依山尽","41":"中文"}}
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
         * product_space : {"1":"公寓","2":"别墅"}
         * product_space1 : {"1":"0~30","2":"30~40","3":"40~60","4":"60~80","5":"80~100","6":"100~120","7":"120~140","8":"140~200","9":"200~500"}
         * product_price : {"0~300000":"0~30","300000~400000":"30~40","400000~600000":"40~60","600000~800000":"60~80","800000~1000000":"80~100","1000000~1200000":"100~120","1200000~1400000":"120~140","1400000~2000000":"140~200","2000000~5000000":"200~500","5000000~10000000":"500~1000","10000000~20000000":"1000~2000"}
         * product_cate : {"1":"jsdkhsdklgha'gja'gjae'og","2":"这是韩语","3":"rrrb","4":"俩小鸟","5":"两个小黄","12":"两只黄鹂鸣翠柳","16":"醉里挑灯看剑","17":"白日依山尽","41":"中文"}
         */

        private ProductAreaBean product_area;
        private ProductHouseBean product_house;
        private ProductSpaceBean product_space;
        private ProductSpace1Bean product_space1;
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

        public ProductSpaceBean getProduct_space() {
            return product_space;
        }

        public void setProduct_space(ProductSpaceBean product_space) {
            this.product_space = product_space;
        }

        public ProductSpace1Bean getProduct_space1() {
            return product_space1;
        }

        public void setProduct_space1(ProductSpace1Bean product_space1) {
            this.product_space1 = product_space1;
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
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;
            @SerializedName("5")
            private String _$5;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
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
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;
            @SerializedName("5")
            private String _$5;
            @SerializedName("6")
            private String _$6;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }
        }

        public static class ProductSpaceBean {
            /**
             * 1 : 公寓
             * 2 : 别墅
             */

            @SerializedName("1")
            private String _$1;
            @SerializedName("2")
            private String _$2;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }
        }

        public static class ProductSpace1Bean {
            /**
             * 1 : 0~30
             * 2 : 30~40
             * 3 : 40~60
             * 4 : 60~80
             * 5 : 80~100
             * 6 : 100~120
             * 7 : 120~140
             * 8 : 140~200
             * 9 : 200~500
             */

            @SerializedName("1")
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;
            @SerializedName("5")
            private String _$5;
            @SerializedName("6")
            private String _$6;
            @SerializedName("7")
            private String _$7;
            @SerializedName("8")
            private String _$8;
            @SerializedName("9")
            private String _$9;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }

            public String get_$7() {
                return _$7;
            }

            public void set_$7(String _$7) {
                this._$7 = _$7;
            }

            public String get_$8() {
                return _$8;
            }

            public void set_$8(String _$8) {
                this._$8 = _$8;
            }

            public String get_$9() {
                return _$9;
            }

            public void set_$9(String _$9) {
                this._$9 = _$9;
            }
        }

        public static class ProductPriceBean {
            @SerializedName("0~300000")
            private String _$_0300000291; // FIXME check this code
            @SerializedName("300000~400000")
            private String _$_300000400000162; // FIXME check this code
            @SerializedName("400000~600000")
            private String _$_4000006000003; // FIXME check this code
            @SerializedName("600000~800000")
            private String _$_600000800000242; // FIXME check this code
            @SerializedName("800000~1000000")
            private String _$_8000001000000226; // FIXME check this code
            @SerializedName("1000000~1200000")
            private String _$_10000001200000247; // FIXME check this code
            @SerializedName("1200000~1400000")
            private String _$_1200000140000067; // FIXME check this code
            @SerializedName("1400000~2000000")
            private String _$_14000002000000210; // FIXME check this code
            @SerializedName("2000000~5000000")
            private String _$_2000000500000093; // FIXME check this code
            @SerializedName("5000000~10000000")
            private String _$_50000001000000094; // FIXME check this code
            @SerializedName("10000000~20000000")
            private String _$_1000000020000000298; // FIXME check this code

            public String get_$_0300000291() {
                return _$_0300000291;
            }

            public void set_$_0300000291(String _$_0300000291) {
                this._$_0300000291 = _$_0300000291;
            }

            public String get_$_300000400000162() {
                return _$_300000400000162;
            }

            public void set_$_300000400000162(String _$_300000400000162) {
                this._$_300000400000162 = _$_300000400000162;
            }

            public String get_$_4000006000003() {
                return _$_4000006000003;
            }

            public void set_$_4000006000003(String _$_4000006000003) {
                this._$_4000006000003 = _$_4000006000003;
            }

            public String get_$_600000800000242() {
                return _$_600000800000242;
            }

            public void set_$_600000800000242(String _$_600000800000242) {
                this._$_600000800000242 = _$_600000800000242;
            }

            public String get_$_8000001000000226() {
                return _$_8000001000000226;
            }

            public void set_$_8000001000000226(String _$_8000001000000226) {
                this._$_8000001000000226 = _$_8000001000000226;
            }

            public String get_$_10000001200000247() {
                return _$_10000001200000247;
            }

            public void set_$_10000001200000247(String _$_10000001200000247) {
                this._$_10000001200000247 = _$_10000001200000247;
            }

            public String get_$_1200000140000067() {
                return _$_1200000140000067;
            }

            public void set_$_1200000140000067(String _$_1200000140000067) {
                this._$_1200000140000067 = _$_1200000140000067;
            }

            public String get_$_14000002000000210() {
                return _$_14000002000000210;
            }

            public void set_$_14000002000000210(String _$_14000002000000210) {
                this._$_14000002000000210 = _$_14000002000000210;
            }

            public String get_$_2000000500000093() {
                return _$_2000000500000093;
            }

            public void set_$_2000000500000093(String _$_2000000500000093) {
                this._$_2000000500000093 = _$_2000000500000093;
            }

            public String get_$_50000001000000094() {
                return _$_50000001000000094;
            }

            public void set_$_50000001000000094(String _$_50000001000000094) {
                this._$_50000001000000094 = _$_50000001000000094;
            }

            public String get_$_1000000020000000298() {
                return _$_1000000020000000298;
            }

            public void set_$_1000000020000000298(String _$_1000000020000000298) {
                this._$_1000000020000000298 = _$_1000000020000000298;
            }
        }

        public static class ProductCateBean {
            /**
             * 1 : jsdkhsdklgha'gja'gjae'og
             * 2 : 这是韩语
             * 3 : rrrb
             * 4 : 俩小鸟
             * 5 : 两个小黄
             * 12 : 两只黄鹂鸣翠柳
             * 16 : 醉里挑灯看剑
             * 17 : 白日依山尽
             * 41 : 中文
             */

            @SerializedName("1")
            private String _$1;
            @SerializedName("2")
            private String _$2;
            @SerializedName("3")
            private String _$3;
            @SerializedName("4")
            private String _$4;
            @SerializedName("5")
            private String _$5;
            @SerializedName("12")
            private String _$12;
            @SerializedName("16")
            private String _$16;
            @SerializedName("17")
            private String _$17;
            @SerializedName("41")
            private String _$41;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String get_$12() {
                return _$12;
            }

            public void set_$12(String _$12) {
                this._$12 = _$12;
            }

            public String get_$16() {
                return _$16;
            }

            public void set_$16(String _$16) {
                this._$16 = _$16;
            }

            public String get_$17() {
                return _$17;
            }

            public void set_$17(String _$17) {
                this._$17 = _$17;
            }

            public String get_$41() {
                return _$41;
            }

            public void set_$41(String _$41) {
                this._$41 = _$41;
            }
        }
    }
}
