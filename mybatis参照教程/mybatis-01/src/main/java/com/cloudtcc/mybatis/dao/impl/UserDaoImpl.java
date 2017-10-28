package com.cloudtcc.mybatis.dao.impl;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cloudtcc.mybatis.dao.UserDao;
import com.cloudtcc.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	SqlSessionFactory factory;
	
	public UserDaoImpl() throws IOException {
		SqlSessionFactoryBuilder b =new SqlSessionFactoryBuilder();
		this.factory = b.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		
	}

	public User getUserById(Integer id) {
		SqlSession session = factory.openSession();
		return session.selectOne("queryUserById", 1);
	}

}
