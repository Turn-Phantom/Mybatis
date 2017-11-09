package com.li.mybatis3.mapper;

import java.util.List;

import com.li.mybatis3.pojo.User;
import com.li.mybatis3.pojo.User2;

/**
 * Mapper动态代理开发方式
 * @author Administrator
 *
 */
public interface UserMapper {
	/**
	 * 根据用户id查询
	 */
	User queryUserById(int id);
	/**
	 * 根据用户名模糊查询用户
	 */
	List<User> queryUserByUsername(String username);
	/**
	 * 根据用户名删除用户
	 */
	void deleteUserByUsername(String username);
	
	/**
	 * 新增用户
	 */
	void addUser(User2 user2);
}
