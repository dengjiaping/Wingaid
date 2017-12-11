package com.yd.org.sellpopularizesystem.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;


/**
 * 银行卡信息
 */
public class BankActivity extends BaseActivity {
    private EditText accountNameEd;
    private EditText accountNumberEd;
    private EditText bankNameEd;
    private EditText bsbEd;
    private MyUserInfo myUserInfo;

    @Override
    protected int setContentView() {
        return R.layout.activity_bank;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getString(R.string.bank_info));

        myUserInfo = (MyUserInfo) getIntent().getSerializableExtra("userkey");

        accountNameEd = getViewById(R.id.accountNameEd);
        accountNumberEd = getViewById(R.id.accountNumberEd);
        bankNameEd = getViewById(R.id.bankNameEd);
        bsbEd = getViewById(R.id.bsbEd);

        try {
            //持卡人
            accountNameEd.setText((null == myUserInfo.getResult().getAccount_name() || TextUtils.isEmpty(myUserInfo.getResult().getAccount_name())) ? "" : myUserInfo.getResult().getAccount_name());
            //卡号
            accountNumberEd.setText((null == myUserInfo.getResult().getAccount_number() || TextUtils.isEmpty(myUserInfo.getResult().getAccount_number())) ? "" : myUserInfo.getResult().getAccount_number());
            //开户行
            bankNameEd.setText((null == myUserInfo.getResult().getBank_name() || TextUtils.isEmpty(myUserInfo.getResult().getBank_name())) ? "" : myUserInfo.getResult().getBank_name());
            //bsb
            bsbEd.setText((null == myUserInfo.getResult().getBsb() || TextUtils.isEmpty(myUserInfo.getResult().getBsb())) ? "" : myUserInfo.getResult().getBsb());

        } catch (NullPointerException e) {
            e.printStackTrace();

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        saveAdress();
    }

    @Override
    public void setListener() {

    }


    private void saveAdress() {

        try {
            String account_name = "", account_number = "", bank_name, bsb = "";


            if (BaseApplication.getInstance().myUserInfo.getResult() != null) {
                //持卡人
                account_name = accountNameEd.getText().toString().trim();
                BaseApplication.getInstance().myUserInfo.getResult().setAccount_name(account_name);
                //卡号
                account_number = accountNumberEd.getText().toString().trim();
                BaseApplication.getInstance().myUserInfo.getResult().setAccount_number(account_number);

                //开户行
                bank_name = bankNameEd.getText().toString().trim();
                BaseApplication.getInstance().myUserInfo.getResult().setBank_name(bank_name);

                //bsb
                bsb = bsbEd.getText().toString().trim();
                BaseApplication.getInstance().myUserInfo.getResult().setBsb(bsb);

            }
        } catch (NullPointerException e) {
            e.printStackTrace();

        }


    }


}
