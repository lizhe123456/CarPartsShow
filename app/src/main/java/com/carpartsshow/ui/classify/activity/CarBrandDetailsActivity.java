package com.carpartsshow.ui.classify.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.CarFilterBean;
import com.carpartsshow.presenter.classify.CarFilterPresenter;
import com.carpartsshow.presenter.classify.contract.CarFilterContract;
import com.carpartsshow.ui.classify.adapter.CarBrandDetailsAdapter;
import com.carpartsshow.widgets.AnimatedExpandableListView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/30.
 */

public class CarBrandDetailsActivity extends MvpActivity<CarFilterPresenter> implements CarFilterContract.View {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.expandable_lv)
    AnimatedExpandableListView expandableListView;

    private CarBrandDetailsAdapter mAdapter;
    private boolean flag;

    @Override
    protected int setLayout() {
        return R.layout.activity_car_brand;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        String group = getIntent().getStringExtra("group");
        title.setText(group);
        mPresenter.carFilter(group);
        mAdapter = new CarBrandDetailsAdapter(this);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadData(CarFilterBean carFilterBean) {
        expandableListView.setAdapter(mAdapter);
        mAdapter.loadData(carFilterBean.getListCXI());
        mAdapter.setOnOpenListener(new CarBrandDetailsAdapter.OnOpenListener() {
            @Override
            public void open(int groupPosition) {
                if (flag) {
                    flag = false;
                    expandableListView.collapseGroupWithAnimation(groupPosition);
                }else {
                    flag = true;
                    expandableListView.expandGroupWithAnimation(groupPosition);
                }
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

        mAdapter.setOnItemListener(new CarBrandDetailsAdapter.OnItemListener() {
            @Override
            public void OnGroupItemClick(CarFilterBean.ListCXIBean listCXIBean) {

            }

            @Override
            public void OnSubItemClick(CarFilterBean.ListCXIBean listCXIBean, CarFilterBean.ListCXIBean.ListCarsBean listCarsBean) {
                Intent intent = new Intent();
                intent.putExtra("cid",listCarsBean.getID());
                intent.putExtra("label",listCarsBean.getLabel());
                setResult(1,intent);
                CarBrandDetailsActivity.this.finish();
            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
