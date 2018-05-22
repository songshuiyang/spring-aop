package com.aop.test.service;

import com.aop.learn.demain.User;
import com.aop.learn.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Writer;

/**
 * @author songshuiyang
 * @title: 基于Schema 配置切面
 * @description:
 * @date 2017/11/18 14:56
 */
public class SchemaTest {

    private ApplicationContext context;

    public SchemaTest() {
        this.context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-schema.xml");
    }

    /**
     * 插入一条记录
     */
    @Test
    public void insertUser() {
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setId("1");
        user.setName("小明");
        user.setAge(18);
        userService.insertUser(user);

    }

}
