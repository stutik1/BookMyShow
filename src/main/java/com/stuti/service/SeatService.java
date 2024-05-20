package com.stuti.service;

import com.stuti.model.Seats;
import com.stuti.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(final SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seats> getSeatsByShowId(final Long showId) {
        return seatRepository.findSeatsByShowId(showId);
    }

}
