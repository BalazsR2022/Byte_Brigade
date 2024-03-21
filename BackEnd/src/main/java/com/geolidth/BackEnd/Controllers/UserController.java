package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewUser;
import com.geolidth.BackEnd.services.BookService;
import com.geolidth.BackEnd.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<BookUser> getById(@PathVariable Integer id) {
        return ResponseEntity.status(OK).body(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<BookUser> signUp(@RequestBody NewUser newUser) {
        return  ResponseEntity.status(CREATED).body(userService.save(newUser));
    }
}