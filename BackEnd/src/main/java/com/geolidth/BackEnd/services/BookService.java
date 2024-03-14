package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.models.dto.UpdatedBook;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book save (NewBook book);
    Book updateBook(int id, UpdatedBook updateBook);
    boolean deleteBook(int id);


}
