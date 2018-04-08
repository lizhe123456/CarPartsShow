package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.SeckillGoodsBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.TimelimitContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/4/8.
 */

public class TimelimitPresenter extends BasePresenterImpl<TimelimitContract.View> implements TimelimitContract.Presenter {
    DataManager dataManager;

    int page = 1;

    @Inject
    public TimelimitPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getTimeData(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchListSplitSeckillGoods(userId,page)
                .compose(RxUtil.<CPSResponse<List<SeckillGoodsBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<SeckillGoodsBean>>handle())
                .subscribeWith(new CommonSubscriber<List<SeckillGoodsBean>>(mView){
                    @Override
                    public void onNext(List<SeckillGoodsBean> list) {
                        super.onNext(list);
                        if (type == 1){
                            mView.loadData(list);
                        }else {
                            mView.loadMore(list);
                        }
                        page++;
                    }
                })

        );
    }
}
