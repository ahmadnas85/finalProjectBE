package com.FinalProject.FinalProject.repository;

import com.FinalProject.FinalProject.model.Favorite;
import com.FinalProject.FinalProject.repository.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoritesRepositoryImpl implements FavoritesRepository {
    private static final String FAVORITES_TABLE = "favorites";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public void addFavorite(Long userId, Long itemId) {
        String sql = "INSERT INTO " + FAVORITES_TABLE + " (user_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                userId,
                itemId
        );
    }
    @Override
    public void deleteFavorite(Long userId, Long itemId) {
        String sql = "DELETE FROM " + FAVORITES_TABLE + " WHERE user_id = ? AND item_id = ?";
        jdbcTemplate.update(
                sql,
                userId,
                itemId
        );
    }
    @Override
    public List<Favorite> getFavoritesByUserId(Long userId) {
        String sql = "SELECT item_id FROM " + FAVORITES_TABLE + " WHERE user_id = ?";
        return jdbcTemplate.query(
                sql,
                favoriteMapper,
                userId
        );
    }
}
