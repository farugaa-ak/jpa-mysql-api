package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1l, "Natasha", "Krakow2017", "9.09"));
        books.add(new Book(2l, "Marysia", "Wroclaw", "92.09"));
        books.add(new Book(3l, "Zosia", "Gdansk", "9.209"));
    }

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
        books.add(ksiazka);
        modelMap.addAttribute("ksiazka", ksiazka);
        return "redirect:/showbooks"; //GET
    }

    @GetMapping("/showbooks")
    public String showbook(ModelMap modelMap){
        modelMap.addAttribute("ksiazki", books);
        return "showbooks";
    }


    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable String id){
        int index = findIndexById(Long.valueOf(id));
        books.remove(index);

        return "redirect:/showbooks";
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
