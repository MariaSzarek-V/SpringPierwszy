package pl.coderslab.mvc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher getById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(publisher);
    }

    public List<Publisher> findAll() {
        return entityManager.createQuery("select p from Publisher p", Publisher.class).getResultList();
    }


}
