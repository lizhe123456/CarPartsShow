package com.carpartsshow.ui.me.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.UpdatePassPresenter;
import com.carpartsshow.presenter.me.contract.UpdatePassContract;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class UpdatePassActivity extends MvpActivity<UpdatePassPresenter> implements UpdatePassContract.View {
    @BindView(R.id.et_old_pass)
    EditText etOldPass;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.et_pass2)
    EditText etPass2;

    private LoginBean loginBean;
    private String oldPass;
    private String newFPwd;
    private String newTPwd;

    @Override
    protected int setLayout() {
        return R.layout.activity_update_pass;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(this,"user");
    }


    @OnClick({R.id.iv_back, R.id.tv_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_edit:
                oldPass = etOldPass.getText().toString().trim();
                if (TextUtils.isEmpty(oldPass)){
                    CPSToast.showText(this, "请输入旧密码");
                    return;
                }
                newFPwd = etPass.getText().toString().trim();
                if (TextUtils.isEmpty(newFPwd)){
                    CPSToast.showText(this, "请输入新密码");
                    return;
                }
                newTPwd = etPass2.getText().toString().trim();
                if (TextUtils.isEmpty(newTPwd)){
                    CPSToast.showText(this, "请再次输入新密码");
                    return;
                }

                mPresenter.updatePass(loginBean.getRepairUser_ID(), oldPass, newFPwd, newTPwd);
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void state() {
        CPSToast.showText(this, "修改成功");
        this.finish();
    }

}
