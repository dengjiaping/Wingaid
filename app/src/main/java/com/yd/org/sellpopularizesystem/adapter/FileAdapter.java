package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-dot on 2017/5/15.
 */

public class FileAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ProductDetailBean.ResultBean.FileContentBean> file_content = new ArrayList<>();

    public FileAdapter(Context mContext, List<ProductDetailBean.ResultBean.FileContentBean> file_content) {
        this.mContext = mContext;
        this.file_content = file_content;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return file_content.size();
    }

    @Override
    public Object getItem(int position) {
        return file_content.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder=new ViewHolder();
            convertView = inflater.inflate(R.layout.file_item, null);
            viewHolder.tvFilfeTitle = (TextView) convertView.findViewById(R.id.tvFilfeTitle);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.fileContent = file_content.get(position);

        try {

            viewHolder.tvFilfeTitle.setText(file_content.get(position).getDetail_name());

        }catch (NullPointerException e){
            e.printStackTrace();
        }


        return convertView;
    }

    public class ViewHolder {
        public ProductDetailBean.ResultBean.FileContentBean fileContent;
        private TextView tvFilfeTitle;
    }
}
