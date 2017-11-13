package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {



    @GetMapping("/bookadd")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("book", new Book());
        return "addbook";
    }


    @PostMapping("/bookadd")
    public String addBook(@ModelAttribute Book book, ModelMap modelMap){
        modelMap.addAttribute("book", book);
        return "showbook";
    }











/*    @GetMapping("/showbook")
    public String showbook(@ModelAttribute Book book, ModelMap modelMap){
        modelMap.addAttribute("book", new Book());
        return "showbook";
    }*/
}
