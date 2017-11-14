package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/article")
    public String showFormArticle(ModelMap modelMap){
        Article articleAttr = new Article();
        modelMap.addAttribute("articleAttribute", articleAttr);
        return "articleForm";
    }

    @PostMapping("/addarticle")
    public String addArticle(@ModelAttribute Article articleAttribute, ModelMap modelMap){
        modelMap.addAttribute("addedArticle", articleAttribute);
        return "showArticle";
    }
}
