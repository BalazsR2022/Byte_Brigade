package com.vizsgaremekbackend;
import org.springframework.stereotype.Service;


import java.awt.print.Book;
import java.util.List;

@Service
public class VizsgaremekbackendApplication {
	private List<Book>book;
	public VizsgaremekbackendApplication(){


		book.add(new Book());
		book.add(new Book());


	}

	public List<Book> getBooks() {
		return book;
	}
}
