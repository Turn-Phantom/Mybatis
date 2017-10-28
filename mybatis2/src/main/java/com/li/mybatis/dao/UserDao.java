package com.li.mybatis.dao;

import java.util.List;

import com.li.mybatis.pojo.User;

public interface UserDao {
	/**
	 * 根据id查询用户
	 */
	User queryUserById(int id);
	
	/**
	 * 根据username模糊查询用户
	 */
	List<User> queryUserByUsername(String username);
	
	/**
	 * 新增用户
	 */
	void saveUser();
}
