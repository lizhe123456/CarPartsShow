package com.carpartsshow.model.http.api;

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
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by lizhe on 2018/3/14.
 */

public interface CPSApi {

    //用户找回密码
    @POST("/api/User/SubmitFindPwd")
    Flowable<CPSResponse> submitFindPwd(@Body Map<String, Object> params);

    //用户登录
    @POST("/api/User/SubmitLogin")
    Flowable<CPSResponse<LoginBean>> submitLogin(@Body Map<String, Object> params);


    //发送验证码
    @GET("/api/User/SendPhoneCode")
    Flowable<CPSResponse> sendPhoneCode(@Query("UserInfo_Mobile") String mobile);

    //修改密码
    @POST("/api/User/UpdatePwd")
    Flowable<CPSResponse> updatePwd(@Body Map<String, Object> params);

    //修改收货地址
    @POST("/api/User/UpdateShippingAddress")
    Flowable<CPSResponse> updateShippingAddress(@Body Map<String, Object> params);

    //我的收藏
    @GET("/api/User/Collection")
    Flowable<CPSResponse<CollectionBean>> collection(@Query("RepairUser_ID") String userId,
                                                     @Query("PageIndex") int page,
                                                     @Query("PageSize") int size);
    //我的优惠卷
    @GET("/api/User/UserCoupon")
    Flowable<CPSResponse<List<CouponBean>>> userCoupon(@Query("RepairUser_ID") String userId,
                                                       @Query("PageIndex") int page,
                                                       @Query("PageSize") int size,
                                                       @Query("Coupon_IsUse") int isUse);

    //积分记录
    @GET("/api/User/SplitIntegerRecord")
    Flowable<CPSResponse<IntergralBean>> splitIntegerRecord(@Query("RepairUser_ID") String userId,
                                                            @Query("PageIndex") int page,
                                                            @Query("PageSize") int size);

    //用户信息
    @GET("/api/User/GetUserInfo")
    Flowable<CPSResponse<UserInfoBean>> getUserInfo(@Query("RepairUser_ID") String userId);

    //信用使用记录
    @GET("/api/User/CreditWaitRecord")
    Flowable<CPSResponse> creditWaitRecord(@Query("RepairUser_ID") String userId);

    //提交意见
    @POST("/api/User/SubmitFeedback")
    Flowable<CPSResponse> submitFeedback(@Body Map<String, Object> params);

    //查询地区
    @GET("/api/User/ListArea")
    Flowable<CPSResponse<AddressBean>> listArea(@Query("parentId") String parentId);

    //查询地区
    @GET("/api/User/ListArea")
    Flowable<CPSResponse<AddressBean>> listArea();

    //积分商城首页
    @GET("/api/IntegerShop/Index")
    Flowable<CPSResponse<IntergralShopBean>> splitShopIndex(@Query("RepairUser_ID") String userId,@Query("SearchValue") String searchValue, @Query("PageIndex") int page, @Query("PageSize") int size);

    //我的积分越换记录
    @GET("/api/IntegerShop/SplitExchangeRecord")
    Flowable<CPSResponse<List<IntegralRecordBean>>> splitExchangeRecord(@Query("RepairUser_ID") String userId, @Query("pageSize") int size, @Query("pageIndex") int page);

    //或有商品
    @GET("/api/IntegerShop/SplitListIntegerGoods")
    Flowable<CPSResponse<List<IntergralShopBean.IstIntegerGoods>>> splitListIntegerGoods(@Query("PageIndex") int page,
                                                @Query("PageSize") int size,
                                                @Query("SearchValue") String searchValue,
                                                @Query("RepairUser_ID") String userId,
                                                @Query("IntegerGoodsType_ID") String goodsTypeId);

    //新闻中心
    @GET("/api/Home/SplitListNotice")
    Flowable<CPSResponse<List<NewsListBean>>> splitListNotice(@Query("NewsType") String type, @Query("PageIndex") int page, @Query("PageSize") int size);

    //新闻类型
    @GET("/api/Home/ListNoticeType")
    Flowable<CPSResponse<List<NewTypeBean>>> listNoticeType();

    //购物车
    @GET("/api/User/UserCar")
    Flowable<CPSResponse<ShopCarBean>> userShopingCarList(@Query("RepairUser_ID") String userId, @Query("PageIndex") int page, @Query("PageSize") int size);

    //购物车加一
    @POST("/api/User/AddCar")
    Flowable<CPSResponse> addCar(@Body Map<String, Object> params);

    @GET("/api/User/AppendCar")
    Flowable<CPSResponse> addCar(@Query("RepairUser_ID") String userId,@Query("Pids") String pid);

