package com.stuti.model;

import java.time.LocalDate;

public class Movie {
    private Long movieId;
    private String title;
    private String language;
    private String genres;
    private String actor;
    private String description;
    private Double rating;
    private LocalDate releaseDate;

    public Movie(Long movieId, String title, String language, String genres, String actor, String description, Double rating, LocalDate releaseDate) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
        this.genres = genres;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public Movie() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
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
