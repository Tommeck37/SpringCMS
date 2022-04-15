package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.ArticleDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.AuthorDao;


import java.util.List;

@Controller
public class ArticleController {


    @Autowired
    public ArticleDao articleDao;

    @Autowired
    public AuthorDao authorDao;

    @RequestMapping("list-articles")
    public String allArticles(Model model){
        model.addAttribute("article", articleDao.findAllArticle());
        return "articleList";
    }
    @RequestMapping("add-article")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        return "add-article";
    }
    @RequestMapping(value = "add-article", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("article") Article article, BindingResult bindingResult){
        articleDao.saveArticle(article);
        return "redirect:/list-articles";
    }
    @ModelAttribute("authors")
    public List<Author> authors() {
        return this.authorDao.findAllAuthors();
    }
    @RequestMapping("/remove-article/{id}")
    public String deleteAuthor(@PathVariable Long id){
        Article article = articleDao.findById(id);
        articleDao.deleteArticle(article);
        return "redirect:/list-articles";
    }
}
