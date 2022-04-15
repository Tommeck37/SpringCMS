import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.AuthorDao;

import org.springframework.core.convert.converter.Converter;


public class AuthorConverter implements Converter<String, Author> {

    @Override
    public Author convert(String source) {
        return authorDao.findAuthorById(Long.parseLong(source));
    }
    @Autowired
    AuthorDao authorDao;
}
