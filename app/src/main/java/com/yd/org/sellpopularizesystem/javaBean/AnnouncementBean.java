package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/3/13.
 */

public class AnnouncementBean extends Domine{
    /**
     * code : 1
     * msg : 成功获取公告列表
     * total_number : 12
     * result : [{"id":19581,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"支付定金 成功预定后 {{审核定金成功发给推荐人}}","content":"祝贺您的客户 － android.android 001，  成功预订了 APT-Rousehill Stage 2 - Building ABC的  47/C308 ！  负责这个销售合同的销售人员是  liao . liao 在此友情提醒您：您的客户需要在14 个自然日里完成合同签署， 并且支付10% 定金， 否则开发商将取消他的合同，他所预定的物业也会被返回市场出售。  我们希望您和销售人员有很好的合作， 助客户在规定的时间内完成合同交换的事宜。\u2014\u2014赢家系统 ","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":0,"fasong_time":0,"read_time":1505292725,"about_id":0,"about_table":"customer","is_read":1,"is_del":0},{"id":19577,"cate_id":4,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"订单：2787定金已审核，请进行下一步操作","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505291912,"fasong_time":0,"read_time":0,"about_id":2787,"about_table":"product_orders","is_read":0,"is_del":0},{"id":19560,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"a51c4c3a293d3b1218f1893b4c94c53e","title":"订房通知","content":"恭喜销售liao . liao于2017-09-13成功预定项目APT - Parramatta Imperial Tower A单元73，总价910000.00","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505290266,"fasong_time":0,"read_time":1505291818,"about_id":0,"about_table":"product_orders","is_read":1,"is_del":0},{"id":19503,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"订房通知 销售版","content":"恭喜销售liao . liao于2017-09-13成功预定项目APT-Rousehill Stage 2 - Building ABC单元47，总价705000.00","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505287631,"fasong_time":0,"read_time":1505291808,"about_id":0,"about_table":"product_orders","is_read":1,"is_del":0},{"id":19458,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户android 008android 008","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286896,"fasong_time":0,"read_time":1505289101,"about_id":0,"about_table":"customer","is_read":1,"is_del":0},{"id":19456,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户androidandroid 007","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286817,"fasong_time":0,"read_time":1505289112,"about_id":0,"about_table":"customer","is_read":1,"is_del":0},{"id":19454,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户androidandroid 006","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286754,"fasong_time":0,"read_time":0,"about_id":0,"about_table":"customer","is_read":0,"is_del":0},{"id":19452,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户androidandroid 005","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286613,"fasong_time":0,"read_time":0,"about_id":0,"about_table":"customer","is_read":0,"is_del":0},{"id":19450,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户androidandroid 004","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286494,"fasong_time":0,"read_time":0,"about_id":0,"about_table":"customer","is_read":0,"is_del":0},{"id":19448,"cate_id":2,"notice_info_id":0,"user_id":"623","client_id":"ba9742f7136bcf8354b2a544bd64cbed","title":"推荐人新注册客户androidandroid 003","content":"","status":0,"is_xunhuan":0,"xunhuan_time":0,"add_time":1505286427,"fasong_time":0,"read_time":0,"about_id":0,"about_table":"customer","is_read":0,"is_del":0}]
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

    public static class ResultBean extends Domine{
        /**
         * id : 19581
         * cate_id : 2
         * notice_info_id : 0
         * user_id : 623
         * client_id : ba9742f7136bcf8354b2a544bd64cbed
         * title : 支付定金 成功预定后 {{审核定金成功发给推荐人}}
         * content : 祝贺您的客户 － android.android 001，  成功预订了 APT-Rousehill Stage 2 - Building ABC的  47/C308 ！  负责这个销售合同的销售人员是  liao . liao 在此友情提醒您：您的客户需要在14 个自然日里完成合同签署， 并且支付10% 定金， 否则开发商将取消他的合同，他所预定的物业也会被返回市场出售。  我们希望您和销售人员有很好的合作， 助客户在规定的时间内完成合同交换的事宜。——赢家系统
         * status : 0
         * is_xunhuan : 0
         * xunhuan_time : 0
         * add_time : 0
         * fasong_time : 0
         * read_time : 1505292725
         * about_id : 0
         * about_table : customer
         * is_read : 1
         * is_del : 0
         */

        private int id;
        private int cate_id;
        private int notice_info_id;
        private String user_id;
        private String client_id;
        private String title;
        private String content;
        private int status;
        private int is_xunhuan;
        private int xunhuan_time;
        private int add_time;
        private int fasong_time;
        private int read_time;
        private int about_id;
        private String about_table;
        private int is_read;
        private int is_del;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public int getNotice_info_id() {
            return notice_info_id;
        }

        public void setNotice_info_id(int notice_info_id) {
            this.notice_info_id = notice_info_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIs_xunhuan() {
            return is_xunhuan;
        }

        public void setIs_xunhuan(int is_xunhuan) {
            this.is_xunhuan = is_xunhuan;
        }

        public int getXunhuan_time() {
            return xunhuan_time;
        }

        public void setXunhuan_time(int xunhuan_time) {
            this.xunhuan_time = xunhuan_time;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getFasong_time() {
            return fasong_time;
        }

        public void setFasong_time(int fasong_time) {
            this.fasong_time = fasong_time;
        }

        public int getRead_time() {
            return read_time;
        }

        public void setRead_time(int read_time) {
            this.read_time = read_time;
        }

        public int getAbout_id() {
            return about_id;
        }

        public void setAbout_id(int about_id) {
            this.about_id = about_id;
        }

        public String getAbout_table() {
            return about_table;
        }

        public void setAbout_table(String about_table) {
            this.about_table = about_table;
        }

        public int getIs_read() {
            return is_read;
        }

        public void setIs_read(int is_read) {
            this.is_read = is_read;
        }

        public int getIs_del() {
            return is_del;
        }

        public void setIs_del(int is_del) {
            this.is_del = is_del;
        }
    }
}
