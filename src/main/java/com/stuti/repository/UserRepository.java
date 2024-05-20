package com.stuti.repository;

import com.stuti.model.Users;
import com.stuti.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Users update(Users user){
        return user;
    }

    public Users save(Users user) {
        String sql = "INSERT INTO users (name,email,phone,createat) VALUES (?, ?, ?,?)";
        jdbcTemplate.update(
                sql,
                user.getName(),
                user.getPhone(),
                user.getEmail(),
             Timestamp.from(Instant.now())  //TODO  : have to convert ist to utc time zone
        );
        return user;
    }

    public Users findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return (Users) jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }
}
