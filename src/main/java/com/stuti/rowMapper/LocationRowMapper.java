package com.stuti.rowMapper;

import com.stuti.Locations;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper{

        public Locations mapRow(ResultSet rs, int rowNum) throws SQLException {
            Locations locations = new Locations();
            locations.setId(rs.getLong("id"));
            locations.setCity(rs.getString("city"));
            return locations;
        }
    }

