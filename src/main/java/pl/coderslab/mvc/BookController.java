package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    //zapisywanie nowej
    @RequestMapping("/book/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Thinking in Java");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");
        authorDao.saveAuthor(author);
        book.setAuthor(author);

        book.setDescription("spoko");
        book.setRating(5);
        book.setPublisher(publisher);
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    //pobieranie po id
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.getById(id);
        return book.toString();
    }

    //update
    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.getById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    //delete po id
    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.getById(id);
        bookDao.delete(book);
        return "deleted";
    }
}
