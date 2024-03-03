package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.Book;
import com.geolidth.BackEnd.models.NewBook;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book save (NewBook book);

}
