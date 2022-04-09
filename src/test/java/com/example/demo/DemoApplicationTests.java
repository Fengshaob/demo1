package com.example.demo;

import com.example.demo.model.OrderModel;
import com.example.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(2L);
        orderModel.setUserId(2L);
        orderService.createOrder(orderModel);
    }

}
