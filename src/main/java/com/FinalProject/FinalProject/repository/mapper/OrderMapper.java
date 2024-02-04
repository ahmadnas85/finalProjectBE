package com.FinalProject.FinalProject.repository.mapper;

import com.FinalProject.FinalProject.model.Order;
import com.FinalProject.FinalProject.model.Status;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("order_status"),
                rs.getTimestamp("order_date").toLocalDateTime(),
                rs.getInt("total_price"),
                rs.getString("order_shipping_address")
        );
        return order;
    }
}
