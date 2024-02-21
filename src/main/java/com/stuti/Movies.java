package com.stuti;

import java.time.LocalDate;
import java.util.List;

public class Movies {
    private Long id;
    private String title;
    private String language;
    private List<String> genres;
    private Location location;
    private String actor;
    private String description;
    private Double rating;
    private LocalDate releaseDate;

    public Movies(Long id, String title, String language, List<String> genres, Location location, String actor, String description, Double rating, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.genres = genres;
        this.location = location;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
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

    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
