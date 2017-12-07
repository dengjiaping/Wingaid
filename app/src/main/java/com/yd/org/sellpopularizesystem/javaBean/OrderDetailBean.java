package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/6/27.
 */

public class OrderDetailBean extends Domine{
    /**
     * code : 1
     * msg : 成功获取订单信息
     * result : {"product_orders_id":2869,"company_id":"1","order_type":1,"product_id":"5","eoi_id":"","purchaseReason":"未知","is_two_order":0,"another_order_id":"0","property_id":24,"product_childs_type":3,"price":"652000.00","currency":"au","client":6899,"co_purchaser":"","is_firb":0,"client_type":1,"sales_id":1070,"lawyer_id":6,"lawyer_name":"Aydin","lawyer_tel":"9676 2664","lawyer_email":"aydin.acar@ailegal.com.au","payment_method":1,"payment_amount":"300.00","add_time":"1509691694","order_money_url":"1103","pay_time":"","order_money_upload_time":"1509691694","order_moneycheck_time":"","order_money_status":1,"sales_advice_is_true":0,"sales_advice_status":0,"contract_apply_time":0,"contract_unsigned_url":"","unsign_upload_time":"","contract_apply_check_time":0,"contract_apply_status":0,"buy_money_url":"","buy_money_account_paid":"0.00","buy_money_upload_number":0,"buy_money_add_time":"","buy_money_check_time":"","buy_money_status":0,"contract_url":"","contract_add_time":"","contract_check_time":"","upload_contract_status":0,"cancel_apply_time":0,"cancel_time":"","who_cancel":0,"cancel_apply_status":0,"complete_time":"","remark":"","days_to_pay":"1510296494","vendor_id":130,"vendor_lawyer_id":361,"sale_advice_status":0,"sale_advice_check_time":"","old_status":"","exchanged_time":0,"is_wait_send_contract":0,"is_confirm_user_cancel":0,"create_type":1,"status":0,"product_name":"APT-Parramatta Skyrise (Exclusive)","customer_surname":"lliao","customer_first_name":"liao","customer_en_name":"","product_info":{"product_childs_id":24,"product_id":5,"product_childs_lot_number":"168","product_childs_unit_number":"2906","company_id":1,"cate_id":3,"cate_type":3,"area":"","bedroom":"1","bathroom":"1","car_space":"0","has_study":"0","ensuite":"0","level":"29","floor_type":"Single Level","aspect":"N","internal":"50.00","external":"5.00","building_area":"55.00","land_size":"0.00","price":"652000.00","vendor_price":"652000.00","discount_amount":"0.00","land_vendor_price":"0.00","land_discount_amount":"0.00","house_vendor_price":"652000.00","house_discount_amount":"0.00","is_gst":1,"exit_commossion":"","adjust_factor":"1.00","is_special_commossion":0,"commossion_type":1,"commossion_value":"2.00","commossion_send_type":1,"module_one_first":0,"module_two_first":0,"module_three_first":0,"currency":"au","thumb":"public/uploads/product_childs_thumb/170628/201706281344455629.jpg","agent_notes":"","up_time":null,"up_ip":null,"up_admin":null,"is_lock":1,"is_eoi":0,"if_eoi":0,"recind_number":0,"old_status":0,"status":5},"buy_money_info":[],"customer_info":{"customer_id":6899,"company_id":1,"customer_nick":null,"head_img":"public/uploads/head_img/171026/201710261138111092.jpg","true_name":null,"surname":"lliao","first_name":"liao","en_name":"","sex":0,"title":"","gender":"","birth_date":"","mid_name":"","ext_id":"","customer_type":1,"company_name":"","select_self":"1","client_id":"1070","client":"","abn":"","acn":"","age":null,"mobile":"5454545","unit_number":"","street_number":"","street_address_line_1":"bdbsb","street_address_line_2":"","suburb":"","state":"","postcode":"578484","country":"澳大利亚","company_mobile":"","company_e_mail":"","company_fax":"","company_unit_number":"","company_street_number":"","company_street_address_line_1":"","company_street_address_line_2":"","company_suburb":"","company_state":"","company_postcode":"","company_country":"澳大利亚","province":"","city":"","area":"","address":null,"zip_code":"","openid":null,"wechat_number":"","wechat_nick":"","wechat_img":"","qq_number":"","e_mail":"gxgxhxbb@qq.com","fax":"","job":"","income":0,"family_name":"","family_first_name":"","family_relationship":"","family_mobile":"","family_email":"","sign_number":0,"card_id":"","passport_id":"","passport_country":"澳大利亚","card_validity":null,"is_experience":0,"flight_date":null,"flight_number":null,"add_time":1508987943,"update_time":1508989091,"add_ip":"114.91.119.226","add_admin":null,"add_user":521,"is_del":0,"is_firb":2,"is_wait":0,"from_type":1,"registe_number":1,"is_first_user":1,"status":0,"memo":"","remark":""}}
     */

