package com.cloudtcc.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cloudtcc.mybatis.mapper.OrdersMapper;
import com.cloudtcc.mybatis.mapper.UserMapper;
import com.cloudtcc.mybatis.pojo.Orders;
import com.cloudtcc.mybatis.pojo.User;

public class OrdersTest {
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
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders = mapper.queryOrdersById(3);
		System.out.println(orders);
	}
	
	
}
