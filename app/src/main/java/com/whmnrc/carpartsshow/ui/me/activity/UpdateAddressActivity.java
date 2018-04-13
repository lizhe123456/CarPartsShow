package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.AddressBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.presenter.me.UpdateAddressPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.UpdateAddressContract;
import com.whmnrc.carpartsshow.ui.me.adapter.bean.CityBean;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.AddressDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;

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

    String add;
    //省编码
    String pCode = "110000";
    //市编码
    String cCode = "110100";
    String aCode = "110101";

    private boolean isFrist = false;
    private boolean isRun = false;
    private UserInfoBean.CurrentRepairUserBean currentRepairUser;

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
        currentRepairUser = (UserInfoBean.CurrentRepairUserBean) getIntent().getSerializableExtra("userInfo");
         if (currentRepairUser != null) {
            if (!TextUtils.isEmpty(currentRepairUser.getRepairUser_Provice()) && !TextUtils.isEmpty(currentRepairUser.getRepairUser_City())){
                pCode = currentRepairUser.getRepairUser_Provice();
                cCode = currentRepairUser.getRepairUser_City();
                aCode = currentRepairUser.getRepairUser_Region() == null ? "" : currentRepairUser.getRepairUser_Region();
                add = currentRepairUser.getRepairUser_DetailAddress() == null ? "" : currentRepairUser.getRepairUser_DetailAddress();
//                mPresenter.getAreaList();
//                isRun = true;
                tvAdd.setText(add);
                tvAdd.setSelection(add.length());
                tvAddA.setText(currentRepairUser.getRepairUser_RegionName());
                tvAddS.setText(currentRepairUser.getRepairUser_ProviceName());
                tvAddC.setText(currentRepairUser.getRepairUser_CityName());
            }else {

            }
        }
    }




    @OnClick({R.id.iv_back, R.id.tv_save,R.id.tv_add_a,R.id.tv_add_c,R.id.tv_add_s})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_save:
                LoginBean loginBean = SpUtil.getObject(this,"user");
                String address = tvAdd.getText().toString().trim();
                if (TextUtils.isEmpty(address)){
                    CPSToast.showText(this,"详细地址不能为空");
                }else {
                    mPresenter.updateAddress(loginBean.getRepairUser_ID(), pCode, cCode, aCode,address);
                }
                break;
            case R.id.tv_add_s:
                mPresenter.getAreaList();
                break;
            case R.id.tv_add_c:
                if (pCode != null) {
                    mPresenter.getAreaList(pCode, 1);
                }
                break;
            case R.id.tv_add_a:
                if (cCode != null) {
                    mPresenter.getAreaList(cCode, 2);
                }
                break;
        }

    }

    @Override
    public void stateError() {

    }

    @Override
    public void state(String msg) {
        CPSToast.showText(this,msg);
        setResult(2);
        finish();
    }

    @Override
    public void showAddress(List<AddressBean.ResultdataBean> addressBean) {


    }

    @Override
    public void setP(final List<AddressBean.ResultdataBean> addressBean) {
        if (isFrist) {
            for (int i = 0; i < addressBean.size(); i++) {
                if (addressBean.get(i).getAreaId().equals(pCode)) {
                    tvAddS.setText(addressBean.get(i).getAreaName());
                    pCode = addressBean.get(i).getAreaId();
                    mPresenter.getAreaList(pCode,1);
                    if (TextUtils.isEmpty(cCode)){
                        isFrist = false;
                    }
                    break;
                }
            }
        }else {
            for (int i = 0; i < addressBean.size(); i++) {
                if (pCode.equals(addressBean.get(i).getAreaId())) {
                    addressBean.get(i).setSelect(true);
                    break;
                }
            }
            final AddressDialog dialog = new AddressDialog(this);
            final ListAdapter listAdapter = new ListAdapter(this);
            dialog.show(listAdapter, addressBean);
            listAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    for (int i = 0; i < addressBean.size(); i++) {
                        addressBean.get(i).setSelect(false);
                    }
                    addressBean.get(position).setSelect(true);
                    listAdapter.addFirstDataSet(addressBean);
                    AddressBean.ResultdataBean resultdataBean = (AddressBean.ResultdataBean) item;
                    tvAddS.setText(resultdataBean.getAreaName());
                    mPresenter.getAreaList(resultdataBean.getAreaId(),1);
                    loading("加载中..");
                    isRun = true;
                    pCode = resultdataBean.getAreaId();
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void setC(final List<AddressBean.ResultdataBean> addressBean) {
        if (isFrist) {
            for (int i = 0; i < addressBean.size(); i++) {
                if (addressBean.get(i).getAreaId().equals(cCode)) {
                    tvAddC.setText(addressBean.get(i).getAreaName());
                    cCode = addressBean.get(i).getAreaId();
                    mPresenter.getAreaList(cCode,2);
                    if (TextUtils.isEmpty(aCode)){
                        isFrist = false;
                    }
                    break;
                }
            }
        }else if (isRun){
            tvAddC.setText(addressBean.get(0).getAreaName());
            mPresenter.getAreaList(addressBean.get(0).getAreaId(),2);
            cCode = addressBean.get(0).getAreaId();
            loading("加载中");
        } else {
            for (int i = 0; i < addressBean.size(); i++) {
                if (cCode.equals(addressBean.get(i).getAreaId())) {
                    addressBean.get(i).setSelect(true);
                    break;
                }
            }
            final AddressDialog dialog = new AddressDialog(this);
            final ListAdapter listAdapter = new ListAdapter(this);
            dialog.show(listAdapter, addressBean);
            listAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    for (int i = 0; i < addressBean.size(); i++) {
                        addressBean.get(i).setSelect(false);
                    }
                    addressBean.get(position).setSelect(true);
                    listAdapter.addFirstDataSet(addressBean);
                    AddressBean.ResultdataBean resultdataBean = (AddressBean.ResultdataBean) item;
                    tvAddC.setText(resultdataBean.getAreaName());
                    mPresenter.getAreaList(resultdataBean.getAreaId(),2);
                    isRun = true;
                    cCode = resultdataBean.getAreaId();
                    loading("加载中");
                    dialog.dismiss();
                }
            });
        }
    }

    @Override
    public void setA(final List<AddressBean.ResultdataBean> addressBean) {
        if (isFrist) {
            for (int i = 0; i < addressBean.size(); i++) {
                if (addressBean.get(i).getAreaId().equals(aCode)) {
                    tvAddA.setText(addressBean.get(i).getAreaName());
                    aCode = addressBean.get(i).getAreaId();
                    break;
                }
            }
            isFrist = false;
        }else if (isRun){
            tvAddA.setText(addressBean.get(0).getAreaName());
            aCode = addressBean.get(0).getAreaId();
            unLoading();
            isRun = false;
        }else {
            for (int i = 0; i < addressBean.size(); i++) {
                if (aCode.equals(addressBean.get(i).getAreaId())) {
                    addressBean.get(i).setSelect(true);
                    break;
                }
            }
            final AddressDialog dialog = new AddressDialog(this);
            final ListAdapter listAdapter = new ListAdapter(this);
            dialog.show(listAdapter, addressBean);
            listAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    for (int i = 0; i < addressBean.size(); i++) {
                        addressBean.get(i).setSelect(false);
                    }
                    addressBean.get(position).setSelect(true);
                    listAdapter.addFirstDataSet(addressBean);
                    AddressBean.ResultdataBean resultdataBean = (AddressBean.ResultdataBean) item;
                    tvAddA.setText(resultdataBean.getAreaName());
                    aCode = resultdataBean.getAreaId();
                    dialog.dismiss();
                }
            });
        }
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
