package MovieOn.impl;

import MovieOn.DTO.FavoriteDto;
import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Favorites;
import MovieOn.db.repository.FavoritesRepository;
import MovieOn.db.services.FavoritesService;
import MovieOn.db.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;
    @Autowired
    private MovieService movieService;

    private Favorites map(FavoriteDto favoriteDto){
        Favorites favorites = new Favorites();
        favorites.setIsFavorite(favoriteDto.isFavorite());
        favorites.setFavId(favoriteDto.getFavId());
        favorites.setMovieId(favoriteDto.getMovieId());
        favorites.setUserId(favoriteDto.getUserId());
        return favorites;
    }

    private FavoriteDto mapToDto(Favorites fav){
        FavoriteDto favoriteDto = new FavoriteDto();
        favoriteDto.setFavId(fav.getFavId());
        favoriteDto.setMovieId(fav.getMovieId());
        favoriteDto.setUserId(fav.getUserId());
        favoriteDto.setFavorite(fav.getIsFavorite());
        return  favoriteDto;
    }

    @Override
    public FavoriteDto addFavorite(Favorites favorite) {
//        Favorites fav1 = favoritesRepository.findByMovieIdAndIsFavoriteTrue(favorite.getMovieId());
//        FavoriteDto favoriteDto = new FavoriteDto();
//        if (fav1 == null) {
            Favorites fav = favoritesRepository.save(favorite);
            FavoriteDto favoriteDto = mapToDto(fav);
//        }
        return favoriteDto;
    }

    @Override
    public void deleteFavorite(Long movieId) {
        Favorites fav1 = favoritesRepository.findByMovieIdAndIsFavoriteTrue(movieId);
        favoritesRepository.delete(fav1);

    }

    @Override
    public List<MovieDto> findByUser(Long userId) {
        List<MovieDto> favMovies = new ArrayList<>();
        List<Favorites> favorites = favoritesRepository.findAllByUserIdAndAndIsFavoriteTrue(userId);
        for(Favorites f: favorites ){
            MovieDto movieDto = movieService.getMovieById(f.getMovieId());
            favMovies.add(movieDto);
        }
        return favMovies;

    }


}
