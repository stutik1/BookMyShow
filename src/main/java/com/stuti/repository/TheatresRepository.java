package com.stuti.repository;

import com.stuti.Location;
import com.stuti.Seats;
import com.stuti.Theatres;
import com.stuti.rowMapper.TheatresRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheatresRepository {

    private final JdbcTemplate jdbcTemplate;

    public TheatresRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Theatres> findByLocation(Long id) {
        String sql = "SELECT * " +
                "FROM theaters t " +
                "INNER JOIN location l ON t.location_id = l.id " +
                "WHERE l.id = ?";
        return jdbcTemplate.query(sql, new Object[]{id},new TheatresRowMapper());
        //return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Theatres.class));
    }

    public List<Theatres> findAll() {
        String sql = "SELECT * FROM theaters";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Theatres.class));

    }
}
