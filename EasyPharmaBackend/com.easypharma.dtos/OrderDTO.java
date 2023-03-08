package com.easypharma.dtos;

import com.easypharma.entities.Order;

public class OrderDTO {
    private Integer id;
    private Integer userId;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.setId(order.getOrderId());
        //this.setUserId(order.getUserId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}