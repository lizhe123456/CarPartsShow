package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.IntergralBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.IntergralContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class IntergralPresenter extends BasePresenterImpl<IntergralContract.View> implements IntergralContract.Presenter{

    DataManager dataManager;
    private int page = 1;
    private int size = 10;

    @Inject
    public IntergralPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getIntergralList(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitIntegerRecord(userId,page,size)
                .compose(RxUtil.<CPSResponse<List<IntergralBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<IntergralBean>>handle())
                .subscribeWith(new CommonSubscriber<List<IntergralBean>>(mView){
                    @Override
                    public void onNext(List<IntergralBean> intergralBean) {
                        super.onNext(intergralBean);
                        if (type == 1){
                            mView.showContent(intergralBean);
                        }else {
                            mView.loadMore(intergralBean);
                        }
                        page++;
                    }
                })
        );
    }
}
