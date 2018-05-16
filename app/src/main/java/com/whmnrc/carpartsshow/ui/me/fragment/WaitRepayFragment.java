package com.whmnrc.carpartsshow.ui.me.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.pay.alipay.AliPayTools;
import com.whmnrc.carpartsshow.pay.wechat.pay.WechatPay;
import com.whmnrc.carpartsshow.pay.wechat.pay.WechatPayTools;
import com.whmnrc.carpartsshow.presenter.me.CreditMoneyPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.whmnrc.carpartsshow.ui.me.adapter.ConsumptionRecordAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.PayDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 * 待还款
 */

public class WaitRepayFragment extends MvpFragment<CreditMoneyPresenter> implements CreditMoneyContract.View {
    @BindView(R.id.my_moe)
    TextView myMoe;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ConsumptionRecordAdapter adapter;
    private PayDialog payDialog;
    private int type;
    private LoginBean loginBean;
    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_repay;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        adapter = new ConsumptionRecordAdapter(getContext());
        loginBean = SpUtil.getObject(getContext(), "user");
//        tvNum.setText(loginBean);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 2);
            }
        });
       adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
           @Override
           public void onClick(View view, Object item, int position) {

               payDialog = new PayDialog.Builder(getContext())
                       .setPayListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
//                                payDialog.select();
                               if (type == 0){
                                   //支付宝
                                   /**
                                    * AliPayTools.aliPay(mContext,
                                    APP_ID,//支付宝分配的APP_ID
                                    isRSA2,//是否是 RSA2 加密
                                    RSA_PRIVATE,// RSA 或 RSA2 字符串
                                    new AliPayModel(order_id,//订单ID (唯一)
                                    money,//价格
                                    name,//商品名称
                                    detail),//商品描述详情 (用于显示在 支付宝 的交易记录里)
                                    new onRequestListener() {
                                   @Override
                                   public void onSuccess(String s) {RxToast.success("支付成功");}

                                   @Override
                                   public void onError(String s) {RxToast.error("支付失败");
                                   }
                                   });
                                    */
                                   payDialog.dismiss();
                                   CPSToast.showText(getContext(),"暂不支持");
                               }else if (type == 1){
                                   //微信
                                   /**
                                    * wechatPayApp(mContext,
                                    app_id, //微信分配的APP_ID
                                    partner_id, //微信分配的 PARTNER_ID (商户ID)
                                    wx_private_key, //微信分配的 PRIVATE_KEY (私钥)
                                    prepay_id, //订单ID (唯一)
                                    new onRequestListener() {
                                   @Override
                                   public void onSuccess(String s) {}

                                   @Override
                                   public void onError(String s) {}
                                   });
                                    */
                                   payDialog.dismiss();
                                   CPSToast.showText(getContext(),"暂不支持");
                               }
                           }
                       }).setIsCredit(false)
                       .setAliListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               payDialog.select(0);
                               type = 0;
                           }
                       }).setWXListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               payDialog.select(1);
                               type = 1;
                           }

                       }).build();
               payDialog.show();
               payDialog.select(0);
           }
       });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadMore(List<ConsumptionRecordBean> list) {
        refresh.finishLoadmore();
        adapter.addMoreDataSet(list);


    }

    @Override
    public void loadFrist(List<ConsumptionRecordBean> list) {
        tvNum.setText(list.size() + "笔");
        double num;
        if ( Double.parseDouble(loginBean.getRepairUser_CreditMoney()) - Double.parseDouble(loginBean.getRepairUser_CreditBeOverMoney()) < 0){
            num = 0;
        }else {
            num = Double.parseDouble(loginBean.getRepairUser_CreditMoney()) - Double.parseDouble(loginBean.getRepairUser_CreditBeOverMoney());
        }
        myMoe.setText(num+"");
        refresh.finishRefresh();
        adapter.addFirstDataSet(list);
        if (list.size() == 0) {
            CPSToast.showText(getContext(), "没有更多记录了");
        }
    }

    public static void createSign(String orderId, int payType, int PayPurpose) {
        String url ="http://www.lkyyzj.com/api/Pay/Pay";
        Map params = new HashMap();
        params.put("UserInfoID", "17612751274");
        params.put("Money", "0.1");
        params.put("PayType", payType);
        params.put("OrderPayNo", orderId);
        params.put("PayPurpose", PayPurpose);
//        OkhttpUtil.postString(url, GsonUtil.createGsonString(params), objectCallback);
    }
}
