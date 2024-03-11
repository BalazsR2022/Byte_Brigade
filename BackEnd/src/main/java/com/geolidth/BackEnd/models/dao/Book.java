package com.geolidth.BackEnd.models.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String title;
    @Column(length = 50)
    private String author;
    @Column(length = 50)
    private String publisher;
    @Column(length = 30)
    private String category;
    @Column(length = 50)
    private String county;
    @Column(length = 50)
    private String condition;
    private Integer OwnerId;


    public Book() {
    }

    public Book(String title, String author, String publisher, String category, String county, String condition) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.county = county;
        this.condition = condition;

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
    public String getCounty() { return county; }
    public void setCounty(String county) { this.county = county; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public Integer getOwnerId() { return OwnerId; }
    public void setOwnerId(Integer ownerId) { OwnerId = ownerId; }













}


