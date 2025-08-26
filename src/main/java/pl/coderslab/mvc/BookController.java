package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.mvc.repository.AuthorRepository;
import pl.coderslab.mvc.repository.BookRepository;
import pl.coderslab.mvc.repository.CategoryRepository;
import pl.coderslab.mvc.repository.PublisherRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;

    }

    @RequestMapping("/test/findByTitle/{title}")
    @ResponseBody
    public String findByTitle(@PathVariable String title){
        List<Book> books = bookRepository.findByTitle(title);
        books.forEach(System.out::println);
        return "test/findByTitle";
    }

    @RequestMapping("/test/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id){
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null){
            return book.toString();
        }
        return "Nie ma takiej ksiazki";
    }

    @RequestMapping("/test/createBookWithCategory")
    @ResponseBody
    public String createBookWithCategory(){
        Publisher publisher = new Publisher();
        publisher.setName("Wydawnictwo");
        publisherDao.save(publisher);

        Category category = new Category();
        category.setName("Moja_kategorie");

        // jpa repo ma wbudowaną metode save, category repo może być puste byle by było
        categoryRepository.save(category);

        Book book = new Book();
        book.setTitle("Ksiazka z kategoria");

        Author author1 = new Author();
        author1.setFirstName("Aaa");
        author1.setLastName("XXX");
        Author author2 = new Author();
        author2.setFirstName("Bbb");
        author2.setLastName("YYY");
        List<Author> authors = Arrays.asList(author1, author2);
        authorDao.saveAuthor(author1);
        authorDao.saveAuthor(author2);
        book.setAuthor(authors);
        book.setDescription("opis");
        book.setRating(3);
        book.setPublisher(publisher);
        book.setCategory(category);
        bookDao.saveBook(book);

        return "Id dodanej książki to:"
                + book.getId() +" id categorii " + book.getCategory().getId();
    }

    @RequestMapping("/test/findByCategory/{id}")
    @ResponseBody
    public String findByCategoryName(@PathVariable Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isPresent()){
            Category category = byId.get();
            List<Book> books = bookRepository.findByCategory(category);
            books.forEach(System.out::println);
        }
        return "test/findByCategoryName";
    }
//
//    @RequestMapping("/test/book/author/{id}")
//    @ResponseBody
//    public String findByAuthorId(@PathVariable Long id){
//
//    }

    @RequestMapping("/test/book/publisher/{id}")
    @ResponseBody
    public String findByPublisherId(@PathVariable Long id){
        List<Book> books = bookRepository.findByPublisherId(id);
        books.forEach(System.out::println);
        return "test/book/publisher";

    }


    @RequestMapping("/test/findByCategoryId/{id}")
    @ResponseBody
    public String findByCategoryId(@PathVariable Long id){

        List<Book> books = bookRepository.findByCategoryId(id);
        books.forEach(System.out::println);
        return "test/findByCategoryId";
    }

    @RequestMapping("/test/findByRating/{rating}")
    @ResponseBody
    public String findByRating(@PathVariable int rating){
        List<Book> books = bookRepository.findByRating(rating);
        books.forEach(System.out::println);
        return "test/findByRating";

    }
    //Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
    @RequestMapping("/test/first/{categoryId}")
    @ResponseBody
    public String first(@PathVariable Long categoryId){
        List<Book> books = bookRepository.findByCategoryId(categoryId);
        return "test/first";
    }

//    //Query zapytanie
    @RequestMapping("/find-by-title")
    @ResponseBody
    public String findByTitle(){
        bookRepository.findByTitleQuery("Thinking in Java").forEach(System.out::println);
        return "find-by-title";
    }

    @RequestMapping("author-by-firstname/{prefix}")
    @ResponseBody
    public String findByFirstName(@PathVariable String prefix){
        authorRepository.findAuthorsByFirstNamePrefixIgnoreCase(prefix).forEach(System.out::println);
        return "author-by-firstname";
    }
//    @RequestMapping("/find-first-by-category-order-by-title")
//    @ResponseBody
//    public String findFirstByCategoryOrderByTitle(){
//        bookRepository.findFirstByCategoryOrderByTitleAsc("Moja_kategorie");
//        return "find-first-by-category-order-by-title";
//    }

//    @RequestMapping("/find-by-category")
//    @ResponseBody
//    public String findByCategory(){
//        Category category = new Category();
//        category.setName("Moja_kategorie");
//        bookRepository.findByCategoryQuery(category).forEach(System.out::println);
//
////        bookRepository.findByCategoryQuery("Moja_kategorie").forEach(System.out::println);
//        return "find-by-category";
//    }




    @RequestMapping("/test/findall")
    @ResponseBody
    public String testfindAll() {
        bookRepository.findAll().forEach(System.out::println);
        return "spring data";
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
