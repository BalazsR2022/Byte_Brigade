package com.geolidth.BackEnd.models.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
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
    private String quality;
    @Column
    private Integer OwnerId;


    public Book() {
    }

    public Book(Integer id, String title, String author, String publisher, String category, String county, String quality) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.county = county;
        this.quality = quality;

    }
}


