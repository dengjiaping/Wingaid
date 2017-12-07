package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ProductChildBean;
import com.yd.org.sellpopularizesystem.javaBean.ProductListBean;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bai on 2017/1/10.
 */

public class StorePopHousingAdapter extends BaseAdapter {

    protected List<ProductListBean.ResultBean> list = new ArrayList<>();// 数据
    protected Context mContext;// 上下文
    protected LayoutInflater getInflater;// 加载布局
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;

    public StorePopHousingAdapter(Context context) {
        this.mContext = context;
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
    public void addData(List<ProductListBean.ResultBean> list) {
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
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE1;
        } else {
            return TYPE2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        Holder1 holder1 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    holder = new Holder();
                    convertView = getInflater.inflate(R.layout.list_item_layout, null);
                    holder.prductImageView = (ImageView) convertView.findViewById(R.id.prductImageView);
                    holder.productName = (TextView) convertView.findViewById(R.id.productName);
                    convertView.setTag(holder);
                    break;
                case TYPE2:
                    holder1 = new Holder1();
                    convertView = getInflater.inflate(R.layout.product_listview_item2, null);
                    holder1.lvSubItem = (ListView) convertView.findViewById(R.id.lvSubItem);
                    convertView.setTag(holder);
                    break;
            }
            // holder.productDescription = (TextView) convertView.findViewById(R.id.productDescription);

        } else {
            switch (type) {
                case TYPE1:
                    holder = (Holder) convertView.getTag();
                    break;
                case TYPE2:
                    holder1 = (Holder1) convertView.getTag();
                    break;
            }
        }

        switch (type) {
            case TYPE1:
                holder.productListBean = list.get(position);
                BitmapUtil.loadImageView(mContext, Contants.DOMAIN + "/" + list.get(position).getThumb(), holder.prductImageView);
                holder.productName.setText(list.get(position).getProduct_name().trim());
                break;
            case TYPE2:
                // holder1.childs=list.get(position-1).getChilds();
                Log.e("TAG", "TYPE2: " + holder1.childs.size());
                holder1.lvSubItem.setAdapter(new ItemAdapter(mContext, holder1.childs));
                break;
        }

        // holder.productDescription.setText(Parse.getInstance().replaceBlank(list.get(position).getDescription()+""));
        return convertView;
    }

    public class Holder {
        private ImageView prductImageView;
        private TextView productName, productDescription;
        public ProductListBean.ResultBean productListBean;

    }

    public class Holder1 {
        private List<ProductChildBean> childs = new ArrayList();
        private ListView lvSubItem;

    }

    class ItemAdapter extends BaseAdapter {
        private Context mItemContext;
        private List<ProductChildBean> childs = new ArrayList<>();
        private LayoutInflater inflater;

        public ItemAdapter(Context mContext, List<ProductChildBean> childs) {
            this.mItemContext = mContext;
            this.childs = childs;
            this.inflater = LayoutInflater.from(mItemContext);
        }

        @Override
        public int getCount() {
            Log.e("TAG", "getCount: " + childs.size());
            return childs.size();
        }

        @Override
        public ProductChildBean getItem(int position) {
            return childs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder2 holder2 = null;
            if (convertView == null) {
                holder2 = new Holder2();
                convertView = inflater.inflate(R.layout.product_listview_item_sublay, null);
                holder2.tvPriceRange = (TextView) convertView.findViewById(R.id.tvPriceRange);
                holder2.tvHouse = (TextView) convertView.findViewById(R.id.tvHouse);
                holder2.tvBathroom = (TextView) convertView.findViewById(R.id.tvBathroom);
                holder2.tvCar = (TextView) convertView.findViewById(R.id.tvCar);
                convertView.setTag(holder2);
            } else {
                holder2 = (Holder2) convertView.getTag();
            }
            holder2.childBean = childs.get(position);

            try {
                holder2.tvPriceRange.setText(holder2.childBean.getCate_id() + "");
                holder2.tvHouse.setText(holder2.childBean.getBedroom());
                holder2.tvBathroom.setText(holder2.childBean.getBathroom());
                holder2.tvCar.setText(holder2.childBean.getCar_space());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }


            return convertView;
        }

        public class Holder2 {
            private TextView tvPriceRange, tvHouse, tvBathroom, tvCar;
            public ProductChildBean childBean;

        }
    }

}
