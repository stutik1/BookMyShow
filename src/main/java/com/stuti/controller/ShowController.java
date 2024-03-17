package com.stuti.controller;

import com.stuti.Shows;
import com.stuti.Theatres;
import com.stuti.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bms/shows")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/search/{movieId}")
    public ResponseEntity<List<Shows>> searchShows(@PathVariable Long movieId) {
        List<Shows> shows = showService.findShowsByMovie(movieId);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/getShow")
    public ResponseEntity<List<Shows>> getShowsByMovieAndLocation(@RequestParam Long movieId, @RequestParam Long id) {
        List<Shows> shows = showService.findShowsByMovieAndLocation(movieId, id);
        return ResponseEntity.ok(shows);
    }
}
