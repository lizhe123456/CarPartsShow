package com.whmnrc.carpartsshow.ui.me;

import android.app.Dialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.presenter.me.MePresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.MeContract;
import com.whmnrc.carpartsshow.ui.LoginActivity;
import com.whmnrc.carpartsshow.ui.me.activity.AboutUsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.AllOrderActivity;
import com.whmnrc.carpartsshow.ui.me.activity.FeedbackActivity;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralShopActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyCollectActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyCouponActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyIntegralActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyMoneyActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyOrderActivity;
import com.whmnrc.carpartsshow.ui.me.activity.NewsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.UpdateAddressActivity;
import com.whmnrc.carpartsshow.ui.me.activity.UpdatePassActivity;
import com.whmnrc.carpartsshow.ui.me.adapter.ItemAdapter;
import com.whmnrc.carpartsshow.ui.me.adapter.OrderListAdapter;
import com.whmnrc.carpartsshow.ui.me.adapter.bean.OrderItem;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.SlideGridView;
import com.whmnrc.carpartsshow.view.SlideListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/12.
 */

public class MeFragment extends MvpFragment<MePresenter> implements MeContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_gongsi)
    TextView tvGongsi;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.text_money)
    TextView textMoney;
    @BindView(R.id.collection)
    TextView collection;
    @BindView(R.id.text_collection)
    TextView textCollection;
    @BindView(R.id.coupon)
    TextView coupon;
    @BindView(R.id.text_coupon)
    TextView textCoupon;
    @BindView(R.id.integral)
    TextView integral;
    @BindView(R.id.text_integral)
    TextView textIntegral;
    @BindView(R.id.grid_order)
    SlideGridView gridOrder;
    @BindView(R.id.lv_item_list)
    SlideListView lvItemList;
    @BindView(R.id.tv_exit_login)
    TextView tvExitLogin;
    @BindView(R.id.stu_bar)
    View view;

    private String userId;
    private OrderListAdapter orderListAdapter;
    private ItemAdapter itemAdapter;
    private LoginBean loginBean;
    private UserInfoBean userInfoBean;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void init() {
        super.init();
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) view.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
        linearParams.height = ScreenUtils.getStatusHeight(getContext());
        view.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
        title.setText("个人中心");
        textCollection.setText("收藏");
        textCoupon.setText("优惠券");
        textMoney.setText("可用信用额度");
        textIntegral.setText("积分");
        itemAdapter = new ItemAdapter(getContext());
        lvItemList.setAdapter(itemAdapter);
        itemAdapter.addFristData(OrderItem.initItemData());
        gridOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                switch (i){
                    case 0:
                        intent.putExtra("page",0);
                        break;
                    case 1:
                        intent.putExtra("page",1);
                        break;
                    case 2:
                        intent.putExtra("page",2);
                        break;
                    case 3:
                        intent.putExtra("page",3);
                        break;
                    case 4:
                        intent.putExtra("page",4);
                        break;
                }
                intent.setClass(getContext(), MyOrderActivity.class);
                startActivity(intent);
            }
        });

        lvItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //积分商城
                        Intent intent3 = new Intent();
                        intent3.setClass(getContext(), IntegralShopActivity.class);
                        startActivity(intent3);
                        break;
                    case 1:
                        //新闻资讯
                        Intent intent4 = new Intent();
                        intent4.setClass(getContext(), NewsActivity.class);
                        startActivity(intent4);
                        break;
                    case 2:
                        //联系客服
                        show();
                        break;
                    case 3:
                        //意见反馈
                        Intent intent1 = new Intent();
                        intent1.setClass(getContext(), FeedbackActivity.class);
                        startActivity(intent1);
                        break;
                    case 4:
                        //修改密码
                        Intent intent2 = new Intent();
                        intent2.setClass(getContext(), UpdatePassActivity.class);
                        startActivity(intent2);
                        break;
                    case 5:
                        //关于我们
                        Intent intent = new Intent();
                        intent.setClass(getContext(), AboutUsActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(getContext(), "user");
        userId = loginBean.getRepairUser_ID();
        mPresenter.getUserInfo(userId);

    }

    @Override
    public void stateError() {

    }

    @Override
    public void showUserInfo(UserInfoBean userInfoBean) {
        this.userInfoBean = userInfoBean;
        coupon.setText(userInfoBean.getCouponCount() + "");
        collection.setText(userInfoBean.getCollectionCount() + "");
        money.setText(userInfoBean.getCurrentRepairUser().getRepairUser_CreditMoney() + "");
        integral.setText(userInfoBean.getCurrentRepairUser().getRepairUser_Integer() + "");
        tvGongsi.setText(userInfoBean.getCurrentRepairUser().getRepairUser_Name() + "");
        orderListAdapter = new OrderListAdapter(getContext());
        gridOrder.setAdapter(orderListAdapter);
        List<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("待付款", R.drawable.wait_send_out_goods, userInfoBean.getWaitOrder()));
        list.add(new OrderItem("待发货", R.drawable.wait_payment, userInfoBean.getPayCompluteOrder()));
        list.add(new OrderItem("待收货", R.drawable.wait_collect_goods, userInfoBean.getWaitGoodsOrder()));
        list.add(new OrderItem("已完成", R.drawable.complete, userInfoBean.getCompluteOrder()));
        list.add(new OrderItem("退货/售后", R.drawable.return_goods, userInfoBean.getSaleOrder()));
        orderListAdapter.addFristData(list);
        SpUtil.getObject(getContext(),"userInfo");
    }



    @OnClick({R.id.ll_money, R.id.ll_collection, R.id.ll_coupon, R.id.ll_integral,R.id.tv_gongsi,R.id.tv_exit_login,R.id.all_order})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_gongsi:
                Intent starter = new Intent(getContext(), UpdateAddressActivity.class);
                starter.putExtra("userInfo",userInfoBean.getCurrentRepairUser());
                startActivityForResult(starter,1);
                break;
            case R.id.ll_money:
                //信用使用记录
                MyMoneyActivity.start(getContext(),new Gson().toJson(userInfoBean));
                break;
            case R.id.ll_collection:
                intent.setClass(getContext(), MyCollectActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_coupon:
                intent.setClass(getContext(), MyCouponActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_integral:
                intent.setClass(getContext(), MyIntegralActivity.class);
                if (userInfoBean != null) {
                    intent.putExtra("integer", userInfoBean.getCurrentRepairUser().getRepairUser_Integer() + "");
                }else {
                    intent.putExtra("integer", "0");
                }
                startActivity(intent);
                break;
            case R.id.tv_exit_login:
                SpUtil.removeObject(getContext(),"user");
                getActivity().finish();
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.all_order:
                AllOrderActivity.start(getContext());
                break;
        }
    }

    private void show() {
        final Dialog bottomDialog = new Dialog(getContext(), R.style.BottomDialog);
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_content_normal, null);
        TextView tv_cancel = contentView.findViewById(R.id.tv_cancel);
        TextView tv_phone_2 = contentView.findViewById(R.id.tv_phone_2);
        TextView tv_phone_1 = contentView.findViewById(R.id.tv_phone_1);

        if (userInfoBean != null && userInfoBean.getListServicePhone().size() > 0){
            try {
                tv_phone_1.setText(userInfoBean.getListServicePhone().get(0).getItemValue());
                tv_phone_2.setText(userInfoBean.getListServicePhone().get(1).getItemValue());
                tv_phone_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ScreenUtils.diallPhone(getContext(),userInfoBean.getListServicePhone().get(0).getItemValue());
                    }
                });
                tv_phone_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ScreenUtils.diallPhone(getContext(),userInfoBean.getListServicePhone().get(1).getItemValue());
                    }
                });
            }catch (IndexOutOfBoundsException e){

            }
        }

        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog.cancel();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getUserInfo(userId);
    }


}
