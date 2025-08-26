package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

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

        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Smith");
        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Doe");
        List<Author> authors = Arrays.asList(author1, author2);
        authorDao.saveAuthor(author1);
        authorDao.saveAuthor(author2);
        book.setAuthor(authors);

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


    @RequestMapping("/book/all")
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @RequestMapping("/book/rating/{rating}")
    @ResponseBody
    public List<Book> getAllByRaiting(@PathVariable int rating) {
        return bookDao.findAllByRating(rating);
    }

    @RequestMapping("/book/allwithpublisher")
    @ResponseBody
    public List<Book> getAllByPublisher() {
        return bookDao.findAllWithPublisher();
    }

    @RequestMapping("/book/publisher/{publisherId}")
    @ResponseBody
    public List<Book> getAllByPublisher(@PathVariable Long publisherId) {
        return bookDao.findAllWithSpecifiedPublisher(publisherId);
    }

    @RequestMapping("/book/author/{authorId}")
    @ResponseBody
    public List<Book> getAllByAuthor(@PathVariable Long authorId) {
        return bookDao.findAllWithSpecifiedAuthor(authorId);
    }

}
