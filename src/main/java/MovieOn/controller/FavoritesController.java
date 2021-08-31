package MovieOn;

import MovieOn.db.entity.Movie;
import MovieOn.db.repository.FavoritesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/favorites")

public class FavoritesController {

    private final FavoritesRepository favoritesRepository;

    public FavoritesController(FavoritesRepository favoritesRepository){
        this.favoritesRepository = favoritesRepository;

    }

    @GetMapping
    public List<Movie> getFavorites() {
        return favoritesRepository.findAll();
    }

    @GetMapping("/{movie_id}")
    public Movie getFavorites(@PathVariable Long movie_id) {
        return favoritesRepository.findById(movie_id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity addFavorite(@RequestBody Movie movie) throws URISyntaxException {
        Movie savedClient = favoritesRepository.save(movie);
        return ResponseEntity.created(new URI("/favorites/" + savedClient.getId())).body(savedClient);
    }
}
