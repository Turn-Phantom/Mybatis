package com.cloudtcc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cloudtcc.mybatis.pojo.User;

public class UserTest {
	@Test
	public void test1() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//通过sqlSession对象操作数据库
		Object user = session.selectOne("queryUserById", 10);
		System.out.println(user);
		session.close();
	}
	@Test
	public void test2() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//通过sqlSession对象操作数据库
		List<Object> list = session.selectList("queryUsersByName", "%陈%");
		System.out.println(list);
		session.close();
	}
	@Test
	public void test3() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//通过sqlSession对象操作数据库
		List<Object> list = session.selectList("queryUsersByName1", "陈");
		System.out.println(list);
		session.close();
	}
	@Test
	public void test4() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//添加用户
		User user = new User();
		user.setUsername("rose");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("美国纽约");
		int insert = session.insert("addUser1", user);
		session.commit();
		System.out.println(user.getId());
		session.close();
	}
	@Test
	public void test5() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//更新用户
		User user = session.selectOne("queryUserById", 1);
		user.setUsername("王五六");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("铁岭");
		int insert = session.insert("updateUser", user);
		session.commit();
		System.out.println(insert);
		session.close();
	}
	@Test
	public void test6() throws IOException{
		//创建SqlSessionFactoryBuilder  用来读取配置文件生成SqlSessionFactory
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//读取配置文件
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		//生成SqlSessionFactory
		SqlSessionFactory factory = builder.build(is);
		//获得sqlSession  
		SqlSession session = factory.openSession();
		//删除用户
		int insert = session.delete("deleteUser", 29);
		session.commit();
		System.out.println(insert);
		session.close();
	}
}
