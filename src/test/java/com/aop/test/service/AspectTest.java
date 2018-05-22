package com.aop.test.service;

import com.aop.learn.demain.User;
import com.aop.learn.service.UserService;
import com.aop.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基于@AspectJ切面
 */
public class AspectTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 插入一条记录
     */
    @Test
    public void insertUser() {
        User user = new User();
        user.setId("1");
        user.setName("小明");
        user.setAge(18);
        userService.insertUser(user);

    }

    /**
     * 删除一条记录
     */
    @Test
    public void deleteUser() {
        userService.deleteUser("1");
    }


}
