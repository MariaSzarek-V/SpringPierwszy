package pl.coderslab.mvc.tvshow;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String title;
    private int releaseYear;
    private List<String> genres;
    private double rating;
}
