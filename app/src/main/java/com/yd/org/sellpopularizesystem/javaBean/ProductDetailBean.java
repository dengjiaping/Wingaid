package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/4/27.
 */

public class ProductDetailBean extends Domine{


    /**
     * code : 1
     * msg : 成功获取产品详情
     * result : {"product_id":76,"company_id":1,"cate_id":3,"thumb":"public/uploads/product_thumb/170723/20170723/21795e0d40b8e6fb75dd523219b82118.jpg","provice":"","city":"","county":"","town":"","address":"","latitude":0,"longitude":0,"is_firb":0,"firb_number":0,"already_firb_number":0,"sales_method":"sale","is_promote":0,"is_hot_sale":1,"eoi_open_time":null,"constr_start_time":null,"constr_end_time":null,"start_sales_time":1499356800,"stop_sales_time":null,"sunset_time":null,"settlement_time":1540915200,"attr_1":0,"attr_2":0,"attr_3":0,"attr_4":0,"attr_5":1,"attr_6":1,"attr_7":0,"preview_memo":"","agent_notes":"","transfer_account":"","product_type":"Off Plan","vendor":"Urban(Wolli) Pty Ltd","land_vendor":"","house_vendor":"145","vendor_lawyer":"Strathfield.Law","builder":"","is_da":0,"da_number":"","dp_number":"","desposit_holder":"Unknown","deposit_holder_others":"","days_to_pay":"14","exchange_deposit":"10.00","firb_exchange_deposit":"10.00","min_reservation_fee":"5000.00","is_gst":1,"adjust_factor":"1.00","exit_commossion":"","commossion_type":1,"commossion_value":"2","commossion_send_type":1,"module_one_first":50,"module_two_first":0,"module_three_first":0,"sa_vendor_email":"","sa_vendor_names":"","sa_sent_to":"","sa_vs_contact_name":"","sa_vs_contact_phone":"","sa_vs_contact_fax":"","sa_vs_contact_email":"","street_number":"7-13","street_address_1":"Willis St","street_address_2":"","address_suburb":"Wolli Creek","state":"NSW","postcode":"2205","country":"","is_study":0,"study_id":"","up_time":null,"up_ip":null,"up_admin":null,"sell_number":18,"sign_number":2,"share_url":"","product_sort":999,"is_old_product":1,"status":2,"product_name":"APT- Wolli Creek ","description":"","img_content":[{"detail_id":687,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture","description":"","old_name":"image6.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008035615.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008035615_thumb.jpg","extension":"jpg","add_time":1500811683,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":690,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"picture4","description":"","old_name":"image3.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232009074250.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232009074250_thumb.jpg","extension":"jpg","add_time":1500811747,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":689,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture3","description":"","old_name":"image2.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008457442.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008457442_thumb.jpg","extension":"jpg","add_time":1500811726,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":688,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"picture2","description":"","old_name":"image4.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008264415.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008264415_thumb.jpg","extension":"jpg","add_time":1500811706,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":691,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture5","description":"","old_name":"image5.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232009308590.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232009308590_thumb.jpg","extension":"jpg","add_time":1500811770,"add_ip":"210.185.109.19","add_admin":6,"status":0}],"description_url":"public/uploads/product_detail/170727/detail_201707271403382625.pdf","video_url":null,"contract_url":"public/uploads/product_detail/170727/detail_201707271400588071.pdf","file_content":[{"detail_id":1067,"content_type":2,"img_type":2,"file_type":2,"company_id":1,"product_id":76,"detail_name":"finish of schedule","description":"","old_name":"7-13 Willis St Wolli Creek -finish of schedule.pdf","sort":0,"url":"public/uploads/product_detail/170927/detail_201709271607319234.pdf","thumbURL":"public/uploads/product_detail/170927/detail_201709271607319234_thumb.pdf","extension":"pdf","add_time":1506499651,"add_ip":"61.69.80.54","add_admin":21,"status":0},{"detail_id":1065,"content_type":2,"img_type":2,"file_type":2,"company_id":1,"product_id":76,"detail_name":"floor plate","description":"","old_name":"16-020_7-13 Willis Street Wolli Creek_Floor Plates_170710.pdf","sort":0,"url":"public/uploads/product_detail/170927/detail_201709271606166862.pdf","thumbURL":"public/uploads/product_detail/170927/detail_201709271606166862_thumb.pdf","extension":"pdf","add_time":1506499576,"add_ip":"61.69.80.54","add_admin":21,"status":0}]}
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

    public static class ResultBean  extends Domine{
        /**
         * product_id : 76
         * company_id : 1
         * cate_id : 3
         * thumb : public/uploads/product_thumb/170723/20170723/21795e0d40b8e6fb75dd523219b82118.jpg
         * provice :
         * city :
         * county :
         * town :
         * address :
         * latitude : 0
         * longitude : 0
         * is_firb : 0
         * firb_number : 0
         * already_firb_number : 0
         * sales_method : sale
         * is_promote : 0
         * is_hot_sale : 1
         * eoi_open_time : null
         * constr_start_time : null
         * constr_end_time : null
         * start_sales_time : 1499356800
         * stop_sales_time : null
         * sunset_time : null
         * settlement_time : 1540915200
         * attr_1 : 0
         * attr_2 : 0
         * attr_3 : 0
         * attr_4 : 0
         * attr_5 : 1
         * attr_6 : 1
         * attr_7 : 0
         * preview_memo :
         * agent_notes :
         * transfer_account :
         * product_type : Off Plan
         * vendor : Urban(Wolli) Pty Ltd
         * land_vendor :
         * house_vendor : 145
         * vendor_lawyer : Strathfield.Law
         * builder :
         * is_da : 0
         * da_number :
         * dp_number :
         * desposit_holder : Unknown
         * deposit_holder_others :
         * days_to_pay : 14
         * exchange_deposit : 10.00
         * firb_exchange_deposit : 10.00
         * min_reservation_fee : 5000.00
         * is_gst : 1
         * adjust_factor : 1.00
         * exit_commossion :
         * commossion_type : 1
         * commossion_value : 2
         * commossion_send_type : 1
         * module_one_first : 50
         * module_two_first : 0
         * module_three_first : 0
         * sa_vendor_email :
         * sa_vendor_names :
         * sa_sent_to :
         * sa_vs_contact_name :
         * sa_vs_contact_phone :
         * sa_vs_contact_fax :
         * sa_vs_contact_email :
         * street_number : 7-13
         * street_address_1 : Willis St
         * street_address_2 :
         * address_suburb : Wolli Creek
         * state : NSW
         * postcode : 2205
         * country :
         * is_study : 0
         * study_id :
         * up_time : null
         * up_ip : null
         * up_admin : null
         * sell_number : 18
         * sign_number : 2
         * share_url :
         * product_sort : 999
         * is_old_product : 1
         * status : 2
         * product_name : APT- Wolli Creek
         * description :
         * img_content : [{"detail_id":687,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture","description":"","old_name":"image6.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008035615.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008035615_thumb.jpg","extension":"jpg","add_time":1500811683,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":690,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"picture4","description":"","old_name":"image3.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232009074250.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232009074250_thumb.jpg","extension":"jpg","add_time":1500811747,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":689,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture3","description":"","old_name":"image2.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008457442.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008457442_thumb.jpg","extension":"jpg","add_time":1500811726,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":688,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"picture2","description":"","old_name":"image4.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232008264415.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232008264415_thumb.jpg","extension":"jpg","add_time":1500811706,"add_ip":"210.185.109.19","add_admin":6,"status":0},{"detail_id":691,"content_type":1,"img_type":2,"file_type":0,"company_id":1,"product_id":76,"detail_name":"Picture5","description":"","old_name":"image5.jpg","sort":0,"url":"public/uploads/product_detail/170723/detail_201707232009308590.jpg","thumbURL":"public/uploads/product_detail/170723/detail_201707232009308590_thumb.jpg","extension":"jpg","add_time":1500811770,"add_ip":"210.185.109.19","add_admin":6,"status":0}]
         * description_url : public/uploads/product_detail/170727/detail_201707271403382625.pdf
         * video_url : null
         * contract_url : public/uploads/product_detail/170727/detail_201707271400588071.pdf
         * file_content : [{"detail_id":1067,"content_type":2,"img_type":2,"file_type":2,"company_id":1,"product_id":76,"detail_name":"finish of schedule","description":"","old_name":"7-13 Willis St Wolli Creek -finish of schedule.pdf","sort":0,"url":"public/uploads/product_detail/170927/detail_201709271607319234.pdf","thumbURL":"public/uploads/product_detail/170927/detail_201709271607319234_thumb.pdf","extension":"pdf","add_time":1506499651,"add_ip":"61.69.80.54","add_admin":21,"status":0},{"detail_id":1065,"content_type":2,"img_type":2,"file_type":2,"company_id":1,"product_id":76,"detail_name":"floor plate","description":"","old_name":"16-020_7-13 Willis Street Wolli Creek_Floor Plates_170710.pdf","sort":0,"url":"public/uploads/product_detail/170927/detail_201709271606166862.pdf","thumbURL":"public/uploads/product_detail/170927/detail_201709271606166862_thumb.pdf","extension":"pdf","add_time":1506499576,"add_ip":"61.69.80.54","add_admin":21,"status":0}]
         */

