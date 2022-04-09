package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-24
 */
@Data
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Long userId;

}
