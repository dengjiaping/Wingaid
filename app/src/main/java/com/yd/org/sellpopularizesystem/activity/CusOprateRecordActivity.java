package com.yd.org.sellpopularizesystem.activity;

import android.Manifest;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.permission.Acp;
import com.lidong.photopicker.permission.AcpListener;
import com.lidong.photopicker.permission.AcpOptions;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CommonAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.application.ViewHolder;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.SwipeListview.SwipeMenu;
import com.yd.org.sellpopularizesystem.internal.SwipeListview.SwipeMenuCreator;
import com.yd.org.sellpopularizesystem.internal.SwipeListview.SwipeMenuItem;
import com.yd.org.sellpopularizesystem.internal.SwipeListview.SwipeMenuListView;
import com.yd.org.sellpopularizesystem.javaBean.ErrorBean;
import com.yd.org.sellpopularizesystem.javaBean.SubscribeListBean;
import com.yd.org.sellpopularizesystem.javaBean.VisitRecord;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

public class CusOprateRecordActivity extends BaseActivity implements PullToRefreshLayout
        .OnRefreshListener {
    private String customeId;
    private Bundle bundle;
    private String flag;
    private TextView tvDes, tvVisitTile, tvVisitSubmit,
            tvVisitTime;
    private EditText etVistTitle, etVistContent;
    private CommonAdapter visitAdapter, subscribeAdapter;
    private SwipeMenuListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private Dialog visitDilog;
    private VisitRecord.ResultBean visitRecord;
    public static CusOprateRecordActivity cusOprateRecordActivity;
    private List<VisitRecord.ResultBean> vrrb = new ArrayList<>();
    private List<SubscribeListBean.ResultBean> rbList = new ArrayList<>();
    private ArrayList<String> imagePaths = new ArrayList<>();
    private static final int REQUEST_CAMERA_CODE = 10;

    @Override
    protected int setContentView() {
        cusOprateRecordActivity = this;
        return R.layout.activity_cus_oprate_record;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        flag = bundle.getString("custocora");
        customeId = (String) bundle.get("customeId");
        initWidgets();
        //拜访记录
        if (flag.equals("custovisit") || flag.equals("custoreser")) {
            if (flag.equals("custovisit")) {
                setTitle(getString(R.string.visit));
                initVisitDilaog();
                getVisitData(page, true);

                //预约记录
            } else if (flag.equals("custoreser")) {
                setTitle(getString(R.string.yuyuerecord));
                getReservertData(page, true);
            }
            clickRightImageView(R.mipmap.addim, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag.equals("custovisit")) {
                        bundle.putString("cora", "visit");
                        ActivitySkip.forward(CusOprateRecordActivity.this, DialogOptionActivity
                                .class, bundle);
                    } else if (flag.equals("custoreser")) {
                        bundle.putString("cora", "reserver");
                        ActivitySkip.forward(CusOprateRecordActivity.this, DialogOptionActivity
                                .class, bundle);
                    }
                }
            });
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == ExtraName.UPDATE && flag.equals("custovisit")) {
                getVisitData(page, true);
            } else if (msg.what == ExtraName.UPDATE && flag.equals("custoreser")) {
                getReservertData(page, true);
            }
        }
    };

    private void initWidgets() {
        listView = getViewById(R.id.content_view);
        tvDes = getViewById(R.id.tvDes);
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.ivCertificate:
                    Acp.getInstance(CusOprateRecordActivity.this).request(new AcpOptions.Builder
                            ().setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            .build(), new AcpListener() {
                        @Override
                        public void onGranted() {

                            PhotoPickerIntent intent = new PhotoPickerIntent
                                    (CusOprateRecordActivity.this);
                            intent.setSelectModel(SelectModel.SINGLE);
                            intent.setShowCarema(true); // 是否显示拍照
                            // intent.setMaxTotal(6); // 最多选择照片数量，默认为6
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                        }

                        @Override
                        public void onDenied(List<String> permissions) {
                            ToasShow.showToastCenter(CusOprateRecordActivity.this, permissions
                                    .toString() + "权限拒绝");
                        }
                    });
                    break;

                //提交拜访记录
                case R.id.tvVisitSubmit:
                    try {
                        if (etVistTitle.getText().toString().equals(visitRecord.getTitle().toString()) && etVistContent.getText().toString().equals(visitRecord.getContent()
                                .toString())) {
                            ToasShow.showToastCenter(CusOprateRecordActivity.this, getString(R.string
                                    .tips));
                        } else {
                            updateVisit();
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };


    private void updateVisit() {
        EasyHttp.post(Contants.CHANGE_PASSWORD).cacheMode(CacheMode.NO_CACHE).params("v_log_id",
                visitRecord.getV_log_id() + "").params("customer_id", customeId).params("title",
                etVistTitle.getText().toString()).params("content", etVistContent.getText()
                .toString()).timeStamp(true).execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                showDialog();
            }

            @Override
            public void onError(ApiException e) {
                closeDialog();
            }

            @Override
            public void onSuccess(String json) {
                Log.e("onSuccess***", "UserBean:" + json);
                closeDialog();

                try {
                    Gson gs = new Gson();
                    ErrorBean result = gs.fromJson(json, ErrorBean.class);
                    if (result.getCode().equals("1")) {
                        ToasShow.showToastCenter(CusOprateRecordActivity.this, result.getMsg());
                        handler.sendEmptyMessage(ExtraName.UPDATE);
                        visitDilog.dismiss();

                    } else {
                        ToasShow.showToastCenter(CusOprateRecordActivity.this, result.getMsg());
                        visitDilog.dismiss();
                    }
                } catch (JsonSyntaxException e) {
                    Log.e("解析异常", "e:" + e.getMessage());

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }


    @Override
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    if (flag.equals("custovisit")) {
                        visitRecord = (VisitRecord.ResultBean) visitAdapter.getItem(position);
                        visitDilog.show();
                        tvVisitTile.setText(getString(R.string.details));
                        etVistTitle.setText(visitRecord.getTitle());
                        tvVisitTime.setText(MyUtils.date2String("MM/dd HH:mm", visitRecord
                                .getAdd_time() * 1000));
                        etVistContent.setText(visitRecord.getContent());
                        tvVisitSubmit.setText(getString(R.string.update));
                        tvVisitSubmit.setOnClickListener(mOnClickListener);
                    } else if (flag.equals("custoreser")) {
                        Bundle bun = new Bundle();
                        bun.putSerializable("subrb", rbList.get(position));
                        ActivitySkip.forward(CusOprateRecordActivity.this, DialogOptionActivity
                                .class, bun);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }


            }
        });


    }


    private void initVisitDilaog() {
        visitDilog = new Dialog(CusOprateRecordActivity.this);
        visitDilog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        visitDilog.setContentView(R.layout.visit_operate_view);
        Window dialogWindow = visitDilog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = MyUtils.getStatusBarHeight(CusOprateRecordActivity.this);
        dialogWindow.setAttributes(lp);
        dialogWindow.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams
                .WRAP_CONTENT);
        dialogWindow.setGravity(Gravity.CENTER);
        initVisitDilaogViews(visitDilog);
    }

    private void initVisitDilaogViews(Dialog visitDilog) {
        tvVisitTile = (TextView) visitDilog.findViewById(R.id.tvVisitTile);
        etVistTitle = (EditText) visitDilog.findViewById(R.id.etVistTitle);
        tvVisitTime = (TextView) visitDilog.findViewById(R.id.tvVisitTime);
        etVistContent = (EditText) visitDilog.findViewById(R.id.etVistContent);
        tvVisitSubmit = (TextView) visitDilog.findViewById(R.id.tvVisitSubmit);
    }

    private void getVisitData(int page, final boolean isRel) {

        EasyHttp.get(Contants.VISIT_RECORD_LIST)
                .cacheMode(CacheMode.DEFAULT).headers
                ("Cache-Control", "max-age=0")
                .timeStamp(true).params("user_id", SharedPreferencesHelps.getUserID())
                .params("customer_id", customeId)
                .params("page", String.valueOf(page))
                .params("number", "100")
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

                        closeDialog();

                        try {


                            Gson gson = new Gson();
                            VisitRecord visitRecord = gson.fromJson(json, VisitRecord.class);
                            if (visitRecord.getCode().equals("1")) {
                                vrrb = visitRecord.getResult();
                            }


                            if (isRel) {

                                if (vrrb.size() == 0) {
                                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                                    listView.setVisibility(View.GONE);
                                } else {
                                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                }

                                visitAdapter = new CommonAdapter<VisitRecord.ResultBean>
                                        (CusOprateRecordActivity.this, vrrb, R.layout
                                                .visit_listview_item_layout) {
                                    @Override
                                    public void convert(ViewHolder holder, VisitRecord.ResultBean
                                            item) {
                                        holder.setText(R.id.tvVisitTime, MyUtils.date2String
                                                ("yyyy/MM/dd", Long.valueOf(item.getAdd_time() +
                                                        "000")));
                                        holder.setText(R.id.tvVisitTitle, item.getTitle());
                                        holder.setText(R.id.tvVisitContent, item.getContent());
                                    }
                                };
                                listView.setAdapter(visitAdapter);
                                initMenuListView();


                            } else {
                                visitAdapter.addMore(vrrb);
                            }

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                            Log.e("解析异常", "e:" + e.getMessage());
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    private void initMenuListView() {
        //创建一个SwipeMenuCreator供ListView使用
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                //创建一个侧滑菜单
                SwipeMenuItem deleteItem = new SwipeMenuItem(CusOprateRecordActivity.this);
                //给该侧滑菜单设置背景
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                //设置宽度
                deleteItem.setWidth(MyUtils.dp2px(CusOprateRecordActivity.this, 80));
                //设置文字
                deleteItem.setTitle(getString(R.string.delete));
                //字体大小
                deleteItem.setTitleSize(16);
                //字体颜色
                deleteItem.setTitleColor(Color.WHITE);
                //加入到侧滑菜单中
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(creator);
        //侧滑菜单的相应事件
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0://第一个添加的菜单的响应时间(打开)
                        if (flag.equals("custovisit")) {
                            if (vrrb.size() > 0) {
                                int vlog_id = vrrb.get(position).getV_log_id();
                                vrrb.remove(position);
                                visitAdapter.notifyDataSetChanged();
                                if (vrrb.size() == 0) {
                                    tvDes.setVisibility(View.VISIBLE);
                                    tvDes.setText(getString(R.string.noinformation));
                                }
                                removeVistOrResRecord(vlog_id);
                            }
                        } else if (flag.equals("custoreser")) {
                            if (rbList.size() > 0) {
                                Log.e("size", "onMenuItemClick: " + rbList.size() + "\n" +
                                        position);
                                int log_id = rbList.get(position).getO_log_id();
                                rbList.remove(position);
                                subscribeAdapter.notifyDataSetChanged();
                                if (rbList.size() == 0) {
                                    tvDes.setVisibility(View.VISIBLE);
                                    tvDes.setText(getString(R.string.noinformation));
                                }
                                removeVistOrResRecord(log_id);
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void removeVistOrResRecord(int id) {
        String strUrl = "";
        String key = null;
        if (flag.equals("custovisit")) {
            key = "v_log_id";

            strUrl = Contants.REMOVE_VISIT_RECORD;
        } else if (flag.equals("custoreser")) {

            key = "o_log_id";
            strUrl = Contants.REMOVE_RESERVER_RECORD;
        }


        EasyHttp.post(strUrl).cacheMode(CacheMode.NO_CACHE).params(key, id + "").timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess***", "UserBean:" + json);
                        closeDialog();

                        if (!TextUtils.isEmpty(json)) {


                            try {

                                Gson gson = new Gson();
                                ErrorBean errorBean = gson.fromJson(json, ErrorBean.class);
                                if (errorBean.getCode().equals("1")) {
                                    ToasShow.showToastCenter(CusOprateRecordActivity.this, errorBean
                                            .getMsg());
                                }

                            } catch (JsonSyntaxException e) {

                                Log.e("解析异常", "e:" + e.getMessage());
                            }


                        }


                    }
                });


    }

    private void getReservertData(int page, final boolean isRel) {
        EasyHttp.get(Contants.RESERVER_RECORDER_LIST).cacheMode(CacheMode.DEFAULT).headers
                ("Cache-Control", "max-age=0").timeStamp(true).params("user_id",
                SharedPreferencesHelps.getUserID()).params("customer_id", customeId).params
                ("page", String.valueOf(page)).params("number", "100").execute(new SimpleCallBack<String>() {
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

                closeDialog();

                if (json != null) {

                    try {


                        Gson gson = new Gson();
                        SubscribeListBean slb = gson.fromJson(json, SubscribeListBean.class);
                        if (slb.getCode().equals("1")) {
                            rbList = slb.getResult();
                        }


                        if (isRel) {
                            if (rbList.size() == 0) {
                                getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                                listView.setVisibility(View.GONE);
                            } else {
                                getViewById(R.id.noInfomation).setVisibility(View.GONE);
                                listView.setVisibility(View.VISIBLE);
                            }
                            subscribeAdapter = new CommonAdapter<SubscribeListBean.ResultBean>
                                    (CusOprateRecordActivity.this, rbList, R.layout
                                            .reserver_listview_item_layout) {
                                @Override
                                public void convert(ViewHolder holder, SubscribeListBean
                                        .ResultBean item) {
                                    holder.setText(R.id.tvSubscribeTime, MyUtils.date2String
                                            ("MM/dd " +
                                                    "HH:mm", item.getOrder_time() * 1000));
                                    holder.setText(R.id.tvSubscribeContent, item.getContent());
                                }
                            };

                            listView.setAdapter(subscribeAdapter);
                            initMenuListView();
                        } else {
                            subscribeAdapter.addMore(rbList);
                        }

                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                        Log.e("解析异常", "e:" + e.getMessage());
                    }


                }


            }
        });


    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;

        if (flag.equals("custovisit")) {
            getVisitData(page, true);
        } else if (flag.equals("custoreser")) {
            getReservertData(page, true);
        }

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        if (flag.equals("custovisit")) {
            getVisitData(page, false);
        } else if (flag.equals("custoreser")) {
            getReservertData(page, false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDialog();
    }


}
