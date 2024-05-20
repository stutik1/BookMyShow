package com.stuti.service;

import com.stuti.model.Movie;
import com.stuti.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> searchMovie(String cityName) {
        return movieRepository.searchMovie("all","all",cityName);
    }

    public List<Movie> searchMovie(String language, String cityName) {
        return movieRepository.searchMovie(language,"all",cityName);
    }

    public List<Movie> searchMovie(String language, String genre, String cityName) {
        return movieRepository.searchMovie(language,genre,cityName);
    }

    public void createMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public Movie findMovieById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovie();
    }

    public List<Movie> findMoviesByLocation(String city) {
        return movieRepository.findMoviesByLocation(city);
    }

    public List<Movie> getMoviesByLocationGenresAndLanguage(String city, String genres, String language) {
        return movieRepository.findMoviesByLocationGenresAndLanguage(city, genres, language);
    }
}
