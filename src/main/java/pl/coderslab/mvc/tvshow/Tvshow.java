//package pl.coderslab.mvc.tvshow;
//
//import jakarta.persistence.*;
//import lombok.*;
//import pl.coderslab.mvc.tvshow.Director;
//
//
//@Entity
//@Getter
//@Setter
//@ToString
////@Builder
//@NoArgsConstructor
//
//public class Tvshow {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    int releaseYear;
//
//    @ManyToOne
//    private Director director;
//
//}