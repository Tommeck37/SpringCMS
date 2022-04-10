package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.*;

import java.util.List;

@RestController
@Controller
public class HomePageController {
    @Autowired
    public HomePageController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    ArticleDao articleDao;
    AuthorDao authorDao;
    CategoryDao categoryDao;


    @RequestMapping(value = "/")
    public String home() {
        Article article = new Article();
        Author author = new Author();
        author.setFirstName("Tomasz");
        author.setLastName("Czornak");
        article.setAuthor(author);
        article.setContent("Dupa jasiu pierdzi stasiu");
        article.setTitle("testowy tytuł");
        articleDao.saveArticle(article);
        List<Article> articles = articleDao.fiveLastArticles();
        articles.forEach(a -> System.out.println(a.getTitle() + " " + a.getAuthor() + " " + a.getContent()));
        return articles.toString();


    }
}
