package com.yd.org.sellpopularizesystem.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.ExaminationActivity;
import com.yd.org.sellpopularizesystem.activity.GradeActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ExamlineBean;
import com.yd.org.sellpopularizesystem.utils.ActivitySkip;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;
import com.yd.org.sellpopularizesystem.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bai on 2017/1/19.
 */

public class ExamineAdapter extends BaseAdapter {

    protected List<ExamlineBean.ResultBean> list = new ArrayList<>();// 数据
    protected Context context;// 上下文
    protected LayoutInflater getInflater;// 加载布局
    private Activity activity;


    public ExamineAdapter(Activity context) {
        this.context = context;
        this.activity = context;
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
    public void addData(List<ExamlineBean.ResultBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderView holder = null;

        if (convertView == null) {
            holder = new HolderView();
            convertView = getInflater.inflate(R.layout.examine_item, null);
            holder.studyDisImageView = (ImageView) convertView.findViewById(R.id.studyDisImageView);
            holder.lockImageView = (ImageView) convertView.findViewById(R.id.lockImageView);
            holder.studyTextView = (TextView) convertView.findViewById(R.id.studyTextView);


            holder.dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
            holder.resultsTextView = (TextView) convertView.findViewById(R.id.resultsTextView);
            holder.examTextView = (TextView) convertView.findViewById(R.id.examTextView);
            holder.examineLinearLayout = (LinearLayout) convertView.findViewById(R.id.examineLinearLayout);

            convertView.setTag(holder);
        } else {
            holder = (HolderView) convertView.getTag();
        }
        holder.productListBean = list.get(position);


        try {
            BitmapUtil.loadImageView(context, Contants.DOMAIN + "/" + list.get(position).getThumb(), holder.studyDisImageView);


            holder.studyTextView.setText(holder.productListBean.getPaper_title());
            String time = holder.productListBean.getStop_time() + "000";
            holder.dateTextView.setText(context.getString(R.string.deadline) + MyUtils.getInstance().date2String("yyyy/MM/dd", Long.valueOf(time)));
            if (list.get(position).getCan_check() == 1) {
                holder.lockImageView.setVisibility(View.GONE);
            } else {
                holder.lockImageView.setVisibility(View.VISIBLE);
                holder.examineLinearLayout.setVisibility(View.GONE);
            }
            if (list.get(position).getIs_check() == 0) {//开始考核
                holder.examTextView.setText(context.getString(R.string.start_check));
                holder.examTextView.setTextColor(Color.WHITE);
                holder.resultsTextView.setVisibility(View.INVISIBLE);
            }
            if (list.get(position).getAnswer_id() != null) {
                holder.examTextView.setText(context.getString(R.string.examination_));
                if (list.get(position).getIs_check() == 1) {
                    holder.examTextView.setTextColor(Color.GREEN);
                    holder.resultsTextView.setVisibility(View.INVISIBLE);
                } else {
                    holder.examTextView.setText(context.getString(R.string.start_check));
                    holder.examTextView.setTextColor(Color.WHITE);
                    holder.resultsTextView.setVisibility(View.VISIBLE);
                }
            }

            holder.resultsTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("key", list.get(position));
                    ActivitySkip.forward(activity, GradeActivity.class, bundle);

                }
            });

            final HolderView finalHolder = holder;
            holder.examTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalHolder.examTextView.getText().equals(context.getString(R.string.examination_))) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key", list.get(position));
                        ActivitySkip.forward(activity, GradeActivity.class, bundle);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("paper_id", list.get(position).getPaper_id() + "");
                        ActivitySkip.forward(activity, ExaminationActivity.class, bundle);
                    }

                }
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    public class HolderView {
        private ImageView studyDisImageView, lockImageView;
        private TextView studyTextView, dateTextView, resultsTextView, examTextView;
        public ExamlineBean.ResultBean productListBean;
        private LinearLayout examineLinearLayout;

    }
}
