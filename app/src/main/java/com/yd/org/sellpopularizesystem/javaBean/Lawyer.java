package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/4/25.
 */

public class Lawyer extends Domine {

    /**
     * code : 1
     * msg : 成功获取律师列表
     * result : [{"law_firm":"","lawyer_list":[{"lawyer_id":21,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"111@QQ.COM","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492159412","add_ip":"116.231.51.223","add_admin":"","status":0},{"lawyer_id":15,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"f1","surname":"family1","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"1111","lawyer_email":"11@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492155457","add_ip":"188.166.246.253","add_admin":"","status":0},{"lawyer_id":10,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1491473611","add_ip":"117.84.36.145","add_admin":"","status":0},{"lawyer_id":9,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1491473522","add_ip":"117.84.36.145","add_admin":"","status":0},{"lawyer_id":8,"company_id":3,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"测试律师01","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"13911111111","lawyer_email":"lenka.zheng@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1490411451","add_ip":"117.84.78.214, ","add_admin":"12","status":0},{"lawyer_id":7,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"qwewqeqw","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"12312312","lawyer_email":"qweqweqwe@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1490411342","add_ip":"117.84.78.214","add_admin":"3","status":1},{"lawyer_id":6,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":" 国防部：敦促日方恪守走和平发展道路的承诺","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"2324","lawyer_email":"rtgt@fg.gh","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898756","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":5,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"自然好味道","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"4008006465","lawyer_email":"fsf@d.dd","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898748","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":1,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"齐大大","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1234","lawyer_email":"15252132437@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898733","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":2,"company_id":1,"customer_id":87,"vendor_id":"","law_firm":"","first_name":"梅须逊雪三分白","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"543543","lawyer_email":"3234@er.dd","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898718","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":3,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"44","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1323","lawyer_email":"gytry@fg.yg","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898696","add_ip":"117.84.37.76","add_admin":"4","status":0}]},{"law_firm":"aa","lawyer_list":[{"lawyer_id":22,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"aa","first_name":"hhh","surname":"aa","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"1123","lawyer_email":"qq@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492160073","add_ip":"116.231.51.223","add_admin":"","status":0}]},{"law_firm":"lenka","lawyer_list":[{"lawyer_id":34,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"lenka","first_name":"dhjd","surname":"syue","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"2316","lawyer_email":"gsh@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492495249","add_ip":"101.81.74.105","add_admin":"","status":0},{"lawyer_id":28,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"lenka","first_name":"ka","surname":"len","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"15801903006","lawyer_email":"Lenka.zheng@e-dot.net","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492326074","add_ip":"101.81.74.105","add_admin":"","status":0}]},{"law_firm":"test1","lawyer_list":[{"lawyer_id":20,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"test1","first_name":"aa2","surname":"aa22","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"ff","lawyer_email":"33@QQ.COM","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492158183","add_ip":"116.231.51.223","add_admin":"","status":0},{"lawyer_id":17,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"test1","first_name":"aaa2","surname":"aaa1","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"aaaa","lawyer_email":"22@QQ.COM","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492155733","add_ip":"116.231.51.223","add_admin":"","status":0},{"lawyer_id":16,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"test1","first_name":"名叫詹姆斯","surname":"姓尼古拉斯","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"6464364","lawyer_email":"lawyer_email@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"3343r","street_number":"efesfse","street_address_1":"grdgrdh","street_address_2":"fdbdfsg","suburb":"gsd","state":"bfdsh","postcode":"fdhf","country":"china","add_time":"1492155597","add_ip":"116.231.51.223","add_admin":"","status":0}]},{"law_firm":"律师行","lawyer_list":[{"lawyer_id":35,"company_id":9,"customer_id":0,"vendor_id":"开发商编号","law_firm":"律师行","first_name":"律师姓氏","surname":"律师名字","abn_sign":"ABN","acn_sign":"ACN","type":0,"lawyer_tel":"电话","lawyer_email":"邮箱","lawyer_fax":"传真","lawyer_sex":0,"unit_number":"单位号码","street_number":"街道号码","street_address_1":"街道地址1","street_address_2":"街道地址2","suburb":"郊区","state":"洲","postcode":"邮政编码","country":"国家","add_time":"1492498968","add_ip":"117.84.72.25","add_admin":"15","status":0},{"lawyer_id":30,"company_id":5,"customer_id":3796,"vendor_id":"7","law_firm":"律师行","first_name":"律师名","surname":"律师姓","abn_sign":"ABN","acn_sign":"ACN","type":2,"lawyer_tel":"律师电话","lawyer_email":"电子邮件","lawyer_fax":"律师传真","lawyer_sex":0,"unit_number":"单位号码","street_number":"街道号码","street_address_1":"街道地址行1","street_address_2":"街道地址行2","suburb":"郊区","state":"洲","postcode":"邮政编码","country":"国家","add_time":"1492329711","add_ip":"180.114.134.123","add_admin":"18","status":0},{"lawyer_id":19,"company_id":9,"customer_id":0,"vendor_id":"2","law_firm":"律师行","first_name":"律师名","surname":"律师姓*","abn_sign":"ABN","acn_sign":"ACNnn","type":2,"lawyer_tel":"对应联系电话","lawyer_email":"电子邮件","lawyer_fax":"对应联系传真","lawyer_sex":0,"unit_number":"单位号码","street_number":"街道号码","street_address_1":"街道地址行1","street_address_2":"街道地址行2","suburb":"郊区","state":"洲","postcode":"邮政编码","country":"国家","add_time":"1492157494","add_ip":"117.84.38.145","add_admin":"15","status":0},{"lawyer_id":18,"company_id":1,"customer_id":0,"vendor_id":"2","law_firm":"律师行","first_name":"律师名","surname":"律师姓","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"34","lawyer_email":"5345","lawyer_fax":"43543543","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492157371","add_ip":"117.84.38.145","add_admin":"15","status":0}]},{"law_firm":"这是律师行","lawyer_list":[{"lawyer_id":13,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"这是律师行","first_name":"名叫詹姆斯","surname":"姓尼古拉斯","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"6464364","lawyer_email":"lawyer_email@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"3343r","street_number":"efesfse","street_address_1":"grdgrdh","street_address_2":"fdbdfsg","suburb":"gsd","state":"bfdsh","postcode":"fdhf","country":"china","add_time":"1492140884","add_ip":"116.231.51.223","add_admin":"","status":0},{"lawyer_id":12,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"这是律师行","first_name":"律师名","surname":"律师姓","abn_sign":"abn","acn_sign":"acn","type":0,"lawyer_tel":"tel222","lawyer_email":"email","lawyer_fax":"fax2","lawyer_sex":0,"unit_number":"danweihaoma","street_number":"街道号码","street_address_1":"街道地址行1","street_address_2":"街道地址行2","suburb":"郊区","state":"周","postcode":"postcode","country":"china","add_time":"1491526990","add_ip":"117.84.36.145","add_admin":"4","status":0},{"lawyer_id":11,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"这是律师行","first_name":"名叫詹姆斯","surname":"姓尼古拉斯","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"6464364","lawyer_email":"lawyer_email@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"3343r","street_number":"efesfse","street_address_1":"grdgrdh","street_address_2":"fdbdfsg","suburb":"gsd","state":"bfdsh","postcode":"fdhf","country":"china","add_time":"1491476028","add_ip":"117.84.36.145","add_admin":"","status":0}]},{"law_firm":"阳光律师行","lawyer_list":[{"lawyer_id":14,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"阳光律师行","first_name":"律师名","surname":"律师姓","abn_sign":"abn","acn_sign":"acn","type":1,"lawyer_tel":"17895101277","lawyer_email":"lvshiyouxiang@lawyer.cn","lawyer_fax":"625895546","lawyer_sex":0,"unit_number":"单位号码","street_number":"街道号码","street_address_1":"街道地址行1","street_address_2":"街道地址行2","suburb":" 郊区","state":" 洲","postcode":" 邮政编码","country":" 国家","add_time":"1492152022","add_ip":"117.84.38.145","add_admin":"15","status":0}]}]
     */

