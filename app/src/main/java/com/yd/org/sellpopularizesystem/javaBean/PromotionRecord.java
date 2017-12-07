package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/6/20.
 */

public class PromotionRecord extends Domine {
    /**
     * code : 1
     * msg : 成功获取订单列表
     * total_number : 1
     * result : [{"product_orders_id":62,"company_id":"1","order_type":1,"product_id":"75","eoi_id":"0","purchaseReason":"投资","property_id":2203,"product_childs_type":3,"price":"522000.00","currency":"au","client":7807,"is_firb":0,"client_type":1,"sales_id":189,"lawyer_id":25,"lawyer_name":"ABP Lawyer","lawyer_tel":"02 8880 6505","lawyer_email":"0","payment_method":1,"payment_amount":"30000.00","add_time":"1497855048","order_money_url":"87","pay_time":"1497855045","order_money_upload_time":"1497855048","order_moneycheck_time":"1497855747","order_money_status":2,"sales_advice_is_true":0,"sales_advice_status":0,"contract_apply_time":1497855747,"contract_unsigned_url":"","unsign_upload_time":"","contract_apply_check_time":0,"contract_apply_status":2,"buy_money_url":"","buy_money_account_paid":"522000.00","buy_money_add_time":"1497859853","buy_money_check_time":"1497859893","buy_money_status":2,"contract_url":"public/uploads/contract/170619/201706191507582778.jpg","contract_add_time":"1497856078","contract_check_time":"1497856207","upload_contract_status":2,"cancel_apply_time":0,"cancel_time":"","cancel_apply_status":0,"complete_time":"","remark":"","days_to_pay":"1497855048","sale_advice_status":0,"old_status":"","status":11,"product_name":{"company_id":1,"product_info_id":75,"product_id":75,"product_name":"Land - Austral Green Stage 2","product_description":"","add_time":1497674479,"lan":"en"},"customer_surname":"andriod","customer_first_name":"feng","customer_en_name":"fengadffggg","is_create_sr":"1","sale_advice_url":"https://www.wingaid.com/index.php/admin/outpdf/out_sales_advice_pdf?type=down&order_id=62","product_info":{"product_childs_id":2203,"product_id":75,"product_childs_lot_number":"1026","product_childs_unit_number":"1026","company_id":2,"cate_id":2,"cate_type":3,"area":"","bedroom":"0","bathroom":"0","car_space":"0","has_study":"0","ensuite":"0","level":"0","floor_type":"0","aspect":"0","internal":"0.00","external":"0.00","building_area":"0.00","land_size":"435.00","price":"522000.00","vendor_price":"522000.00","discount_amount":"0.00","land_vendor_price":"522000.00","land_discount_amount":"0.00","house_vendor_price":"0.00","house_discount_amount":"0.00","is_gst":1,"extra_commossion":"","is_specal_commission":0,"sales_commission_type":1,"sales_commission_value":"0.00","first_commission_type":"","commossion_first":"0.00","second_commission_type":"","commossion_second":"0.00","third_commission_type":"","commossion_third":"0.00","currency":"au","thumb":"public/uploads/product_childs_thumb/170618/201706181805044707.jpg","agent_notes":"","up_time":1497667655,"up_ip":"140.207.23.98","up_admin":15,"is_lock":1,"is_eoi":0,"if_eoi":0,"status":2}}]
     */

