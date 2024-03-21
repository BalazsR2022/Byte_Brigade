package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Book> save(@RequestHeader Integer userId, @RequestBody NewBook newBook) {
        Book savedBook = bookService.save(userId, newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int bookId,
            @RequestHeader Integer userId,
            @RequestBody UpdateBook updateBook) {
        Book updatedBook = bookService.updateBook(userId, bookId, updateBook);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId, @RequestHeader Integer userId) {
        bookService.deleteBook(userId, bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


 }
