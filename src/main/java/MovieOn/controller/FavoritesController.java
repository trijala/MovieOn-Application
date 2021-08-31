package MovieOn.controller;

import MovieOn.DTO.FavoriteDto;
import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Favorites;
import MovieOn.db.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @GetMapping
    public List<MovieDto> getFavorites(@RequestParam Long userId) {
       return favoritesService.findByUser(userId);
    }

    @PostMapping
    @ResponseBody
    public FavoriteDto addFavorite(@RequestBody Favorites fav){
             return favoritesService.addFavorite(fav);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteFavorite(@RequestParam Long movieId){
        favoritesService.deleteFavorite(movieId);
    }
}
