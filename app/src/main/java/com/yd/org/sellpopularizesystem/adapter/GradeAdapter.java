package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.GradeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/3/16.
 */

public class GradeAdapter extends BaseAdapter {
    private List<GradeBean.ResultBean> data = new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;

    //private int index;
    public GradeAdapter(Context mContext, List<GradeBean.ResultBean> data) {
        this.data = data;
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.grade_display_listview_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.questionTitle);
            viewHolder.mListView = (ListView) convertView.findViewById(R.id.itemListView);
            viewHolder.ivFlag = (ImageView) convertView.findViewById(R.id.ivFlag);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        try {
            if (data.get(position).getCorrect_answer().contains(",")) {
                viewHolder.textView.setText((position + 1) + ". " + data.get(position).getCheck_title() + mContext.getString(R.string.multiple_choice));
            } else {
                if (data.get(position).getOptions().size() > 2) {
                    viewHolder.textView.setText((position + 1) + ". " + data.get(position).getCheck_title() + mContext.getString(R.string.single_choice));
                } else {
                    viewHolder.textView.setText((position + 1) + ". " + data.get(position).getCheck_title() + mContext.getString(R.string.yesornoquestion));
                }

            }
            if (data.get(position).getCheck_result().equals("1")) {
                viewHolder.ivFlag.setImageResource(R.mipmap.correcticonx);
            } else {
                viewHolder.ivFlag.setImageResource(R.mipmap.incorrecticonx);
            }

            viewHolder.mListView.setAdapter(new ItemAdapter(mContext, position, data.get(position).getOptions(), data.get(position).getUser_answer()));

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    class ViewHolder {
        private TextView textView;
        private ListView mListView;
        private ImageView ivFlag;
    }

    class ItemAdapter extends BaseAdapter {
        private List<GradeBean.ResultBean.OptionsBean> itemData = new ArrayList<>();
        //private List<GradeBean.ResultBean> resultBeen=new ArrayList<>();
        private int pos;
        private Context mContext;
        private LayoutInflater layoutInflater;
        private String user_answer;

        public ItemAdapter(Context mContext, int position, List<GradeBean.ResultBean.OptionsBean> itemData, String user_answer) {
            this.itemData = itemData;
            this.mContext = mContext;
            this.pos = position;
            this.layoutInflater = LayoutInflater.from(mContext);
            this.user_answer = user_answer;

        }


        @Override
        public int getCount() {
            return itemData.size();
        }

        @Override
        public Object getItem(int position) {
            return itemData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemViewHolder itemViewHolder = null;
            if (convertView == null) {
                itemViewHolder = new ItemViewHolder();
                convertView = layoutInflater.inflate(R.layout.item_search_history, null);
                itemViewHolder.itemTextView = (TextView) convertView.findViewById(R.id.tvHistory);
                convertView.setTag(itemViewHolder);
            } else {
                itemViewHolder = (ItemViewHolder) convertView.getTag();
            }


            try {

                itemViewHolder.itemTextView.setText(itemData.get(position).getOption_name());
                itemViewHolder.itemTextView.setTextColor(Color.BLACK);

                if (data.get(pos).getCheck_result().equals("0") && itemData.get(position).getIs_true() == 1) {
                    itemViewHolder.itemTextView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.textview_right));
                } else {
                    itemViewHolder.itemTextView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.textview_noright));
                }

                String all[] = user_answer.split(",");
                for (int i = 0; i < all.length; i++) {
                    if (all[i].equals(String.valueOf(itemData.get(position).getOption_id())) && data.get(pos).getCheck_result().equals("1")) {
                        itemViewHolder.itemTextView.setTextColor(Color.GREEN);
                        break;
                    } else if (all[i].equals(String.valueOf(itemData.get(position).getOption_id())) && data.get(pos).getCheck_result().equals("0")) {
                        itemViewHolder.itemTextView.setTextColor(Color.RED);
                        break;
                    }

                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }


            return convertView;
        }

        class ItemViewHolder {
            private TextView itemTextView;
        }
    }

}
