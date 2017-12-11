package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by hejin on 2017/9/22.
 */

public class InvoiceDetailBean extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * result : {"user_name":"da2.da2","abn":"uu66 ","acn":"","phone":"658808994","address":"澳大利亚Jordan124578","date":1512556029,"fors":"8","description":"Land - Clydesdale Marsden Park /nkh；看Contract price:$6799900.00","amount":"101998.50","subtotal":101998.5,"gst":"0.00","is_gst":1,"other":"10000.00","total":"111998.5","account_name":"e-dot.net","bsb":"bsb","account_number":"98765543211","subtotal_other":0,"other_gst":"-","invoice_id":50,"invoice_no":"Iv000050","status":2}
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
         * user_name : da2.da2
         * abn : uu66
         * acn :
         * phone : 658808994
         * address : 澳大利亚Jordan124578
         * date : 1512556029
         * fors : 8
         * description : Land - Clydesdale Marsden Park /nkh；看Contract price:$6799900.00
         * amount : 101998.50
         * subtotal : 101998.5
         * gst : 0.00
         * is_gst : 1
         * other : 10000.00
         * total : 111998.5
         * account_name : e-dot.net
         * bsb : bsb
         * account_number : 98765543211
         * subtotal_other : 0
         * other_gst : -
         * invoice_id : 50
         * invoice_no : Iv000050
         * status : 2
         */

        private String user_name;
        private String abn;
        private String acn;
        private String phone;
        private String address;
        private int date;
        private String fors;
        private String description;
        private String amount;
        private double subtotal;
        private String gst;
        private int is_gst;
        private String other;
        private String total;
        private String account_name;
        private String bsb;
        private String account_number;
        private double subtotal_other;
        private String other_gst;
        private int invoice_id;
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

        public String getAcn() {
            return acn;
        }

        public void setAcn(String acn) {
            this.acn = acn;
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

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getFors() {
            return fors;
        }

        public void setFors(String fors) {
            this.fors = fors;
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

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
        }

        public String getGst() {
            return gst;
        }

        public void setGst(String gst) {
            this.gst = gst;
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

        public double getSubtotal_other() {
            return subtotal_other;
        }

        public void setSubtotal_other(double subtotal_other) {
            this.subtotal_other = subtotal_other;
        }

        public String getOther_gst() {
            return other_gst;
        }

        public void setOther_gst(String other_gst) {
            this.other_gst = other_gst;
        }

        public int getInvoice_id() {
            return invoice_id;
        }

        public void setInvoice_id(int invoice_id) {
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
