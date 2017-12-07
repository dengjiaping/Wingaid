package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by e-dot on 2017/10/27.
 */

public class EOIPayBean {

    /**
     * code : 1
     * msg : 充值成功
     * result : {"user_id":"501","customer_id":"4900","product_id":"73","product_childs_id":"2467","pay_method":"6","amount":"2000","add_time":1508998885,"add_ip":"114.91.119.226"}
     * trust_account_id : 942
     */

    private String code;
    private String msg;
    private ResultBean result;
    private String trust_account_id;

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

    public String getTrust_account_id() {
        return trust_account_id;
    }

    public void setTrust_account_id(String trust_account_id) {
        this.trust_account_id = trust_account_id;
    }

    public static class ResultBean extends Domine {
        /**
         * user_id : 501
         * customer_id : 4900
         * product_id : 73
         * product_childs_id : 2467
         * pay_method : 6
         * amount : 2000
         * add_time : 1508998885
         * add_ip : 114.91.119.226
         */

        private String user_id;
        private String customer_id;
        private String product_id;
        private String product_childs_id;
        private String pay_method;
        private String amount;
        private int add_time;
        private String add_ip;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getProduct_childs_id() {
            return product_childs_id;
        }

        public void setProduct_childs_id(String product_childs_id) {
            this.product_childs_id = product_childs_id;
        }

        public String getPay_method() {
            return pay_method;
        }

        public void setPay_method(String pay_method) {
            this.pay_method = pay_method;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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
    }
}
