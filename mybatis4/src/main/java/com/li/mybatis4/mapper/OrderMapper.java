package com.li.mybatis4.mapper;

import com.li.mybatis4.pojo.Order;
import com.li.mybatis4.pojo.User;

import java.util.List;

public interface OrderMapper {
    /**
     *查询所有订单信息（一）
     */
    List<Order> queryOrderAll();
    /**
     * 查询所有订单信息（使用resultMap映射字段）
     */
    List<Order> queryOrdersAll();

}
