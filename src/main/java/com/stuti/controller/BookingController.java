package com.stuti.controller;

import com.stuti.model.Bookings;
import com.stuti.service.BookingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("bms/ticket")
public class BookingController {

    private static final Logger logger = LogManager.getLogger(BookingController.class);
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

//    @PostMapping("/booking")
//    public ResponseEntity<String> bookTickets(@RequestBody Bookings bookings) {
//        try {
//            boolean success = bookingService.bookTicket(bookings);
//            if (success) {
//                return ResponseEntity.ok("Booking successful");
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Booking failed");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during booking: " + e.getMessage());
//        }
//    }

    @PostMapping("/bookings")
    public ResponseEntity<String> bookSeat(@RequestBody Bookings bookings) {

        try {
            logger.info("userId "+bookings.getUserId()+" show time"+ bookings.getShowtimeId()+" Seat Id "+ bookings.getSeatId());
            boolean success = bookingService.bookSeat(bookings.getUserId(), bookings.getShowtimeId(), bookings.getSeatId());
            if (success) {
                return new ResponseEntity<>("Seat booked successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Seat is not available", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Internal Server Error"+e.getMessage());
            return new ResponseEntity<>("Failed to book seat: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


      @GetMapping("{id}")
    public ResponseEntity<?> getBooking(@PathVariable Long id) {
        logger.info("Booking id"+ id);
//        Bookings bookings = bookingService.getBookingById(id);
//        return ResponseEntity.ok().body(bookings);
        if (id <= 0) {
            logger.info("Invalid id"+ id);
            return ResponseEntity.badRequest().body("Invalid booking ID");
        }
        Bookings booking ;
        try {
            booking=bookingService.getBookingById(id);
            logger.info(MessageFormat.format("Booking found {0}", id));
        } catch (EmptyResultDataAccessException e) {
            logger.error("Booking not found"+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        } catch (Exception e) {
            logger.error("Internal Server Error"+id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bookings>> getBookingsByUserId(@PathVariable Long userId) {
        try {
            List<Bookings> bookings = bookingService.getBookingsByUserId(userId);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

