package com.stuti.controller;

import com.stuti.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms")
public class MoviesController {
    private final MovieRepository movieRepository;

    @Autowired
    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


}
