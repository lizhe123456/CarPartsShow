package com.carpartsshow.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.AddressBean;
import com.carpartsshow.ui.me.adapter.bean.CityBean;

import java.util.List;


/**
 * Created by lizhe on 2017/12/23.
 * 类介绍：自定义对话框
 */

public class ZlCustomDialog extends Dialog {

    RecyclerView recyclerView;
    public LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_dialog);
        recyclerView = findViewById(R.id.recyclerView);
    }


    public void show(BaseAdapter<AddressBean.ResultdataBean> adapter, List<AddressBean.ResultdataBean> list){
        this.show();
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(list);
    }

    public ZlCustomDialog(Context context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }


}
