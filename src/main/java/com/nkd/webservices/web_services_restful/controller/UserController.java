package com.nkd.webservices.web_services_restful.controller;

import com.nkd.webservices.web_services_restful.entity.User;
import com.nkd.webservices.web_services_restful.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{userId}")
    private ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") Long userId) {
        Optional<User> optionalUser = userService.getUserById(userId);
        return new ResponseEntity<>(optionalUser, HttpStatus.OK);
    }

    @PostMapping("save")
    private ResponseEntity<User> saveUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("delete/{userId}")
    private String deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "User why id " + userId + "was deleted";
    }

    @PutMapping("update/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        User updateUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updateUser);
    }

}
