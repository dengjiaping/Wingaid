package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/5/11.
 */

public class EoilistBean {

    /**
     * code : 1
     * msg : 获取成功
     * total : 5
     * result : [{"eoi_id":1021,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":92,"product_childs_id":3491,"pay_method":1,"amount":"300","evidence":"public/uploads/eoi_money_new/20171026/36e9e273383ffd3e0e7dd68dfc3a9eef.jpg","add_time":1508998211,"add_ip":"114.91.119.226","check_time":1509005532,"refund_time":0,"if_pay":1,"status":2,"customer_info":{"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300","currency":"au","payment_method":1,"eoi_money_url":"public/uploads/eoi_money_new/20171026/36e9e273383ffd3e0e7dd68dfc3a9eef.jpg","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":656}},{"eoi_id":1019,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":93,"product_childs_id":3501,"pay_method":7,"amount":"2000","evidence":"","add_time":1508997336,"add_ip":"114.91.119.226","check_time":0,"refund_time":0,"if_pay":0,"status":2,"customer_info":{"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""},"product_info":{"product_id":93,"product_name":"Land - Clydesdale Marsden Park "},"product_childs_info":{"product_childs_id":3501,"bedroom":"0","bathroom":"0","car_space":"0","price":"405000.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"2000","currency":"cny","payment_method":7,"eoi_money_url":"","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":650}},{"eoi_id":1018,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":93,"product_childs_id":3501,"pay_method":6,"amount":"2000","evidence":"","add_time":1508997312,"add_ip":"114.91.119.226","check_time":0,"refund_time":0,"if_pay":0,"status":2,"customer_info":{"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""},"product_info":{"product_id":93,"product_name":"Land - Clydesdale Marsden Park "},"product_childs_info":{"product_childs_id":3501,"bedroom":"0","bathroom":"0","car_space":"0","price":"405000.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"2000","currency":"cny","payment_method":6,"eoi_money_url":"","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":649}},{"eoi_id":1016,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":92,"product_childs_id":3503,"pay_method":6,"amount":"2000","evidence":"","add_time":1508996721,"add_ip":"114.91.119.226","check_time":0,"refund_time":0,"if_pay":0,"status":2,"customer_info":{"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3503,"bedroom":"4","bathroom":"2","car_space":"1","price":"314000.00","product_childs_unit_number":"Emerald 19"},"pay_info":{"payment_amount":"2000","currency":"cny","payment_method":6,"eoi_money_url":"","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":647}},{"eoi_id":1015,"company_id":1,"user_id":1070,"customer_id":6899,"product_id":92,"product_childs_id":3503,"pay_method":1,"amount":"300","evidence":"public/uploads/eoi_money_new/20171026/f111c608f2c087e47f69be190b5ab8cb.jpg","add_time":1508996691,"add_ip":"114.91.119.226","check_time":1508999045,"refund_time":0,"if_pay":1,"status":2,"customer_info":{"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3503,"bedroom":"4","bathroom":"2","car_space":"1","price":"314000.00","product_childs_unit_number":"Emerald 19"},"pay_info":{"payment_amount":"300","currency":"au","payment_method":1,"eoi_money_url":"public/uploads/eoi_money_new/20171026/f111c608f2c087e47f69be190b5ab8cb.jpg","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":646}}]
     */

    private String code;
    private String msg;
    private int total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * eoi_id : 1021
         * company_id : 1
         * user_id : 1070
         * customer_id : 6899
         * product_id : 92
         * product_childs_id : 3491
         * pay_method : 1
         * amount : 300
         * evidence : public/uploads/eoi_money_new/20171026/36e9e273383ffd3e0e7dd68dfc3a9eef.jpg
         * add_time : 1508998211
         * add_ip : 114.91.119.226
         * check_time : 1509005532
         * refund_time : 0
         * if_pay : 1
         * status : 2
         * customer_info : {"customer_id":6899,"surname":"lliao","first_name":"liao","en_name":""}
         * product_info : {"product_id":92,"product_name":"House - Clydesdale Marsden Park"}
         * product_childs_info : {"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"}
         * pay_info : {"payment_amount":"300","currency":"au","payment_method":1,"eoi_money_url":"public/uploads/eoi_money_new/20171026/36e9e273383ffd3e0e7dd68dfc3a9eef.jpg","is_use":"0","eoi_money_status":"2","cancel_apply_status":"0","trust_account_id":656}
         */

        private int eoi_id;
        private int company_id;
        private int user_id;
        private int customer_id;
        private int product_id;
        private int product_childs_id;
        private int pay_method;
        private String amount;
        private String evidence;
        private int add_time;
        private String add_ip;
        private int check_time;
        private int refund_time;
        private int if_pay;
        private int status;
        private CustomerInfoBean customer_info;
        private ProductInfoBean product_info;
        private ProductChildsInfoBean product_childs_info;
        private PayInfoBean pay_info;

