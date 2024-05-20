package com.stuti.rowMapper;

import com.stuti.model.Location;
import com.stuti.model.Theatres;
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
        location.setId(rs.getLong("id"));
        location.setCity(rs.getString("city"));
        theater.setLocation(location);

        return theater;
    }
}

