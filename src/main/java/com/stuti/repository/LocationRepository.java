package com.stuti.repository;

import com.stuti.Locations;
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

    public List<Locations> findAllLocations() {
        String sql = "select * from location";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Locations.class));
    }

    public Locations findLocationsById(Long id) {
        String sql = "select * from location where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Locations.class));
    }
}
