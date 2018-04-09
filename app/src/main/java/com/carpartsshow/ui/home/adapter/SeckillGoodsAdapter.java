package com.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.util.SystemUtil;

/**
 * Created by lizhe on 2018/3/26.
 */

public class SeckillGoodsAdapter extends BaseAdapter<HomePageBean.ListSeckillGoodsBean>{

    public SeckillGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.ListSeckillGoodsBean item, int position) {
        int width = (SystemUtil.getScreenWidth(getContext())-10) / 3;
        LinearLayout linearLayout = holder.getView(R.id.ll_goods_layout);
        FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        //获取当前控件的布局对象
        params.width = width;//设置当前控件布局的高度
        linearLayout.setLayoutParams(params);//将设置好的布局参数应用到控件中
        holder.setText(R.id.tv_name,item.getSeckill_Name())
                .setText(R.id.tv_price,item.getSeckill_Price()+"")
                .setText(R.id.tv_old_price,"¥" + item.getSeckill_SuggestPrice()+"")
                .setGlieuImage(R.id.iv_img,item.getSeckill_ImgPath());
        TextView textView = holder.getView(R.id.tv_old_price);
        textView.getPaint().setAntiAlias(true);//抗锯齿
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.ListSeckillGoodsBean item) {
        return R.layout.seckill_item;
    }
}
