package com.li.mybatis6_spring.dao;

import com.li.mybatis6_spring.pojo.User;

import java.util.List;

/**
 * mybatis整合Spring的传统dao开发模式
 */
public interface UserDao {
    /**
     *根据id查询用户
     */
    User queryUserById(int id);
    /***
     * 根据用户名模糊查询用户
     */
    List<User> queryUserByUsername(String username);
    /**
     * 添加用户
     */
    String addUser(User user);
}
