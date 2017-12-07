package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by hejin on 2017/4/27.
 */

public class ProductSubunitListBean extends Domine{

    /**
     * code : 1
     * msg : 成功获取产品列表
     * total_number : 2
     * result : [{"product_childs_id":26,"product_id":9,"product_childs_lot_number":"1909","product_childs_unit_number":"C座","company_id":1,"cate_id":3,"cate_type":1,"area":"3","bedroom":"3","bathroom":"3","car_space":"4","has_study":"3","ensuite":"1","level":"34","floor_type":"","aspect":"","internal":"758.00","external":"45.00","building_area":"33.00","land_size":"0.00","price":"0.00","vendor_price":"0.00","discount_amount":"0.00","land_vendor_price":"0.00","land_discount_amount":"0.00","house_vendor_price":"0.00","house_discount_amount":"0.00","is_gst":1,"is_specal_commission":0,"sales_commission_type":1,"sales_commission_value":"0.00","first_commission_type":"","commossion_first":"0.00","second_commission_type":"","commossion_second":"0.00","third_commission_type":"","commossion_third":"0.00","currency":"","thumb":"public/uploads/product_childs_thumb/170215/201702151505504262.png","up_time":1487142350,"up_ip":"117.84.78.157","up_admin":4,"is_lock":1,"is_eoi":0,"if_eoi":0,"status":0,"cate_name":"rrrb","product_name":"好房不等人，快来抢房啦","product_description":"这里是简介","product_childs_name":"人有两个宝","product_childs_description":"双手和大脑，，，双手会做工，大脑会思考"},{"product_childs_id":25,"product_id":9,"product_childs_lot_number":"萨达萨达","product_childs_unit_number":"萨达萨达","company_id":1,"cate_id":0,"cate_type":1,"area":"","bedroom":"1","bathroom":"12","car_space":"1","has_study":"0","ensuite":"0","level":"0","floor_type":"","aspect":"","internal":"0.00","external":"0.00","building_area":"0.00","land_size":"0.00","price":"0.00","vendor_price":"0.00","discount_amount":"0.00","land_vendor_price":"0.00","land_discount_amount":"0.00","house_vendor_price":"0.00","house_discount_amount":"0.00","is_gst":1,"is_specal_commission":0,"sales_commission_type":1,"sales_commission_value":"0.00","first_commission_type":"","commossion_first":"0.00","second_commission_type":"","commossion_second":"0.00","third_commission_type":"","commossion_third":"0.00","currency":"","thumb":"public/uploads/product_childs_thumb/170214/201702141710003562.png","up_time":1487063400,"up_ip":"117.84.78.157","up_admin":4,"is_lock":1,"is_eoi":0,"if_eoi":0,"status":0,"cate_name":null,"product_name":"好房不等人，快来抢房啦","product_description":"这里是简介","product_childs_name":"","product_childs_description":"第三方撒旦法"}]
     */

    private String code;
    private String msg;
    private int total_number;
    private List<ProductChildBean> result;

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

    public List<ProductChildBean> getResult() {
        return result;
    }

    public void setResult(List<ProductChildBean> result) {
        this.result = result;
    }
}
