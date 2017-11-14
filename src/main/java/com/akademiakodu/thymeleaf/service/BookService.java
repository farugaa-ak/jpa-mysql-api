package com.akademiakodu.thymeleaf.service;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository  = bookRepository;
        bookRepository.save(new Book("Natasha", "Krakow2017", "9.09"));
        bookRepository.save(new Book("Natasha", "Krakow2017", "9.09"));
        bookRepository.save(new Book("Marysia", "Wroclaw", "92.09"));
        bookRepository.save(new Book("Zosia", "Gdansk", "9.209"));

    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(Long id) {
        bookRepository.delete(id);
    }
}
