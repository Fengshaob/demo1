package com.example.demo.service.impl;

import com.example.demo.common.LockUtil;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.OrderModel;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 冯邵兵
 * @since 2022-03-24
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private LockUtil lockUtil;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(OrderModel order) {
        orderMapper.insert(order);
    }

    @Override
    public OrderModel findOrder(Long userId) {
        return orderMapper.findOrder(userId);
    }

    @Override
    public OrderModel findOrderById(Long orderId) throws Exception {
        String key = "order:" + orderId;
        try {
            lockUtil.lock(key, 3L);
            return orderMapper.findOrderById(orderId);
        } finally {
            lockUtil.unlock(key);
        }
    }

}
