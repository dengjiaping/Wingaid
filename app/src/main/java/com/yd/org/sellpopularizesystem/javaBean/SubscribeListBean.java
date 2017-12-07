package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/5/12.
 */

public class SubscribeListBean {

    /**
     * code : 1
     * msg : 获取成功
     * total_number : 1
     * result : [{"o_log_id":4,"company_id":1,"user_id":100048,"title":"2375D905-57B9-478E-8A32-3AA1DC88298F:BB89A4B9-BEBE-4804-9EBC-9EB5DE83CF13","customer_id":3684,"content":"The ","add_time":1494569030,"order_time":1494749015,"cue_time":1494655422,"cue_every_time":3600,"update_time":1494569030,"add_ip":"101.81.231.191","is_tixing":0,"status":0,"surname":"Liu","first_name":"Peng","en_name":"Aaron"}]
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

    public static class ResultBean extends Domine{
        /**
         * o_log_id : 4
         * company_id : 1
         * user_id : 100048
         * title : 2375D905-57B9-478E-8A32-3AA1DC88298F:BB89A4B9-BEBE-4804-9EBC-9EB5DE83CF13
         * customer_id : 3684
         * content : The
         * add_time : 1494569030
         * order_time : 1494749015
         * cue_time : 1494655422
         * cue_every_time : 3600
         * update_time : 1494569030
         * add_ip : 101.81.231.191
         * is_tixing : 0
         * status : 0
         * surname : Liu
         * first_name : Peng
         * en_name : Aaron
         */

        private int o_log_id;
        private int company_id;
        private int user_id;
        private String title;
        private int customer_id;
        private String content;
        private int add_time;
        private long order_time;
        private long cue_time;
        private int cue_every_time;
        private int update_time;
        private String add_ip;
        private int is_tixing;
        private int status;
        private String surname;
        private String first_name;
        private String en_name;

        public int getO_log_id() {
            return o_log_id;
        }

        public void setO_log_id(int o_log_id) {
            this.o_log_id = o_log_id;
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

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public long getOrder_time() {
            return order_time;
        }

        public void setOrder_time(long order_time) {
            this.order_time = order_time;
        }

        public long getCue_time() {
            return cue_time;
        }

        public void setCue_time(long cue_time) {
            this.cue_time = cue_time;
        }

        public int getCue_every_time() {
            return cue_every_time;
        }

        public void setCue_every_time(int cue_every_time) {
            this.cue_every_time = cue_every_time;
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

        public int getIs_tixing() {
            return is_tixing;
        }

        public void setIs_tixing(int is_tixing) {
            this.is_tixing = is_tixing;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
