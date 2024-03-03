package com.geolidth.BackEnd.models;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private boolean canBeBooked;

    public Book(Integer id, String title, String author, String publisher, String category, boolean canBeBooked) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCanBeBooked() {
        return canBeBooked;
    }
}


