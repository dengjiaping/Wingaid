package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;

import java.util.Vector;

/**
 * Created by bai on 2017/1/12.
 */

public class ScaleCityAdapter extends BaseAdapter {
    private Context mContext;           // 定义Context
    private Vector<String> dataBase = new Vector<String>();
    private Vector<Boolean> isBoolean = new Vector<Boolean>();
    private int lastPosition = -1;      //记录上一次选中的位置，-1表示未选中
    private boolean multiChoose;        //表示当前适配器是否允许多选

    public ScaleCityAdapter(Context mContext, Vector<String> dataBase, boolean isMulti) {
        this.mContext = mContext;
        this.multiChoose = isMulti;
        this.dataBase = dataBase;

        for (int i = 0; i < dataBase.size(); i++)
            isBoolean.add(false);
    }


    @Override
    public int getCount() {
        return dataBase.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if (convertView == null) {
            holderView = new HolderView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.scale_city_item, null);
            holderView.radioButton = (TextView) convertView.findViewById(R.id.popupwindowTv);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }

        try {

            if (isBoolean.elementAt(position) == true) {
                holderView.radioButton.setBackground(mContext.getResources().getDrawable(R.drawable.radiobutton_select));
            } else {
                holderView.radioButton.setBackground(mContext.getResources().getDrawable(R.drawable.button_select));
            }
            holderView.radioButton.setText(dataBase.get(position));

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    public class HolderView {
        TextView radioButton;
    }

    // 修改选中的状态
    public void changeState(int position) {
        // 多选时
        if (multiChoose == true) {

            //当postion==0则选中的是"不限",其它选中的变回不选中,
            if (position == 0) {
                isBoolean.setElementAt(true, 0);
                for (int i = 1; i < dataBase.size(); i++) {
                    isBoolean.setElementAt(false, i);   //直接取反即可

                }

            } else {
                isBoolean.setElementAt(false, 0);
                isBoolean.setElementAt(!isBoolean.elementAt(position), position);   //直接取反即可

            }

        }
        // 单选时
        else {
            if (lastPosition != -1) isBoolean.setElementAt(false, lastPosition);    //取消上一次的选中状态
            isBoolean.setElementAt(!isBoolean.elementAt(position), position);   //直接取反即可
            lastPosition = position;        //记录本次选中的位置
        }
        notifyDataSetChanged();     //通知适配器进行更新
    }

    public boolean getSelect(int postion) {
        return isBoolean.elementAt(postion);
    }


}
