package com.stuti.controller;

import com.stuti.model.Shows;
import com.stuti.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/search")
    public ResponseEntity<List<Shows>> getShowsByMovieIdAndCity(@RequestParam Long movieId, @RequestParam String city) {
        List<Shows> shows = showService.getShowsByMovieIdAndCity(movieId, city);
        if (shows.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shows);
    }
}
