package pl.coderslab.mvc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.saveAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthorById(@PathVariable Long id) {
        Author author = authorDao.getById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorDao.getById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorDao.getById(id);
        authorDao.delete(author);
        return "author deleted";
    }

}
