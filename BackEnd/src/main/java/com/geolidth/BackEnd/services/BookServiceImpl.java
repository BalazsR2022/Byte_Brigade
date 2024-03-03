package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private List<Book> books;

    public BookServiceImpl() {
        books = new ArrayList<>();
        books.add(new Book("Gyűrűk ura", "J.J.R. Tolkien", "európa","fantasy", true));
        books.add(new Book("Snoopy - szupercsapat", "Charles M. Schulz", "vad virágok","fantasy", true));
        books.add(new Book("Anya csak egy van", "Vámos Miklós", "ab ovo","szépirodalom", false));
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }
}
