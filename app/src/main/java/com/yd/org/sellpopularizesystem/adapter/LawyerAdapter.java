package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.Lawyer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/4/26.
 */

public class LawyerAdapter extends BaseAdapter implements SectionIndexer {
    private LayoutInflater layoutInflater;
    private List<Lawyer.ResultBean.LawyerListBean> tasks = new ArrayList<>();
    private int[] sectionIndices;
    private String[] sectionHeaders;

    public LawyerAdapter(Context context, List<Lawyer.ResultBean.LawyerListBean> tasks) {
        layoutInflater = LayoutInflater.from(context);
        this.tasks = tasks;
        sectionIndices = getSectionIndices();
        sectionHeaders = getSectionHeaders();
    }

    public void refresh(List<Lawyer.ResultBean.LawyerListBean> tasks) {
        this.tasks = tasks;
        sectionIndices = getSectionIndices();
        sectionHeaders = getSectionHeaders();
        notifyDataSetChanged();
    }

    public int[] getSectionIndices() {
        List<Integer> sectionIndices = new ArrayList<Integer>();
        String lastLawFirm = tasks.get(0).getLaw_firm();
        sectionIndices.add(0);
        for (int i = 1; i < tasks.size(); i++) {
            String lawFirm = tasks.get(i).getLaw_firm();
            if (!lawFirm.equals(lastLawFirm)) {
                lastLawFirm = lawFirm;
                sectionIndices.add(i);
            }
        }
        int[] sections = new int[sectionIndices.size()];
        for (int i = 0; i < sectionIndices.size(); i++) {
            sections[i] = sectionIndices.get(i);
        }
        return sections;
    }

    public String[] getSectionHeaders() {
        try {

            if (sectionIndices.length > 0) {
                String[] sectionHeaders = new String[sectionIndices.length];
                for (int i = 0; i < sectionIndices.length; i++) {
                    sectionHeaders[i] = tasks.get(sectionIndices[i]).getLaw_firm();
                }
                return sectionHeaders;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return sectionHeaders;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<Lawyer.ResultBean.LawyerListBean> list) {
        if (list == null) {
            this.tasks = new ArrayList<>();
        } else {
            this.tasks = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.lawyer_listview_item, null);
            viewHolder.tvLawFirm = (TextView) convertView.findViewById(R.id.law_firm);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        try {
            int sec = getSectionForPosition(position);
            if (position == getPositionForSection(sec)) {
                viewHolder.tvLawFirm.setVisibility(View.VISIBLE);
                viewHolder.tvLawFirm.setText(tasks.get(position).getLaw_firm());
            } else {
                viewHolder.tvLawFirm.setVisibility(View.GONE);
            }
            viewHolder.tvName.setText(tasks.get(position).getFirst_name() + tasks.get(position).getSurname());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return convertView;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        try {
            if (sectionIndex >= sectionIndices.length) {
                sectionIndex = sectionIndices.length - 1;
            } else if (sectionIndex < 0) {
                sectionIndex = 0;
            }
            return sectionIndices[sectionIndex];
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        for (int i = 0; i < sectionIndices.length; i++) {
            if (position < sectionIndices[i]) {
                return i - 1;
            }
        }
        return sectionIndices.length - 1;
    }

    class ViewHolder {
        TextView tvLawFirm;
        TextView tvName;
    }


}
