package com.carpartsshow.app;

import com.carpartsshow.util.FileUtil;

/**
 * Created by lizhe on 2018/3/12.
 * 全局常量
 */

public class Constants {

    //正式关闭日志
    public static final boolean IS_DEBUG = true;

    public static final String CPS_URL = "http://api.jscxqp.com:80/swagger/docs/v1/";
    public static final String PATH_CACHE = FileUtil.getFileDir("Http") + "/caches";
}
