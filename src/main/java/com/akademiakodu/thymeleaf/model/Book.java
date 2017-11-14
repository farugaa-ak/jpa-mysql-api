package com.akademiakodu.thymeleaf.model;

//PLAIN OLD JAVA OBJECT POJO
public class Book {

    private String author;
    private String title;
    private String price;

    private Long id;
    public Book() {
    }

    public Book(Long id, String author, String title, String price) {
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
