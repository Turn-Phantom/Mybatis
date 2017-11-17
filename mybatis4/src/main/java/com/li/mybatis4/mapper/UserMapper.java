package com.li.mybatis4.mapper;

import com.li.mybatis4.pojo.QueryVo;
import com.li.mybatis4.pojo.QueryVo2;
import com.li.mybatis4.pojo.User;

import java.util.List;



public interface UserMapper {
	/**
	 * 根据包装类型查询用户
	 */
	List<User> queryUserByQueryVo(QueryVo queryVo);

	/**
	 * 查询用户条数
	 */
	int queryUserCount();
	/**
	 * 根据条件查询用户（普通where）
	 */
	List<User> queryUserByWhere(User user);
	/**
	 * 根据动态sql if标签查询
	 */
	List<User> queryUserByIf(User user);
	/**
	 * 根据动态sql，查询，if标签
	 */
	List<User> queryUserByIf2(User user);
	/**
	 * 使用sql片段 根据条件查询
	 */
	List<User> queryUserByWhere1(User user);
	/**
	 * 使用foreach标签遍历查询多个id的用户
	 */
	List<User> queryUserByIds (QueryVo2 queryVo2);
}
