package pl.coderslab.mvc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book getById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }


    public List<Book> findAll() {
//        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public List<Book> findAllByRating(int rating){
        return entityManager
                .createQuery("select distinct b from Book b join fetch b.authors a join fetch b.publisher where b.rating = :rating", Book.class)
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findAllWithPublisher(){
        return entityManager.createQuery("select b from Book b join b.publisher", Book.class).getResultList();
    }

    public List<Book> findAllWithSpecifiedPublisher(Long publisherId){
        return entityManager.createQuery("select distinct b from Book b where b.publisher.id = :publisherId", Book.class).setParameter("publisherId", publisherId).getResultList();
    }

    public List<Book> findAllWithSpecifiedAuthor(Long authorId){
        return entityManager.createQuery( "select distinct b from Book b join fetch b.authors a where a.id = :authorId", Book.class ) .setParameter("authorId", authorId) .getResultList();     }
}
