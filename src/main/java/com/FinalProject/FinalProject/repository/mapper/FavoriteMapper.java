package com.FinalProject.FinalProject.repository.mapper;

import com.FinalProject.FinalProject.model.Favorite;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FavoriteMapper implements RowMapper<Favorite> {
    @Override
    public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
        Favorite favorite = new Favorite(
                rs.getLong("user_id"),
                rs.getLong("item_id")
        );
        return favorite;
    }
}
