package com.carpartsshow.model.http.api;

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
                                                            @Query("pageSize") int size);

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
    Flowable<CPSResponse<IntergralShopBean>> splitShopIndex(@Query("SearchValue") String searchValue, @Query("PageIndex") int page, @Query("PageSize") int size);

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
    Flowable<CPSResponse> splitListNotice(@Query("NewsType") int type, @Query("PageIndex") int page, @Query("PageSize") int size);

    //新闻类型
    @GET("/api/Home/ListNoticeType")
    Flowable<CPSResponse<List<NewTypeBean>>> listNoticeType();

    //购物车
    @POST("/api/User/UserCar")
    @FormUrlEncoded
    Flowable<CPSResponse<ShopCarBean>> userShopingCarList(@Field("RepairUser_ID") String userId, @Field("PageIndex") int page, @Field("PageSize") int size);

    //信用记录
    @GET("/api/User/SplitCreditRecord")
    Flowable<CPSResponse> splitCreditRecord(@Query("RepairUser_ID") String userId,
                                            @Query("PageIndex") int page,
                                            @Query("PageSize") int size,
                                            @Query("CreditRecord_State") int creditRecordState);

    //首页
    @GET("/api/Home/Index")
    Flowable<CPSResponse<HomePageBean>> getHomePageData(@Query("RepairUser_ID") String userId,
                                                        @Query("PageIndex") int page,
                                                        @Query("PageSize") int size);

    //秒杀商品详情
    @GET("/api/Home/SeckillGoodsDetail")
    Flowable<CPSResponse> seckillGoodsDetail(@Query("RepairUser_ID") String userId,
                                             @Query("Seckill_ID") String seckillId);

    //返回商品详情
    @GET("/api/Home/GoodsDetail")
    Flowable<CPSResponse> goodsDetail(@Query("RepairUser_ID") String userId,
                                      @Query("Goods_ID") String goodsId);

    //商品分类查找
    @GET("/api/Home/Classification")
    Flowable<CPSResponse<ClassificationBean>> classification(@Query("RepairUser_ID") String userId);

    //车辆类型
    @GET("/api/Home/CarFilter")
    Flowable<CPSResponse> carFilter(@Query("val") String val);

    //商品搜索
    @GET("/api/Home/ListGoods")
    Flowable<CPSResponse> listGoods(@QueryMap Map<String, String> map);

    //商品搜索分页
    @GET("/api/Home/ListSplitGoods")
    Flowable<CPSResponse> listSplitGoods(@QueryMap Map<String, String> map);


}
