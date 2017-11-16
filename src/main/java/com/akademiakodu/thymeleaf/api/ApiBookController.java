package com.akademiakodu.thymeleaf.api;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.service.ArticleService;
import com.akademiakodu.thymeleaf.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

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
}
