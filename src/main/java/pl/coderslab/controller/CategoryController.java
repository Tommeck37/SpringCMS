package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.CategoryDao;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("/allCategories")
    public String allCategories(){
        Category category = new Category();
        Article article = new Article();
        article.setContent("Poprawka");
        article.setAuthor(new Author());
        category.setDescription("także");
        category.setName("pierdolety");
        category.setArticle(new Article());
        categoryDao.saveCategory(category);
        List<Category> categories = categoryDao.findAllCategories();
        categories.forEach(c-> System.out.println(c.getDescription()));
        System.out.println(categories.toString());
        return "redirect:/listCategories";
    }
    @RequestMapping("/listCategories")
    public String list(Model model){
        model.addAttribute("category", categoryDao.findAllCategories());
        System.out.println(categoryDao.findAllCategories().toString());
        return "categoryList";
    }


    @RequestMapping("add-category")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "add-category";
    }
    @RequestMapping(value = "add-category", method = RequestMethod.POST)
    public String saveCategoryForm(Category category){
        categoryDao.saveCategory(category);
        return "redirect:/listCategories";
    }
    @RequestMapping("/removeCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect:/listCategories";
    }
    @RequestMapping("/editCategory/{id}")
    public String editBook(@PathVariable Long id, Model model){
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @RequestMapping(value = "/editCategory/{id}", method = RequestMethod.POST)
    public String saveEditCategory(@PathVariable Long id, Category category) {
        categoryDao.editCategory(category);

        return "redirect:/listCategories";
    }
}
