package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.models.dto.UpdateBook;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    List<Book> getBooks(Optional<String> q);
    Book getById(int id) throws NoSuchBookException;
    Book save (NewBook book);
    Book updateBook(int id, UpdateBook updateBook) throws NoSuchBookException;
    void deleteBook(int id) throws NoSuchBookException;


}
