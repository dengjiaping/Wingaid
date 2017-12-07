package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.permission.Acp;
import com.lidong.photopicker.permission.AcpListener;
import com.lidong.photopicker.permission.AcpOptions;
import com.squareup.picasso.Picasso;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CountrySortAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.custom.AddrXmlParser;
import com.yd.org.sellpopularizesystem.javaBean.CityInfoModel;
import com.yd.org.sellpopularizesystem.javaBean.CountrySortModel;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.CustomeDetailedBean;
import com.yd.org.sellpopularizesystem.javaBean.DistrictInfoModel;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.javaBean.ProvinceInfoModel;
import com.yd.org.sellpopularizesystem.myView.CircleImageView;
import com.yd.org.sellpopularizesystem.myView.MyPopupwindow;
import com.yd.org.sellpopularizesystem.myView.WheelView;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.CharacterParserUtil;
import com.yd.org.sellpopularizesystem.utils.CountryComparator;
import com.yd.org.sellpopularizesystem.utils.GetCountryNameSort;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ObjectSaveUtil;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StringUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.yd.org.sellpopularizesystem.R.id.city;


/**
 * 客户信息详情页面
 */
public class CustomDetailedActivity extends BaseActivity {
    private String customer_type = "1";//默认是公司客户
    private String TAG = CustomDetailedActivity.class.getSimpleName();
    private CircleImageView customeIcon;
    private CheckBox cbCom;
    private EditText edCustomeTrueName, etMiddleName, edcustmomeDetailedBie, edCustomeMobile,
            edcustmomeDetailedWeChat, edcustmomeDetailedQQ, etCusMemo, edcustmomeDetailedCity,
            edcustmomeDetailedAddress, edcustmomeDetailedEmail, edcustmomeDetailedWeJob,
            edcustmomeDetailedSalary, edcustmomeDetailedCard, edcustmomeDetailedPassPort,
            edcustmomeDetailedNationality, edcustmomeDetailedKinsfolk, edcustmomeDetailedRelation,
            edcustmomeDetailedPhone, edZipCode, etNationSearch, etFirb, etFistName, etEnglishName, etLn, etNation, comName, etBusaccount, etComaccount, etComTel, etComEmail, etComFax, etComRes, etUnit, etStreetNum,
            etStreet1, etStreet2, etEma, etDistrict, etZhou, etStreetNum_01, etDistrict_01, etZhou_01, etStreet1_01, etStreet2_01, etEma_01, etUnit_01, family_email_ed;
    //国家选择列表
    private ListView lvNation;
    private ImageView ivPhone, ivEmail;
    private TextView tvEoi, tvVisit, tvReserver, tvExpandRe, tvPurchase, tvCountry, tvCountry_01;
    private LinearLayout llOperate, llComContent;
    private MyPopupwindow myPopupwindow;
    private List<CountrySortModel> mAllCountryList;
    private List mCountries = new ArrayList();
    private List mStates = new ArrayList();
    private PopupWindow addrPopWindow, nationSelectPopWindow, firbSelectPopWindow;
    //州筛选相关
    private OptionsPickerView optionsPickerView;
    private CustomBean.ResultBean resultBean;
    private String tag, imagePath = "";
    private String strUrl;
    /**
     * 与选择地址相关
     */
    protected ArrayList<String> mProvinceDatas;
    protected Map<String, ArrayList<String>> mCitisDatasMap = new HashMap<>();
    protected Map<String, ArrayList<String>> mDistrictDatasMap = new HashMap<>();
    private ArrayList<String> imagePaths = new ArrayList<>();
    protected String mCurrentProviceName;
    protected String mCurrentCityName;
    protected String mCurrentDistrictName;
    private TextView boxBtnOk;
    //国家选择相关
    private GetCountryNameSort countryChangeUtil;
    private CountrySortAdapter adapter;
    private CharacterParserUtil characterParserUtil;
    private CountryComparator pinyinComparator;

    //城市选择
    private WheelView mProvincePicker;
    private WheelView mCityPicker;
    private WheelView mCountyPicker;
    private View contentView, nationPopWindowView, firbPwView;
    protected boolean isDataLoaded = false;
    public static final String UPDATE = "update_custome";
    public static final String ADD = "add_custome";
    private static final int REQUEST_CAMERA_CODE = 10;
    /**
     * 与日期选择相关
     */
    private TimePickerView pvTime;
    //firb选择相关
    private Button btUnknown, btSure, btFalse;

    private int flag;
    //推荐人关联的客户
    private int refer_number = 0;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            if (null != resultBean) {
                bundle.putString("customeId", resultBean.getCustomer_id() + "");
            }

