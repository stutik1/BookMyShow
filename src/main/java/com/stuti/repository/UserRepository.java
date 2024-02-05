package com.stuti.repository;

import com.stuti.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public Users update(Users user) {
        return user;
    }

    public Users save(Users user) {
        return user;
    }

    public Users getId(Long id) {
         return getId(id);
    }

}
