package com.whmnrc.carpartsshow.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;

import java.util.List;


/**
 * Created by lizhe on 2017/12/23.
 * 类介绍：自定义对话框
 */

public class ScanCodeDialog extends Dialog {

    RecyclerView recyclerView;

    public ScanCodeDialog(@NonNull Context context) {
        super(context, R.style.BottomDialogSty);

    }

    public ScanCodeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_dialog);
        recyclerView = findViewById(R.id.recyclerView);
        Window dialogWindow = this.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.BottomDialog_Animation); // 添加动画
        dialogWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
    }


    public void show(BaseAdapter adapter, List list) {
        if (!this.isShowing()) {
            this.show();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
            adapter.addFirstDataSet(list);
        }
    }


}
