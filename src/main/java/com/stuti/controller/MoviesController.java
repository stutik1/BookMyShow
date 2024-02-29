package com.stuti.controller;

import com.stuti.Movies;
import com.stuti.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
       //List<Movies> movies = movieService.searchMovie();

        return ResponseEntity.ok(requestParam);
//        if(!movies.isEmpty()){
//            return ResponseEntity.ok(movies);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> addMovie(@RequestBody Movies movie){
        movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/{id}")
    public Movies getMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/getAllMovie")
    public ResponseEntity<Movies> getAllMovies(){
        List<Movies> movies = movieService.getMovies() ;
        return (ResponseEntity) ResponseEntity.ok(movies);
    }

    @GetMapping("/byLocation")
    public List<Map<String, Object>> findMoviesByLocation(@RequestParam String city) {
        return movieService.findMoviesByLocation(city);
    }
}
