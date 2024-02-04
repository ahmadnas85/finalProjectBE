package com.FinalProject.FinalProject.controller;

import com.FinalProject.FinalProject.model.ItemInOrder;
import com.FinalProject.FinalProject.model.Order;
import com.FinalProject.FinalProject.model.OrderAndItemsRequest;
import com.FinalProject.FinalProject.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    public void addOrderAndItems(@RequestBody OrderAndItemsRequest orderAndItemsRequest) {
        ordersService.addOrderAndItems(orderAndItemsRequest.getOrder(), orderAndItemsRequest.getItemsInOrder());
    }
    @DeleteMapping("/delete/item")
    public void deleteOrderItemById(@RequestParam Long orderId, @RequestParam Long itemId) {
        ordersService.deleteOrderItemById(orderId, itemId);
    }
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return ordersService.updateOrder(order);
    }
    @DeleteMapping("/delete")
    public void deleteOrderAndItems(@RequestParam Long orderId) {
        ordersService.deleteOrderAndItems(orderId);
    }
    @GetMapping("/all/user")
    public List<Order> getAllOrdersByUserId(@RequestParam Long userId) {
        return ordersService.getAllOrdersByUserId(userId);
    }
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return ordersService.getAllOrders();
    }
    @GetMapping("/get")
    public Order getOrderById(@RequestParam Long orderId) {
        return ordersService.getOrderById(orderId);
    }
    @GetMapping("/items")
    public List<ItemInOrder> getOrderItemsByOrderId(@RequestParam Long orderId) {
        return ordersService.getOrderItemsByOrderId(orderId);
    }
}
