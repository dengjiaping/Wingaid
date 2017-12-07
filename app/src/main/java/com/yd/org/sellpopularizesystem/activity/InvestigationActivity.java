package com.yd.org.sellpopularizesystem.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.myView.CircleImageView;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ObjectSaveUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 开始调研页面
 */
public class InvestigationActivity extends BaseActivity {
    private Button btSubmit, btUnsure;
    private TextView tvCustomeName, edtTime;
    private EditText etContact, etAddress;
    private CircleImageView ivCustomePhoto;
    private CustomBean.ResultBean resultBean;
    private OptionsPickerView pvCustomTime;
    private List<String> weeks = new ArrayList<>();
    private List<String> hours = new ArrayList<>();
    private List<String> minutes = new ArrayList<>();
    private Calendar cal;

    @Override
    protected int setContentView() {
        return R.layout.activity_investigation;

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.inverstigation));
        hideRightImagview();
        btSubmit = getViewById(R.id.btnSubmit);
        btUnsure = getViewById(R.id.btnUnsure);
        tvCustomeName = getViewById(R.id.tvCustomeName);
        etContact = getViewById(R.id.etContact);
        etAddress = getViewById(R.id.etAddress);
        ivCustomePhoto = getViewById(R.id.ivHeadPhoto);
        edtTime = getViewById(R.id.edtTime);


        try {


            resultBean = ((CustomBean.ResultBean) ObjectSaveUtil.readObject(InvestigationActivity.this, "custome"));


            if (!TextUtils.isEmpty(resultBean.getSurname()) || !TextUtils.isEmpty(resultBean.getFirst_name())) {

                if (!TextUtils.isEmpty(resultBean.getSurname()) && !TextUtils.isEmpty(resultBean.getFirst_name())) {
                    tvCustomeName.setText(resultBean.getSurname() + " " + resultBean.getFirst_name());
                } else if (!TextUtils.isEmpty(resultBean.getSurname())) {
                    tvCustomeName.setText(resultBean.getSurname() + "");
                } else if (!TextUtils.isEmpty(resultBean.getFirst_name())) {
                    tvCustomeName.setText(resultBean.getFirst_name() + "");
                }

            }

            if (!TextUtils.isEmpty(resultBean.getMobile())) {
                etContact.setText(resultBean.getMobile() + "");
            }

            if (!TextUtils.isEmpty(resultBean.getAddress() + "")) {
                etAddress.setText(resultBean.getAddress() + "");
            }

            if (!TextUtils.isEmpty(resultBean.getHead_img())) {
                BitmapUtil.loadImageView(this, Contants.DOMAIN + "/" + resultBean.getHead_img(), ivCustomePhoto);

            } else {
                ivCustomePhoto.setImageResource(R.mipmap.settingbt);
            }
            //初始化自定义选择器的数据
            MyUtils.getInstance().getOptionData(InvestigationActivity.this, weeks, hours, minutes);
            //初始化自定义选择器
            initOptionPicker();


        } catch (NullPointerException e) {

        }
    }

    private void initOptionPicker() {
        cal = Calendar.getInstance();
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                setText(cal, options1, options2, options3);
            }
        }).setTitleText(getString(R.string.uploadetime)).setTitleColor(R.color.black)
                .setCyclic(true, true, true)/*.setOutSideCancelable(false)*/
                .setSelectOptions(weeks.indexOf("今天"), hours.indexOf(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))), minutes.indexOf(String.format("%02d", cal.get(Calendar.MINUTE))))
                .isDialog(true);

        builder.setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
            @Override
            public void customLayout(View v) {
                TextView tvFinish = (TextView) v.findViewById(R.id.tv_finish);
                TextView tvTitle = (TextView) v.findViewById(R.id.tvTitle);
                ImageView ivUp = (ImageView) v.findViewById(R.id.ivUp);
                ImageView ivDown = (ImageView) v.findViewById(R.id.ivDown);
                ivUp.setVisibility(View.GONE);
                ivDown.setVisibility(View.GONE);
                tvFinish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvCustomTime.returnData();
                    }
                });

            }
        });
        pvCustomTime = new OptionsPickerView(builder);
        View view = LayoutInflater.from(this).inflate(R.layout.pickerview_custom_time, null);
        LinearLayout llOptionPicker = (LinearLayout) view.findViewById(R.id.optionspicker);
        pvCustomTime.setNPicker(weeks, hours, minutes);
    }

    private void setText(Calendar cal, int options1, int options2, int options3) {

        try {


            String str1 = weeks.get(options1);
            String str2 = hours.get(options2);
            String str3 = minutes.get(options3);
            String[] nums = new String[2];
            if (str1.equals(getString(R.string.today))) {
                nums[0] = String.format("%02d", cal.get(Calendar.MONTH) + 1);
                nums[1] = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
            } else {
                nums = str1.split("\\D+");
            }
            edtTime.setText(cal.get(Calendar.YEAR) + "-" + String.format("%02d", Integer.parseInt(nums[0])) + "-"
                    + String.format("%02d", Integer.parseInt(nums[1])) + getString(R.string.blank_space) + str2 + ":" + str3);

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setListener() {
        btSubmit.setOnClickListener(mClickListener);
        btUnsure.setOnClickListener(mClickListener);
        edtTime.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSubmit:
                    ActivitySkip.forward(InvestigationActivity.this, InvestigateListActivity.class);
                    break;
                case R.id.btnUnsure:
                    ActivitySkip.forward(InvestigationActivity.this, HomeActivity.class);
                    break;

                case R.id.edtTime:
                    pvCustomTime.show();
                    break;
            }
        }
    };


}
