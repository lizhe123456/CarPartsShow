package com.carpartsshow.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carpartsshow.R;

/**
 * Created by lizhe on 2018/3/30.
 */

public class PayDialog extends Dialog {


    private ImageView selectAli;
    private ImageView selectWx;
    private ImageView selectCredit;
    private LinearLayout llAli;
    private LinearLayout llWx;
    private LinearLayout llCredit;
    private TextView tvPay;
    private Context context;
    private boolean isCredit = true;

    private View.OnClickListener onWxClickListener;
    private View.OnClickListener onALiClickListener;
    private View.OnClickListener onPayClickListener;
    private View.OnClickListener onCreditClickListener;

    public PayDialog(@NonNull Context context) {
        super(context,R.style.BottomDialogSty);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay);
        Window dialogWindow = this.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.BottomDialog_Animation); // 添加动画
        dialogWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
        selectAli = findViewById(R.id.select_ali);
        selectWx = findViewById(R.id.select_wx);
        selectCredit = findViewById(R.id.select_credit);
        llAli = findViewById(R.id.ali_ll);
        llWx = findViewById(R.id.wx_ll);
        llCredit = findViewById(R.id.credit_ll);
        tvPay = findViewById(R.id.tv_pay);
    }

    @Override
    public void show() {
        super.show();
        show(this);
    }

    public void show(PayDialog payDialog){
        if (onWxClickListener != null){
            payDialog.tvPay.setOnClickListener(payDialog.onPayClickListener);
        }

        if (onALiClickListener != null){
            payDialog.llWx.setOnClickListener(payDialog.onWxClickListener);
        }

        if (onPayClickListener != null){
            payDialog.llAli.setOnClickListener(payDialog.onALiClickListener);
        }

        if (onCreditClickListener != null){
            payDialog.llCredit.setOnClickListener(payDialog.onCreditClickListener);
        }

        if (!isCredit){
            payDialog.llCredit.setVisibility(View.GONE);
        }
    }

    public void select(int type){
        switch (type){
            case 0:
                selectAli.setImageResource(R.drawable.round_btn_selected);
                selectCredit.setImageResource(R.drawable.round_btn_normal);
                selectWx.setImageResource(R.drawable.round_btn_normal);
                break;
            case 1:
                selectWx.setImageResource(R.drawable.round_btn_selected);
                selectCredit.setImageResource(R.drawable.round_btn_normal);
                selectAli.setImageResource(R.drawable.round_btn_normal);
                break;
            case 2:
                selectCredit.setImageResource(R.drawable.round_btn_selected);
                selectWx.setImageResource(R.drawable.round_btn_normal);
                selectAli.setImageResource(R.drawable.round_btn_normal);
                break;
        }
    }

    public static class Builder {
        private PayDialog mDialog;

        public Builder(Context context) {
            mDialog = new PayDialog(context);
        }

        public Builder setCreditListener(View.OnClickListener onCreditClickListener) {
            mDialog.onCreditClickListener = onCreditClickListener;
            return this;
        }

        public Builder setPayListener(View.OnClickListener onPayClickListener) {
            mDialog.onPayClickListener = onPayClickListener;
            return this;
        }

        public Builder setWXListener(View.OnClickListener onWxClickListener) {
            mDialog.onWxClickListener = onWxClickListener;
            return this;
        }

        public Builder setAliListener(View.OnClickListener onALiClickListener) {
            mDialog.onALiClickListener = onALiClickListener;
            return this;
        }

        public Builder setIsCredit(boolean flag){
            mDialog.isCredit = flag;
            return this;
        }

        public PayDialog build() {
            return mDialog;
        }
    }
}
