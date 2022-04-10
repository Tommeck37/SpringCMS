import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.CategoryDao;

import org.springframework.core.convert.converter.Converter;


public class CategoryConverter implements Converter<String, Category> {

    @Override
    public Category convert(String source) {
        return categoryDao.findById(Long.parseLong(source));
    }
    @Autowired
    CategoryDao categoryDao;
}
