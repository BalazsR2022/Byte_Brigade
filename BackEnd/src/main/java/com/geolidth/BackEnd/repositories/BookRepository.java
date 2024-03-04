package com.geolidth.BackEnd.repositories;

import com.geolidth.BackEnd.models.dao.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();
}
