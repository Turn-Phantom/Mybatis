package com.li.mybatis.dao.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.li.mybatis.dao.UserDao;
import com.li.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	//创建SqlSessionFactory
	private SqlSessionFactory ssf = null;
	//初始化SqlSessionFactory
	public UserDaoImpl(SqlSessionFactory ssf) {
		super();
		this.ssf = ssf;
	}
//根据id查询用户
	public User queryUserById(int id) {
		//创建SqlSession
		SqlSession ss = this.ssf.openSession();
		//执行查询逻辑
		User user = ss.selectOne("queryUserById", id);
		//释放资源
		ss.close();
		return user;
	}
//根据username模糊查询用户
	public List<User> queryUserByUsername(String username) {
		//创建SqlSession
		SqlSession ss = this.ssf.openSession();
		//执行查询逻辑
		List<User> list = ss.selectList("queryUserByUsername", username);
		//关闭资源
		ss.close();
		return list;
	}
//新增用户
	public void saveUser() {
		//创建SqlSession
		SqlSession ss =this.ssf.openSession();
		User user = new User();
		user.setUserName("李冰冰");
		user.setBirthday("1985-02-03");
		user.setSex(0);
		user.setAddress("广东");
		ss.insert("saveUser", user);
		ss.commit();
		ss.close();
		System.out.println(user);
	}

}
