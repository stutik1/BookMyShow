package com.stuti.controller;

import com.stuti.Users;
//import com.stuti.Util;
import com.stuti.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bms/user")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/users")
//    public ResponseEntity<Users> createdUser(@RequestBody Users user) {
//        Users createdUser = userService.createUsers(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@Valid @RequestBody Users user){

            Long createdUser =  userService.saveUser(user);

//        if (!Util.validateEmail(user.getEmail())) {
//            return ResponseEntity.badRequest().body("Invalid email address");
//        }
        // return  ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Users> updateById(@PathVariable Long id, @RequestBody Users updateUser ){
        Users user = userService.updateUser(id,updateUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id) {
        Users user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
}
