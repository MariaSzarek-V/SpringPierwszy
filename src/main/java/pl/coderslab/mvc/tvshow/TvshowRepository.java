package pl.coderslab.mvc.tvshow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.mvc.movie.Tvshow;

@Repository
public interface TvshowRepository extends JpaRepository<Tvshow, Long> {
}