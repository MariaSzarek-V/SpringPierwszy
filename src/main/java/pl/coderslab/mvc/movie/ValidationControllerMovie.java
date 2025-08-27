package pl.coderslab.mvc.movie;



import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController

public class ValidationControllerMovie {
    private final Validator validator;

    public ValidationControllerMovie(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/movievalidate")
    public String validateMovie() {
        Movie movie = new Movie();
        movie.setTitle("film tytul");


        Set<ConstraintViolation<Movie>> constraintViolations = validator.validate(movie);

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