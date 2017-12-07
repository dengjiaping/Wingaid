package com.yd.org.sellpopularizesystem.javaBean;

/**
 * Created by e-dot on 2017/6/22.
 */

public class PayBean extends Domine{


    /**
     * code : 1
     * msg : 获取成功
     * result : alipay_sdk=alipay-sdk-php-20161101&app_id=2017060107398874&biz_content=%7B%22body%22%3A%22wingaid-%E4%BB%98%E6%AC%BE%E7%BC%96%E5%8F%B7%EF%BC%9ATA000110%22%2C%22subject%22%3A+%22wingaid-%E4%BB%98%E6%AC%BE%E7%BC%96%E5%8F%B7%EF%BC%9ATA000110%22%2C%22out_trade_no%22%3A+%2214981227056762%22%2C%22timeout_express%22%3A+%2230m%22%2C%22total_amount%22%3A+%222000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.wingaid.com%2Findex.php%2Fapi%2Findex%2Falipay_notify&sign_type=RSA2&timestamp=2017-06-22+17%3A12%3A44&version=1.0&sign=tvCuSbsLEd2tI1RhvZjpjE3SWvq6wajeY40syBSD1P67JeJBB2U7TPs0AksK4WQ9L%2FIwi9YWdRbu%2FYc1FDdYOIfHnCxFx%2FD6TK08WAsvO%2FgdV83L2LZWr9RFdIKWQOnrVrWQjnNJL3aJAtp3xw3wH1bTFsY0ybJ1ocG6oHRpFsanBla47OBaH4igJMtpm3JSJ9hDl0goUK1c%2BxBm%2FmrnlSQcAcV4Dyt8YCIyXq76KqcGRmA8leinElBZJOEaegquG2k4CDlz%2FU03RYDRi5Z9Bpvk2kmXNj01FwICwIJjDJkFJt1g2lXxfVvETzsfPqrGJDb5NuFe5DnESMWxbjrgug%3D%3D
     */

    private String code;
    private String msg;
    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
