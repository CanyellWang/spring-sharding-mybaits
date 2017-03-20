package com.snowcattle.demo.service.impl;

import com.snowcattle.demo.entity.Order;
import com.snowcattle.demo.mapper.OrderDao;
import com.snowcattle.demo.sharding.CustomerContextHolder;
import com.snowcattle.demo.sharding.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    //插入
    public int insertOrder(Order order) {
        CustomerContextHolder.setCustomerType(CustomerContextHolder.getShardingDBKeyByUserId(DataSourceType.jdbc_player_db, order.getUserId()));
        order.setSharding_table_index(CustomerContextHolder.getShardingDBTableIndexByUserId(order.getUserId()));
        //return orderMapper.insertOrder(order);
        return orderDao.insert(order);
    }

    //删除
    public void deleteByUserId(Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        CustomerContextHolder.setCustomerType(CustomerContextHolder.getShardingDBKeyByUserId(DataSourceType.jdbc_player_db, order.getUserId()));
        order.setSharding_table_index(CustomerContextHolder.getShardingDBTableIndexByUserId(order.getUserId()));
        orderDao.deleteByUserId(order);
    }
    //修改
    public void updateOrder(Order order) {
        CustomerContextHolder.setCustomerType(CustomerContextHolder.getShardingDBKeyByUserId(DataSourceType.jdbc_player_db, order.getUserId()));
        order.setSharding_table_index(CustomerContextHolder.getShardingDBTableIndexByUserId(order.getUserId()));
        orderDao.updateOrder(order);
    }
    //查询
    public Order getOrderByUserId(Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        CustomerContextHolder.setCustomerType(CustomerContextHolder.getShardingDBKeyByUserId(DataSourceType.jdbc_player_db, order.getUserId()));
        order.setSharding_table_index(CustomerContextHolder.getShardingDBTableIndexByUserId(order.getUserId()));
        Order result = orderDao.getOrder(order);
        System.out.println(result);
        return result;
    }

}// end of  class
