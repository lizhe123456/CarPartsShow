package com.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.util.SystemUtil;

/**
 * Created by lizhe on 2018/3/26.
 */

public class HomeCategoryAdapter extends BaseAdapter<HomePageBean.ListFirstCategoryBean> {

    public HomeCategoryAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.ListFirstCategoryBean item, int position) {
        int width = SystemUtil.getScreenWidth(getContext()) / 5;
        LinearLayout linearLayout = holder.getView(R.id.ll_layout);
        FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        //获取当前控件的布局对象
        params.width = width;//设置当前控件布局的高度
        linearLayout.setLayoutParams(params);//将设置好的布局参数应用到控件中
        holder.setText(R.id.tv_categorg_name,item.getName());
        holder.setGlieuImage(R.id.iv_img,item.getCategory_ImgPath());
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.ListFirstCategoryBean item) {
        return R.layout.item_home_category;
    }
}
