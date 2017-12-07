package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by e-dot on 2017/8/27.
 */

public class ReferBean extends Domine{

    /**
     * code : 1
     * msg : 获取成功
     * result : {"client_qrcode":"http://crm.vxda.cn/index.php/download/app/down_app?refer_code=000501","refer_code":"000501"}
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
         * client_qrcode : http://crm.vxda.cn/index.php/download/app/down_app?refer_code=000501
         * refer_code : 000501
         */

        private String client_qrcode;
        private String refer_code;

        public String getClient_qrcode() {
            return client_qrcode;
        }

        public void setClient_qrcode(String client_qrcode) {
            this.client_qrcode = client_qrcode;
        }

        public String getRefer_code() {
            return refer_code;
        }

        public void setRefer_code(String refer_code) {
            this.refer_code = refer_code;
        }
    }
}
