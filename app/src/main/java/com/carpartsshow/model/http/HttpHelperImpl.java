package com.carpartsshow.model.http;

import com.carpartsshow.model.http.api.CPSApi;
import com.carpartsshow.model.http.bean.AddressBean;
import com.carpartsshow.model.http.bean.CarFilterBean;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.CollectionBean;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.carpartsshow.model.http.bean.CouponBean;
import com.carpartsshow.model.http.bean.GoodsDetailBean;
import com.carpartsshow.model.http.bean.GoodsListBean;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.bean.IntegralRecordBean;
import com.carpartsshow.model.http.bean.IntergralBean;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.MsgBean;
import com.carpartsshow.model.http.bean.NewTypeBean;
import com.carpartsshow.model.http.bean.NewsListBean;
import com.carpartsshow.model.http.bean.OrderBean;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.model.http.bean.ShopCarBean;
import com.carpartsshow.model.http.bean.UserInfoBean;
import com.carpartsshow.model.http.response.CPSResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.http.Field;

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
    public Flowable<CPSResponse<List<NewsListBean>>> fetchSplitListNotice(String type, int page, int size) {
        return cpsApi.splitListNotice(type, page, size);
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
    public Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page, int creditRecordState) {
        return cpsApi.splitCreditRecord(userId, page, size, creditRecordState);
    }
    @Override
    public Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page) {
        return cpsApi.splitCreditRecord(userId, page, size);
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
    public Flowable<CPSResponse<GoodsDetailBean>> goodsDetail(String userId, String goodsId) {
        return cpsApi.goodsDetail(userId, goodsId);
    }

    @Override
    public Flowable<CPSResponse<ClassificationBean>> classification(String userId) {
        return cpsApi.classification(userId);
    }

    @Override
    public Flowable<CPSResponse<CarFilterBean>> carFilter(String val) {
        return cpsApi.carFilter(val);
    }

    @Override
    public Flowable<CPSResponse> fetchListGoods(Map<String, String> map) {
        return cpsApi.listGoods(map);
    }

    @Override
    public Flowable<CPSResponse<GoodsListBean>> fetchListSplitGoods(Map<String, Object> map) {
        return cpsApi.listSplitGoods(map);
    }

    @Override
    public Flowable<CPSResponse> fetchAddCar(Map<String, Object> map) {
        return cpsApi.addCar(map);
    }

    @Override
    public Flowable<CPSResponse> fetchSubCar(Map<String, Object> map) {
        return cpsApi.subCar(map);
    }

    @Override
    public Flowable<CPSResponse> fetchAppendCollections(Map<String, Object> map) {
        return cpsApi.appendCollections(map);
    }

    @Override
    public Flowable<CPSResponse> fetchDelCards(String cids) {
        return cpsApi.delCards(cids);
    }

    @Override
    public Flowable<CPSResponse<List<MsgBean>>> fetchSplitUserMsg(String userId, int page) {
        return cpsApi.splitUserMsg(userId,page);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitOrder(Map<String, Object> map) {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("sbOrder",map);
        return cpsApi.submitOrder(map1);
    }

    @Override
    public Flowable<CPSResponse<OrderBean>> fetchToOder(String userId, String productAttrIds) {
        return cpsApi.toOder(userId, productAttrIds);
    }

    @Override
    public Flowable<CPSResponse<OrderListBean>> fetchSplitListOrder(String userId, int size, int page, int type) {
        return cpsApi.splitListOrder(userId, size, page, type);
    }

}
