package MovieOn.db.services;

import MovieOn.DTO.FavoriteDto;
import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Favorites;


import java.util.List;

public interface FavoritesService {
    List<MovieDto> findByUser(Long userId);
    FavoriteDto addFavorite(Favorites favorite);
    void deleteFavorite(Long movieId);

}