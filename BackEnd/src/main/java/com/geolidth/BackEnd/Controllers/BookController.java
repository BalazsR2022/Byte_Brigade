package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.Book;
import com.geolidth.BackEnd.models.NewBook;
import com.geolidth.BackEnd.services.BookService;
import com.geolidth.BackEnd.services.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody NewBook newBook) {
        Book savedBook = bookService.save(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }

    

 }
