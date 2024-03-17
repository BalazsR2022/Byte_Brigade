package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.dto.ErrorMessage;
import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam Optional<String> q) {
        List<Book> books = bookService.getBooks(q);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book book = bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody NewBook newBook) {
        Book savedBook = bookService.save(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody UpdateBook updateBook) {
        Book updatedBook = bookService.updateBook(id, updateBook);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @ExceptionHandler(NoSuchBookException.class)
    public ResponseEntity<ErrorMessage> handleNoSuchBookException(NoSuchBookException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(e.getMessage()));
    }

 }
