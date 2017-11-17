package com.li.mybatis4.test;

import com.li.mybatis4.mapper.OrderMapper;
import com.li.mybatis4.mapper.UserMapper;
import com.li.mybatis4.pojo.Order;
import com.li.mybatis4.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderMapperTest {
    private SqlSessionFactory ssf = null;

    @Before
    public void initTest() throws IOException {
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        this.ssf = ssfb.build(is);
    }
//配置文件以resultType映射方式测试
    @Test
    public void queryOrderAll(){
        //获取SqlSession
        SqlSession ss = this.ssf.openSession();
        //获取OrderMapper
        OrderMapper orderMapper = ss.getMapper(OrderMapper.class);
        //执行查询
        List<Order> list = orderMapper.queryOrderAll();
        for (Order order:list
             ) {
            System.out.println(order);
        }
        //关闭资源
        ss.close();
    }
//配置文件以resultMap方式对应映射字段测试
    @Test
    public void queryOrdersAll(){
        //获取SqlSession
        SqlSession ss =this.ssf.openSession();
        //获取OrderMapper
        OrderMapper ordermapper = ss.getMapper(OrderMapper.class);
        List<Order> list = ordermapper.queryOrdersAll();
        for (Order order:list
             ) {
            System.out.println(order);
        }
        ss.close();
    }

}