    private int code;
    private String msg;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean extends Domine{
        /**
         * law_firm :
         * lawyer_list : [{"lawyer_id":21,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"111@QQ.COM","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492159412","add_ip":"116.231.51.223","add_admin":"","status":0},{"lawyer_id":15,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"f1","surname":"family1","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"1111","lawyer_email":"11@qq.com","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1492155457","add_ip":"188.166.246.253","add_admin":"","status":0},{"lawyer_id":10,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1491473611","add_ip":"117.84.36.145","add_admin":"","status":0},{"lawyer_id":9,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"","lawyer_email":"","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1491473522","add_ip":"117.84.36.145","add_admin":"","status":0},{"lawyer_id":8,"company_id":3,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"测试律师01","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"13911111111","lawyer_email":"lenka.zheng@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1490411451","add_ip":"117.84.78.214, ","add_admin":"12","status":0},{"lawyer_id":7,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"qwewqeqw","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"12312312","lawyer_email":"qweqweqwe@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1490411342","add_ip":"117.84.78.214","add_admin":"3","status":1},{"lawyer_id":6,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":" 国防部：敦促日方恪守走和平发展道路的承诺","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"2324","lawyer_email":"rtgt@fg.gh","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898756","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":5,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"自然好味道","surname":"","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"4008006465","lawyer_email":"fsf@d.dd","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898748","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":1,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"齐大大","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1234","lawyer_email":"15252132437@qq.com","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898733","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":2,"company_id":1,"customer_id":87,"vendor_id":"","law_firm":"","first_name":"梅须逊雪三分白","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"543543","lawyer_email":"3234@er.dd","lawyer_fax":"","lawyer_sex":0,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898718","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":3,"company_id":1,"customer_id":0,"vendor_id":"","law_firm":"","first_name":"44","surname":"","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1323","lawyer_email":"gytry@fg.yg","lawyer_fax":"","lawyer_sex":1,"unit_number":"","street_number":"","street_address_1":"","street_address_2":"","suburb":"","state":"","postcode":"","country":"","add_time":"1487898696","add_ip":"117.84.37.76","add_admin":"4","status":0}]
         */

        private String law_firm;
        private boolean isFirst=true;

        public boolean isFirst() {
            return isFirst;
        }

        public void setFirst(boolean first) {
            isFirst = first;
        }

        private List<LawyerListBean> lawyer_list;

        public String getLaw_firm() {
            return law_firm;
        }

        public void setLaw_firm(String law_firm) {
            this.law_firm = law_firm;
        }

        public List<LawyerListBean> getLawyer_list() {
            return lawyer_list;
        }

        public void setLawyer_list(List<LawyerListBean> lawyer_list) {
            this.lawyer_list = lawyer_list;
        }

        public static class LawyerListBean extends Domine{
            /**
             * lawyer_id : 21
             * company_id : 1
             * customer_id : 0
             * vendor_id :
             * law_firm :
             * first_name :
             * surname :
             * abn_sign :
             * acn_sign :
             * type : 0
             * lawyer_tel :
             * lawyer_email : 111@QQ.COM
             * lawyer_fax :
             * lawyer_sex : 0
             * unit_number :
             * street_number :
             * street_address_1 :
             * street_address_2 :
             * suburb :
             * state :
             * postcode :
             * country :
             * add_time : 1492159412
             * add_ip : 116.231.51.223
             * add_admin :
             * status : 0
             */
            private boolean isFirst;
            private int lawyer_id;
            private int company_id;
            private int customer_id;
            private String vendor_id;
            private String law_firm;
            private String first_name;
            private String surname;
            private String abn_sign;
            private String acn_sign;
            private int type;
            private String lawyer_tel;
            private String lawyer_email;
            private String lawyer_fax;
            private int lawyer_sex;
            private String unit_number;
            private String street_number;
            private String street_address_1;
            private String street_address_2;
            private String suburb;
            private String state;
            private String postcode;
            private String country;
            private String add_time;
            private String add_ip;
            private String add_admin;
            private int status;

            public boolean isFirst() {
                return isFirst;
            }

            public void setFirst(boolean first) {
                isFirst = first;
            }

            public int getLawyer_id() {
                return lawyer_id;
            }

            public void setLawyer_id(int lawyer_id) {
                this.lawyer_id = lawyer_id;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(int customer_id) {
                this.customer_id = customer_id;
            }

            public String getVendor_id() {
                return vendor_id;
            }

            public void setVendor_id(String vendor_id) {
                this.vendor_id = vendor_id;
            }

            public String getLaw_firm() {
                return law_firm;
            }

            public void setLaw_firm(String law_firm) {
                this.law_firm = law_firm;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getAbn_sign() {
                return abn_sign;
            }

            public void setAbn_sign(String abn_sign) {
                this.abn_sign = abn_sign;
            }

            public String getAcn_sign() {
                return acn_sign;
            }

            public void setAcn_sign(String acn_sign) {
                this.acn_sign = acn_sign;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getLawyer_tel() {
                return lawyer_tel;
            }

            public void setLawyer_tel(String lawyer_tel) {
                this.lawyer_tel = lawyer_tel;
            }

            public String getLawyer_email() {
                return lawyer_email;
            }

            public void setLawyer_email(String lawyer_email) {
                this.lawyer_email = lawyer_email;
            }

            public String getLawyer_fax() {
                return lawyer_fax;
            }

            public void setLawyer_fax(String lawyer_fax) {
                this.lawyer_fax = lawyer_fax;
            }

            public int getLawyer_sex() {
                return lawyer_sex;
            }

            public void setLawyer_sex(int lawyer_sex) {
                this.lawyer_sex = lawyer_sex;
            }

            public String getUnit_number() {
                return unit_number;
            }

            public void setUnit_number(String unit_number) {
                this.unit_number = unit_number;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getStreet_address_1() {
                return street_address_1;
            }

            public void setStreet_address_1(String street_address_1) {
                this.street_address_1 = street_address_1;
            }

            public String getStreet_address_2() {
                return street_address_2;
            }

            public void setStreet_address_2(String street_address_2) {
                this.street_address_2 = street_address_2;
            }

            public String getSuburb() {
                return suburb;
            }

            public void setSuburb(String suburb) {
                this.suburb = suburb;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getAdd_ip() {
                return add_ip;
            }

            public void setAdd_ip(String add_ip) {
                this.add_ip = add_ip;
            }

            public String getAdd_admin() {
                return add_admin;
            }

            public void setAdd_admin(String add_admin) {
                this.add_admin = add_admin;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