        private int product_id;
        private int company_id;
        private int cate_id;
        private String thumb;
        private String provice;
        private String city;
        private String county;
        private String town;
        private String address;
        private double latitude;
        private double longitude;
        private int is_firb;
        private int firb_number;
        private int already_firb_number;
        private String sales_method;
        private int is_promote;
        private int is_hot_sale;
        private Object eoi_open_time;
        private Object constr_start_time;
        private Object constr_end_time;
        private int start_sales_time;
        private Object stop_sales_time;
        private Object sunset_time;
        private int settlement_time;
        private int attr_1;
        private int attr_2;
        private int attr_3;
        private int attr_4;
        private int attr_5;
        private int attr_6;
        private int attr_7;
        private String preview_memo;
        private String agent_notes;
        private String transfer_account;
        private String product_type;
        private String vendor;
        private String land_vendor;
        private String house_vendor;
        private String vendor_lawyer;
        private String builder;
        private int is_da;
        private String da_number;
        private String dp_number;
        private String desposit_holder;
        private String deposit_holder_others;
        private String days_to_pay;
        private String exchange_deposit;
        private String firb_exchange_deposit;
        private String min_reservation_fee;
        private int is_gst;
        private String adjust_factor;
        private String exit_commossion;
        private int commossion_type;
        private String commossion_value;
        private int commossion_send_type;
        private int module_one_first;
        private int module_two_first;
        private int module_three_first;
        private String sa_vendor_email;
        private String sa_vendor_names;
        private String sa_sent_to;
        private String sa_vs_contact_name;
        private String sa_vs_contact_phone;
        private String sa_vs_contact_fax;
        private String sa_vs_contact_email;
        private String street_number;
        private String street_address_1;
        private String street_address_2;
        private String address_suburb;
        private String state;
        private String postcode;
        private String country;
        private int is_study;
        private String study_id;
        private Object up_time;
        private Object up_ip;
        private Object up_admin;
        private int sell_number;
        private int sign_number;
        private String share_url;
        private int product_sort;
        private int is_old_product;
        private int status;
        private String product_name;
        private String description;
        private String description_url;
        private Object video_url;
        private String contract_url;
        private List<ImgContentBean> img_content;
        private List<FileContentBean> file_content;

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
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

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getIs_firb() {
            return is_firb;
        }

