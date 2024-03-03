package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.Book;
import com.geolidth.BackEnd.services.BookService;
import com.geolidth.BackEnd.services.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

 }
