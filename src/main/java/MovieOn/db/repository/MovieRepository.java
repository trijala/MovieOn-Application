package MovieOn.db.repository;

import MovieOn.db.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByActiveTrue();
    Movie findMovieByIdAndActiveTrue(Long id);
}

