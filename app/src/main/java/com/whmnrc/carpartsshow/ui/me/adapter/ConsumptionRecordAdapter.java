package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by lizhe on 2018/3/29.
 */

public class ConsumptionRecordAdapter extends BaseAdapter<ConsumptionRecordBean> {

    private int type;

    public ConsumptionRecordAdapter(Context context, int type) {
        super(context);
        this.type = type;
    }

    @Override
    protected void bindDataToItemView(final BaseViewHolder holder, final ConsumptionRecordBean item, int position) {

        holder.setTag(R.id.tv_num, "金额：" + item.getCredit_AllMoney())
                .setText(R.id.tv_f_price, "退款金额：" + item.getCredit_BackMoney())
                .setText(R.id.tv_item_2, "总积分：" + item.getCredit_Integer())
                .setText(R.id.tv_item_3, "冻结积分：" + item.getCredit_FrozenInteger())
                .setText(R.id.tv_item_4, "损失积分：" + item.getCredit_LossInteger())
                .setText(R.id.tv_item_5, "退货积分：" + item.getCredit_BackInteger())
                .setText(R.id.tv_item_6, "有效积分：" + item.getCredit_ValidInteger())
                .setText(R.id.tv_time, "记账周期：" + stringDateString(item.getCredit_StartTime()) + "至" + stringDateString(item.getCredit_EndTime()));


        holder.setOnClickListener(R.id.tv_cat_d, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!item.isShow()) {
                    holder.setVisible(R.id.ll_rv, true);
                    item.setShow(true);
                } else {
                    holder.setVisible(R.id.ll_rv, false);
                    item.setShow(false);
                }
            }
        });
        if (type == 0) {
            holder.setText(R.id.tv_go, "已还款");
            holder.setTextColor(R.id.tv_go, android.R.color.holo_green_dark);
        } else if (type == 1) {
            holder.setText(R.id.tv_go, "去还款");
            holder.setTextColor(R.id.tv_go, android.R.color.holo_red_dark);

        }

        RecyclerView recyclerView = holder.getView(R.id.rv_d);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RVDAdapter adapter = new RVDAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(item.getListDetail());
    }

    @Override
    protected int getItemViewLayoutId(int position, ConsumptionRecordBean item) {
        return R.layout.item_consumption_record;
    }


    public class RVDAdapter extends BaseAdapter<ConsumptionRecordBean.ListDetailBean> {

        public RVDAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ConsumptionRecordBean.ListDetailBean item, int position) {
            holder.setText(R.id.tv_order_num, item.getOrder_No()).setText(R.id.tv_time, item.getCreditRecord_CreateTime()).setText(R.id.tv_num, item.getCreditRecord_Money() + "");
        }

        @Override
        protected int getItemViewLayoutId(int position, ConsumptionRecordBean.ListDetailBean item) {
            return R.layout.item_rvd;
        }
    }

    private String stringDateString(String date) {
        try {
            date = date.replace("T","");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            Date dt2 = sdf.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(dt2);
            return dateString;
        } catch (ParseException e) {
//            e.printStackTrace();
            return "";
        }
    }
}
