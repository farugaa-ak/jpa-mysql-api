package com.akademiakodu.thymeleaf.repository;

import com.akademiakodu.thymeleaf.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long>{

    Article findByTitle(String title); // SEELECT * FROM ARTICLE WHERE c.title = title

    //Spring analyze below method name and generate SQL QUERY
    Article findByTitleAndContent(String title, String content); // SEELECT * FROM ARTICLE WHERE c.title = title AND c.content = content


}
