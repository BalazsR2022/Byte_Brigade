package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.models.dto.UpdatedBook;
import com.geolidth.BackEnd.repositories.BookRepository;
import org.springframework.stereotype.Service;
import com.geolidth.BackEnd.exceptions.BookNotFoundException;

import java.util.List;
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
                newBook.getCondition());
        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(int id, UpdatedBook updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublisher(updatedBook.getPublisher());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setCounty(updatedBook.getCounty());
            existingBook.setCondition(updatedBook.getCondition());

            return bookRepository.save(existingBook);
        } else {
            throw new BookNotFoundException("Ezzel az azonosítóval könyv nem található: " + id);
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

