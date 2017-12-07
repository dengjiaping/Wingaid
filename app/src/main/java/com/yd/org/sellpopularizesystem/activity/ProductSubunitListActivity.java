package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
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
import com.yd.org.sellpopularizesystem.adapter.CommonAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.application.ViewHolder;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.EOIPayBean;
import com.yd.org.sellpopularizesystem.javaBean.EoilistBean;
import com.yd.org.sellpopularizesystem.javaBean.ImageContent;
import com.yd.org.sellpopularizesystem.javaBean.ProSubunitListBean;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.myView.CommonPopuWindow;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ObjectSaveUtil;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.body.UIProgressResponseCallBack;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductSubunitListActivity extends BaseActivity {
    private Button btViewDetail, btRemain, btLineup, btCancel;
    private int pos;
    private RelativeLayout rlPop;
    private TextView tvPrice, tvNoInfo, tvIntroduce, tvVideo, tvFloor, tvContract, tvFile;
    private ListView lvHouseDetail;
    private ImageView ivSearch;
    private View mView;
    private List<ProSubunitListBean.ResultBean.PropertyBean> data = new ArrayList<>();
    private CommonAdapter adapter;
    //private Object bean;
    //private ProductListBean.ResultBean.ChildsBean childBean;
    private CustomePopuWindow mCustomePopuWindow;
    private String bedRoomNum;
    private String bathRoomNum = "";
    private String carSpace = "";
    // private String product_id;
    private String string = "";
    private String page = "1";
    //从产品中点击预订跳转标志
    // private String flag = "";
    private ProductDetailBean.ResultBean prs;
    private Bundle bund = new Bundle();
    //筛选
    private OptionsPickerView optionsPickerView;
    private List houseTypes = new ArrayList<>();
    private List numbers = new ArrayList<>();
    private String strHouseType;
    private String strNum;
    private List<ImageContent> imgContents = new ArrayList<ImageContent>();
    private List<EoilistBean.ResultBean> eoiList = new ArrayList<>();
    private boolean isSequence = false;

    //EOI充值

    private Dialog eoiPayDialog;
    private TextView tvMoneyNum, tvPayMethod, tvEoiSubmit;
    private ImageView ivCertificate, ivCash, ivIdCard, ivAlipay, ivWechatPay;
    private LinearLayout llCertificate;
    private String payment_method;
    private String picPath = "";
    private ArrayList<String> imagePaths = new ArrayList<>();
    private static final int REQUEST_CAMERA_CODE = 10;

    private ProductListBean.ResultBean mResultBean;

    @Override
    protected int setContentView() {
        return R.layout.activity_view_more;

    }

    @Override
    public void initView() {

        mResultBean = (ProductListBean.ResultBean) getIntent().getSerializableExtra("key");
        setTitle(mResultBean.getProduct_name() + "");
        getViews();
        getListData();
//        product_id = (String) bundle.get("productId");
//        flag = (String) bundle.get("pidatopsla");

        //       prs = (ProductDetailBean.ResultBean) bundle.getSerializable("prs");
//        if (flag != null && flag.equals("maptopsla")) {
//            string = (String) bundle.get("title");
//            setTitle(string);
//            getListData();
//
//
//        }
//        if (prs == null) {
//            //获取产品详情
//            getItemProductDetail();
//        } else {
//            controlColor();
//        }
        //  if (flag != null && flag.equals("pidatopsla")) {
        //    string = (String) bundle.get("title");

        //}
//        if (bean != null) {
//            if (bean instanceof List) {//点击查看所有传递过来的集合对象
//                String proName = bundle.getString("productName");
//                setTitle(proName);
//                getListData();
//            } else {//点击单个item传递过来的对象
//                childBean = (ProductListBean.ResultBean.ChildsBean) bean;
//                bedRoomNum = childBean.getBedroom();
//                product_id = (String) bundle.get("productId");
//                string = bundle.getString("productName");
//                setTitle(string);
//                getListData();
//            }
//        }
    }

    private void getViews() {
        setRightTitle(R.string.select, mOnClickListener);
        ivSearch = getViewById(R.id.rightSearchLinearLayout);
        ivSearch.setVisibility(View.GONE);
        tvPrice = getViewById(R.id.tvPrice);
        tvPrice.setOnClickListener(mOnClickListener);
        lvHouseDetail = getViewById(R.id.lvHouseDetail);
        tvIntroduce = getViewById(R.id.tvIntroduce);
        tvIntroduce.setOnClickListener(mOnClickListener);
        tvNoInfo = getViewById(R.id.tvNoInfo);
        tvVideo = getViewById(R.id.tvVideo);
        tvFloor = getViewById(R.id.tvFloor);
        tvFloor.setOnClickListener(mOnClickListener);
        tvContract = getViewById(R.id.tvContract);
        tvContract.setOnClickListener(mOnClickListener);
        tvFile = getViewById(R.id.tvFile);
        tvFile.setOnClickListener(mOnClickListener);

        mCustomePopuWindow = new CustomePopuWindow(ProductSubunitListActivity.this);
        mView = mCustomePopuWindow.getContentView();
        rlPop = (RelativeLayout) mView.findViewById(R.id.rlPop);
        rlPop.setOnClickListener(mOnClickListener);
        btViewDetail = (Button) mView.findViewById(R.id.btViewDetail);
        btRemain = (Button) mView.findViewById(R.id.btRemain);
        btLineup = (Button) mView.findViewById(R.id.btLineup);
        btCancel = (Button) mView.findViewById(R.id.btCancel);
        initOptionData();
        initOptionsPickerView();

    }

    private void initOptionData() {
        //筛选卧室,浴室,车库
        houseTypes.add(getString(R.string.bedroom));
        houseTypes.add(getString(R.string.bathroom));
        houseTypes.add(getString(R.string.carport));
        numbers.add(getString(R.string.nolimit));
        //筛选数据
        for (int i = 1; i < 10; i++) {
            numbers.add(String.valueOf(i));
            if (i != 9) {
                numbers.add(String.valueOf(i + 0.5));
            }
        }
    }

    private void initOptionsPickerView() {
        OptionsPickerView.Builder builder = new OptionsPickerView.Builder(this, new
                OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        strHouseType = (String) houseTypes.get(options1);
                        strNum = numbers.get(options2).equals(getString(R.string.nolimit)) ? "" :
                                (String) numbers.get(options2);
                        if (strHouseType.equals(getString(R.string.bedroom))) {
                            bedRoomNum = strNum;
                            bathRoomNum = "";
                            carSpace = "";
                        } else if (houseTypes.get(options1).equals(getString(R.string.bathroom))) {
                            bedRoomNum = "";
                            bathRoomNum = strNum;
                            carSpace = "";
                        } else if (houseTypes.get(options1).equals(getString(R.string.carport))) {
                            carSpace = strNum;
                            bedRoomNum = "";
                            bathRoomNum = "";
                        }
                        List<ProSubunitListBean.ResultBean.PropertyBean> filterList = findAllByPro(data,
                                strHouseType, strNum);
                        if (filterList.size() > 0) {
                            adapter.setmDatas(filterList);
                            adapter.notifyDataSetChanged();
                        } else {
                            ToasShow.showToastCenter(ProductSubunitListActivity.this, getString(R.string
                                    .nomatchdata));
                        }
                    }
                }).setTitleColor(R.color.black).setCyclic(false, false, true).setSelectOptions(houseTypes
                .indexOf(getString(R.string.bedroom)), numbers.indexOf(getString(R.string
                .nolimit)));
        optionsPickerView = new OptionsPickerView(builder);
        optionsPickerView.setNPicker(houseTypes, numbers, null);
    }


    private List<ProSubunitListBean.ResultBean.PropertyBean> findAllByPro(List<ProSubunitListBean
            .ResultBean.PropertyBean> data, String strHouseType, String strNum) {
        List<ProSubunitListBean.ResultBean.PropertyBean> filterList = new ArrayList<>();
        if (strNum.equals("")) {
            filterList.clear();
            filterList.addAll(data);
        } else {
            for (int i = 0; i < data.size(); i++) {
                if (strHouseType.equals(getString(R.string.bedroom))) {
                    if (data.get(i).getBedroom().equals(strNum)) {
                        filterList.add(data.get(i));
                    }
                }
                if (strHouseType.equals(getString(R.string.bathroom))) {
                    if (data.get(i).getBathroom().equals(strNum)) {
                        filterList.add(data.get(i));
                    }
                }
                if (strHouseType.equals(getString(R.string.carport))) {
                    if (data.get(i).getCar_space().equals(strNum)) {
                        filterList.add(data.get(i));
                    }
                }
            }
        }
        return filterList;
    }

    //获取子单元列表数据
    private void getListData() {
        EasyHttp.get(Contants.PRODUCT_SUBUNIT_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true).params("user_id",
                SharedPreferencesHelps.getUserID())
                .params("product_id", mResultBean.getProduct_id() + "")
                .params("provice", "")
                .params("city", "")
                .params("town", "")
                .params("address", "")
                .params("bedroom", bedRoomNum == null ? "" : bedRoomNum)
                .params("bathroom", bathRoomNum)
                .params("car_space", carSpace)
                .params("has_study", "")
                .params("ensuite", "")
                .params("level", "")
                .params("price", "0~100000000")
                .params("internal", "0~100000000")
                .params("external", "0~100000000")
                .params("building_area", "0~100000000")
                .params("is_lock", "")
                .params("page", String.valueOf(page))
                .params("number", "1000").execute(new SimpleCallBack<String>() {
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

                Log.e("json***", "json:" + json);

                closeDialog();
                if (json != null) {
                    parseJson(json);
                }

            }
        });


    }

    private void parseJson(String s) {

        try {

            Gson gson = new Gson();
            ProSubunitListBean pslb = gson.fromJson(s, ProSubunitListBean.class);
            if (pslb.getCode().equals("1")) {
                data = pslb.getResult().getProperty();
            }

            //按照价格排序
            sortPriceLowToHigh(data);
            //找出eoi元素
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getIf_eoi() == 1) {
                    ProSubunitListBean.ResultBean.PropertyBean p = data.get(i);
                    data.remove(i);
                    //把eoi元素放在第一位
                    data.add(0, p);
                }
            }

            if (data.size() > 0) {
                tvNoInfo.setVisibility(View.GONE);
                setAdapter();
            } else {
                tvNoInfo.setVisibility(View.VISIBLE);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private void sortPriceLowToHigh(List<ProSubunitListBean.ResultBean.PropertyBean> data) {
        Collections.sort(data, new Comparator<ProSubunitListBean.ResultBean.PropertyBean>() {
            @Override
            public int compare(ProSubunitListBean.ResultBean.PropertyBean o1, ProSubunitListBean
                    .ResultBean.PropertyBean o2) {

                try {
                    if (Integer.parseInt(o1.getPrice().split("\\.")[0]) > Integer.parseInt
                            (o2.getPrice().split("\\.")[0])) {
                        return 1;
                    }

                    if (Integer.parseInt(o1.getPrice().split("\\.")[0]) == Integer.parseInt
                            (o2.getPrice().split("\\.")[0])) {
                        return 0;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }


                return -1;
            }
        });
    }

    private void setAdapter() {
        adapter = new CommonAdapter<ProSubunitListBean.ResultBean.PropertyBean>(this, data, R
                .layout.productdetaill_activity_listview_item) {
            @Override
            public void convert(ViewHolder holder, final ProSubunitListBean.ResultBean
                    .PropertyBean item) {

                try {

                    //没有预订时颜色
                    if (item.getIs_lock() == 0) {

                        if (SharedPreferencesHelps.getProjectStatus().equals("old")) {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.redhome);
                        } else {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.greenhome);
                        }


                    } else if (item.getIs_lock() == 1) {
                        //预定过的颜色
                        holder.setImageResource(R.id.ivHouse, R.mipmap.redhome);
                        //为eoi时的颜色
                    } else {


                        if (SharedPreferencesHelps.getProjectStatus().equals("old")) {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.redhome);
                        } else {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.yellowhome);
                        }


                    }
                    if (item.getIf_eoi() == 1) {

                        if (SharedPreferencesHelps.getProjectStatus().equals("old")) {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.redhome);
                        } else {
                            holder.setImageResource(R.id.ivHouse, R.mipmap.eoi);
                        }
                    }


                    //房型图
                    if (!item.getThumb().equals("")) {
                        holder.getView(R.id.tvNoPhoto).setVisibility(View.GONE);
                        holder.getView(R.id.ivHousePic).setVisibility(View.VISIBLE);

                        if (item.getThumb().endsWith(".pdf") || item.getThumb().endsWith(".PDF")) {
                            holder.getView(R.id.ivHousePic).setOnClickListener(new View
                                    .OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageContent imageContent = new ImageContent();
                                    imageContent.setUrl(item.getThumb());
                                    imgContents.clear();
                                    imgContents.add(imageContent);
                                    bund.putString("introduce", item.getThumb() + "");
                                    bund.putString("type", "1");
                                    ActivitySkip.forward(ProductSubunitListActivity.this,
                                            IntroduceActivity.class, bund);

                                }
                            });
                        } else {

                            holder.getView(R.id.ivHousePic).setOnClickListener(new View
                                    .OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageContent imageContent = new ImageContent();
                                    imageContent.setUrl(item.getThumb());
                                    imgContents.clear();
                                    imgContents.add(imageContent);
                                    bund.putSerializable("img_content", (Serializable) imgContents);
                                    ActivitySkip.forward(ProductSubunitListActivity.this,
                                            ImageShowActivity.class, bund);
                                }
                            });
                        }


                    } else {
                        holder.getView(R.id.tvNoPhoto).setVisibility(View.VISIBLE);
                        holder.getView(R.id.ivHousePic).setVisibility(View.GONE);
                    }
                    holder.setText(R.id.tvDetailLoc, item.getProduct_childs_unit_number());
                    holder.setText(R.id.tvBedRoom, item.getBedroom());
                    holder.setText(R.id.tvBathroom, item.getBathroom());
                    holder.setText(R.id.tvCarSquare, item.getCar_space());
                    if (item.getCate_id() == 2) {
                        holder.setText(R.id.tvHouseSquare, item.getLand_size());
                    } else {
                        holder.setText(R.id.tvHouseSquare, MyUtils.addComma(item.getBuilding_area().split("\\.")[0]));
                    }

                    holder.setText(R.id.tvDetailPrice, "$" + getString(R.string.single_blank_space) +
                            MyUtils.addComma(item.getPrice().split("\\.")[0]));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }


            }
        };
        lvHouseDetail.setAdapter(adapter);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //筛选
                case R.id.rightTitle:
                    optionsPickerView.show();
                    break;
                //价格排序
                case R.id.tvPrice:
                    if (!isSequence) {
                        Drawable drawable = ContextCompat.getDrawable(ProductSubunitListActivity
                                .this, R.mipmap.trangle_down);
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                                .getMinimumHeight());
                        tvPrice.setCompoundDrawables(null, null, drawable, null);
                        sortPriceHighToLow();
                        isSequence = true;
                    } else {
                        Drawable drawable = ContextCompat.getDrawable(ProductSubunitListActivity
                                .this, R.mipmap.trangle_up);
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                                .getMinimumHeight());
                        tvPrice.setCompoundDrawables(null, null, drawable, null);
                        List<ProSubunitListBean.ResultBean.PropertyBean> lists = adapter
                                .getmDatas();
                        sortPriceLowToHigh(lists);
                        adapter.notifyDataSetChanged();
                        isSequence = false;
                    }

                    break;

                case R.id.rlPop:
                    if (mCustomePopuWindow != null) {
                        mCustomePopuWindow.dismiss();
                    }
                    break;
                //查看详情
                case R.id.btViewDetail:
                    if (bund != null) {
                        bund.putSerializable("item", data.get(pos));
                        ActivitySkip.forward(ProductSubunitListActivity.this,
                                ProductSubItemDetailActivity.class, bund);
                        mCustomePopuWindow.dismiss();
                    }
                    break;
                //预定
                case R.id.btRemain:
                    if (bund != null) {
                        bund.putSerializable("item", data.get(pos));
                        ActivitySkip.forward(ProductSubunitListActivity.this, ReserveActivity
                                .class, bund);
                        mCustomePopuWindow.dismiss();
                    }
                    break;
                case R.id.btCancel:
                    if (mCustomePopuWindow != null) {
                        mCustomePopuWindow.dismiss();
                    }
                    break;
                //排队
                case R.id.btLineup:
                    if (mCustomePopuWindow != null) {
                        mCustomePopuWindow.dismiss();
                    }

                    showEoiPay();
                    break;

                //eoi充值
                case R.id.ivCash:
                    if (llCertificate.getVisibility() == View.GONE) {
                        llCertificate.setVisibility(View.VISIBLE);
                    }
                    tvMoneyNum.setText("$ 300.00");
                    tvPayMethod.setText(getString(R.string.recash));
                    payment_method = "1";
                    break;
                case R.id.ivIdCard:
                    if (llCertificate.getVisibility() == View.GONE) {
                        llCertificate.setVisibility(View.VISIBLE);
                    }
                    tvMoneyNum.setText("$ 300.00");
                    tvPayMethod.setText(getString(R.string.transfer));
                    payment_method = "4";
                    break;
                case R.id.ivAlipay:
                    if (llCertificate.getVisibility() == View.VISIBLE) {
                        llCertificate.setVisibility(View.GONE);
                    }
                    tvPayMethod.setText(R.string.alipay);
                    tvMoneyNum.setText("￥ 2000.00");
                    payment_method = "6";
                    break;
                case R.id.ivWeixinPay:
                    if (llCertificate.getVisibility() == View.VISIBLE) {
                        llCertificate.setVisibility(View.GONE);
                    }
                    tvPayMethod.setText(R.string.wechatpay);
                    tvMoneyNum.setText("￥ 2000.00");
                    payment_method = "7";
                    break;
                case R.id.ivCertificate:
                    Acp.getInstance(ProductSubunitListActivity.this).request(new AcpOptions
                            .Builder().setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE).build(), new AcpListener() {
                        @Override
                        public void onGranted() {

                            PhotoPickerIntent intent = new PhotoPickerIntent
                                    (ProductSubunitListActivity.this);
                            intent.setSelectModel(SelectModel.SINGLE);
                            intent.setShowCarema(true); // 是否显示拍照
                            // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                        }

                        @Override
                        public void onDenied(List<String> permissions) {
                            ToasShow.showToastCenter(ProductSubunitListActivity.this, permissions
                                    .toString() + "权限拒绝");
                        }
                    });
                    break;
                //提交eoi
                case R.id.tvEoiSubmit:

                    if (llCertificate.getVisibility() == View.VISIBLE) {
                        if (picPath == "") {
                            ToasShow.showToastCenter(ProductSubunitListActivity.this, getString(R
                                    .string.picpath));
                        }
                    }
                    if (tvMoneyNum.getText().equals("-")) {
                        ToasShow.showToastCenter(ProductSubunitListActivity.this, getString(R
                                .string.pay_method));
                    } else {
                        //提交eoi
                        submitEoi();
                    }
                    break;
                //视频
                case R.id.tvVideo:
                    if (bund != null) {
                        if (tvVideo.getAlpha() == 1.0f) {
                            bund.putSerializable("prs", prs);
                            ActivitySkip.forward(ProductSubunitListActivity.this, VideoActivity
                                    .class, bund);
                        }
                    }
                    break;
                //介绍
                case R.id.tvIntroduce:

                    if (tvIntroduce.getAlpha() == 1.0f) {
                        bund.putString("type", "0");
                        bund.putString("introduce", prs.getDescription_url() + "");
                        ActivitySkip.forward(ProductSubunitListActivity.this, IntroduceActivity
                                .class, bund);
                    }
                    break;
                //平面图
                case R.id.tvFloor:
                    if (tvFloor.getAlpha() == 1.0f) {
                        bund.putSerializable("floorListData", (Serializable) prs.getFile_content());
                        ActivitySkip.forward(ProductSubunitListActivity.this,
                                BuildingPlanActivity.class, bund);
                    }
                    break;
                //合同
                case R.id.tvContract:
                    if (tvContract.getAlpha() == 1.0f) {
                        bund.putSerializable("file", prs);
                        bund.putString("key", "Contract");
                        ActivitySkip.forward(ProductSubunitListActivity.this, FileActivity.class,
                                bund);
                    }
                    break;
                //文件
                case R.id.tvFile:
                    if (tvFile.getAlpha() == 1.0f) {
                        bund.putString("key", "File");
                        bund.putSerializable("file", prs);
                        ActivitySkip.forward(ProductSubunitListActivity.this, FileActivity.class,
                                bund);
                    }
                    break;
            }
        }
    };

    private void sortPriceHighToLow() {
        try {

            List<ProSubunitListBean.ResultBean.PropertyBean> lists = adapter.getmDatas();
            Collections.sort(lists, new Comparator<ProSubunitListBean.ResultBean.PropertyBean>() {
                @Override
                public int compare(ProSubunitListBean.ResultBean.PropertyBean o1, ProSubunitListBean
                        .ResultBean.PropertyBean o2) {

                    if (Integer.parseInt(o2.getPrice().split("\\.")[0]) > Integer.parseInt
                            (o1.getPrice().split("\\.")[0])) {
                        return 1;
                    }

                    if (Integer.parseInt(o1.getPrice().split("\\.")[0]) == Integer.parseInt
                            (o2.getPrice().split("\\.")[0])) {
                        return 0;
                    }
                    return -1;
                }
            });
            adapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            e.printStackTrace();

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }


    }

    private void showEoiPay() {
        if (eoiPayDialog == null) {
            eoiPayDialog = new Dialog(ProductSubunitListActivity.this);
            eoiPayDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            eoiPayDialog.setContentView(R.layout.eoi_operate_view);
            Window dialogWindow = eoiPayDialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.x = MyUtils.getStatusBarHeight(ProductSubunitListActivity.this);
            dialogWindow.setAttributes(lp);
            dialogWindow.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, WindowManager
                    .LayoutParams.WRAP_CONTENT);
            dialogWindow.setGravity(Gravity.CENTER | Gravity.TOP);
            initDialogViews(eoiPayDialog);
            eoiPayDialog.show();
        } else {
            eoiPayDialog.show();
        }
    }

    private void initDialogViews(Dialog dialog) {
        tvMoneyNum = (TextView) dialog.findViewById(R.id.tvMoneyNum);
        tvPayMethod = (TextView) dialog.findViewById(R.id.tvPayMethod);
        tvEoiSubmit = (TextView) dialog.findViewById(R.id.tvEoiSubmit);
        ivCash = (ImageView) dialog.findViewById(R.id.ivCash);
        ivIdCard = (ImageView) dialog.findViewById(R.id.ivIdCard);
        ivAlipay = (ImageView) dialog.findViewById(R.id.ivAlipay);
        ivWechatPay = (ImageView) dialog.findViewById(R.id.ivWeixinPay);
        llCertificate = (LinearLayout) dialog.findViewById(R.id.llCertificate);
        ivCertificate = (ImageView) dialog.findViewById(R.id.ivCertificate);
        ivCash.setOnClickListener(mOnClickListener);
        ivIdCard.setOnClickListener(mOnClickListener);
        ivAlipay.setOnClickListener(mOnClickListener);
        ivWechatPay.setOnClickListener(mOnClickListener);
        tvEoiSubmit.setOnClickListener(mOnClickListener);
        ivCertificate.setOnClickListener(mOnClickListener);

    }


    /**
     * 充值EOI
     */
    private void submitEoi() {
        String customer_id = ((CustomBean.ResultBean) ObjectSaveUtil.readObject
                (ProductSubunitListActivity.this, "custome")).getCustomer_id() + "";
        UIProgressResponseCallBack mUIProgressResponseCallBack = new UIProgressResponseCallBack() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {


            }
        };

        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());
        httpParams.put("customer_id", customer_id);
        httpParams.put("product_id", data.get(pos).getProduct_id() + "");
        httpParams.put("product_childs_id", data.get(pos).getProduct_childs_id() + "");
        httpParams.put("pay_method", payment_method);


        if (!picPath.equals("")) {
            File picFile = new File(picPath);
            httpParams.put("file", picFile, mUIProgressResponseCallBack);
        }

        EasyHttp.post(Contants.EOI_RECHARGE_).cacheMode(CacheMode.NO_CACHE).params(httpParams)
                .timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                showDialog();
            }

            @Override
            public void onError(ApiException e) {
                closeDialog();
                ToasShow.showToast(ProductSubunitListActivity.this, getResources().getString(R
                        .string.network_error));
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess***", "UserBean:" + json);
                closeDialog();


                try {

                    Gson gs = new Gson();
                    EOIPayBean result = gs.fromJson(json, EOIPayBean.class);
                    ToasShow.showToastCenter(ProductSubunitListActivity.this, result.getMsg());
                    if (result.getCode().equals("1")) {
                        eoiPayDialog.dismiss();
                        if (payment_method.equals("6") || payment_method.equals("7")) {
                            Bundle bundle = new Bundle();
                            bundle.putString("payurlId", result.getTrust_account_id());
                            bundle.putString("payment_method", payment_method);
                            ActivitySkip.forward(ProductSubunitListActivity.this, PaymentQrActivity
                                    .class, bundle);
                        }

                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }


//    private void getItemProductDetail() {
//        EasyHttp.get(Contants.PRODUCT_DETAIL)
//                .cacheMode(CacheMode.DEFAULT)
//                .headers("Cache-Control", "max-age=0")
//                .timeStamp(true).params("product_id", mResultBean.getProduct_id() + "")
//                .params("user_id", SharedPreferencesHelps.getUserID())
//                .execute(new SimpleCallBack<String>() {
//                    @Override
//                    public void onStart() {
//                        super.onStart();
//                        showDialog();
//                    }
//
//                    @Override
//                    public void onError(ApiException e) {
//                        closeDialog();
//                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(String json) {
//                        Log.e("onSuccess", "json:" + json);
//                        closeDialog();
//
//                        try {
//
//                            Gson gson = new Gson();
//                            ProductDetailBean pdb = gson.fromJson(json, ProductDetailBean.class);
//                            if (pdb.getCode().equals("1")) {
//                                prs = pdb.getResult();
//                                BaseApplication.getInstance().setPrs(prs);
//                                controlColor();
//
//
//                            }
//                        } catch (JsonSyntaxException e) {
//                            e.printStackTrace();
//                        } catch (NullPointerException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                });
//
//
//    }


//    //控制控件颜色
//    private void controlColor() {
//        if (prs.getDescription_url() != null) {
//            tvIntroduce.setAlpha(1.0f);
//        }
//        if (prs.getVideo_url() != null) {
//            tvVideo.setAlpha(1.0f);
//        }
//
//
//        if (prs.getFile_content() != null && prs.getFile_content().size() > 0) {
//
//            for (int i = 0; i < prs.getFile_content().size(); i++) {
//                if (prs.getFile_content().get(i).getFile_type() == 1) {
//                    tvFloor.setAlpha(1.0f);
//                }
//            }
//
//        }
//
//
//        if (prs.getContract_url() != null && !prs.getContract_url().equals("")) {
//            tvContract.setAlpha(1.0f);
//        }
//        if (prs.getFile_content() != null && prs.getFile_content().size() > 0) {
//            tvFile.setAlpha(1.0f);
//        }
//    }

    @Override
    public void setListener() {
        btViewDetail.setOnClickListener(mOnClickListener);
        btRemain.setOnClickListener(mOnClickListener);
        btLineup.setOnClickListener(mOnClickListener);
        btCancel.setOnClickListener(mOnClickListener);
        lvHouseDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCustomePopuWindow.showAtLocation(ProductSubunitListActivity.this.findViewById(R
                        .id.llProdet), Gravity.BOTTOM, 0, 0);
                pos = position;


                //销售可预订
                if (SharedPreferencesHelps.getType() == 1) {

                    if (data.get(pos).getIs_lock() == 1) {
                        btRemain.setVisibility(View.GONE);
                        btLineup.setVisibility(View.GONE);
                    } else if (data.get(pos).getIs_lock() == 0) {

                        if (SharedPreferencesHelps.getProjectStatus().equals("old")) {
                            Log.e("TAG", "onItemClick: " + SharedPreferencesHelps
                                    .getProjectStatus());
                            btRemain.setVisibility(View.GONE);
                        } else {
                            btRemain.setVisibility(View.VISIBLE);
                        }
                        btLineup.setVisibility(View.GONE);
                    }
                    if (data.get(pos).getIf_eoi() == 1) {
                        btRemain.setVisibility(View.GONE);
                        btLineup.setVisibility(View.VISIBLE);
                    }

                    //推荐人不可预订
                } else if (SharedPreferencesHelps.getType() == 2) {
                    btRemain.setVisibility(View.GONE);
                    btLineup.setVisibility(View.GONE);
                }
            }
        });
    }

    class CustomePopuWindow extends CommonPopuWindow {

        public CustomePopuWindow(Activity context) {
            super(context);
        }

        @Override
        protected int getLayoutId() {
            return R.layout.prodet_lvitem_popwindow;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity
                            .EXTRA_RESULT);
                    loadAdpater(list);
                    break;
                //从相册选取图片
                case ExtraName.ALBUM_PICTURE:
                    Uri selectedPhotoUri = null;
                    selectedPhotoUri = data.getData();
                    picPath = BitmapUtil.getImagePath(ProductSubunitListActivity.this,
                            selectedPhotoUri, null, null);
                    Picasso.with(this).load(selectedPhotoUri).resize(ivCertificate.getWidth(),
                            ivCertificate.getHeight()).into(ivCertificate);
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
        picPath = imagePaths.get(0);
        Picasso.with(ProductSubunitListActivity.this).load("file://" + picPath).resize
                (ivCertificate.getWidth(), ivCertificate.getHeight()).centerInside().into
                (ivCertificate);

    }

}
