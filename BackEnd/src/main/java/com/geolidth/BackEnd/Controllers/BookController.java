package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.UserRole;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.UpdateBook;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dto.NewBook;
import com.geolidth.BackEnd.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam(required = false) String query) {
        List<Book> books = bookService.searchBooks(query);
        return ResponseEntity.ok(books);
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
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int bookId,
            @RequestBody UpdateBook updateBook) {
        Book updatedBook = bookService.updateBook(bookId, updateBook);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/{bookId}/reserve")
    public ResponseEntity<Void> reserveBook(@PathVariable Integer bookId, Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            try {
                bookService.reserveBook(bookId);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (NoSuchBookException e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}