package com.yd.org.sellpopularizesystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.MySalesAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.custom.CharacterParser;
import com.yd.org.sellpopularizesystem.custom.PinyinComparatorSalers;
import com.yd.org.sellpopularizesystem.custom.SideBar;
import com.yd.org.sellpopularizesystem.internal.PullToRefreshLayout;
import com.yd.org.sellpopularizesystem.internal.PullableListView;
import com.yd.org.sellpopularizesystem.javaBean.ReferUserBean;
import com.yd.org.sellpopularizesystem.myView.SearchEditText;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySalesActivity extends BaseActivity implements SectionIndexer, PullToRefreshLayout.OnRefreshListener {
    private PullableListView listView;
    private PullToRefreshLayout ptrl;
    private int page = 1;
    private SideBar sideBar;
    private TextView dialog;
    private MySalesAdapter adapter;
    private LinearLayout titleLayout;
    private TextView tvNofriends;
    private SearchEditText searchEditText;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<ReferUserBean.ResultBean> SourceDateList = new ArrayList<>();

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparatorSalers pinyinComparator;
    //用以判断跳转不同界面

    private List filterDateList;


    @Override
    protected int setContentView() {
        return R.layout.activity_custome;
    }

    @Override
    public void initView() {
        hideRightImagview();
        setTitle("选择销售");

        initViews();

        //网络数据
        getCustomeListData(true, page);


    }


    private void initViews() {

        searchEditText = getViewById(R.id.activity_main_input_edittext);
        titleLayout = getViewById(R.id.title_layout);
        tvNofriends = getViewById(R.id.noInfomation);
        // 实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparatorSalers();

        sideBar = getViewById(R.id.sidrbar);
        dialog = getViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        ptrl = getViewById(R.id.refresh_view);
        ptrl.setOnRefreshListener(this);
        listView = getViewById(R.id.content_view);


    }

    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List filledData(List date) {
        List list = new ArrayList();
        List<ReferUserBean.ResultBean> mSortList = new ArrayList<>();
        for (int i = 0; i < date.size(); i++) {
            ReferUserBean.ResultBean sortModel = (ReferUserBean.ResultBean) date.get(i);
            // 汉字转换成拼音
            if (!TextUtils.isEmpty(sortModel.getSurname())) {
                String pinyin = characterParser.getSelling(sortModel.getSurname());
                String sortString = pinyin.substring(0, 1).toUpperCase();
                // 正则表达式，判断首字母是否是英文字母
                if (sortString.matches("[A-Z]")) {
                    sortModel.setSortLetters(sortString.toUpperCase());
                } else {
                    sortModel.setSortLetters("#");
                }
                mSortList.add(sortModel);
            }
        }
        list.clear();
        list.addAll(mSortList);
        return list;

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        if (TextUtils.isEmpty(filterStr)) {
            tvNofriends.setVisibility(View.GONE);
            adapter.updateListView(SourceDateList);
        } else {
            filterDateList = new ArrayList<>();
            for (ReferUserBean.ResultBean sortModel : SourceDateList) {
                String name = sortModel.getSurname();
                if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr) || characterParser.getSelling(name).startsWith(filterStr.toUpperCase())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        adapter.updateListView(filterDateList);
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
        return SourceDateList.get(position).getSortLetters().charAt(0);

    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < SourceDateList.size(); i++) {
            String sortStr = SourceDateList.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    private void getCustomeListData(final boolean b, int page) {

        EasyHttp.get(Contants.REFER_USER_LIST)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params("refer_id", SharedPreferencesHelps.getUserID())
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
                        Log.e("onSuccess", "onSuccess:" + json);
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
            //客户信息
            ReferUserBean product = gson.fromJson(json, ReferUserBean.class);
            if (product.getCode() == 1) {
                SourceDateList = filledData(product.getResult());
            }


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
                adapter = new MySalesAdapter(this);
                adapter.addData(SourceDateList);
                listView.setAdapter(adapter);
            } else {
                adapter.addMore(SourceDateList);
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
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // 这个时候不需要挤压效果 就把他隐藏掉
                titleLayout.setVisibility(View.GONE);
                // 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (searchEditText.getText().toString().length() == 0) {
                    adapter.updateListView(SourceDateList);
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 这里要利用adapter.getItem(position)来获取当前position所对应的对象
                MySalesAdapter.ViewHolder viewHolder = (MySalesAdapter.ViewHolder) view.getTag();
                ReferUserBean.ResultBean resultBean = viewHolder.resultBean;
                Bundle bundle = new Bundle();
                Intent i = new Intent();
                i.putExtra("custome", resultBean);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });


    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        ptrl.refreshFinish(PullToRefreshLayout.SUCCEED);
        page = 1;
        getCustomeListData(true, page);
    }


    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

        page++;
        ptrl.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        getCustomeListData(false, page);
    }
}
