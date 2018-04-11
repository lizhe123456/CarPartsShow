package com.whmnrc.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.util.SystemUtil;

/**
 * Created by lizhe on 2018/3/26.
 */

public class SpecialOfferAdapter extends BaseAdapter<HomePageBean.SpecialOfferBean> {

    public SpecialOfferAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.SpecialOfferBean item, int position) {
        int width = (SystemUtil.getScreenWidth(getContext())-32) / 2;
        ImageView imageView = holder.getView(R.id.iv_img);
        FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) imageView.getLayoutParams();
        //获取当前控件的布局对象
        params.width = width;//设置当前控件布局的高度
        imageView.setLayoutParams(params);//将设置好的布局参数应用到控件中
        holder.setGlieuImage(R.id.iv_img,item.getBanner_WxAppImgPath());
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.SpecialOfferBean item) {
        return R.layout.item_special_offer;
    }
}
