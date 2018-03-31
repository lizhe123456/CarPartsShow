package com.carpartsshow.ui.me.fragment.order.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.ui.me.fragment.order.adapter.OrderGoodsAdapter;
import com.carpartsshow.ui.shopping.adapter.ConfirmOrderAdapter;

/**
 * Created by lizhe on 2018/3/31.
 */

public abstract class OrderAdapter extends BaseAdapter<OrderListBean.DataBean> {

    public OrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DataBean item, int position) {
        //订单号
        holder.setText(R.id.tv_order_num,"订单号："+item.getOrder_No());
        switch (item.getOrder_State()){
            case 0 :
                holder.setText(R.id.order_state,"待支付");
                break;
            case 1 :
                holder.setText(R.id.order_state,"已支付");
                break;
            case 2 :
                holder.setText(R.id.order_state,"待收货");
                break;
            case 3 :
                holder.setText(R.id.order_state,"已完成");
                break;
            case 4 :
                holder.setText(R.id.order_state,"取消的订单");
                break;
            case 5 :
                holder.setText(R.id.order_state,"等待审核");
                break;
            case 6 :
                holder.setText(R.id.order_state,"退款成功");
                break;
            case 7 :
                holder.setText(R.id.order_state,"退款失败");
                break;
        }
        //订单状态
        RecyclerView goodsList = holder.getView(R.id.rv_goods_list);
        OrderGoodsAdapter adapter = new OrderGoodsAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        goodsList.setLayoutManager(layoutManager);
        goodsList.setAdapter(adapter);
        adapter.addFirstDataSet(item.getDetail());

        holder.setOnClickListener(R.id.tv_urgent, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加急订单
            }
        });
        holder.setOnClickListener(R.id.tv_pay, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //支付
            }
        });
        holder.setOnClickListener(R.id.tv_service, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //申请售后
            }
        });

        holder.setOnClickListener(R.id.tv_confirm_order, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确认收货
            }
        });

        holder.setOnClickListener(R.id.tv_customer_service, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //联系客服
            }
        });

        holder.setOnClickListener(R.id.tv_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消订单

            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.DataBean item) {
        return R.layout.wait_order_item;
    }

    //申请售后

    //订单加急

    //查看物流

    //确认收货

    //取消订单

    //付款

    //联系客服

    //显示空页面

}
