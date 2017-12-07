package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

public class SortGroupMemberAdapter extends BaseAdapter implements SectionIndexer {
    private List<CustomBean.ResultBean> list = new ArrayList<>();
    private Context mContext;
    private Drawable drawable;

    public SortGroupMemberAdapter(Context mContext) {
        this.mContext = mContext;


    }


    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<CustomBean.ResultBean> list) {

        this.list = list;
        notifyDataSetChanged();
    }

    public void addMore(List<CustomBean.ResultBean> datas) {
        this.list.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        return this.list.size();

    }

    @Override
    public Object getItem(int position) {
        return list.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.activity_group_member_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.customName);
            viewHolder.tvNickName = (TextView) view.findViewById(R.id.tvNickName);
            viewHolder.tvLetter = (TextView) view.findViewById(R.id.catalog);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.customImageiView);
            view.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) view.getTag();

        }


        viewHolder.resultBean = list.get(position);

        try {

            // 根据position获取分类的首字母的Char ascii值
            int section = getSectionForPosition(position);


            // 如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
            if (position == getPositionForSection(section)) {
                viewHolder.tvLetter.setVisibility(View.VISIBLE);
                viewHolder.tvLetter.setText(viewHolder.resultBean.getSortLetters());
            } else {
                viewHolder.tvLetter.setVisibility(View.GONE);
            }

            viewHolder.tvNickName.setText(list.get(position).getEn_name().equals("") ? "" : list.get(position).getEn_name());

            if (!TextUtils.isEmpty(list.get(position).getFirst_name()) && list.get(position).getFirst_name().equals("--") || !TextUtils.isEmpty(list.get(position).getSurname()) && list.get(position).getSurname().equals("--") || !TextUtils.isEmpty(list.get(position).getFirst_name()) && list.get(position).getFirst_name().equals("-") || !TextUtils.isEmpty(list.get(position).getSurname()) && list.get(position).getSurname().equals("-")) {
                viewHolder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.read));
            } else {
                viewHolder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.gray));
            }


            if (TextUtils.isEmpty(list.get(position).getMid_name()) || list.get(position).getMid_name() == null) {
                viewHolder.tvTitle.setText(list.get(position).getSurname() + mContext.getString(R.string.single_blank_space) + list.get(position).getFirst_name());

            } else {
                viewHolder.tvTitle.setText(list.get(position).getSurname() + mContext.getString(R.string.single_blank_space) + list.get(position).getMid_name() + mContext.getString(R.string.single_blank_space) + list.get(position).getFirst_name());

            }

            if (!TextUtils.isEmpty(list.get(position).getHead_img()) && list.get(position).getHead_img() != null && list.get(position).getHead_img() != "") {
                BitmapUtil.loadImageView(mContext, Contants.DOMAIN + "/" + list.get(position).getHead_img(), viewHolder.imageView);
                Log.e("imageview", "tt:" + Contants.DOMAIN + "/" + list.get(position).getHead_img());

            } else {
                if (drawable == null) {
                    drawable = ContextCompat.getDrawable(mContext, R.mipmap.settingbt);
                }
                viewHolder.imageView.setImageDrawable(drawable);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return view;

    }

    public static class ViewHolder {
        public TextView tvLetter;
        public TextView tvTitle, tvNickName;
        public ImageView imageView;
        public CustomBean.ResultBean resultBean;

    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char ascii值
     */

    @Override
    public int getSectionForPosition(int position) {
        return list.get(position).getSortLetters().charAt(0);

    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    @Override
    public int getPositionForSection(int section) {

        try {
            String sortStr;
            for (int i = 0; i < getCount(); i++) {
                sortStr = list.get(i).getSortLetters();
                char firstChar = sortStr.toUpperCase().charAt(0);
                if (firstChar == section) {
                    return i;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return -1;
    }


    @Override
    public Object[] getSections() {
        return null;
    }
}