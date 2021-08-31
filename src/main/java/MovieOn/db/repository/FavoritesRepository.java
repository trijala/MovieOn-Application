package MovieOn.db.repository;

import MovieOn.db.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    List<Favorites> findAllByUserIdAndAndIsFavoriteTrue(Long userId);
    Favorites findByMovieIdAndIsFavoriteTrue(Long movieId);
}
