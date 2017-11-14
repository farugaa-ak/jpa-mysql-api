package com.akademiakodu.thymeleaf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//PLAIN OLD JAVA OBJECT POJO
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String author;
    private String title;
    private String price;

    public Book() {
    }

    public Book(String author, String title, String price) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
