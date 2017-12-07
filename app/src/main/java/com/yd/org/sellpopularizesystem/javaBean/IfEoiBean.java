package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/10/26.
 */

public class IfEoiBean extends Domine{


    /**
     * code : 1
     * msg : 可以使用EOI下单
     * result : [{"eoi_id":1015,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":92,"product_childs_id":3503,"pay_method":1,"amount":"300","evidence":"public/uploads/eoi_money_new/20171026/f111c608f2c087e47f69be190b5ab8cb.jpg","add_time":1508996691,"add_ip":"114.91.119.226","check_time":1508999045,"refund_time":0,"if_pay":1,"status":1}]
     */

    private String code;
    private String msg;
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean extends Domine{
        /**
         * eoi_id : 1015
         * company_id : 1
         * user_id : 1070
         * customer_id : 6899
         * product_id : 92
         * product_childs_id : 3503
         * pay_method : 1
         * amount : 300
         * evidence : public/uploads/eoi_money_new/20171026/f111c608f2c087e47f69be190b5ab8cb.jpg
         * add_time : 1508996691
         * add_ip : 114.91.119.226
         * check_time : 1508999045
         * refund_time : 0
         * if_pay : 1
         * status : 1
         */

        private int eoi_id;
        private int company_id;
        private int user_id;
        private int customer_id;
        private int product_id;
        private int product_childs_id;
        private int pay_method;
        private String amount;
        private String evidence;
        private int add_time;
        private String add_ip;
        private int check_time;
        private int refund_time;
        private int if_pay;
        private int status;

        public int getEoi_id() {
            return eoi_id;
        }

        public void setEoi_id(int eoi_id) {
            this.eoi_id = eoi_id;
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

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public int getProduct_childs_id() {
            return product_childs_id;
        }

        public void setProduct_childs_id(int product_childs_id) {
            this.product_childs_id = product_childs_id;
        }

        public int getPay_method() {
            return pay_method;
        }

        public void setPay_method(int pay_method) {
            this.pay_method = pay_method;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getEvidence() {
            return evidence;
        }

        public void setEvidence(String evidence) {
            this.evidence = evidence;
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

        public int getCheck_time() {
            return check_time;
        }

        public void setCheck_time(int check_time) {
            this.check_time = check_time;
        }

        public int getRefund_time() {
            return refund_time;
        }

        public void setRefund_time(int refund_time) {
            this.refund_time = refund_time;
        }

        public int getIf_pay() {
            return if_pay;
        }

        public void setIf_pay(int if_pay) {
            this.if_pay = if_pay;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
