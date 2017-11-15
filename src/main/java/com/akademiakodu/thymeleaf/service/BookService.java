package com.akademiakodu.thymeleaf.service;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger LOG = LoggerFactory.getLogger(BookService.class);

    //injection by field/setter
    BookRepository bookRepository;

    //injection by constructor
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        bookRepository.save(new Book("Natasha", "Krakow2017", "9.09"));
        bookRepository.save(new Book("Natasha", "Krakow2017", "9.09"));
        bookRepository.save(new Book("Marysia", "Wroclaw", "92.09"));
        bookRepository.save(new Book("Zosia", "Gdansk", "9.209"));

    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);//adding rows to book table
    }

    public void removeBook(Long id) {
        bookRepository.delete(id);
    }
}
