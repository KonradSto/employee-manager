package com.konradsto.employeedirectory.controller;

import com.konradsto.employeedirectory.model.Users;
import com.konradsto.employeedirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void addUser(@RequestBody Users user){
        userService.saveUser(user);
    }
}
