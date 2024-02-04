package com.FinalProject.FinalProject.repository;

import com.FinalProject.FinalProject.model.Item;
import com.FinalProject.FinalProject.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private static final String ITEM_TABLE = "items";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE;
        return jdbcTemplate.query(
                sql,
                itemMapper
        );
    }
    @Override
    public Item updateItem(Item item) {
        String sql = "UPDATE " + ITEM_TABLE + " SET name = ?, price = ?, image = ?, in_stock = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                item.getName(),
                item.getPrice(),
                item.getImage(),
                item.getInStock(),
                item.getId());
        return item;
    }

}
