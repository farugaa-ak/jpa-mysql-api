package com.akademiakodu.thymeleaf.service;

import com.akademiakodu.thymeleaf.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1l, "Natasha", "Krakow2017", "9.09"));
        books.add(new Book(2l, "Marysia", "Wroclaw", "92.09"));
        books.add(new Book(3l, "Zosia", "Gdansk", "9.209"));

    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        int nextId = books.size() + 1;
        book.setId(Long.valueOf(nextId));
        books.add(book);
    }

    public void removeBook(Long id) {
        int index = findIndexById(id);
        books.remove(index);
    }

    private int findIndexById(Long id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                //books.remove(i); // ConcurrentModifcationException
                return i;
            }
        }
        return -1;
    }
}
