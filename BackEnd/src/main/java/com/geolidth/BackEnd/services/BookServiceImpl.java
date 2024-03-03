package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.Book;
import com.geolidth.BackEnd.models.NewBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private List<Book> books;

    public BookServiceImpl() {
        books = new ArrayList<>();
        books.add(new Book(1,"Gyűrűk ura", "J.J.R. Tolkien", "európa","fantasy", true));
        books.add(new Book(2,"Snoopy - szupercsapat", "Charles M. Schulz", "vad virágok","fantasy", true));
        books.add(new Book(3,"Anya csak egy van", "Vámos Miklós", "ab ovo","szépirodalom", false));
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book save(NewBook newBook) {
        Book book = new Book(books.size() + 1, newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), null, true);
        books.add(book);
        return book;
    }
}
