package com.stuti.repository;

import com.stuti.Location;
import com.stuti.rowMapper.LocationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Location createLocation(Location location) {
        String sql = "INSERT INTO location(city) VALUES (?)";
        jdbcTemplate.update(sql, location.getCity());
        return location;
    }

    public List<Location> findAllLocations() {
        String sql = "select * from location";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Location.class));
    }

    public Location findLocationsById(Long id) {
        String sql = "select * from location where id = ?";
        return (Location) jdbcTemplate.queryForObject(sql, new Object[]{id}, new LocationRowMapper());
    }

}
