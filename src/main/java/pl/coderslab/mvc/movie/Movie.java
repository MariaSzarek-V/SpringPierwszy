package pl.coderslab.mvc.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    @Size(max = 20)
    private String title;
    private int releaseYear;

    @ManyToMany
    private List<Genre> genres;
    private double rating;

}
