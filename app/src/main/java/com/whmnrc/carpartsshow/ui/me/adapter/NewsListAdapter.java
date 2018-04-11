package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.NewsListBean;

/**
 * Created by lizhe on 2018/3/28.
 */

public class NewsListAdapter extends BaseAdapter<NewsListBean> {

    public NewsListAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, NewsListBean item, int position) {
        String imgPath = getDataSource().get(position).getNotice_ImgPaths();
        String[] imgs = imgPath.split(",");
        if (imgs.length == 1){
            holder.setText(R.id.tv_desc,item.getNotice_Title())
                    .setText(R.id.tv_time,item.getNotice_ReleaseTime())
                    .setGlieuImage(R.id.iv_img,imgs[0]);
        }else if (imgs.length == 0){
            holder.setVisible(R.id.ll_img_layout,false).setText(R.id.tv_time,item.getNotice_ReleaseTime()).setText(R.id.tv_desc,item.getNotice_Title());
        }else {
            holder.setVisible(R.id.ll_img_layout,true)
                    .setText(R.id.tv_time,item.getNotice_ReleaseTime())
                    .setText(R.id.tv_desc,item.getNotice_Title())
                    .setGlieuImage(R.id.iv_img1,imgs[0])
                    .setGlieuImage(R.id.iv_img2,imgs[1])
                    .setGlieuImage(R.id.iv_img3,imgs[2]);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, NewsListBean item) {
        String imgPath = getDataSource().get(position).getNotice_ImgPaths();
        String[] imgs = imgPath.split(",");
        if (imgs.length == 1){
            return R.layout.item_news_list;
        }else {
            return R.layout.item_news_list_2;
        }

    }

}
