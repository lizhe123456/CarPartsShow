package com.whmnrc.carpartsshow.model.http;

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
import java.util.List;
import java.util.Map;
import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/3/14.
 */

public interface HttpHelper {

    Flowable<CPSResponse<LoginBean>> fetchSubmitLogin(Map<String, Object> params);

    Flowable<CPSResponse> fetchSubmitFindPwd(Map<String, Object> params);

    Flowable<CPSResponse> fetchSendPhoneCode(String mobile);

    Flowable<CPSResponse> fetchUpdatePwd(Map<String, Object> params);

    Flowable<CPSResponse> fetchUpdateShippingAddress(Map<String, Object> params);

    Flowable<CPSResponse> fetchSubmitFeedback(Map<String, Object> params);

    Flowable<CPSResponse<CollectionBean>> fetchCollection(String userId, int page, int size);

    Flowable<CPSResponse<List<CouponBean>>> fetchUserCoupon(String userId, int page, int size, int isUse);

    Flowable<CPSResponse<List<IntergralBean>>> fetchSplitIntegerRecord(String userId, int page, int size);

    Flowable<CPSResponse<UserInfoBean>> fetchGetUserInfo(String userId);

    Flowable<CPSResponse> fetchCreditWaitRecord(String userId);

    Flowable<CPSResponse<AddressBean>> fetchAddressInfo(String pId);

    Flowable<CPSResponse<AddressBean>> fetchAddressInfo();

    Flowable<CPSResponse<IntergralShopBean>> fetchSplitShopIndex(String searchValue, int page, int size);

    Flowable<CPSResponse<List<IntegralRecordBean>>> fetchSplitExchangeRecord(String userId, int size, int page);

    Flowable<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>> fetchsplitListIntegerGoods(int size,int page,String searchValue,String userId,String goodsTypeId);

    Flowable<CPSResponse<List<NewsListBean>>> fetchSplitListNotice(String type, int page, int size);

    Flowable<CPSResponse<List<NewTypeBean>>> fetchListNoticeType();

    Flowable<CPSResponse<ShopCarBean>> userShopingCarList(String userId, int size, int page);

    Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page, int creditRecordState);

    Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(String userId, int size, int page);

    Flowable<CPSResponse<HomePageBean>> getHomePageData(String userId, int size, int page);

    Flowable<CPSResponse<SeckillGoodsDetail>> seckillGoodsDetail(String userId, String seckillId);

    Flowable<CPSResponse<GoodsDetailBean>> goodsDetail(String userId, String goodsId);

    Flowable<CPSResponse<ClassificationBean>> classification(String userId);

    Flowable<CPSResponse<CarFilterBean>> carFilter(String val);

    Flowable<CPSResponse> fetchListGoods(Map<String, String> map);

    Flowable<CPSResponse<GoodsListBean>> fetchListSplitGoods(Map<String, Object> map);

    Flowable<CPSResponse> fetchAddCar(Map<String, Object> map);

    Flowable<CPSResponse> fetchAddCar(String userId,String pid);

    Flowable<CPSResponse> fetchSubCar(Map<String, Object> map);

    Flowable<CPSResponse> fetchAppendCollections(Map<String, Object> map);

    Flowable<CPSResponse> fetchDelCards(String cids);

    Flowable<CPSResponse<List<MsgBean>>> fetchSplitUserMsg(String userId, int page);

    Flowable<CPSResponse> fetchSubmitOrder(Map<String,Object> map);

    Flowable<CPSResponse<OrderBeanV2>> fetchToOder(String userId, String productAttrIds);

    Flowable<CPSResponse<OrderListBean>> fetchSplitListOrder(String userId,int size, int page, int type);

    Flowable<CPSResponse> fetchSureOrderUrgent(String orderId);

    Flowable<CPSResponse> fetchSureOrder(String orderId);

    Flowable<CPSResponse> fetchCancelOrder(String orderId);

    Flowable<CPSResponse> fetchDelCollection(String orderId);

    Flowable<CPSResponse<List<SeckillGoodsBean>>> fetchListSplitSeckillGoods(String userId,int page);

    Flowable<CPSResponse<List<CarModelByVINBean>>> fetchGetCarModelByVIN(String vin);

    Flowable<CPSResponse> fetchSubmitRefundOrder(String orederId, String userId);

    Flowable<CPSResponse<List<ClassificationBean.ListBrandBean>>> fetchgetListBrand(String userId, int step, String categoryName);

    Flowable<CPSResponse<List<PayRecordBean>>> fetchGetSplitOrderRecord(int pageIndex, String userId);

    Flowable<CPSResponse> submitRefundGoods(Map<String, Object> map);

}
