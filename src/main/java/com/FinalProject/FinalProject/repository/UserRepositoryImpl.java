package com.FinalProject.FinalProject.repository;

import com.FinalProject.FinalProject.model.User;
import com.FinalProject.FinalProject.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String USER_TABLE = "users";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        String sql = "INSERT INTO " + USER_TABLE + " (first_name, last_name, email, phone, address_country, address_city, user_name, user_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddressCountry(),
                user.getAddressCity(),
                user.getUserName(),
                user.getUserPassword()
        );
    }
    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE + " WHERE id = ?";
        jdbcTemplate.update(
                sql,
                userId
        );
    }
    @Override
    public User getUserByUserName(String userName) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE user_name = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    userMapper,
                    userName
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE;
        return jdbcTemplate.query(
                sql,
                userMapper
        );
    }
    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    userMapper,
                    email
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public User getUserByPhone(String phone) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE phone = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    userMapper,
                    phone
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM " + USER_TABLE + " WHERE user_name = ? AND user_password = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    userMapper,
                    userName,
                    password
            );
        } catch (Exception e) {
            return null;
        }
    }
}
