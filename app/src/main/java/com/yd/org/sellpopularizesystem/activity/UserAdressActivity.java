package com.yd.org.sellpopularizesystem.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CountrySortAdapter;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.javaBean.CountrySortModel;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.utils.CharacterParserUtil;
import com.yd.org.sellpopularizesystem.utils.CountryComparator;
import com.yd.org.sellpopularizesystem.utils.GetCountryNameSort;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class UserAdressActivity extends BaseActivity {

    private  TextView tvUserNation;
    private  EditText userUnitNumberEd;
    private  EditText userStreetNumberEd;
    private  EditText userSuburbNumberEd;
    private  EditText userStateEd;
    private  EditText userDetailedAddressEd;
    private   EditText userDetailedAddressEd2;
    private   EditText userPostcodeEd;


    private PopupWindow nationSelectPopWindow;
    private EditText etNationSearch;
    private ListView lvNation;
    private View nationPopWindowView;
    private GetCountryNameSort countryChangeUtil;
    private CountrySortAdapter adapter;
    private CharacterParserUtil characterParserUtil;
    private CountryComparator pinyinComparator;
    private List<CountrySortModel> mAllCountryList;
    //州筛选相关
    private OptionsPickerView optionsPickerView;
    private List states = new ArrayList<>();

    private MyUserInfo myUserInfo;
    private String type;
    private String strZhou;
    private boolean isChoose = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_user_adress;
    }

    @Override
    public void initView() {

        hideRightImagview();
        myUserInfo = (MyUserInfo) getIntent().getSerializableExtra("userkey");
        type = getIntent().getStringExtra("type");

        if (type.equals("1")) {
            setTitle(getResources().getString(R.string.myaddress));
        } else {
            setTitle(getResources().getString(R.string.company_add));
        }

        initStatesOptionData();
        initStatesOptionsPickerView();
        setUserAdress(myUserInfo);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveAdress();
    }

    private void setUserAdress(MyUserInfo myUserInfo) {
        tvUserNation = getViewById(R.id.tvUserNation);
        userUnitNumberEd = getViewById(R.id.userUnitNumberEd);
        userStreetNumberEd = getViewById(R.id.userStreetNumberEd);
        userSuburbNumberEd = getViewById(R.id.userSuburbNumberEd);
        userStateEd = getViewById(R.id.userStateEd);
        userDetailedAddressEd = getViewById(R.id.userDetailedAddressEd);
        userDetailedAddressEd2 = getViewById(R.id.userDetailedAddressEd2);
        userPostcodeEd = getViewById(R.id.userPostcodeEd);


        try {


            //我的地址
            if (myUserInfo != null) {

                if (type.equals("1")) {

                    //国家
                    tvUserNation.setText((null == myUserInfo.getResult().getCountry() || TextUtils.isEmpty(myUserInfo.getResult().getCountry())) ? getResources().getString(R.string.Australian) : myUserInfo.getResult().getCountry());
                    //单元号
                    userUnitNumberEd.setText((null == myUserInfo.getResult().getUnit_number() || TextUtils.isEmpty(myUserInfo.getResult().getUnit_number())) ? "" : myUserInfo.getResult().getUnit_number());
                    //街道号码
                    userStreetNumberEd.setText((null == myUserInfo.getResult().getStreet_number() || TextUtils.isEmpty(myUserInfo.getResult().getStreet_number())) ? "" : myUserInfo.getResult().getStreet_number());
                    //区
                    userSuburbNumberEd.setText((null == myUserInfo.getResult().getSuburb() || TextUtils.isEmpty(myUserInfo.getResult().getSuburb())) ? "" : myUserInfo.getResult().getSuburb());
                    //州
                    userStateEd.setText((null == myUserInfo.getResult().getState() || TextUtils.isEmpty(myUserInfo.getResult().getState())) ? "" : myUserInfo.getResult().getState());
                    //街道地址1
                    userDetailedAddressEd.setText((null == myUserInfo.getResult().getStreet_address_line_1() || TextUtils.isEmpty(myUserInfo.getResult().getStreet_address_line_1())) ? "" : myUserInfo.getResult().getStreet_address_line_1());
                    //街道地址2
                    userDetailedAddressEd2.setText((null == myUserInfo.getResult().getStreet_address_line_2() || TextUtils.isEmpty(myUserInfo.getResult().getStreet_address_line_2())) ? "" : myUserInfo.getResult().getStreet_address_line_2());
                    //邮编
                    userPostcodeEd.setText((null == myUserInfo.getResult().getPostcode() || TextUtils.isEmpty(myUserInfo.getResult().getPostcode())) ? "" : myUserInfo.getResult().getPostcode());


                    //公司地址
                } else {
                    //国家
                    tvUserNation.setText((null == myUserInfo.getResult().getCompany_country() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_country())) ? getResources().getString(R.string.Australian) : myUserInfo.getResult().getCompany_country());
                    //单元号
                    userUnitNumberEd.setText((null == myUserInfo.getResult().getCompany_unit_number() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_unit_number())) ? "" : myUserInfo.getResult().getCompany_unit_number());
                    //街道号码
                    userStreetNumberEd.setText((null == myUserInfo.getResult().getCompany_street_number() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_street_number())) ? "" : myUserInfo.getResult().getCompany_street_number());
                    //区
                    userSuburbNumberEd.setText((null == myUserInfo.getResult().getCompany_suburb() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_suburb())) ? "" : myUserInfo.getResult().getCompany_suburb());
                    //州
                    userStateEd.setText((null == myUserInfo.getResult().getCompany_state() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_state())) ? "" : myUserInfo.getResult().getCompany_state());
                    //街道地址1
                    userDetailedAddressEd.setText((null == myUserInfo.getResult().getCompany_street_address_line_1() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_street_address_line_1())) ? "" : myUserInfo.getResult().getCompany_street_address_line_1());
                    //街道地址2
                    userDetailedAddressEd2.setText((null == myUserInfo.getResult().getCompany_street_address_line_2() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_street_address_line_2())) ? "" : myUserInfo.getResult().getCompany_street_address_line_2());
                    //邮编
                    userPostcodeEd.setText((null == myUserInfo.getResult().getCompany_postcode() || TextUtils.isEmpty(myUserInfo.getResult().getCompany_postcode())) ? "" : myUserInfo.getResult().getCompany_postcode());

                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void saveAdress() {


        String country = "", unit_number = "", street_number = "", suburb = "", state = "", street_address_line_1 = "", street_address_line_2 = "", postcode = "";


        try {


            if (BaseApplication.getInstance().myUserInfo.getResult() != null) {

                //我的地址
                if (type.equals("1")) {


                    country = tvUserNation.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCountry(country);

                    //单元号
                    unit_number = userUnitNumberEd.getText().toString().trim();

                    BaseApplication.getInstance().myUserInfo.getResult().setUnit_number(unit_number);
                    //街道号
                    street_number = userStreetNumberEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setStreet_number(street_number);

                    //区
                    suburb = userSuburbNumberEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setSuburb(suburb);

                    //州
                    state = userStateEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setState(state);

                    //街道1
                    street_address_line_1 = userDetailedAddressEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setStreet_address_line_1(street_address_line_1);
                    //街道2
                    street_address_line_2 = userDetailedAddressEd2.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setStreet_address_line_2(street_address_line_2);
                    //邮编
                    postcode = userPostcodeEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setPostcode(postcode);


                } else {


                    //国际
                    country = tvUserNation.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_country(country);


                    //单元号
                    unit_number = userUnitNumberEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_unit_number(unit_number);


                    //街道号
                    street_number = userStreetNumberEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_street_number(street_number);

                    //区
                    suburb = userSuburbNumberEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_suburb(suburb);

                    //州
                    state = userStateEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_state(state);


                    //街道1
                    street_address_line_1 = userDetailedAddressEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_street_address_line_1(street_address_line_1);

                    //街道2
                    street_address_line_2 = userDetailedAddressEd2.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_street_address_line_2(street_address_line_2);


                    //邮编
                    postcode = userPostcodeEd.getText().toString().trim();
                    BaseApplication.getInstance().myUserInfo.getResult().setCompany_postcode(postcode);


                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setListener() {

        tvUserNation.setOnClickListener(mClickListener);
        userStateEd.setOnClickListener(mClickListener);
        userSuburbNumberEd.setOnClickListener(mClickListener);
    }

    private String strFlag;
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.tvUserNation:
                    getCountryOrStateList(1);
                    if (nationSelectPopWindow == null) {
                        initCountrySelectView();
                    }
                    adapter.updateListView(mAllCountryList);
                    strFlag = "1";
                    nationSelectPopWindow.showAtLocation(UserAdressActivity.this.findViewById(R.id.mainLinear), Gravity.BOTTOM, 0, 0);
                    break;
                //州
                case R.id.userStateEd:
                    MyUtils.getInstance().setKeyBoardFocusable(UserAdressActivity.this, userStateEd);
                    optionsPickerView.show();
                    break;
                //区
                case R.id.userSuburbNumberEd:
                    if (TextUtils.isEmpty(userStateEd.getText().toString())) {
                        ToasShow.showToastCenter(UserAdressActivity.this, getResources().getString(R.string.choose_zhou));
                    } else {
                        getCountryOrStateList(2);
                        if (nationSelectPopWindow == null) {
                            initCountrySelectView();
                        }
                        if (isChoose) {
                            Log.e("TAG", "onClick: " + mAllCountryList.size());
                            lvNation.setAdapter(adapter);
                            adapter.updateListView(mAllCountryList);
                            strFlag = "2";
                            nationSelectPopWindow.showAtLocation(UserAdressActivity.this.findViewById(R.id.mainLinear), Gravity.BOTTOM, 0, 0);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };

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
                    countryNumber = fileterList.get(position).countryNumber;
                } else {
                    // 点击后返回
                    countryName = mAllCountryList.get(position).countryName.trim();
                    countryNumber = mAllCountryList.get(position).countryNumber;
                }
                if (strFlag != null && strFlag.equals("1")) {
                    tvUserNation.setText(countryName);
                } else {
                    userSuburbNumberEd.setText(countryName);
                }
                nationSelectPopWindow.dismiss();
            }
        });


    }

    private void initStatesOptionData() {
        List statesList = Arrays.asList(getResources().getStringArray(R.array.states_list_au));
        states.addAll(statesList);
    }

    private void initStatesOptionsPickerView() {
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(UserAdressActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                strZhou = (String) states.get(options1);
                userStateEd.setText(strZhou);
            }
        }).setTitleColor(R.color.black)
                .isDialog(true);
        optionsPickerView = new OptionsPickerView(builder);
        optionsPickerView.setNPicker(states, null, null);
    }

    private void getCountryOrStateList(int flag) {
        mAllCountryList = new ArrayList<CountrySortModel>();
        pinyinComparator = new CountryComparator();
        countryChangeUtil = new GetCountryNameSort();
        characterParserUtil = new CharacterParserUtil();
        String[] countryList = null;
        if (flag == 1) {
            countryList = getResources().getStringArray(R.array.country_code_list_ch);
        } else if (flag == 2) {
            String strState = userStateEd.getText().toString();
            isChoose = true;
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
                ToasShow.showToastCenter(UserAdressActivity.this, getResources().getString(R.string.choose_zhou));
                return;
            }

        }
        if (mAllCountryList.size() > 0) {
            mAllCountryList.clear();
        }
        for (int i = 0, length = countryList.length; i < length; i++) {
            String[] country = countryList[i].split("\\*");
            String countryName = country[0].trim();
            //String countryNumber = country[1];
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
        }

        Collections.sort(mAllCountryList, pinyinComparator);
        if (adapter == null) {
            adapter = new CountrySortAdapter(UserAdressActivity.this, mAllCountryList);
        }
        adapter.updateListView(mAllCountryList);
    }


}
