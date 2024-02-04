package com.FinalProject.FinalProject.repository;


import com.FinalProject.FinalProject.model.ItemInOrder;
import com.FinalProject.FinalProject.model.Order;
import com.FinalProject.FinalProject.repository.mapper.ItemInOrderMapper;
import com.FinalProject.FinalProject.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrdersRepositoryImpl implements OrdersRepository {
    private static final String ORDERS_TABLE = "orders";
    private static final String ORDER_ITEMS_TABLE = "order_items";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ItemInOrderMapper itemInOrderMapper;

    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO " + ORDERS_TABLE + " (user_id, order_status, order_date, total_price, order_shipping_address) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                order.getUserId(),
                order.getOrderStatus(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getOrderShippingAddress()
        );
    }
    @Override
    public void addOrderItem(Long orderId, Long itemId, int quantity) {
        String sql = "INSERT INTO " + ORDER_ITEMS_TABLE + " (order_id, item_id, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                orderId,
                itemId,
                quantity
        );
    }
    @Override
    public void deleteOrderItemById(Long orderId, Long itemId) {
        String sql = "DELETE FROM " + ORDER_ITEMS_TABLE + " WHERE order_id = ? AND item_id = ?";
        jdbcTemplate.update(
                sql,
                orderId,
                itemId
        );
    }
    @Override
    public Order updateOrder(Order order) {
        String sql = "UPDATE " + ORDERS_TABLE + " SET user_id = ?, order_status = ?, order_date = ?, total_price = ?, order_shipping_address = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                order.getUserId(),
                order.getOrderStatus(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getOrderShippingAddress(),
                order.getId()
        );
        return order;
    }
    @Override
    public void deleteOrderById(Long orderId) {
        String sql2 = "DELETE FROM " + ORDER_ITEMS_TABLE + " WHERE order_id = ?";
        jdbcTemplate.update(
                sql2,
                orderId
        );
        String sql = "DELETE FROM " + ORDERS_TABLE + " WHERE id = ?";
        jdbcTemplate.update(
                sql,
                orderId
        );

    }
    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE + " WHERE user_id = ?";
        return  jdbcTemplate.query(
                sql,
                orderMapper,
                userId
        );
    }
    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM " + ORDERS_TABLE;
        return jdbcTemplate.query(
                sql,
                orderMapper
        );
    }
    @Override
    public Order getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE + " WHERE id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                orderMapper,
                orderId
        );
    }
    @Override
    public List<ItemInOrder> getOrderItemsByOrderId(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_ITEMS_TABLE + " WHERE order_id = ?";
        return jdbcTemplate.query(
                sql,
                itemInOrderMapper,
                orderId
        );
    }





}