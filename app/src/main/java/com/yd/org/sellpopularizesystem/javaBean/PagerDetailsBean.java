package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;
import java.util.Vector;

/**
 * Created by hejin on 2017/3/7.
 */

public class PagerDetailsBean {

    /**
     * code : 1
     * msg : 成功获取试题列表
     * result : [{"check_id":22,"company_id":1,"type":1,"check_title":"public function","add_time":1488510364,"add_ip":"","add_admin":0,"status":0,"id":80,"paper_id":7,"sort":99,"options":[{"option_name":"错误","option_id":82},{"option_name":"正确","option_id":81}]},{"check_id":15,"company_id":1,"type":3,"check_title":"额uhf","add_time":1487402229,"add_ip":"","add_admin":0,"status":0,"id":68,"paper_id":7,"sort":99,"options":[{"option_name":"你现在的工作","option_id":85},{"option_name":"你的住址地址","option_id":86},{"option_name":"工作内容","option_id":87}]},{"check_id":21,"company_id":1,"type":1,"check_title":"1+1=2","add_time":1488510371,"add_ip":"","add_admin":0,"status":0,"id":81,"paper_id":7,"sort":99,"options":[{"option_name":"错误","option_id":93},{"option_name":"正确","option_id":92}]},{"check_id":18,"company_id":1,"type":1,"check_title":"五个、贾平凹i警方无法","add_time":1488510387,"add_ip":"","add_admin":0,"status":0,"id":82,"paper_id":7,"sort":99,"options":[{"option_name":"正确","option_id":64},{"option_name":"错误","option_id":65}]},{"check_id":16,"company_id":1,"type":1,"check_title":"额外人而我沃尔特we额外","add_time":1488510396,"add_ip":"","add_admin":0,"status":0,"id":83,"paper_id":7,"sort":99,"options":[{"option_name":"错误","option_id":72},{"option_name":"正确","option_id":71}]}]
     */

    private String code;
    private String msg;
    private List<QuestionBean> result;

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

    public List<QuestionBean> getResult() {
        return result;
    }

    public void setResult(List<QuestionBean> result) {
        this.result = result;
    }


}
