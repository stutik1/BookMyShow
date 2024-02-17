package com.stuti.repository;

import com.stuti.Locations;
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

    public Locations createLocation(Locations location) {
        String sql = "INSERT INTO locations(city) VALUES (?)";
        jdbcTemplate.update(sql, location.getCity());
        return location;
    }

    public List<Locations> findAllLocations() {
        String sql = "select * from locations";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Locations.class));
    }

    public Locations findLocationsById(Long id) {
        String sql = "select * from locations where id = ?";
        return (Locations) jdbcTemplate.queryForObject(sql, new Object[]{id}, new LocationRowMapper());
    }

}
