package com.FinalProject.FinalProject.repository.mapper;

import com.FinalProject.FinalProject.model.Item;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemMapper implements RowMapper<Item>{

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getString("image"),
                rs.getLong("in_stock")
        );
        return item;
    }
}
