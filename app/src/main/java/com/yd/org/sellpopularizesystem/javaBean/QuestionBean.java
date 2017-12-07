package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/3/14.
 */

public class QuestionBean {
        /**
         * check_id : 22
         * company_id : 1
         * type : 1
         * check_title : public function
         * add_time : 1488510364
         * add_ip :
         * add_admin : 0
         * status : 0
         * id : 80
         * paper_id : 7
         * sort : 99
         * options : [{"option_name":"错误","option_id":82},{"option_name":"正确","option_id":81}]
         */

        private int check_id;
        private int company_id;
        private int type;
        private String check_title;
        private int add_time;
        private String add_ip;
        private int add_admin;
        private int status;
        private int id;
        private int paper_id;
        private int sort;
        private List<OptionBean> options;

        public int getCheck_id() {
            return check_id;
        }

        public void setCheck_id(int check_id) {
            this.check_id = check_id;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCheck_title() {
            return check_title;
        }

        public void setCheck_title(String check_title) {
            this.check_title = check_title;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPaper_id() {
            return paper_id;
        }

        public void setPaper_id(int paper_id) {
            this.paper_id = paper_id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public List<OptionBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionBean> options) {
            this.options = options;
        }
}
