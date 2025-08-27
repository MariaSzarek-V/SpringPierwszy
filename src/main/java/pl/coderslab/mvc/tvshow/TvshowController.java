//package pl.coderslab.mvc.tvshow;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//import pl.coderslab.mvc.tvshow.Tvshow;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tvshow")
//@Slf4j
//public class TvshowController {
//
//    private final TvshowRepository tvshowRepository;
//
//    public TvshowController(TvshowRepository tvshowRepository) {
//        this.tvshowRepository = tvshowRepository;
//    }
//    @GetMapping
//    public List<Tvshow> getAllMovies() {
//        return tvshowRepository.findAll();
//    }
//    @GetMapping("/{id}")
//    public Tvshow getTvshowById(Long id) {
//        return tvshowRepository.findById(id).orElse(null);
//    }
//    @PostMapping
//    public Tvshow createTvshow(@RequestBody Tvshow tvshow) {
//        log.info("Creating tvshow: {}", tvshow);
//        return tvshowRepository.save(tvshow);
//
//    }
//}