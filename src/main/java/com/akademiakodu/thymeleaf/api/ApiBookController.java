package com.akademiakodu.thymeleaf.api;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController // add @ResponseBody to all methods
public class ApiBookController {

    private static final Logger LOG = LoggerFactory.getLogger(ApiBookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public Collection<Book> getAllBooks(){
        LOG.info("Getting allBooks");
        return bookService.getBooks();
    }


    //@REquestParam localhost:8080/books?id=3
    //@PathVariable localhost:8080/books/{id}
    @GetMapping("/api/books/{id}")
    //@ResponseBody // JACKSON
    public Book getAllBooks(@PathVariable Long id){
        LOG.info("Getting book={}", id);
        return bookService.getBook(id);
    }

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book  book){
        LOG.info("Saving book={}", book);
        bookService.addBook(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id){
        LOG.info("Deleting book with id={}", id);
        bookService.removeBook(id);
    }





    //api/books  ONLY NOUNS
    ///api/books/1

    //api/doSth -verb NOT!!!!
}
