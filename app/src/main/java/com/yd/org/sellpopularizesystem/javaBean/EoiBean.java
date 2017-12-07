package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/11/13.
 */

public class EoiBean extends Domine {


    /**
     * code : 1
     * msg : 获取成功
     * total : 7
     * result : [{"eoi_id":744,"company_id":1,"user_id":396,"customer_id":6393,"product_id":93,"product_childs_id":3501,"pay_method":1,"amount":"300.00","evidence":"public/uploads/eoi_money_new/20171121/a9bd4faaa17896de9f642d578b65190f.jpg","add_time":1511231023,"add_ip":"116.233.206.187","check_time":0,"refund_time":0,"if_pay":1,"status":0,"customer_info":{"customer_id":6393,"surname":"Jin","first_name":"David","en_name":""},"product_info":{"product_id":93,"product_name":"Land - Clydesdale Marsden Park "},"product_childs_info":{"product_childs_id":3501,"bedroom":"0","bathroom":"0","car_space":"0","price":"405000.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":1,"eoi_money_url":"public/uploads/eoi_money_new/20171121/a9bd4faaa17896de9f642d578b65190f.jpg","eoi_money_status":0,"trust_account_id":693}},{"eoi_id":650,"company_id":1,"user_id":396,"customer_id":6702,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/171011/201710111454281805.png","add_time":1507704868,"add_ip":"","check_time":1507787027,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":6702,"surname":"Moon","first_name":"Sung Hyun","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/171011/201710111454281805.png","eoi_money_status":1,"trust_account_id":null}},{"eoi_id":624,"company_id":1,"user_id":396,"customer_id":6393,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/171006/201710061808289278.png","add_time":1507284508,"add_ip":"","check_time":1507590262,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":6393,"surname":"Jin","first_name":"David","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/171006/201710061808289278.png","eoi_money_status":1,"trust_account_id":null}},{"eoi_id":623,"company_id":1,"user_id":396,"customer_id":6394,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/171006/201710061805013441.png","add_time":1507284301,"add_ip":"","check_time":1507590232,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":6394,"surname":"Jin","first_name":"Catherine","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/171006/201710061805013441.png","eoi_money_status":1,"trust_account_id":null}},{"eoi_id":598,"company_id":1,"user_id":396,"customer_id":6329,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/170929/201709291356093151.jpg","add_time":1506664569,"add_ip":"","check_time":1506669600,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":6329,"surname":"Kim","first_name":"Hyunme","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/170929/201709291356093151.jpg","eoi_money_status":1,"trust_account_id":null}},{"eoi_id":596,"company_id":1,"user_id":396,"customer_id":6328,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/170929/201709291237447793.jpg","add_time":1506659864,"add_ip":"","check_time":1506663778,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":6328,"surname":"Nam","first_name":"Samuel","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/170929/201709291237447793.jpg","eoi_money_status":1,"trust_account_id":null}},{"eoi_id":494,"company_id":1,"user_id":396,"customer_id":5984,"product_id":92,"product_childs_id":3491,"pay_method":4,"amount":"300.00","evidence":"public/uploads/eoi_money/170914/201709141030318359.jpg","add_time":1505356231,"add_ip":"","check_time":1505381227,"refund_time":0,"if_pay":1,"status":1,"customer_info":{"customer_id":5984,"surname":"Yoon","first_name":"Ki ppeum","en_name":""},"product_info":{"product_id":92,"product_name":"House - Clydesdale Marsden Park"},"product_childs_info":{"product_childs_id":3491,"bedroom":"4","bathroom":"2","car_space":"2","price":"1.00","product_childs_unit_number":"EOI"},"pay_info":{"payment_amount":"300.00","currency":"au","payment_method":4,"eoi_money_url":"public/uploads/eoi_money/170914/201709141030318359.jpg","eoi_money_status":1,"trust_account_id":null}}]
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

    public static class ResultBean extends Domine {
        /**
         * eoi_id : 744
         * company_id : 1
         * user_id : 396
         * customer_id : 6393
         * product_id : 93
         * product_childs_id : 3501
         * pay_method : 1
         * amount : 300.00
         * evidence : public/uploads/eoi_money_new/20171121/a9bd4faaa17896de9f642d578b65190f.jpg
         * add_time : 1511231023
         * add_ip : 116.233.206.187
         * check_time : 0
         * refund_time : 0
         * if_pay : 1
         * status : 0
         * customer_info : {"customer_id":6393,"surname":"Jin","first_name":"David","en_name":""}
         * product_info : {"product_id":93,"product_name":"Land - Clydesdale Marsden Park "}
         * product_childs_info : {"product_childs_id":3501,"bedroom":"0","bathroom":"0","car_space":"0","price":"405000.00","product_childs_unit_number":"EOI"}
         * pay_info : {"payment_amount":"300.00","currency":"au","payment_method":1,"eoi_money_url":"public/uploads/eoi_money_new/20171121/a9bd4faaa17896de9f642d578b65190f.jpg","eoi_money_status":0,"trust_account_id":693}
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

        public static class CustomerInfoBean extends Domine {
            /**
             * customer_id : 6393
             * surname : Jin
             * first_name : David
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

        public static class ProductInfoBean extends Domine {
            /**
             * product_id : 93
             * product_name : Land - Clydesdale Marsden Park
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

        public static class ProductChildsInfoBean extends Domine {
            /**
             * product_childs_id : 3501
             * bedroom : 0
             * bathroom : 0
             * car_space : 0
             * price : 405000.00
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

        public static class PayInfoBean extends Domine {
            /**
             * payment_amount : 300.00
             * currency : au
             * payment_method : 1
             * eoi_money_url : public/uploads/eoi_money_new/20171121/a9bd4faaa17896de9f642d578b65190f.jpg
             * eoi_money_status : 0
             * trust_account_id : 693
             */

            private String payment_amount;
            private String currency;
            private int payment_method;
            private String eoi_money_url;
            private int eoi_money_status;
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

            public int getEoi_money_status() {
                return eoi_money_status;
            }

            public void setEoi_money_status(int eoi_money_status) {
                this.eoi_money_status = eoi_money_status;
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
