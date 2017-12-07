package com.yd.org.sellpopularizesystem.javaBean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hejin on 2017/9/22.
 */

public class InvoiceDetailBean extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * result : {"user_name":"liao.liao","abn":"djdjffjf","phone":"sssxxx","address":"阿塞拜疆12123awasfuture12345","date":1505896661,"for":"193","description":"House-Boxhill (Brass Homes)/193Contract price:$606000.00","amount":"2908.80","subtotal":"2908.80","is_gst":1,"other":"0.00","total":"2908.8","account_name":"vvvvv","bsb":"gggvv","account_number":"ccvfgv","invoice_id":"5","invoice_no":"Iv000005","status":1}
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

    public static class ResultBean extends Domine{
        /**
         * user_name : liao.liao
         * abn : djdjffjf
         * phone : sssxxx
         * address : 阿塞拜疆12123awasfuture12345
         * date : 1505896661
         * for : 193
         * description : House-Boxhill (Brass Homes)/193Contract price:$606000.00
         * amount : 2908.80
         * subtotal : 2908.80
         * is_gst : 1
         * other : 0.00
         * total : 2908.8
         * account_name : vvvvv
         * bsb : gggvv
         * account_number : ccvfgv
         * invoice_id : 5
         * invoice_no : Iv000005
         * status : 1
         */

        private String user_name;
        private String abn;
        private String phone;
        private String address;
        private long date;
        private String forX;
        private String description;
        private String amount;
        private String subtotal;
        private int is_gst;
        private String other;
        private String total;
        private String account_name;
        private String bsb;
        private String account_number;
        private String invoice_id;
        private String invoice_no;
        private int status;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getAbn() {
            return abn;
        }

        public void setAbn(String abn) {
            this.abn = abn;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getForX() {
            return forX;
        }

        public void setForX(String forX) {
            this.forX = forX;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public int getIs_gst() {
            return is_gst;
        }

        public void setIs_gst(int is_gst) {
            this.is_gst = is_gst;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getAccount_name() {
            return account_name;
        }

        public void setAccount_name(String account_name) {
            this.account_name = account_name;
        }

        public String getBsb() {
            return bsb;
        }

        public void setBsb(String bsb) {
            this.bsb = bsb;
        }

        public String getAccount_number() {
            return account_number;
        }

        public void setAccount_number(String account_number) {
            this.account_number = account_number;
        }

        public String getInvoice_id() {
            return invoice_id;
        }

        public void setInvoice_id(String invoice_id) {
            this.invoice_id = invoice_id;
        }

        public String getInvoice_no() {
            return invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
