package com.stuti.rowMapper;

import com.stuti.Location;
import com.stuti.Theatres;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TheatresRowMapper implements RowMapper<Theatres> {

    @Override
    public Theatres mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theatres theater = new Theatres();
        theater.setId(rs.getLong("id"));
        theater.setName(rs.getString("name"));

        Location location = new Location();
        location.setId(rs.getLong("location_id"));
        location.setCity(rs.getString("city"));
        theater.setLocation(location);

        return theater;
    }
}

