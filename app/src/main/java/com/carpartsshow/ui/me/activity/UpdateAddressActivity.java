package com.carpartsshow.ui.me.activity;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.AddressBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.UpdateAddressPresenter;
import com.carpartsshow.presenter.me.contract.UpdateAddressContract;
import com.carpartsshow.ui.me.adapter.bean.CityBean;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.ZlCustomDialog;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class UpdateAddressActivity extends MvpActivity<UpdateAddressPresenter> implements UpdateAddressContract.View {
    @BindView(R.id.tv_add_s)
    TextView tvAddS;
    @BindView(R.id.tv_add_c)
    TextView tvAddC;
    @BindView(R.id.tv_add_a)
    TextView tvAddA;
    @BindView(R.id.et_add)
    EditText tvAdd;
    List<CityBean> list;

    String p;
    String c;
    String a;
    String add;
    //省编码
    String pCode;
    //市编码
    String cCode;

    @Override
    protected int setLayout() {
        return R.layout.activity_update_address;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this,"user");

        p = loginBean.getRepairUser_Provice();
        c = loginBean.getRepairUser_City();
        a = loginBean.getRepairUser_Region();
        add = loginBean.getRepairUser_DetailAddress();
        tvAddS.setText(p);
        tvAddA.setText(a);
        tvAddC.setText(c);
        tvAdd.setText(add);
    }




    @OnClick({R.id.iv_back, R.id.tv_save,R.id.tv_add_a,R.id.tv_add_c,R.id.tv_add_s})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_save:
                break;
            case R.id.tv_add_s:
                mPresenter.getAreaList();
                break;
            case R.id.tv_add_c:
                mPresenter.getAreaList(pCode,1);
                break;
            case R.id.tv_add_a:
                mPresenter.getAreaList(cCode,2);
                ZlCustomDialog dialog2 = new ZlCustomDialog(this);
                break;
        }

    }

    @Override
    public void stateError() {

    }

    @Override
    public void state() {

    }

    @Override
    public void showAddress(List<AddressBean.ResultdataBean> addressBean) {


    }

    @Override
    public void setP(List<AddressBean.ResultdataBean> addressBean) {
        for (int i = 0; i < addressBean.size(); i++) {
            if (p.equals(addressBean.get(i).getAreaName())){
                addressBean.get(i).setSelect(true);
                break;
            }
        }
        ZlCustomDialog dialog = new ZlCustomDialog(this);
        ListAdapter listAdapter = new ListAdapter(this);
        dialog.show(listAdapter,addressBean);
    }

    @Override
    public void setC(List<AddressBean.ResultdataBean> addressBean) {
        ZlCustomDialog dialog = new ZlCustomDialog(this);
        ListAdapter listAdapter = new ListAdapter(this);
        dialog.show(listAdapter,addressBean);
    }

    @Override
    public void setA(List<AddressBean.ResultdataBean> addressBean) {
        ZlCustomDialog dialog = new ZlCustomDialog(this);
        ListAdapter listAdapter = new ListAdapter(this);
        dialog.show(listAdapter,addressBean);
    }


    public class ListAdapter extends BaseAdapter<AddressBean.ResultdataBean> {

        public ListAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, AddressBean.ResultdataBean item, int position) {
            holder.setText(R.id.tv_pca,item.getAreaName());
            if (item.isSelect()){
                holder.setImageResource(R.id.iv_select,R.drawable.round_btn_selected);
            }else {
                holder.setImageResource(R.id.iv_select,R.drawable.round_btn_normal);
            }

        }

        @Override
        protected int getItemViewLayoutId(int position, AddressBean.ResultdataBean item) {
            return R.layout.city_item;
        }
    }



}
