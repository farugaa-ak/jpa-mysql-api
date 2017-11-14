package com.akademiakodu.thymeleaf.repository;

import com.akademiakodu.thymeleaf.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    //CREATE\READ | UPDATE |DELETE

}
