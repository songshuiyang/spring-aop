package com.aop.learn.advice;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 增强类
 */
public class UserAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 增强方法
     * @param joinPoint
     */
    public void afterExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        logger.info("小明在" + matter.format(new Date())+ "执行了【" +methodName  + "】方法");

    }
}
