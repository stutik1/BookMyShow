package com.stuti.controller;

import com.stuti.model.Seats;
import com.stuti.repository.BookingRepository;
import com.stuti.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/bms")
public class SeatsController {

    private final SeatService seatService;
    private final BookingRepository bookingRepository;

    @Autowired
    public SeatsController(SeatService seatService, BookingRepository bookingRepository) {
        this.seatService = seatService;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/shows/{showId}/seats")
    public ResponseEntity<List<Seats>> getSeatsByShowId(@PathVariable Long showId) {
        List<Seats> seats = seatService.getSeatsByShowId(showId);
        if (seats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(seats);
    }
}
