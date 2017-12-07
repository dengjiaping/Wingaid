package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by bai on 2017/1/19.
 */

public class StudyBean extends Domine {

    /**
     * code : 1
     * total_number : 1
     * msg : 成功获取学习列表
     * result : [{"study_id":9,"company_id":1,"study_title":"第3节内容","type_id":1,"description":"","thumb":"public/uploads/study_thumb/170116/201701161412441709.jpg","study_number":null,"add_time":1484788528,"add_ip":"","add_admin":0,"status":1,"chapter":"3.1.1.1","id":341,"user_id":12,"can_study":1,"is_study":0,"sort":99,"paper_id":null}]
     */

    private String code;
    private int total_number;
    private String msg;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
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
         * study_id : 9
         * company_id : 1
         * study_title : 第3节内容
         * type_id : 1
         * description :
         * thumb : public/uploads/study_thumb/170116/201701161412441709.jpg
         * study_number : null
         * add_time : 1484788528
         * add_ip :
         * add_admin : 0
         * status : 1
         * chapter : 3.1.1.1
         * id : 341
         * user_id : 12
         * can_study : 1
         * is_study : 0
         * sort : 99
         * paper_id : null
         */

        private String study_id;
        private int company_id;
        private String study_title;
        private int type_id;
        private String description;
        private String thumb;
        private Object study_number;
        private int add_time;
        private String add_ip;
        private int add_admin;
        private int status;
        private String chapter;
        private int id;
        private int user_id;
        private int can_study;
        private int is_study;
        private int sort;
        private Object paper_id;

        public String getStudy_id() {
            return study_id;
        }

        public void setStudy_id(String study_id) {
            this.study_id = study_id;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getStudy_title() {
            return study_title;
        }

        public void setStudy_title(String study_title) {
            this.study_title = study_title;
        }

        public int getType_id() {
            return type_id;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Object getStudy_number() {
            return study_number;
        }

        public void setStudy_number(Object study_number) {
            this.study_number = study_number;
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

        public String getChapter() {
            return chapter;
        }

        public void setChapter(String chapter) {
            this.chapter = chapter;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCan_study() {
            return can_study;
        }

        public void setCan_study(int can_study) {
            this.can_study = can_study;
        }

        public int getIs_study() {
            return is_study;
        }

        public void setIs_study(int is_study) {
            this.is_study = is_study;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public Object getPaper_id() {
            return paper_id;
        }

        public void setPaper_id(Object paper_id) {
            this.paper_id = paper_id;
        }
    }
}
