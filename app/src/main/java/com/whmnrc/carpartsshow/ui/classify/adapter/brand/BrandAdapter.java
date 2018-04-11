package com.whmnrc.carpartsshow.ui.classify.adapter.brand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.util.GlideuUtil;

import java.util.List;

/**
 * Created by lizhe on 2018/3/27.
 */

public class BrandAdapter extends BaseAdapter implements SectionIndexer {

    private List<ClassificationBean.ListBrandBean> list = null;
    private Context mContext;

    public BrandAdapter(Context mContext, List<ClassificationBean.ListBrandBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<ClassificationBean.ListBrandBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public ClassificationBean.ListBrandBean getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        final ClassificationBean.ListBrandBean mContent = list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_brand, null);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.tvLetter = (TextView) view.findViewById(R.id.tv_catagory);
            viewHolder.imageView = view.findViewById(R.id.iv_img);
            viewHolder.relativeLayout = view.findViewById(R.id.rl_layout);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        int section = getSectionForPosition(position);

        if (position == getPositionForSection(section)) {
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(mContent.getCompany_FirstWord());
        } else {
            viewHolder.tvLetter.setVisibility(View.GONE);
        }

        viewHolder.tvTitle.setText(this.list.get(position).getName());
        GlideuUtil.loadImageView(mContext,mContent.getLogo(),viewHolder.imageView);
        return view;

    }


    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
        ImageView imageView;
        RelativeLayout relativeLayout;
    }

    public int getSectionForPosition(int position) {
        return list.get(position).getCompany_FirstWord().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getCompany_FirstWord();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] getSections() {
        return null;
    }


}
