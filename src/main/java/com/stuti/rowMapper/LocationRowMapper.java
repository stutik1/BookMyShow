package com.stuti.rowMapper;

import com.stuti.Location;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper{

        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setId(rs.getLong("id"));
            location.setCity(rs.getString("city"));
            return location;
        }
    }

