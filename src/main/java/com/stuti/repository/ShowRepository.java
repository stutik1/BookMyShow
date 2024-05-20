package com.stuti.repository;

import com.stuti.model.Shows;
import com.stuti.rowMapper.ShowRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Shows> findShowsByMovie(Long movieId) {
        //String sql = "select * from shows join movies m on shows.movie_id = m.id join location l on shows.location_id = l.id where m.id = ?";
        String sql = "SELECT * FROM shows WHERE movie_id = ?";
        return jdbcTemplate.query(sql, new Object[]{movieId}, new ShowRowMapper());

    }

    public List<Shows> findShowsByMovieAndLocation(Long movieId, String city) {
        String sql = "SELECT s.id, s.show_date, s.start_time, s.end_time, t.name , l.city FROM shows s " +
                "JOIN theaters t ON s.theater_id = t.id " +
                "JOIN location l ON t.location_id = l.id " +
                "WHERE s.movie_id = ? AND l.city = ?";
        return jdbcTemplate.query(sql, new Object[]{movieId, city}, new ShowRowMapper());
    }
}

