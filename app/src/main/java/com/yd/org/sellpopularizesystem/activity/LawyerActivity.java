package com.yd.org.sellpopularizesystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.LawyerAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.Lawyer;
import com.yd.org.sellpopularizesystem.myView.SearchEditText;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.GetLawyerNameSort;
import com.yd.org.sellpopularizesystem.utils.LawyerComparator;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LawyerActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private SearchEditText searchEditText;
    private LawyerAdapter lawyerAdapter;
    //律师组集合
    private List<Lawyer.ResultBean> lawyerGroupListData = new ArrayList<>();
    //律师集合
    private List<Lawyer.ResultBean.LawyerListBean> lawyerListData = new ArrayList<>();
    /**
     * 分组的布局
     */
    private LinearLayout titleLayout;
    /**
     * 分组上显示的字母
     */
    private TextView title;
    /**
     * 上次第一个可见元素，用于滚动时记录标识。
     */
    private int lastFirstVisibleItem = -1;
    //搜索相关
    private GetLawyerNameSort countryChangeUtil;
    private LawyerComparator pinyinComparator;
    public static LawyerActivity lawyerActivity;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == ExtraName.UPDATE) {
                getLawyerListData("", true);
            }
        }
    };

    @Override
    protected int setContentView() {
        lawyerActivity = this;
        return R.layout.activity_lawyer;
    }

    @Override
    public void initView() {
        setTitle(getString(R.string.selectlawyer));
        searchEditText = getViewById(R.id.activity_main_input_edittext);
        searchEditText.addTextChangedListener(textWatcher);
        titleLayout = getViewById(R.id.lltitle);
        title = getViewById(R.id.title);
        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);

        pinyinComparator = new LawyerComparator();
        countryChangeUtil = new GetLawyerNameSort();
        getLawyerListData("", true);
    }


    /**
     * 获取律师列表
     */
    private void getLawyerListData(String customeId, final boolean b) {
        EasyHttp.get(Contants.LAWYER_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("customer_id", "")
                .params("law_firm", "")
                .params("company_id", "")
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

    private void jsonParse(String json, boolean isRefresh) {

        try {
            Gson gson = new Gson();
            Lawyer lawyerBean = gson.fromJson(json, Lawyer.class);
            if (lawyerBean.getCode() == 1) {
                lawyerGroupListData = lawyerBean.getResult();
                for (int i = 0; i < lawyerGroupListData.size(); i++) {
                    for (int j = 0; j < lawyerGroupListData.get(i).getLawyer_list().size(); j++) {
                        Lawyer.ResultBean.LawyerListBean lawyer = lawyerGroupListData.get(i).getLawyer_list().get(j);
                        if (lawyer.getLaw_firm().equals("")) {
                            lawyer.setLaw_firm("null");
                        }
                        lawyerListData.add(lawyer);
                    }
                }
            }
            if (isRefresh) {
                Collections.sort(lawyerListData, pinyinComparator);
                lawyerAdapter = new LawyerAdapter(LawyerActivity.this, lawyerListData);
                listView.setAdapter(lawyerAdapter);
                setScrollListener();
            } else {
                lawyerAdapter.notifyDataSetChanged();


            }

        } catch (JsonSyntaxException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void setListener() {

        changeLeftImageView(R.mipmap.close, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, R.anim.out_anim);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 这里要利用adapter.getItem(position)来获取当前position所对应的对象
                Intent intent = new Intent();
                intent.putExtra("lawyer", lawyerListData.get(position));
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

        clickRightImageView(R.mipmap.addim, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitySkip.forward(LawyerActivity.this, LawyerAddActivity.class);
            }
        });


    }

    private void setScrollListener() {

        if (lawyerListData.size() > 0) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                    try {

                        int section = 0;
                        int nextSecPosition = 0;

                        section = lawyerAdapter.getSectionForPosition(firstVisibleItem);
                        nextSecPosition = lawyerAdapter.getPositionForSection(section + 1);

                        if (firstVisibleItem != lastFirstVisibleItem) {
                            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout.getLayoutParams();
                            params.topMargin = 0;
                            titleLayout.setLayoutParams(params);
                            if (firstVisibleItem == 0) {
                                title.setVisibility(View.GONE);
                            } else {
                                title.setVisibility(View.VISIBLE);
                                title.setText(lawyerAdapter.getSectionHeaders()[section]);

                            }
                        }

                        if (nextSecPosition == firstVisibleItem + 1) {
                            View childView = view.getChildAt(0);
                            if (childView != null) {
                                int titleHeight = titleLayout.getHeight();
                                int bottom = childView.getBottom();
                                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout
                                        .getLayoutParams();
                                if (bottom < titleHeight) {
                                    float pushedDistance = bottom - titleHeight;
                                    //params.topMargin = (int) pushedDistance;
                                    titleLayout.setLayoutParams(params);
                                } else {
                                    if (params.topMargin != 0) {
                                        params.topMargin = 0;
                                        titleLayout.setLayoutParams(params);
                                    }
                                }
                            }
                        }

                        lastFirstVisibleItem = firstVisibleItem;
                    } catch (NullPointerException e) {
                        e.printStackTrace();

                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();

                    }


                }
            });
        }
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s != null && s.length() > 0) {

            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String strSearch = searchEditText.getText().toString();
            if (strSearch.length() > 0) {
                ArrayList<Lawyer.ResultBean.LawyerListBean> fileterList = (ArrayList<Lawyer.ResultBean.LawyerListBean>) countryChangeUtil
                        .search(strSearch, lawyerListData);
                lawyerAdapter.updateListView(fileterList);


            } else {
                lawyerAdapter.updateListView(lawyerListData);
            }
            listView.setSelection(0);
        }
    };

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);

    }


}
