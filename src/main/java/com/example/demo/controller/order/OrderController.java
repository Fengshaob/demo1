package com.example.demo.controller.order;

import com.example.demo.aspect.ExceptionHandler;
import com.example.demo.common.Response;
import com.example.demo.common.ResponseUtil;
import com.example.demo.controller.BaseController;
import com.example.demo.model.OrderModel;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-24
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @ExceptionHandler("创建订单")
    @PostMapping("/create")
    @ResponseBody
    public Response createOrder(@RequestBody OrderModel order) {
        orderService.createOrder(order);
        return ResponseUtil.success();
    }

    @ExceptionHandler("查询订单")
    @GetMapping("/findOrder")
    @ResponseBody
    public Response<OrderModel> findOrder(@RequestParam Long userId) {
        OrderModel order = orderService.findOrder(userId);
        return ResponseUtil.success(order);
    }

    @ExceptionHandler("查询订单")
    @GetMapping("/findOrderById")
    @ResponseBody
    public Response<OrderModel> findOrderById(@RequestParam Long orderId) throws Exception {
        OrderModel order = orderService.findOrderById(orderId);
        return ResponseUtil.success(order);
    }

}

