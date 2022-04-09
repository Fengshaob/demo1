package com.example.demo.aspect;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.BizException;
import com.example.demo.common.CommonCodeEnum;
import com.example.demo.common.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

/**
 * 全局异常处理Aspect
 */
@Component
@Aspect
@Slf4j
public class ExceptionHandlerAspect {

    @Pointcut("@annotation(exceptionHandler)")
    private void pointCutMethod(ExceptionHandler exceptionHandler) {
    }

    /**
     *
     * @param pjp
     * @param exceptionHandler
     * @return
     */
    @Around("pointCutMethod(exceptionHandler)")
    public Object doAround(ProceedingJoinPoint pjp, ExceptionHandler exceptionHandler) {
        Object object = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 获取请求参数
            Object[] args = pjp.getArgs();
            String[] paramNames = ((CodeSignature) pjp.getSignature()).getParameterNames();
            StringBuilder param = new StringBuilder();
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    param.append(paramNames[i]);
                    param.append("=");
                    param.append(JSON.toJSON(args[i]));
                    param.append(";");
                }
            }

            // 打印请求日志
            if (log.isInfoEnabled()) {
                log.info("[{}]请求报文:{}", exceptionHandler.value(), param.toString());
            }

            object = pjp.proceed();

        } catch (BizException exception) {
            log.error("[{}]业务异常：{},{}", exceptionHandler.value(), exception.getCode(), exception.getMessage());
            return ResponseUtil.fail( exception.getCode(), exception.getMessage());
        } catch (IllegalArgumentException exception) {
            log.error("[{}]参数异常：", exceptionHandler.value(), exception);
            return ResponseUtil.fail(CommonCodeEnum.ILLEGAL_ARGUMENT.getCode(), exception.getMessage());
        } catch (Exception exception) {
            log.error("[{}]系统异常：", exceptionHandler.value(), exception);
            return ResponseUtil.fail(CommonCodeEnum.SYSTEM_ERROR);
        } catch (Throwable exception) {
            log.error("[{}]未知异常：", exceptionHandler.value(), exception);
            return ResponseUtil.fail(CommonCodeEnum.SYSTEM_ERROR);
        } finally {
            // 打印响应日志
            if (log.isInfoEnabled()) {
                log.info("[{}]返回报文：{},耗时：{}毫秒", exceptionHandler.value(), JSON.toJSON(object),
                        (System.currentTimeMillis() - beginTime));
            }
        }

        return object;
    }

}
