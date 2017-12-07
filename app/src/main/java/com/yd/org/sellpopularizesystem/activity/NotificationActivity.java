package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.CommonAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ViewHolder;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.AnnouncementBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import static com.igexin.push.extension.mod.SecurityUtils.b;

public class NotificationActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private List<AnnouncementBean.ResultBean> informationContents = new ArrayList<>();
    private CommonAdapter adapter;
    private int page = 1;

    @Override
    protected int setContentView() {
        return R.layout.activity_notification;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle(getResources().getString(R.string.setting_notification));
        //下拉加载
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);

        getData(1, true);

    }

    private void getData(int page, final boolean isRefresh) {

        EasyHttp.get(Contants.SYSTEM_ANNOUNCEMENT)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("user_id", SharedPreferencesHelps.getUserID())
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
                        if (null != json) {
                            jsonParse(json, b);
                        }

                    }
                });


    }

    private void jsonParse(String s, boolean isRefresh) {
        try {

            Gson gson = new Gson();
            AnnouncementBean bean = gson.fromJson(s, AnnouncementBean.class);
            if (bean.getCode().equals("1")) {
                informationContents = bean.getResult();
                Log.e("inform", "jsonParse: " + informationContents.toString());
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        if (isRefresh) {

            adapter = new CommonAdapter<AnnouncementBean.ResultBean>(this, informationContents, R.layout.notification_listview_item) {
                @Override
                public void convert(ViewHolder holder, AnnouncementBean.ResultBean item) {
                    holder.setText(R.id.tvMessageTitle, item.getTitle());
                    if (item.getIs_read() == 1) {
                        holder.getView(R.id.tvPoint).setVisibility(View.INVISIBLE);
                    } else {
                        holder.getView(R.id.tvPoint).setVisibility(View.VISIBLE);
                    }
                }
            };
            listView.setAdapter(adapter);
        } else {
            adapter.addMore(informationContents);
        }


    }

    @Override
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AnnouncementBean.ResultBean resultBean = (AnnouncementBean.ResultBean) adapter.getItem(position);

                Bundle bundle = new Bundle();
                bundle.putString("data", resultBean.getContent());
                bundle.putString("title", resultBean.getTitle());
                bundle.putString("notice_id", resultBean.getId() + "");
                ActivitySkip.forward(NotificationActivity.this, InformationContentActivity.class, bundle);
            }
        });
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getData(page, true);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        // 千万别忘了告诉控件刷新完毕了哦！
        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getData(page, false);

    }
}
