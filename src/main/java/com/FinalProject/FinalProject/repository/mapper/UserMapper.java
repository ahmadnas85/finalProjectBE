package com.FinalProject.FinalProject.repository.mapper;

import com.FinalProject.FinalProject.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("address_country"),
            rs.getString("address_city"),
            rs.getString("user_name"),
            rs.getString("user_password")
        );
        return user;
    }
}
