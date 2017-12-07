package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/3/15.
 */

public class GradeBean extends Domine {

    /**
     * code : 1
     * total_answer : 6
     * total_right_answer : 0
     * total_wrong_answer : 6
     * result : [{"logs_id":334,"company_id":0,"user_id":100014,"paper_id":7,"study_id":15,"answer_id":"2017031058317","check_id":22,"correct_answer":"95","user_answer":"82","check_result":"0","add_time":1489110139,"add_ip":"116.231.51.134","status":0,"check_title":"public function","options":[{"option_id":82,"option_name":"错误","is_true":0},{"option_id":81,"option_name":"正确","is_true":0}]},{"logs_id":335,"company_id":0,"user_id":100014,"paper_id":7,"study_id":15,"answer_id":"2017031058317","check_id":15,"correct_answer":"95","user_answer":"85,86","check_result":"0","add_time":1489110139,"add_ip":"116.231.51.134","status":0,"check_title":"额uhf","options":[{"option_id":85,"option_name":"你现在的工作","is_true":0},{"option_id":86,"option_name":"你的住址地址","is_true":0},{"option_id":87,"option_name":"工作内容","is_true":0}]},{"logs_id":336,"company_id":0,"user_id":100014,"paper_id":7,"study_id":15,"answer_id":"2017031058317","check_id":21,"correct_answer":"95","user_answer":"92","check_result":"0","add_time":1489110139,"add_ip":"116.231.51.134","status":0,"check_title":"1+1=2","options":[{"option_id":93,"option_name":"错误","is_true":0},{"option_id":92,"option_name":"正确","is_true":0}]},{"logs_id":337,"company_id":0,"user_id":100014,"paper_id":7,"study_id":15,"answer_id":"2017031058317","check_id":18,"correct_answer":"95","user_answer":"65","check_result":"0","add_time":1489110139,"add_ip":"116.231.51.134","status":0,"check_title":"五个、贾平凹i警方无法","options":[{"option_id":64,"option_name":"正确","is_true":0},{"option_id":65,"option_name":"错误","is_true":0}]},{"logs_id":338,"company_id":0,"user_id":100014,"paper_id":7,"study_id":15,"answer_id":"2017031058317","check_id":16,"correct_answer":"95","user_answer":"72","check_result":"0","add_time":1489110139,"add_ip":"116.231.51.134","status":0,"check_title":"额外人而我沃尔特we额外","options":[{"option_id":72,"option_name":"错误","is_true":0},{"option_id":71,"option_name":"正确","is_true":0}]}]
     */

    private String code;
    private int total_answer;
    private int total_right_answer;
    private int total_wrong_answer;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal_answer() {
        return total_answer;
    }

    public void setTotal_answer(int total_answer) {
        this.total_answer = total_answer;
    }

    public int getTotal_right_answer() {
        return total_right_answer;
    }

    public void setTotal_right_answer(int total_right_answer) {
        this.total_right_answer = total_right_answer;
    }

    public int getTotal_wrong_answer() {
        return total_wrong_answer;
    }

    public void setTotal_wrong_answer(int total_wrong_answer) {
        this.total_wrong_answer = total_wrong_answer;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * logs_id : 334
         * company_id : 0
         * user_id : 100014
         * paper_id : 7
         * study_id : 15
         * answer_id : 2017031058317
         * check_id : 22
         * correct_answer : 95
         * user_answer : 82
         * check_result : 0
         * add_time : 1489110139
         * add_ip : 116.231.51.134
         * status : 0
         * check_title : public function
         * options : [{"option_id":82,"option_name":"错误","is_true":0},{"option_id":81,"option_name":"正确","is_true":0}]
         */

        private int logs_id;
        private int company_id;
        private int user_id;
        private int paper_id;
        private int study_id;
        private String answer_id;
        private int check_id;
        private String correct_answer;
        private String user_answer;
        private String check_result;
        private int add_time;
        private String add_ip;
        private int status;
        private String check_title;
        private List<OptionsBean> options;

        public int getLogs_id() {
            return logs_id;
        }

        public void setLogs_id(int logs_id) {
            this.logs_id = logs_id;
        }

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

        public int getPaper_id() {
            return paper_id;
        }

        public void setPaper_id(int paper_id) {
            this.paper_id = paper_id;
        }

        public int getStudy_id() {
            return study_id;
        }

        public void setStudy_id(int study_id) {
            this.study_id = study_id;
        }

        public String getAnswer_id() {
            return answer_id;
        }

        public void setAnswer_id(String answer_id) {
            this.answer_id = answer_id;
        }

        public int getCheck_id() {
            return check_id;
        }

        public void setCheck_id(int check_id) {
            this.check_id = check_id;
        }

        public String getCorrect_answer() {
            return correct_answer;
        }

        public void setCorrect_answer(String correct_answer) {
            this.correct_answer = correct_answer;
        }

        public String getUser_answer() {
            return user_answer;
        }

        public void setUser_answer(String user_answer) {
            this.user_answer = user_answer;
        }

        public String getCheck_result() {
            return check_result;
        }

        public void setCheck_result(String check_result) {
            this.check_result = check_result;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCheck_title() {
            return check_title;
        }

        public void setCheck_title(String check_title) {
            this.check_title = check_title;
        }

        public List<OptionsBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionsBean> options) {
            this.options = options;
        }

        public static class OptionsBean {
            public String getOptionid() {
                return optionid;
            }

            public void setOptionid(String optionid) {
                this.optionid = optionid;
            }

            /**
             * option_id : 82
             * option_name : 错误
             * is_true : 0
             */
            private String optionid;
            private int option_id;
            private String option_name;
            private int is_true;

            public int getOption_id() {
                return option_id;
            }

            public void setOption_id(int option_id) {
                this.option_id = option_id;
            }

            public String getOption_name() {
                return option_name;
            }

            public void setOption_name(String option_name) {
                this.option_name = option_name;
            }

            public int getIs_true() {
                return is_true;
            }

            public void setIs_true(int is_true) {
                this.is_true = is_true;
            }
        }
    }
}
