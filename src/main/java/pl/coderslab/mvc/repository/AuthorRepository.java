package pl.coderslab.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.mvc.Author;
import pl.coderslab.mvc.Book;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Book, Long> {

//Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
    @Query("SELECT a FROM Author a WHERE LOWER(a.firstName) LIKE LOWER(CONCAT(:prefix, '%'))")
    List<Author> findAuthorsByFirstNamePrefixIgnoreCase(@Param("prefix") String prefix);

    //Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.
    @Query("SELECT a FROM Author a WHERE a.lastName LIKE CONCAT(:prefix, '%')")
    List<Author> findAuthorsByLastNamePrefix(@Param("prefix") String prefix);

}
