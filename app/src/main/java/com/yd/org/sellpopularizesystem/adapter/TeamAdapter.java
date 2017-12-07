package com.yd.org.sellpopularizesystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.javaBean.TeamBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejin on 2017/5/17.
 */

public class TeamAdapter extends BaseAdapter implements SectionIndexer {
    private LayoutInflater layoutInflater;
    private List<TeamBean.ResultBean.SubBeanX> tasks = new ArrayList<>();
    private Context mContext;

    public TeamAdapter(Context context, List<TeamBean.ResultBean.SubBeanX> tasks) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        this.tasks = tasks;

    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<TeamBean.ResultBean.SubBeanX> list) {
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
            convertView = layoutInflater.inflate(R.layout.team_listview_item_layout, null);
            viewHolder.tvTeamName = (TextView) convertView.findViewById(R.id.tvTeamName);
            viewHolder.lvTeamMember = (ListView) convertView.findViewById(R.id.lvTeamMember);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.subBeanX = tasks.get(position);


        try {

            viewHolder.tvTeamName.setText(viewHolder.subBeanX.getSurname() + mContext.getString(R.string.single_blank_space) + viewHolder.subBeanX.getFirstname() + " " + "- $" + viewHolder.subBeanX.getCommission());
            if (tasks.get(position).getSub() != null && tasks.get(position).getSub().size() > 0) {
                if (viewHolder.lvTeamMember.getVisibility() == View.GONE) {
                    viewHolder.lvTeamMember.setVisibility(View.VISIBLE);
                }
                viewHolder.childs = tasks.get(position).getSub();
                viewHolder.lvTeamMember.setAdapter(new ItemAdapter(mContext, viewHolder.childs));
            } else {
                viewHolder.lvTeamMember.setVisibility(View.GONE);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    class ViewHolder {
        TextView tvTeamName;
        ListView lvTeamMember;
        TeamBean.ResultBean.SubBeanX subBeanX;
        List<TeamBean.ResultBean.SubBeanX.SubBean> childs = new ArrayList<>();
    }

    //内层listview适配器
    class ItemAdapter extends BaseAdapter {
        private Context mItemContext;
        private List<TeamBean.ResultBean.SubBeanX.SubBean> childs = new ArrayList<>();
        private LayoutInflater inflater;

        public ItemAdapter(Context mContext, List<TeamBean.ResultBean.SubBeanX.SubBean> childs) {
            this.mItemContext = mContext;
            this.childs = childs;
            this.inflater = LayoutInflater.from(mItemContext);
        }

        @Override
        public int getCount() {
            return childs.size();
        }

        @Override
        public TeamBean.ResultBean.SubBeanX.SubBean getItem(int position) {
            return childs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TeamMemberViewHolder teamMemberViewHolder = null;
            if (convertView == null) {
                teamMemberViewHolder = new TeamMemberViewHolder();
                convertView = inflater.inflate(R.layout.team_listview_item_sublay, null);
                teamMemberViewHolder.tvTeamMemberName = (TextView) convertView.findViewById(R.id.tvTeamMemberName);
                convertView.setTag(teamMemberViewHolder);
            } else {
                teamMemberViewHolder = (TeamMemberViewHolder) convertView.getTag();
            }


            try {
                teamMemberViewHolder.subBean = childs.get(position);
                teamMemberViewHolder.tvTeamMemberName.setText(teamMemberViewHolder.subBean.getSurname() +
                        mItemContext.getString(R.string.single_blank_space) + teamMemberViewHolder.subBean.getFirstname() + " " + "- $" + teamMemberViewHolder.subBean.getCommission());

            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            return convertView;
        }

        class TeamMemberViewHolder {
            private TextView tvTeamMemberName;
            private TeamBean.ResultBean.SubBeanX.SubBean subBean;
        }
    }
}
