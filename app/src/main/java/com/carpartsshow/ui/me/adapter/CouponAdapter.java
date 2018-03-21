package com.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.CouponBean;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CouponAdapter extends BaseAdapter<CouponBean> {

    public CouponAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, CouponBean item, int position) {
        holder.setText(R.id.tv_man_me,"满"+item.getCoupon_FullMoneyUse()+"可使用此优惠券");
        holder.setText(R.id.tv_coupon_me,item.getCoupon_Money()+"元抵用券");
        String time = item.getCoupon_OverTime().substring(0,9);
        holder.setText(R.id.tv_coupon_time,"仅限"+time+"日前使用");
    }

    @Override
    protected int getItemViewLayoutId(int position, CouponBean item) {
        return R.layout.item_coupon;
    }
}
