package com.li.mybatis6_spring;

import com.li.mybatis6_spring.dao.UserDao;
import com.li.mybatis6_spring.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * mybatis整合Spring原始方式开发dao
 */
public class UserDaoTest {
    private ApplicationContext context;
    @Before
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
    }
    //通过id查询用户信息
    @Test
    public void queryUserById(){
        //获取UserDao（通过加载Spring配置文件中管理的bean）
        UserDao userDao = this.context.getBean(UserDao.class);
        //执行方法传参
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }
    //通过用户名模糊查询
    @Test
    public void queryUserByUsername(){
        //获取UserDao
        UserDao userDao = this.context.getBean(UserDao.class);
        User user = new User();
        user.setUsername("林");
        List<User> list = userDao.queryUserByUsername(user.getUsername());
        for (User u:list
             ) {
            System.out.println(u);
        }
    }
    //添加用户
    @Test
    public void addUser(){
        UserDao userDao = this.context.getBean(UserDao.class);
        User user = new User();
        user.setUsername("王海");
        user.setBirthday("2017-10-10");
        user.setSex(1);
        user.setAddress("江苏南京");
        String tip = userDao.addUser(user);
        System.out.println(tip);
    }
}

