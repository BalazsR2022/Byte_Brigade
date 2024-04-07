package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.auth.UserCredentials;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewUser;

import com.geolidth.BackEnd.services.BookService;
import com.geolidth.BackEnd.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController

@RequestMapping("/users")
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping("/user/profile")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')") // Hozzáférés engedélyezése bejelentkezett felhasználóknak
    public ResponseEntity<?> getUserProfile() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        BookUser user = userService.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookUser> getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(OK).body(userService.getById(id));
    }




    @PostMapping("/signup")
    public ResponseEntity<BookUser> signUp(@RequestBody NewUser newUserRequest) {
        BookUser savedUser = userService.save(new BookUser(newUserRequest));
        return ResponseEntity.status(CREATED).body(savedUser);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addBook(book));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/admin/{userId}")
    public ResponseEntity<BookUser> updateUser(@PathVariable Integer userId,
                                               @RequestBody NewUser userDetails) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(userId, userDetails));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/admin/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{userId}")
    public ResponseEntity<BookUser> updateUserData(@PathVariable Integer userId,
                                                   @RequestBody NewUser userDetails) {
        userService.updateUserData(userId, userDetails);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserData(@PathVariable Integer userId) {
        userService.deleteUserData(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/reserve/{bookId}")
    public ResponseEntity<Void> reserveBook(@PathVariable Long bookId,
                                            Authentication authentication) {
        userService.reserveBook(bookId, ((BookUser) authentication.getPrincipal()).getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}