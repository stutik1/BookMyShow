package com.stuti.repository;

import com.stuti.Movies;
import com.stuti.Seats;
import com.stuti.rowMapper.SeatRowMapper;
import com.stuti.rowMapper.ShowRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SeatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SeatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Seats> findSeatsByShowId(Long showId) {
        String sql = "select * from seats where fk_show_id = ?";
        return jdbcTemplate.query(sql, new Object[]{showId}, new BeanPropertyRowMapper<>(Seats.class));
    }
}
