package com.whmnrc.carpartsshow.ui.me.fragment.order.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.presenter.me.MyOrderPresenter;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.OrderGoodsAdapter;
import com.whmnrc.carpartsshow.widgets.CurrencyDialog;

/**
 * Created by lizhe on 2018/3/31.
 */

public abstract class OrderAdapter extends BaseAdapter<OrderListBean.DataBean> {

    private OnOrderListener onOrderListener;
    protected MyOrderPresenter myOrderPresenter;

    public OrderAdapter(Context context,MyOrderPresenter myOrderPresenter) {
        super(context);
        this.myOrderPresenter = myOrderPresenter;
    }

    public void setOnOrderListener(OnOrderListener onOrderListener) {
        this.onOrderListener = onOrderListener;
    }

    CurrencyDialog currencyDialog;

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, final OrderListBean.DataBean item, int position) {
        //订单号
        holder.setText(R.id.tv_order_num,"订单号："+item.getOrder_No());
        switch (item.getOrder_State()){
            case 0 :
                holder.setText(R.id.order_state,"待支付");
                holder.setText(R.id.tv_btn_1,"联系客服").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setText(R.id.tv_btn_2,"取消订单").setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消订单
                        currencyDialog = new CurrencyDialog.Builder(getContext())
                                .setMessage("确定要取消订单吗？")
                                .setPositiveButton("确认", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        myOrderPresenter.cancelOrder(item.getOrder_ID());
                                        currencyDialog.dismiss();
                                    }
                                })
                                .setNegativeButton("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        currencyDialog.dismiss();
                                    }
                                }).build();
                        currencyDialog.show();
                    }
                });
                holder.setText(R.id.tv_btn_3,"付款").setOnClickListener(R.id.tv_btn_3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //付款
                        if (onOrderListener != null)
                            onOrderListener.payClick(item);
                    }
                });
                break;
            case 1 :
                holder.setText(R.id.order_state,"已支付");
                holder.setText(R.id.tv_btn_1,"加急催单").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //加急催单
                        currencyDialog = new CurrencyDialog.Builder(getContext())
                                .setMessage("确定要催单？")
                                .setPositiveButton("确认", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        currencyDialog.dismiss();
                                        myOrderPresenter.orderUrgent(item.getOrder_ID());
                                    }
                                })
                                .setNegativeButton("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        currencyDialog.dismiss();
                                    }
                                }).build();
                        currencyDialog.show();
                    }
                });
                holder.setText(R.id.tv_btn_2,"联系客服").setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 2 :
                holder.setText(R.id.order_state,"待收货");
                holder.setVisible(R.id.tv_btn_1,false);
                holder.setText(R.id.tv_btn_2,"确认收货").setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //确认收货
                        currencyDialog = new CurrencyDialog.Builder(getContext())
                                .setMessage("确定要收货吗？")
                                .setPositiveButton("确认", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        myOrderPresenter.receiptGoods(item.getOrder_ID());
                                        currencyDialog.dismiss();
                                    }
                                })
                                .setNegativeButton("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        currencyDialog.dismiss();
                                    }
                                }).build();
                        currencyDialog.show();

                    }
                });
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 3 :
                holder.setText(R.id.order_state,"已完成");
                holder.setText(R.id.tv_btn_1,"申请退货").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //申请售后
                        currencyDialog = new CurrencyDialog.Builder(getContext())
                                .setMessage("确定要退货吗？")
                                .setPositiveButton("确认", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (onOrderListener != null)
                                            onOrderListener.applyCustomerServiceClick(item);
                                        currencyDialog.dismiss();
                                    }
                                })
                                .setNegativeButton("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        currencyDialog.dismiss();
                                    }
                                }).build();
                        currencyDialog.show();

                    }
                });
                holder.setText(R.id.tv_btn_2,"联系客服").setOnClickListener(R.id.tv_btn_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 4 :
                holder.setText(R.id.order_state,"取消的订单");
                holder.setVisible(R.id.tv_btn_1,false);
                holder.setVisible(R.id.tv_btn_2,false);
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 5 :
                holder.setText(R.id.order_state,"退货申请中");
                holder.setText(R.id.tv_btn_1,"联系客服").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setVisible(R.id.tv_btn_2,false);
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 6 :
                holder.setText(R.id.order_state,"退货成功");
                holder.setText(R.id.tv_btn_1,"联系客服").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setVisible(R.id.tv_btn_2,false);
                holder.setVisible(R.id.tv_btn_3,false);
                break;
            case 7 :
                holder.setText(R.id.order_state,"退货失败");
                holder.setText(R.id.tv_btn_1,"联系客服").setOnClickListener(R.id.tv_btn_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //联系客服
                        if (onOrderListener != null)
                            onOrderListener.customerServicePhoneClick(item);
                    }
                });
                holder.setVisible(R.id.tv_btn_2,false);
                holder.setVisible(R.id.tv_btn_3,false);
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
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {

                OrderListBean.DataBean.DetailBean detailBean = (OrderListBean.DataBean.DetailBean) item;
                if (detailBean.getProduct_Type() == 0) {
                    GoodsDetailsActivity.newInstance(getContext(), detailBean.getProduct_ID(), detailBean.getProduct_Type());
                }else if (detailBean.getProduct_Type() == 1){
                    GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(detailBean.getUrl(),false,0);
                    GoodsDetailsActivity.newInstance(getContext() ,goodsDetailToBean);
                }else if (detailBean.getProduct_Type() == 2){
                    GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(detailBean.getUrl(),false,0);
                    goodsDetailToBean.setType(1);
                    GoodsDetailsActivity.newInstance(getContext(), goodsDetailToBean);
                }
            }
        });

    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.DataBean item) {
        return R.layout.wait_order_item;
    }



}
