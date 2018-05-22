package com.aop.learn.service;

import com.aop.learn.demain.User;

public interface UserService {
    /**
     * 插入一条用户记录
     * @param user
     */
     void insertUser(User user);

    /**
     * 删除一条用户记录
     * @param id
     */
     void deleteUser(String id);
}
