package MovieOn.impl;

import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Movie;
import MovieOn.db.repository.MovieRepository;
import MovieOn.db.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private MovieDto mapToDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setDescription(movie.getDescription());
        movieDto.setId(movie.getId());
        movieDto.setPoster(movie.getPoster());
        movieDto.setActive(movie.getActive());
        movieDto.setTitle(movie.getTitle());
        movieDto.setYear_created(movie.getYear_created());
        return movieDto;
    }

    private Movie map(MovieDto movieDto){
        Movie movie = new Movie();
        movie.setYear_created(movieDto.getYear_created());
        movie.setId(movieDto.getId());
        movie.setPoster(movieDto.getPoster());
        movie.setDescription(movieDto.getDescription());
        movie.setTitle(movieDto.getTitle());
        movie.setActive(movieDto.getActive());
        return movie;
    }

    @Override
    public List<MovieDto> getMovies() {

        List<Movie> movies =  movieRepository.findAllByActiveTrue();
        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie m: movies){
            MovieDto movieDto = mapToDto(m);
            movieDtos.add(movieDto);
        }
        return  movieDtos;

    }

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findMovieByIdAndActiveTrue(id);
        MovieDto movieDto = mapToDto(movie);
        return movieDto;
    }

    @Override
    public MovieDto addMovie(Movie movie) {
        Movie m = movieRepository.save(movie);
        MovieDto movieDto = mapToDto(m);
        return movieDto;
    }

    @Override
    public void deleteMovie(long id) {
        Movie movie1 = movieRepository.findById(id).orElseThrow(RuntimeException::new);
        movieRepository.delete(movie1);
    }

    @Override
    public MovieDto updateMovie(long id, Movie movie) {
        Movie currentMovie = movieRepository.findMovieByIdAndActiveTrue(id);
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setYear_created(movie.getYear_created());
        currentMovie.setDescription(movie.getDescription());
        currentMovie.setPoster(movie.getPoster());
        currentMovie.setId(movie.getId());
        currentMovie = movieRepository.save(movie);
        MovieDto movieDto = mapToDto(currentMovie);
        return movieDto;
    }



}
