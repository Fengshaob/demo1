package com.example.demo.common;

/**
 * 
 */
public enum CommonCodeEnum {

    /** 操作成功 */
    SUCCESS("000000", "SUCCESS"),
    /** 系统异常*/
    SYSTEM_ERROR("999999", "SYSTEM_ERROR"),
    /** 参数不正确 */
    ILLEGAL_ARGUMENT("999991", "ILLEGAL_ARGUMENT")
    ;

    /** 错误码 */
    protected String   code;
    
    /** 描述信息  */
    protected String   message;


    /**
     * 构造方法
     */
    CommonCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     * 
     * @param code  错误码
     * @return
     */
    public static CommonCodeEnum getResultCodeEnumByCode(String code) {
        for (CommonCodeEnum param : values()) {
            if (code.equals(param.getCode()) ) {
                return param;
            }
        }
        return null;
    }
    
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}
