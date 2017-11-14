package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    //List<Book> = new ArrayList [..]

    @GetMapping("/bookadd")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("ksiazka", new Book());
        //1
        //Book book = new Book();
        //th:object //book.set
        //2 thymleaf
//        book.setAuthor("autor");
//        book.setTitle("title");
//        book.setPrice("33242");

        return "addbook"; //@Controller + dependencies(thymleaf) - View
    }

    @PostMapping("/bookadd")
    public String addBook(@ModelAttribute Book ksiazka, ModelMap modelMap){
        //list.add(book)
        modelMap.addAttribute("ksiazka", ksiazka);
        return "showbook";
    }


/*    @GetMapping("/showbooks")
    public String showbook(@ModelAttribute Book book, ModelMap modelMap){
        modelMap.addAttribute("books", new Book());
        return "showbook";
    }*/
}
