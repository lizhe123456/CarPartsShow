package com.whmnrc.carpartsshow.app;

import com.whmnrc.carpartsshow.util.FileUtil;

/**
 * Created by lizhe on 2018/3/12.
 * 全局常量
 */

public class Constants {

    //正式关闭日志
    public static final boolean IS_DEBUG = false;

    public static final String CPS_URL = "http://api.jscxqp.com:80/swagger/docs/v1/";
    public static final String PATH_CACHE = FileUtil.getFileDir("Http") + "/caches";
    public static boolean IS_REPAYMENT = true;


    public static String ALI_PAY_APPID=""; //支付宝APP ID
    public static String WX_PAY_APPID=""; //微信APPid
    public static String WX_PAY_PARTNER_ID=""; //微信商户ID
    public static String WX_PAY_PRIVATE_KEY=""; //微信私钥
    //微信统一下单接口
    public static final String WX_TOTAL_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}
