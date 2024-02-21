package com.stuti.repository;

import com.stuti.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movies> searchMovie(String language, String genre, String cityName) {
        String sql = "SELECT m.id, m.title, m.language, m.genre, m.description, m.rating, l.cityName " +
                "FROM movies m " +
                "LEFT JOIN locations l ON m.location_id = l.id " +
                "WHERE 1=1";
        List<Object> params = new ArrayList<>();

        if (language != null) {
            sql += " AND m.language = ?";
            params.add(language);
        }

        if (genre != null) {
            sql += " AND m.genre = ?";
            params.add(genre);
        }

        if (cityName != null) {
            sql += " AND l.cityName = ?";
            params.add(cityName);
        }
        return jdbcTemplate.query(sql, params.toArray(), new BeanPropertyRowMapper<>(Movies.class));

    }

    public void addMovie(Movies movie) {
        String sql = "INSERT INTO movies (id, title, rating, description, actor, genres, language, release_date, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, movie.getId(), movie.getTitle(), movie.getRating(), movie.getDescription(),
                movie.getActor(), String.join(",", movie.getGenres()), movie.getLanguage(), movie.getReleaseDate(),
                movie.getLocation().getId());
    }
}
