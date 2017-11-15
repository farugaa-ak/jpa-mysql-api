package com.akademiakodu.thymeleaf.controller;

import com.akademiakodu.thymeleaf.model.Article;
import com.akademiakodu.thymeleaf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public String showFormArticle(ModelMap modelMap){
        Article articleAttr = new Article();
        modelMap.addAttribute("articleAttribute", articleAttr);

        //view
        return "articleForm";
    }

    @PostMapping("/addarticle")
    public String addArticle(@ModelAttribute Article articleAttribute, ModelMap modelMap){
        //sent to Database
        articleService.save(articleAttribute);
        modelMap.addAttribute("articlesAttribute", articleService.findAll());
        return "showArticles";
    }

    @GetMapping("/article/{title}")
    public String showArticleByTitle(@PathVariable String title, ModelMap modelMap){
        Article articleByTitle = articleService.findArticleByTitle(title);
        modelMap.addAttribute("addedArticle", articleByTitle);

        return "showArticle";
    }


}
