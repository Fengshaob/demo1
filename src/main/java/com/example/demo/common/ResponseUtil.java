package com.example.demo.common;


/**
 * Reponse 构建工具
 */
public class ResponseUtil {
    /**
     * 构建统一的返回值
     * @param data
     * @return
     */
    public static <T> Response<T> success(T data) {
        Response<T> result = new Response<T>(CommonCodeEnum.SUCCESS.getCode(), CommonCodeEnum.SUCCESS.getMessage(), data);
        return result;
    }

    public static <T> Response<T> fail(CommonCodeEnum enumBase) {
        return new Response<T>(enumBase.getCode(), enumBase.getMessage(), null);
    }

    public static <T> Response<T> fail(CommonCodeEnum enumBase, T data) {
        return new Response<T>(enumBase.getCode(), enumBase.getMessage(), data);
    }

    public static <T> Response<T> fail(String code, String message) {
        return new Response<T>(code, message, null);
    }

    public static <T> Response<T> fail(String code, String message, T data) {
        return new Response<T>(code, message, data);
    }

    public static <T> Response<T> fail() {
        return fail(CommonCodeEnum.SYSTEM_ERROR);
    }

    public static <T> Response<T> success() {
        return success(null);
    }

}
