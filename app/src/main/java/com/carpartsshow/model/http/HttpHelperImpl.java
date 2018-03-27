package com.carpartsshow.model.http;

import com.carpartsshow.model.http.api.CPSApi;
import com.carpartsshow.model.http.bean.AddressBean;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.CollectionBean;
import com.carpartsshow.model.http.bean.CouponBean;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.bean.IntegralRecordBean;
import com.carpartsshow.model.http.bean.IntergralBean;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.NewTypeBean;
import com.carpartsshow.model.http.bean.ShopCarBean;
import com.carpartsshow.model.http.bean.UserInfoBean;
import com.carpartsshow.model.http.response.CPSResponse;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/3/14.
 */

public class HttpHelperImpl implements HttpHelper{

    CPSApi cpsApi;

    @Inject
    public HttpHelperImpl(CPSApi cpsApi) {
        this.cpsApi = cpsApi;
    }

    @Override
    public Flowable<CPSResponse<LoginBean>> fetchSubmitLogin(Map<String, Object> params) {
        return cpsApi.submitLogin(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitFindPwd(Map<String, Object> params) {
        return cpsApi.submitFindPwd(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSendPhoneCode(String mobile) {
        return cpsApi.sendPhoneCode(mobile);
    }

    @Override
    public Flowable<CPSResponse> fetchUpdatePwd(Map<String, Object> params) {
        return cpsApi.updatePwd(params);
    }

    @Override
    public Flowable<CPSResponse> fetchUpdateShippingAddress(Map<String, Object> params) {
        return cpsApi.updateShippingAddress(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitFeedback(Map<String, Object> params) {
        return cpsApi.submitFeedback(params);
    }

    @Override
    public Flowable<CPSResponse<CollectionBean>> fetchCollection(String userId, int page, int size) {
        return cpsApi.collection(userId, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<CouponBean>>> fetchUserCoupon(String userId, int page, int size, int isUse) {
        return cpsApi.userCoupon(userId, page, size, isUse);
    }

    @Override
    public Flowable<CPSResponse<IntergralBean>> fetchSplitIntegerRecord(String userId, int page, int size) {
        return cpsApi.splitIntegerRecord(userId, page, size);
    }

    @Override
    public Flowable<CPSResponse<UserInfoBean>> fetchGetUserInfo(String userId) {
        return cpsApi.getUserInfo(userId);
    }

    @Override
    public Flowable<CPSResponse> fetchCreditWaitRecord(String userId) {
        return cpsApi.creditWaitRecord(userId);
    }

    @Override
    public Flowable<CPSResponse<AddressBean>> fetchAddressInfo(String pId) {
        return cpsApi.listArea(pId);
    }

    @Override
    public Flowable<CPSResponse<AddressBean>> fetchAddressInfo() {
        return cpsApi.listArea();
    }

    @Override
    public Flowable<CPSResponse<IntergralShopBean>> fetchSplitShopIndex(String searchValue, int page, int size) {
        return cpsApi.splitShopIndex(searchValue, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<IntegralRecordBean>>> fetchSplitExchangeRecord(String userId, int size, int page) {
        return cpsApi.splitExchangeRecord(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>> fetchsplitListIntegerGoods(int size, int page, String searchValue, String userId, String goodsTypeId) {
        return cpsApi.splitListIntegerGoods(size, page, searchValue, userId, goodsTypeId);
    }

    @Override
    public Flowable<CPSResponse> fetchSplitListNotice(int type, int size, int page) {
        return cpsApi.splitListNotice(type, size, page);
    }

    @Override
    public Flowable<CPSResponse<List<NewTypeBean>>> fetchListNoticeType() {
        return cpsApi.listNoticeType();
    }

    @Override
    public Flowable<CPSResponse<ShopCarBean>> userShopingCarList(String userId, int size, int page) {
        return cpsApi.userShopingCarList(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse> splitCreditRecord(String userId, int size, int page, int creditRecordState) {
        return cpsApi.splitCreditRecord(userId, size, page, creditRecordState);
    }

    @Override
    public Flowable<CPSResponse<HomePageBean>> getHomePageData(String userId, int size, int page) {
        return cpsApi.getHomePageData(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse> seckillGoodsDetail(String userId, String seckillId) {
        return cpsApi.seckillGoodsDetail(userId, seckillId);
    }

    @Override
    public Flowable<CPSResponse> goodsDetail(String userId, String goodsId) {
        return cpsApi.goodsDetail(userId, goodsId);
    }

    @Override
    public Flowable<CPSResponse<ClassificationBean>> classification(String userId) {
        return cpsApi.classification(userId);
    }

    @Override
    public Flowable<CPSResponse> carFilter(String val) {
        return cpsApi.carFilter(val);
    }

    @Override
    public Flowable<CPSResponse> fetchListGoods(Map<String, String> map) {
        return cpsApi.listGoods(map);
    }

    @Override
    public Flowable<CPSResponse> fetchListSplitGoods(Map<String, String> map) {
        return cpsApi.listSplitGoods(map);
    }

}
