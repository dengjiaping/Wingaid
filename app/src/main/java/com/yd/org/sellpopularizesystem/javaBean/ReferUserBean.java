package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/8/29.
 */

public class ReferUserBean extends Domine{


    /**
     * code : 1
     * msg : 成功获取用户列表
     * total_number : 6
     * result : [{"user_id":194,"first_name":"Lixin","surname":"Jia"},{"user_id":195,"first_name":"Feifei","surname":"Ma"},{"user_id":196,"first_name":"Min","surname":"Gong"},{"user_id":197,"first_name":"Shuai","surname":"Yuan"},{"user_id":501,"first_name":"iO","surname":"An"},{"user_id":501,"first_name":"iO","surname":"An"}]
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

    public static class ResultBean extends Domine{

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        private String sortLetters;

        /**
         * user_id : 194
         * first_name : Lixin
         * surname : Jia
         */

        private int user_id;
        private String first_name;
        private String surname;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
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
    }
}
