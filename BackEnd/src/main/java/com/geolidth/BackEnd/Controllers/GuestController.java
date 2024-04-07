package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.services.BookService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/guest")
public class GuestController {

    private final BookService bookService;

    public GuestController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        try {
            Book book = bookService.getById(id);
            return ResponseEntity.ok(book);
        } catch (NoSuchBookException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity<String> reserveBook(@PathVariable Integer id, @RequestBody(required = false) UserCredentials userCredentials) {
        if (userCredentials == null) {
            return new ResponseEntity<>("Belépés szükséges a könyv lefoglalásához.", HttpStatus.UNAUTHORIZED);
        }
        if (isValidCredentials(userCredentials)) {
            return new ResponseEntity<>("A könyv lefoglalása sikeres volt!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Érvénytelen felhasználónév vagy jelszó.", HttpStatus.BAD_REQUEST);
        }
    }
    @Data
    static class UserCredentials {
        private String username;
        private String email;
        private String password;
    }

    private boolean isValidCredentials(UserCredentials userCredentials) {
        // Ezen még dolgozunk majd, ellenőrzési logika (pl. adatbázisból lekérdezés)
        return true; // Ezen is, csak ideiglenes, minden hitelesítést elfogadunk
    }
}