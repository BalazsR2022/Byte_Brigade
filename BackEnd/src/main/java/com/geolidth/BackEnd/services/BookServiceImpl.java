package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();

    }

    @Override
    public Book save(NewBook newBook) {
        Book book = new Book(newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), null, true);
        return bookRepository.save(book);

    }
}