    private String code;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * product_orders_id : 2869
         * company_id : 1
         * order_type : 1
         * product_id : 5
         * eoi_id :
         * purchaseReason : 未知
         * is_two_order : 0
         * another_order_id : 0
         * property_id : 24
         * product_childs_type : 3
         * price : 652000.00
         * currency : au
         * client : 6899
         * co_purchaser :
         * is_firb : 0
         * client_type : 1
         * sales_id : 1070
         * lawyer_id : 6
         * lawyer_name : Aydin
         * lawyer_tel : 9676 2664
         * lawyer_email : aydin.acar@ailegal.com.au
         * payment_method : 1
         * payment_amount : 300.00
         * add_time : 1509691694
         * order_money_url : 1103
         * pay_time :
         * order_money_upload_time : 1509691694
         * order_moneycheck_time :
         * order_money_status : 1
         * sales_advice_is_true : 0
         * sales_advice_status : 0
         * contract_apply_time : 0
         * contract_unsigned_url :
         * unsign_upload_time :
         * contract_apply_check_time : 0
         * contract_apply_status : 0
         * buy_money_url :
         * buy_money_account_paid : 0.00
         * buy_money_upload_number : 0
         * buy_money_add_time :
         * buy_money_check_time :
         * buy_money_status : 0
         * contract_url :
         * contract_add_time :
         * contract_check_time :
         * upload_contract_status : 0
         * cancel_apply_time : 0
         * cancel_time :
         * who_cancel : 0
         * cancel_apply_status : 0
         * complete_time :
         * remark :
         * days_to_pay : 1510296494
         * vendor_id : 130
         * vendor_lawyer_id : 361
         * sale_advice_status : 0
         * sale_advice_check_time :
         * old_status :
         * exchanged_time : 0
         * is_wait_send_contract : 0
         * is_confirm_user_cancel : 0
         * create_type : 1
         * status : 0
         * product_name : APT-Parramatta Skyrise (Exclusive)
         * customer_surname : lliao
         * customer_first_name : liao
         * customer_en_name :
         * product_info : {"product_childs_id":24,"product_id":5,"product_childs_lot_number":"168","product_childs_unit_number":"2906","company_id":1,"cate_id":3,"cate_type":3,"area":"","bedroom":"1","bathroom":"1","car_space":"0","has_study":"0","ensuite":"0","level":"29","floor_type":"Single Level","aspect":"N","internal":"50.00","external":"5.00","building_area":"55.00","land_size":"0.00","price":"652000.00","vendor_price":"652000.00","discount_amount":"0.00","land_vendor_price":"0.00","land_discount_amount":"0.00","house_vendor_price":"652000.00","house_discount_amount":"0.00","is_gst":1,"exit_commossion":"","adjust_factor":"1.00","is_special_commossion":0,"commossion_type":1,"commossion_value":"2.00","commossion_send_type":1,"module_one_first":0,"module_two_first":0,"module_three_first":0,"currency":"au","thumb":"public/uploads/product_childs_thumb/170628/201706281344455629.jpg","agent_notes":"","up_time":null,"up_ip":null,"up_admin":null,"is_lock":1,"is_eoi":0,"if_eoi":0,"recind_number":0,"old_status":0,"status":5}
         * buy_money_info : []
         * customer_info : {"customer_id":6899,"company_id":1,"customer_nick":null,"head_img":"public/uploads/head_img/171026/201710261138111092.jpg","true_name":null,"surname":"lliao","first_name":"liao","en_name":"","sex":0,"title":"","gender":"","birth_date":"","mid_name":"","ext_id":"","customer_type":1,"company_name":"","select_self":"1","client_id":"1070","client":"","abn":"","acn":"","age":null,"mobile":"5454545","unit_number":"","street_number":"","street_address_line_1":"bdbsb","street_address_line_2":"","suburb":"","state":"","postcode":"578484","country":"澳大利亚","company_mobile":"","company_e_mail":"","company_fax":"","company_unit_number":"","company_street_number":"","company_street_address_line_1":"","company_street_address_line_2":"","company_suburb":"","company_state":"","company_postcode":"","company_country":"澳大利亚","province":"","city":"","area":"","address":null,"zip_code":"","openid":null,"wechat_number":"","wechat_nick":"","wechat_img":"","qq_number":"","e_mail":"gxgxhxbb@qq.com","fax":"","job":"","income":0,"family_name":"","family_first_name":"","family_relationship":"","family_mobile":"","family_email":"","sign_number":0,"card_id":"","passport_id":"","passport_country":"澳大利亚","card_validity":null,"is_experience":0,"flight_date":null,"flight_number":null,"add_time":1508987943,"update_time":1508989091,"add_ip":"114.91.119.226","add_admin":null,"add_user":521,"is_del":0,"is_firb":2,"is_wait":0,"from_type":1,"registe_number":1,"is_first_user":1,"status":0,"memo":"","remark":""}
         */

