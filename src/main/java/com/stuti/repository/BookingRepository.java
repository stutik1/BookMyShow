package com.stuti.repository;

import com.stuti.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Bookings create() {
        String sql = "INSERT INTO bookings (user_id, showtime_id, seat_id, booking_date, booking_time, status) VALUES (?, ?, ?, CURRENT_DATE, CURRENT_TIME, 'confirmed') RETURNING *";

        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Bookings.class));
    }
}