        public void setIs_firb(int is_firb) {
            this.is_firb = is_firb;
        }

        public int getFirb_number() {
            return firb_number;
        }

        public void setFirb_number(int firb_number) {
            this.firb_number = firb_number;
        }

        public int getAlready_firb_number() {
            return already_firb_number;
        }

        public void setAlready_firb_number(int already_firb_number) {
            this.already_firb_number = already_firb_number;
        }

        public String getSales_method() {
            return sales_method;
        }

        public void setSales_method(String sales_method) {
            this.sales_method = sales_method;
        }

        public int getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(int is_promote) {
            this.is_promote = is_promote;
        }

        public int getIs_hot_sale() {
            return is_hot_sale;
        }

        public void setIs_hot_sale(int is_hot_sale) {
            this.is_hot_sale = is_hot_sale;
        }

        public Object getEoi_open_time() {
            return eoi_open_time;
        }

        public void setEoi_open_time(Object eoi_open_time) {
            this.eoi_open_time = eoi_open_time;
        }

        public Object getConstr_start_time() {
            return constr_start_time;
        }

        public void setConstr_start_time(Object constr_start_time) {
            this.constr_start_time = constr_start_time;
        }

        public Object getConstr_end_time() {
            return constr_end_time;
        }

        public void setConstr_end_time(Object constr_end_time) {
            this.constr_end_time = constr_end_time;
        }

