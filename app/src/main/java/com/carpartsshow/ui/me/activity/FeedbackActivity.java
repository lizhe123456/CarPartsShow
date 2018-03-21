package com.carpartsshow.ui.me.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.FeedBackPresenter;
import com.carpartsshow.presenter.me.contract.FeedBackContract;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class FeedbackActivity extends MvpActivity<FeedBackPresenter> implements FeedBackContract.View {
    @BindView(R.id.feed_back)
    EditText feedBack;
    @BindView(R.id.tv_num)
    TextView tvNum;
    private static final int MAX_LENGTH = 20;
    private String feedText;

    @Override
    protected int setLayout() {
        return R.layout.activity_feedback;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        feedBack.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String content = feedBack.getText().toString();
                tvNum.setText("("+content.length() + "/"
                        + MAX_LENGTH+")");
            }

        });
    }

    @OnClick({R.id.iv_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_submit:
                feedText = feedBack.getText().toString();
                if (TextUtils.isEmpty(feedText)){
                    CPSToast.showText(this,"请输入意见");
                    return;
                }
                LoginBean loginBean = SpUtil.getObject(this,"user");
                mPresenter.submitFeedback(feedText, loginBean.getRepairUser_ID());
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void state() {
        CPSToast.showText(this,"提交成功");
        this.finish();
    }
}
