package com.stuti.controller;

import com.stuti.Seats;
import com.stuti.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class SeatsController {

    private final SeatService seatService;

    @Autowired
    public SeatsController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats/{showId}")
    public ResponseEntity<List<Seats>> getSeatsByShow(@PathVariable Long showId) {
        List<Seats> seats = seatService.findSeatsByShowId(showId);
            return ResponseEntity.ok(seats);
    }
}
