package com.li.mybatis4.test;

import com.li.mybatis5.mapper.OrderUserMapper;
import com.li.mybatis5.pojo.Order;
import com.li.mybatis5.pojo.OrdersUser;
import com.li.mybatis5.pojo.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersUserMapperTest {
    private SqlSessionFactory ssf= null;

    @Before
    public void initTest() throws IOException {
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        this.ssf = ssfb.build(is);
    }

    @Test
    public void queryOrderUser1(){
        //获取SqlSession
        SqlSession ss = this.ssf.openSession();
        //获取OrderUserMapper
        OrderUserMapper orderUserMapper = ss.getMapper(OrderUserMapper.class);
        //执行查询
        List<OrdersUser> list = orderUserMapper.queryOrderUser1();
        for (OrdersUser orderUser:list
             ) {
            System.out.println(orderUser);
        }
        ss.close();
    }
    @Test
    public void queryOrderUser2(){
        //获取SqlSession
        SqlSession ss = this.ssf.openSession();
        //获取映射接口
        OrderUserMapper orderUserMapper = ss.getMapper(OrderUserMapper.class);
        //执行查询
        List<Order> list = orderUserMapper.queryOrderUser2();
        //遍历结果
        for (Order o: list
             ) {
            System.out.println(o);
        }
        ss.close();
    }
    @Test
    public void queryUserOrderMany(){
        //获取SqlSession
        SqlSession ss = this.ssf.openSession();
        //获取映射接口
        OrderUserMapper orderUserMapper = ss.getMapper(OrderUserMapper.class);
        //执行查询
        List<UserOrder> list = orderUserMapper.queryUserOrderMany();
        for (UserOrder uo: list
             ) {
            System.out.println(uo);
        }
        ss.close();
    }
}
