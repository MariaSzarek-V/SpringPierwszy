package pl.coderslab.mvc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public PersonDetails getById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }
    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }
    public void delete(PersonDetails personDetails) {
        entityManager.remove(entityManager.contains(personDetails) ? personDetails : entityManager.merge(personDetails));
    }

}
