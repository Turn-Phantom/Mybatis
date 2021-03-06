package com.cloudtcc.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cloudtcc.mybatis.mapper.UserMapper;
import com.cloudtcc.mybatis.pojo.QueryVo;
import com.cloudtcc.mybatis.pojo.User;

public class UserTest {
	private SqlSession sqlSession;

	@Before
	public void before() throws IOException{
		SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = build.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		sqlSession = sqlSessionFactory.openSession();
	}
	@After
	public void after(){
		sqlSession.close();
	}
	
	@Test
	public void test1(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.queryUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void test2(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Integer num = mapper.queryCountUser();
		System.out.println(num);
	}
	//queryVo测试
	@Test
	public void test3(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("张三");
		vo.setUser(user);
		User u = mapper.queryUserByUserName(vo);
		System.out.println(u);
	}
	//if条件查询
	@Test
	public void test4(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		//user.setUsername("王五");
		user.setSex("男");
		List<User> list = mapper.queryUserByWhere(user);
		System.out.println(list);
	}
	//foreach查询
	@Test
	public void test5(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> list = new ArrayList<>();
		list.add(24);
		list.add(25);
		list.add(26);
		vo.setIds(list);
		List<User> l = mapper.queryUsersById(vo);
		System.out.println(l);
	}
	//foreach查询
	@Test
	public void test6(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		Integer[] ids ={24,25,26};
		vo.setIdArr(ids);
		List<User> l = mapper.queryUsersById1(vo);
		System.out.println(l);
	}
}
