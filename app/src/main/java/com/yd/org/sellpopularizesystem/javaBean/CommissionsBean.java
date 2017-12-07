package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/5/2.
 */

public class CommissionsBean extends Domine {


    /**
     * code : 1
     * msg : 成功获取佣金列表
     * total_number : 11
     * result : {"amount":29535,"checked":0,"unchecked":5004,"con":4,"datas":[{"id":3536,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":6930,"customer_first_name":"Junghwan","customer_surname":"Byun","customer_en_name":"","order_id":2543,"product_id":3,"product_childs_id":1941,"product_name":"APT-Harris Park Project","product_childs_lot_number":"Shop","product_childs_unit_number":"shop","order_price":"550000.00","commossion":"7500.00","gst":"750.00","total":"8250.00","first_money":"0.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"7500.00","second_gst":"750.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":0,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1509075453,"update_time":1509075453,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":0,"one_invoice_status":4,"two_invoice_status":4,"three_invoice_status":4},{"id":3366,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":5984,"customer_first_name":"Ki ppeum","customer_surname":"Yoon","customer_en_name":"","order_id":2453,"product_id":93,"product_childs_id":3530,"product_name":"Land - Clydesdale Marsden Park 【EOI】","product_childs_lot_number":"1044","product_childs_unit_number":"1044","order_price":"405000.00","commossion":"6075.00","gst":"0.00","total":"6075.00","first_money":"2430.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"3645.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":1,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1506737426,"update_time":1506737426,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":1,"one_invoice_status":1,"two_invoice_status":4,"three_invoice_status":4},{"id":3335,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":6133,"customer_first_name":"Jongpil","customer_surname":"LEE","customer_en_name":"","order_id":2437,"product_id":12,"product_childs_id":2929,"product_name":"House - Box Hill (49 Terry Rd)","product_childs_lot_number":"1","product_childs_unit_number":"1","order_price":"429000.00","commossion":"6435.00","gst":"0.00","total":"6435.00","first_money":"2574.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"3861.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":1,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1505960535,"update_time":1505960535,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":1,"one_invoice_status":1,"two_invoice_status":4,"three_invoice_status":4},{"id":3244,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":5804,"customer_first_name":"Nae","customer_surname":"Kim","customer_en_name":"","order_id":2387,"product_id":21,"product_childs_id":2102,"product_name":"APT-Blacktown Project","product_childs_lot_number":"90","product_childs_unit_number":"1105","order_price":"585000.00","commossion":"8775.00","gst":"0.00","total":"8775.00","first_money":"4387.50","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"4387.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":0,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1503483121,"update_time":1503483121,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":0,"one_invoice_status":4,"two_invoice_status":4,"three_invoice_status":4}]}
     */

