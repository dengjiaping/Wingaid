package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.PromotionRecordBean;
import com.yd.org.sellpopularizesystem.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-dot on 2017/5/15.
 */

public class PromotionRecordAdapter extends BaseAdapter {
    private List<PromotionRecordBean.ResultBean> datas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;

    public PromotionRecordAdapter(Context mContext) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    public void addMore(List<PromotionRecordBean.ResultBean> data) {
        this.datas.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
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
            convertView = layoutInflater.inflate(R.layout.promotionrecord_list, null);
            viewHoler.tvPromDate = (TextView) convertView.findViewById(R.id.tvPromDate);
            viewHoler.tvPromTitle = (TextView) convertView.findViewById(R.id.tvPromTitle);
            viewHoler.tvPromLong = (TextView) convertView.findViewById(R.id.tvPromLong);
            viewHoler.promtionLinear = (LinearLayout) convertView.findViewById(R.id.promtionLinear);

            convertView.setTag(viewHoler);

        } else {
            viewHoler = (ViewHoler) convertView.getTag();
        }
        viewHoler.resultBean = datas.get(position);

        try {

            viewHoler.promtionLinear.setVisibility(View.GONE);
            viewHoler.tvPromDate.setText(MyUtils.getInstance().date2String("yyyy/MM/dd", Long.parseLong(datas.get(position).getAdd_time() + "000")));
            viewHoler.tvPromTitle.setText(datas.get(position).getProduct_name());
            viewHoler.tvPromLong.setText(datas.get(position).getStay_time());

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return convertView;
    }


    public class ViewHoler {
        public PromotionRecordBean.ResultBean resultBean;
        private TextView tvPromDate, tvPromTitle, tvPromLong;
        private LinearLayout promtionLinear;
    }
}
