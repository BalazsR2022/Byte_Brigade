package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.ForbiddenActionException;
import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.exceptions.NoSuchUserException;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private  UserService userService;
    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    @Override
    public List<Book> getBooks(Optional<String> q) {
        if (q.isEmpty()) {
            return bookRepository.findAll();
        } else {
            List<Book> books = new ArrayList<>();
            books.addAll(bookRepository.findAllByAuthorContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByTitleContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByPublisherContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByCategoryContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByCountyContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByQualityContainsIgnoreCase(q.get().toLowerCase()));
            books.addAll(bookRepository.findAllByYear(Integer.parseInt(q.get())));

            return books;
        }
    }
@Override
public Book getById(int id) throws NoSuchBookException {
    return bookRepository.findById(id).orElseThrow(NoSuchBookException::new);

}
@Override
public Book save(NewBook newBook) throws NoSuchUserException {
    Book book = convertToBook(newBook.getId(), newBook);
    return bookRepository.save(book);
}


    @Override
    public Book updateBook(Integer bookId, UpdateBook updateBook)
            throws NoSuchUserException, NoSuchBookException, ForbiddenActionException {
        BookUser user = userService.getById(bookId);
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            if (!bookOptional.get().getOwner().getId().equals(user.getId())) {
                throw new ForbiddenActionException();
            }
            Book book = bookOptional.get();
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
            if (updateBook.getYear() != null && updateBook.getYear() != 0) {
                book.setYear(updateBook.getYear());
            }

            return bookRepository.save(book);
        } else {
            throw new NoSuchBookException();
        }
    }

    public void deleteBook(Integer bookId)
            throws NoSuchUserException, NoSuchBookException, ForbiddenActionException {
        BookUser user = userService.getById(bookId);
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            if (book.get().getOwner().getId().equals(user.getId())) {
                bookRepository.deleteById(bookId);
            } else {
                throw new ForbiddenActionException();
            }
        } else {
            throw new NoSuchBookException();
        }
    }
    public Book convertToBook(Integer userId, NewBook newBook) throws  NoSuchUserException {
        BookUser user = userService.getById(userId);
        Book book = new Book(
                newBook.getId(),
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getPublisher(),
                newBook.getCategory(),
                newBook.getCounty(),
                newBook.getQuality(),
                newBook.getYear());
        book.setOwner(user);
        return book;
    }
    @Override
    public void reserveBook(Integer bookId) throws NoSuchBookException {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new NoSuchBookException();
        }

        Book book = optionalBook.get();
        book.setReserved(true);
        bookRepository.save(book);
    }
}


