package com.FinalProject.FinalProject.controller;

import com.FinalProject.FinalProject.model.Favorite;
import com.FinalProject.FinalProject.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;

    @PostMapping("/add")
    public void addFavorite(@RequestParam Long userId,@RequestParam Long itemId) {
        favoritesService.addFavorite(userId, itemId);
    }
    @GetMapping("/getFavById")
    public List<Favorite> getFavoritesByUserId(@RequestParam Long userId) {
        return favoritesService.getFavoritesByUserId(userId);
    }
    @DeleteMapping("/delete")
    public void deleteFavorite(@RequestParam Long userId, @RequestParam Long itemId) {
        favoritesService.deleteFavorite(userId, itemId);
    }

}
