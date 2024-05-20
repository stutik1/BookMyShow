package com.stuti.rowMapper;

import com.stuti.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setRating(rs.getDouble("rating"));
        movie.setDescription(rs.getString("description"));
        movie.setActor(rs.getString("actor"));
        movie.setGenres(rs.getString("genres"));
        movie.setLanguage(rs.getString("language"));
        movie.setReleaseDate(rs.getDate("release_date").toLocalDate());
//        Location location = new Location();
//        location.setCity(rs.getString("city"));
//        movie.setLocation(location);

        return movie;

    }
}
