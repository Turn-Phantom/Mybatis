package com.li.mybatis4.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.li.mybatis4.mapper.UserMapper;
import com.li.mybatis4.pojo.QueryVo;
import com.li.mybatis4.pojo.QueryVo2;
import com.li.mybatis4.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


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
	public void queryUserByQueryVo(){
		//mybatis和Spring整合后，交给Spring管理
		SqlSession ss = this.ssf.openSession();
		//创建接口动态代理对象，整合之后，交给Spring管理
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		//使用UserMapper执行查询，使用包装对象
		QueryVo queryVo  = new QueryVo();
		//设置user条件
		User user = new User();
		user.setUserName("张");
		queryVo.setUser(user);
		//执行查询
	//	System.out.println(user);
		List<User> list = userMapper.queryUserByQueryVo(queryVo);
		for (User u:list) {
			System.out.println(u);
		}
		//关闭事务
		ss.close();
	}
	@Test
	public void queryUserCount(){
		SqlSession ss = this.ssf.openSession();
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		int count = userMapper.queryUserCount();
		System.out.println("user表总条数："+count);
		ss.close();
	}

	//根据条件查询用户信息
	@Test
	public void queryUserByWhere(){
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//获取UserMapper
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setSex(1);
		user.setUserName("李");
		List<User> list = userMapper.queryUserByWhere(user);
		for (User u:list
			 ) {
			System.out.println(u);
		}
		ss.close();
	}
	//根据动态sql if标签执行多条件语句
	@Test
	public void queryUserByIf(){
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//获取UserMapper
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setSex(0);
		user.setUserName("张");
		List<User> list = userMapper.queryUserByIf(user);
		for (User u: list
			 ) {
			System.out.println(u);
		}
		ss.close();
	}
	//根据动态sql if标签执行多条件语句(修改where)
	@Test
	public void queryUserByIf2(){
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//获取UserMapper
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		User user = new User();
		user.setSex(1);
		user.setUserName("张");
		List<User> list = userMapper.queryUserByIf2(user);
		for (User u: list
				) {
			System.out.println(u);
		}
		ss.close();
	}
	//使用sql片段
	@Test
	public void queryUserByWhere1(){
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//获取UserMapper
		UserMapper userMapper =  ss.getMapper(UserMapper.class);
		User user =  new User();
		user.setUserName("林");
		List<User> list = userMapper.queryUserByWhere1(user);
		for (User u: list
			 ) {
			System.out.println(u);
		}
		ss.close();
	}
	//使用foreach标签遍历，根据多个id查询用户
	@Test
	public void queryUserByIds(){
		//获取SqlSession
		SqlSession ss = this.ssf.openSession();
		//获取UserMapper
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		QueryVo2 queryVo2 = new QueryVo2();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(22);
		ids.add(24);
		ids.add(27);
		queryVo2.setIds(ids);
		List<User> list = userMapper.queryUserByIds(queryVo2);
		for (User u:list
			 ) {
			System.out.println(u);
		}
		ss.close();
	}
}
