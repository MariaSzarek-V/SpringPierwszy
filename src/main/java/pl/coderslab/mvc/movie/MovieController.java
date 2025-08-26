package pl.coderslab.mvc.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Slf4j
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        log.info("Creating movie: {}", movie);
        return movieRepository.save(movie);
    }
}