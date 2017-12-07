package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.myView.ShareDialog;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ObjectSaveUtil;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.StatusBarUtil;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.yd.org.sellpopularizesystem.utils.ZXingUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class ProductItemDetailActivity extends AppCompatActivity {
    private TextView tvId, tvProdes, tvIsSalingNum, tvHasSaledNum, tvFirbNum, tvEoiTime, tvSaleDeadTime, tvStartDate, tvCloseDate, tvMemo, tvProjectPro, tvSupplier, tvLawyer, tvBuilder, tvDespositHolder, tvForeignMoney, tvCashDesposit, tvSubscription, tvhas, tvIntroduce, tvVideo, tvOrder, tvFloor, tvContract, tvFile, tvrojectDe, tvSaleTime, agent_notes, proDelAddTv;
    private RollPagerView rpv;
    private ProductListBean.ResultBean mResultBean;
    private ProductDetailBean.ResultBean prs;
    private UMShareListener mUmShareListener;
    private ShareAction mShareAction;
    private String string;
    private static Bitmap bitmap;
    private Bundle bun = new Bundle();
    //private String product_id;
    protected ImageView backImageView, imageViewShare;
    private CustomBean.ResultBean custome;
    private LinearLayout agentsNotesLin;
    private int temp = 0;
    private RelativeLayout salingRel;
    private LinearLayout agentsLin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item_des);
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        custome = ((CustomBean.ResultBean) ObjectSaveUtil.readObject(ProductItemDetailActivity.this, "custome"));

        //
        Bundle bundle = getIntent().getExtras();
        string = bundle.getString("productName");
        mResultBean = (ProductListBean.ResultBean) bundle.getSerializable("bean");
        // product_id = String.valueOf(resultBean.getProduct_id());

        initView();
    }

    public void initView() {
        agentsLin = (LinearLayout) findViewById(R.id.agentsLin);


        tvOrder = (TextView) findViewById(R.id.tvOrder);
        tvhas = (TextView) findViewById(R.id.tvhas);
        salingRel = (RelativeLayout) findViewById(R.id.salingRel);
        if (SharedPreferencesHelps.getProjectStatus().equals("old")) {

            salingRel.setVisibility(View.GONE);
            tvhas.setText(getString(R.string.pdel_));
            tvOrder.setText(getString(R.string.unit_list));

        } else {
            salingRel.setVisibility(View.VISIBLE);
            tvhas.setText(getString(R.string.hashsalenum));
            tvOrder.setText(getString(R.string.reserver));
        }

        //agent notes

        agentsNotesLin = (LinearLayout) findViewById(R.id.agentsNotesLin);
        agentsNotesLin.setOnClickListener(mOnClickListener);


        agent_notes = (TextView) findViewById(R.id.agent_notes);

        proDelAddTv = (TextView) findViewById(R.id.proDelAddTv);

        //保存推广开始时间
        SharedPreferencesHelps.setTime((System.currentTimeMillis() / 1000) + "");
        backImageView = (ImageView) findViewById(R.id.backImageView);
        backImageView.setOnClickListener(mOnClickListener);


        imageViewShare = (ImageView) findViewById(R.id.imageViewShare);
        imageViewShare.setOnClickListener(mOnClickListener);

        initViews();
        initData();
        setListener();

    }

    private void openShareDialog(final String shareUrl) {


        Bitmap bitmap = ZXingUtils.createQRImage(shareUrl, 200, 200);

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
        }
        new ShareDialog(ProductItemDetailActivity.this, new ShareDialog.onClickback() {
            @Override
            public void onShare(int id) {
                switch (id) {
                    case 1://微信
                        shareToMedia(SHARE_MEDIA.WEIXIN, shareUrl);
                        Log.e("分享链接", "shareUrl:" + shareUrl);
                        break;
                    case 2://微信朋友圈
                        shareToMedia(SHARE_MEDIA.WEIXIN_CIRCLE, shareUrl);
                        break;
                    case 3://facebook
                        shareToMedia(SHARE_MEDIA.FACEBOOK, shareUrl);
                        break;
                }
            }
        }, bitmap).show();
    }

    private void shareToMedia(SHARE_MEDIA share_MEDIA, String shareUrl) {
        try {

            final UMWeb web = new UMWeb(shareUrl);
            web.setTitle(getResources().getString(R.string.app_name));
            web.setDescription(mResultBean.getProduct_name());
            web.setThumb(new UMImage(ProductItemDetailActivity.this, Contants.DOMAIN + "/" + mResultBean.getThumb()));
            mShareAction.setPlatform(share_MEDIA).setCallback(mUmShareListener).withMedia(web).share();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void initViews() {
        //轮播图控件
        rpv = (RollPagerView) findViewById(R.id.rpv);
        //设置轮播时间间隔
        rpv.setPlayDelay(3000);
        //设置轮播动画持续时间
        rpv.setAnimationDurtion(500);
        //自定义指示器图片
        //rpv.setHintView(new IconHintView(this,R.mipmap.dian_true,R.mipmap.dian_false));
        rpv.setHintView(new ColorPointHintView(this, Color.WHITE, Color.parseColor("#7F7F7F")));
        rpv.setOnItemClickListener(mOnItemClickListener);
        tvId = (TextView) findViewById(R.id.tvId);
        tvProdes = (TextView) findViewById(R.id.tvProdes);
        tvIsSalingNum = (TextView) findViewById(R.id.tvIsSalingNum);
        tvHasSaledNum = (TextView) findViewById(R.id.tvHasSaledNum);
        tvFirbNum = (TextView) findViewById(R.id.tvFirbNum);
        tvEoiTime = (TextView) findViewById(R.id.tvEoiTime);
        tvSaleTime = (TextView) findViewById(R.id.tvSaleTime);
        tvSaleDeadTime = (TextView) findViewById(R.id.tvSaleDeadTime);
        tvStartDate = (TextView) findViewById(R.id.tvStartDate);
        tvCloseDate = (TextView) findViewById(R.id.tvCloseDate);
        tvMemo = (TextView) findViewById(R.id.tvMemo);
        tvProjectPro = (TextView) findViewById(R.id.tvProjectPro);
        tvSupplier = (TextView) findViewById(R.id.tvSupplier);
        tvBuilder = (TextView) findViewById(R.id.tvBuilder);
        tvLawyer = (TextView) findViewById(R.id.tvLawyer);
        tvDespositHolder = (TextView) findViewById(R.id.tvDespositHolder);
        tvForeignMoney = (TextView) findViewById(R.id.tvForeignMoney);
        tvCashDesposit = (TextView) findViewById(R.id.tvCashDesposit);
        tvSubscription = (TextView) findViewById(R.id.tvSubscription);
        tvIntroduce = (TextView) findViewById(R.id.tvIntroduce);
        tvVideo = (TextView) findViewById(R.id.tvVideo);
        tvFloor = (TextView) findViewById(R.id.tvFloor);
        tvContract = (TextView) findViewById(R.id.tvContract);
        tvFile = (TextView) findViewById(R.id.tvFile);

        tvrojectDe = (TextView) findViewById(R.id.tvrojectDe);
        tvrojectDe.setText(string);
        mUmShareListener = new CustomShareListener(this);
        mShareAction = new ShareAction(ProductItemDetailActivity.this);

    }

    private void initData() {
        EasyHttp.get(Contants.PRODUCT_DETAIL)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("product_id", mResultBean.getProduct_id() + "")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();

                    }

                    @Override
                    public void onError(ApiException e) {

                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("json***", "json:" + json);

                        if (null != json) {


                            try {

                                Gson gson = new Gson();
                                ProductDetailBean pdb = gson.fromJson(json, ProductDetailBean.class);
                                if (pdb.getCode().equals("1")) {
                                    prs = pdb.getResult();
                                    BaseApplication.getInstance().setPrs(prs);
                                    setInfo(prs);
                                }

                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }


                        }


                    }
                });


    }


    private void setInfo(ProductDetailBean.ResultBean prs) {


        try {
            //轮播控件适配器
            rpv.setAdapter(new NormalAdapter(rpv));
            tvId.setText(prs.getProduct_id() + "");
            tvProdes.setText(prs.getDescription());
            tvIsSalingNum.setText(prs.getSell_number() + "");

            if (SharedPreferencesHelps.getProjectStatus().equals("old")) {
                tvHasSaledNum.setText((prs.getSign_number() + prs.getSell_number()) + "");
            } else {
                tvHasSaledNum.setText(prs.getSign_number() + "");
            }

            tvFirbNum.setText(prs.getFirb_number() + "");


            if (null != prs.getAgent_notes() && !TextUtils.isEmpty(prs.getAgent_notes())) {
                agentsLin.setVisibility(View.VISIBLE);
                agent_notes.setText(prs.getAgent_notes());
                double agents = Integer.parseInt(prs.getAgent_notes());
                int agentsSize = (int) Math.ceil(agents / 0.5);
                if (agentsSize > 16) {
                    agentsSize = 16;
                }
                for (int i = 0; i < agentsSize; i++) {

                    //每0.5显示一颗星星
                    ImageView imageView = new ImageView(ProductItemDetailActivity.this);
                    imageView.setImageResource(R.mipmap.agents);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setPadding(4, 4, 4, 4);
                    agentsLin.addView(imageView);

                }


            } else {
                agentsLin.setVisibility(View.GONE);
            }


            Locale locale = Locale.getDefault();
            String language = locale.getLanguage();
            Resources resources = getResources();
            Configuration config = resources.getConfiguration();
            if (!language.equals("")) {
                if (language.equals("zh")) {
                    proDelAddTv.setText(prs.getCountry() + " " + prs.getState() + " " + prs.getCity() + " " + prs.getStreet_address_1() + " " + prs.getStreet_address_2() + " " + prs.getStreet_number() + " " + prs.getPostcode());
                } else if (language.equals("en")) {
                    proDelAddTv.setText(prs.getStreet_number() + " " + prs.getStreet_address_1() + " " + prs.getStreet_address_2() + " " + prs.getAddress_suburb() + " " + prs.getState() + " " + prs.getPostcode() + " " + prs.getCountry());

                }
            }


            if (prs.getEoi_open_time() == null || (double) prs.getEoi_open_time() == 0 || String.valueOf(prs.getEoi_open_time()).equals("0")) {
                tvEoiTime.setText("--");
            } else {
                tvEoiTime.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(Double.valueOf((double) prs.getEoi_open_time()).longValue() + "000")));
            }
            if ((double) prs.getStart_sales_time() == 0 || String.valueOf(prs.getStart_sales_time()).equals("0")) {
                tvSaleTime.setText("--");
            } else {
                tvSaleTime.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(Double.valueOf((double) prs.getStart_sales_time()).longValue() + "000")));
            }
            if (prs.getStop_sales_time() == null || (double) prs.getStop_sales_time() == 0 || String.valueOf(prs.getStop_sales_time()).equals("0")) {
                tvSaleDeadTime.setText("--");
            } else {
                tvSaleDeadTime.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(Double.valueOf((double) prs.getStop_sales_time()).longValue() + "000")));
            }
            if (prs.getSunset_time() == null || (double) prs.getSunset_time() == 0 || String.valueOf(prs.getSunset_time()).equals("0")) {
                tvStartDate.setText("--");
            } else {
                tvStartDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(Double.valueOf((double) prs.getSunset_time()).longValue() + "000")));
            }
            if ((double) prs.getSettlement_time() == 0 || String.valueOf(prs.getSettlement_time()).equals("0")) {
                tvCloseDate.setText("--");
            } else {
                tvCloseDate.setText(MyUtils.date2String("yyyy/MM/dd", Long.parseLong(Double.valueOf((double) prs.getSettlement_time()).longValue() + "000")));
            }

            tvMemo.setText(prs.getPreview_memo());
            tvProjectPro.setText(prs.getProduct_type());
            tvSupplier.setText(prs.getVendor());
            tvLawyer.setText(prs.getVendor_lawyer());
            tvBuilder.setText(prs.getBuilder());
            tvDespositHolder.setText(prs.getDesposit_holder());
            tvForeignMoney.setText(prs.getExchange_deposit() + "%");
            tvCashDesposit.setText(prs.getFirb_exchange_deposit() + "%");
            tvSubscription.setText(prs.getMin_reservation_fee());
            controlColor();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            agentsLin.setVisibility(View.GONE);
        } catch (NullPointerException e) {
            e.printStackTrace();

        }

    }


    private void controlColor() {

        try {

            if (prs.getDescription_url() != null) {
                tvIntroduce.setAlpha(1.0f);
            }
            if (prs.getVideo_url() != null) {
                tvVideo.setAlpha(1.0f);
            }
            if (prs.getFile_content() != null && prs.getFile_content().size() > 0) {

                for (int i = 0; i < prs.getFile_content().size(); i++) {
                    if (prs.getFile_content().get(i).getFile_type() == 1) {
                        tvFloor.setAlpha(1.0f);
                    }
                }

            }
            if (prs.getContract_url() != null && !prs.getContract_url().equals("")) {
                tvContract.setAlpha(1.0f);
            }
            if (prs.getFile_content() != null && prs.getFile_content().size() > 0) {
                tvFile.setAlpha(1.0f);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                //agent notes
                case R.id.agentsNotesLin:

                    if (temp == 0) {
                        agent_notes.setVisibility(View.VISIBLE);
                        temp = 1;
                    } else {
                        agent_notes.setVisibility(View.GONE);
                        temp = 0;
                    }


                    break;


                //分享
                case R.id.imageViewShare:
                    final String shareUrl = Contants.SHURE_URL + "?product_id=" + mResultBean.getProduct_id() + "&user_id=" + SharedPreferencesHelps.getUserID() + "&refer_id=" + SharedPreferencesHelps.getReferCode();
                    openShareDialog(shareUrl);

                    break;
                //介绍
                case R.id.tvIntroduce:
                    if (tvIntroduce.getAlpha() == 1.0f) {
                        bun.putString("introduce", prs.getDescription_url() + "");
                        bun.putString("type", "0");
                        ActivitySkip.forward(ProductItemDetailActivity.this, IntroduceActivity.class, bun);
                    }

                    break;
                //视频
                case R.id.tvVideo:
                    if (tvVideo.getAlpha() == 1.0f) {
                        bun.putSerializable("prs", prs);
                        ActivitySkip.forward(ProductItemDetailActivity.this, VideoActivity.class, bun);
                    }
                    break;
                //预定
                case R.id.tvOrder:
                    if (mResultBean != null) {
                        // bun.putSerializable("prs", prs);
                        // bun.putString("productId", product_id == null ? "" : product_id);
                        //bun.putString("title", resultBean.getProduct_name());
                        bun.putSerializable("key", mResultBean);
                        // bun.putString("pidatopsla", "pidatopsla");
                        ActivitySkip.forward(ProductItemDetailActivity.this, ProductSubunitListActivity.class, bun);
                    }
                    break;
                //平面图
                case R.id.tvFloor:
                    if (mResultBean != null) {
                        if (tvFloor.getAlpha() == 1.0f) {
                            bun.putSerializable("floorListData", (Serializable) prs.getFile_content());
                            ActivitySkip.forward(ProductItemDetailActivity.this, BuildingPlanActivity.class, bun);
                        }
                    }
                    break;
                //合同
                case R.id.tvContract:
                    if (tvContract.getAlpha() == 1.0f) {
                        bun.putSerializable("file", prs);
                        bun.putString("key", "Contract");
                        ActivitySkip.forward(ProductItemDetailActivity.this, FileActivity.class, bun);
                    }
                    break;
                //文件
                case R.id.tvFile:
                    if (tvFile.getAlpha() == 1.0f) {
                        bun.putString("key", "File");
                        bun.putSerializable("file", prs);
                        ActivitySkip.forward(ProductItemDetailActivity.this, FileActivity.class, bun);
                    }
                    break;


                //返回按钮
                case R.id.backImageView:
                    addSaleLog();
                    finish();
                    break;
                default:
                    break;
            }
        }
    };
    OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            bun = new Bundle();
            bun.putSerializable("prs", prs);
            ActivitySkip.forward(ProductItemDetailActivity.this, ScaleDeltaileActivity.class, bun);
        }
    };


    public void setListener() {
        tvIntroduce.setOnClickListener(mOnClickListener);
        tvVideo.setOnClickListener(mOnClickListener);
        tvOrder.setOnClickListener(mOnClickListener);
        tvFloor.setOnClickListener(mOnClickListener);
        tvContract.setOnClickListener(mOnClickListener);
        tvFile.setOnClickListener(mOnClickListener);
    }

    private class CustomShareListener implements UMShareListener {

        private WeakReference<ProductItemDetailActivity> mActivity;

        private CustomShareListener(ProductItemDetailActivity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            ToasShow.showToastCenter(ProductItemDetailActivity.this, getString(R.string.sharesuccess));
            if (bitmap != null) {
                bitmap.recycle();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (t != null) {
                String expName = t.getMessage();
                if (expName.contains(getString(R.string.noinstallapp))) {
                    ToasShow.showToastCenter(ProductItemDetailActivity.this, getString(R.string.clientnoinstallapp));
                } else {
                    ToasShow.showToastCenter(ProductItemDetailActivity.this, getString(R.string.sharefail));

                }

            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mActivity.get(), platform + getString(R.string.sharecancel), Toast.LENGTH_SHORT).show();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    private class NormalAdapter extends LoopPagerAdapter {
        public NormalAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            BitmapUtil.loadImageView(ProductItemDetailActivity.this, Contants.DOMAIN + "/" + prs.getImg_content().get(position).getThumbURL(), view);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return ProductItemDetailActivity.this.prs.getImg_content().size();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            addSaleLog();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


    private void addSaleLog() {
        try {
            JSONArray jsonarray = new JSONArray();//json数组，里面包含的内容为pet的所有对象
            JSONObject jsonObj = new JSONObject();//pet对象，json形式

            jsonObj.put("product_id", mResultBean.getProduct_id());
            jsonObj.put("user_id", SharedPreferencesHelps.getUserID());
            //Log.e("addSaleLog", "customer_id: "+ BaseApplication.getInstance().getResultBean().getCustomer_id());
            jsonObj.put("customer_id", custome.getCustomer_id() + "");
            jsonObj.put("content", string);
            jsonObj.put("start_time", SharedPreferencesHelps.getTime());
            jsonObj.put("end_time", ((System.currentTimeMillis() / 1000) + ""));
            jsonObj.put("gps_x_y", mResultBean.getLongitude() + "," + mResultBean.getLatitude());
            jsonarray.put(jsonObj);

            SharedPreferencesHelps.setData(jsonarray.toString());


            if (null != HomeActivity.homeActiviyt && null != HomeActivity.homeActiviyt.recordHandler) {
                HomeActivity.homeActiviyt.recordHandler.sendEmptyMessage(0x001);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }


}
