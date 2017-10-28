package com.cloudtcc.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cloudtcc.mybatis.dao.UserDao;
import com.cloudtcc.mybatis.dao.impl.UserDaoImpl;
import com.cloudtcc.mybatis.mapper.UserMapper;
import com.cloudtcc.mybatis.pojo.User;

public class UserTest2 {
	@Test
	public void test1() throws IOException {
		UserDao ud = new UserDaoImpl();
		User user = ud.getUserById(1);
		System.out.println(user);
	}

	@Test
	public void test2() throws IOException {
		// 创建SqlSessionFactoryBuilder 用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		// 获得sqlSession
		SqlSession session = factory.openSession();
		//mybatis自动返回实现
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.queryUserById(1);
		System.out.println(user);
	}
}
