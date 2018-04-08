package com.carpartsshow.ui.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.eventbus.GoodsMoreBean;
import com.carpartsshow.model.http.bean.GoodsListBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.shopping.AddCarPresenter;
import com.carpartsshow.presenter.shopping.contract.AddCarContract;
import com.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.carpartsshow.ui.home.adapter.GoodsListAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/27.
 */

public class GoodsFragment extends MvpFragment<AddCarPresenter> implements AddCarContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private GoodsListAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        EventBus.getDefault().register(this);
        mAdapter = new GoodsListAdapter(getContext());
        final LoginBean loginBean = SpUtil.getObject(getContext(),"user");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                EventBus.getDefault().post(new GoodsMoreBean(2));
            }
        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //向GoodsSearchActivity发送请求，网络请求逻辑在GoodsSearchActivity中
                EventBus.getDefault().post(new GoodsMoreBean(1));
            }
        });
        mAdapter.setOnJoinClickListener(new GoodsListAdapter.OnJoinClickListener() {
            @Override
            public void joinCar(GoodsListBean.ListGoodsBean item) {
                mPresenter.plus(loginBean.getRepairUser_ID(),item.getGoods_ID(),0);
            }
        });
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                GoodsListBean.ListGoodsBean listGoodsBean = (GoodsListBean.ListGoodsBean) item;
                GoodsDetailsActivity.newInstance(getContext(),listGoodsBean.getGoods_ID(),0,"");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateData(GoodsListBean bean){
        //刷新ui
        if (bean.getIsMore() == 1) {
            if (bean.getListGoods().size() == 0){
                CPSToast.showText(getContext(),"没有更多商品了。");
            }
            mAdapter.addFirstDataSet(bean.getListGoods());
            refresh.finishRefresh();
        }else {
            mAdapter.addMoreDataSet(bean.getListGoods());
            refresh.finishLoadmore();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void state(String msg) {
        CPSToast.showText(getContext(),msg);
    }
}
