package pl.coderslab.entity;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }
    public void deleteArticle(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
        public Article editArticle(Article article) {
            entityManager.merge(article);
            return article;
        }

    public List<Article> findAllArticle(){
        return entityManager.createQuery("select a from Article a").getResultList();
    }
    public List<Article> fiveLastArticles(){
        return entityManager.createQuery("select a from Article a join fetch a.author order by a.created desc").setMaxResults(5).getResultList();

    }

}
