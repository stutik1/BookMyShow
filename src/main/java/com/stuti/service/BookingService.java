package com.stuti.service;

import com.stuti.Bookings;
import com.stuti.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService{

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Bookings createBooking(Long userId, Long showtimeId, Long seatId) {
        return bookingRepository.create();
    }
}