        public int getEoi_id() {
            return eoi_id;
        }

        public void setEoi_id(int eoi_id) {
            this.eoi_id = eoi_id;
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

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
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

        public int getPay_method() {
            return pay_method;
        }

        public void setPay_method(int pay_method) {
            this.pay_method = pay_method;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getEvidence() {
            return evidence;
        }

        public void setEvidence(String evidence) {
            this.evidence = evidence;
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

        public int getCheck_time() {
            return check_time;
        }

        public void setCheck_time(int check_time) {
            this.check_time = check_time;
        }

        public int getRefund_time() {
            return refund_time;
        }

        public void setRefund_time(int refund_time) {
            this.refund_time = refund_time;
        }

        public int getIf_pay() {
            return if_pay;
        }

        public void setIf_pay(int if_pay) {
            this.if_pay = if_pay;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public CustomerInfoBean getCustomer_info() {
            return customer_info;
        }

        public void setCustomer_info(CustomerInfoBean customer_info) {
            this.customer_info = customer_info;
        }

        public ProductInfoBean getProduct_info() {
            return product_info;
        }

        public void setProduct_info(ProductInfoBean product_info) {
            this.product_info = product_info;
        }

        public ProductChildsInfoBean getProduct_childs_info() {
            return product_childs_info;
        }

        public void setProduct_childs_info(ProductChildsInfoBean product_childs_info) {
            this.product_childs_info = product_childs_info;
        }

        public PayInfoBean getPay_info() {
            return pay_info;
        }

        public void setPay_info(PayInfoBean pay_info) {
            this.pay_info = pay_info;
        }

        public static class CustomerInfoBean {
            /**
             * customer_id : 6899
             * surname : lliao
             * first_name : liao
             * en_name :
             */

            private int customer_id;
            private String surname;
            private String first_name;
            private String en_name;

            public int getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(int customer_id) {
                this.customer_id = customer_id;
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
        }

        public static class ProductInfoBean {
            /**
             * product_id : 92
             * product_name : House - Clydesdale Marsden Park
             */

            private int product_id;
            private String product_name;

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
        }

        public static class ProductChildsInfoBean {
            /**
             * product_childs_id : 3491
             * bedroom : 4
             * bathroom : 2
             * car_space : 2
             * price : 1.00
             * product_childs_unit_number : EOI
             */

            private int product_childs_id;
            private String bedroom;
            private String bathroom;
            private String car_space;
            private String price;
            private String product_childs_unit_number;

            public int getProduct_childs_id() {
                return product_childs_id;
            }

            public void setProduct_childs_id(int product_childs_id) {
                this.product_childs_id = product_childs_id;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getProduct_childs_unit_number() {
                return product_childs_unit_number;
            }

            public void setProduct_childs_unit_number(String product_childs_unit_number) {
                this.product_childs_unit_number = product_childs_unit_number;
            }
        }

        public static class PayInfoBean {
            /**
             * payment_amount : 300
             * currency : au
             * payment_method : 1
             * eoi_money_url : public/uploads/eoi_money_new/20171026/36e9e273383ffd3e0e7dd68dfc3a9eef.jpg
             * is_use : 0
             * eoi_money_status : 2
             * cancel_apply_status : 0
             * trust_account_id : 656
             */

            private String payment_amount;
            private String currency;
            private int payment_method;
            private String eoi_money_url;
            private String is_use;
            private String eoi_money_status;
            private String cancel_apply_status;
            private int trust_account_id;

            public String getPayment_amount() {
                return payment_amount;
            }

            public void setPayment_amount(String payment_amount) {
                this.payment_amount = payment_amount;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public int getPayment_method() {
                return payment_method;
            }

            public void setPayment_method(int payment_method) {
                this.payment_method = payment_method;
            }

            public String getEoi_money_url() {
                return eoi_money_url;
            }

            public void setEoi_money_url(String eoi_money_url) {
                this.eoi_money_url = eoi_money_url;
            }

            public String getIs_use() {
                return is_use;
            }

            public void setIs_use(String is_use) {
                this.is_use = is_use;
            }

            public String getEoi_money_status() {
                return eoi_money_status;
            }

            public void setEoi_money_status(String eoi_money_status) {
                this.eoi_money_status = eoi_money_status;
            }

            public String getCancel_apply_status() {
                return cancel_apply_status;
            }

            public void setCancel_apply_status(String cancel_apply_status) {
                this.cancel_apply_status = cancel_apply_status;
            }

            public int getTrust_account_id() {
                return trust_account_id;
            }

            public void setTrust_account_id(int trust_account_id) {
                this.trust_account_id = trust_account_id;
            }
        }

    }
}
