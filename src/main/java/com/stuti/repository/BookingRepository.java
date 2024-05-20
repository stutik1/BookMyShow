package com.stuti.repository;

import com.stuti.model.Bookings;
import com.stuti.rowMapper.BookingRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int saveBooking(Long userId, Long showId, Long seatId, String status) {
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fk_user_id",Integer.parseInt(String.valueOf(userId)));
        mapSqlParameterSource.addValue("fk_show_id",showId);
        mapSqlParameterSource.addValue("fk_seat_id",seatId);
        String insertQuery = "INSERT INTO bookings (fk_user_id, fk_show_id, fk_seat_id, booking_date, booking_time, status)" +
                " VALUES (:fk_user_id, :fk_show_id, :fk_seat_id, CURRENT_DATE, CURRENT_TIME, 'CONFIRMED')";
        return namedParameterJdbcTemplate.update(insertQuery, mapSqlParameterSource);
    }

    public Bookings getBookingById(Long id) {
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("stuti_id",Integer.parseInt(String.valueOf(id)));
        String sql = "select * from bookings where id = :stuti_id ";
        return namedParameterJdbcTemplate.queryForObject(sql,mapSqlParameterSource,new BookingRowMapper());
    }

    public List<Bookings> getBookingsByUserId(Long userId) {
        String query = "SELECT * FROM bookings WHERE fk_user_id = ?";
        return jdbcTemplate.query(query,new BookingRowMapper(), new Object[]{userId});
    }
}

