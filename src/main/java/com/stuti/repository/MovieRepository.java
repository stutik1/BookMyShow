package com.stuti.repository;

import com.stuti.model.Movie;
import com.stuti.rowMapper.MovieRowMapper;
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

    public List<Movie> searchMovie(String language, String genre, String cityName) {
        String sql = "SELECT m.* FROM movies m " +
                "JOIN movie_locations ml ON m.id = ml.movie_id " +
                "JOIN location l ON ml.location_id = l.id " +
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
        return jdbcTemplate.query(sql, params.toArray(), new BeanPropertyRowMapper<>(Movie.class));

    }

    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movies (id, title, rating, description, actor, genres, language, release_date, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, movie.getMovieId(), movie.getTitle(), movie.getRating(), movie.getDescription(),
                movie.getActor(), String.join(",", movie.getGenres()), movie.getLanguage(), movie.getReleaseDate());
    }

    public Movie findById(Long movieId) {
       String sql = "Select * from movies where id = ?";
       //String sql =  "SELECT m.id, m.title, m.rating, m.description, m.actor, m.genres, m.language, m.release_date, l.city FROM movies m JOIN location l ON m.location_id = l.id WHERE m.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{movieId}, new MovieRowMapper());

      //  return (Movies) jdbcTemplate.queryForObject(sql, new Object[]{id}, new MovieRowMapper());

    }

    public List<Movie> getMovie() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class));
    }

    public List<Movie> findMoviesByLocation(String city) {
        String sql = "SELECT m.id,m.title, m.rating, m.description, m.actor, m.genres, m.language, m.release_date " +
                "FROM movies m " +
                "JOIN movie_locations ml ON m.id = ml.movie_id " +
                "JOIN location l ON ml.location_id = l.id " +
                "WHERE l.city = ?";
        return jdbcTemplate.query(sql,new MovieRowMapper(),city);
    }

    public List<Movie> findMoviesByLocationGenresAndLanguage(String city, String genres, String language) {
        String sql = "SELECT m.* FROM movies m " +
                "JOIN movie_locations ml ON m.id = ml.movie_id " +
                "JOIN location l ON ml.location_id = l.id " +
                "WHERE l.city = ? AND m.genres = ? AND m.language = ?";

        return jdbcTemplate.query(sql, new Object[]{city, genres, language}, new MovieRowMapper());
    }
}