        private int product_orders_id;
        private String company_id;
        private int order_type;
        private String product_id;
        private String eoi_id;
        private String purchaseReason;
        private int is_two_order;
        private String another_order_id;
        private int property_id;
        private int product_childs_type;
        private String price;
        private String currency;
        private int client;
        private String co_purchaser;
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
        private int buy_money_upload_number;
        private String buy_money_add_time;
        private String buy_money_check_time;
        private int buy_money_status;
        private String contract_url;
        private String contract_add_time;
        private String contract_check_time;
        private int upload_contract_status;
        private int cancel_apply_time;
        private String cancel_time;
        private int who_cancel;
        private int cancel_apply_status;
        private String complete_time;
        private String remark;
        private String days_to_pay;
        private int vendor_id;
        private int vendor_lawyer_id;
        private int sale_advice_status;
        private String sale_advice_check_time;
        private String old_status;
        private int exchanged_time;
        private int is_wait_send_contract;
        private int is_confirm_user_cancel;
        private int create_type;
        private int status;
        private String product_name;
        private String customer_surname;
        private String customer_first_name;
        private String customer_en_name;
        private ProductInfoBean product_info;
        private CustomerInfoBean customer_info;
        private List<?> buy_money_info;

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

        public int getIs_two_order() {
            return is_two_order;
        }

        public void setIs_two_order(int is_two_order) {
            this.is_two_order = is_two_order;
        }

        public String getAnother_order_id() {
            return another_order_id;
        }

