package com.li.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.li.mybatis.dao.UserDao;
import com.li.mybatis.dao.daoImp.UserDaoImpl;
import com.li.mybatis.pojo.User;
/**
 * 原始dao开发模式
 * @author Administrator
 *
 */
public class TestDao {
	private SqlSessionFactory ssf =null;
	
	@Before
	public void initTest() throws IOException {
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//加载SqlMapConfig配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory
		this.ssf = ssfb.build(is);
	}

	@Test
	public void queryUserById() {
		//创建dao对象
		UserDao userdao = new UserDaoImpl(this.ssf);
		//执行查询
		User user= userdao.queryUserById(25);
		System.out.println(user);
	}
	
	@Test
	public void queryUserByUsername() {
		//创建dao对象
		UserDao userdao = new UserDaoImpl(this.ssf);
		//执行查询
		List<User> list = userdao.queryUserByUsername("%林%");
		System.out.println(list);
	}
	
	@Test
	public void saveUser() {
		//创建dao对象
		UserDao userdao = new UserDaoImpl(this.ssf);
		//执行插入
		userdao.saveUser();
		
	}
}
/**
 * 原始dao开发中存在以下问题：
 * dao方法体存在重复代码：
 * 		通过SqlSessionFactory创建SqlSession，调用SqlSession的数据库操作方法
 * 调用SqlSession的数据库操作方法需要制定statement的id，这里存在硬编码，不利于开发维护
 * */
