package com.geolidth.BackEnd.models.dto;

import lombok.Data;

@Data
public class NewBook {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String county;
    public String quality;
    public Integer year;
}