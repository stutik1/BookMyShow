package com.stuti.controller;

import com.stuti.Bookings;
import com.stuti.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bms/ticket")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public ResponseEntity<String> bookTickets(@RequestBody Bookings request) {
        Bookings booking = bookingService.createBooking(request.getUserId(), request.getShowtimeId(), request.getSeatId());

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }
}
