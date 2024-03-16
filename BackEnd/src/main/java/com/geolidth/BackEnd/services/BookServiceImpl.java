package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.repositories.BookRepository;
import org.springframework.stereotype.Service;
import com.geolidth.BackEnd.exceptions.BookNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();

    }
    @Override
    public Book save(NewBook newBook) {
        Book book = new Book(
                newBook.getId(),
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getPublisher(),
                newBook.getCategory(),
                newBook.getCounty(),
                newBook.getQuality());
        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(int id, UpdateBook updateBook) throws NoSuchBookException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book =optionalBook.get();
            if (updateBook.getTitle() != null && !updateBook.getTitle().isBlank()) {
                book.setTitle(updateBook.getTitle());
            }
            if (updateBook.getAuthor() != null && !updateBook.getAuthor().isBlank()) {
                book.setAuthor(updateBook.getAuthor());
            }
            if (updateBook.getPublisher() != null && !updateBook.getPublisher().isBlank()) {
                book.setPublisher(updateBook.getPublisher());
            }
            if (updateBook.getCategory() != null && !updateBook.getCategory().isBlank()) {
                book.setCategory(updateBook.getCategory());
            }
            if (updateBook.getCounty() != null && !updateBook.getCounty().isBlank()) {
                book.setCounty(updateBook.getCounty());
            }
            if (updateBook.getQuality() != null && !updateBook.getQuality().isBlank()) {
                book.setQuality(updateBook.getQuality());
            }

            return bookRepository.save(book);
        } else {
            throw new NoSuchBookException();
        }
    }
    @Override
    public boolean deleteBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

