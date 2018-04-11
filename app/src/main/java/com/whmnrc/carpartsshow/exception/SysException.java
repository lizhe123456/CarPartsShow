package com.whmnrc.carpartsshow.exception;

import com.whmnrc.carpartsshow.model.http.response.CPSResponse;

/**
 * Created by Administrator on 2017/12/22.
 * 服务器异常处理类
 */

public class SysException extends RuntimeException {

    public static final int USER_NOT_EXIST = -1;
    public static final int PASS_ERROR = -1;

    public static final int CODE_PASSWORD = 601;
    public static final int CODE_NUM = 603;
    public static final int SERVER_ERROR = 404;
    public static final int USER_LOCKED = 504;
    public static final int SQL_ERROR = 406;

    public SysException(CPSResponse cpsResponse) {
        this(getApiExceptionMessage(cpsResponse));
    }

    public SysException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param cpsResponse
     * @return
     */
    private static String getApiExceptionMessage(CPSResponse cpsResponse){
        String message;
        if (cpsResponse.getType() == 1 && cpsResponse.getResultdata() == null){
            message = "没有更多记录";
        }else {
            message = cpsResponse.getMessage();
        }
        return message;
    }
}
