package MovieOn.controller;

import MovieOn.DTO.MovieDto;
import MovieOn.db.entity.Movie;
import MovieOn.db.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {



    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDto> getMovies()	{
        return movieService.getMovies();
    }

    @GetMapping("/api/v1/movies/{id}")
    public MovieDto getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public MovieDto addMovie(@RequestBody Movie movie) throws URISyntaxException {
      return movieService.addMovie(movie);
    }

    @PutMapping("/api/v1/movies/{id}")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
      return movieService.updateMovie(id,movie);
    }

    @DeleteMapping("/api/v1/movies")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

}
