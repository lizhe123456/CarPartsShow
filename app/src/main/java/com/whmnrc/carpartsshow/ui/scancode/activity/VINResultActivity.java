package com.whmnrc.carpartsshow.ui.scancode.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.BaiduWord;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.presenter.scancode.ScanCodePresenter;
import com.whmnrc.carpartsshow.presenter.scancode.contract.ScanCodeContract;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.scancode.ImgPretreatment;
import com.whmnrc.carpartsshow.ui.scancode.RecognizeService;
import com.whmnrc.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.whmnrc.carpartsshow.util.FileUtil;
import com.whmnrc.carpartsshow.util.GlideuUtil;
import com.whmnrc.carpartsshow.util.ImageUtil;
import com.whmnrc.carpartsshow.util.VINUtil;
import com.whmnrc.carpartsshow.view.ScanCodeDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.whmnrc.carpartsshow.ui.scancode.ImgPretreatment.converyToGrayImg;
import static com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity.saveBitmapToSd;

/**
 * Created by lizhe on 2018/4/13.
 */

public class VINResultActivity extends MvpActivity<ScanCodePresenter> implements ScanCodeContract.View {

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.et_vin_num)
    EditText etSearch;
    @BindView(R.id.title)
    TextView title;

    public static void start(Context context, String path, String vin) {
        Intent starter = new Intent(context, VINResultActivity.class);
        starter.putExtra("path", path);
        starter.putExtra("vin", vin);
        context.startActivity(starter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(List<CarModelByVINBean> list) {
        final ScanCodeDialog dialog = new ScanCodeDialog(VINResultActivity.this);
        ScanCodeCarBrandAdapter scanCodeCarBrandAdapter = new ScanCodeCarBrandAdapter(VINResultActivity.this);
        scanCodeCarBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CarModelByVINBean carModelByVINBean = (CarModelByVINBean) item;
                Intent intent = new Intent(VINResultActivity.this, GoodsSearchActivity.class);
                intent.putExtra("NLevelID", carModelByVINBean.getNLevelID());
                intent.putExtra("carBrand", carModelByVINBean.getPP() + " " + carModelByVINBean.getCX() + "--排量 " + carModelByVINBean.getPL() + " " + carModelByVINBean.getNK());
                startActivity(intent);
                VINResultActivity.this.finish();
            }
        });
        dialog.show(scanCodeCarBrandAdapter, list);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_vin_result;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void setData() {
        title.setText("识别结果");
        String path = getIntent().getStringExtra("path");
        String vin = getIntent().getStringExtra("vin");
        if (!TextUtils.isEmpty(path)) {
            GlideuUtil.loadImageView(this, path, ivImg);
            etSearch.setText(vin);
            etSearch.setSelection(vin.length());
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @OnClick({R.id.iv_back, R.id.tv_qu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_qu:
                String vin = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(vin) || !VINUtil.checkVIN(vin)) {
                    CPSToast.showText(this, "请输入17位VIN码");
                } else {
                    mPresenter.getVinCode(vin);
                }
                break;
        }
    }

}
