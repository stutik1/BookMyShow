package com.stuti.controller;

import com.stuti.model.Movie;
import com.stuti.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bms/movies")
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.findMovieById(movieId);
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam Map<String, String> params, HttpServletRequest request) {
        List<Movie> movies=new ArrayList<>();
        if(params.containsKey("city")){
            movies=movieService.findMoviesByLocation(params.get("city"));
        }else{
           // movies=movieService.get(city, genres, language);
        }
        // movies =
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(movies);
        }
    }

}
