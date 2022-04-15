package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.AuthorDao;
import pl.coderslab.entity.Category;


@Controller
public class AuthorController {

    @Autowired
    public AuthorDao authorDao;

    @RequestMapping("/list-authors")
    public String allAuthors(Model model) {
        model.addAttribute("author", authorDao.findAllAuthors());
        return "authorList";
    }
    @RequestMapping("add-author")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "add-author";
    }
    @RequestMapping(value = "add-author", method = RequestMethod.POST)
    public String saveAuthor(Author author){
        authorDao.saveAuthor(author);
        return "redirect:/list-authors";
    }
    @RequestMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id){
        Author author = authorDao.findAuthorById(id);
        authorDao.deleteAuthor(author);
        return "redirect:/list-authors";
    }
    @RequestMapping("/edit-author/{id}")
    public String editBook(@PathVariable Long id, Model model){
        Author author = authorDao.findAuthorById(id);
        model.addAttribute("author", author);
        return "edit-author";
    }
    @RequestMapping(value = "/edit-author/{id}", method = RequestMethod.POST)
    public String saveEditCategory(@PathVariable Long id, Author author) {
        authorDao.editAuthor(author);

        return "redirect:/list-authors";
    }
}
