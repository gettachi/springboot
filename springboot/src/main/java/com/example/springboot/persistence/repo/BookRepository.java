package com.example.springboot.persistence.repo;

import com.example.springboot.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findByTitle(String title);

}