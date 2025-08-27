//package pl.coderslab.mvc.tvshow;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/directors")
//@Slf4j
//public class DirectorController {
//
//    private final DirectorRepository directorRepository;
//
//    public DirectorController(DirectorRepository directorRepository) {
//        this.directorRepository = directorRepository;
//    }
//
//    @GetMapping
//    public List<Director> getAllDirectors() {
//        return directorRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Director getDirectorById(@PathVariable Long id) {
//        return directorRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping
//    public Director createDirector(@RequestBody Director director) {
//        log.info("New director: {}", director);
//        return directorRepository.save(director);
//    }
//}
