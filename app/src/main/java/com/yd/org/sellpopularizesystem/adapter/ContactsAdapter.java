package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.ContactsActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.CustomBean;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-dot on 2017/11/9.
 */

public class ContactsAdapter extends BaseAdapter implements SectionIndexer {
    private List<CustomBean.ResultBean> list = new ArrayList<>();
    private Context mContext;
    private Drawable drawable;

    public ContactsAdapter(Context mContext) {
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

            view = LayoutInflater.from(mContext).inflate(R.layout.activity_gcontacts_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.customName);
            viewHolder.addButton = (TextView) view.findViewById(R.id.addButton);
            viewHolder.addTextView = (TextView) view.findViewById(R.id.addTextView);
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

            if (!TextUtils.isEmpty(list.get(position).getSurname() + "")) {
                viewHolder.tvTitle.setText(list.get(position).getSurname() + "");

            } else {
                viewHolder.tvTitle.setText("###");

            }

            if (viewHolder.resultBean.isAdd()) {
                viewHolder.addButton.setVisibility(View.GONE);
                viewHolder.addTextView.setVisibility(View.VISIBLE);
            } else {
                viewHolder.addButton.setVisibility(View.VISIBLE);
                viewHolder.addTextView.setVisibility(View.GONE);


            }

            if (!TextUtils.isEmpty(list.get(position).getHead_img()) && list.get(position).getHead_img() != null && list.get(position).getHead_img() != "") {
                BitmapUtil.loadImageView(mContext, Contants.DOMAIN + "/" + list.get(position).getHead_img(), viewHolder.imageView);
            } else {
                if (drawable == null) {
                    drawable = ContextCompat.getDrawable(mContext, R.mipmap.settingbt);
                }
                viewHolder.imageView.setImageDrawable(drawable);
            }


            viewHolder.addButton.setOnClickListener(new AddOnClick(viewHolder.resultBean, viewHolder.addButton));

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return view;

    }

    public static class ViewHolder {
        public TextView tvTitle, addButton, addTextView, tvLetter;
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
        String sortStr;
        for (int i = 0; i < getCount(); i++) {
            sortStr = list.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }

        return -1;
    }


    @Override
    public Object[] getSections() {
        return null;
    }

    class AddOnClick implements View.OnClickListener {
        private TextView addButton;
        private CustomBean.ResultBean resultBean;

        public AddOnClick(CustomBean.ResultBean resultBean, TextView addButton) {
            this.addButton = addButton;
            this.resultBean = resultBean;

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.addButton:
                    ContactsActivity.mContactsActivity.addCustome(resultBean.getSurname() + "", resultBean.getMobile() + "");
                    break;
            }
        }
    }
}

