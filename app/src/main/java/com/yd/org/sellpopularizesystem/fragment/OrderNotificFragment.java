package com.yd.org.sellpopularizesystem.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.InformationContentActivity;
import com.yd.org.sellpopularizesystem.activity.SaleRecordActivity;
import com.yd.org.sellpopularizesystem.adapter.NotificationAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.AnnouncementBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.yd.org.sellpopularizesystem.adapter.NotificationAdapter.getIsSelected;


public class OrderNotificFragment extends BaseFragmentView implements PullToRefreshLayout.OnRefreshListener {
    public static OrderNotificFragment notificFragment;
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private List<AnnouncementBean.ResultBean> informationContents = new ArrayList<>();
    private List<AnnouncementBean.ResultBean> sumnData = new ArrayList<>();
    private NotificationAdapter adapter;
    private int page = 1;
    private int cate_id, type = 0;
    private boolean isShow = false;
    private AnnouncementBean.ResultBean resultBean;
    private int flag;
    private int firstVisibleItemPos;


    public Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                //全选
                case 0:
                    //全选,全不选
                    if (informationContents.size() > 0) {
                        if (msg.arg1 == 0) {
                            // 遍历list的长度，将MyAdapter中的map值全部设为true
                            for (int i = 0; i < informationContents.size(); i++) {
                                getIsSelected().put(i, true);
                            }

                        } else {
                            // 遍历list的长度，将MyAdapter中的map值全部设为true
                            for (int i = 0; i < informationContents.size(); i++) {
                                getIsSelected().put(i, false);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    break;


                //编辑,取消
                case 1:
                    isShow = (boolean) msg.obj;
                    type = msg.arg2;
                    //还原数据,默认全不选
                    if (null != adapter) {
                        //设置适配器用于是否显示checkBox
                        adapter.setsShowI(isShow);

                        for (int i = 0; i < informationContents.size(); i++) {
                            getIsSelected().put(i, false);
                        }
                        adapter.notifyDataSetChanged();

                    }
                    break;

                //删除
                case 2:
                    if (null != isSelected() && !isSelected().equals("")) {
                        Log.e("TAG", "执行删除操作 ");
                        deleteNoticeLog(isSelected());
                        type = msg.arg2;
                    } else {
                        if (isAdded()) {
                            ToasShow.showToastCenter(getActivity(), getString(R.string.select_not));
                        }
                        //ToasShow.showToastCenter(getActivity(), getString(R.string.select_not));
                        type = 1;
                    }

                    break;


                //查看已读
                case 3:
                    String notID = (String) msg.obj;
                    commitNotice(notID);

                    break;

            }
        }
    };


    /**
     * 创建实体类
     *
     * @param cate_id
     * @return
     */
    public static OrderNotificFragment getInstnce(int cate_id) {
        OrderNotificFragment notificFragmen = new OrderNotificFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cate_id", cate_id);
        notificFragmen.setArguments(bundle);
        return notificFragmen;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        notificFragment = this;
        setContentView(R.layout.fragment_notific);
        initViews();
        //获取数据
        Log.e(TAG, "initView: " + cate_id + ":" + informationContents.size());
        getData(1, true, cate_id);
    }

