package com.whmnrc.carpartsshow.model.http;

import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.model.http.api.CPSApi;
import com.whmnrc.carpartsshow.model.http.bean.AddressBean;
import com.whmnrc.carpartsshow.model.http.bean.CarFilterBean;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.model.http.bean.CollectionBean;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.CouponBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsListBean;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.model.http.bean.IntegralRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.IntergralBean;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.MsgBean;
import com.whmnrc.carpartsshow.model.http.bean.NewTypeBean;
import com.whmnrc.carpartsshow.model.http.bean.NewsListBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBeanV2;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.model.http.bean.PayRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsBean;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsDetail;
import com.whmnrc.carpartsshow.model.http.bean.ShopCarBean;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.util.SpUtil;

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
    public Flowable<CPSResponse<List<IntergralBean>>> fetchSplitIntegerRecord(String userId, int page, int size) {
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
        LoginBean loginBean = SpUtil.getObject(App.getInstance().getmContext(),"user");
        return cpsApi.splitShopIndex(loginBean.getRepairUser_ID(),searchValue, page, size);
    }

    @Override
    public Flowable<CPSResponse<List<IntegralRecordBean>>> fetchSplitExchangeRecord(String userId, int size, int page) {
        return cpsApi.splitExchangeRecord(userId, size, page);
    }

    @Override
    public Flowable<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>> fetchsplitListIntegerGoods(int size, int page, String searchValue, String userId, String goodsTypeId) {
        return cpsApi.splitListIntegerGoods(page,size, searchValue, userId, goodsTypeId);
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
    public Flowable<CPSResponse<SeckillGoodsDetail>> seckillGoodsDetail(String userId, String seckillId) {
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
    public Flowable<CPSResponse> fetchAddCar(String userId,String pid) {
        return cpsApi.addCar(userId, pid);
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
        return cpsApi.submitOrder(map);
    }

    @Override
    public Flowable<CPSResponse<OrderBeanV2>> fetchToOder(String userId, String productAttrIds) {
        return cpsApi.toOder(userId, productAttrIds);
    }

    @Override
    public Flowable<CPSResponse<OrderListBean>> fetchSplitListOrder(String userId, int size, int page, int type) {
        return cpsApi.splitListOrder(userId, size, page, type);
    }

    @Override
    public Flowable<CPSResponse> fetchSureOrderUrgent(String orderId) {
        return cpsApi.sureOrderUrgent(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchSureOrder(String orderId) {
        return cpsApi.sureOrder(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchCancelOrder(String orderId) {
        return cpsApi.cancelOrder(orderId);
    }

    @Override
    public Flowable<CPSResponse> fetchDelCollection(String orderId) {
        LoginBean loginBean = SpUtil.getObject(App.getInstance().getmContext(),"user");
        return cpsApi.delCollection(loginBean.getRepairUser_ID(),orderId);
    }

    @Override
    public Flowable<CPSResponse<List<SeckillGoodsBean>>> fetchListSplitSeckillGoods(String userId, int page) {
        return cpsApi.listSplitSeckillGoods(userId, page);
    }

    @Override
    public Flowable<CPSResponse<List<CarModelByVINBean>>> fetchGetCarModelByVIN(String vin) {
        return cpsApi.getCarModelByVIN(vin);
    }

    @Override
    public Flowable<CPSResponse> fetchSubmitRefundOrder(String orederId, String userId) {
        return cpsApi.submitRefundOrder(orederId,userId);
    }

    @Override
    public Flowable<CPSResponse<List<ClassificationBean.ListBrandBean>>> fetchgetListBrand(String userId, int step, String categoryName) {
        return cpsApi.getListBrand(userId, step, categoryName);
    }

    @Override
    public Flowable<CPSResponse<List<PayRecordBean>>> fetchGetSplitOrderRecord(int pageIndex, String userId) {
        return cpsApi.getSplitOrderRecord(pageIndex,userId);
    }

    @Override
    public Flowable<CPSResponse> submitRefundGoods(Map<String, Object> map) {
        return cpsApi.submitRefundGoods(map);
    }

}
