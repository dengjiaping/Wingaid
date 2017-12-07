package com.yd.org.sellpopularizesystem.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.ProductItemDetailActivity;
import com.yd.org.sellpopularizesystem.activity.ProductSubunitListActivity;
import com.yd.org.sellpopularizesystem.activity.ScaleActivity;
import com.yd.org.sellpopularizesystem.activity.StudySubitemActivity;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.MyUtils;
import com.yd.org.sellpopularizesystem.utils.ToasShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/3/28.
 */

public class CustomeListAdapter extends BaseAdapter {
    private Context mContext;
    private List<ProductListBean.ResultBean> list = new ArrayList<>();// 数据
    private LayoutInflater inflater;

    public CustomeListAdapter(Activity mContext) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 新增数据并刷新数据
     *
     * @param list
     */
    public void addData(List<ProductListBean.ResultBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_layout, null);
            viewHolder.prductImageView = (ImageView) convertView.findViewById(R.id.prductImageView);
            viewHolder.ivLockImageView = (ImageView) convertView.findViewById(R.id.ivIslock);
            viewHolder.productName = (TextView) convertView.findViewById(R.id.productName);
            viewHolder.lvSubItem = (ListView) convertView.findViewById(R.id.lvSubItem);
            viewHolder.rlViewAll = (RelativeLayout) convertView.findViewById(R.id.rlViewAll);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.productListBean = list.get(position);


