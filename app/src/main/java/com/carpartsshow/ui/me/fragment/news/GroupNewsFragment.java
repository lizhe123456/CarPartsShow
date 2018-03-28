package com.carpartsshow.ui.me.fragment.news;

import android.os.Bundle;
import android.os.Parcelable;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.ui.classify.fragment.BrandFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/18.
 */

public class GroupNewsFragment extends BaseFragment {



    public static GroupNewsFragment newInstance(List<ClassificationBean.ListBrandBean> list){
        GroupNewsFragment myFragment = new GroupNewsFragment();
        Bundle bundle = new Bundle();

        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_group_news;
    }


    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }
}
