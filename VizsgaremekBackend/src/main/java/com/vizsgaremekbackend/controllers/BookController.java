package com.vizsgaremekbackend.controllers;

import com.vizsgaremekbackend.VizsgaremekbackendApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public String getBooks() {
        return "Books végpont";
    }


}
