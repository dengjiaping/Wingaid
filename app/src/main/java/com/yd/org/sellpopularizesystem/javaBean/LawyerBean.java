package com.yd.org.sellpopularizesystem.javaBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hejin on 2017/4/1.
 */

public class LawyerBean extends Domine{

    /**
     * code : 1
     * msg : 成功获取律师列表
     * result : [{"lawyer_id":8,"company_id":3,"customer_id":0,"lawyer_name":"测试律师01","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"13911111111","lawyer_email":"lenka.zheng@qq.com","lawyer_fax":"","lawyer_sex":1,"add_time":"1490411451","add_ip":"117.84.78.214, ","add_admin":"12","status":0},{"lawyer_id":7,"company_id":1,"customer_id":0,"lawyer_name":"qwewqeqw","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"12312312","lawyer_email":"qweqweqwe@qq.com","lawyer_fax":"","lawyer_sex":1,"add_time":"1490411342","add_ip":"117.84.78.214","add_admin":"3","status":0},{"lawyer_id":6,"company_id":1,"customer_id":0,"lawyer_name":" 国防部：敦促日方恪守走和平发展道路的承诺","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"2324","lawyer_email":"rtgt@fg.gh","lawyer_fax":"","lawyer_sex":0,"add_time":"1487898756","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":5,"company_id":1,"customer_id":0,"lawyer_name":"自然好味道","abn_sign":"","acn_sign":"","type":0,"lawyer_tel":"4008006465","lawyer_email":"fsf@d.dd","lawyer_fax":"","lawyer_sex":0,"add_time":"1487898748","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":1,"company_id":1,"customer_id":0,"lawyer_name":"齐大大","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1234","lawyer_email":"15252132437@qq.com","lawyer_fax":"","lawyer_sex":1,"add_time":"1487898733","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":2,"company_id":1,"customer_id":87,"lawyer_name":"梅须逊雪三分白","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"543543","lawyer_email":"3234@er.dd","lawyer_fax":"","lawyer_sex":0,"add_time":"1487898718","add_ip":"117.84.37.76","add_admin":"4","status":0},{"lawyer_id":3,"company_id":1,"customer_id":0,"lawyer_name":"44","abn_sign":"","acn_sign":"","type":1,"lawyer_tel":"1323","lawyer_email":"gytry@fg.yg","lawyer_fax":"","lawyer_sex":1,"add_time":"1487898696","add_ip":"117.84.37.76","add_admin":"4","status":0}]
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

    public static class ResultBean implements Serializable{
        /**
         * lawyer_id : 8
         * company_id : 3
         * customer_id : 0
         * lawyer_name : 测试律师01
         * abn_sign :
         * acn_sign :
         * type : 1
         * lawyer_tel : 13911111111
         * lawyer_email : lenka.zheng@qq.com
         * lawyer_fax :
         * lawyer_sex : 1
         * add_time : 1490411451
         * add_ip : 117.84.78.214,
         * add_admin : 12
         * status : 0
         */

        private int lawyer_id;
        private int company_id;
        private int customer_id;
        private String lawyer_name;
        private String abn_sign;
        private String acn_sign;
        private int type;
        private String lawyer_tel;
        private String lawyer_email;
        private String lawyer_fax;
        private int lawyer_sex;
        private String add_time;
        private String add_ip;
        private String add_admin;
        private int status;
        private String sortLetters;

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

        public String getLawyer_name() {
            return lawyer_name;
        }

        public void setLawyer_name(String lawyer_name) {
            this.lawyer_name = lawyer_name;
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

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }
    }
}
