package com.li.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.li.mybatis.pojo.User;
import com.li.mybatis.pojo.User2;

public class Mybatis1 {
	SqlSessionFactory ssf = null;
	@Before
	public void init() throws Exception {
		//1.创建SqlSessionFactoryBuilder 对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//2.加载SqlMapCongif.xml配置文件
		InputStream  is = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建sqlSessionFactory对象
		this.ssf = ssfb.build(is);
	}
	/**
	 * 根据id查询用户信息
	 */
	@Test
	public void testQueryUserById() {
		//4.创建SqlSession对象
		SqlSession ss = ssf.openSession();
		//5.执行SqlSession对象，执行查询，获取结果user
		User user = ss.selectOne("queryUserById", 10);//第一个参数为User.xml配置文件中的statement的id，第二个是执行sql需要的条件参数
		//Test_DateExchange ex = new Test_DateExchange();
		//String date = (ex.getExchangeDate(user.getBirthday()));
		System.out.println(user);//控制台打印查询结果
		//System.out.println(date);
		ss.close();//释放资源
	}
	/**
	 * 根据用户名模糊查询用户
	 */
	@Test
	public void testQueryUserByUserName() {
		SqlSession ss = ssf.openSession();
		List<User> list = ss.selectList("queryUserByUserName1","%王%");
		//List<User> list = ss.selectList("queryUserByUserName2","王");
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		ss.close();
	}

	/**
	 * 新增用户
	 */
	@Test
	public void TestSaveUser() {
		//创建SqlSession对象
		SqlSession ss = ssf.openSession();
		//创建需要保存的User
		User user = new User();
		//user.setId(3);
		user.setUserName("李梅");
		user.setBirthday("1995-02-20");
		user.setSex(0);
		user.setAddress("广东茂名");	
		ss.insert("saveUser",user);
		System.out.println("插入成功");
		System.out.println(user);
		//提交事务
		ss.commit();
		//释放资源
		ss.close();
	}
	
	/**
	 * 新增用户，返回自增长id
	 */
	@Test
	public void TestSaveUser1() {
		SqlSession ss = ssf.openSession();
		User user = new User();
		user.setUserName("林冲");
		user.setBirthday("1999-10-23");
		user.setSex(1);
		user.setAddress("北京");
		ss.insert("saveUser1",user);
		System.out.println(user);
		ss.commit();
		ss.close();
	}
	
	/**
	 * 使用UUID自动生成主键id
	 */
	@Test
	public void testSaveUser2() {
		SqlSession ss = ssf.openSession();
		User2 user2 = new User2();
		user2.setUserName("赵六");
		user2.setBirthday("2017-10-27");
		user2.setSex(1);
		user2.setAddress("天津");
		ss.insert("saveUser2", user2);
		System.out.println(user2);
		ss.commit();
		ss.close();
	}
	
	/**
	 * 根据id修改用户信息
	 */
	@Test
	public void testUpdateUserById() {
		SqlSession ss = ssf.openSession();
		User user = new User();
		user.setId(26);
		user.setUserName("aaa");
		user.setSex(0);
		user.setBirthday("1990-01-01");
		user.setAddress("123456");
		ss.update("updateUserById", user);
		System.out.println(user);
		ss.commit();
		ss.close();
	}
	 
	/**
	 * 根据id删除用户
	 */
	@Test
	public void testDeleteUserById() {
		SqlSession ss = ssf.openSession();
		//执行SqlSession对象执行删除
		ss.delete("deleteUserById", 26);		
		ss.commit();//提交事务
		ss.close();//关闭资源
	}
}

/**
 * mybatis对于jdbc编程的优势：
 * 	1.在sqlMapConfig.xml 中配置数据库连接池，使用连接池管理数据库连接
 *  2.将sql语句配置在xxxmapper.xml文件中，与java代码分离
 *  3.Mybatis自动将java对象映射到sql语句，通过statement中的parameterType定义输入参数类型
 *  4.Mybatis自动将sql执行结果映射到java实体对象，通过statement中的resultType定义输出结果类型
 * */
