package com.stuti;

import java.util.List;

public class Movies {
    private Long id;
    private String title;
    private String language;
    private String genre;
    private Locations location;
    private String description;
    private Double rating;

    public Movies(Long id, String title, String language, String genre, Locations location, String description, Double rating) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.location = location;
        this.description = description;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
