package com.yd.org.sellpopularizesystem.javaBean;

import java.util.List;

/**
 * Created by e-dot on 2017/5/2.
 */

public class CommissionsBean extends Domine {


    /**
     * code : 1
     * msg : 成功获取佣金列表
     * total_number : 50
     * result : [{"id":192,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Auburn Tower A","product_childs_lot_number":"","product_childs_unit_number":"307","order_price":"645000.00","commossion":"0.00","gst":"0.00","total":"10965.00","first_money":"5482.50","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5482.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Auburn Tower A","remark_2":"307"},{"id":433,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"WWP Marina Square","product_childs_lot_number":"","product_childs_unit_number":"E2.908","order_price":"718740.00","commossion":"0.00","gst":"0.00","total":"7906.14","first_money":"3953.07","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"3953.07","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"WWP Marina Square","remark_2":"E2.908"},{"id":524,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Parramatta Imperial B","product_childs_lot_number":"","product_childs_unit_number":"801","order_price":"860000.00","commossion":"0.00","gst":"0.00","total":"16082.00","first_money":"8041.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"2000.00","second_gst":"0.00","second_status":1,"second_time":null,"third_money":"6041.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Parramatta Imperial B","remark_2":"801"},{"id":533,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Parramatta Imperial B","product_childs_lot_number":"","product_childs_unit_number":"1002","order_price":"780000.00","commossion":"0.00","gst":"0.00","total":"14586.00","first_money":"7293.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"2000.00","second_gst":"0.00","second_status":1,"second_time":null,"third_money":"5293.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Parramatta Imperial B","remark_2":"1002"},{"id":716,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 2","product_childs_lot_number":"","product_childs_unit_number":"C307","order_price":"740000.00","commossion":"0.00","gst":"0.00","total":"12210.00","first_money":"6105.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"6105.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 2","remark_2":"C307"},{"id":726,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 2","product_childs_lot_number":"","product_childs_unit_number":"A310","order_price":"680000.00","commossion":"0.00","gst":"0.00","total":"11220.00","first_money":"5610.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5610.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 2","remark_2":"A310"},{"id":730,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 2","product_childs_lot_number":"","product_childs_unit_number":"C207","order_price":"745000.00","commossion":"0.00","gst":"0.00","total":"12292.50","first_money":"6146.25","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"6146.25","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 2","remark_2":"C207"},{"id":744,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 2","product_childs_lot_number":"","product_childs_unit_number":"C305","order_price":"740000.00","commossion":"0.00","gst":"0.00","total":"12210.00","first_money":"6105.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"6105.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 2","remark_2":"C305"},{"id":769,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rousehill Stage 3","product_childs_lot_number":"","product_childs_unit_number":"F208","order_price":"765000.00","commossion":"0.00","gst":"0.00","total":"10098.00","first_money":"5049.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5049.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rousehill Stage 3","remark_2":"F208"},{"id":830,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 3","product_childs_lot_number":"","product_childs_unit_number":"GG07","order_price":"670000.00","commossion":"0.00","gst":"0.00","total":"11055.00","first_money":"5527.50","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5527.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 3","remark_2":"GG07"},{"id":834,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 3","product_childs_lot_number":"","product_childs_unit_number":"GG11","order_price":"675000.00","commossion":"0.00","gst":"0.00","total":"11137.50","first_money":"5568.75","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5568.75","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 3","remark_2":"GG11"},{"id":837,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 3","product_childs_lot_number":"","product_childs_unit_number":"GG14","order_price":"655000.00","commossion":"0.00","gst":"0.00","total":"10807.50","first_money":"5403.75","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"5403.75","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 3","remark_2":"GG14"},{"id":843,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rousehill Stage 3 ","product_childs_lot_number":"","product_childs_unit_number":"F301","order_price":"665000.00","commossion":"0.00","gst":"0.00","total":"8778.00","first_money":"4389.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"4389.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rousehill Stage 3 ","remark_2":"F301"},{"id":845,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rousehill Stage 3 ","product_childs_lot_number":"","product_childs_unit_number":"G309","order_price":"695000.00","commossion":"0.00","gst":"0.00","total":"9174.00","first_money":"4587.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"4587.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rousehill Stage 3 ","remark_2":"G309"},{"id":850,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rousehill Stage 3 ","product_childs_lot_number":"","product_childs_unit_number":"F316","order_price":"665000.00","commossion":"0.00","gst":"0.00","total":"8778.00","first_money":"4389.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"4389.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rousehill Stage 3 ","remark_2":"F316"},{"id":851,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rousehill Stage 3 ","product_childs_lot_number":"","product_childs_unit_number":"F210","order_price":"680000.00","commossion":"0.00","gst":"0.00","total":"8976.00","first_money":"4488.00","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"4488.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rousehill Stage 3 ","remark_2":"F210"},{"id":871,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 1","product_childs_lot_number":"","product_childs_unit_number":"E109","order_price":"675000.00","commossion":"0.00","gst":"0.00","total":"7425.00","first_money":"3712.50","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"3712.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 1","remark_2":"E109"},{"id":884,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 1","product_childs_lot_number":"","product_childs_unit_number":"E212","order_price":"685000.00","commossion":"0.00","gst":"0.00","total":"7535.00","first_money":"3767.50","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"3767.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 1","remark_2":"E212"},{"id":890,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Rouse Hill Stage 1","product_childs_lot_number":"","product_childs_unit_number":"E304","order_price":"675000.00","commossion":"0.00","gst":"0.00","total":"7425.00","first_money":"3712.50","first_gst":"0.00","first_status":1,"first_time":null,"second_money":"3712.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Rouse Hill Stage 1","remark_2":"E304"},{"id":1204,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Parramatta Skyrise","product_childs_lot_number":"","product_childs_unit_number":"3702","order_price":"1160000.00","commossion":"0.00","gst":"0.00","total":"12760.00","first_money":"6380.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"6380.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Parramatta Skyrise","remark_2":"3702"},{"id":1308,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"49 Box Hill House & Land ","product_childs_lot_number":"","product_childs_unit_number":"5","order_price":"728150.00","commossion":"0.00","gst":"0.00","total":"13616.41","first_money":"4500.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"9116.41","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"49 Box Hill House & Land ","remark_2":"5"},{"id":1322,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"49 Box Hill House & Land ","product_childs_lot_number":"","product_childs_unit_number":"19","order_price":"395200.00","commossion":"0.00","gst":"0.00","total":"4347.20","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"2347.20","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"49 Box Hill House & Land ","remark_2":"19"},{"id":1323,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"49 Box Hill House & Land ","product_childs_lot_number":"","product_childs_unit_number":"20","order_price":"412100.00","commossion":"0.00","gst":"0.00","total":"4533.10","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"2533.10","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"49 Box Hill House & Land ","remark_2":"20"},{"id":1332,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"49 Box Hill House & Land ","product_childs_lot_number":"","product_childs_unit_number":"37","order_price":"390000.00","commossion":"0.00","gst":"0.00","total":"4290.00","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"2290.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"49 Box Hill House & Land ","remark_2":"37"},{"id":1551,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"NK Foxall Rd","product_childs_lot_number":"","product_childs_unit_number":"211","order_price":"947400.00","commossion":"0.00","gst":"0.00","total":"20842.80","first_money":"5000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"15842.80","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"NK Foxall Rd","remark_2":"211"},{"id":1705,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Schofields-Maple 3","product_childs_lot_number":"","product_childs_unit_number":"129","order_price":"977400.00","commossion":"0.00","gst":"0.00","total":"8000.00","first_money":"4000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"4000.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Schofields-Maple 3","remark_2":"129"},{"id":1857,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Marsden Park S2 Land Only","product_childs_lot_number":"","product_childs_unit_number":"100","order_price":"491490.00","commossion":"0.00","gst":"0.00","total":"9190.86","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"7190.86","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Marsden Park S2 Land Only","remark_2":"100"},{"id":1878,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Marsden Park S3 Land Only","product_childs_lot_number":"","product_childs_unit_number":"156","order_price":"417500.00","commossion":"0.00","gst":"0.00","total":"4592.50","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"2592.50","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Marsden Park S3 Land Only","remark_2":"156"},{"id":1879,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Marsden Park S3 Land Only","product_childs_lot_number":"","product_childs_unit_number":"157","order_price":"416250.00","commossion":"0.00","gst":"0.00","total":"4578.75","first_money":"2000.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"2578.75","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Marsden Park S3 Land Only","remark_2":"157"},{"id":1881,"company_id":1,"sale_id":224,"user_id":224,"user_first_name":"","user_surname":"","user_en_name":"","customer_id":0,"customer_first_name":"","customer_surname":"","customer_en_name":"","order_id":null,"product_id":null,"product_childs_id":null,"product_name":"Metro Groves - Box Hill","product_childs_lot_number":"","product_childs_unit_number":"116","order_price":"750000.00","commossion":"0.00","gst":"0.00","total":"9900.00","first_money":"3960.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"5940.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":0,"update_time":null,"is_value":0,"status":0,"remark_1":"Metro Groves - Box Hill","remark_2":"116"},{"id":3078,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1968,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499656946,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3081,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1971,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499657132,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3084,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1972,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658011,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3087,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1973,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658199,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3090,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1974,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658343,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3093,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1975,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658376,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3096,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1976,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658422,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3099,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1977,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658438,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3102,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1978,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658501,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3105,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1979,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658570,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3108,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1980,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658738,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3111,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1981,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499658751,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3114,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1988,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"945200.00","commossion":"1890.40","gst":"0.00","total":"1890.40","first_money":"756.16","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1134.24","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499663578,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3117,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1990,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"577000.00","commossion":"1154.00","gst":"0.00","total":"1154.00","first_money":"461.60","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"692.40","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499663823,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3120,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":1995,"product_id":71,"product_childs_id":2215,"product_name":"","product_childs_lot_number":"211","product_childs_unit_number":"","order_price":"577000.00","commossion":"1154.00","gst":"0.00","total":"1154.00","first_money":"461.60","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"692.40","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499664165,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3123,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":2010,"product_id":71,"product_childs_id":2216,"product_name":"","product_childs_lot_number":"212","product_childs_unit_number":"","order_price":"991900.00","commossion":"1983.80","gst":"0.00","total":"1983.80","first_money":"793.52","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1190.28","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499664727,"update_time":null,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3129,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":2019,"product_id":71,"product_childs_id":2216,"product_name":"","product_childs_lot_number":"212","product_childs_unit_number":"","order_price":"991900.00","commossion":"1983.80","gst":"0.00","total":"1983.80","first_money":"793.52","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1190.28","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499679398,"update_time":1499679398,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3132,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":2020,"product_id":71,"product_childs_id":2216,"product_name":"","product_childs_lot_number":"212","product_childs_unit_number":"","order_price":"991900.00","commossion":"1983.80","gst":"0.00","total":"1983.80","first_money":"793.52","first_gst":"0.00","first_status":0,"first_time":1499750876,"second_money":"1190.28","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499736566,"update_time":1499750893,"is_value":0,"status":0,"remark_1":"","remark_2":""},{"id":3135,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"caogang","order_id":2033,"product_id":71,"product_childs_id":2216,"product_name":"","product_childs_lot_number":"212","product_childs_unit_number":"","order_price":"991900.00","commossion":"1983.80","gst":"0.00","total":"1983.80","first_money":"793.52","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1190.28","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"0.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499751236,"update_time":1499751236,"is_value":1,"status":0,"remark_1":"","remark_2":""},{"id":3154,"company_id":1,"sale_id":224,"user_id":391,"user_first_name":"gang","user_surname":"cao","user_en_name":"","customer_id":4190,"customer_first_name":"Gang","customer_surname":"cao","customer_en_name":"nickName2","order_id":2042,"product_id":73,"product_childs_id":2228,"product_name":"","product_childs_lot_number":"10","product_childs_unit_number":"","order_price":"1000000.00","commossion":"2000.00","gst":"0.00","total":"2000.00","first_money":"0.00","first_gst":"0.00","first_status":0,"first_time":null,"second_money":"1000.00","second_gst":"0.00","second_status":0,"second_time":null,"third_money":"1000.00","third_gst":"0.00","third_status":0,"third_time":null,"exit_commossion":"0.00","exit_status":0,"exit_time":0,"add_time":1499853003,"update_time":1499853003,"is_value":0,"status":0,"remark_1":"","remark_2":""}]
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

    public static class ResultBean {
        /**
         * id : 192
         * company_id : 1
         * sale_id : 224
         * user_id : 224
         * user_first_name :
         * user_surname :
         * user_en_name :
         * customer_id : 0
         * customer_first_name :
         * customer_surname :
         * customer_en_name :
         * order_id : null
         * product_id : null
         * product_childs_id : null
         * product_name : Auburn Tower A
         * product_childs_lot_number :
         * product_childs_unit_number : 307
         * order_price : 645000.00
         * commossion : 0.00
         * gst : 0.00
         * total : 10965.00
         * first_money : 5482.50
         * first_gst : 0.00
         * first_status : 1
         * first_time : null
         * second_money : 5482.50
         * second_gst : 0.00
         * second_status : 0
         * second_time : null
         * third_money : 0.00
         * third_gst : 0.00
         * third_status : 0
         * third_time : null
         * exit_commossion : 0.00
         * exit_status : 0
         * exit_time : 0
         * add_time : 0
         * update_time : null
         * is_value : 0
         * status : 0
         * remark_1 : Auburn Tower A
         * remark_2 : 307
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
        private String order_id;
        private String product_id;
        private String product_childs_id;
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
        private String first_time;
        private String second_money;
        private String second_gst;
        private int second_status;
        private String second_time;
        private String third_money;
        private String third_gst;
        private int third_status;
        private String third_time;
        private String exit_commossion;
        private int exit_status;
        private int exit_time;
        private int first_invoice_status;
        private int second_invoice_status;
        private int third_invoice_status;
        private int add_time;
        private String update_time;
        private int is_value;
        private int is_show;
        private int status;
        private String remark_1;
        private String remark_2;
        private int is_wait_xingzheng;
        private int is_wait_caiwu;
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

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public Object getProduct_childs_id() {
            return product_childs_id;
        }

        public void setProduct_childs_id(String product_childs_id) {
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

        public String getFirst_time() {
            return first_time;
        }

        public void setFirst_time(String first_time) {
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

        public String getSecond_time() {
            return second_time;
        }

        public void setSecond_time(String second_time) {
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

        public String getThird_time() {
            return third_time;
        }

        public void setThird_time(String third_time) {
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

        public int getAdd_time() {
            return add_time;
        }

        public void setAdd_time(int add_time) {
            this.add_time = add_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
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


