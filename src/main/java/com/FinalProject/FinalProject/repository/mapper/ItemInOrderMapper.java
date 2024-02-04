package com.FinalProject.FinalProject.repository.mapper;

import com.FinalProject.FinalProject.model.ItemInOrder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemInOrderMapper implements RowMapper<ItemInOrder> {
    @Override
    public ItemInOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemInOrder itemInOrder = new ItemInOrder(
                rs.getLong("order_id"),
                rs.getLong("item_id"),
                rs.getInt("quantity")
        );
        return itemInOrder;
    }
}
