package com.geolidth.BackEnd.repositories;

import com.geolidth.BackEnd.models.dao.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();

    //List<Book> findAllByCanBeBooked(Boolean canBeBooked);
    //@Query(value = "SELECT * FROM books WHERE author LIKE %barmi%", nativeQuery = true)
    List<Book> findAllByAuthorContainsIgnoreCase(String q);
    List<Book> findAllByTitleContainsIgnoreCase(String q);
    List<Book> findAllByPublisherContainsIgnoreCase(String q);
    List<Book> findAllByCategoryContainsIgnoreCase(String q);
    List<Book> findAllByCountyContainsIgnoreCase(String q);
    List<Book> findAllByQualityContainsIgnoreCase(String q);



}
