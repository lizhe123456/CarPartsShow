package com.carpartsshow.ui.classify.fragment;

import android.os.Bundle;
import android.os.Parcelable;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.model.http.bean.ClassificationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/27.
 * 分类-车型
 */

public class CarBrandFragment extends BaseFragment{


    public static CarBrandFragment newInstance(List<ClassificationBean.ListCarBrandBean> list){
        CarBrandFragment myFragment = new CarBrandFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_car_brand;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }
}
