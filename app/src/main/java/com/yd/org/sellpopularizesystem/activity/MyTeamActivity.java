package com.yd.org.sellpopularizesystem.activity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.TeamAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.TeamBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

public class MyTeamActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {

    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private TeamAdapter teamAdapter;
    //团队集合
    private List<TeamBean.ResultBean.SubBeanX> teamGroupListData = new ArrayList<>();
    /**
     * 分组的布局
     */

    private LinearLayout titleLayout;

    /**
     * 分组上显示的字母
     */
    private TextView title, tvNoInfo;
    /**
     * 上次第一个可见元素，用于滚动时记录标识。
     */
    private int lastFirstVisibleItem = -1;

    @Override
    protected int setContentView() {
        return R.layout.activity_myteam;
    }

    @Override
    public void initView() {
        setTitle(R.string.myteam);
        hideRightImagview();
        tvNoInfo = getViewById(R.id.tvNoInfo);
        titleLayout = getViewById(R.id.lltitle);
        title = getViewById(R.id.title);
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);
        getTeamListData("", true);
    }


    /**
     * 获取我的团队列表
     */
    private void getTeamListData(String s, final boolean b) {
        EasyHttp.get(Contants.TEAM_LIST).cacheMode(CacheMode.DEFAULT).headers("Cache-Control",
                "max-age=0").timeStamp(true).params("user_id", SharedPreferencesHelps.getUserID()
        ).execute(new SimpleCallBack<String>() {
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


    private void jsonParse(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            TeamBean tb = gson.fromJson(json, TeamBean.class);
            if (tb.getCode().equals("1")) {
                teamGroupListData = tb.getResult().getSub();

            }

            if (isRefresh) {

                if (teamGroupListData.size() == 0) {
                    getViewById(R.id.noInfomation).setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {
                    getViewById(R.id.noInfomation).setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }

                teamAdapter = new TeamAdapter(MyTeamActivity.this, teamGroupListData);
                listView.setAdapter(teamAdapter);

            }
            setListener();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void setListener() {
        if (teamGroupListData.size() > 0) {

            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int
                        visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem != lastFirstVisibleItem) {
                        Log.e("top***0", "LLL");
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams)
                                titleLayout.getLayoutParams();
                        params.topMargin = 0;
                        titleLayout.setLayoutParams(params);
                        if (firstVisibleItem == 0) {
                            title.setVisibility(View.GONE);
                            Log.e("top***1", "LLL");
                        } else {
                            Log.e("top***2", "LLL");
                            title.setVisibility(View.VISIBLE);
                            title.setText(teamGroupListData.get(firstVisibleItem).getSurname() +
                                    getString(R.string.single_blank_space) + teamGroupListData
                                    .get(firstVisibleItem).getFirstname() + " " + "-$" +
                                    teamGroupListData.get(firstVisibleItem).getCommission());

                        }
                    }

                    lastFirstVisibleItem = firstVisibleItem;
                }
            });
        }


    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
    }

}
