package com.whmnrc.carpartsshow.ui.me.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.CollectionBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.CollectionPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.CollectionContract;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.me.adapter.CollectionAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 * 我的收藏
 */

public class MyCollectActivity extends MvpActivity<CollectionPresenter> implements CollectionContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.ll_select)
    LinearLayout llSelect;
    @BindView(R.id.all_select)
    TextView allSelect;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private CollectionAdapter mAdapter;

    private boolean isEdit;
    private boolean isAllSelect;
    private LoginBean loginBean;

    @Override
    protected int setLayout() {
        return R.layout.activity_collect;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(this, "user");
        mPresenter.getCollectionList(loginBean.getRepairUser_ID(), 1);
        mAdapter = new CollectionAdapter(this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getCollectionList(loginBean.getRepairUser_ID(), 2);
            }
        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getCollectionList(loginBean.getRepairUser_ID(), 1);
            }
        });
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CollectionBean.CollectionListProductBean collectionBean = (CollectionBean.CollectionListProductBean) item;
                GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(collectionBean.getUrl(), collectionBean.isCollection(), collectionBean.getCarCount());
                GoodsDetailsActivity.newInstance(MyCollectActivity.this, goodsDetailToBean);
//                GoodsDetailsActivity.newInstance(MyCollectActivity.this,collectionBean.getCollection_ProductID(),collectionBean.getCollection_Type());
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_edit, R.id.all_select, R.id.tv_delete, R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_edit:
                if (!isEdit) {
                    isEdit = true;
                    tvEdit.setText("完成");
                    llSelect.setVisibility(View.VISIBLE);
                    mAdapter.showSelect();
                } else {
                    isEdit = false;
                    tvEdit.setText("编辑");
                    llSelect.setVisibility(View.GONE);
                    mAdapter.hipeSelect();
                }
                break;
            case R.id.all_select:
                if (!isAllSelect) {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.round_btn_selected);
                    allSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    allSelect.setCompoundDrawablePadding(8);
                    isAllSelect = true;
                    mAdapter.allSelect(isAllSelect);

                } else {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.round_btn_normal);
                    allSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    allSelect.setCompoundDrawablePadding(8);
                    isAllSelect = false;
                    mAdapter.allSelect(isAllSelect);
                }
                break;
            case R.id.tv_delete:
                String pids = "";
                List<CollectionBean.CollectionListProductBean> list = new ArrayList<>();
                for (int i = 0; i < mAdapter.getDataSource().size(); i++) {
                    if (mAdapter.getDataSource().get(i).isSelect()) {
                        list.add(mAdapter.getDataSource().get(i));
                    }

                }
                for (CollectionBean.CollectionListProductBean coll : list) {
                    if (list.size() == 1) {
                        pids += coll.getCollection_ProductID() + "," + coll.getCollection_Type();
                    } else {
                        pids += coll.getCollection_ProductID() + "," + coll.getCollection_Type() + "|";
                    }
                }
                mPresenter.delCollections(pids);
                break;
            case R.id.tv_add:
                //加入购物车
                String cids = "";
                List<CollectionBean.CollectionListProductBean> list1 = new ArrayList<>();
                for (int i = 0; i < mAdapter.getDataSource().size(); i++) {
                    if (mAdapter.getDataSource().get(i).isSelect()) {
                        list1.add(mAdapter.getDataSource().get(i));
                    }

                }
                for (CollectionBean.CollectionListProductBean coll : list1) {
                    if (list1.size() == 1) {
                        cids += coll.getCollection_ProductID() + "," + coll.getCollection_Type();
                    } else {
                        cids += coll.getCollection_ProductID() + "," + coll.getCollection_Type() + "|";
                    }
                }
                mPresenter.plus(loginBean.getRepairUser_ID(), cids);
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(CollectionBean collectionBean) {
        if (collectionBean.getCollectionListProduct().size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        refresh.finishRefresh();
        mAdapter.addFirstDataSet(collectionBean.getCollectionListProduct());
    }

    @Override
    public void loadMore(CollectionBean couponBean) {
        refresh.finishLoadmore();
        mAdapter.addMoreDataSet(couponBean.getCollectionListProduct());
    }

    @Override
    public void state(String msg) {
        CPSToast.showText(this, msg);
        mPresenter.getCollectionList(loginBean.getRepairUser_ID(), 1);
    }


    @Override
    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.order_empty);
            textView.setText("暂无更多数据~");
        }
    }
}
