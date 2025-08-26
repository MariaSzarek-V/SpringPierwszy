package pl.coderslab.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.mvc.Book;
import pl.coderslab.mvc.Category;

@ResponseBody
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
