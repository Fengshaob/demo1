/**  
 * @Corporation 连连银通电子支付有限公司
 * @ClassName com.lianpay.fundapi.web.annotation.Operation.java 
 * @Version V1.0   
 */
package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * 统一异常注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionHandler {

	// 操作名称
	public String value();

}
