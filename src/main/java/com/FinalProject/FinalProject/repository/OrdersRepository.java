package com.FinalProject.FinalProject.repository;

import com.FinalProject.FinalProject.model.ItemInOrder;
import com.FinalProject.FinalProject.model.Order;

import java.util.List;

public interface OrdersRepository {
    void addOrder(Order order);

    void addOrderItem(Long orderId, Long itemId, int quantity);

    void deleteOrderItemById(Long orderId, Long itemId);

    Order updateOrder(Order order);

    void deleteOrderById(Long orderId);


    List<Order> getAllOrdersByUserId(Long userId);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    List<ItemInOrder> getOrderItemsByOrderId(Long orderId);
}