            switch (view.getId()) {
                //日期选择
                case R.id.edcustmomeDetailedBie:
                    //隐藏键盘
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    pvTime.show();
                    break;
                //拍照
                case R.id.ivPhone:
                    if (TextUtils.isEmpty(edCustomeMobile.getText())) {
                        return;
                    } else {
                        Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + edCustomeMobile.getText().toString()));
                        if (ActivityCompat.checkSelfPermission(CustomDetailedActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(intentPhone);
                    }
                    break;
                //邮件
                case R.id.ivEmail:
                    if (TextUtils.isEmpty(edCustomeMobile.getText())) {
                        return;
                    } else {
                        Uri uri = Uri.parse("mailto:" + edcustmomeDetailedEmail.getText().toString());
                        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                        //intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.emailtopic)); // 主题
                        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.emailcontent)); // 正文
                        startActivity(Intent.createChooser(intent, getString(R.string.chooseemailapp)));
                    }

                    break;
                //城市选择
                case R.id.edcustmomeDetailedCity:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    if (isDataLoaded) {
                        Log.e(TAG, "onClick: " + edcustmomeDetailedNationality.getText());
                        if (edcustmomeDetailedNationality.getText().toString().equals(getString(R.string.china))) {
                            edcustmomeDetailedCity.setFocusable(false);
                            edcustmomeDetailedCity.setFocusableInTouchMode(false);
                            addrPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                        } else {
                            Log.e(TAG, "onClick***: " + edcustmomeDetailedNationality.getText());
                            edcustmomeDetailedCity.setFocusableInTouchMode(true);
                            edcustmomeDetailedCity.setFocusable(true);
                            edcustmomeDetailedCity.requestFocus();
                        }
                    }
                    break;
                //国家或地区选择
                case R.id.edcustmomeDetailedNationality:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    flag = 1;
                    getCountryOrStateList(1);
                    if (nationSelectPopWindow == null) {
                        initCountrySelectView();
                    }
                    strFlag = "1";
                    adapter.updateListView(mCountries);
                    nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                    break;
                //国家选择2
                case R.id.tvCountry:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    flag = 2;
                    getCountryOrStateList(1);
                    if (nationSelectPopWindow == null) {
                        initCountrySelectView();
                    }
                    strFlag = "1";
                    adapter.updateListView(mCountries);
                    nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                    break;

                //国家
                case R.id.tvCountry_01:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    flag = 4;
                    getCountryOrStateList(1);
                    if (nationSelectPopWindow == null) {
                        initCountrySelectView();
                    }
                    strFlag = "1";
                    adapter.updateListView(mCountries);
                    nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                    break;
                //州1
                case R.id.etZhou:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, etZhou);
                    etName = "zhou";
                    optionsPickerView.show();
                    break;
                //州
                case R.id.etZhou_01:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, etZhou_01);
                    etName = "zhou1";
                    optionsPickerView.show();
                    break;
                //区
                case R.id.etDistrict_01:
                    if (TextUtils.isEmpty(etZhou_01.getText().toString())) {
                        ToasShow.showToastCenter(CustomDetailedActivity.this, getResources().getString(R.string.choose_zhou));
                    } else {
                        getCountryOrStateList(2);
                        if (nationSelectPopWindow == null) {
                            initCountrySelectView();
                        }
                        if (isChoose) {
                            strFlag = "2";
                            adapter.updateListView(mStates);
                            nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                        }

                    }
                    break;
                //区1
                case R.id.etDistrict:
                    if (TextUtils.isEmpty(etZhou.getText().toString())) {
                        ToasShow.showToastCenter(CustomDetailedActivity.this, getResources().getString(R.string.choose_zhou));
                    } else {
                        getCountryOrStateList(2);
                        if (nationSelectPopWindow == null) {
                            initCountrySelectView();
                        }
                        if (isChoose) {
                            strFlag = "3";
                            adapter.updateListView(mStates);
                            nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                        }

                    }
                    break;

                //国籍选择
                case R.id.etNation:
                    MyUtils.getInstance().setKeyBoardFocusable(CustomDetailedActivity.this, edcustmomeDetailedBie);
                    flag = 3;
                    getCountryOrStateList(1);
                    if (nationSelectPopWindow == null) {
                        initCountrySelectView();
                    }
                    strFlag = "1";
                    adapter.updateListView(mCountries);
                    nationSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                    break;
                case R.id.etFirb:
                    firbSelectPopWindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed), Gravity.BOTTOM, 0, 0);
                    break;
                //EOI
                case R.id.tvEoi:
                    bundle.putString("select", "custom");
                    bundle.putString("customerID", resultBean.getCustomer_id() + "");
                    ActivitySkip.forward(CustomDetailedActivity.this, EOIActivity.class, bundle);

                    break;
                //拜访
                case R.id.tvVisit:
                    bundle.putString("custocora", "custovisit");
                    ActivitySkip.forward(CustomDetailedActivity.this, CusOprateRecordActivity.class, bundle);


                    break;
                //预约
                case R.id.tvReserve:
                    bundle.putString("custocora", "custoreser");
                    ActivitySkip.forward(CustomDetailedActivity.this, CusOprateRecordActivity.class, bundle);
                    break;
                //推广记录
                case R.id.tvExpandRe:
                    bundle.putString("custocora", "custoexpand");
                    bundle.putSerializable("customer_id", resultBean);
                    ActivitySkip.forward(CustomDetailedActivity.this, PromotionRecordActivity.class, bundle);
                    break;
                //购房记录
                case R.id.tvPurchaseRe:
                    bundle.putString("custocora", "custopurchase");
                    bundle.putSerializable("customer_id", resultBean);
                    ActivitySkip.forward(CustomDetailedActivity.this, PromotionRecordActivity.class, bundle);
                    break;

                default:
                    break;
            }
        }
    };

    private String push_to = "1";
    private List states = new ArrayList<>();
    private String strFlag;
    private String strZhou;
    private boolean isChoose = true;
    private String etName;//判断点击的是etZhou还是etZhou1

    @Override
    protected int setContentView() {
        return R.layout.activity_custom_detailed;
    }

    @Override
    public void initView() {
        Views();
        Bundle bundle = getIntent().getExtras();
        if (!TextUtils.isEmpty(bundle.getString("add"))) {
            tag = bundle.getString("add");
            //添加客户
            if (tag.equals("add")) {
                setTitle(R.string.custome_add);
                llOperate.setVisibility(View.GONE);

                if (SharedPreferencesHelps.getType() == 2) {
                    getInfo();
                }


                //完善用户信息
            } else if (tag.equals("completeinfo")) {
                setTitle(R.string.complete_user);
                getViewById(R.id.ivCon).setVisibility(View.VISIBLE);
                getViewById(R.id.ivPro).setVisibility(View.VISIBLE);
                getViewById(R.id.countryImage).setVisibility(View.VISIBLE);
                getViewById(R.id.Street1_01Imageview).setVisibility(View.VISIBLE);
                getViewById(R.id.ivZipcode).setVisibility(View.VISIBLE);
                getViewById(R.id.ivfirb).setVisibility(View.VISIBLE);
                getViewById(R.id.llOperate).setVisibility(View.GONE);
                resultBean = (CustomBean.ResultBean) bundle.getSerializable("cun");
                getCustomInfo(resultBean);

                Log.e("getCustomInfo", "getCustomInfo***1");
            } else {//更新客户
                setTitle(R.string.customdetaild_title);
                resultBean = (CustomBean.ResultBean) bundle.getSerializable("custome");
                Log.e("getCustomInfo", "getCustomInfo***2");
                getCustomInfo(resultBean);
            }
        }
        if (bundle.getString(ExtraName.SCALETOCUSTOME) != null) {
            setTitle(R.string.customdetaild_title);
            resultBean = ((CustomBean.ResultBean) ObjectSaveUtil.readObject(CustomDetailedActivity.this, "custome"));
            Log.e("getCustomInfo", "getCustomInfo***3");
            getCustomInfo(resultBean);
        }


        /*initProviceSelectView();
        setTimePicker();*/
        initProvincePickerView();
        setTimePicker();
        initStatesOptionData();
        initStatesOptionsPickerView();

    }


    private void Views() {
        etNation = getViewById(R.id.etNation);
        etLn = getViewById(R.id.etLn);
        customeIcon = getViewById(R.id.customeIcon);
        edCustomeTrueName = getViewById(R.id.edCustomeTrueName);
        etFistName = getViewById(R.id.etFistName);
        etMiddleName = getViewById(R.id.etMiddleName);
        etEnglishName = getViewById(R.id.etEnglishName);
        edcustmomeDetailedBie = getViewById(R.id.edcustmomeDetailedBie);
        edCustomeMobile = getViewById(R.id.edCustomeMobile);
        ivPhone = getViewById(R.id.ivPhone);
        edcustmomeDetailedWeChat = getViewById(R.id.edcustmomeDetailedWeChat);
        edcustmomeDetailedQQ = getViewById(R.id.edcustmomeDetailedQQ);
        etCusMemo = getViewById(R.id.etCusMemo);

        llComContent = getViewById(R.id.llComContent);
        cbCom = getViewById(R.id.cbCom);
        comName = getViewById(R.id.comName);
        etBusaccount = getViewById(R.id.etBusaccount);
        etComaccount = getViewById(R.id.etComaccount);
        etComTel = getViewById(R.id.etComTel);
        etComEmail = getViewById(R.id.etComEmail);
        etComFax = getViewById(R.id.etComFax);
        etComRes = getViewById(R.id.etComRes);
        tvCountry = getViewById(R.id.tvCountry);
        etUnit = getViewById(R.id.etUnit);
        etStreetNum = getViewById(R.id.etStreetNum);
        etStreet1 = getViewById(R.id.etStreet1);
        etStreet2 = getViewById(R.id.etStreet2);
        etEma = getViewById(R.id.etEma);
        etDistrict = getViewById(R.id.etDistrict);
        etZhou = getViewById(R.id.etZhou);
        tvCountry_01 = getViewById(R.id.tvCountry_01);

        etStreetNum_01 = getViewById(R.id.etStreetNum_01);
        etDistrict_01 = getViewById(R.id.etDistrict_01);
        etZhou_01 = getViewById(R.id.etZhou_01);
        etStreet1_01 = getViewById(R.id.etStreet1_01);
        etStreet2_01 = getViewById(R.id.etStreet2_01);
        etEma_01 = getViewById(R.id.etEma_01);
        etUnit_01 = getViewById(R.id.etUnit_01);
        family_email_ed = getViewById(R.id.family_email);

        edcustmomeDetailedCity = getViewById(R.id.edcustmomeDetailedCity);
        edcustmomeDetailedAddress = getViewById(R.id.edcustmomeDetailedAddress);
        edZipCode = getViewById(R.id.edcustmeZipCode);
        edcustmomeDetailedEmail = getViewById(R.id.edcustmomeDetailedEmail);
        ivEmail = getViewById(R.id.ivEmail);
        edcustmomeDetailedWeJob = getViewById(R.id.edcustmomeDetailedWeJob);
        edcustmomeDetailedSalary = getViewById(R.id.edcustmomeDetailedSalary);
        edcustmomeDetailedCard = getViewById(R.id.edcustmomeDetailedCard);
        edcustmomeDetailedPassPort = getViewById(R.id.edcustmomeDetailedPassPort);
        edcustmomeDetailedNationality = getViewById(R.id.edcustmomeDetailedNationality);
        edcustmomeDetailedKinsfolk = getViewById(R.id.edcustmomeDetailedKinsfolk);
        edcustmomeDetailedRelation = getViewById(R.id.edcustmomeDetailedRelation);
        edcustmomeDetailedPhone = getViewById(R.id.edcustmomeDetailedPhone);
        etFirb = getViewById(R.id.etFirb);
        llOperate = getViewById(R.id.llOperate);
        tvEoi = getViewById(R.id.tvEoi);
        tvVisit = getViewById(R.id.tvVisit);
        tvReserver = getViewById(R.id.tvReserve);
        tvExpandRe = getViewById(R.id.tvExpandRe);
        if (SharedPreferencesHelps.getType() == 2) {
            tvVisit.setVisibility(View.GONE);
            tvReserver.setVisibility(View.GONE);
            tvExpandRe.setVisibility(View.GONE);
        }
        tvPurchase = getViewById(R.id.tvPurchaseRe);
        mAllCountryList = new ArrayList<CountrySortModel>();
        pinyinComparator = new CountryComparator();
        countryChangeUtil = new GetCountryNameSort();
        characterParserUtil = new CharacterParserUtil();
        //getCountryList();

    }

    private void setTimePicker() {
        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                if (date.getTime() > (new Date()).getTime()) {
                    ToasShow.showToastCenter(CustomDetailedActivity.this, getString(R.string.select_birth));
                } else {
                    edcustmomeDetailedBie.setText(MyUtils.getTime("yyyy/MM/dd", date));
                }

            }
        });
        builder.setType(TimePickerView.Type.YEAR_MONTH_DAY);
        //时间选择器
        pvTime = new TimePickerView(builder);
    }

    private void initStatesOptionData() {
        List statesList = Arrays.asList(getResources().getStringArray(R.array.states_list_au));
        states.addAll(statesList);
    }

    private void initStatesOptionsPickerView() {
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(CustomDetailedActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                strZhou = (String) states.get(options1);
                if (etName != null && etName.equals("zhou")) {
                    etZhou.setText(strZhou);
                } else {
                    etZhou_01.setText(strZhou);
                }

            }
        }).setTitleColor(R.color.black)
                .isDialog(true);
        optionsPickerView = new OptionsPickerView(builder);
        optionsPickerView.setNPicker(states, null, null);
    }

    private void getCountryOrStateList(int flag) {

        String[] countryList = null;
        if (flag == 1) {
            countryList = getResources().getStringArray(R.array.country_code_list_ch);
        } else if (flag == 2) {
            isChoose = true;
            String strState = etZhou_01.getText().toString();
            if (strState.equals("NSW")) {
                Log.e("TAG", "NSW:" + strState);
                countryList = getResources().getStringArray(R.array.district_nsw_list_au);
            } else if (strState.equals("VIC")) {
                Log.e("TAG", "VIC:" + strState);
                countryList = getResources().getStringArray(R.array.district_vic_list_au);
            } else if (strState.equals("ACT")) {
                Log.e("TAG", "ACT:" + strState);
                countryList = getResources().getStringArray(R.array.district_act_list_au);
            } else if (strState.equals("QLD")) {
                Log.e("TAG", "QLD:" + strState);
                countryList = getResources().getStringArray(R.array.district_qld_list_au);
            } else if (strState.equals("SA")) {
                Log.e("TAG", "SA:" + strState);
                countryList = getResources().getStringArray(R.array.district_sa_list_au);
            } else if (strState.equals("NT")) {
                Log.e("TAG", "NT:" + strState);
                countryList = getResources().getStringArray(R.array.district_nt_list_au);
            } else if (strState.equals("TAS")) {
                Log.e("TAG", "TAS:" + strState);
                countryList = getResources().getStringArray(R.array.district_tas_list_au);
            } else if (strState.equals("WA")) {
                Log.e("TAG", "WA:" + strState);
                countryList = getResources().getStringArray(R.array.district_wa_list_au);
            } else {
                isChoose = false;
                ToasShow.showToastCenter(CustomDetailedActivity.this, getResources().getString(R.string.choose_zhou));
                return;
            }

        }
        mAllCountryList.clear();
        for (int i = 0, length = countryList.length; i < length; i++) {

            try {
                String[] country = countryList[i].split("\\*");

                String countryName = country[0].trim();

                String countrySortKey = characterParserUtil.getSelling(countryName);
                if (flag == 2) {
                    String countryNumber = country[1];
                    CountrySortModel countrySortModel = new CountrySortModel(countryName, countryNumber,
                            countrySortKey);
                    String sortLetter = countryChangeUtil.getSortLetterBySortKey(countrySortKey);
                    if (sortLetter == null) {
                        sortLetter = countryChangeUtil.getSortLetterBySortKey(countryName);
                    }
                    countrySortModel.sortLetters = sortLetter;
                    mAllCountryList.add(countrySortModel);
                } else {
                    CountrySortModel countrySortModel = new CountrySortModel(countryName,
                            countrySortKey);
                    String sortLetter = countryChangeUtil.getSortLetterBySortKey(countrySortKey);
                    if (sortLetter == null) {
                        sortLetter = countryChangeUtil.getSortLetterBySortKey(countryName);
                    }

                    countrySortModel.sortLetters = sortLetter;
                    mAllCountryList.add(countrySortModel);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }


        }

        Collections.sort(mAllCountryList, pinyinComparator);
        if (flag == 1) {
            if (mCountries.size() == 0) {
                mCountries.addAll(mAllCountryList);
            }

        } else if (flag == 2) {
            mStates.clear();
            mStates.addAll(mAllCountryList);
        }
        if (adapter == null) {
            adapter = new CountrySortAdapter(CustomDetailedActivity.this, mAllCountryList);
        }
    }


    /**
     * 设置客户信息
     *
     * @param customeDetailedBean
     */
    private void setInfo(CustomeDetailedBean customeDetailedBean) {

        try {


            //*******************
            //设置头像
            if (!TextUtils.isEmpty(customeDetailedBean.getResult().getHead_img())) {
                Picasso.with(this).load(Contants.DOMAIN + "/" + customeDetailedBean.getResult().getHead_img()).
                        config(Bitmap.Config.RGB_565).fit().into(customeIcon);
            }


            //姓
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getSurname())) {
                edCustomeTrueName.setText("");
            } else {
                edCustomeTrueName.setText(customeDetailedBean.getResult().getSurname());

            }

            //名
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getFirst_name())) {
                etFistName.setText("");
            } else {
                etFistName.setText(customeDetailedBean.getResult().getFirst_name());
            }

            //中间名
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getMid_name())) {
                etMiddleName.setText("");
            } else {
                etMiddleName.setText(customeDetailedBean.getResult().getMid_name());
            }

            //英文名
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getEn_name())) {
                etEnglishName.setText("");
            } else {
                etEnglishName.setText(customeDetailedBean.getResult().getEn_name());
            }

            //生日
            if (customeDetailedBean.getResult().getBirth_date() != null) {
                if (TextUtils.isEmpty(customeDetailedBean.getResult().getBirth_date() + "")
                        || String.valueOf(customeDetailedBean.getResult().getBirth_date()).equals("")) {
                    edcustmomeDetailedBie.setText("");
                } else {
                    if (customeDetailedBean.getResult().getBirth_date().contains("\\-")) {
                        String[] str = customeDetailedBean.getResult().getBirth_date().split("\\-");
                        String dateStr = str[0] + "/" + str[1] + "/" + str[2];
                        Log.i(TAG, "setInfo: " + dateStr);
                        edcustmomeDetailedBie.setText(dateStr);
                    } else {
                        edcustmomeDetailedBie.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(customeDetailedBean.getResult().getBirth_date() + "000")));
                    }
                }
            }
            //电话
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getMobile())) {
                edCustomeMobile.setText("");
            } else {
                edCustomeMobile.setText(customeDetailedBean.getResult().getMobile());
            }

            //邮箱
            if (TextUtils.isEmpty((String) customeDetailedBean.getResult().getE_mail())) {
                edcustmomeDetailedEmail.setText("");
            } else {
                edcustmomeDetailedEmail.setText((String) customeDetailedBean.getResult().getE_mail());
            }

            //微信号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getWechat_number())) {
                edcustmomeDetailedWeChat.setText("");
            } else {
                edcustmomeDetailedWeChat.setText(customeDetailedBean.getResult().getWechat_number());
            }

            //QQ号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getQq_number())) {
                edcustmomeDetailedQQ.setText("");
            } else {
                edcustmomeDetailedQQ.setText(customeDetailedBean.getResult().getQq_number());
            }

            if (TextUtils.isEmpty(customeDetailedBean.getResult().getMemo())) {
                etCusMemo.setText("");
            } else {
                etCusMemo.setText(customeDetailedBean.getResult().getMemo());
            }

            //个人客户
            if (customeDetailedBean.getResult().getCustomer_type() == 1) {
                cbCom.setChecked(false);
                llComContent.setVisibility(View.GONE);
                customer_type = "1";
            } else {
                //公司客户
                cbCom.setChecked(true);
                llComContent.setVisibility(View.VISIBLE);
                customer_type = "2";
            }


            //公司名称
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_name())) {
                comName.setText("");
            } else {
                comName.setText(customeDetailedBean.getResult().getCompany_name());
            }
            //ANB
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getAbn())) {
                etBusaccount.setText("");
            } else {
                etBusaccount.setText(customeDetailedBean.getResult().getAbn());
            }
            //ACn
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getAcn())) {
                etComaccount.setText("");
            } else {
                etComaccount.setText(customeDetailedBean.getResult().getAcn());
            }
            //公司电话
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_mobile())) {
                etComTel.setText("");
            } else {
                etComTel.setText(customeDetailedBean.getResult().getCompany_mobile());
            }
            //公司邮箱
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_e_mail())) {
                etComEmail.setText("");
            } else {
                etComEmail.setText(customeDetailedBean.getResult().getCompany_e_mail());
            }
            //公司传真
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_fax())) {
                etComFax.setText("");
            } else {
                etComFax.setText(customeDetailedBean.getResult().getCompany_fax());
            }
            //负责人
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getClient())) {
                etComRes.setText("");
            } else {
                etComRes.setText(customeDetailedBean.getResult().getClient());
            }
            //公司国家
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_country())) {
                tvCountry.setText(getResources().getString(R.string.Australian));
            } else {
                tvCountry.setText(customeDetailedBean.getResult().getCompany_country());
            }
            //公司单元号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_unit_number())) {
                etUnit.setText("");
            } else {
                etUnit.setText(customeDetailedBean.getResult().getCompany_unit_number());
            }
            //公司街道号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_street_number())) {
                etStreetNum.setText("");
            } else {
                etStreetNum.setText(customeDetailedBean.getResult().getCompany_street_number());
            }
            //公司区
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_suburb())) {
                etDistrict.setText("");
            } else {
                etDistrict.setText(customeDetailedBean.getResult().getCompany_suburb());
            }
            //公司州
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_state())) {
                etZhou.setText("");
            } else {
                etZhou.setText(customeDetailedBean.getResult().getCompany_state());
            }
            //街道1
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_street_address_line_1())) {
                etStreet1.setText("");
            } else {
                etStreet1.setText(customeDetailedBean.getResult().getCompany_street_address_line_1());
            }
            //街道2
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_street_address_line_2())) {
                etStreet2.setText("");
            } else {
                etStreet2.setText(customeDetailedBean.getResult().getCompany_street_address_line_2());
            }


            //公司邮编
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCompany_postcode())) {
                etEma.setText("");
            } else {
                etEma.setText(customeDetailedBean.getResult().getCompany_postcode());
            }


            //-------------联系方式-----------------


            //国家
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCountry())) {
                tvCountry_01.setText(getString(R.string.Australian));
            } else {
                tvCountry_01.setText(customeDetailedBean.getResult().getCountry());
            }
            //单元号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getUnit_number())) {
                etUnit_01.setText("");
            } else {
                etUnit_01.setText(customeDetailedBean.getResult().getUnit_number());
            }
            //街道号
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getStreet_number())) {
                etStreetNum_01.setText("");
            } else {
                etStreetNum_01.setText(customeDetailedBean.getResult().getStreet_number());
            }
            //区
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getSuburb())) {
                etDistrict_01.setText("");
            } else {
                etDistrict_01.setText(customeDetailedBean.getResult().getSuburb());
            }
            //州
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getState())) {
                etZhou_01.setText("");
            } else {
                etZhou_01.setText(customeDetailedBean.getResult().getState());
            }
            //街道1
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getStreet_address_line_1())) {
                etStreet1_01.setText("");
            } else {
                etStreet1_01.setText(customeDetailedBean.getResult().getStreet_address_line_1());
            }
            //街道2
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getStreet_address_line_2())) {
                etStreet2_01.setText("");
            } else {
                etStreet2_01.setText(customeDetailedBean.getResult().getStreet_address_line_2());
            }


            //邮编
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getPostcode())) {
                etEma_01.setText("");
            } else {
                etEma_01.setText(customeDetailedBean.getResult().getPostcode());
            }


            //        //是否是FIRB 0未知 1是  2否
            if (customeDetailedBean.getResult().getIs_firb() == 1) {
                etFirb.setText(R.string.sur);
            } else if (customeDetailedBean.getResult().getIs_firb() == 2) {
                etFirb.setText(R.string.isno);
            } else {
                etFirb.setText(R.string.unknown_);
            }

            //职业
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getJob())) {
                edcustmomeDetailedWeJob.setText("");
            } else {
                edcustmomeDetailedWeJob.setText(customeDetailedBean.getResult().getJob());
            }

            //年薪
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getIncome() + "") || customeDetailedBean.getResult().getIncome() == 0) {
                edcustmomeDetailedSalary.setText("");
            } else {
                edcustmomeDetailedSalary.setText(customeDetailedBean.getResult().getIncome() + "");
            }

            //省份证
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getCard_id())) {
                edcustmomeDetailedCard.setText("");
            } else {
                edcustmomeDetailedCard.setText(customeDetailedBean.getResult().getCard_id());
            }

            //护照
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getPassport_id())) {
                edcustmomeDetailedPassPort.setText("");
            } else {
                edcustmomeDetailedPassPort.setText(customeDetailedBean.getResult().getPassport_id());
            }

            //国籍
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getPassport_country())) {
                etNation.setText("");
            } else {
                etNation.setText(customeDetailedBean.getResult().getPassport_country());
            }

            //亲属姓

            if (TextUtils.isEmpty((String) customeDetailedBean.getResult().getFamily_name())) {
                edcustmomeDetailedKinsfolk.setText("");
            } else {
                edcustmomeDetailedKinsfolk.setText((String) customeDetailedBean.getResult().getFamily_name());
            }
            //亲属名
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getFamily_first_name())) {
                etLn.setText("");
            } else {
                etLn.setText(customeDetailedBean.getResult().getFamily_first_name());
            }

            //关系
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getFamily_relationship())) {
                edcustmomeDetailedRelation.setText("");
            } else {
                edcustmomeDetailedRelation.setText(customeDetailedBean.getResult().getFamily_relationship());
            }

            //亲属手机号码
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getFamily_mobile())) {
                edcustmomeDetailedPhone.setText("");
            } else {
                edcustmomeDetailedPhone.setText(customeDetailedBean.getResult().getFamily_mobile());
            }

            //亲属邮编
            if (TextUtils.isEmpty(customeDetailedBean.getResult().getFamily_email())) {
                family_email_ed.setText("");
            } else {
                family_email_ed.setText(customeDetailedBean.getResult().getFamily_email());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void initCountrySelectView() {

        //国家选择popWindow视图
        nationPopWindowView = LayoutInflater.from(this).inflate(R.layout.nation_picker, null);
        etNationSearch = (EditText) nationPopWindowView.findViewById(R.id.etNationSearch);
        lvNation = (ListView) nationPopWindowView.findViewById(R.id.lvNation);

        lvNation.setAdapter(adapter);
        nationSelectPopWindow = new PopupWindow(nationPopWindowView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        nationSelectPopWindow.setHeight(MyUtils.getInstance().getScreenSize(this) * 2 / 3);
        nationSelectPopWindow.setOutsideTouchable(true);
        nationSelectPopWindow.setTouchable(true);
        nationSelectPopWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        //设置SelectPicPopu  pWindow弹出窗体动画效果
        nationSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable cd = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        nationSelectPopWindow.setBackgroundDrawable(cd);

        etNationSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchContent = etNationSearch.getText().toString();
                if (searchContent.length() > 0) {
                    // 按照输入内容进行匹配
                    ArrayList<CountrySortModel> fileterList = (ArrayList<CountrySortModel>) countryChangeUtil
                            .search(searchContent, mAllCountryList);
                    Log.e("TAG", "afterTextChanged: " + fileterList.size());
                    adapter.updateListView(fileterList);
                } else {
                    adapter.updateListView(mAllCountryList);
                }
                lvNation.setSelection(0);
            }
        });


        lvNation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String countryName = null;
                String countryNumber = null;
                String etSearchContent = etNationSearch.getText().toString();
                if (etSearchContent.length() > 0) {
                    // 按照输入内容进行匹配
                    ArrayList<CountrySortModel> fileterList = (ArrayList<CountrySortModel>) countryChangeUtil
                            .search(etSearchContent, mAllCountryList);
                    countryName = fileterList.get(position).countryName;
                } else {
                    // 点击后返回
                    countryName = mAllCountryList.get(position).countryName.trim();
                }
                if (flag == 1) {
                    edcustmomeDetailedNationality.setText(countryName);
                    if (!countryName.equals(getResources().getString(R.string.china)) && !TextUtils.isEmpty(edcustmomeDetailedCity.getText().toString().trim())) {
                        edcustmomeDetailedCity.setText("");
                    }
                } else if (flag == 2) {
                    tvCountry.setText(countryName);
                } else if (flag == 3) {
                    etNation.setText(countryName);
                } else if (flag == 4) {
                    tvCountry_01.setText(countryName);
                }
                if (strFlag != null && strFlag.equals("2")) {
                    etDistrict_01.setText(countryName);
                }
                if (strFlag != null && strFlag.equals("3")) {
                    etDistrict.setText(countryName);
                }
                nationSelectPopWindow.dismiss();
            }
        });

    }

    private void initProvincePickerView() {
        //省市县选择视图
        contentView = LayoutInflater.from(this).inflate(
                R.layout.addr_picker, null);
        mProvincePicker = (WheelView) contentView.findViewById(R.id.province);
        mCityPicker = (WheelView) contentView.findViewById(city);
        mCountyPicker = (WheelView) contentView.findViewById(R.id.county);
        boxBtnOk = (TextView) contentView.findViewById(R.id.box_btn_ok);

        addrPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        addrPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        addrPopWindow.setBackgroundDrawable(dw);
        mProvincePicker.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                String provinceText = mProvinceDatas.get(id);
                if (!mCurrentProviceName.equals(provinceText)) {
                    mCurrentProviceName = provinceText;
                    ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProviceName);
                    mCityPicker.resetData(mCityData);
                    mCityPicker.setDefault(0);
                    mCurrentCityName = mCityData.get(0);

                    ArrayList<String> mDistrictData = mDistrictDatasMap.get(mCurrentCityName);
                    mCountyPicker.resetData(mDistrictData);
                    mCountyPicker.setDefault(0);
                    mCurrentDistrictName = mDistrictData.get(0);
                }
            }

            @Override
            public void selecting(int id, String text) {
            }
        });

        mCityPicker.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProviceName);
                String cityText = mCityData.get(id);
                if (!mCurrentCityName.equals(cityText)) {
                    mCurrentCityName = cityText;
                    ArrayList<String> mCountyData = mDistrictDatasMap.get(mCurrentCityName);
                    mCountyPicker.resetData(mCountyData);
                    mCountyPicker.setDefault(0);
                    mCurrentDistrictName = mCountyData.get(0);
                }
            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        mCountyPicker.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                ArrayList<String> mDistrictData = mDistrictDatasMap.get(mCurrentCityName);
                String districtText = mDistrictData.get(id);
                if (!mCurrentDistrictName.equals(districtText)) {
                    mCurrentDistrictName = districtText;
                }
            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        boxBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = mCurrentProviceName + getString(R.string.single_blank_space) + mCurrentCityName;
                if (!mCurrentDistrictName.equals(getString(R.string.other))) {
                    addr += getString(R.string.single_blank_space) + mCurrentDistrictName;
                }
                edcustmomeDetailedCity.setText(addr);
                addrPopWindow.dismiss();
            }
        });

        // 启动线程读取数据
        new Thread() {
            @Override
            public void run() {
                // 读取数据
                isDataLoaded = readAddrDatas();

                // 通知界面线程
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mProvincePicker.setData(mProvinceDatas);
                        mProvincePicker.setDefault(0);
                        mCurrentProviceName = mProvinceDatas.get(0);

                        ArrayList<String> mCityData = mCitisDatasMap.get(mCurrentProviceName);
                        mCityPicker.setData(mCityData);
                        mCityPicker.setDefault(0);
                        mCurrentCityName = mCityData.get(0);

                        ArrayList<String> mDistrictData = mDistrictDatasMap.get(mCurrentCityName);
                        mCountyPicker.setData(mDistrictData);
                        mCountyPicker.setDefault(0);
                        mCurrentDistrictName = mDistrictData.get(0);
                    }
                });
            }
        }.start();

        //FIRB选择视图
        firbPwView = LayoutInflater.from(this).inflate(R.layout.firb_popuwindow, null);
        RelativeLayout rlFirb = (RelativeLayout) firbPwView.findViewById(R.id.rlFirb);
        btUnknown = (Button) firbPwView.findViewById(R.id.btUnknown);
        btSure = (Button) firbPwView.findViewById(R.id.btSure);
        btFalse = (Button) firbPwView.findViewById(R.id.btFalse);
        firbSelectPopWindow = new PopupWindow(firbPwView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        firbSelectPopWindow.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable firb = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        firbSelectPopWindow.setBackgroundDrawable(firb);
        rlFirb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firbSelectPopWindow.dismiss();
            }
        });
        btUnknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirb.setText(getString(R.string.unknown_));
                firbSelectPopWindow.dismiss();
            }
        });

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirb.setText(getString(R.string.yes));
                firbSelectPopWindow.dismiss();
            }
        });

        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirb.setText(getString(R.string.no));
                firbSelectPopWindow.dismiss();
            }
        });
    }

    @Override
    public void setListener() {
        edcustmomeDetailedCity.setOnClickListener(onClickListener);
        edcustmomeDetailedBie.setOnClickListener(onClickListener);
        ivPhone.setOnClickListener(onClickListener);
        ivEmail.setOnClickListener(onClickListener);
        tvCountry.setOnClickListener(onClickListener);
        etZhou.setOnClickListener(onClickListener);
        etDistrict.setOnClickListener(onClickListener);
        etZhou_01.setOnClickListener(onClickListener);
        etDistrict_01.setOnClickListener(onClickListener);
        tvCountry_01.setOnClickListener(onClickListener);
        edcustmomeDetailedNationality.setOnClickListener(onClickListener);
        etNation.setOnClickListener(onClickListener);
        etFirb.setOnClickListener(onClickListener);
        //llOperate.setOnClickListener(onClickListener);
        tvEoi.setOnClickListener(onClickListener);
        tvVisit.setOnClickListener(onClickListener);
        tvReserver.setOnClickListener(onClickListener);
        tvExpandRe.setOnClickListener(onClickListener);
        tvPurchase.setOnClickListener(onClickListener);
        cbCom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //是公司客户
                    llComContent.setVisibility(View.VISIBLE);
                    customer_type = "2";
                } else {
                    //个人客户
                    llComContent.setVisibility(View.GONE);
                    customer_type = "1";
                }
            }
        });
        //添加数据
        if (tag.equals("add")) {
            setRightTitle(R.string.customdetaild_add, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //销售
                    if (SharedPreferencesHelps.getType() == 1) {
                        getEditTextData(ADD);


                        //推荐人
                    } else if (SharedPreferencesHelps.getType() == 2) {

                        //从第六个开始
                        if (refer_number >= 5) {
                            //显示选择框
                            setIsSalers();
                        } else {
                            //正常添加
                            getEditTextData(ADD);
                        }


                    }


                }
            });

            //更新数据
        } else {
            setRightTitle(R.string.customdetaild_save, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getEditTextData(UPDATE);

                }
            });
        }

        customeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myPopupwindow == null) {
                    myPopupwindow = new MyPopupwindow(CustomDetailedActivity.this, itemsOnClick);
                }
                myPopupwindow.showAtLocation(CustomDetailedActivity.this.findViewById(R.id.activity_custom_detailed),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

            }
        });


    }

    //获取销售人员信息
    private void getInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());

        EasyHttp.get(Contants.USER_INFO)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .cacheKey(this.getClass().getSimpleName())
                .params(httpParams)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError***", "onError:" + e.getMessage());

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("onSuccess***", "onSuccess:" + s);
                        closeDialog();


                        try {

                            Gson gson = new Gson();
                            MyUserInfo myUserInfo = gson.fromJson(s, MyUserInfo.class);
                            if (myUserInfo.getCode().equals("1")) {
                                refer_number = myUserInfo.getResult().getRefer_number();
                                Log.e("refer**", "refer_number:" + refer_number);
                            } else {
                                ToasShow.showToastCenter(CustomDetailedActivity.this, myUserInfo.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });
    }


    private void updateOrAddUserInfo(final String updateOrAdd, String mid_name, String surname, String first_name, String en_name,
                                     String birth_date, String mobile, String country, String city, String area,
                                     String e_mail, String job, String income, String card_id, String passport_id,
                                     String passport_country, String family_name, String family_first_name, String family_relationship, String family_mobile,
                                     String zip_code, String is_firb, String wechat_number, String qq_number,
                                     String company_name, String abn, String acn, String company_mobile, String company_e_mail, String company_fax, String client_id, final String client, String select_self, String company_country, String company_unit_number, String company_street_number, String company_suburb, String company_state, String company_street_address_line_1,
                                     String company_street_address_line_2, String company_postcode, String unit_number, String street_number, String suburb, String state, String street_address_line_1, String street_address_line_2, String family_email, String mome) throws FileNotFoundException {
        showDialog();
        UIProgressResponseCallBack mUIProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {


            }
        };


        //更新
        if (updateOrAdd.equals(ADD)) {
            strUrl = Contants.NEW_CUSTOME;
        } else {
            strUrl = Contants.UPDATE_CUSTOME;
        }


        HttpParams ajaxParams = new HttpParams();


        //如果只添加用户,需要userID
        if (updateOrAdd.equals(ADD)) {

        } else {
            ajaxParams.put("customer_id", String.valueOf(resultBean.getCustomer_id()));
        }


        //**************************************

        if (!imagePath.equals("")) {
            ajaxParams.put("file", new File(imagePath), mUIProgressResponseCallBack);//客户头像
        }


        // ajaxParams.put("type_id", SharedPreferencesHelps.getType()+"");//1:销售  2推荐人
        ajaxParams.put("user_id", SharedPreferencesHelps.getUserID());
        ajaxParams.put("first_name", first_name);//姓氏
        ajaxParams.put("surname", surname);//名字
        ajaxParams.put("mid_name", mid_name);//中间名
        ajaxParams.put("en_name", en_name);//英文名
        ajaxParams.put("birth_date", birth_date);//生日（时间戳格式）
        ajaxParams.put("mobile", mobile);//添加电话
        ajaxParams.put("e_mail", e_mail);//添加邮箱
        ajaxParams.put("wechat_number", wechat_number);//添加微信
        ajaxParams.put("qq_number", qq_number);//添加QQ
        ajaxParams.put("customer_type", customer_type);//是否为公司客户     1：个人客户   2：公司客户
        ajaxParams.put("company_name", company_name);//公司名称
        ajaxParams.put("abn", abn);//ABN
        ajaxParams.put("acn", acn);//ACN
        ajaxParams.put("company_mobile", company_mobile);//公司电话
        ajaxParams.put("company_e_mail", company_e_mail);//公司邮箱
        ajaxParams.put("company_fax", company_fax);//公司传真
        ajaxParams.put("client_id", client_id);//负责人ID
        ajaxParams.put("client", client);//负责人ID
        ajaxParams.put("select_self", select_self);//选择自己   1：选自己  0： 选其他人
        ajaxParams.put("company_country", company_country);//公司国家
        ajaxParams.put("company_unit_number", company_unit_number);//公司单元号
        ajaxParams.put("company_street_number", company_street_number);//公司街道号码
        ajaxParams.put("company_suburb", company_suburb);//公司区
        ajaxParams.put("company_state", company_state);//公司州
        ajaxParams.put("company_street_address_line_1", company_street_address_line_1);//公司街道地址一
        ajaxParams.put("company_street_address_line_2", company_street_address_line_2);//公司街道地址二
        ajaxParams.put("company_postcode", company_postcode);//公司邮编
        ajaxParams.put("country", country);//国家
        ajaxParams.put("unit_number", unit_number);//单元号
        ajaxParams.put("street_number", street_number);//街道号码
        ajaxParams.put("suburb", suburb);//区
        ajaxParams.put("state", state);//州
        ajaxParams.put("street_address_line_1", street_address_line_1);//街道地址一
        ajaxParams.put("street_address_line_2", street_address_line_2);//街道地址二
        ajaxParams.put("postcode", zip_code);//邮编
        ajaxParams.put("is_firb", is_firb);//FIRB   0：不确定  1：是   2：不是
        ajaxParams.put("job", job);//职业
        ajaxParams.put("income", income);//目前年薪
        ajaxParams.put("card_id", card_id);//身份证号码
        ajaxParams.put("passport_id", passport_id);//护照号码
        ajaxParams.put("passport_country", passport_country);//护照国别
        ajaxParams.put("family_first_name", family_first_name);//亲属姓氏
        ajaxParams.put("family_name", family_name);//亲属名字
        ajaxParams.put("family_relationship", family_relationship);//亲属关系
        ajaxParams.put("family_mobile", family_mobile);//亲属手机
        ajaxParams.put("family_email", family_email);//亲属邮箱
        ajaxParams.put("memo", mome);//备注


        if (updateOrAdd.equals(ADD)) {
            ajaxParams.put("push_to", push_to);//1：将客户推荐给上线销售   2：将客户推荐到后台，让管理员分配

        }


        EasyHttp.post(strUrl)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params(ajaxParams)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("onSuccess**", "onSuccess:" + s);
                        closeDialog();
                        JSONObject json = null;
                        try {
                            json = new JSONObject(s);
                            ToasShow.showToastCenter(CustomDetailedActivity.this, json.getString("msg"));
                            if (updateOrAdd.equals(ADD)) {//新增

                                if (json.getInt("code") == 1) {
                                    CustomeActivity.customeActivity.handler.sendEmptyMessage(0);
                                }
                            } else {//更新
                                ToasShow.showToastCenter(CustomDetailedActivity.this, json.getString("msg"));
                                if (json.getInt("code") == 1) {
                                    if (tag.equals("completeinfo")) {
                                        //重新赋值
                                        setCustomerValue(((CustomBean.ResultBean) ObjectSaveUtil.readObject(CustomDetailedActivity.this, "custome")));
                                        ReserveActivity.reserveActivity.handler.sendEmptyMessage(0);
                                    } else {
                                        CustomeActivity.customeActivity.handler.sendEmptyMessage(0);
                                    }
                                }
                            }

                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    private void setIsSalers() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View view = View.inflate(this, R.layout.dialog_normal_layout, null);
        dialog.setView(view, 0, 0, 0, 0);// 设置边距为0,保证在2.x的版本上运行没问题


        //公司
        final RadioButton radio_01 = (RadioButton) view.findViewById(R.id.radio_01);
        //线上
        final RadioButton radio_02 = (RadioButton) view.findViewById(R.id.radio_02);

        //取消
        Button positiveButton = (Button) view.findViewById(R.id.positiveButton);
        //提交
        Button negativeButton = (Button) view.findViewById(R.id.negativeButton);


        RadioGroup radioId = (RadioGroup) view.findViewById(R.id.radioId);


        radioId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.radio_01:
                        radio_01.setChecked(true);
                        radio_02.setChecked(false);
                        break;

                    case R.id.radio_02:
                        radio_01.setChecked(false);
                        radio_02.setChecked(true);
                        break;
                    default:
                }
            }
        });


        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (radio_01.isChecked()) {
                    push_to = "2";

                } else if (radio_02.isChecked()) {
                    push_to = "1";

                }

                Log.e("push_to**", "push_to:" + push_to);


                if (tag.equals("add")) {
                    getEditTextData(ADD);
                } else {
                    getEditTextData(UPDATE);
                }

            }
        });

        dialog.show();


    }

    private void setCustomerValue(CustomBean.ResultBean resultBean) {


        try {
            resultBean.setFirst_name(etFistName.getText().toString().trim());
            resultBean.setSurname(edCustomeTrueName.getText().toString().trim());
            resultBean.setMobile(edCustomeMobile.getText().toString().trim());
            resultBean.setE_mail(edcustmomeDetailedEmail.getText().toString().trim());
            resultBean.setCountry(tvCountry_01.getText().toString().trim());
            resultBean.setStreet_address_line_1(etStreet1_01.getText().toString().trim());
            resultBean.setPostcode(etEma_01.getText().toString().trim());
            ObjectSaveUtil.saveObject(CustomDetailedActivity.this, "custome", resultBean);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void getEditTextData(String updateOrAdd) {
        String surname = "", mid_name = "", first_name = "", en_name = "", birth_date = "", mobile = "", country = "", city = "", area = "", e_mail = "", job = "", income = "", card_id = "", passport_id = "",
                passport_country = "", family_name = "", family_first_name = "", family_relationship = "", family_mobile = "",
                zip_code = "", is_firb = "", wechat_number = "", qq_number = "", company_name = "", abn = "", acn = "", company_mobile = "", company_e_mail = "", company_fax = "", client_id = "", client = "", select_self = "", company_country = "", company_unit_number = "", company_street_number = "", company_suburb = "", company_state = "", company_street_address_line_1 = "",
                company_street_address_line_2 = "", company_postcode = "", unit_number = "", street_number = "", suburb = "", state = "", street_address_line_1 = "", street_address_line_2 = "", family_email = "", momeString = "";


        try {


            //姓
            if (!TextUtils.isEmpty(edCustomeTrueName.getText().toString().trim())) {
                surname = edCustomeTrueName.getText().toString().trim();
                if (!MyUtils.isContainChinese(surname)) {
                    ToasShow.showToastCenter(this, getString(R.string.firstname_ensure));
                    return;
                }
            } else {
                ToasShow.showToastCenter(this, getString(R.string.fistnamenonull));
                return;
            }

            //名
            if (!TextUtils.isEmpty(etMiddleName.getText().toString().trim())) {
                mid_name = etMiddleName.getText().toString().trim();
            } else {
                mid_name = "";
            }

            //名
            if (!TextUtils.isEmpty(etFistName.getText().toString().trim())) {
                first_name = etFistName.getText().toString().trim();

                if (!MyUtils.isContainChinese(first_name)) {
                    ToasShow.showToastCenter(this, getString(R.string.firstname_ensure));
                    return;
                }
            } else {
                ToasShow.showToastCenter(this, getString(R.string.lastnamenonull));
                return;
            }


            //英文名称
            if (!TextUtils.isEmpty(etEnglishName.getText().toString().trim())) {
                en_name = etEnglishName.getText().toString().trim();
            } else {
                en_name = "";
            }

            //生日
            if (!TextUtils.isEmpty(edcustmomeDetailedBie.getText().toString().trim())) {
                if (TextUtils.isDigitsOnly(edcustmomeDetailedBie.getText().toString().trim())) {
                    birth_date = "0";
                } else {
                    String bir = String.valueOf(MyUtils.getInstance().string2Date("yyyy/MM/dd", edcustmomeDetailedBie.getText().toString()));
                    birth_date = bir.substring(0, bir.length() - 3);
                    Log.e("birth_date**", "birth_date:" + birth_date);
                }

            }

            //电话,//邮件
            if (TextUtils.isEmpty(edCustomeMobile.getText().toString().trim()) && TextUtils.isEmpty(edcustmomeDetailedEmail.getText().toString().trim())) {
                ToasShow.showToastCenter(this, getString(R.string.teleonenonull));
                return;
            } else {

                if (!TextUtils.isEmpty(edCustomeMobile.getText().toString().trim())) {
                    mobile = edCustomeMobile.getText().toString().trim();
                }

                if (!TextUtils.isEmpty(edcustmomeDetailedEmail.getText().toString().trim())) {
                    if (StringUtils.isEmail(edcustmomeDetailedEmail.getText().toString().trim())) {
                        e_mail = edcustmomeDetailedEmail.getText().toString().trim();
                    } else {
                        ToasShow.showToastCenter(this, getString(R.string.email_hint));
                        return;
                    }

                }

            }


            //国籍或地区
            if (!TextUtils.isEmpty(tvCountry_01.getText().toString().trim())) {
                country = tvCountry_01.getText().toString().trim();
            } else {
                country = getString(R.string.Australian);
                ;
            }


            //工作
            if (!TextUtils.isEmpty(edcustmomeDetailedWeJob.getText().toString().trim())) {
                job = edcustmomeDetailedWeJob.getText().toString().trim();
            }

            //收入
            if (!TextUtils.isEmpty(edcustmomeDetailedSalary.getText().toString().trim())) {
                income = edcustmomeDetailedSalary.getText().toString().trim();
            }

            //证件号
            if (!TextUtils.isEmpty(edcustmomeDetailedCard.getText().toString().trim())) {
                card_id = edcustmomeDetailedCard.getText().toString().trim();
            }

            //护照
            if (!TextUtils.isEmpty(edcustmomeDetailedPassPort.getText().toString().trim())) {
                passport_id = edcustmomeDetailedPassPort.getText().toString().trim();
            }

            //国籍
            if (!TextUtils.isEmpty(etNation.getText().toString().trim())) {
                passport_country = etNation.getText().toString().trim();
            }


            //亲属姓
            if (!TextUtils.isEmpty(edcustmomeDetailedKinsfolk.getText().toString().trim())) {
                family_name = edcustmomeDetailedKinsfolk.getText().toString().trim();
            }

            //名
            if (!TextUtils.isEmpty(etLn.getText().toString().trim())) {
                family_first_name = etLn.getText().toString().trim();
            }

            //关系
            if (!TextUtils.isEmpty(edcustmomeDetailedRelation.getText().toString().trim())) {
                family_relationship = edcustmomeDetailedRelation.getText().toString().trim();
            }

            //电话
            if (!TextUtils.isEmpty(edcustmomeDetailedPhone.getText().toString().trim())) {
                family_mobile = edcustmomeDetailedPhone.getText().toString().trim();
            }

            //邮编
            if (!TextUtils.isEmpty(etEma_01.getText().toString().trim())) {
                //zip_code = edZipCode.getText().toString().trim();
                zip_code = etEma_01.getText().toString().trim();
            } else {
                ToasShow.showToastCenter(this, getString(R.string.nonullpostcode));
                return;
            }


            //是否是FIRB
            if (!TextUtils.isEmpty(etFirb.getText().toString().trim())) {

                if (etFirb.getText().toString().trim().equals(getString(R.string.yes))) {
                    is_firb = "1";
                } else if (etFirb.getText().toString().trim().equals(getString(R.string.no))) {
                    is_firb = "2";
                } else {
                    is_firb = "0";
                }
            } else {
                ToasShow.showToastCenter(this, getString(R.string.firb_not_empty));
                return;
            }

            //微信
            if (!TextUtils.isEmpty(edcustmomeDetailedWeChat.getText().toString())) {
                wechat_number = edcustmomeDetailedWeChat.getText().toString();
            }
            //qq
            if (!TextUtils.isEmpty(edcustmomeDetailedQQ.getText().toString())) {
                qq_number = edcustmomeDetailedQQ.getText().toString();
            }

            family_email = family_email_ed.getText().toString().trim();

            //公司名称,如果为公司客户,公司名称为必填项

            if (customer_type == "2") {
                if (!TextUtils.isEmpty(comName.getText().toString())) {
                    company_name = comName.getText().toString().trim();
                } else {
                    ToasShow.showToastCenter(this, getString(R.string.com_noe));
                    return;
                }

            } else {
                company_name = comName.getText().toString().trim();
            }

            abn = etBusaccount.getText().toString().trim();//ABN
            acn = etComaccount.getText().toString().trim();//ACN
            company_mobile = etComTel.getText().toString().trim();//公司电话
            company_e_mail = etComEmail.getText().toString().trim();//公司邮箱
            company_fax = etComFax.getText().toString().trim();//公司传真


            //etComRes

            if (customer_type == "2") {
                if (!TextUtils.isEmpty(etComRes.getText().toString())) {
                    client = etComRes.getText().toString().trim();//负责人名字（string)
                } else {
                    ToasShow.showToastCenter(this, getString(R.string.comres));
                    return;
                }

            } else {
                client = etComRes.getText().toString().trim();//负责人名字（string)
            }
            client_id = SharedPreferencesHelps.getUserID();//负责人ID
            select_self = "1";//选择自己   1：选自己  0： 选其他人


            company_country = tvCountry.getText().toString().trim();//公司国家
            company_unit_number = etUnit.getText().toString().trim();//公司单元号
            company_street_number = etStreetNum.getText().toString().trim();//公司街道号码
            company_suburb = etDistrict.getText().toString().trim();//公司区
            company_state = etZhou.getText().toString().trim();//公司州


            company_street_address_line_1 = etStreet1.getText().toString().trim();//公司街道地址一
            company_street_address_line_2 = etStreet2.getText().toString().trim();//公司街道地址二
            company_postcode = etEma.getText().toString().trim();//公司邮编
            unit_number = etUnit_01.getText().toString().trim();//单元号
            street_number = etStreetNum_01.getText().toString().trim();//街道号码
            suburb = etDistrict_01.getText().toString().trim();//区

            state = etZhou_01.getText().toString().trim();//州
            street_address_line_1 = etStreet1_01.getText().toString().trim();//街道地址一
            street_address_line_2 = etStreet2_01.getText().toString().trim();//街道地址二
            momeString = etCusMemo.getText().toString().trim();


            updateOrAddUserInfo(updateOrAdd, mid_name, surname, first_name, en_name,
                    birth_date, mobile, country, city, area,
                    e_mail, job, income, card_id, passport_id,
                    passport_country, family_name, family_first_name, family_relationship, family_mobile,
                    zip_code, is_firb, wechat_number, qq_number, company_name, abn, acn, company_mobile, company_e_mail, company_fax, client_id, client, select_self, company_country, company_unit_number, company_street_number, company_suburb, company_state, company_street_address_line_1,
                    company_street_address_line_2, company_postcode, unit_number, street_number, suburb, state, street_address_line_1, street_address_line_2, family_email, momeString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();

        }


    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.photoButton:
                    myPopupwindow.dismiss();

                    Acp.getInstance(CustomDetailedActivity.this).request(new AcpOptions.Builder()
                                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                            , Manifest.permission.READ_EXTERNAL_STORAGE
                                    ).build(),
                            new AcpListener() {
                                @Override
                                public void onGranted() {
                                    PhotoPickerIntent intent = new PhotoPickerIntent(CustomDetailedActivity.this);
                                    intent.setSelectModel(SelectModel.SINGLE);
                                    intent.setShowCarema(true); // 是否显示拍照
                                    // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                                    startActivityForResult(intent, REQUEST_CAMERA_CODE);


                                }

                                @Override
                                public void onDenied(List<String> permissions) {
                                    ToasShow.showToastCenter(CustomDetailedActivity.this, permissions.toString() + "权限拒绝");
                                }
                            });


                    break;

                case R.id.cancelButton:
                    myPopupwindow.dismiss();
                    break;
                default:
            }
        }

    };


    private void getCustomInfo(CustomBean.ResultBean resultBean) {

        EasyHttp.get(Contants.CUSTOME_DETAILED)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("customer_id", resultBean.getCustomer_id() + "")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();


                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("CustomDetailedActivity", "json:" + json);
                        closeDialog();

                        try {
                            Gson gson = new Gson();
                            CustomeDetailedBean customeDetailedBean = gson.fromJson(json, CustomeDetailedBean.class);
                            if (customeDetailedBean.getCode().equals("1")) {
                                setInfo(customeDetailedBean);
                            }

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });

    }

    /**
     * 拍照上传
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    loadAdpater(list);
                    break;
                default:
            }

        }

    }

    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        imagePath = imagePaths.get(0);

        Picasso.with(CustomDetailedActivity.this).load("file://" + imagePath).fit().into(customeIcon);
    }

    /**
     * 读取地址数据，请使用线程进行调用
     *
     * @return
     */
    protected boolean readAddrDatas() {
        List<ProvinceInfoModel> provinceList = null;
        AssetManager asset = getAssets();
        try {
            InputStream input = asset.open("province_data.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            AddrXmlParser handler = new AddrXmlParser();
            parser.parse(input, handler);
            input.close();
            provinceList = handler.getDataList();
            if (provinceList != null && !provinceList.isEmpty()) {
                mCurrentProviceName = provinceList.get(0).getName();
                List<CityInfoModel> cityList = provinceList.get(0).getCityList();
                if (cityList != null && !cityList.isEmpty()) {
                    mCurrentCityName = cityList.get(0).getName();
                    List<DistrictInfoModel> districtList = cityList.get(0).getDistrictList();
                    mCurrentDistrictName = districtList.get(0).getName();
                }
            }
            mProvinceDatas = new ArrayList<String>();
            for (int i = 0; i < provinceList.size(); i++) {
                mProvinceDatas.add(provinceList.get(i).getName());
                List<CityInfoModel> cityList = provinceList.get(i).getCityList();
                ArrayList<String> cityNames = new ArrayList<String>();
                for (int j = 0; j < cityList.size(); j++) {
                    cityNames.add(cityList.get(j).getName());
                    List<DistrictInfoModel> districtList = cityList.get(j).getDistrictList();
                    ArrayList<String> distrinctNameArray = new ArrayList<String>();
                    DistrictInfoModel[] distrinctArray = new DistrictInfoModel[districtList.size()];
                    for (int k = 0; k < districtList.size(); k++) {
                        DistrictInfoModel districtModel = new DistrictInfoModel(districtList.get(k).getName(), districtList.get(k).getZipcode());
                        distrinctArray[k] = districtModel;
                        distrinctNameArray.add(districtModel.getName());
                    }
                    mDistrictDatasMap.put(cityNames.get(j), distrinctNameArray);
                }
                mCitisDatasMap.put(provinceList.get(i).getName(), cityNames);
            }
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }

}
