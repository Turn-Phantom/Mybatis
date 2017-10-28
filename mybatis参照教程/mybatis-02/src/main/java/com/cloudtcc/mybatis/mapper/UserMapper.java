package com.cloudtcc.mybatis.mapper;

import java.util.List;

import com.cloudtcc.mybatis.pojo.QueryVo;
import com.cloudtcc.mybatis.pojo.User;

public interface UserMapper {
	//4个原则
	//1,方法名称必须和UerMapper.xml文件的里面的id一样
	//2，方法的参数必须和UerMapper.xml文件的里面的parameterType一致
	//3，方法的返回值必须和UerMapper.xml文件的里面的resultType一致
	//4，UerMapper.xml里面的namespace必须写此接口的全类名
	public User queryUserById(Integer id);
	public List<User> queryUsersByName2(String name);
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(Integer id);
	public Integer queryCountUser();
	
	public User queryUserByUserName(QueryVo vo);
	public List<User> queryUserByWhere(User user);
	public List<User> queryUsersById(QueryVo vo);
	public List<User> queryUsersById1(QueryVo vo);
	
}
