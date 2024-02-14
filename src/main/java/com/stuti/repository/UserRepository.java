package com.stuti.repository;

import com.stuti.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Users update(Users user) {
        return user;
    }

    public Users save(Users user) {
        String sql = "INSERT INTO users (name,email,phone,createat) VALUES (?, ?, ?,?)";
        jdbcTemplate.update(
                sql,
                user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getCreateAt()

        );
        return user;
    }

    public Users getId(Long id) {
         return getId(id);
    }

}
