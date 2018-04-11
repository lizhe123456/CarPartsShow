package com.whmnrc.carpartsshow.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;

import java.util.List;


/**
 * Created by lizhe on 2017/12/23.
 * 类介绍：自定义对话框
 */

public class AddressDialog extends Dialog {

    RecyclerView recyclerView;

    public AddressDialog(@NonNull Context context) {
        super(context);
    }

    public AddressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_dialog);
        recyclerView = findViewById(R.id.recyclerView);

    }


    public void show(BaseAdapter adapter, List list){
        this.show();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(list);
    }


}
