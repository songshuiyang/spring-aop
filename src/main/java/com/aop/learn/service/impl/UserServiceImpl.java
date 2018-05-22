package com.aop.learn.service.impl;

import com.aop.learn.demain.User;
import com.aop.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 插入一条用户记录
     * @param user
     */
    @Override
    public void insertUser(User user){
        logger.info("inserUser 方法执行中");
    }

    /**
     * 删除一条用户记录
     * @param id
     */
    @Override
    public void deleteUser(String id){
        logger.info("deleteUser 方法执行中");
    }
}
