package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralGoodsActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntegralShopAdapter extends BaseAdapter<IntergralShopBean> {

    private Item2Adapter item2Adapter;

    public IntegralShopAdapter(Context context) {
        super(context);
    }

    public void addFirstDataSet(IntergralShopBean data) {
        List<IntergralShopBean.IntegerGoodsListBean> listBeans = data.getIntegerGoodsList();
        IntergralShopBean.IntegerGoodsListBean integerGoodsListBean = new IntergralShopBean.IntegerGoodsListBean();
        integerGoodsListBean.setImg(R.drawable.all_classify);
        integerGoodsListBean.setIntegerGoodsType_Name("全部分类");
        listBeans.add(integerGoodsListBean);
        data.setIntegerGoodsList(listBeans);
        List<IntergralShopBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(data);
        }
        super.addFirstDataSet(list);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, IntergralShopBean item, int position) {
        if (position == 0){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < item.getBannerList().size(); i++) {
                list.add(item.getBannerList().get(i).getBanner_WxAppImgPath());
            }
            holder.setBannerImg(R.id.banner,list);
        }else if (position == 1){
            RecyclerView recyclerView = holder.getView(R.id.recyclerView_c);
            StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            Item1Adapter adapter = new Item1Adapter(getContext());
            recyclerView.setAdapter(adapter);
            adapter.addFirstDataSet(item.getIntegerGoodsList());
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    IntergralShopBean.IntegerGoodsListBean intergralShopBean = (IntergralShopBean.IntegerGoodsListBean) item;
                    IntegralGoodsActivity.start(getContext(), intergralShopBean.getIntegerGoodsType_ID());
                }
            });
        }else if (position == 2){
            RecyclerView recyclerView = holder.getView(R.id.recyclerView_item);
            GridLayoutManager linearLayoutManager1 = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(linearLayoutManager1);
            item2Adapter = new Item2Adapter(getContext());
            recyclerView.setAdapter(item2Adapter);
            item2Adapter.addFirstDataSet(item.getIstIntegerGoods());
            item2Adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    IntergralShopBean.IstIntegerGoods intergralShopBean = (IntergralShopBean.IstIntegerGoods) item;
                    GoodsDetailsActivity.newInstance(getContext(),intergralShopBean);
                }
            });
        }
    }

    public void addMore(IntergralShopBean data){
        item2Adapter.addMoreDataSet(data.getIstIntegerGoods());
    }

    @Override
    protected int getItemViewLayoutId(int position, IntergralShopBean item) {
        if (position == 0){
            return R.layout.integral_shop_item;
        }else if (position == 1){
            return R.layout.integral_shop_item1;
        }else {
            return R.layout.integral_shop_item2;
        }
    }

    public class Item1Adapter extends BaseAdapter<IntergralShopBean.IntegerGoodsListBean>{

        public Item1Adapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, IntergralShopBean.IntegerGoodsListBean item, int position) {
            if (item.getImg() != 0){
                holder.setText(R.id.tv_text,item.getIntegerGoodsType_Name());
                holder.setImageResource(R.id.img_classify,item.getImg());
            }else {
                holder.setText(R.id.tv_text, item.getIntegerGoodsType_Name());
                holder.setGlieuImage(R.id.img_classify, item.getIntegerGoodsType_ImgPath());
            }
        }

        @Override
        protected int getItemViewLayoutId(int position, IntergralShopBean.IntegerGoodsListBean item) {
            return R.layout.item_integral_shop;
        }
    }

    public class Item2Adapter extends BaseAdapter<IntergralShopBean.IstIntegerGoods>{

        public Item2Adapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, IntergralShopBean.IstIntegerGoods item, int position) {
            holder.setGlieuImage(R.id.img_good,item.getIntegerGoods_ImgPath());
            holder.setText(R.id.tv_price,item.getIntegerGoods_Integer()+"");
            holder.setText(R.id.tv_houz,"积分");
            holder.setText(R.id.goods_desc,item.getIntegerGoods_Name());

        }

        @Override
        protected int getItemViewLayoutId(int position, IntergralShopBean.IstIntegerGoods item) {
            return R.layout.item2_integral_shop;
        }
    }
}
