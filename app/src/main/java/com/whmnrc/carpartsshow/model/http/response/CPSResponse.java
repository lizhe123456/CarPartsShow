package com.whmnrc.carpartsshow.model.http.response;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/14.
 */

public class CPSResponse<T> implements Serializable{

    /**
     * {
        " type": 0,
        "errorcode": 0,
        "message": "string",
        "resultdata": {}
     }
     */

    int type;
    int errorcode;
    String message;
    T resultdata;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResultdata() {
        return resultdata;
    }

    public void setResultdata(T resultdata) {
        this.resultdata = resultdata;
    }
}
