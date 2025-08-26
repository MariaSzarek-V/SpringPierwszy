package pl.coderslab.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.mvc.Category;

@ResponseBody
public interface PublisherRepository extends JpaRepository<Category, Long> {


}