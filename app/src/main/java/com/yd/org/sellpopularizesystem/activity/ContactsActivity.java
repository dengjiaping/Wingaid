package com.yd.org.sellpopularizesystem.activity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.ContactsAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.custom.CharacterParser;
import com.yd.org.sellpopularizesystem.custom.PinyinComparator;
import com.yd.org.sellpopularizesystem.custom.SideBar;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.myView.SearchEditText;
import com.yd.org.sellpopularizesystem.utils.GetCustomerNameSort;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactsActivity extends BaseActivity implements SectionIndexer, PullToRefreshLayout
        .OnRefreshListener {

    public static ContactsActivity mContactsActivity;
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private SideBar sideBar;
    private TextView dialog;
    private TextView tvNofriends;
    private LinearLayout titleLayout;
    private SearchEditText searchEditText;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<CustomBean.ResultBean> SourceDateList = new ArrayList<>();
    private GetCustomerNameSort nameChangeUtil;
    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;
    private ContactsAdapter adapter;

    private String push_to = "1";
    private List<String> contacts = new ArrayList<>();

    //推荐人关联的客户
    private int refer_number = 0;
    private List<CustomBean.ResultBean> SourceDateAll = new ArrayList<>();


    //通讯录
    /**
     * 联系人显示名称
     **/
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;

    /**
     * 电话号码
     **/
    private static final int PHONES_NUMBER_INDEX = 1;

    /**
     * 联系人的ID
     **/
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    private static final String[] PHONES_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID};


    @Override
    protected int setContentView() {
        mContactsActivity = this;
        return R.layout.activity_contacts;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getString(R.string.contacts_title));
        SourceDateAll = (List<CustomBean.ResultBean>) getIntent().getSerializableExtra("key");
        getInfo();


        try {
            if (null != SourceDateAll && SourceDateAll.size() > 0) {
                for (int i = 0; i < SourceDateAll.size(); i++) {
                    contacts.add(SourceDateAll.get(i).getMobile());
                }

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        initViews();
        showContacts(true);

    }

    private void initViews() {

        searchEditText = getViewById(R.id.activity_main_input_edittext);
        titleLayout = getViewById(R.id.title_layout);
        tvNofriends = getViewById(R.id.noInfomation);
        // 实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        nameChangeUtil = new GetCustomerNameSort();
        pinyinComparator = new PinyinComparator();

        sideBar = getViewById(R.id.sidrbar);
        dialog = getViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);


    }


    @Override
    public Object[] getSections() {
        return null;
    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char ascii值
     */
    @Override
    public int getSectionForPosition(int position) {

        try {
            return SourceDateList.get(position).getSortLetters().charAt(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return -1;


    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    @Override
    public int getPositionForSection(int section) {

        try {
            for (int i = 0; i < SourceDateList.size(); i++) {
                String sortStr = SourceDateList.get(i).getSortLetters();
                char firstChar = sortStr.toUpperCase().charAt(0);
                if (firstChar == section) {
                    return i;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return -1;
    }

    private List<CustomBean.ResultBean> getPhoneContacts() {


        showDialog();


        List<CustomBean.ResultBean> mSortList = new ArrayList<CustomBean.ResultBean>();


        ContentResolver resolver = getContentResolver();

        // 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                PHONES_PROJECTION, null, null, null);


        try {
            if (phoneCursor != null) {
                while (phoneCursor.moveToNext()) {

                    // 得到手机号码
                    String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                    // 当手机号码为空的或者为空字段 跳过当前循环
                    if (TextUtils.isEmpty(phoneNumber))
                        continue;

                    // 得到联系人名称
                    String contactName = phoneCursor
                            .getString(PHONES_DISPLAY_NAME_INDEX);

                    // 得到联系人ID
                    Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);

                    CustomBean.ResultBean sort = new CustomBean.ResultBean();


                    if (contacts.contains(phoneNumber)) {
                        sort.setAdd(true);
                    } else {
                        sort.setAdd(false);
                    }

                    sort.setMobile(phoneNumber);
                    sort.setSurname(contactName);


                    // 汉字转换成拼音
                    String pinyin = characterParser.getSelling(contactName);
                    String sortString = pinyin.substring(0, 1).toUpperCase();
                    sort.setSortLetters(sortString);

                    // 正则表达式，判断首字母是否是英文字母
                    if (sortString.matches("[A-Z]")) {
                        sort.setSortLetters(sortString.toUpperCase());
                    } else {
                        sort.setSortLetters("#");
                    }

                    mSortList.add(sort);


                }

                phoneCursor.close();
            }
            return mSortList;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return mSortList;
    }


    private void showContacts(boolean isRefresh) {

        //先检查是否授权
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            //申请权限  第二个参数是一个 数组 说明可以同时申请多个权限
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS}, 1);
        } else {//已授权

            SourceDateList = getPhoneContacts();

        }


        closeDialog();
        if (isRefresh) {

            if (SourceDateList.size() == 0) {
                tvNofriends.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else {
                tvNofriends.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }


            // 根据a-z进行排序源数据
            Collections.sort(SourceDateList, pinyinComparator);
            adapter = new ContactsAdapter(this);
            listView.setAdapter(adapter);
        }
        adapter.addMore(SourceDateList);

    }


    @Override
    public void setListener() {
        // 设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {

                try {
                    // 该字母首次出现的位置
                    int position = adapter.getPositionForSection(s.charAt(0));
                    if (position != -1) {
                        listView.setSelection(position);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }


            }
        });


        // 根据输入框输入值的改变来过滤搜索
        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 这个时候不需要挤压效果 就把他隐藏掉
                titleLayout.setVisibility(View.GONE);
                // 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    String searchContent = searchEditText.getText().toString();
                    if (searchContent.length() > 0) {
                        ArrayList<CustomBean.ResultBean> fileterList = (ArrayList<CustomBean
                                .ResultBean>) nameChangeUtil.search_(searchContent, SourceDateList);
                        adapter.updateListView(fileterList);
                    } else {
                        adapter.updateListView(SourceDateList);
                    }
                    listView.setSelection(0);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }


            }
        });
    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        showContacts(true);


    }


    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);

    }

    public void addCustome(String surname, String mobile) {


        if (TextUtils.isEmpty(mobile)) {
            ToasShow.showToastCenter(ContactsActivity.this, getResources().getString(R.string.tel_hint));
            return;
        } else {


            //销售
            if (SharedPreferencesHelps.getType() == 1) {

                addUserInfo(surname, mobile);


                //推荐人
            } else if (SharedPreferencesHelps.getType() == 2) {

                //从第六个开始
                if (refer_number >= 5) {
                    //显示选择框
                    setIsSalers(surname, mobile);
                } else {
                    //正常添加
                    addUserInfo(surname, mobile);

                }

            }
        }
    }


    private void addUserInfo(String surname, String mobile) {

        showDialog();
        HttpParams ajaxParams = new HttpParams();
        //**************************************
        ajaxParams.put("user_id", SharedPreferencesHelps.getUserID());
        ajaxParams.put("first_name", "-");//姓氏

        if (TextUtils.isEmpty(surname)) {
            ajaxParams.put("surname", "-");//名字
        } else {

            ajaxParams.put("surname", surname);//名字
        }

        ajaxParams.put("mid_name", "");//中间名
        ajaxParams.put("en_name", "");//英文名
        ajaxParams.put("birth_date", "");//生日（时间戳格式）
        ajaxParams.put("mobile", mobile);//添加电话
        ajaxParams.put("e_mail", "");//添加邮箱
        ajaxParams.put("wechat_number", "");//添加微信
        ajaxParams.put("qq_number", "");//添加QQ
        ajaxParams.put("customer_type", "1");//是否为公司客户     1：个人客户   2：公司客户
        ajaxParams.put("company_name", "");//公司名称
        ajaxParams.put("abn", "");//ABN
        ajaxParams.put("acn", "");//ACN
        ajaxParams.put("company_mobile", "");//公司电话
        ajaxParams.put("company_e_mail", "");//公司邮箱
        ajaxParams.put("company_fax", "");//公司传真
        ajaxParams.put("client_id", "");//负责人ID
        ajaxParams.put("client", "");//负责人ID
        ajaxParams.put("select_self", "");//选择自己   1：选自己  0： 选其他人
        ajaxParams.put("company_country", "");//公司国家
        ajaxParams.put("company_unit_number", "");//公司单元号
        ajaxParams.put("company_street_number", "");//公司街道号码
        ajaxParams.put("company_suburb", "");//公司区
        ajaxParams.put("company_state", "");//公司州
        ajaxParams.put("company_street_address_line_1", "");//公司街道地址一
        ajaxParams.put("company_street_address_line_2", "");//公司街道地址二
        ajaxParams.put("company_postcode", "");//公司邮编
        ajaxParams.put("country", "");//国家
        ajaxParams.put("unit_number", "");//单元号
        ajaxParams.put("street_number", "");//街道号码
        ajaxParams.put("suburb", "");//区
        ajaxParams.put("state", "");//州
        ajaxParams.put("street_address_line_1", "");//街道地址一
        ajaxParams.put("street_address_line_2", "");//街道地址二
        ajaxParams.put("postcode", "");//邮编
        ajaxParams.put("is_firb", "");//FIRB   0：不确定  1：是   2：不是
        ajaxParams.put("job", "");//职业
        ajaxParams.put("income", "");//目前年薪
        ajaxParams.put("card_id", "");//身份证号码
        ajaxParams.put("passport_id", "");//护照号码
        ajaxParams.put("passport_country", "");//护照国别
        ajaxParams.put("family_first_name", "");//亲属姓氏
        ajaxParams.put("family_name", "");//亲属名字
        ajaxParams.put("family_relationship", "");//亲属关系
        ajaxParams.put("family_mobile", "");//亲属手机
        ajaxParams.put("family_email", "");//亲属邮箱
        ajaxParams.put("memo", "");//备注
        ajaxParams.put("push_to", push_to);//1：将客户推荐给上线销售   2：将客户推荐到后台，让管理员分配


        EasyHttp.post(Contants.NEW_CUSTOME)
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
                        Log.e("e***", "e:" + e.getMessage());

                        closeDialog();
                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e("s**", "onSuccess:" + s);
                        closeDialog();
                        JSONObject json = null;
                        try {
                            json = new JSONObject(s);
                            ToasShow.showToastCenter(ContactsActivity.this, json.getString("msg"));
                            if (json.getInt("code") == 1) {
                                CustomeActivity.customeActivity.handler.sendEmptyMessage(0);
                                finish();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    private void setIsSalers(final String surname, final String mobile) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View view = View.inflate(this, R.layout.dialog_normal_layout, null);
        // dialog.setView(view);// 将自定义的布局文件设置给dialog
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


                addUserInfo(surname, mobile);
            }
        });

        dialog.show();


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
                                ToasShow.showToastCenter(ContactsActivity.this, myUserInfo.getMsg());
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //权限申请成功
                Log.e("授权**", "授权成功*****");
                SourceDateList = getPhoneContacts();
            } else {
                Log.e("授权**", "授权失败*****");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
