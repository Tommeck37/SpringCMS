package pl.coderslab.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }
    public void deleteAuthor(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
    public Author editAuthor(Author author) {
        entityManager.merge(author);
        return author;
    }
    public List<Author> findAllAuthors(){
        return entityManager.createQuery("select a from Author a").getResultList();
    }
    public Author findAuthorById(long id) {
        return entityManager.find(Author.class, id);
    }
}
