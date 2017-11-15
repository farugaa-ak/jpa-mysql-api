package com.akademiakodu.thymeleaf.service;

import com.akademiakodu.thymeleaf.model.Article;
import com.akademiakodu.thymeleaf.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    ArticleRepository articleRepository;

    public void save(Article articleAttribute) {
        LOG.info("User is saving article={}", articleAttribute);
        System.out.println("### User is saving article=" + articleAttribute);
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

    public Article findArticleByTitle(String title){
        LOG.info("User is trying to find article with title={}", title);
        Article byTitle = articleRepository.findByTitle(title);
        if (byTitle == null) {
            LOG.warn("Article with title={} not found", title);
            return new Article("article doesnt exist", "article doesnt exist", "article doesnt exist");
        }
        return byTitle;
    }
}
