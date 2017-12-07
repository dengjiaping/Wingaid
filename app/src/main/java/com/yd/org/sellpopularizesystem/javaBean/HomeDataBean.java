package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by bai on 2017/1/16.
 */

public class HomeDataBean extends Domine {


    /**
     * code : 1
     * msg : 成功获取首页数据
     * result : {"total_product":6,"new_product":6,"total_customer":3,"new_customer":3,"total_study":0,"uncheck":0,"unread":11}
     */

    private int code;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * total_product : 6
         * new_product : 6
         * total_customer : 3
         * new_customer : 3
         * total_study : 0
         * uncheck : 0
         * unread : 11
         */

        private int total_product;
        private int new_product;
        private int total_customer;
        private int new_customer;
        private int total_study;
        private int uncheck;
        private int unread;

        public int getTotal_product() {
            return total_product;
        }

        public void setTotal_product(int total_product) {
            this.total_product = total_product;
        }

        public int getNew_product() {
            return new_product;
        }

        public void setNew_product(int new_product) {
            this.new_product = new_product;
        }

        public int getTotal_customer() {
            return total_customer;
        }

        public void setTotal_customer(int total_customer) {
            this.total_customer = total_customer;
        }

        public int getNew_customer() {
            return new_customer;
        }

        public void setNew_customer(int new_customer) {
            this.new_customer = new_customer;
        }

        public int getTotal_study() {
            return total_study;
        }

        public void setTotal_study(int total_study) {
            this.total_study = total_study;
        }

        public int getUncheck() {
            return uncheck;
        }

        public void setUncheck(int uncheck) {
            this.uncheck = uncheck;
        }

        public int getUnread() {
            return unread;
        }

        public void setUnread(int unread) {
            this.unread = unread;
        }
    }
}
