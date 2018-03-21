package com.carpartsshow.ui.me.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.CollectionBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.CollectionPresenter;
import com.carpartsshow.presenter.me.contract.CollectionContract;
import com.carpartsshow.ui.me.adapter.CollectionAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
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

    private CollectionAdapter mAdapter;

    private boolean isEdit;
    private boolean isAllSelect;

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
        LoginBean loginBean = SpUtil.getObject(this,"user");
        mPresenter.getCollectionList(loginBean.getRepairUser_ID(),1);
        mAdapter = new CollectionAdapter(this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
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
                    mAdapter.allSelect(isAllSelect);
                    isAllSelect = true;
                }else {
                    Drawable drawableLeft = getResources().getDrawable(
                            R.drawable.round_btn_normal);
                    allSelect.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    allSelect.setCompoundDrawablePadding(8);
                    mAdapter.allSelect(isAllSelect);
                    isAllSelect = true;
                }
                break;
            case R.id.tv_delete:
                CPSToast.showText(this,"  ");
                break;
            case R.id.tv_add:
                CPSToast.showText(this,"  ");
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(CollectionBean collectionBean) {
        mAdapter.addFirstDataSet(collectionBean.getCollectionListProduct());
    }

    @Override
    public void loadMore(CollectionBean couponBean) {
        mAdapter.addMoreDataSet(couponBean.getCollectionListProduct());
    }
}
