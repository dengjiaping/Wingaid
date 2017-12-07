package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by e-dot on 2017/6/23.
 */

public class WXpayBean extends Domine{


    /**
     * code : 1
     * msg : 获取成功
     * result : {"return_code":"SUCCESS","return_msg":"OK","appid":"wxaaa583d7b2f02dc3","mch_id":"1481724482","nonce_str":"WyzAPSHmRhMv1fpq","sign":"94FB6960CE540F87DF4010B7E4AF058B","result_code":"SUCCESS","prepay_id":"wx20170623093821445c8e7e760008414724","trade_type":"APP"}
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
         * return_code : SUCCESS
         * return_msg : OK
         * appid : wxaaa583d7b2f02dc3
         * mch_id : 1481724482
         * nonce_str : WyzAPSHmRhMv1fpq
         * sign : 94FB6960CE540F87DF4010B7E4AF058B
         * result_code : SUCCESS
         * prepay_id : wx20170623093821445c8e7e760008414724
         * trade_type : APP
         */

        private String return_code;
        private String return_msg;
        private String appid;
        private String mch_id;
        private String nonce_str;
        private String sign;
        private String result_code;
        private String prepay_id;
        private String trade_type;

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }
    }
}
