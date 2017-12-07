package com.yd.org.sellpopularizesystem.javaBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${bai} on 17/2/4.
 */

public class CustomBean implements Serializable {


    /**
     * code : 1
     * msg : 成功获取客户列表
     * total_number : 2
     * result : [{"customer_id":7784,"company_id":1,"customer_nick":null,"head_img":"","true_name":null,"surname":"len","first_name":"ka","en_name":"nickName","sex":0,"title":"","gender":"","birth_date":"","mid_name":"","ext_id":"","customer_type":1,"abn":"","acn":"","age":null,"mobile":"1391","unit_number":"","street_number":"","street_address_line_1":"","street_address_line_2":"","suburb":"","state":"","postcode":"","country":"","province":"","city":"","area":"","address":"","zip_code":"-","openid":null,"wechat_number":"","wechat_nick":"","wechat_img":"","qq_number":"","e_mail":null,"job":"","income":0,"family_name":null,"family_first_name":"","family_relationship":"","family_mobile":"","family_email":"","sign_number":0,"card_id":"","passport_id":"","passport_country":"","card_validity":null,"is_experience":0,"flight_date":null,"flight_number":null,"add_time":1497424638,"update_time":1497424638,"add_ip":"116.226.190.44","add_admin":null,"add_user":183,"is_del":0,"is_firb":0,"status":0,"memo":""},{"customer_id":7782,"company_id":1,"customer_nick":null,"head_img":"","true_name":null,"surname":"mike","first_name":"jack","en_name":"nickname","sex":0,"title":"","gender":"","birth_date":"","mid_name":"le","ext_id":"","customer_type":1,"abn":"","acn":"","age":null,"mobile":"131","unit_number":"","street_number":"","street_address_line_1":"","street_address_line_2":"","suburb":"","state":"","postcode":"","country":"","province":"","city":"","area":"","address":"","zip_code":"-","openid":null,"wechat_number":"","wechat_nick":"","wechat_img":"","qq_number":"","e_mail":null,"job":"","income":0,"family_name":null,"family_first_name":"","family_relationship":"","family_mobile":"","family_email":"","sign_number":0,"card_id":"","passport_id":"","passport_country":"","card_validity":null,"is_experience":0,"flight_date":null,"flight_number":null,"add_time":1497415086,"update_time":1497415086,"add_ip":"116.226.190.44","add_admin":null,"add_user":183,"is_del":0,"is_firb":0,"status":0,"memo":""}]
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


    public static class ResultBean  implements Serializable {
        /**
         * customer_id : 7784
         * company_id : 1
         * customer_nick : null
         * head_img :
         * true_name : null
         * surname : len
         * first_name : ka
         * en_name : nickName
         * sex : 0
         * title :
         * gender :
         * birth_date :
         * mid_name :
         * ext_id :
         * customer_type : 1
         * abn :
         * acn :
         * age : null
         * mobile : 1391
         * unit_number :
         * street_number :
         * street_address_line_1 :
         * street_address_line_2 :
         * suburb :
         * state :
         * postcode :
         * country :
         * province :
         * city :
         * area :
         * address :
         * zip_code : -
         * openid : null
         * wechat_number :
         * wechat_nick :
         * wechat_img :
         * qq_number :
         * e_mail : null
         * job :
         * income : 0
         * family_name : null
         * family_first_name :
         * family_relationship :
         * family_mobile :
         * family_email :
         * sign_number : 0
         * card_id :
         * passport_id :
         * passport_country :
         * card_validity : null
         * is_experience : 0
         * flight_date : null
         * flight_number : null
         * add_time : 1497424638
         * update_time : 1497424638
         * add_ip : 116.226.190.44
         * add_admin : null
         * add_user : 183
         * is_del : 0
         * is_firb : 0
         * status : 0
         * memo :
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
        private String province;
        private String city;
        private String area;
        private String address;
        private String zip_code;
        private Object openid;
        private String wechat_number;
        private String wechat_nick;
        private String wechat_img;
        private String qq_number;
        private String e_mail;
        private String job;
        private int income;
        private Object family_name;
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
        private int status;
        private String memo;

        public boolean isAdd() {
            return isAdd;
        }

        public void setAdd(boolean add) {
            isAdd = add;
        }

        private  boolean  isAdd;

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        private String sortLetters;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
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

        public Object getFamily_name() {
            return family_name;
        }

        public void setFamily_name(Object family_name) {
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
    }
}