    private void initViews() {
        cate_id = getArguments().getInt("cate_id");
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);

    }

    private void getData(int pages, final boolean isRefresh, final int cate_id) {
        Log.e("cate_id", "cate_id: " + cate_id);
        EasyHttp.get(Contants.SYSTEM_ANNOUNCEMENT)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("cate_id", cate_id + "")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .params("page", String.valueOf(pages))
                .params("number", "1000")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        dismissLoadingDialog();
                        Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String json) {
                        dismissLoadingDialog();
                        jsonParse(json, isRefresh, cate_id);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        dismissLoadingDialog();
                    }
                });


    }


    private void jsonParse(String s, boolean isRefresh, int cate_id) {

        try {
            Gson gson = new Gson();
            AnnouncementBean bean = gson.fromJson(s, AnnouncementBean.class);
            if (bean.getCode().equals("1")) {
                if (informationContents.size() > 0) {
                    informationContents.clear();
                }
                informationContents.addAll(bean.getResult());
                sumnData.addAll(informationContents);
            }
            //通知首页加载消息数量
            HomeFragment.homeFragment.mHandler.sendEmptyMessage(1);
            int un_read = 0;
            if (bean.getTotal_number() > 0) {
                for (int i = 0; i < sumnData.size(); i++) {
                    if (sumnData.get(i).getIs_read() != 1) {
                        un_read += 1;
                    }
                }
                Log.e("jsonParse", "un_read: " + un_read);
                Message message = null;
                if (cate_id == 4) {
                    message = new Message();
                    message.what = 0;
                    message.arg1 = un_read;
                    Log.e("un_read", "orderNum: " + un_read);
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(0);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);

                } else if (cate_id == 3) {
                    message = new Message();
                    message.what = 1;
                    message.arg1 = un_read;
                    Log.e("un_read", "teamNum: " + un_read);
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(1);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                } else if (cate_id == 2) {
                    message = new Message();
                    message.what = 2;
                    message.arg1 = un_read;
                    Log.e("un_read", "comNum: " + un_read);
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(2);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                } else if (cate_id == 1) {
                    message = new Message();
                    message.what = 3;
                    message.arg1 = un_read;
                    Log.e("un_read", "systemNum: " + un_read);
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(3);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                }


            } else {
                Message message = null;
                if (cate_id == 4) {
                    message = new Message();
                    message.what = 0;
                    message.arg1 = 0;


                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(0);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);

                } else if (cate_id == 3) {
                    message = new Message();
                    message.what = 1;
                    message.arg1 = 0;
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(1);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                } else if (cate_id == 2) {
                    message = new Message();
                    message.what = 2;
                    message.arg1 = 0;
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(2);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                } else if (cate_id == 1) {
                    message = new Message();
                    message.what = 3;
                    message.arg1 = 0;
                    NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(3);
                    NotificationFragment.notificationFragment.mhandler.sendMessage(message);
                }

            }

            if (isRefresh) {
                if (informationContents.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }

                adapter = new NotificationAdapter(getActivity(), isShow);
                listView.setAdapter(adapter);

                //定位上一次的position位置
                if (flag == 1) {
                    listView.setSelection(firstVisibleItemPos);

                }

            }

            adapter.addMore(informationContents);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                resultBean = (AnnouncementBean.ResultBean) adapter.getItem(position);

                if (type == 1) {
                    // 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤
                    NotificationAdapter.ViewHoler holder = (NotificationAdapter.ViewHoler) view.getTag();
                    // 改变CheckBox的状态
                    holder.check_box.toggle();
                    // 将CheckBox的选中状况记录下来
                    getIsSelected().put(position, holder.check_box.isChecked());
                } else {
                    //隐藏红点
                    // 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤
                    NotificationAdapter.ViewHoler holder = (NotificationAdapter.ViewHoler) view.getTag();
                    holder.tvPoint.setVisibility(View.INVISIBLE);
                    holder.tvMessage.setTextColor(getResources().getColor(R.color.gray));


                    //发送消息已读
                    Message message = new Message();
                    message.what = 3;
                    message.obj = String.valueOf(resultBean.getId());
                    Log.e("notice_log_id", "onItemClick: " + resultBean.getId());
                    mHandle.sendMessage(message);

                    if (cate_id == 4) {
                        flag = 1;
                        //预定推送消息
                        Bundle bundle = new Bundle();
                        bundle.putString("saletoorder", "saletoorder");
                        bundle.putString("orderid", resultBean.getAbout_id() + "");
                        ActivitySkip.forward(getActivity(), SaleRecordActivity.class, bundle);
                    } else {
                        //预定推送消息
                        Bundle bundle = new Bundle();
                        bundle.putString("title", resultBean.getTitle());
                        bundle.putString("notice_id", resultBean.getId() + "");
                        bundle.putString("data", resultBean.getContent());

                        ActivitySkip.forward(getActivity(), InformationContentActivity.class, bundle);
                    }

                }
            }


        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                firstVisibleItemPos = firstVisibleItem;
            }
        });

    }

    /**
     * 删除预定通知
     *
     * @param notice_id
     */
    private void deleteNoticeLog(String notice_id) {
        Log.e("TAG", "deleteNoticeLog****: ");
        EasyHttp.get(Contants.DELETE_NOTICE)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("notice_logs_id", notice_id)
                .params("user_id", SharedPreferencesHelps.getUserID())

                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        type = 0;
                        ToasShow.showToastCenter(getActivity(), e.getMessage());
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onSuccess(String json) {

                        dismissLoadingDialog();

                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            if (jsonObject.getString("code").equals("1")) {
                                //如果删除成功,此时的状态是可以点击查看详情的
                                type = 0;
                                //发送删除成功消息
                                NotificationFragment.notificationFragment.mhandler.sendEmptyMessage(4);

                                if (sumnData != null) {
                                    sumnData.clear();
                                }
                                getData(1, true, cate_id);

                            }
                            ToasShow.showToastCenter(getActivity(), jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    /**
     * 判断是否选中
     *
     * @param
     */

    private String isSelected() {
        StringBuffer stringBuffer = new StringBuffer();
        if (adapter.getInformationtents().size() > 0) {
            for (int i = 0; i < adapter.getInformationtents().size(); i++) {
                if (getIsSelected().get(i)) {
                    stringBuffer.append(adapter.getInformationtents().get(i).getId() + ",");
                }
            }
            return stringBuffer.toString();
        }

        return null;
    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        flag = 0;
        if (sumnData != null) {
            sumnData.clear();
        }
        Log.e("onRefresh", "onRefresh: " + cate_id + "sumnData:" + sumnData.size());
        getData(page, true, cate_id);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        page++;
        flag = 0;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getData(page, false, cate_id);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }


    private void commitNotice(String str) {
        Log.e("notice_log_id", "commitNotice: " + str);
        EasyHttp.get(Contants.SUBMIT_READED)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("notice_logs_id", str)
                .params("user_id", SharedPreferencesHelps.getUserID())

                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        type = 0;
                        ToasShow.showToastCenter(getActivity(), e.getMessage());
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onSuccess(String json) {
                        Log.e("onSuccess", "onSuccess: ");
                        dismissLoadingDialog();
                        try {

                            HomeFragment.homeFragment.mHandler.sendEmptyMessage(1);
                            if (sumnData != null) {
                                sumnData.clear();
                            }
                            //获取数据
                            getData(1, true, cate_id);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                });


    }


}