        try {

            BitmapUtil.loadImageView(mContext, Contants.DOMAIN + "/" + list.get(position).getThumb(), viewHolder.prductImageView);

            viewHolder.productName.setText(list.get(position).getProduct_name().trim());
            viewHolder.lvSubItem.setAdapter(new ItemAdapter(mContext, viewHolder.productListBean.getChilds()));


            //根据getIs_can_sale(),getIs_study()判断是否需要学习
            if ((list.get(position).getIs_can_sale().equals("1") && (list.get(position).getIs_study() == 0 || list.get(position).getIs_study() == 1))) {

                viewHolder.ivLockImageView.setVisibility(View.VISIBLE);
                viewHolder.lvSubItem.setVisibility(View.GONE);
                viewHolder.rlViewAll.setVisibility(View.GONE);
                viewHolder.prductImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //对应的学习项目
                        ToasShow.showToastCenter(mContext, mContext.getString(R.string.sale_toas) + list.get(position).getProduct_name());
                        Bundle bundle = new Bundle();
                        bundle.putString("type_id", String.valueOf(list.get(position).getStudy_type_id()));
                        ActivitySkip.forward((Activity) mContext, StudySubitemActivity.class, bundle);
                    }
                });
            } else {
                viewHolder.ivLockImageView.setVisibility(View.GONE);
                viewHolder.lvSubItem.setVisibility(View.VISIBLE);
                viewHolder.rlViewAll.setVisibility(View.VISIBLE);
                //点击查看单个item
                viewHolder.prductImageView.setOnClickListener(new MyOnClick(position, viewHolder.productListBean, ProductItemDetailActivity.class, viewHolder.productListBean.getProduct_name(), viewHolder.productListBean.getProduct_id() + ""));
                //点击查看所有
                viewHolder.rlViewAll.setOnClickListener(new MyOnClick(position, viewHolder.productListBean.getChilds(), ProductSubunitListActivity.class, viewHolder.productListBean.getProduct_name(), viewHolder.productListBean.getProduct_id() + ""));
                //产品子单元listview点击
                viewHolder.lvSubItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                        BaseApplication.getInstance().setIs_firb(list.get(position).getIs_firb());
                        BaseApplication.getInstance().setFirb_number(list.get(position).getFirb_number());
                        ScaleActivity.scaleActivity.goTo(list.get(position).getChilds().get(p), ProductSubunitListActivity.class, list.get(position).getProduct_name().toLowerCase(), list.get(position).getProduct_id() + "");
                    }
                });


            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return convertView;
    }


    private class MyOnClick implements View.OnClickListener {
        private Object mObject;
        private Class<?> mClass;
        private String title;
        private String productId;
        private int postion;

        public MyOnClick(int postions, Object mObject, Class<?> mClass, String title, String productId) {
            this.postion = postions;
            BaseApplication.getInstance().setIs_firb(list.get(postion).getIs_firb());
            BaseApplication.getInstance().setFirb_number(list.get(postion).getIs_firb());
            this.mObject = mObject;
            this.mClass = mClass;
            this.title = title;
            this.productId = productId;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.prductImageView:
                    ScaleActivity.scaleActivity.goTo(mObject, mClass, title, productId);
                    break;
                case R.id.rlViewAll:
                    ScaleActivity.scaleActivity.goTo(mObject, mClass, title, productId);
                    break;

            }
        }
    }


    public class ViewHolder {
        private ImageView prductImageView, ivLockImageView;
        private TextView productName;
        private ListView lvSubItem;
        private RelativeLayout rlViewAll;
        public ProductListBean.ResultBean productListBean;
    }

    class ItemAdapter extends BaseAdapter {
        private Context mItemContext;
        private List<ProductListBean.ResultBean.ChildsBean> childs = new ArrayList<>();
        private LayoutInflater inflater;

        public ItemAdapter(Context mContext, List<ProductListBean.ResultBean.ChildsBean> childs) {
            this.mItemContext = mContext;
            this.childs = childs;
            this.inflater = LayoutInflater.from(mItemContext);
        }

        @Override
        public int getCount() {
            return childs.size();
        }

        @Override
        public ProductListBean.ResultBean.ChildsBean getItem(int position) {
            return childs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder1 holder1 = null;
            if (convertView == null) {
                holder1 = new Holder1();
                convertView = inflater.inflate(R.layout.product_listview_item_sublay, null);
                holder1.tvPriceRange = (TextView) convertView.findViewById(R.id.tvPriceRange);
                holder1.tvHouse = (TextView) convertView.findViewById(R.id.tvHouse);
                holder1.tvBathroom = (TextView) convertView.findViewById(R.id.tvBathroom);
                holder1.tvCar = (TextView) convertView.findViewById(R.id.tvCar);
                convertView.setTag(holder1);
            } else {
                holder1 = (Holder1) convertView.getTag();
            }
            holder1.childBean = childs.get(position);


            try {

                if (Math.ceil(Double.parseDouble(holder1.childBean.getMin_price())) / 1000 < 1) {
                    holder1.tvPriceRange.setText("$" + mContext.getString(R.string.single_blank_space) + "1k"
                            + mContext.getString(R.string.single_blank_space) + "to" + mContext.getString(R.string.single_blank_space) + "$"
                            + mContext.getString(R.string.single_blank_space) + MyUtils.addComma(String.valueOf(Math.ceil(Double.parseDouble(holder1.childBean.getMax_price())) / 1000).split("\\.")[0]) + "k");
                } else {
                    holder1.tvPriceRange.setText("$" + mContext.getString(R.string.single_blank_space) +
                            MyUtils.addComma(String.valueOf(Math.ceil(Double.parseDouble(holder1.childBean.getMin_price())) / 1000).split("\\.")[0]) + "k"
                            + mContext.getString(R.string.single_blank_space) + "to" + mContext.getString(R.string.single_blank_space) + "$"
                            + mContext.getString(R.string.single_blank_space) + MyUtils.addComma(String.valueOf(Math.ceil(Double.parseDouble(holder1.childBean.getMax_price())) / 1000).split("\\.")[0]) + "k");
                }

                holder1.tvHouse.setText(holder1.childBean.getBedroom());
                holder1.tvBathroom.setText(holder1.childBean.getBathroom());
                holder1.tvCar.setText(holder1.childBean.getCar_space());
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }


            return convertView;
        }

        class Holder1 {
            private TextView tvPriceRange, tvHouse, tvBathroom, tvCar;
            public ProductListBean.ResultBean.ChildsBean childBean;

        }
    }

}
