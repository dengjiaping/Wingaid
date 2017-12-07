package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by e-dot on 2017/9/19.
 */

public class ReceiptBean extends Domine {

    /**
     * code : 1
     * msg : 获取成功
     * result : {"user_name":"liaoliao","product":"Deposit for APT-Blacktown Project Lot 42","number":"$300.00"}
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

    public static class ResultBean extends Domine {
        /**
         * user_name : liaoliao
         * product : Deposit for APT-Blacktown Project Lot 42
         * number : $300.00
         */

        private String user_name;
        private String product;
        private String number;
        private String check_time;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getCheck_time() {
            return check_time;
        }

        public void setCheck_time(String check_time) {
            this.check_time = check_time;
        }
    }
}
