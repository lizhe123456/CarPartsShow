package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;

import java.util.List;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/6/22.
 */

public class ReturnGoodsAdapter extends BaseAdapter<OrderListBean.DataBean.DetailBean> {

    private OnClickRequestListener onClickRequestListener;

    public ReturnGoodsAdapter(Context context) {
        super(context);
    }

    public void setOnClickRequestListener(OnClickRequestListener onClickRequestListener) {
        this.onClickRequestListener = onClickRequestListener;
    }

    public void shopNotifyItemChanged(int position) {
        String[] strings = total(getDataSource());
        onClickRequestListener.updateTotal(strings[0], strings[1], strings[2]);
        notifyItemChanged(position);
    }

    @Override
    protected void bindDataToItemView(final BaseViewHolder holder, final OrderListBean.DataBean.DetailBean item, final int position) {
        holder.setText(R.id.tv_goods_name, item.getProduct_Name() == null ? "" : item.getProduct_Name())
                .setText(R.id.tv_goods_num, item.getReturnGoodsNum() + "");
        if (item.getProduct_Type() == 2) {
            holder.setText(R.id.tv_price, "积分： " + item.getProduct_Price());
            holder.setVisible(R.id.tv_jifen_desc, true);
        } else {
            if (item.getProduct_Price() <= 0) {
                holder.setText(R.id.tv_price, R.string.no_price);
            } else {
                holder.setText(R.id.tv_price, "¥" + item.getProduct_Price());
            }
            holder.setVisible(R.id.tv_jifen_desc, false);
        }

        holder.setGlieuImage(R.id.goods_img, item.getProduct_ImgPath());

        holder.setOnClickListener(R.id.goods_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickRequestListener != null)
                    onClickRequestListener.goodsDetails(item);
            }
        });
        if (item.getProduct_Type() != 2) {
            if (item.isSelected()) {
                holder.setImageResource(R.id.iv_select, R.drawable.round_btn_selected);
            } else {
                holder.setImageResource(R.id.iv_select, R.drawable.round_btn_normal);
            }


            holder.setOnClickListener(R.id.tv_reduce, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickRequestListener != null) {
                        //该商品货物减一
                        int i = item.getReturnGoodsNum();
                        if (i > 0) {
                            //减一请求
                            onClickRequestListener.reduce(item, position);
                        }
                    }
                }
            });
            holder.setOnClickListener(R.id.tv_plus, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickRequestListener != null) {
                        //加一请求
                        if (item.getKuCun() > 0) {
                            onClickRequestListener.plus(item, position);
                        }
                    }
                }
            });
        }

        holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAll = false;
                if (!item.isSelected()) {
                    holder.setImageResource(R.id.iv_select, R.drawable.round_btn_selected);
                    item.setSelected(true);
                    String[] strings = total(getDataSource());
                    onClickRequestListener.updateTotal(strings[0], strings[1], strings[2]);
                } else {
                    holder.setImageResource(R.id.iv_select, R.drawable.round_btn_normal);
                    item.setSelected(false);
                    String[] strings = total(getDataSource());
                    onClickRequestListener.updateTotal(strings[0], strings[1], strings[2]);
                }
                for (int i = 0; i < getDataSource().size(); i++) {
                    if (getDataSource().get(i).isSelected()) {
                        isAll = true;
                    } else {
                        isAll = false;
                        break;
                    }
                }
                onClickRequestListener.isAll(isAll);
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.DataBean.DetailBean item) {
        return R.layout.item_shop_car;
    }

    private String[] total(List<OrderListBean.DataBean.DetailBean> list) {
        int money = 0;
        int integral = 0;
        int num = 0;
        for (OrderListBean.DataBean.DetailBean bean : list) {
            if (bean.isSelected()) {
                if (bean.getProduct_Type() == 2) {
                    integral += bean.getProduct_Price() * bean.getReturnGoodsNum();
                } else {
                    money += bean.getProduct_Price() * bean.getReturnGoodsNum();
                }
                num += bean.getReturnGoodsNum();
            }
        }
        return new String[]{"¥" + money + ".00", "积分： " + integral, num + ""};
    }

    //全选
    public void allSelected(boolean isAll) {
        for (int i = 0; i < getDataSource().size(); i++) {
            if (isAll) {
                if (!getDataSource().get(i).isSelected()) {
                    getDataSource().get(i).setSelected(isAll);
                    notifyItemChanged(i);
                }
            } else {
                if (getDataSource().get(i).isSelected()) {
                    getDataSource().get(i).setSelected(isAll);
                    notifyItemChanged(i);
                }
            }
        }
        String[] strings = total(getDataSource());
        onClickRequestListener.updateTotal(strings[0], strings[1], strings[2]);
    }

    public interface OnClickRequestListener {

        void plus(OrderListBean.DataBean.DetailBean item, int position);

        void reduce(OrderListBean.DataBean.DetailBean item, int position);

        void updateTotal(String money, String integral, String num);

        void isAll(boolean isAll);

        void goodsDetails(OrderListBean.DataBean.DetailBean item);
    }

}
