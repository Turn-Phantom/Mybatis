package com.li.mybatis3.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.li.mybatis3.mapper.UserMapper;
import com.li.mybatis3.pojo.User;
import com.li.mybatis3.pojo.User2;

public class UserMapperTest {
	private SqlSessionFactory ssf = null;
	
	@Before
	public void initTest() throws IOException {
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory
		this.ssf = ssfb.build(is);
	}
	
	@Test
	public void queryUserById() {
		//获取SqlSession，和Spring整合后，由Spring管理
		SqlSession ss = this.ssf.openSession();
		//从SqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		//执行查询方法
		User user = userMapper.queryUserById(25);
		System.out.println(user);
		//关闭资源，和Spring整合后，由Spring管理
		ss.close();
	}

	@Test
	public void queryUserByUsername() {
		//获取SqlSession,
		SqlSession ss = this.ssf.openSession();
		//从SqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		//执行查询方法
		List<User> list = userMapper.queryUserByUsername("李");
		
		System.out.println(list);
		//关闭资源
		ss.close();
	}
	
	@Test
	public void deleteUserByUsername() {
		//获取SqlSession
		SqlSession ss =  this.ssf.openSession();
		//从SqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		//执行删除方法
		userMapper.deleteUserByUsername("嗯哼");
		ss.close();
	}
	
	@Test
	public void addUser() {
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//从SqlSession中获取Mapper接口的代理对象
		UserMapper userMapper= ss.getMapper(UserMapper.class);
		User2 user2 = new User2();
		user2.setUserName("赵高");
		user2.setBirthday("2001-10-15");
		user2.setSex(1);
		user2.setAddress("广东河源");
		userMapper.addUser(user2);
		System.out.println(user2);
		ss.commit();
		ss.close();
	}
}
/**
 * selectOne 和selectList：
 * 	动态代理对象调用sqlSession.selectOne()和sqlSession.selectList()
 * 	是根据mapper接口方法的返回值决定的，如果返回list则调用selectList方法，
 * 	如果返回对象则调用selectOne方法
 * namespace
 * 	mybatis官方推荐使用mapper代理方法开发mapper接口，程序员不用编写mapper接口实现类，使用mapper代理方法时
 * 	输入参数可以使用pojo包装map对象，保证dao的通用性
 * */