        public int getStart_sales_time() {
            return start_sales_time;
        }

        public void setStart_sales_time(int start_sales_time) {
            this.start_sales_time = start_sales_time;
        }

        public Object getStop_sales_time() {
            return stop_sales_time;
        }

        public void setStop_sales_time(Object stop_sales_time) {
            this.stop_sales_time = stop_sales_time;
        }

        public Object getSunset_time() {
            return sunset_time;
        }

        public void setSunset_time(Object sunset_time) {
            this.sunset_time = sunset_time;
        }

        public int getSettlement_time() {
            return settlement_time;
        }

        public void setSettlement_time(int settlement_time) {
            this.settlement_time = settlement_time;
        }

        public int getAttr_1() {
            return attr_1;
        }

        public void setAttr_1(int attr_1) {
            this.attr_1 = attr_1;
        }

        public int getAttr_2() {
            return attr_2;
        }

        public void setAttr_2(int attr_2) {
            this.attr_2 = attr_2;
        }

        public int getAttr_3() {
            return attr_3;
        }

        public void setAttr_3(int attr_3) {
            this.attr_3 = attr_3;
        }

        public int getAttr_4() {
            return attr_4;
        }

        public void setAttr_4(int attr_4) {
            this.attr_4 = attr_4;
        }

        public int getAttr_5() {
            return attr_5;
        }

        public void setAttr_5(int attr_5) {
            this.attr_5 = attr_5;
        }

        public int getAttr_6() {
            return attr_6;
        }

        public void setAttr_6(int attr_6) {
            this.attr_6 = attr_6;
        }

        public int getAttr_7() {
            return attr_7;
        }

        public void setAttr_7(int attr_7) {
            this.attr_7 = attr_7;
        }

        public String getPreview_memo() {
            return preview_memo;
        }

        public void setPreview_memo(String preview_memo) {
            this.preview_memo = preview_memo;
        }

        public String getAgent_notes() {
            return agent_notes;
        }

        public void setAgent_notes(String agent_notes) {
            this.agent_notes = agent_notes;
        }

        public String getTransfer_account() {
            return transfer_account;
        }

        public void setTransfer_account(String transfer_account) {
            this.transfer_account = transfer_account;
        }

        public String getProduct_type() {
            return product_type;
        }

