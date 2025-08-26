package pl.coderslab.mvc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person getById(Long id) {
        return entityManager.find(Person.class, id);
    }
    public void update(Person person) {
        entityManager.merge(person);
    }
    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }

}
