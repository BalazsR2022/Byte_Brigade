package com.geolidth.BackEnd.models.dto;

public class NewBook {
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String county;
    public String condition;









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

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getCounty() { return county; }
    public void setCounty(String county) { this.county = county; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}
