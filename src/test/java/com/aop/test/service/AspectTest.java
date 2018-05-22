package com.aop.test.service;

import com.aop.learn.service.AgentWriter;
import com.aop.learn.service.Seller;
import com.aop.learn.service.Writer;
import com.aop.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author songshuiyang
 * @title: 基于spring配置使用@AspectJ切面
 * @description:
 * @date 2017/11/15 22:04
 */
public class AspectTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Writer writer;

    @Autowired
    private AgentWriter agentWriter;

    /**
     * 查看注入了那些类
     */
    @Test
    public void test() {
        logger.info("--------------------------bean--------------------------");
        for (String beanName : this.applicationContext.getBeanDefinitionNames()) {
            logger.info(beanName);
        }
        logger.info("--------------------------bean--------------------------");
    }

    /**
     * 基于spring配置使用@AspectJ切面
     */
    @Test
    public void test1() {
        writer.serveTo("songshuiyang");
        writer.greetTo("songshuiyang");
    }

    /**
     * 测试引介增强
     */
    @Test
    public void declaredParentsTest() {
        writer.greetTo("songshuiyang");
        Seller seller = (Seller) writer; // 可以成功的进行强制类型转换
        seller.sell("机械键盘");
    }

    /**
     * 测试 @annotation 切点函数
     */
    @Test
    public void annotationNeedTest() {
        writer.nestTo();
    }

    /**
     * 测试环绕增强，访问连接点信息
     */
    @Test
    public void aroundTest() {
        writer.greetTo("songshuiyang1", 18);
    }

    /**
     * 测试绑定代理对象
     */
    @Test
    public void agentBindTest() {
        agentWriter.agent(writer);
    }

    /**
     * 测试绑定类注解对象
     */
    @Test
    public void annoBindTest() {
        agentWriter.agent(writer);
    }
    /**
     * 测试后置增强绑定返回值
     */
    @Test
    public void afterReturnBindTest() {
        writer.name();
    }

    /**
     * 测试绑定抛出的异常返回值
     */
    @Test
    public void afterExceptionnBindTest() {
        writer.throwExcetion();
    }
}
