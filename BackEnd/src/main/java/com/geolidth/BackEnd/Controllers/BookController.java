package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<Book> save(@RequestBody NewBook newBook, Authentication auth) {
        BookUser user = (BookUser) auth.getPrincipal();
        Book savedBook = bookService.save(user.getId(), newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int bookId,
            @RequestBody UpdateBook updateBook, Authentication auth) {
        BookUser user = (BookUser) auth.getPrincipal();
        Book updatedBook = bookService.updateBook(user.getId(), bookId, updateBook);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }


    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId, Authentication auth) {
        BookUser user = (BookUser) auth.getPrincipal();
        bookService.deleteBook(user.getId(), bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


 }
