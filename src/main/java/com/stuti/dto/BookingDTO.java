package com.stuti.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long showtimeId;
    private Long seatId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String status;
}
