package com.stuti.repository;

import com.stuti.Shows;
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

    public List<Shows> findShowsByMovieAndLocation(Long movieId, Long id) {
        String sql = "SELECT s.* FROM shows s JOIN movies m ON s.movie_id = m.id JOIN location l ON s.location_id = l.id WHERE m.id = ? AND l.id = ?";
        return jdbcTemplate.query(sql, new Object[] { movieId, id }, new ShowRowMapper());
    }
}
