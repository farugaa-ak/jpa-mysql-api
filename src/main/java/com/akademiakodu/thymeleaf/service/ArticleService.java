package com.akademiakodu.thymeleaf.service;

import com.akademiakodu.thymeleaf.model.Article;
import com.akademiakodu.thymeleaf.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public void save(Article articleAttribute) {
        articleRepository.save(articleAttribute);
    }

    public List<Article> findAll(){
        Iterable<Article> all = articleRepository.findAll();

        List<Article> articles = convertToList(all);

        return articles;
    }

    private List<Article> convertToList(Iterable<Article> all) {
        List<Article> articles = new ArrayList<>();
        for (Article article : all) {
            articles.add(article);
        }
        return articles;
    }
}
