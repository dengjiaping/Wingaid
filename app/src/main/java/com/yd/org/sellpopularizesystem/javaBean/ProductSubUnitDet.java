package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by hejin on 2017/4/27.
 */

public class ProductSubUnitDet extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * result : {"product_childs_id":1899,"product_id":38,"product_childs_lot_number":"10","product_childs_unit_number":"203","company_id":2,"cate_id":1,"cate_type":1,"area":"","bedroom":"1","bathroom":"2","car_space":"1","has_study":"0","ensuite":"3","level":"2","floor_type":"1","aspect":"W","internal":"44.00","external":"6.00","building_area":"50.00","land_size":"0.00","price":"0.00","vendor_price":"650000.00","discount_amount":"0.00","land_vendor_price":"0.00","land_discount_amount":"0.00","house_vendor_price":"0.00","house_discount_amount":"0.00","is_gst":1,"is_specal_commission":0,"sales_commission_type":1,"sales_commission_value":"2.00","first_commission_type":"","commossion_first":"0.00","second_commission_type":"","commossion_second":"0.00","third_commission_type":"","commossion_third":"0.00","currency":"au","thumb":"public/uploads/product_thumb/170406/201704060956022039.jpg","up_time":null,"up_ip":null,"up_admin":null,"is_lock":1,"is_eoi":0,"if_eoi":0,"status":0}
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
         * product_childs_id : 1899
         * product_id : 38
         * product_childs_lot_number : 10
         * product_childs_unit_number : 203
         * company_id : 2
         * cate_id : 1
         * cate_type : 1
         * area :
         * bedroom : 1
         * bathroom : 2
         * car_space : 1
         * has_study : 0
         * ensuite : 3
         * level : 2
         * floor_type : 1
         * aspect : W
         * internal : 44.00
         * external : 6.00
         * building_area : 50.00
         * land_size : 0.00
         * price : 0.00
         * vendor_price : 650000.00
         * discount_amount : 0.00
         * land_vendor_price : 0.00
         * land_discount_amount : 0.00
         * house_vendor_price : 0.00
         * house_discount_amount : 0.00
         * is_gst : 1
         * is_specal_commission : 0
         * sales_commission_type : 1
         * sales_commission_value : 2.00
         * first_commission_type :
         * commossion_first : 0.00
         * second_commission_type :
         * commossion_second : 0.00
         * third_commission_type :
         * commossion_third : 0.00
         * currency : au
         * thumb : public/uploads/product_thumb/170406/201704060956022039.jpg
         * up_time : null
         * up_ip : null
         * up_admin : null
         * is_lock : 1
         * is_eoi : 0
         * if_eoi : 0
         * status : 0
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
        private Object up_time;
        private Object up_ip;
        private Object up_admin;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
