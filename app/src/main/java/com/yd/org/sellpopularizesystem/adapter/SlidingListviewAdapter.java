package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.VisitRecord;
import com.yd.org.sellpopularizesystem.utils.MyUtils;

import java.util.List;

/**
 * Created by hejin on 2017/5/8.
 */

public class SlidingListviewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<VisitRecord.ResultBean> list;
    private int mRightViewWidth;

    public SlidingListviewAdapter(Context mContext, List<VisitRecord.ResultBean> list, int mRightViewWidth) {
        this.mContext = mContext;
        this.list = list;
        this.mRightViewWidth = mRightViewWidth;
        mInflater = LayoutInflater.from(mContext);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        onClick listener = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.visit_listview_item_layout, null);
            viewHolder = new ViewHolder();
            listener = new onClick();
            viewHolder.llLeft = (LinearLayout) convertView.findViewById(R.id.llLeft);
            //viewHolder.llRightDel= (LinearLayout) convertView.findViewById(R.id.llRightDel);
            viewHolder.tvVisitTime = (TextView) convertView.findViewById(R.id.tvVisitTime);
            viewHolder.tvVisitTitle = (TextView) convertView.findViewById(R.id.tvVisitTitle);
            viewHolder.tvVisitContent = (TextView) convertView.findViewById(R.id.tvVisitContent);
            //viewHolder.tvDelete= (TextView) convertView.findViewById(R.id.tvDel);
            //  this.mRightViewWidth=viewHolder.tvDelete.getWidth();
            viewHolder.tvDelete.setOnClickListener(listener);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        try {
            listener.setPosition(position);//传递position
            // 设置布局参数

            LinearLayout.LayoutParams lp_left = new LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT);
            viewHolder.llLeft.setLayoutParams(lp_left);
            LinearLayout.LayoutParams lp_right = new LinearLayout.LayoutParams(mRightViewWidth,
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT);
            viewHolder.llRightDel.setLayoutParams(lp_right);
            VisitRecord.ResultBean visitResultBean = list.get(position);
            viewHolder.tvVisitTime.setText(MyUtils.date2String("yyyy/MM/dd", visitResultBean.getAdd_time() * 1000));
            viewHolder.tvVisitTitle.setText(visitResultBean.getTitle());
            viewHolder.tvVisitContent.setText(visitResultBean.getContent());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    class onClick implements View.OnClickListener {
        int position;

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
               /* case R.id.tvDel:
                    list.remove(position);
                    SlidingListviewAdapter.this.notifyDataSetChanged();
                    break;*/
                default:
                    break;
            }
        }
    }

    MySetTopInterface mySetTopInterface;

    public interface MySetTopInterface {
        void Onclick_ll_setTop_ll_right(View view, int position);
    }

    public void setMySetTopInterface(MySetTopInterface mySetTopInterface) {
        this.mySetTopInterface = mySetTopInterface;
    }

    class ViewHolder {

        LinearLayout llLeft;
        LinearLayout llRightDel;
        TextView tvVisitTime;
        TextView tvVisitTitle;
        TextView tvVisitContent;
        TextView tvDelete;
    }
}
