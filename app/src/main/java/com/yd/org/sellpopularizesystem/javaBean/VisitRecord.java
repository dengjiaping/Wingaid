package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/5/5.
 */

public class VisitRecord extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * total_number : 11
     * result : [{"v_log_id":14,"company_id":1,"user_id":100009,"title":"这是一条拜访记录标题","customer_id":90,"content":"这是一条拜访记录内容","add_time":1491543700,"visit_time":111,"update_time":1491543700,"add_ip":"117.84.36.145","surname":"xiao","first_name":"er","en_name":"littler ER"},{"v_log_id":4,"company_id":0,"user_id":100009,"title":"这是一条拜访记录标题","customer_id":90,"content":"这是一条拜访记录内容","add_time":1491464779,"visit_time":0,"update_time":0,"add_ip":"117.84.36.145","surname":"xiao","first_name":"er","en_name":"littler ER"},{"v_log_id":3,"company_id":1,"user_id":100009,"title":"这是一条拜访记录标题","customer_id":90,"content":"这是一条拜访记录内容","add_time":1491465319,"visit_time":0,"update_time":0,"add_ip":"117.84.36.145","surname":"xiao","first_name":"er","en_name":"littler ER"},{"v_log_id":5,"company_id":1,"user_id":100009,"title":"这是一条拜访记录标题","customer_id":90,"content":"这是一条拜访记录内容","add_time":1491465465,"visit_time":0,"update_time":0,"add_ip":"117.84.36.145","surname":"xiao","first_name":"er","en_name":"littler ER"},{"v_log_id":6,"company_id":1,"user_id":100009,"title":"这是一条拜访记录标题","customer_id":90,"content":"这是一条拜访记录内容","add_time":1491465466,"visit_time":0,"update_time":0,"add_ip":"117.84.36.145","surname":"xiao","first_name":"er","en_name":"littler ER"}]
     */

    private String code;
    private String msg;
    private int total_number;
    private List<ResultBean> result;

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

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * v_log_id : 14
         * company_id : 1
         * user_id : 100009
         * title : 这是一条拜访记录标题
         * customer_id : 90
         * content : 这是一条拜访记录内容
         * add_time : 1491543700
         * visit_time : 111
         * update_time : 1491543700
         * add_ip : 117.84.36.145
         * surname : xiao
         * first_name : er
         * en_name : littler ER
         */

        private int v_log_id;
        private int company_id;
        private int user_id;
        private String title;
        private int customer_id;
        private String content;
        private long add_time;
        private int visit_time;
        private int update_time;
        private String add_ip;
        private String surname;
        private String first_name;
        private String en_name;

        public int getV_log_id() {
            return v_log_id;
        }

        public void setV_log_id(int v_log_id) {
            this.v_log_id = v_log_id;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getVisit_time() {
            return visit_time;
        }

        public void setVisit_time(int visit_time) {
            this.visit_time = visit_time;
        }

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }

        public String getAdd_ip() {
            return add_ip;
        }

        public void setAdd_ip(String add_ip) {
            this.add_ip = add_ip;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getEn_name() {
            return en_name;
        }

        public void setEn_name(String en_name) {
            this.en_name = en_name;
        }
    }
}
