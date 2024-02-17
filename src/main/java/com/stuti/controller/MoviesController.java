package com.stuti.controller;

import com.stuti.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bms/movie")
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, String>> filterMovie(@RequestParam Map<String,String> requestParam){
       // List<Movies> movies = movieService.searchMovie(language,genre,cityName);
        return ResponseEntity.ok(requestParam);
//        if(!movies.isEmpty()){
//            return ResponseEntity.ok(movies);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
    }

//    @PostMapping("/create")
//    public ResponseEntity



}
