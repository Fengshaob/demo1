package com.example.demo.service;


import com.example.demo.model.OrderModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-24
 */
public interface OrderService {

    void createOrder(OrderModel order);

    OrderModel findOrder(Long userId);

    OrderModel findOrderById(Long orderId) throws Exception;
}
