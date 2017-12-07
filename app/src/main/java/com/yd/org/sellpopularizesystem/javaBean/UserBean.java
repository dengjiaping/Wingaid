package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by bai on 2017/1/13.
 */

public class UserBean extends Domine {
    /**
     * code : 1
     * msg : 登录成功！
     * result : {"company_id":1,"user_id":501,"account":"test11","password":"e10adc3949ba59abbe56e057f20f883e","type":1,"first_name":"iO","surname":"An","mobile":"18217608367","e_mail":"11@QQ.com","sales_logo":"public/uploads/user/170826/201708261450086602.jpg","refer_code":"000501","is_active":0,"status":0,"head_img":"public/uploads/user/170826/201708261450086602.jpg"}
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

    public static class ResultBean extends Domine{
        /**
         * company_id : 1
         * user_id : 501
         * account : test11
         * password : e10adc3949ba59abbe56e057f20f883e
         * type : 1
         * first_name : iO
         * surname : An
         * mobile : 18217608367
         * e_mail : 11@QQ.com
         * sales_logo : public/uploads/user/170826/201708261450086602.jpg
         * refer_code : 000501
         * is_active : 0
         * status : 0
         * head_img : public/uploads/user/170826/201708261450086602.jpg
         */

        private int company_id;
        private int user_id;
        private String account;
        private String password;
        private int type=1;
        private String first_name;
        private String surname;
        private String mobile;
        private String e_mail;
        private String sales_logo;
        private String refer_code;
        private int is_active;
        private int status;
        private String head_img;

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

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getE_mail() {
            return e_mail;
        }

        public void setE_mail(String e_mail) {
            this.e_mail = e_mail;
        }

        public String getSales_logo() {
            return sales_logo;
        }

        public void setSales_logo(String sales_logo) {
            this.sales_logo = sales_logo;
        }

        public String getRefer_code() {
            return refer_code;
        }

        public void setRefer_code(String refer_code) {
            this.refer_code = refer_code;
        }

        public int getIs_active() {
            return is_active;
        }

        public void setIs_active(int is_active) {
            this.is_active = is_active;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }
    }
}
