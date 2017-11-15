package com.akademiakodu.thymeleaf.repository;

import com.akademiakodu.thymeleaf.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long>{
}
