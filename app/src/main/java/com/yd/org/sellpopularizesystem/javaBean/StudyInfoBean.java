package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/5/8.
 */

public class StudyInfoBean extends Domine {


    /**
     * code : 1
     * msg : 成功获取学习详情
     * result : [{"detail_id":6,"study_id":15,"detail_title":"SJOL","description":"FSEFASEFWA发","sort":0,"url":"public/uploads/study_detail/170119/detail_201701191712453026.jpg","old_name":"4.jpg","extension":"jpg","add_time":1484817165,"add_ip":"180.114.133.77","add_admin":4,"status":0}]
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

    public static class ResultBean {
        /**
         * detail_id : 6
         * study_id : 15
         * detail_title : SJOL
         * description : FSEFASEFWA发
         * sort : 0
         * url : public/uploads/study_detail/170119/detail_201701191712453026.jpg
         * old_name : 4.jpg
         * extension : jpg
         * add_time : 1484817165
         * add_ip : 180.114.133.77
         * add_admin : 4
         * status : 0
         */

        private int detail_id;
        private int study_id;
        private String detail_title;
        private String description;
        private int sort;
        private String url;
        private String old_name;
        private String extension;
        private int add_time;
        private String add_ip;
        private int add_admin;
        private int status;

        public int getDetail_id() {
            return detail_id;
        }

        public void setDetail_id(int detail_id) {
            this.detail_id = detail_id;
        }

        public int getStudy_id() {
            return study_id;
        }

        public void setStudy_id(int study_id) {
            this.study_id = study_id;
        }

        public String getDetail_title() {
            return detail_title;
        }

        public void setDetail_title(String detail_title) {
            this.detail_title = detail_title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOld_name() {
            return old_name;
        }

        public void setOld_name(String old_name) {
            this.old_name = old_name;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
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

        public int getAdd_admin() {
            return add_admin;
        }

        public void setAdd_admin(int add_admin) {
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