        public void setAnother_order_id(String another_order_id) {
            this.another_order_id = another_order_id;
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

        public String getCo_purchaser() {
            return co_purchaser;
        }

        public void setCo_purchaser(String co_purchaser) {
            this.co_purchaser = co_purchaser;
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

        public int getBuy_money_upload_number() {
            return buy_money_upload_number;
        }

        public void setBuy_money_upload_number(int buy_money_upload_number) {
            this.buy_money_upload_number = buy_money_upload_number;
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

        public int getWho_cancel() {
            return who_cancel;
        }

        public void setWho_cancel(int who_cancel) {
            this.who_cancel = who_cancel;
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

        public int getVendor_id() {
            return vendor_id;
        }

        public void setVendor_id(int vendor_id) {
            this.vendor_id = vendor_id;
        }

        public int getVendor_lawyer_id() {
            return vendor_lawyer_id;
        }

        public void setVendor_lawyer_id(int vendor_lawyer_id) {
            this.vendor_lawyer_id = vendor_lawyer_id;
        }

        public int getSale_advice_status() {
            return sale_advice_status;
        }

        public void setSale_advice_status(int sale_advice_status) {
            this.sale_advice_status = sale_advice_status;
        }

        public String getSale_advice_check_time() {
            return sale_advice_check_time;
        }

        public void setSale_advice_check_time(String sale_advice_check_time) {
            this.sale_advice_check_time = sale_advice_check_time;
        }

        public String getOld_status() {
            return old_status;
        }

        public void setOld_status(String old_status) {
            this.old_status = old_status;
        }

        public int getExchanged_time() {
            return exchanged_time;
        }

        public void setExchanged_time(int exchanged_time) {
            this.exchanged_time = exchanged_time;
        }

        public int getIs_wait_send_contract() {
            return is_wait_send_contract;
        }

        public void setIs_wait_send_contract(int is_wait_send_contract) {
            this.is_wait_send_contract = is_wait_send_contract;
        }

        public int getIs_confirm_user_cancel() {
            return is_confirm_user_cancel;
        }

        public void setIs_confirm_user_cancel(int is_confirm_user_cancel) {
            this.is_confirm_user_cancel = is_confirm_user_cancel;
        }

        public int getCreate_type() {
            return create_type;
        }

        public void setCreate_type(int create_type) {
            this.create_type = create_type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
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

        public ProductInfoBean getProduct_info() {
            return product_info;
        }

        public void setProduct_info(ProductInfoBean product_info) {
            this.product_info = product_info;
        }

        public CustomerInfoBean getCustomer_info() {
            return customer_info;
        }

        public void setCustomer_info(CustomerInfoBean customer_info) {
            this.customer_info = customer_info;
        }

        public List<?> getBuy_money_info() {
            return buy_money_info;
        }

        public void setBuy_money_info(List<?> buy_money_info) {
            this.buy_money_info = buy_money_info;
        }

        public static class ProductInfoBean {
            /**
             * product_childs_id : 24
             * product_id : 5
             * product_childs_lot_number : 168
             * product_childs_unit_number : 2906
             * company_id : 1
             * cate_id : 3
             * cate_type : 3
             * area :
             * bedroom : 1
             * bathroom : 1
             * car_space : 0
             * has_study : 0
             * ensuite : 0
             * level : 29
             * floor_type : Single Level
             * aspect : N
             * internal : 50.00
             * external : 5.00
             * building_area : 55.00
             * land_size : 0.00
             * price : 652000.00
             * vendor_price : 652000.00
             * discount_amount : 0.00
             * land_vendor_price : 0.00
             * land_discount_amount : 0.00
             * house_vendor_price : 652000.00
             * house_discount_amount : 0.00
             * is_gst : 1
             * exit_commossion :
             * adjust_factor : 1.00
             * is_special_commossion : 0
             * commossion_type : 1
             * commossion_value : 2.00
             * commossion_send_type : 1
             * module_one_first : 0
             * module_two_first : 0
             * module_three_first : 0
             * currency : au
             * thumb : public/uploads/product_childs_thumb/170628/201706281344455629.jpg
             * agent_notes :
             * up_time : null
             * up_ip : null
             * up_admin : null
             * is_lock : 1
             * is_eoi : 0
             * if_eoi : 0
             * recind_number : 0
             * old_status : 0
             * status : 5
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
            private String exit_commossion;
            private String adjust_factor;
            private int is_special_commossion;
            private int commossion_type;
            private String commossion_value;
            private int commossion_send_type;
            private int module_one_first;
            private int module_two_first;
            private int module_three_first;
            private String currency;
            private String thumb;
            private String agent_notes;
            private Object up_time;
            private Object up_ip;
            private Object up_admin;
            private int is_lock;
            private int is_eoi;
            private int if_eoi;
            private int recind_number;
            private int old_status;
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

            public String getExit_commossion() {
                return exit_commossion;
            }

            public void setExit_commossion(String exit_commossion) {
                this.exit_commossion = exit_commossion;
            }

            public String getAdjust_factor() {
                return adjust_factor;
            }

            public void setAdjust_factor(String adjust_factor) {
                this.adjust_factor = adjust_factor;
            }

            public int getIs_special_commossion() {
                return is_special_commossion;
            }

            public void setIs_special_commossion(int is_special_commossion) {
                this.is_special_commossion = is_special_commossion;
            }

            public int getCommossion_type() {
                return commossion_type;
            }

            public void setCommossion_type(int commossion_type) {
                this.commossion_type = commossion_type;
            }

            public String getCommossion_value() {
                return commossion_value;
            }

            public void setCommossion_value(String commossion_value) {
                this.commossion_value = commossion_value;
            }

            public int getCommossion_send_type() {
                return commossion_send_type;
            }

            public void setCommossion_send_type(int commossion_send_type) {
                this.commossion_send_type = commossion_send_type;
            }

            public int getModule_one_first() {
                return module_one_first;
            }

            public void setModule_one_first(int module_one_first) {
                this.module_one_first = module_one_first;
            }

            public int getModule_two_first() {
                return module_two_first;
            }

            public void setModule_two_first(int module_two_first) {
                this.module_two_first = module_two_first;
            }

            public int getModule_three_first() {
                return module_three_first;
            }

            public void setModule_three_first(int module_three_first) {
                this.module_three_first = module_three_first;
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

            public Object getUp_time() {
                return up_time;
            }

            public void setUp_time(Object up_time) {
                this.up_time = up_time;
            }

            public Object getUp_ip() {
                return up_ip;
            }

            public void setUp_ip(Object up_ip) {
                this.up_ip = up_ip;
            }

            public Object getUp_admin() {
                return up_admin;
            }

            public void setUp_admin(Object up_admin) {
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

            public int getRecind_number() {
                return recind_number;
            }

            public void setRecind_number(int recind_number) {
                this.recind_number = recind_number;
            }

            public int getOld_status() {
                return old_status;
            }

            public void setOld_status(int old_status) {
                this.old_status = old_status;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class CustomerInfoBean {
            /**
             * customer_id : 6899
             * company_id : 1
             * customer_nick : null
             * head_img : public/uploads/head_img/171026/201710261138111092.jpg
             * true_name : null
             * surname : lliao
             * first_name : liao
             * en_name :
             * sex : 0
             * title :
             * gender :
             * birth_date :
             * mid_name :
             * ext_id :
             * customer_type : 1
             * company_name :
             * select_self : 1
             * client_id : 1070
             * client :
             * abn :
             * acn :
             * age : null
             * mobile : 5454545
             * unit_number :
             * street_number :
             * street_address_line_1 : bdbsb
             * street_address_line_2 :
             * suburb :
             * state :
             * postcode : 578484
             * country : 澳大利亚
             * company_mobile :
             * company_e_mail :
             * company_fax :
             * company_unit_number :
             * company_street_number :
             * company_street_address_line_1 :
             * company_street_address_line_2 :
             * company_suburb :
             * company_state :
             * company_postcode :
             * company_country : 澳大利亚
             * province :
             * city :
             * area :
             * address : null
             * zip_code :
             * openid : null
             * wechat_number :
             * wechat_nick :
             * wechat_img :
             * qq_number :
             * e_mail : gxgxhxbb@qq.com
             * fax :
             * job :
             * income : 0
             * family_name :
             * family_first_name :
             * family_relationship :
             * family_mobile :
             * family_email :
             * sign_number : 0
             * card_id :
             * passport_id :
             * passport_country : 澳大利亚
             * card_validity : null
             * is_experience : 0
             * flight_date : null
             * flight_number : null
             * add_time : 1508987943
             * update_time : 1508989091
             * add_ip : 114.91.119.226
             * add_admin : null
             * add_user : 521
             * is_del : 0
             * is_firb : 2
             * is_wait : 0
             * from_type : 1
             * registe_number : 1
             * is_first_user : 1
             * status : 0
             * memo :
             * remark :
             */

            private int customer_id;
            private int company_id;
            private Object customer_nick;
            private String head_img;
            private Object true_name;
            private String surname;
            private String first_name;
            private String en_name;
            private int sex;
            private String title;
            private String gender;
            private String birth_date;
            private String mid_name;
            private String ext_id;
            private int customer_type;
            private String company_name;
            private String select_self;
            private String client_id;
            private String client;
            private String abn;
            private String acn;
            private Object age;
            private String mobile;
            private String unit_number;
            private String street_number;
            private String street_address_line_1;
            private String street_address_line_2;
            private String suburb;
            private String state;
            private String postcode;
            private String country;
            private String company_mobile;
            private String company_e_mail;
            private String company_fax;
            private String company_unit_number;
            private String company_street_number;
            private String company_street_address_line_1;
            private String company_street_address_line_2;
            private String company_suburb;
            private String company_state;
            private String company_postcode;
            private String company_country;
            private String province;
            private String city;
            private String area;
            private Object address;
            private String zip_code;
            private Object openid;
            private String wechat_number;
            private String wechat_nick;
            private String wechat_img;
            private String qq_number;
            private String e_mail;
            private String fax;
            private String job;
            private int income;
            private String family_name;
            private String family_first_name;
            private String family_relationship;
            private String family_mobile;
            private String family_email;
            private int sign_number;
            private String card_id;
            private String passport_id;
            private String passport_country;
            private Object card_validity;
            private int is_experience;
            private Object flight_date;
            private Object flight_number;
            private int add_time;
            private int update_time;
            private String add_ip;
            private Object add_admin;
            private int add_user;
            private int is_del;
            private int is_firb;
            private int is_wait;
            private int from_type;
            private int registe_number;
            private int is_first_user;
            private int status;
            private String memo;
            private String remark;

            public int getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(int customer_id) {
                this.customer_id = customer_id;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public Object getCustomer_nick() {
                return customer_nick;
            }

            public void setCustomer_nick(Object customer_nick) {
                this.customer_nick = customer_nick;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }

            public Object getTrue_name() {
                return true_name;
            }

            public void setTrue_name(Object true_name) {
                this.true_name = true_name;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getEn_name() {
                return en_name;
            }

            public void setEn_name(String en_name) {
                this.en_name = en_name;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getBirth_date() {
                return birth_date;
            }

            public void setBirth_date(String birth_date) {
                this.birth_date = birth_date;
            }

            public String getMid_name() {
                return mid_name;
            }

            public void setMid_name(String mid_name) {
                this.mid_name = mid_name;
            }

            public String getExt_id() {
                return ext_id;
            }

            public void setExt_id(String ext_id) {
                this.ext_id = ext_id;
            }

            public int getCustomer_type() {
                return customer_type;
            }

            public void setCustomer_type(int customer_type) {
                this.customer_type = customer_type;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getSelect_self() {
                return select_self;
            }

            public void setSelect_self(String select_self) {
                this.select_self = select_self;
            }

            public String getClient_id() {
                return client_id;
            }

            public void setClient_id(String client_id) {
                this.client_id = client_id;
            }

            public String getClient() {
                return client;
            }

            public void setClient(String client) {
                this.client = client;
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

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUnit_number() {
                return unit_number;
            }

            public void setUnit_number(String unit_number) {
                this.unit_number = unit_number;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getStreet_address_line_1() {
                return street_address_line_1;
            }

            public void setStreet_address_line_1(String street_address_line_1) {
                this.street_address_line_1 = street_address_line_1;
            }

            public String getStreet_address_line_2() {
                return street_address_line_2;
            }

            public void setStreet_address_line_2(String street_address_line_2) {
                this.street_address_line_2 = street_address_line_2;
            }

            public String getSuburb() {
                return suburb;
            }

            public void setSuburb(String suburb) {
                this.suburb = suburb;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCompany_mobile() {
                return company_mobile;
            }

            public void setCompany_mobile(String company_mobile) {
                this.company_mobile = company_mobile;
            }

            public String getCompany_e_mail() {
                return company_e_mail;
            }

            public void setCompany_e_mail(String company_e_mail) {
                this.company_e_mail = company_e_mail;
            }

            public String getCompany_fax() {
                return company_fax;
            }

            public void setCompany_fax(String company_fax) {
                this.company_fax = company_fax;
            }

            public String getCompany_unit_number() {
                return company_unit_number;
            }

            public void setCompany_unit_number(String company_unit_number) {
                this.company_unit_number = company_unit_number;
            }

            public String getCompany_street_number() {
                return company_street_number;
            }

            public void setCompany_street_number(String company_street_number) {
                this.company_street_number = company_street_number;
            }

            public String getCompany_street_address_line_1() {
                return company_street_address_line_1;
            }

            public void setCompany_street_address_line_1(String company_street_address_line_1) {
                this.company_street_address_line_1 = company_street_address_line_1;
            }

            public String getCompany_street_address_line_2() {
                return company_street_address_line_2;
            }

            public void setCompany_street_address_line_2(String company_street_address_line_2) {
                this.company_street_address_line_2 = company_street_address_line_2;
            }

            public String getCompany_suburb() {
                return company_suburb;
            }

            public void setCompany_suburb(String company_suburb) {
                this.company_suburb = company_suburb;
            }

            public String getCompany_state() {
                return company_state;
            }

            public void setCompany_state(String company_state) {
                this.company_state = company_state;
            }

            public String getCompany_postcode() {
                return company_postcode;
            }

            public void setCompany_postcode(String company_postcode) {
                this.company_postcode = company_postcode;
            }

            public String getCompany_country() {
                return company_country;
            }

            public void setCompany_country(String company_country) {
                this.company_country = company_country;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public String getZip_code() {
                return zip_code;
            }

            public void setZip_code(String zip_code) {
                this.zip_code = zip_code;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public String getWechat_number() {
                return wechat_number;
            }

            public void setWechat_number(String wechat_number) {
                this.wechat_number = wechat_number;
            }

            public String getWechat_nick() {
                return wechat_nick;
            }

            public void setWechat_nick(String wechat_nick) {
                this.wechat_nick = wechat_nick;
            }

            public String getWechat_img() {
                return wechat_img;
            }

            public void setWechat_img(String wechat_img) {
                this.wechat_img = wechat_img;
            }

            public String getQq_number() {
                return qq_number;
            }

            public void setQq_number(String qq_number) {
                this.qq_number = qq_number;
            }

            public String getE_mail() {
                return e_mail;
            }

            public void setE_mail(String e_mail) {
                this.e_mail = e_mail;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public int getIncome() {
                return income;
            }

            public void setIncome(int income) {
                this.income = income;
            }

            public String getFamily_name() {
                return family_name;
            }

            public void setFamily_name(String family_name) {
                this.family_name = family_name;
            }

            public String getFamily_first_name() {
                return family_first_name;
            }

            public void setFamily_first_name(String family_first_name) {
                this.family_first_name = family_first_name;
            }

            public String getFamily_relationship() {
                return family_relationship;
            }

            public void setFamily_relationship(String family_relationship) {
                this.family_relationship = family_relationship;
            }

            public String getFamily_mobile() {
                return family_mobile;
            }

            public void setFamily_mobile(String family_mobile) {
                this.family_mobile = family_mobile;
            }

            public String getFamily_email() {
                return family_email;
            }

            public void setFamily_email(String family_email) {
                this.family_email = family_email;
            }

            public int getSign_number() {
                return sign_number;
            }

            public void setSign_number(int sign_number) {
                this.sign_number = sign_number;
            }

            public String getCard_id() {
                return card_id;
            }

            public void setCard_id(String card_id) {
                this.card_id = card_id;
            }

            public String getPassport_id() {
                return passport_id;
            }

            public void setPassport_id(String passport_id) {
                this.passport_id = passport_id;
            }

            public String getPassport_country() {
                return passport_country;
            }

            public void setPassport_country(String passport_country) {
                this.passport_country = passport_country;
            }

            public Object getCard_validity() {
                return card_validity;
            }

            public void setCard_validity(Object card_validity) {
                this.card_validity = card_validity;
            }

            public int getIs_experience() {
                return is_experience;
            }

            public void setIs_experience(int is_experience) {
                this.is_experience = is_experience;
            }

            public Object getFlight_date() {
                return flight_date;
            }

            public void setFlight_date(Object flight_date) {
                this.flight_date = flight_date;
            }

            public Object getFlight_number() {
                return flight_number;
            }

            public void setFlight_number(Object flight_number) {
                this.flight_number = flight_number;
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

            public String getAdd_ip() {
                return add_ip;
            }

            public void setAdd_ip(String add_ip) {
                this.add_ip = add_ip;
            }

            public Object getAdd_admin() {
                return add_admin;
            }

            public void setAdd_admin(Object add_admin) {
                this.add_admin = add_admin;
            }

            public int getAdd_user() {
                return add_user;
            }

            public void setAdd_user(int add_user) {
                this.add_user = add_user;
            }

            public int getIs_del() {
                return is_del;
            }

            public void setIs_del(int is_del) {
                this.is_del = is_del;
            }

            public int getIs_firb() {
                return is_firb;
            }

            public void setIs_firb(int is_firb) {
                this.is_firb = is_firb;
            }

            public int getIs_wait() {
                return is_wait;
            }

            public void setIs_wait(int is_wait) {
                this.is_wait = is_wait;
            }

            public int getFrom_type() {
                return from_type;
            }

            public void setFrom_type(int from_type) {
                this.from_type = from_type;
            }

            public int getRegiste_number() {
                return registe_number;
            }

            public void setRegiste_number(int registe_number) {
                this.registe_number = registe_number;
            }

            public int getIs_first_user() {
                return is_first_user;
            }

            public void setIs_first_user(int is_first_user) {
                this.is_first_user = is_first_user;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}