    private int code;
    private String msg;
    private int total_number;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean extends Domine {
        /**
         * product_orders_id : 62
         * company_id : 1
         * order_type : 1
         * product_id : 75
         * eoi_id : 0
         * purchaseReason : 投资
         * property_id : 2203
         * product_childs_type : 3
         * price : 522000.00
         * currency : au
         * client : 7807
         * is_firb : 0
         * client_type : 1
         * sales_id : 189
         * lawyer_id : 25
         * lawyer_name : ABP Lawyer
         * lawyer_tel : 02 8880 6505
         * lawyer_email : 0
         * payment_method : 1
         * payment_amount : 30000.00
         * add_time : 1497855048
         * order_money_url : 87
         * pay_time : 1497855045
         * order_money_upload_time : 1497855048
         * order_moneycheck_time : 1497855747
         * order_money_status : 2
         * sales_advice_is_true : 0
         * sales_advice_status : 0
         * contract_apply_time : 1497855747
         * contract_unsigned_url :
         * unsign_upload_time :
         * contract_apply_check_time : 0
         * contract_apply_status : 2
         * buy_money_url :
         * buy_money_account_paid : 522000.00
         * buy_money_add_time : 1497859853
         * buy_money_check_time : 1497859893
         * buy_money_status : 2
         * contract_url : public/uploads/contract/170619/201706191507582778.jpg
         * contract_add_time : 1497856078
         * contract_check_time : 1497856207
         * upload_contract_status : 2
         * cancel_apply_time : 0
         * cancel_time :
         * cancel_apply_status : 0
         * complete_time :
         * remark :
         * days_to_pay : 1497855048
         * sale_advice_status : 0
         * old_status :
         * status : 11
         * product_name : {"company_id":1,"product_info_id":75,"product_id":75,"product_name":"Land - Austral Green Stage 2","product_description":"","add_time":1497674479,"lan":"en"}
         * customer_surname : andriod
         * customer_first_name : feng
         * customer_en_name : fengadffggg
         * is_create_sr : 1
         * sale_advice_url : https://www.wingaid.com/index.php/admin/outpdf/out_sales_advice_pdf?type=down&order_id=62
         * product_info : {"product_childs_id":2203,"product_id":75,"product_childs_lot_number":"1026","product_childs_unit_number":"1026","company_id":2,"cate_id":2,"cate_type":3,"area":"","bedroom":"0","bathroom":"0","car_space":"0","has_study":"0","ensuite":"0","level":"0","floor_type":"0","aspect":"0","internal":"0.00","external":"0.00","building_area":"0.00","land_size":"435.00","price":"522000.00","vendor_price":"522000.00","discount_amount":"0.00","land_vendor_price":"522000.00","land_discount_amount":"0.00","house_vendor_price":"0.00","house_discount_amount":"0.00","is_gst":1,"extra_commossion":"","is_specal_commission":0,"sales_commission_type":1,"sales_commission_value":"0.00","first_commission_type":"","commossion_first":"0.00","second_commission_type":"","commossion_second":"0.00","third_commission_type":"","commossion_third":"0.00","currency":"au","thumb":"public/uploads/product_childs_thumb/170618/201706181805044707.jpg","agent_notes":"","up_time":1497667655,"up_ip":"140.207.23.98","up_admin":15,"is_lock":1,"is_eoi":0,"if_eoi":0,"status":2}
         */

        private int product_orders_id;
        private String company_id;
        private int order_type;
        private String product_id;
        private String eoi_id;
        private String purchaseReason;
        private int property_id;
        private int product_childs_type;
        private String price;
        private String currency;
        private int client;
        private int is_firb;
        private int client_type;
        private int sales_id;
        private int lawyer_id;
        private String lawyer_name;
        private String lawyer_tel;
        private String lawyer_email;
        private int payment_method;
        private String payment_amount;
        private String add_time;
        private String order_money_url;
        private String pay_time;
        private String order_money_upload_time;
        private String order_moneycheck_time;
        private int order_money_status;
        private int sales_advice_is_true;
        private int sales_advice_status;
        private int contract_apply_time;
        private String contract_unsigned_url;
        private String unsign_upload_time;
        private int contract_apply_check_time;
        private int contract_apply_status;
        private String buy_money_url;
        private String buy_money_account_paid;
        private String buy_money_add_time;
        private String buy_money_check_time;
        private int buy_money_status;
        private String contract_url;
        private String contract_add_time;
        private String contract_check_time;
        private int upload_contract_status;
        private int cancel_apply_time;
        private String cancel_time;
        private int cancel_apply_status;
        private String complete_time;
        private String remark;
        private String days_to_pay;
        private int sale_advice_status;
        private String old_status;
        private int status;
        private ProductNameBean product_name;
        private String customer_surname;
        private String customer_first_name;
        private String customer_en_name;
        private String is_create_sr;
        private String sale_advice_url;
        private ProductInfoBean product_info;

        public int getProduct_orders_id() {
            return product_orders_id;
        }

        public void setProduct_orders_id(int product_orders_id) {
            this.product_orders_id = product_orders_id;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int order_type) {
            this.order_type = order_type;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getEoi_id() {
            return eoi_id;
        }

        public void setEoi_id(String eoi_id) {
            this.eoi_id = eoi_id;
        }

        public String getPurchaseReason() {
            return purchaseReason;
        }

        public void setPurchaseReason(String purchaseReason) {
            this.purchaseReason = purchaseReason;
        }

        public int getProperty_id() {
            return property_id;
        }

        public void setProperty_id(int property_id) {
            this.property_id = property_id;
        }

        public int getProduct_childs_type() {
            return product_childs_type;
        }

        public void setProduct_childs_type(int product_childs_type) {
            this.product_childs_type = product_childs_type;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getClient() {
            return client;
        }

        public void setClient(int client) {
            this.client = client;
        }

        public int getIs_firb() {
            return is_firb;
        }

        public void setIs_firb(int is_firb) {
            this.is_firb = is_firb;
        }

        public int getClient_type() {
            return client_type;
        }

        public void setClient_type(int client_type) {
            this.client_type = client_type;
        }

        public int getSales_id() {
            return sales_id;
        }

        public void setSales_id(int sales_id) {
            this.sales_id = sales_id;
        }

        public int getLawyer_id() {
            return lawyer_id;
        }

        public void setLawyer_id(int lawyer_id) {
            this.lawyer_id = lawyer_id;
        }

        public String getLawyer_name() {
            return lawyer_name;
        }

        public void setLawyer_name(String lawyer_name) {
            this.lawyer_name = lawyer_name;
        }

        public String getLawyer_tel() {
            return lawyer_tel;
        }

        public void setLawyer_tel(String lawyer_tel) {
            this.lawyer_tel = lawyer_tel;
        }

        public String getLawyer_email() {
            return lawyer_email;
        }

        public void setLawyer_email(String lawyer_email) {
            this.lawyer_email = lawyer_email;
        }

        public int getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(int payment_method) {
            this.payment_method = payment_method;
        }

        public String getPayment_amount() {
            return payment_amount;
        }

        public void setPayment_amount(String payment_amount) {
            this.payment_amount = payment_amount;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getOrder_money_url() {
            return order_money_url;
        }

        public void setOrder_money_url(String order_money_url) {
            this.order_money_url = order_money_url;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getOrder_money_upload_time() {
            return order_money_upload_time;
        }

        public void setOrder_money_upload_time(String order_money_upload_time) {
            this.order_money_upload_time = order_money_upload_time;
        }

        public String getOrder_moneycheck_time() {
            return order_moneycheck_time;
        }

        public void setOrder_moneycheck_time(String order_moneycheck_time) {
            this.order_moneycheck_time = order_moneycheck_time;
        }

        public int getOrder_money_status() {
            return order_money_status;
        }

        public void setOrder_money_status(int order_money_status) {
            this.order_money_status = order_money_status;
        }

        public int getSales_advice_is_true() {
            return sales_advice_is_true;
        }

        public void setSales_advice_is_true(int sales_advice_is_true) {
            this.sales_advice_is_true = sales_advice_is_true;
        }

        public int getSales_advice_status() {
            return sales_advice_status;
        }

        public void setSales_advice_status(int sales_advice_status) {
            this.sales_advice_status = sales_advice_status;
        }

        public int getContract_apply_time() {
            return contract_apply_time;
        }

        public void setContract_apply_time(int contract_apply_time) {
            this.contract_apply_time = contract_apply_time;
        }

        public String getContract_unsigned_url() {
            return contract_unsigned_url;
        }

        public void setContract_unsigned_url(String contract_unsigned_url) {
            this.contract_unsigned_url = contract_unsigned_url;
        }

        public String getUnsign_upload_time() {
            return unsign_upload_time;
        }

        public void setUnsign_upload_time(String unsign_upload_time) {
            this.unsign_upload_time = unsign_upload_time;
        }

        public int getContract_apply_check_time() {
            return contract_apply_check_time;
        }

        public void setContract_apply_check_time(int contract_apply_check_time) {
            this.contract_apply_check_time = contract_apply_check_time;
        }

        public int getContract_apply_status() {
            return contract_apply_status;
        }

        public void setContract_apply_status(int contract_apply_status) {
            this.contract_apply_status = contract_apply_status;
        }

        public String getBuy_money_url() {
            return buy_money_url;
        }

        public void setBuy_money_url(String buy_money_url) {
            this.buy_money_url = buy_money_url;
        }

        public String getBuy_money_account_paid() {
            return buy_money_account_paid;
        }

        public void setBuy_money_account_paid(String buy_money_account_paid) {
            this.buy_money_account_paid = buy_money_account_paid;
        }

        public String getBuy_money_add_time() {
            return buy_money_add_time;
        }

        public void setBuy_money_add_time(String buy_money_add_time) {
            this.buy_money_add_time = buy_money_add_time;
        }

        public String getBuy_money_check_time() {
            return buy_money_check_time;
        }

        public void setBuy_money_check_time(String buy_money_check_time) {
            this.buy_money_check_time = buy_money_check_time;
        }

        public int getBuy_money_status() {
            return buy_money_status;
        }

        public void setBuy_money_status(int buy_money_status) {
            this.buy_money_status = buy_money_status;
        }

        public String getContract_url() {
            return contract_url;
        }

        public void setContract_url(String contract_url) {
            this.contract_url = contract_url;
        }

        public String getContract_add_time() {
            return contract_add_time;
        }

        public void setContract_add_time(String contract_add_time) {
            this.contract_add_time = contract_add_time;
        }

        public String getContract_check_time() {
            return contract_check_time;
        }

        public void setContract_check_time(String contract_check_time) {
            this.contract_check_time = contract_check_time;
        }

        public int getUpload_contract_status() {
            return upload_contract_status;
        }

        public void setUpload_contract_status(int upload_contract_status) {
            this.upload_contract_status = upload_contract_status;
        }

        public int getCancel_apply_time() {
            return cancel_apply_time;
        }

        public void setCancel_apply_time(int cancel_apply_time) {
            this.cancel_apply_time = cancel_apply_time;
        }

        public String getCancel_time() {
            return cancel_time;
        }

        public void setCancel_time(String cancel_time) {
            this.cancel_time = cancel_time;
        }

        public int getCancel_apply_status() {
            return cancel_apply_status;
        }

        public void setCancel_apply_status(int cancel_apply_status) {
            this.cancel_apply_status = cancel_apply_status;
        }

        public String getComplete_time() {
            return complete_time;
        }

        public void setComplete_time(String complete_time) {
            this.complete_time = complete_time;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDays_to_pay() {
            return days_to_pay;
        }

        public void setDays_to_pay(String days_to_pay) {
            this.days_to_pay = days_to_pay;
        }

        public int getSale_advice_status() {
            return sale_advice_status;
        }

        public void setSale_advice_status(int sale_advice_status) {
            this.sale_advice_status = sale_advice_status;
        }

        public String getOld_status() {
            return old_status;
        }

        public void setOld_status(String old_status) {
            this.old_status = old_status;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public ProductNameBean getProduct_name() {
            return product_name;
        }

        public void setProduct_name(ProductNameBean product_name) {
            this.product_name = product_name;
        }

        public String getCustomer_surname() {
            return customer_surname;
        }

        public void setCustomer_surname(String customer_surname) {
            this.customer_surname = customer_surname;
        }

        public String getCustomer_first_name() {
            return customer_first_name;
        }

        public void setCustomer_first_name(String customer_first_name) {
            this.customer_first_name = customer_first_name;
        }

        public String getCustomer_en_name() {
            return customer_en_name;
        }

        public void setCustomer_en_name(String customer_en_name) {
            this.customer_en_name = customer_en_name;
        }

        public String getIs_create_sr() {
            return is_create_sr;
        }

        public void setIs_create_sr(String is_create_sr) {
            this.is_create_sr = is_create_sr;
        }

        public String getSale_advice_url() {
            return sale_advice_url;
        }

        public void setSale_advice_url(String sale_advice_url) {
            this.sale_advice_url = sale_advice_url;
        }

        public ProductInfoBean getProduct_info() {
            return product_info;
        }

        public void setProduct_info(ProductInfoBean product_info) {
            this.product_info = product_info;
        }

        public static class ProductNameBean {
            /**
             * company_id : 1
             * product_info_id : 75
             * product_id : 75
             * product_name : Land - Austral Green Stage 2
             * product_description :
             * add_time : 1497674479
             * lan : en
             */

            private int company_id;
            private int product_info_id;
            private int product_id;
            private String product_name;
            private String product_description;
            private int add_time;
            private String lan;

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getProduct_info_id() {
                return product_info_id;
            }

            public void setProduct_info_id(int product_info_id) {
                this.product_info_id = product_info_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getProduct_description() {
                return product_description;
            }

            public void setProduct_description(String product_description) {
                this.product_description = product_description;
            }

            public int getAdd_time() {
                return add_time;
            }

            public void setAdd_time(int add_time) {
                this.add_time = add_time;
            }

            public String getLan() {
                return lan;
            }

            public void setLan(String lan) {
                this.lan = lan;
            }
        }

        public static class ProductInfoBean {
            /**
             * product_childs_id : 2203
             * product_id : 75
             * product_childs_lot_number : 1026
             * product_childs_unit_number : 1026
             * company_id : 2
             * cate_id : 2
             * cate_type : 3
             * area :
             * bedroom : 0
             * bathroom : 0
             * car_space : 0
             * has_study : 0
             * ensuite : 0
             * level : 0
             * floor_type : 0
             * aspect : 0
             * internal : 0.00
             * external : 0.00
             * building_area : 0.00
             * land_size : 435.00
             * price : 522000.00
             * vendor_price : 522000.00
             * discount_amount : 0.00
             * land_vendor_price : 522000.00
             * land_discount_amount : 0.00
             * house_vendor_price : 0.00
             * house_discount_amount : 0.00
             * is_gst : 1
             * extra_commossion :
             * is_specal_commission : 0
             * sales_commission_type : 1
             * sales_commission_value : 0.00
             * first_commission_type :
             * commossion_first : 0.00
             * second_commission_type :
             * commossion_second : 0.00
             * third_commission_type :
             * commossion_third : 0.00
             * currency : au
             * thumb : public/uploads/product_childs_thumb/170618/201706181805044707.jpg
             * agent_notes :
             * up_time : 1497667655
             * up_ip : 140.207.23.98
             * up_admin : 15
             * is_lock : 1
             * is_eoi : 0
             * if_eoi : 0
             * status : 2
             */

            private int product_childs_id;
            private int product_id;
            private String product_childs_lot_number;
            private String product_childs_unit_number;
            private int company_id;
            private int cate_id;
            private int cate_type;
            private String area;
            private String bedroom;
            private String bathroom;
            private String car_space;
            private String has_study;
            private String ensuite;
            private String level;
            private String floor_type;
            private String aspect;
            private String internal;
            private String external;
            private String building_area;
            private String land_size;
            private String price;
            private String vendor_price;
            private String discount_amount;
            private String land_vendor_price;
            private String land_discount_amount;
            private String house_vendor_price;
            private String house_discount_amount;
            private int is_gst;
            private String extra_commossion;
            private int is_specal_commission;
            private int sales_commission_type;
            private String sales_commission_value;
            private String first_commission_type;
            private String commossion_first;
            private String second_commission_type;
            private String commossion_second;
            private String third_commission_type;
            private String commossion_third;
            private String currency;
            private String thumb;
            private String agent_notes;
            private int up_time;
            private String up_ip;
            private int up_admin;
            private int is_lock;
            private int is_eoi;
            private int if_eoi;
            private int status;

            public int getProduct_childs_id() {
                return product_childs_id;
            }

            public void setProduct_childs_id(int product_childs_id) {
                this.product_childs_id = product_childs_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
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

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public int getCate_type() {
                return cate_type;
            }

            public void setCate_type(int cate_type) {
                this.cate_type = cate_type;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getBedroom() {
                return bedroom;
            }

            public void setBedroom(String bedroom) {
                this.bedroom = bedroom;
            }

            public String getBathroom() {
                return bathroom;
            }

            public void setBathroom(String bathroom) {
                this.bathroom = bathroom;
            }

            public String getCar_space() {
                return car_space;
            }

            public void setCar_space(String car_space) {
                this.car_space = car_space;
            }

            public String getHas_study() {
                return has_study;
            }

            public void setHas_study(String has_study) {
                this.has_study = has_study;
            }

            public String getEnsuite() {
                return ensuite;
            }

            public void setEnsuite(String ensuite) {
                this.ensuite = ensuite;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getFloor_type() {
                return floor_type;
            }

            public void setFloor_type(String floor_type) {
                this.floor_type = floor_type;
            }

            public String getAspect() {
                return aspect;
            }

            public void setAspect(String aspect) {
                this.aspect = aspect;
            }

            public String getInternal() {
                return internal;
            }

            public void setInternal(String internal) {
                this.internal = internal;
            }

            public String getExternal() {
                return external;
            }

            public void setExternal(String external) {
                this.external = external;
            }

            public String getBuilding_area() {
                return building_area;
            }

            public void setBuilding_area(String building_area) {
                this.building_area = building_area;
            }

            public String getLand_size() {
                return land_size;
            }

            public void setLand_size(String land_size) {
                this.land_size = land_size;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getVendor_price() {
                return vendor_price;
            }

            public void setVendor_price(String vendor_price) {
                this.vendor_price = vendor_price;
            }

            public String getDiscount_amount() {
                return discount_amount;
            }

            public void setDiscount_amount(String discount_amount) {
                this.discount_amount = discount_amount;
            }

            public String getLand_vendor_price() {
                return land_vendor_price;
            }

            public void setLand_vendor_price(String land_vendor_price) {
                this.land_vendor_price = land_vendor_price;
            }

            public String getLand_discount_amount() {
                return land_discount_amount;
            }

            public void setLand_discount_amount(String land_discount_amount) {
                this.land_discount_amount = land_discount_amount;
            }

            public String getHouse_vendor_price() {
                return house_vendor_price;
            }

            public void setHouse_vendor_price(String house_vendor_price) {
                this.house_vendor_price = house_vendor_price;
            }

            public String getHouse_discount_amount() {
                return house_discount_amount;
            }

            public void setHouse_discount_amount(String house_discount_amount) {
                this.house_discount_amount = house_discount_amount;
            }

            public int getIs_gst() {
                return is_gst;
            }

            public void setIs_gst(int is_gst) {
                this.is_gst = is_gst;
            }

            public String getExtra_commossion() {
                return extra_commossion;
            }

            public void setExtra_commossion(String extra_commossion) {
                this.extra_commossion = extra_commossion;
            }

            public int getIs_specal_commission() {
                return is_specal_commission;
            }

            public void setIs_specal_commission(int is_specal_commission) {
                this.is_specal_commission = is_specal_commission;
            }

            public int getSales_commission_type() {
                return sales_commission_type;
            }

            public void setSales_commission_type(int sales_commission_type) {
                this.sales_commission_type = sales_commission_type;
            }

            public String getSales_commission_value() {
                return sales_commission_value;
            }

            public void setSales_commission_value(String sales_commission_value) {
                this.sales_commission_value = sales_commission_value;
            }

            public String getFirst_commission_type() {
                return first_commission_type;
            }

            public void setFirst_commission_type(String first_commission_type) {
                this.first_commission_type = first_commission_type;
            }

            public String getCommossion_first() {
                return commossion_first;
            }

            public void setCommossion_first(String commossion_first) {
                this.commossion_first = commossion_first;
            }

            public String getSecond_commission_type() {
                return second_commission_type;
            }

            public void setSecond_commission_type(String second_commission_type) {
                this.second_commission_type = second_commission_type;
            }

            public String getCommossion_second() {
                return commossion_second;
            }

            public void setCommossion_second(String commossion_second) {
                this.commossion_second = commossion_second;
            }

            public String getThird_commission_type() {
                return third_commission_type;
            }

            public void setThird_commission_type(String third_commission_type) {
                this.third_commission_type = third_commission_type;
            }

            public String getCommossion_third() {
                return commossion_third;
            }

            public void setCommossion_third(String commossion_third) {
                this.commossion_third = commossion_third;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getAgent_notes() {
                return agent_notes;
            }

            public void setAgent_notes(String agent_notes) {
                this.agent_notes = agent_notes;
            }

            public int getUp_time() {
                return up_time;
            }

            public void setUp_time(int up_time) {
                this.up_time = up_time;
            }

            public String getUp_ip() {
                return up_ip;
            }

            public void setUp_ip(String up_ip) {
                this.up_ip = up_ip;
            }

            public int getUp_admin() {
                return up_admin;
            }

            public void setUp_admin(int up_admin) {
                this.up_admin = up_admin;
            }

            public int getIs_lock() {
                return is_lock;
            }

            public void setIs_lock(int is_lock) {
                this.is_lock = is_lock;
            }

            public int getIs_eoi() {
                return is_eoi;
            }

            public void setIs_eoi(int is_eoi) {
                this.is_eoi = is_eoi;
            }

            public int getIf_eoi() {
                return if_eoi;
            }

            public void setIf_eoi(int if_eoi) {
                this.if_eoi = if_eoi;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
