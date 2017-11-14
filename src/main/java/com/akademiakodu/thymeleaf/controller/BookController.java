package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Book;
import com.akademiakodu.thymeleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/bookadd")
    public ModelAndView showForm(ModelMap modelMap){
        modelMap.addAttribute("ksiazka", new Book());
        //1
        //Book book = new Book();
        //th:object //book.set
        //2 thymleaf
//        book.setAuthor("autor");
//        book.setTitle("title");
//        book.setPrice("33242");

        return new ModelAndView("addbook", modelMap); //@Controller + dependencies(thymleaf) - View
    }

    @PostMapping("/bookadd")
    public String addBook(@ModelAttribute Book ksiazka, ModelMap modelMap){
        bookService.addBook(ksiazka);
        modelMap.addAttribute("ksiazka", ksiazka);
        return "redirect:/showbooks"; //GET
    }

    @GetMapping("/showbooks")
    public String showbook(ModelMap modelMap){
        modelMap.addAttribute("ksiazki", bookService.getBooks());
        return "showbooks";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam String id){
        bookService.removeBook(Long.valueOf(id));
        return "redirect:/showbooks";
    }

  /*  @GetMapping("/book/delete/{id}")
    public String deleteBook2(@PathVariable String id){
        bookService.removeBook(Long.valueOf(id));
        return "redirect:/showbooks";
    }*/

}