    //购物车减一
    @POST("/api/User/SubCar")
    Flowable<CPSResponse> subCar(@Body Map<String, Object> params);

    //购物车加入收藏
    @POST("/api/User/AppendCollections")
    Flowable<CPSResponse> appendCollections(@Body Map<String ,Object> map);

    //购物车移除
    @GET("/api/User/DelCards")
    Flowable<CPSResponse> delCards(@Query("Cids") String cids);

    //信用记录
    @GET("/api/User/SplitCreditRecord")
    Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(@Query("RepairUser_ID") String userId,
                                                                         @Query("PageIndex") int page,
                                                                         @Query("PageSize") int size,
                                                                         @Query("CreditRecord_State") int creditRecordState);

    @GET("/api/User/SplitCreditRecord")
    Flowable<CPSResponse<List<ConsumptionRecordBean>>> splitCreditRecord(@Query("RepairUser_ID") String userId,
                                                                         @Query("PageIndex") int page,
                                                                         @Query("PageSize") int size);

    //首页
    @GET("/api/Home/Index")
    Flowable<CPSResponse<HomePageBean>> getHomePageData(@Query("RepairUser_ID") String userId,
                                                        @Query("PageIndex") int page,
                                                        @Query("PageSize") int size);

    //秒杀商品详情
    @GET("/api/Home/SeckillGoodsDetail")
    Flowable<CPSResponse<SeckillGoodsDetail>> seckillGoodsDetail(@Query("RepairUser_ID") String userId,
                                                                 @Query("Seckill_ID") String seckillId);

    //返回商品详情
    @GET("/api/Home/GoodsDetail")
    Flowable<CPSResponse<GoodsDetailBean>> goodsDetail(@Query("RepairUser_ID") String userId,
                                                       @Query("Goods_ID") String goodsId);

    //商品分类查找
    @GET("/api/Home/Classification")
    Flowable<CPSResponse<ClassificationBean>> classification(@Query("RepairUser_ID") String userId);

    //车辆类型
    @GET("/api/Home/CarFilter")
    Flowable<CPSResponse<CarFilterBean>> carFilter(@Query("val") String val);

    //商品搜索
    @GET("/api/Home/ListGoods")
    Flowable<CPSResponse> listGoods(@QueryMap Map<String, String> map);

    //商品搜索分页
    @GET("/api/Home/ListSplitGoods")
    Flowable<CPSResponse<GoodsListBean>> listSplitGoods(@QueryMap Map<String, Object> map);

    //消息记录
    @GET("/api/User/SplitUserMsg")
    Flowable<CPSResponse<List<MsgBean>>> splitUserMsg(@Query("RepairUser_ID") String userId, @Query("PageIndex") int page);

    //提交提单
    @POST("/api/User/SubmitOrder")
    Flowable<CPSResponse> submitOrder(@Body Map<String , Object> param);

    //立即购买
    @GET("/api/User/ToOrder")
    Flowable<CPSResponse<OrderBean>> toOder(@Query("RepairUser_ID") String userId,
                                            @Query("ProductAttrIds") String productAttrIds);
    //获取订单数据
    @GET("/api/User/SplitListOrder")
    Flowable<CPSResponse<OrderListBean>> splitListOrder(@Query("RepairUser_ID") String userId, @Query("PageSize") int size, @Query("PageIndex") int page, @Query("OrderType") int type);

    //加急催单
    @GET("/api/User/SureOrderUrgent")
    Flowable<CPSResponse> sureOrderUrgent(@Query("Order_ID") String orderId);

    //确认收货
    @GET("/api/User/SureOrder")
    Flowable<CPSResponse> sureOrder(@Query("Order_ID") String orderId);

    //取消订单
    @GET("/api/User/CancelOrder")
    Flowable<CPSResponse> cancelOrder(@Query("Order_ID") String orderId);

    @GET("/api/User/DelCollection")
    Flowable<CPSResponse> delCollection(@Query("RepairUser_ID") String userId,@Query("Cids") String cids);

    //秒杀商品
    @GET("/api/Home/ListSplitSeckillGoods")
    Flowable<CPSResponse<List<SeckillGoodsBean>>> listSplitSeckillGoods(@Query("RepairUser_ID") String userId,@Query("PageIndex") int page);

    //vin码扫描
    @GET("/api/Home/GetCarModelByVIN")
    Flowable<CPSResponse<List<CarModelByVINBean>>> getCarModelByVIN(@Query("VIN") String vin);

    //退货
    @GET("/api/User/SubmitRefundOrder")
    Flowable<CPSResponse> submitRefundOrder(@Query("OrderId") String orederId, @Query("RepairUser_ID") String userId);
}
