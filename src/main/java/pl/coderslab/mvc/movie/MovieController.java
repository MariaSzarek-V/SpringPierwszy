package pl.coderslab.mvc.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping
    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(s -> MovieDTO.builder()
                        .id(s.getId())
                        .title(s.getTitle())
                        .releaseYear(s.getReleaseYear())
                        .build()
                ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(s -> MovieDTO.builder()
                        .id(s.getId())
                        .title(s.getTitle())
                        .releaseYear(s.getReleaseYear())
                        .build()
                )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie " + id + " not found"));
    }

}
