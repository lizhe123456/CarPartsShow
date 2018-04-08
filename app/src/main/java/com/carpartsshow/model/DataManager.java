package com.carpartsshow.model;

import com.carpartsshow.model.db.RealmHelper;
import com.carpartsshow.model.http.HttpHelper;
import com.carpartsshow.model.http.bean.AddressBean;
import com.carpartsshow.model.http.bean.CarFilterBean;
import com.carpartsshow.model.http.bean.CarModelByVINBean;
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
import com.carpartsshow.model.http.bean.SeckillGoodsBean;
import com.carpartsshow.model.http.bean.SeckillGoodsDetail;
import com.carpartsshow.model.http.bean.ShopCarBean;
import com.carpartsshow.model.http.bean.UserInfoBean;
import com.carpartsshow.model.http.response.CPSResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;


/**
 * Created by Administrator on 2018/3/14.
 */

public class DataManager implements RealmHelper, HttpHelper {

    RealmHelper realmHelper;
    HttpHelper httpHelper;

    public DataManager( HttpHelper httpHelper,RealmHelper realmHelper) {
        this.realmHelper = realmHelper;
        this.httpHelper = httpHelper;
    }


    @Override
    public Flowable<CPSResponse<LoginBean>> fetchSubmitLogin(Map<String, Object> params) {
        return httpHelper.fetchSubmitLogin(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitFindPwd(Map<String, Object> params) {
        return httpHelper.fetchSubmitFindPwd(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSendPhoneCode(String mobile) {
        return httpHelper.fetchSendPhoneCode(mobile);
    }

    @Override
    public Flowable<CPSResponse> fetchUpdatePwd(Map<String, Object> params) {
        return httpHelper.fetchUpdatePwd(params);
    }

    @Override
    public Flowable<CPSResponse> fetchUpdateShippingAddress(Map<String, Object> params) {
        return httpHelper.fetchUpdateShippingAddress(params);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitFeedback(Map<String, Object> params) {
        return httpHelper.fetchSubmitFeedback(params);
    }

    @Override
    public Flowable<CPSResponse<CollectionBean>> fetchCollection(String userId, int page, int size) {
        return httpHelper.fetchCollection(userId, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<CouponBean>>> fetchUserCoupon(String userId, int page, int size, int isUse) {
        return httpHelper.fetchUserCoupon(userId, page, size, isUse);
    }

    @Override
    public Flowable<CPSResponse<IntergralBean>> fetchSplitIntegerRecord(String userId, int page, int size) {
        return httpHelper.fetchSplitIntegerRecord(userId, page, size);
    }

    @Override
    public Flowable<CPSResponse<UserInfoBean>> fetchGetUserInfo(String userId) {
        return httpHelper.fetchGetUserInfo(userId);
    }

    @Override
    public Flowable<CPSResponse> fetchCreditWaitRecord(String userId) {
        return httpHelper.fetchCreditWaitRecord(userId);
    }

    @Override
    public Flowable<CPSResponse<AddressBean>> fetchAddressInfo(String pId) {
        return httpHelper.fetchAddressInfo(pId);
    }

    @Override
    public Flowable<CPSResponse<AddressBean>> fetchAddressInfo() {
        return httpHelper.fetchAddressInfo();
    }

    @Override
    public Flowable<CPSResponse<IntergralShopBean>> fetchSplitShopIndex(String searchValue, int page, int size) {
        return httpHelper.fetchSplitShopIndex(searchValue, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<IntegralRecordBean>>> fetchSplitExchangeRecord(String userId, int size, int page) {
        return httpHelper.fetchSplitExchangeRecord(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>> fetchsplitListIntegerGoods(int size, int page, String searchValue, String userId, String goodsTypeId) {
        return httpHelper.fetchsplitListIntegerGoods(size, page, searchValue, userId, goodsTypeId);
    }

    @Override
    public Flowable<CPSResponse<List<NewsListBean>>> fetchSplitListNotice(String type, int page, int size) {
        return httpHelper.fetchSplitListNotice(type, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<NewTypeBean>>> fetchListNoticeType() {
        return httpHelper.fetchListNoticeType();
    }

    @Override
    public Flowable<CPSResponse<ShopCarBean>> userShopingCarList(String userId, int size, int page) {
        return httpHelper.userShopingCarList(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page, int creditRecordState) {
        return httpHelper.splitCreditRecord(userId, size, page, creditRecordState);
    }
    @Override
    public Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page) {
        return httpHelper.splitCreditRecord(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<HomePageBean>> getHomePageData(String userId, int size, int page) {
        return httpHelper.getHomePageData(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<SeckillGoodsDetail>> seckillGoodsDetail(String userId, String seckillId) {
        return httpHelper.seckillGoodsDetail(userId, seckillId);
    }

    @Override
    public Flowable<CPSResponse<GoodsDetailBean>> goodsDetail(String userId, String goodsId) {
        return httpHelper.goodsDetail(userId, goodsId);
    }

    @Override
    public Flowable<CPSResponse<ClassificationBean>> classification(String userId) {
        return httpHelper.classification(userId);
    }

    @Override
    public Flowable<CPSResponse<CarFilterBean>> carFilter(String val) {
        return httpHelper.carFilter(val);
    }

    @Override
    public Flowable<CPSResponse> fetchListGoods(Map<String, String> map) {
        return httpHelper.fetchListGoods(map);
    }

    @Override
    public Flowable<CPSResponse<GoodsListBean>> fetchListSplitGoods(Map<String, Object> map) {
        return httpHelper.fetchListSplitGoods(map);
    }

    @Override
    public Flowable<CPSResponse> fetchAddCar(Map<String, Object> map) {
        return httpHelper.fetchAddCar(map);
    }

    @Override
    public Flowable<CPSResponse> fetchSubCar(Map<String, Object> map) {
        return httpHelper.fetchSubCar(map);
    }

    @Override
    public Flowable<CPSResponse> fetchAppendCollections(Map<String, Object> map) {
        return httpHelper.fetchAppendCollections(map);
    }

    @Override
    public Flowable<CPSResponse> fetchDelCards(String cids) {
        return httpHelper.fetchDelCards(cids);
    }

    @Override
    public Flowable<CPSResponse<List<MsgBean>>> fetchSplitUserMsg(String userId, int page) {
        return httpHelper.fetchSplitUserMsg(userId, page);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitOrder(Map<String, Object> map) {
        return httpHelper.fetchSubmitOrder(map);
    }

    @Override
    public Flowable<CPSResponse<OrderBean>> fetchToOder(String userId, String productAttrIds) {
        return httpHelper.fetchToOder(userId, productAttrIds);
    }

    @Override
    public Flowable<CPSResponse<OrderListBean>> fetchSplitListOrder(String userId, int size, int page, int type) {
        return httpHelper.fetchSplitListOrder(userId, size, page, type);
    }

    @Override
    public Flowable<CPSResponse> fetchSureOrderUrgent(String orderId) {
        return httpHelper.fetchSureOrderUrgent(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchSureOrder(String orderId) {
        return httpHelper.fetchSureOrder(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchCancelOrder(String orderId) {
        return httpHelper.fetchCancelOrder(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchDelCollection(String orderId) {
        return httpHelper.fetchDelCollection(orderId);
    }

    @Override
    public Flowable<CPSResponse<List<SeckillGoodsBean>>> fetchListSplitSeckillGoods(String userId, int page) {
        return httpHelper.fetchListSplitSeckillGoods(userId, page);
    }

    @Override
    public Flowable<CPSResponse<List<CarModelByVINBean>>> fetchGetCarModelByVIN(String vin) {
        return httpHelper.fetchGetCarModelByVIN(vin);
    }
}
