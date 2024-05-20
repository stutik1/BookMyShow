package com.stuti.repository;

import com.stuti.model.Seats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepository {

    private final JdbcTemplate jdbcTemplate;
    private Object[] userId;
    private int[] showId;

    @Autowired
    public SeatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Seats> findSeatsByShowId(Long showId) {
        String sql = "select * from seats where fk_show_id = ?";
        return jdbcTemplate.query(sql, new Object[]{showId}, new BeanPropertyRowMapper<>(Seats.class));
    }

    // update and check the seats are available or not
    public boolean isSeatAvailable(Long seatId) {
        String query = "SELECT COUNT(*) FROM seats WHERE seat_id = ? AND status = 'AVAILABLE'";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, seatId);
        return count != null && count > 0;
    }

    public void updateSeatStatus(Long seatId, String newStatus) {
        String updateQuery = "UPDATE seats SET status = ? WHERE seat_id = ?";
        jdbcTemplate.update(updateQuery, newStatus, seatId);
    }
}

