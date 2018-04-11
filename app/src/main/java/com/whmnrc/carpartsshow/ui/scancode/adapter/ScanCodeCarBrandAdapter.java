package com.whmnrc.carpartsshow.ui.scancode.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;

/**
 * Created by lizhe on 2018/4/10.
 */

public class ScanCodeCarBrandAdapter extends BaseAdapter<CarModelByVINBean> {

    public ScanCodeCarBrandAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, CarModelByVINBean item, int position) {
        holder.setText(R.id.tv_car_brand,item.getDescribe());
    }

    @Override
    protected int getItemViewLayoutId(int position, CarModelByVINBean item) {
        return R.layout.item_scan_car_brand;
    }
}
