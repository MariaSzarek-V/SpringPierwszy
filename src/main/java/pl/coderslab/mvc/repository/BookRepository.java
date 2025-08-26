package pl.coderslab.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.mvc.Book;
import pl.coderslab.mvc.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long categoryId);
    List<Book> findByPublisherId(Long publisherId);
    List<Book> findByRating(int rating);
    Book findFirstByCategoryIdOrderByTitleDesc(Long categoryId);
//    List<Book> findByAuthorId(Long authorId);

    @Query("select b from Book b where b.title=?1")
    List<Book> findByTitleQuery(String title);

    @Query("select b from Book b where b.category=?1")
    List<Book> findByCategoryQuery(Category category);

    @Query("SELECT b FROM Book b WHERE b.rating > :min AND b.rating < :max")
    List<Book> findBooksWithRatingBetween(@Param("min") int min, @Param("max") int max);

    @Query("Select b from Book b join b.publisher")
    List<Book> findBooksWithPublisher();


    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @Query("SELECT b FROM Book b WHERE b.category = :category ORDER BY b.title ASC")
    List<Book> findFirstByCategoryOrderByTitleAsc(@Param("category") Category category);



}