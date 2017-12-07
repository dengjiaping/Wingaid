package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ScaleListBean;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/2/21.
 */

public class ScaleListItemAdapter extends BaseAdapter {

    private List<ScaleListBean.ResultBean> list = new ArrayList<>();// 数据
    private Context context;// 上下文
    private LayoutInflater getInflater;// 加载布局


    public ScaleListItemAdapter(Context context) {
        this.context = context;
        this.getInflater = LayoutInflater.from(context);

    }


    /**
     * 返回数据长度
     *
     * @return
     */
    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }


    /**
     * 新增数据并刷新数据
     *
     * @param list
     */
    public void addData(List<ScaleListBean.ResultBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    /**
     * 返回项
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /**
     * 返回ID
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holder = null;
        ScaleListBean.ResultBean resultBean = list.get(position);
        if (convertView == null) {
            holder = new HolderView();
            convertView = getInflater.inflate(R.layout.study_item, null);
            holder.studyDisImageView = (ImageView) convertView.findViewById(R.id.studyDisImageView);
            holder.descriptionTextView = (TextView) convertView.findViewById(R.id.descriptionTextView);
            holder.lockImageView = (ImageView) convertView.findViewById(R.id.lockImageView);
            convertView.setTag(holder);
        } else {
            holder = (HolderView) convertView.getTag();
        }


        try {
            holder.lockImageView.setVisibility(View.GONE);
            BitmapUtil.loadImageView(context,Contants.DOMAIN + "/" + list.get(position).getThumb(),holder.studyDisImageView);
            holder.descriptionTextView.setText(resultBean.getProduct_name());

        }catch (NullPointerException e){
            e.printStackTrace();
        }

        return convertView;
    }

    public class HolderView {
        private ImageView studyDisImageView, lockImageView;
        private TextView descriptionTextView;
        public ScaleListBean.ResultBean productListBean;

    }
}
