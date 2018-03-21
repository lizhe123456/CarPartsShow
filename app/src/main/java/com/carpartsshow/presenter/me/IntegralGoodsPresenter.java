package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.IntegralGoodsContract;
import com.carpartsshow.util.RxUtil;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntegralGoodsPresenter extends BasePresenterImpl<IntegralGoodsContract.View> implements IntegralGoodsContract.Presenter {

    DataManager dataManager;
    private int page = 1;
    private int size = 10;

    @Inject
    public IntegralGoodsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getGoodsInfo(final int type, String sValue, String userId, String goodsType) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchsplitListIntegerGoods(size,page,sValue,userId,goodsType)
                .compose(RxUtil.<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>>rxSchedulerHelper())
                .compose(RxUtil.<List<IntergralShopBean.IstIntegerGoods>>handle())
                .subscribeWith(new CommonSubscriber<List<IntergralShopBean.IstIntegerGoods>>(mView){
                    @Override
                    public void onNext(List<IntergralShopBean.IstIntegerGoods> list) {
                        super.onNext(list);
                        if (type == 1){
                            mView.showContent(list);
                        }else {
                            mView.loadMore(list);
                        }
                        page++;
                    }
                })
        );
    }
}
