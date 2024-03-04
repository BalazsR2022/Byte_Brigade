package com.geolidth.BackEnd.models.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    private String title;
    @Column(length = 50)
    private String author;
    @Column(length = 40)
    private String publisher;
    @Column(length = 30)
    private String category;
    private boolean canBeBooked;

    public Book() {
    }

    public Book(String title, String author, String publisher, String category, boolean canBeBooked) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.canBeBooked = canBeBooked;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isCanBeBooked() {
        return canBeBooked;
    }
    public void setCanBeBooked(boolean canBeBooked) {
        this.canBeBooked = canBeBooked;
    }










}


