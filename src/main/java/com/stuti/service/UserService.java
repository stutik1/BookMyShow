package com.stuti.service;

import com.stuti.Users;
import com.stuti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long saveUser(Users user){
        Users savedUsers = userRepository.save(user);
        return savedUsers.getId();
    }

    public Users updateUser(Long id, Users user){
        return userRepository.update(user);
    }

    public Users getById(Long id) {
        return userRepository.getId(id);
    }

//    public Users createUsers(Users user) {
//        user.setCreatedAt(LocalDateTime.now());
//        return userRepository.save(user);
//    }
}
