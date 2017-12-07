package com.yd.org.sellpopularizesystem.javaBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hejin on 2017/2/21.
 */

public class ScaleListBean extends Domine {

    /**
     * code : 1
     * msg : 成功获取产品列表
     * total_number : 1
     * result : [{"product_childs_id":26,"product_id":9,"product_childs_lot_number":"dsefew","product_childs_unit_number":"erew","company_id":1,"cate_id":2,"area":"3","bedroom":3,"bathroom":3,"car_space":4,"has_study":3,"ensuite":1,"level":34,"internal":"758.00","external":"45.00","building_area":"33.00","price":"234.00","thumb":"public/uploads/product_thumb/170119/201701191534324505.jpg","up_time":1484811272,"up_ip":"180.114.133.77","up_admin":4,"sell_number":0,"sign_number":0,"status":0,"provice":"","city":"","county":"","town":"","address":"","latitude":0,"longitude":0,"id":272,"user_id":100009,"add_time":1486633500,"sort":99,"product_name":"好房不等人，快来抢房啦","product_description":"这里是简介","product_childs_name":"人有两个宝","product_childs_description":"双手和大脑，，，双手会做工，大脑会思考"}]
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

    public static class ResultBean implements Serializable {
        /**
         * product_childs_id : 26
         * product_id : 9
         * product_childs_lot_number : dsefew
         * product_childs_unit_number : erew
         * company_id : 1
         * cate_id : 2
         * area : 3
         * bedroom : 3
         * bathroom : 3
         * car_space : 4
         * has_study : 3
         * ensuite : 1
         * level : 34
         * internal : 758.00
         * external : 45.00
         * building_area : 33.00
         * price : 234.00
         * thumb : public/uploads/product_thumb/170119/201701191534324505.jpg
         * up_time : 1484811272
         * up_ip : 180.114.133.77
         * up_admin : 4
         * sell_number : 0
         * sign_number : 0
         * status : 0
         * provice :
         * city :
         * county :
         * town :
         * address :
         * latitude : 0
         * longitude : 0
         * id : 272
         * user_id : 100009
         * add_time : 1486633500
         * sort : 99
         * product_name : 好房不等人，快来抢房啦
         * product_description : 这里是简介
         * product_childs_name : 人有两个宝
         * product_childs_description : 双手和大脑，，，双手会做工，大脑会思考
         */

        private int product_childs_id;
        private int product_id;
        private String product_childs_lot_number;
        private String product_childs_unit_number;
        private int company_id;
        private int cate_id;
        private String area;
        private int bedroom;
        private int bathroom;
        private int car_space;
        private int has_study;
        private int ensuite;
        private int level;
        private String internal;
        private String external;
        private String building_area;
        private String price;
        private String thumb;
        private int up_time;
        private String up_ip;
        private int up_admin;
        private int sell_number;
        private int sign_number;
        private int status;
        private String provice;
        private String city;
        private String county;
        private String town;
        private String address;
        private int latitude;
        private int longitude;
        private int id;
        private int user_id;
        private int add_time;
        private int sort;
        private String product_name;
        private String product_description;
        private String product_childs_name;
        private String product_childs_description;

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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getBedroom() {
            return bedroom;
        }

        public void setBedroom(int bedroom) {
            this.bedroom = bedroom;
        }

        public int getBathroom() {
            return bathroom;
        }

        public void setBathroom(int bathroom) {
            this.bathroom = bathroom;
        }

        public int getCar_space() {
            return car_space;
        }

        public void setCar_space(int car_space) {
            this.car_space = car_space;
        }

        public int getHas_study() {
            return has_study;
        }

        public void setHas_study(int has_study) {
            this.has_study = has_study;
        }

        public int getEnsuite() {
            return ensuite;
        }

        public void setEnsuite(int ensuite) {
            this.ensuite = ensuite;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
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

        public int getSell_number() {
            return sell_number;
        }

        public void setSell_number(int sell_number) {
            this.sell_number = sell_number;
        }

        public int getSign_number() {
            return sign_number;
        }

        public void setSign_number(int sign_number) {
            this.sign_number = sign_number;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getProvice() {
            return provice;
        }

        public void setProvice(String provice) {
            this.provice = provice;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
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

        public String getProduct_childs_name() {
            return product_childs_name;
        }

        public void setProduct_childs_name(String product_childs_name) {
            this.product_childs_name = product_childs_name;
        }

        public String getProduct_childs_description() {
            return product_childs_description;
        }

        public void setProduct_childs_description(String product_childs_description) {
            this.product_childs_description = product_childs_description;
        }
    }
}
