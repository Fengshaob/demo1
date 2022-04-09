package com.example.demo.mapper;

import com.example.demo.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author 冯邵兵
 * @since 2022-03-24
 */
@Mapper
@CacheConfig(cacheNames = "order")
public interface OrderMapper {

    void insert(OrderModel order);

    OrderModel findOrder(Long userId);

    @Cacheable(key = "#orderId", unless="#result == null")
    OrderModel findOrderById(Long orderId);
}

