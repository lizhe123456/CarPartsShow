package com.whmnrc.carpartsshow.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;


/**
 * Created by lizhe on 2018/3/18.
 * 类介绍：
 */

public class LoadingDialog extends Dialog {

    private TextView textView;

    public LoadingDialog(Context context) {
        super(context, R.style.ZlCustomerServiceDialog);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loading);
        textView = (TextView) findViewById(R.id.id_tv_loading_dialog_text);
        setCanceledOnTouchOutside(false);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     * @param message 给用户展示的提示信息
     *
     */
    public LoadingDialog setMessage(String message) {
        textView.setText(message);
        return this;
    }
}
