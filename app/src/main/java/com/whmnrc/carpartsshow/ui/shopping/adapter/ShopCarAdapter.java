package com.whmnrc.carpartsshow.ui.shopping.adapter;

import android.content.Context;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.ShopCarBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/28.
 * 购物车适配器
 */

public class ShopCarAdapter extends BaseAdapter<ShopCarBean.ListCarProductBean> {


    private OnClickRequestListener onClickRequestListener;

    public ShopCarAdapter(Context context) {
        super(context);
    }

    public void setOnClickRequestListener(OnClickRequestListener onClickRequestListener) {
        this.onClickRequestListener = onClickRequestListener;
    }

    public void shopNotifyItemChanged(int position){
        String[] strings = total(getDataSource());
        onClickRequestListener.updateTotal(strings[0],strings[1],strings[2]);
        notifyItemChanged(position);
    }

    @Override
    protected void bindDataToItemView(final BaseViewHolder holder, final ShopCarBean.ListCarProductBean item, final int position) {
        holder.setText(R.id.tv_goods_name,item.getName() == null ? "" : item.getName())
                .setText(R.id.tv_goods_num,item.getBuyCar_Num() + "");
        if (item.getProduct_Type() == 2){
            holder.setText(R.id.tv_price,"积分： " + item.getPrice());
        }else {
            holder.setText(R.id.tv_price, "¥" + item.getPrice() + ".00");
        }

        holder.setGlieuImage(R.id.goods_img,item.getImagePath());

        holder.setOnClickListener(R.id.goods_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickRequestListener != null)
                    onClickRequestListener.goodsDetails(item);
            }
        });

        if (item.isSelected()) {
            holder.setImageResource(R.id.iv_select, R.drawable.round_btn_selected);
        }else {
            holder.setImageResource(R.id.iv_select, R.drawable.round_btn_normal);
        }

        holder.setOnClickListener(R.id.tv_reduce, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickRequestListener != null) {
                    //该商品货物减一
                    int i = item.getBuyCar_Num();
                    if (i > 1) {
                        //减一请求
                        onClickRequestListener.reduce(item,position);
                    }
                }
            }
        });
        holder.setOnClickListener(R.id.tv_plus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickRequestListener != null) {
                    //加一请求
                    onClickRequestListener.plus(item,position);
                }
            }
        });

        holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAll = false;
                if (!item.isSelected()){
                    holder.setImageResource(R.id.iv_select,R.drawable.round_btn_selected);
                    item.setSelected(true);
                    String[] strings = total(getDataSource());
                    onClickRequestListener.updateTotal(strings[0],strings[1],strings[2]);
                }else {
                    holder.setImageResource(R.id.iv_select,R.drawable.round_btn_normal);
                    item.setSelected(false);
                    String[] strings = total(getDataSource());
                    onClickRequestListener.updateTotal(strings[0],strings[1],strings[2]);
                }
                for (int i = 0; i < getDataSource().size(); i++) {
                    if (getDataSource().get(i).isSelected()){
                        isAll = true;
                    }else {
                        isAll = false;
                        break;
                    }
                }
                onClickRequestListener.isAll(isAll);
            }
        });
    }

    public String[] total(List<ShopCarBean.ListCarProductBean> list){
        int money = 0;
        int integral = 0;
        int num = 0;
        for (ShopCarBean.ListCarProductBean bean : list) {
            if (bean.isSelected()) {
                if (bean.getProduct_Type() == 2) {
                    integral += bean.getPrice() * bean.getBuyCar_Num();
                }else {
                    money += bean.getPrice() * bean.getBuyCar_Num();
                }
                num += bean.getBuyCar_Num();
            }
        }
        return new String[]{"¥" + money + ".00","积分： " + integral,num+""};
    }

    @Override
    protected int getItemViewLayoutId(int position, ShopCarBean.ListCarProductBean item) {
        return R.layout.item_shop_car;
    }

    //全选
    public void allSelected(boolean isAll) {
        for (int i = 0; i < getDataSource().size(); i++) {
            if (isAll){
                if (!getDataSource().get(i).isSelected()){
                    getDataSource().get(i).setSelected(isAll);
                    notifyItemChanged(i);
                }
            }else {
                if (getDataSource().get(i).isSelected()) {
                    getDataSource().get(i).setSelected(isAll);
                    notifyItemChanged(i);
                }
            }
        }
        String[] strings = total(getDataSource());
        onClickRequestListener.updateTotal(strings[0],strings[1],strings[2]);
    }


    public interface OnClickRequestListener{

        void plus(ShopCarBean.ListCarProductBean item,int position);

        void reduce(ShopCarBean.ListCarProductBean item,int position);

        void updateTotal(String money, String integral, String num);

        void isAll(boolean isAll);

        void goodsDetails(ShopCarBean.ListCarProductBean item);
    }
}
