package com.stuti.service;

import com.stuti.Movies;
import com.stuti.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movies> searchMovie(String cityName) {
        return movieRepository.searchMovie("all","all",cityName);
    }

    public List<Movies> searchMovie(String language, String cityName) {
        return movieRepository.searchMovie(language,"all",cityName);
    }

    public List<Movies> searchMovie(String language, String genre, String cityName) {
        return movieRepository.searchMovie(language,genre,cityName);
    }

    public void createMovie(Movies movie) {
        movieRepository.addMovie(movie);
    }

    public Movies findMovieById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    public List<Movies> getMovies() {
        return movieRepository.getMovie();
    }

    public List<Map<String, Object>> findMoviesByLocation(String city) {
        return movieRepository.findMoviesByLocation(city);
    }

    public List<Movies> getMoviesByLocationGenresAndLanguage(String city, String genres, String language) {
        return movieRepository.findMoviesByLocationGenresAndLanguage(city, genres, language);
    }
}
