package pl.coderslab.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.persist(category);
    }
    public void deleteCategory(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
    public Category editCategory(Category category) {
        entityManager.merge(category);
        return category;
    }
    public List findAllCategories(){
        return entityManager.createQuery("select c from Category c ").getResultList();
    }
    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }
    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
}
