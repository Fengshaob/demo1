package com.example.demo.common;

import java.io.Serializable;

/**
 */
public class Response<T> implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -313965489774631737L;

    private String   code;
    
    /** 描述信息 */
    private String   message;
    
    /** 数据 */
    private  T data;

    public Response() {
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(T data) {
        this.data = data;
    }
    public Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(CommonCodeEnum resultCode, T data) {
        if (resultCode == null) {
            resultCode = CommonCodeEnum.SYSTEM_ERROR;
        }

        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 设置信息
     *
     * @param resultCode
     */
    public void markResult(CommonCodeEnum resultCode) {
        if (resultCode == null) {
            resultCode = CommonCodeEnum.SYSTEM_ERROR;
        }

        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    
    /**
     * 是否成功
     * 
     * @return
     */
    public boolean isSuccess() {
        return this.code.equals(CommonCodeEnum.SUCCESS.getCode());
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Response setCode(CommonCodeEnum resultCode) {
        markResult(resultCode);
        return this;
    }

    public void setData(T data) {
        this.data = data;
    }
}
