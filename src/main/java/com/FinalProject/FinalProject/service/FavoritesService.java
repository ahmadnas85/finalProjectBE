package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.Favorite;

import java.util.List;

public interface FavoritesService {
    void addFavorite(Long userId, Long itemId);

    void deleteFavorite(Long userId, Long itemId);

    List<Favorite> getFavoritesByUserId(Long userId);
}
