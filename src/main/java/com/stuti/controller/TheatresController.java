package com.stuti.controller;

import com.stuti.Theatres;
import com.stuti.service.TheatresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bms/theaters")
public class TheatresController {

    private final TheatresService theaterService;

    @Autowired
    public TheatresController(TheatresService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<List<Theatres>> searchTheatersByLocationId(@PathVariable Long id) {
        List<Theatres> theaters = theaterService.findTheatersByLocation(id);
        return ResponseEntity.ok(theaters);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Theatres>> getAllTheaters() {
        List<Theatres> theaters = theaterService.getAllTheaters();
        return ResponseEntity.ok(theaters);
    }
}

