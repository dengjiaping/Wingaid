package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yd.org.sellpopularizesystem.application.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ${bai} on 17/2/13.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas = new ArrayList<T>(), list = new ArrayList<T>();
    protected final int mItemLayoutId;
    private boolean isClick = false;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    public CommonAdapter(Context context, T[] array, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = Arrays.asList(array);
        this.mItemLayoutId = itemLayoutId;
    }

    public void adapterNotify() {
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // Log.e("log", "-----getCount()-----" + mDatas.size());
        return mDatas == null ? 0 : mDatas.size();
    }

    public void addMore(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void CleaDates(List<T> datas) {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder holder, T item);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        this.isClick = click;
    }
}
