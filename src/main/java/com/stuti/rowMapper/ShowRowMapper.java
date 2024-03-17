package com.stuti.rowMapper;

import com.stuti.Location;
import com.stuti.Movies;
import com.stuti.Shows;
import com.stuti.Theatres;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shows shows = new Shows();
        shows.setShowId(rs.getLong("id"));
        shows.setDate(rs.getDate("show_date").toLocalDate());
        shows.setStart_time(rs.getTime("start_time").toLocalTime());
        shows.setEnd_time(rs.getTime("end_time").toLocalTime());

        Movies movie = new Movies();
        movie.setMovieId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setRating(rs.getDouble("rating"));
        movie.setDescription(rs.getString("description"));
        movie.setActor(rs.getString("actor"));
        movie.setGenres(rs.getString("genres"));
        movie.setLanguage(rs.getString("language"));
        movie.setReleaseDate(rs.getDate("release_date").toLocalDate());
        shows.setMovies(movie);

        Location location = new Location();
        location.setId(rs.getLong("id"));
        location.setCity(rs.getString("city"));
        shows.setLocation(location);

        Theatres theatre = new Theatres();
        theatre.setId(rs.getLong("id"));
        theatre.setName(rs.getString("name"));
        theatre.setLocation(rs.getLong("location_id"));
        shows.setTheatres(theatre);

        return shows;
    }
}
