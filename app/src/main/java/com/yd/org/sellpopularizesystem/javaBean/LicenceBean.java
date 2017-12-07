package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by ${bai} on 17/7/15.
 */

public class LicenceBean extends Domine {
    /**
     * code : 1
     * msg : 获取成功
     * result : {"licence_id":126,"company_id":"1","user_id":"501","type":1,"licence_name":"Certificate of Registration","abn":"","acn":"","is_gst":0,"request_notes":"","effective_date":"1503808624.583951","expiry_date":"1503808624.70746","licence_type":1,"licence_number":"1111","licence_file":"public/uploads/licence/170827/201708271238282011.jpg","reject_reason":"","add_time":"1503808708","add_ip":"116.237.192.15","add_admin":"","status":0}
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

    public static class ResultBean extends Domine{
        /**
         * licence_id : 126
         * company_id : 1
         * user_id : 501
         * type : 1
         * licence_name : Certificate of Registration
         * abn :
         * acn :
         * is_gst : 0
         * request_notes :
         * effective_date : 1503808624.583951
         * expiry_date : 1503808624.70746
         * licence_type : 1
         * licence_number : 1111
         * licence_file : public/uploads/licence/170827/201708271238282011.jpg
         * reject_reason :
         * add_time : 1503808708
         * add_ip : 116.237.192.15
         * add_admin :
         * status : 0
         */

        private int licence_id;
        private String company_id;
        private String user_id;
        private int type;
        private String licence_name;
        private String abn;
        private String acn;
        private int is_gst;
        private String request_notes;
        private String effective_date;
        private String expiry_date;
        private int licence_type;
        private String licence_number;
        private String licence_file;
        private String reject_reason;
        private String add_time;
        private String add_ip;
        private String add_admin;
        private int status;

        public int getLicence_id() {
            return licence_id;
        }

        public void setLicence_id(int licence_id) {
            this.licence_id = licence_id;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getLicence_name() {
            return licence_name;
        }

        public void setLicence_name(String licence_name) {
            this.licence_name = licence_name;
        }

        public String getAbn() {
            return abn;
        }

        public void setAbn(String abn) {
            this.abn = abn;
        }

        public String getAcn() {
            return acn;
        }

        public void setAcn(String acn) {
            this.acn = acn;
        }

        public int getIs_gst() {
            return is_gst;
        }

        public void setIs_gst(int is_gst) {
            this.is_gst = is_gst;
        }

        public String getRequest_notes() {
            return request_notes;
        }

        public void setRequest_notes(String request_notes) {
            this.request_notes = request_notes;
        }

        public String getEffective_date() {
            return effective_date;
        }

        public void setEffective_date(String effective_date) {
            this.effective_date = effective_date;
        }

        public String getExpiry_date() {
            return expiry_date;
        }

        public void setExpiry_date(String expiry_date) {
            this.expiry_date = expiry_date;
        }

        public int getLicence_type() {
            return licence_type;
        }

        public void setLicence_type(int licence_type) {
            this.licence_type = licence_type;
        }

        public String getLicence_number() {
            return licence_number;
        }

        public void setLicence_number(String licence_number) {
            this.licence_number = licence_number;
        }

        public String getLicence_file() {
            return licence_file;
        }

        public void setLicence_file(String licence_file) {
            this.licence_file = licence_file;
        }

        public String getReject_reason() {
            return reject_reason;
        }

        public void setReject_reason(String reject_reason) {
            this.reject_reason = reject_reason;
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
    }
}
