package com.stuti.repository;

import com.stuti.Location;
import com.stuti.Movies;
import com.stuti.rowMapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Movies findById(Long id) {
      // String sql = "Select * from movies where id = ?";
       String sql =  "SELECT m.id, m.title, m.rating, m.description, m.actor, m.genres, m.language, m.release_date, l.city FROM movies m JOIN location l ON m.location_id = l.id WHERE m.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new MovieRowMapper());

      //  return (Movies) jdbcTemplate.queryForObject(sql, new Object[]{id}, new MovieRowMapper());

    }

    public List<Movies> getMovie() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movies.class));
    }

    public List<Map<String, Object>> findMoviesByLocation(String city) {

        String[] strs={"Cat","Mat","Ama","Cam"};
        Arrays.stream(strs).filter(a->a.contains("m")).map(String::toUpperCase).collect(Collectors.toList());
        String sql = "SELECT m.title, m.rating, m.description, m.actor, m.genres, m.language, m.release_date " +
                "FROM movies m " +
                "JOIN movie_locations ml ON m.id = ml.movie_id " +
                "JOIN location l ON ml.location_id = l.id " +
                "WHERE l.city = ?";
        return jdbcTemplate.queryForList(sql, city);

    }
}
