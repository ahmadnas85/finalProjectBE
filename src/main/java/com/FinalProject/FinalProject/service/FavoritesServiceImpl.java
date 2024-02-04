package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.Favorite;
import com.FinalProject.FinalProject.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;

    @Override
    public void addFavorite(Long userId, Long itemId) {
        favoritesRepository.addFavorite(userId, itemId);
    }
    @Override
    public void deleteFavorite(Long userId, Long itemId) {
        favoritesRepository.deleteFavorite(userId, itemId);
    }
    @Override
    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoritesRepository.getFavoritesByUserId(userId);
    }
}
