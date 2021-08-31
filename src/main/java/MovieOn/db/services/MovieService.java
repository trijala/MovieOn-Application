package MovieOn.db.services;

import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDto> getMovies();
    MovieDto getMovieById(long id);
    MovieDto addMovie(Movie movie);
    void deleteMovie(long id);
    MovieDto updateMovie(long id,Movie movie);

}