    private int code;
    private String msg;
    private int total_number;
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

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean extends Domine{
        /**
         * amount : 29535
         * checked : 0
         * unchecked : 5004
         * con : 4
         * datas : [{"id":3536,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":6930,"customer_first_name":"Junghwan","customer_surname":"Byun","customer_en_name":"","order_id":2543,"product_id":3,"product_childs_id":1941,"product_name":"APT-Harris Park Project","product_childs_lot_number":"Shop","product_childs_unit_number":"shop","order_price":"550000.00","commossion":"7500.00","gst":"750.00","total":"8250.00","first_money":"0.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"7500.00","second_gst":"750.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":0,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1509075453,"update_time":1509075453,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":0,"one_invoice_status":4,"two_invoice_status":4,"three_invoice_status":4},{"id":3366,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":5984,"customer_first_name":"Ki ppeum","customer_surname":"Yoon","customer_en_name":"","order_id":2453,"product_id":93,"product_childs_id":3530,"product_name":"Land - Clydesdale Marsden Park 【EOI】","product_childs_lot_number":"1044","product_childs_unit_number":"1044","order_price":"405000.00","commossion":"6075.00","gst":"0.00","total":"6075.00","first_money":"2430.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"3645.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":1,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1506737426,"update_time":1506737426,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":1,"one_invoice_status":1,"two_invoice_status":4,"three_invoice_status":4},{"id":3335,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":6133,"customer_first_name":"Jongpil","customer_surname":"LEE","customer_en_name":"","order_id":2437,"product_id":12,"product_childs_id":2929,"product_name":"House - Box Hill (49 Terry Rd)","product_childs_lot_number":"1","product_childs_unit_number":"1","order_price":"429000.00","commossion":"6435.00","gst":"0.00","total":"6435.00","first_money":"2574.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"3861.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":1,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1505960535,"update_time":1505960535,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":1,"one_invoice_status":1,"two_invoice_status":4,"three_invoice_status":4},{"id":3244,"company_id":1,"sale_id":396,"user_id":396,"user_first_name":"paul","user_surname":"chung","user_en_name":"","customer_id":5804,"customer_first_name":"Nae","customer_surname":"Kim","customer_en_name":"","order_id":2387,"product_id":21,"product_childs_id":2102,"product_name":"APT-Blacktown Project","product_childs_lot_number":"90","product_childs_unit_number":"1105","order_price":"585000.00","commossion":"8775.00","gst":"0.00","total":"8775.00","first_money":"4387.50","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"4387.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"first_invoice_status":0,"second_invoice_status":0,"third_invoice_status":0,"first_other":"0.00","second_other":"0.00","third_other":"0.00","add_time":1503483121,"update_time":1503483121,"is_value":0,"is_show":1,"status":0,"remark_1":"normal","remark_2":"","is_wait_xingzheng":0,"is_wait_caiwu":0,"is_wait_callback":0,"invoice_number":0,"one_invoice_status":4,"two_invoice_status":4,"three_invoice_status":4}]
         */

        private Object amount;
        private Object checked;
        private Object unchecked;
        private int con;
        private List<DatasBean> datas;

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

        public Object getChecked() {
            return checked;
        }

        public void setChecked(Object checked) {
            this.checked = checked;
        }

        public Object getUnchecked() {
            return unchecked;
        }

        public void setUnchecked(Object unchecked) {
            this.unchecked = unchecked;
        }

        public int getCon() {
            return con;
        }

        public void setCon(int con) {
            this.con = con;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean extends Domine{
            /**
             * id : 3536
             * company_id : 1
             * sale_id : 396
             * user_id : 396
             * user_first_name : paul
             * user_surname : chung
             * user_en_name :
             * customer_id : 6930
             * customer_first_name : Junghwan
             * customer_surname : Byun
             * customer_en_name :
             * order_id : 2543
             * product_id : 3
             * product_childs_id : 1941
             * product_name : APT-Harris Park Project
             * product_childs_lot_number : Shop
             * product_childs_unit_number : shop
             * order_price : 550000.00
             * commossion : 7500.00
             * gst : 750.00
             * total : 8250.00
             * first_money : 0.00
             * first_gst : 0.00
             * first_status : 0
             * first_time : null
             * second_money : 7500.00
             * second_gst : 750.00
             * second_status : 0
             * second_time : null
             * third_money : 0.00
             * third_gst : 0.00
             * third_status : 0
             * third_time : null
             * exit_commossion : 0.00
             * exit_status : 0
             * exit_time : 0
             * first_invoice_status : 0
             * second_invoice_status : 0
             * third_invoice_status : 0
             * first_other : 0.00
             * second_other : 0.00
             * third_other : 0.00
             * add_time : 1509075453
             * update_time : 1509075453
             * is_value : 0
             * is_show : 1
             * status : 0
             * remark_1 : normal
             * remark_2 :
             * is_wait_xingzheng : 0
             * is_wait_caiwu : 0
             * is_wait_callback : 0
             * invoice_number : 0
             * one_invoice_status : 4
             * two_invoice_status : 4
             * three_invoice_status : 4
             */

            private int id;
            private int company_id;
            private int sale_id;
            private int user_id;
            private String user_first_name;
            private String user_surname;
            private String user_en_name;
            private int customer_id;
            private String customer_first_name;
            private String customer_surname;
            private String customer_en_name;
            private int order_id;
            private int product_id;
            private int product_childs_id;
            private String product_name;
            private String product_childs_lot_number;
            private String product_childs_unit_number;
            private String order_price;
            private String commossion;
            private String gst;
            private String total;
            private String first_money;
            private String first_gst;
            private int first_status;
            private long first_time;
            private String second_money;
            private String second_gst;
            private int second_status;
            private long second_time;
            private String third_money;
            private String third_gst;
            private int third_status;
            private long third_time;
            private String exit_commossion;
            private int exit_status;
            private int exit_time;
            private int first_invoice_status;
            private int second_invoice_status;
            private int third_invoice_status;
            private String first_other;
            private String second_other;
            private String third_other;
            private int add_time;
            private int update_time;
            private int is_value;
            private int is_show;
            private int status;
            private String remark_1;
            private String remark_2;
            private int is_wait_xingzheng;
            private int is_wait_caiwu;
            private int is_wait_callback;
            private int invoice_number;
            private int one_invoice_status;
            private int two_invoice_status;
            private int three_invoice_status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getSale_id() {
                return sale_id;
            }

            public void setSale_id(int sale_id) {
                this.sale_id = sale_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUser_first_name() {
                return user_first_name;
            }

            public void setUser_first_name(String user_first_name) {
                this.user_first_name = user_first_name;
            }

            public String getUser_surname() {
                return user_surname;
            }

            public void setUser_surname(String user_surname) {
                this.user_surname = user_surname;
            }

            public String getUser_en_name() {
                return user_en_name;
            }

            public void setUser_en_name(String user_en_name) {
                this.user_en_name = user_en_name;
            }

            public int getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(int customer_id) {
                this.customer_id = customer_id;
            }

            public String getCustomer_first_name() {
                return customer_first_name;
            }

            public void setCustomer_first_name(String customer_first_name) {
                this.customer_first_name = customer_first_name;
            }

            public String getCustomer_surname() {
                return customer_surname;
            }

            public void setCustomer_surname(String customer_surname) {
                this.customer_surname = customer_surname;
            }

            public String getCustomer_en_name() {
                return customer_en_name;
            }

            public void setCustomer_en_name(String customer_en_name) {
                this.customer_en_name = customer_en_name;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getProduct_childs_id() {
                return product_childs_id;
            }

            public void setProduct_childs_id(int product_childs_id) {
                this.product_childs_id = product_childs_id;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getProduct_childs_lot_number() {
                return product_childs_lot_number;
            }

            public void setProduct_childs_lot_number(String product_childs_lot_number) {
                this.product_childs_lot_number = product_childs_lot_number;
            }

            public String getProduct_childs_unit_number() {
                return product_childs_unit_number;
            }

            public void setProduct_childs_unit_number(String product_childs_unit_number) {
                this.product_childs_unit_number = product_childs_unit_number;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getCommossion() {
                return commossion;
            }

            public void setCommossion(String commossion) {
                this.commossion = commossion;
            }

            public String getGst() {
                return gst;
            }

            public void setGst(String gst) {
                this.gst = gst;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getFirst_money() {
                return first_money;
            }

            public void setFirst_money(String first_money) {
                this.first_money = first_money;
            }

            public String getFirst_gst() {
                return first_gst;
            }

            public void setFirst_gst(String first_gst) {
                this.first_gst = first_gst;
            }

            public int getFirst_status() {
                return first_status;
            }

            public void setFirst_status(int first_status) {
                this.first_status = first_status;
            }

            public long getFirst_time() {
                return first_time;
            }

            public void setFirst_time(long first_time) {
                this.first_time = first_time;
            }

            public String getSecond_money() {
                return second_money;
            }

            public void setSecond_money(String second_money) {
                this.second_money = second_money;
            }

            public String getSecond_gst() {
                return second_gst;
            }

            public void setSecond_gst(String second_gst) {
                this.second_gst = second_gst;
            }

            public int getSecond_status() {
                return second_status;
            }

            public void setSecond_status(int second_status) {
                this.second_status = second_status;
            }

            public long getSecond_time() {
                return second_time;
            }

            public void setSecond_time(long second_time) {
                this.second_time = second_time;
            }

            public String getThird_money() {
                return third_money;
            }

            public void setThird_money(String third_money) {
                this.third_money = third_money;
            }

            public String getThird_gst() {
                return third_gst;
            }

            public void setThird_gst(String third_gst) {
                this.third_gst = third_gst;
            }

            public int getThird_status() {
                return third_status;
            }

            public void setThird_status(int third_status) {
                this.third_status = third_status;
            }

            public long getThird_time() {
                return third_time;
            }

            public void setThird_time(long third_time) {
                this.third_time = third_time;
            }

            public String getExit_commossion() {
                return exit_commossion;
            }

            public void setExit_commossion(String exit_commossion) {
                this.exit_commossion = exit_commossion;
            }

            public int getExit_status() {
                return exit_status;
            }

            public void setExit_status(int exit_status) {
                this.exit_status = exit_status;
            }

            public int getExit_time() {
                return exit_time;
            }

            public void setExit_time(int exit_time) {
                this.exit_time = exit_time;
            }

            public int getFirst_invoice_status() {
                return first_invoice_status;
            }

            public void setFirst_invoice_status(int first_invoice_status) {
                this.first_invoice_status = first_invoice_status;
            }

            public int getSecond_invoice_status() {
                return second_invoice_status;
            }

            public void setSecond_invoice_status(int second_invoice_status) {
                this.second_invoice_status = second_invoice_status;
            }

            public int getThird_invoice_status() {
                return third_invoice_status;
            }

            public void setThird_invoice_status(int third_invoice_status) {
                this.third_invoice_status = third_invoice_status;
            }

            public String getFirst_other() {
                return first_other;
            }

            public void setFirst_other(String first_other) {
                this.first_other = first_other;
            }

            public String getSecond_other() {
                return second_other;
            }

            public void setSecond_other(String second_other) {
                this.second_other = second_other;
            }

            public String getThird_other() {
                return third_other;
            }

            public void setThird_other(String third_other) {
                this.third_other = third_other;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public int getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public int getIs_value() {
                return is_value;
            }

            public void setIs_value(int is_value) {
                this.is_value = is_value;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getRemark_1() {
                return remark_1;
            }

            public void setRemark_1(String remark_1) {
                this.remark_1 = remark_1;
            }

            public String getRemark_2() {
                return remark_2;
            }

            public void setRemark_2(String remark_2) {
                this.remark_2 = remark_2;
            }

            public int getIs_wait_xingzheng() {
                return is_wait_xingzheng;
            }

            public void setIs_wait_xingzheng(int is_wait_xingzheng) {
                this.is_wait_xingzheng = is_wait_xingzheng;
            }

            public int getIs_wait_caiwu() {
                return is_wait_caiwu;
            }

            public void setIs_wait_caiwu(int is_wait_caiwu) {
                this.is_wait_caiwu = is_wait_caiwu;
            }

            public int getIs_wait_callback() {
                return is_wait_callback;
            }

            public void setIs_wait_callback(int is_wait_callback) {
                this.is_wait_callback = is_wait_callback;
            }

            public int getInvoice_number() {
                return invoice_number;
            }

            public void setInvoice_number(int invoice_number) {
                this.invoice_number = invoice_number;
            }

            public int getOne_invoice_status() {
                return one_invoice_status;
            }

            public void setOne_invoice_status(int one_invoice_status) {
                this.one_invoice_status = one_invoice_status;
            }

            public int getTwo_invoice_status() {
                return two_invoice_status;
            }

            public void setTwo_invoice_status(int two_invoice_status) {
                this.two_invoice_status = two_invoice_status;
            }

            public int getThree_invoice_status() {
                return three_invoice_status;
            }

            public void setThree_invoice_status(int three_invoice_status) {
                this.three_invoice_status = three_invoice_status;
            }
        }
    }
}


