package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.ItemInOrder;
import com.FinalProject.FinalProject.model.Order;

import java.util.List;

public interface OrdersService {
    void addOrderAndItems(Order order, List<ItemInOrder> itemsInOrder);

    void deleteOrderItemById(Long orderId, Long itemId);

    Order updateOrder(Order order);

    void deleteOrderAndItems(Long orderId);

    List<Order> getAllOrdersByUserId(Long userId);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    List<ItemInOrder> getOrderItemsByOrderId(Long orderId);
}
