package com.yd.org.sellpopularizesystem.javaBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bai on 2017/1/19.
 */

public class ExamlineBean extends Domine {

    /**
     * code : 1
     * msg : 成功获取试卷列表
     * total_number : 3
     * result : [{"paper_id":4,"company_id":1,"study_id":7,"paper_title":"第一节2测试","type_id":0,"thumb":"public/uploads/paper_thumb/170119/201701190901519320.jpg","description":"驱蚊器翁群翁群无","stop_time":1485360000,"add_time":1484805939,"add_ip":"","add_admin":0,"status":0,"id":243,"user_id":12,"sort":99,"can_check":0,"is_check":0,"type_name":null,"answer_id":null},{"paper_id":2,"company_id":1,"study_id":6,"paper_title":"第一节测试","type_id":0,"thumb":"public/uploads/paper_thumb/170118/201701181003276684.jpg","description":"","stop_time":1485273600,"add_time":1484805935,"add_ip":"","add_admin":0,"status":0,"id":238,"user_id":12,"sort":99,"can_check":0,"is_check":0,"type_name":null,"answer_id":null},{"paper_id":3,"company_id":1,"study_id":8,"paper_title":"第四节测试","type_id":0,"thumb":"public/uploads/paper_thumb/170118/201701181402498171.jpg","description":"","stop_time":1485792000,"add_time":1484805943,"add_ip":"","add_admin":0,"status":0,"id":248,"user_id":12,"sort":99,"can_check":0,"is_check":0,"type_name":null,"answer_id":null}]
     */

    private String code;
    private String msg;
    private int total_number;
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

    public static class ResultBean implements Serializable{
        /**
         * paper_id : 4
         * company_id : 1
         * study_id : 7
         * paper_title : 第一节2测试
         * type_id : 0
         * thumb : public/uploads/paper_thumb/170119/201701190901519320.jpg
         * description : 驱蚊器翁群翁群无
         * stop_time : 1485360000
         * add_time : 1484805939
         * add_ip :
         * add_admin : 0
         * status : 0
         * id : 243
         * user_id : 12
         * sort : 99
         * can_check : 0
         * is_check : 0
         * type_name : null
         * answer_id : null
         */

        private int paper_id;
        private int company_id;
        private int study_id;
        private String paper_title;
        private int type_id;
        private String thumb;
        private String description;
        private long stop_time;
        private long add_time;
        private String add_ip;
        private int add_admin;
        private int status;
        private int id;
        private int user_id;
        private int sort;
        private int can_check;
        private int is_check;
        private Object type_name;
        private Object answer_id;

        public int getPaper_id() {
            return paper_id;
        }

        public void setPaper_id(int paper_id) {
            this.paper_id = paper_id;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getStudy_id() {
            return study_id;
        }

        public void setStudy_id(int study_id) {
            this.study_id = study_id;
        }

        public String getPaper_title() {
            return paper_title;
        }

        public void setPaper_title(String paper_title) {
            this.paper_title = paper_title;
        }

        public int getType_id() {
            return type_id;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getStop_time() {
            return stop_time;
        }

        public void setStop_time(long stop_time) {
            this.stop_time = stop_time;
        }

        public long getAdd_time() {
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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getCan_check() {
            return can_check;
        }

        public void setCan_check(int can_check) {
            this.can_check = can_check;
        }

        public int getIs_check() {
            return is_check;
        }

        public void setIs_check(int is_check) {
            this.is_check = is_check;
        }

        public Object getType_name() {
            return type_name;
        }

        public void setType_name(Object type_name) {
            this.type_name = type_name;
        }

        public Object getAnswer_id() {
            return answer_id;
        }

        public void setAnswer_id(Object answer_id) {
            this.answer_id = answer_id;
        }
    }
}
