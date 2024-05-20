package com.stuti.repository;

import com.stuti.model.Theatres;
import com.stuti.rowMapper.TheatresRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TheatresRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TheatresRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Theatres> findByLocation(Long id) {
        String sql = "SELECT * " +
                "FROM theaters t " +
                "INNER JOIN location l ON t.location_id = l.id " +
                "WHERE l.id = ?";

        return jdbcTemplate.query(sql, new Object[]{id},new TheatresRowMapper());
    }

    public List<Theatres> findAll() {
        String sql = "SELECT t.id, t.name, t.location_id, l.city " +
                "FROM theaters t " +
                "JOIN location l ON t.location_id = l.id";
        return jdbcTemplate.query(sql,new TheatresRowMapper());

    }
}
