package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/5/15.
 */

public class PromotionRecordBean extends Domine {

    /**
     * code : 1
     * msg : 成功获取拜访列表
     * total_number : 27
     * result : [{"s_log_id":1,"company_id":1,"product_id":1,"user_id":100048,"customer_id":3684,"team_id":"1","content":null,"start_time":"1494397994","end_time":"1494397996","stay_time":"2秒","gps_x_y":null,"remark":null,"add_time":1494397598,"add_ip":"101.81.231.191","status":0,"product_name":"Bankstown THE Mark","user_first_name":"Lixin","user_surname":"Jia","customer_first_name":null,"customer_surname":null,"customer_en_name":null},{"s_log_id":2,"company_id":1,"product_id":1,"user_id":100048,"customer_id":3684,"team_id":"1","content":null,"start_time":"1494398248","end_time":"1494398257","stay_time":"9秒","gps_x_y":null,"remark":null,"add_time":1494397859,"add_ip":"101.81.231.191","status":0,"product_name":"Bankstown THE Mark","user_first_name":"Lixin","user_surname":"Jia","customer_first_name":null,"customer_surname":null,"customer_en_name":null},{"s_log_id":3,"company_id":1,"product_id":1,"user_id":100048,"customer_id":3684,"team_id":"1","content":null,"start_time":"1494398343","end_time":"1494398346","stay_time":"3秒","gps_x_y":null,"remark":null,"add_time":1494397948,"add_ip":"101.81.231.191","status":0,"product_name":"Bankstown THE Mark","user_first_name":"Lixin","user_surname":"Jia","customer_first_name":null,"customer_surname":null,"customer_en_name":null},{"s_log_id":4,"company_id":1,"product_id":1,"user_id":100048,"customer_id":3684,"team_id":"1","content":null,"start_time":"1494399239","end_time":"1494399244","stay_time":"4秒","gps_x_y":null,"remark":null,"add_time":1494398846,"add_ip":"101.81.231.191","status":0,"product_name":"Bankstown THE Mark","user_first_name":"Lixin","user_surname":"Jia","customer_first_name":null,"customer_surname":null,"customer_en_name":null},{"s_log_id":7,"company_id":1,"product_id":3,"user_id":100048,"customer_id":3684,"team_id":"1","content":null,"start_time":"1494410165","end_time":"1494410176","stay_time":"10秒","gps_x_y":null,"remark":null,"add_time":1494410177,"add_ip":"101.81.231.191","status":0,"product_name":"Leppington Lucere","user_first_name":"Lixin","user_surname":"Jia","customer_first_name":null,"customer_surname":null,"customer_en_name":null}]
     */

    private int code;
    private String msg;
    private int total_number;
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

    public static class ResultBean extends Domine {
        /**
         * s_log_id : 1
         * company_id : 1
         * product_id : 1
         * user_id : 100048
         * customer_id : 3684
         * team_id : 1
         * content : null
         * start_time : 1494397994
         * end_time : 1494397996
         * stay_time : 2秒
         * gps_x_y : null
         * remark : null
         * add_time : 1494397598
         * add_ip : 101.81.231.191
         * status : 0
         * product_name : Bankstown THE Mark
         * user_first_name : Lixin
         * user_surname : Jia
         * customer_first_name : null
         * customer_surname : null
         * customer_en_name : null
         */

        private int s_log_id;
        private int company_id;
        private int product_id;
        private int user_id;
        private int customer_id;
        private String team_id;
        private Object content;
        private String start_time;
        private String end_time;
        private String stay_time;
        private Object gps_x_y;
        private Object remark;
        private int add_time;
        private String add_ip;
        private int status;
        private String product_name;
        private String user_first_name;
        private String user_surname;
        private Object customer_first_name;
        private Object customer_surname;
        private Object customer_en_name;

        public int getS_log_id() {
            return s_log_id;
        }

        public void setS_log_id(int s_log_id) {
            this.s_log_id = s_log_id;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public String getTeam_id() {
            return team_id;
        }

        public void setTeam_id(String team_id) {
            this.team_id = team_id;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getStay_time() {
            return stay_time;
        }

        public void setStay_time(String stay_time) {
            this.stay_time = stay_time;
        }

        public Object getGps_x_y() {
            return gps_x_y;
        }

        public void setGps_x_y(Object gps_x_y) {
            this.gps_x_y = gps_x_y;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public String getAdd_ip() {
            return add_ip;
        }

        public void setAdd_ip(String add_ip) {
            this.add_ip = add_ip;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getUser_first_name() {
            return user_first_name;
        }

        public void setUser_first_name(String user_first_name) {
            this.user_first_name = user_first_name;
        }

        public String getUser_surname() {
            return user_surname;
        }

        public void setUser_surname(String user_surname) {
            this.user_surname = user_surname;
        }

        public Object getCustomer_first_name() {
            return customer_first_name;
        }

        public void setCustomer_first_name(Object customer_first_name) {
            this.customer_first_name = customer_first_name;
        }

        public Object getCustomer_surname() {
            return customer_surname;
        }

        public void setCustomer_surname(Object customer_surname) {
            this.customer_surname = customer_surname;
        }

        public Object getCustomer_en_name() {
            return customer_en_name;
        }

        public void setCustomer_en_name(Object customer_en_name) {
            this.customer_en_name = customer_en_name;
        }
    }
}