        public void setProduct_type(String product_type) {
            this.product_type = product_type;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getLand_vendor() {
            return land_vendor;
        }

        public void setLand_vendor(String land_vendor) {
            this.land_vendor = land_vendor;
        }

        public String getHouse_vendor() {
            return house_vendor;
        }

        public void setHouse_vendor(String house_vendor) {
            this.house_vendor = house_vendor;
        }

        public String getVendor_lawyer() {
            return vendor_lawyer;
        }

        public void setVendor_lawyer(String vendor_lawyer) {
            this.vendor_lawyer = vendor_lawyer;
        }

        public String getBuilder() {
            return builder;
        }

        public void setBuilder(String builder) {
            this.builder = builder;
        }

        public int getIs_da() {
            return is_da;
        }

        public void setIs_da(int is_da) {
            this.is_da = is_da;
        }

        public String getDa_number() {
            return da_number;
        }

        public void setDa_number(String da_number) {
            this.da_number = da_number;
        }

        public String getDp_number() {
            return dp_number;
        }

        public void setDp_number(String dp_number) {
            this.dp_number = dp_number;
        }

        public String getDesposit_holder() {
            return desposit_holder;
        }

        public void setDesposit_holder(String desposit_holder) {
            this.desposit_holder = desposit_holder;
        }

        public String getDeposit_holder_others() {
            return deposit_holder_others;
        }

        public void setDeposit_holder_others(String deposit_holder_others) {
            this.deposit_holder_others = deposit_holder_others;
        }

        public String getDays_to_pay() {
            return days_to_pay;
        }

        public void setDays_to_pay(String days_to_pay) {
            this.days_to_pay = days_to_pay;
        }

        public String getExchange_deposit() {
            return exchange_deposit;
        }

        public void setExchange_deposit(String exchange_deposit) {
            this.exchange_deposit = exchange_deposit;
        }

        public String getFirb_exchange_deposit() {
            return firb_exchange_deposit;
        }

        public void setFirb_exchange_deposit(String firb_exchange_deposit) {
            this.firb_exchange_deposit = firb_exchange_deposit;
        }

        public String getMin_reservation_fee() {
            return min_reservation_fee;
        }

        public void setMin_reservation_fee(String min_reservation_fee) {
            this.min_reservation_fee = min_reservation_fee;
        }

        public int getIs_gst() {
            return is_gst;
        }

        public void setIs_gst(int is_gst) {
            this.is_gst = is_gst;
        }

        public String getAdjust_factor() {
            return adjust_factor;
        }

        public void setAdjust_factor(String adjust_factor) {
            this.adjust_factor = adjust_factor;
        }

        public String getExit_commossion() {
            return exit_commossion;
        }

        public void setExit_commossion(String exit_commossion) {
            this.exit_commossion = exit_commossion;
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

        public String getSa_vendor_email() {
            return sa_vendor_email;
        }

        public void setSa_vendor_email(String sa_vendor_email) {
            this.sa_vendor_email = sa_vendor_email;
        }

        public String getSa_vendor_names() {
            return sa_vendor_names;
        }

        public void setSa_vendor_names(String sa_vendor_names) {
            this.sa_vendor_names = sa_vendor_names;
        }

        public String getSa_sent_to() {
            return sa_sent_to;
        }

        public void setSa_sent_to(String sa_sent_to) {
            this.sa_sent_to = sa_sent_to;
        }

        public String getSa_vs_contact_name() {
            return sa_vs_contact_name;
        }

        public void setSa_vs_contact_name(String sa_vs_contact_name) {
            this.sa_vs_contact_name = sa_vs_contact_name;
        }

        public String getSa_vs_contact_phone() {
            return sa_vs_contact_phone;
        }

        public void setSa_vs_contact_phone(String sa_vs_contact_phone) {
            this.sa_vs_contact_phone = sa_vs_contact_phone;
        }

        public String getSa_vs_contact_fax() {
            return sa_vs_contact_fax;
        }

        public void setSa_vs_contact_fax(String sa_vs_contact_fax) {
            this.sa_vs_contact_fax = sa_vs_contact_fax;
        }

        public String getSa_vs_contact_email() {
            return sa_vs_contact_email;
        }

        public void setSa_vs_contact_email(String sa_vs_contact_email) {
            this.sa_vs_contact_email = sa_vs_contact_email;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        public String getStreet_address_1() {
            return street_address_1;
        }

        public void setStreet_address_1(String street_address_1) {
            this.street_address_1 = street_address_1;
        }

        public String getStreet_address_2() {
            return street_address_2;
        }

        public void setStreet_address_2(String street_address_2) {
            this.street_address_2 = street_address_2;
        }

        public String getAddress_suburb() {
            return address_suburb;
        }

        public void setAddress_suburb(String address_suburb) {
            this.address_suburb = address_suburb;
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

        public int getIs_study() {
            return is_study;
        }

        public void setIs_study(int is_study) {
            this.is_study = is_study;
        }

        public String getStudy_id() {
            return study_id;
        }

        public void setStudy_id(String study_id) {
            this.study_id = study_id;
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

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getProduct_sort() {
            return product_sort;
        }

        public void setProduct_sort(int product_sort) {
            this.product_sort = product_sort;
        }

        public int getIs_old_product() {
            return is_old_product;
        }

        public void setIs_old_product(int is_old_product) {
            this.is_old_product = is_old_product;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription_url() {
            return description_url;
        }

        public void setDescription_url(String description_url) {
            this.description_url = description_url;
        }

        public Object getVideo_url() {
            return video_url;
        }

        public void setVideo_url(Object video_url) {
            this.video_url = video_url;
        }

        public String getContract_url() {
            return contract_url;
        }

        public void setContract_url(String contract_url) {
            this.contract_url = contract_url;
        }

        public List<ImgContentBean> getImg_content() {
            return img_content;
        }

        public void setImg_content(List<ImgContentBean> img_content) {
            this.img_content = img_content;
        }

        public List<FileContentBean> getFile_content() {
            return file_content;
        }

        public void setFile_content(List<FileContentBean> file_content) {
            this.file_content = file_content;
        }

        public static class ImgContentBean extends Domine{
            /**
             * detail_id : 687
             * content_type : 1
             * img_type : 2
             * file_type : 0
             * company_id : 1
             * product_id : 76
             * detail_name : Picture
             * description :
             * old_name : image6.jpg
             * sort : 0
             * url : public/uploads/product_detail/170723/detail_201707232008035615.jpg
             * thumbURL : public/uploads/product_detail/170723/detail_201707232008035615_thumb.jpg
             * extension : jpg
             * add_time : 1500811683
             * add_ip : 210.185.109.19
             * add_admin : 6
             * status : 0
             */

            private int detail_id;
            private int content_type;
            private int img_type;
            private int file_type;
            private int company_id;
            private int product_id;
            private String detail_name;
            private String description;
            private String old_name;
            private int sort;
            private String url;
            private String thumbURL;
            private String extension;
            private int add_time;
            private String add_ip;
            private int add_admin;
            private int status;

            public int getDetail_id() {
                return detail_id;
            }

            public void setDetail_id(int detail_id) {
                this.detail_id = detail_id;
            }

            public int getContent_type() {
                return content_type;
            }

            public void setContent_type(int content_type) {
                this.content_type = content_type;
            }

            public int getImg_type() {
                return img_type;
            }

            public void setImg_type(int img_type) {
                this.img_type = img_type;
            }

            public int getFile_type() {
                return file_type;
            }

            public void setFile_type(int file_type) {
                this.file_type = file_type;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getDetail_name() {
                return detail_name;
            }

            public void setDetail_name(String detail_name) {
                this.detail_name = detail_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getOld_name() {
                return old_name;
            }

            public void setOld_name(String old_name) {
                this.old_name = old_name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbURL() {
                return thumbURL;
            }

            public void setThumbURL(String thumbURL) {
                this.thumbURL = thumbURL;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
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

            public int getAdd_admin() {
                return add_admin;
            }

            public void setAdd_admin(int add_admin) {
                this.add_admin = add_admin;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class FileContentBean extends Domine {
            /**
             * detail_id : 1067
             * content_type : 2
             * img_type : 2
             * file_type : 2
             * company_id : 1
             * product_id : 76
             * detail_name : finish of schedule
             * description :
             * old_name : 7-13 Willis St Wolli Creek -finish of schedule.pdf
             * sort : 0
             * url : public/uploads/product_detail/170927/detail_201709271607319234.pdf
             * thumbURL : public/uploads/product_detail/170927/detail_201709271607319234_thumb.pdf
             * extension : pdf
             * add_time : 1506499651
             * add_ip : 61.69.80.54
             * add_admin : 21
             * status : 0
             */

            private int detail_id;
            private int content_type;
            private int img_type;
            private int file_type;
            private int company_id;
            private int product_id;
            private String detail_name;
            private String description;
            private String old_name;
            private int sort;
            private String url;
            private String thumbURL;
            private String extension;
            private int add_time;
            private String add_ip;
            private int add_admin;
            private int status;

            public int getDetail_id() {
                return detail_id;
            }

            public void setDetail_id(int detail_id) {
                this.detail_id = detail_id;
            }

            public int getContent_type() {
                return content_type;
            }

            public void setContent_type(int content_type) {
                this.content_type = content_type;
            }

            public int getImg_type() {
                return img_type;
            }

            public void setImg_type(int img_type) {
                this.img_type = img_type;
            }

            public int getFile_type() {
                return file_type;
            }

            public void setFile_type(int file_type) {
                this.file_type = file_type;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getDetail_name() {
                return detail_name;
            }

            public void setDetail_name(String detail_name) {
                this.detail_name = detail_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getOld_name() {
                return old_name;
            }

            public void setOld_name(String old_name) {
                this.old_name = old_name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbURL() {
                return thumbURL;
            }

            public void setThumbURL(String thumbURL) {
                this.thumbURL = thumbURL;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
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

            public int getAdd_admin() {
                return add_admin;
            }

            public void setAdd_admin(int add_admin) {
                this.add_admin = add_admin;
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
