package com.stuti;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bookings {
    private Long id;
    private Long userId;
    private Long showtimeId;
    private Long seatId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String status;

    public Bookings(Long id, Long userId, Long showtimeId, Long seatId, LocalDate bookingDate, LocalTime bookingTime, String status) {
        this.id = id;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.seatId = seatId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    public Bookings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
