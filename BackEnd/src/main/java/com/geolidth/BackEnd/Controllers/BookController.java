package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/book")
    public ResponseEntity<Book> getBook() {
        Book book = new Book("Gyűrűk ura", "J.R.R. Tolkien", "európa", "fantasy", true);
        return ResponseEntity.status(200).body(book);
    }

 }
