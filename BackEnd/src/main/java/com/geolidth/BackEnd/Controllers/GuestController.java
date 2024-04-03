package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.exceptions.NoSuchBookException;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.services.BookService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_GUSET')")
@RequestMapping("/guest")
public class GuestController {

    private final BookService bookService;

    public GuestController(BookService bookService) {
        this.bookService = bookService;
    }

    // Könyvek listázása
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    // Könyv részleteinek lekérése
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        try {
            Book book = bookService.getById(bookId);
            return ResponseEntity.ok(book);
        } catch (NoSuchBookException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Könyv lefoglalása
    @PostMapping("/reserve/{id}")
    public ResponseEntity<String> reserveBook(@PathVariable Long id, @RequestBody(required = false) UserCredentials userCredentials) {
        if (userCredentials == null) {
            return new ResponseEntity<>("Belépés szükséges a könyv lefoglalásához.", HttpStatus.UNAUTHORIZED);
        }

        // Ellenőrzés, hogy a felhasználónév, e-mail cím és jelszó helyes-e
        if (isValidCredentials(userCredentials)) {
            // Könyv lefoglalásának logikája
            // ...

            return new ResponseEntity<>("A könyv lefoglalása sikeres volt!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Érvénytelen felhasználónév vagy jelszó.", HttpStatus.BAD_REQUEST);
        }
    }

    // Felhasználói hitelesítő adatok osztály
    @Data
    static class UserCredentials {
        private String username;
        private String email;
        private String password;
    }

    // Felhasználói hitelesítés ellenőrzése
    private boolean isValidCredentials(UserCredentials userCredentials) {
        // Ellenőrzési logika (pl. adatbázisból lekérdezés)
        // ...

        return true; // Ideiglenes, minden hitelesítést elfogadunk
    }
}