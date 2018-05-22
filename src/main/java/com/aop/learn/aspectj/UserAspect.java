package com.aop.learn.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 通过该注解将该类标识为一个切面
 */
@Component
@Aspect
public class UserAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  前置通知：目标方法执行之前执行以下方法体的内容
     */
    @Before("execution(* com.aop.learn.service.*.*(..))")
    public void beforeExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("【" + methodName + "】方法开始前执行切面代码。。。。。。。。。");
    }

    /**
     *  返回通知：目标方法正常执行完毕时执行以下代码
     */
    @AfterReturning("execution(* com.aop.learn.service.*.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("【" + methodName + "】方法正常执行完毕切面代码。。。。。。。。。");
    }
}
