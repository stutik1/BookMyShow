package com.stuti.service;

import com.stuti.Movies;
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


    public List<Movies> searchMovie(String language, String genre, String cityName) {
        return movieRepository.searchMovie(language,genre,cityName);
    }
}
