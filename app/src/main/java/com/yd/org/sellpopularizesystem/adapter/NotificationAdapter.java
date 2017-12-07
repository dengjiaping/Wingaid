package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.AnnouncementBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by e-dot on 2017/5/2.
 */

public class NotificationAdapter extends BaseAdapter {
    private List<AnnouncementBean.ResultBean> informationtents = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mLayout;
    // 用来控制CheckBox的选中状况
    private static HashMap<Integer, Boolean> isSelected;
    private Boolean isShow = false;


    public NotificationAdapter(Context mContext, boolean isShow) {
        this.isShow = isShow;
        this.mContext = mContext;
        this.mLayout = LayoutInflater.from(mContext);
        isSelected = new HashMap<>();

    }

    public List<AnnouncementBean.ResultBean> getInformationtents() {
        return informationtents;
    }

    public void setInformationtents(List<AnnouncementBean.ResultBean> informationtents) {
        this.informationtents = informationtents;
    }

    public void setsShowI(Boolean isShow) {
        this.isShow = isShow;
        notifyDataSetChanged();

    }

    public void addMore(List<AnnouncementBean.ResultBean> informationtents) {
        this.informationtents.addAll(informationtents);
        // 初始化数据
        initDatas();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return informationtents.size();
    }

    // 初始化isSelected的数据
    private void initDatas() {
        for (int i = 0; i < informationtents.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

    @Override
    public Object getItem(int position) {
        return informationtents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler = null;
        if (convertView == null) {
            viewHoler = new ViewHoler();
            convertView = mLayout.inflate(R.layout.notification_listview_item, null);
            viewHoler.tvMessage = (TextView) convertView.findViewById(R.id.tvMessageTitle);
            viewHoler.tvPoint = (TextView) convertView.findViewById(R.id.tvPoint);
            viewHoler.check_box = (CheckBox) convertView.findViewById(R.id.check_box);
            viewHoler.relNotic = (LinearLayout) convertView.findViewById(R.id.relNotic);
            convertView.setTag(viewHoler);
        } else {
            viewHoler = (ViewHoler) convertView.getTag();
        }
        viewHoler.resultBean = informationtents.get(position);


        try {

            viewHoler.tvMessage.setText(informationtents.get(position).getTitle());


            //已读
            if (informationtents.get(position).getIs_read() == 1) {
                viewHoler.tvMessage.setTextColor(mContext.getResources().getColor(R.color.gray));
                viewHoler.tvPoint.setVisibility(View.GONE);
            } else {
                viewHoler.tvMessage.setTextColor(mContext.getResources().getColor(R.color.black));
                viewHoler.tvPoint.setVisibility(View.VISIBLE);
            }

            // 将数据填充到当前convertView的对应控件中
            if (isShow) {
                viewHoler.check_box.setVisibility(View.VISIBLE);
            } else {
                viewHoler.check_box.setVisibility(View.GONE);
            }


            // 根据isSelected来设置checkbox的选中状况
            if (null != getIsSelected().get(position)) {
                viewHoler.check_box.setChecked(getIsSelected().get(position));
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        NotificationAdapter.isSelected = isSelected;
    }


    public static class ViewHoler {
        public LinearLayout relNotic;
        public TextView tvMessage, tvPoint;
        public CheckBox check_box;
        public AnnouncementBean.ResultBean resultBean;


    }
}
