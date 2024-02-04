package com.FinalProject.FinalProject.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long userId;
//    @Enumerated(EnumType.STRING)
    private String orderStatus;
    private LocalDateTime orderDate;
    private int totalPrice;
    private String orderShippingAddress;

    public Order(Long id, Long userId, String orderStatus, LocalDateTime orderDate, int totalPrice, String orderShippingAddress) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderShippingAddress = orderShippingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = String.valueOf(orderStatus);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
    }
}
