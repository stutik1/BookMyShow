package com.stuti.rowMapper;

import com.stuti.model.Bookings;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Bookings> {

    @Override
    public Bookings mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bookings booking = new Bookings();
        booking.setId(rs.getLong("id"));
        booking.setUserId(rs.getLong("fk_user_id"));
        booking.setShowtimeId(rs.getLong("fk_show_id"));
        booking.setSeatId((rs.getLong("fk_seat_id")));
        booking.setBookingDate(rs.getDate("booking_date").toLocalDate());
        booking.setBookingTime(rs.getTime("booking_time").toLocalTime());
        booking.setStatus(rs.getString("status"));
        return booking;
    }
}
