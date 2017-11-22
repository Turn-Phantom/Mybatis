package com.li.mybatis5.mapper;

import com.li.mybatis5.pojo.Order;
import com.li.mybatis5.pojo.OrdersUser;
import com.li.mybatis5.pojo.UserOrder;

import java.util.List;

public interface OrderUserMapper {
    /**
     * 一对一关联，查询订单同时，包含订单信息
     */
    List<OrdersUser> queryOrderUser1();

    /**
     * 使用ResultMap，一对一关联查询，查询订单包含用户信息
     */
    List<Order> queryOrderUser2();
    /**
     * 一对多关联查询用户，用户包含订单信息
     */
    List<UserOrder> queryUserOrderMany();
}
