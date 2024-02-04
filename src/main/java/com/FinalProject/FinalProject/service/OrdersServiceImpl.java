package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.ItemInOrder;
import com.FinalProject.FinalProject.model.Order;
import com.FinalProject.FinalProject.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void addOrderAndItems(Order order, List<ItemInOrder> itemsInOrder) {
        ordersRepository.addOrder(order);
        for (ItemInOrder item : itemsInOrder) {
            ordersRepository.addOrderItem(item.getOrderId(), item.getItemId(), item.getQuantity());
        }
    }
    @Override
    public void deleteOrderItemById(Long orderId, Long itemId) {
        ordersRepository.deleteOrderItemById(orderId, itemId);
    }
    @Override
    public Order updateOrder(Order order) {
        return ordersRepository.updateOrder(order);
    }

    @Override
    public void deleteOrderAndItems(Long orderId) {
        ordersRepository.deleteOrderById(orderId);
    }
    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        return ordersRepository.getAllOrdersByUserId(userId);
    }

    @Override
    public List<Order> getAllOrders() {
        return ordersRepository.getAllOrders();
    }
    @Override
    public Order getOrderById(Long orderId) {
        return ordersRepository.getOrderById(orderId);
    }
    @Override
    public List<ItemInOrder> getOrderItemsByOrderId(Long orderId) {
        return ordersRepository.getOrderItemsByOrderId(orderId);
    }


}
