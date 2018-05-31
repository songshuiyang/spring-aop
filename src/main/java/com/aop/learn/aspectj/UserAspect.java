package com.aop.learn.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过该@Aspect注解将该类标识为一个切面
 */
@Component
@Aspect
public class UserAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 后置增强：目标方法正常执行完毕时执行以下代码
     * @param joinPoint JoinPoint对象封装了SpringAop中切面方法的信息
     */
    @AfterReturning("execution(* com.aop.learn.service.*.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        logger.info("小明在" + matter.format(new Date())+ "执行了【" +methodName  + "】方法");

    }
}
