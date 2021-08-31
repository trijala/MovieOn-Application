package MovieOn;

import MovieOn.db.entity.Movie;
import MovieOn.db.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    private final MovieRepository movieRepository;
    
    public MoviesController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovies(@PathVariable Long id) {
        return movieRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody Movie movie) throws URISyntaxException {
       Movie savedClient = movieRepository.save(movie);
        return ResponseEntity.created(new URI("/movies/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Movie movie) {
        Movie currentMovie = movieRepository.findById(id).orElseThrow(RuntimeException::new);
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setYear(movie.getYear());
        currentMovie = movieRepository.save(movie);

        return ResponseEntity.ok(currentMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
