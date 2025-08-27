package pl.coderslab.mvc.song;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.mvc.Publisher;

import java.util.Set;
import java.util.stream.Collectors;

@RestController

public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validateSong() {
        Song song = new Song();
        song.setTitle("aaaaaa");
        song.setPages(3);
//        song.setRating(5);
        song.setPublisher(new Publisher());

        Set<ConstraintViolation<Song>> constraintViolations = validator.validate(song);

        if (constraintViolations.isEmpty()) {
            return "ok";
        } else {
            String collect = constraintViolations.stream()
                    .map(cv -> cv.getPropertyPath().toString()
                            .concat("  : ")
                            .concat(cv.getMessage())
                            .concat(" "))
                    .collect(Collectors.joining());

            return "fail " + collect;
        }
    }
}