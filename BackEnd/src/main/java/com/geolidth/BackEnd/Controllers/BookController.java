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

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
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
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody UpdateBook updateBook) {

        try {
            Book updatedBook = bookService.updateBook(id, updateBook);
            return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
        } catch (NoSuchBookException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean deletionResult = bookService.deleteBook(id);
        if (deletionResult) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




 }
