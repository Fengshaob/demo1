package com.example.demo.common;

import lombok.Data;

/**
 * 运行时异常
 * 
 */
@Data
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 924102045887105631L;

    protected String          code;

    protected String          message;

    // 异常枚举
    protected CommonCodeEnum errorEnum;
    /**
     * 空构造器。
     */
    public BizException() {
        super();
    }

    public BizException(CommonCodeEnum baseEnum) {
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public BizException(CommonCodeEnum baseEnum, Throwable cause) {
        super(cause);
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public BizException(CommonCodeEnum baseEnum, String message) {
        super(message);
        this.code = baseEnum.getCode();
        this.message = message;
    }

    /**
     * 构造器。
     *
     * @param message
     *            消息
     */
    public BizException(String errorCode, String message) {
        super(message);
        this.code = errorCode;
        this.message = message;
    }

    /**
     * 构造器。
     *
     * @param message
     *            消息
     * @param cause
     *            原因
     */
    public BizException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.code = errorCode;
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

}
