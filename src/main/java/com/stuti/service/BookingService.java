package com.stuti.service;

import com.stuti.model.Bookings;
import com.stuti.repository.BookingRepository;
import com.stuti.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService{
    private static final Logger logger = LogManager.getLogger(BookingService.class);
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    public boolean bookSeat(Long userId, Long showId, Long seatId) {
        if (!seatRepository.isSeatAvailable(seatId)) {
            logger.info(String.format("Seat not available {0}",seatId));
            return false;
        }else{
            logger.info(String.format("Seat available {0}",seatId));
        }

        // Book the seat
        logger.info(String.format(" Seat Booking started ",seatId));
        seatRepository.updateSeatStatus(seatId, "BOOKED");
        logger.info(String.format(" Seat booking completed and booking started",seatId));
        // Create booking record

        bookingRepository.saveBooking(userId, showId, seatId, "CONFIRMED");
        logger.info(String.format(" Booking completed ",seatId));
        return true;
    }

    public Bookings getBookingById(Long id) {
        return bookingRepository.getBookingById(id);
    }


    public List<Bookings> getBookingsByUserId(Long userId) {
        return bookingRepository.getBookingsByUserId(userId);
    }
}
