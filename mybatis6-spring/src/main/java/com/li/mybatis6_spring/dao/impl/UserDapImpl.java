package com.li.mybatis6_spring.dao.impl;

import com.li.mybatis6_spring.dao.UserDao;
import com.li.mybatis6_spring.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Dao实现类，实现类必须继承SqlSessionDaoSupport
 *  SqlSessionDaoSupport 提供getSqlSession() 方法来获取SqlSession
 */
public class UserDapImpl extends SqlSessionDaoSupport implements UserDao {
    @Override
    public User queryUserById(int id) {
        //获取SqlSession
        SqlSession ss = super.getSqlSession();
        //使用SqlSession执行操作
        User user = ss.selectOne("queryUserById",id);
        return user;
        //不需要提交事务，整合Spring后，事务Spring来管理
    }

    @Override
    public List<User> queryUserByUsername(String username) {
        //获取SqlSession
        SqlSession ss = super.getSqlSession();
        List<User> list = ss.selectList("queryUserByUsername",username);
        return list;
        //不需要提交事务，整合Spring后，事务Spring来管理
    }

    @Override
    public String addUser(User user) {
        SqlSession ss = super.getSqlSession();
        int flag = ss.insert("addUser" ,user);
        if (flag == 1)
            return "插入成功";
        else
            return "插入失败";
        //不需要提交事务，整合Spring后，事务Spring来管理
    }
}
