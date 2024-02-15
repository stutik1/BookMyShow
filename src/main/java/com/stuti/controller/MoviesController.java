package com.stuti.controller;

import com.stuti.Movies;
import com.stuti.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bms")
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movies>> filterMovie(@RequestParam String language,@RequestParam String genre,@RequestParam String cityName){
        List<Movies> movies = movieService.searchMovie(language,genre,cityName);
        if(!movies.isEmpty()){
            return ResponseEntity.ok(movies);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
