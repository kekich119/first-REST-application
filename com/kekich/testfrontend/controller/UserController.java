package com.kekich.testfrontend.controller;


import com.kekich.testfrontend.model.User;
import com.kekich.testfrontend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private List<User> users = new ArrayList<User>();

    @GetMapping
    public List<User> getUsers() {
        System.out.println(userService.showAllUsers());
        users.addAll(userService.showAllUsers());
        return userService.showAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        userService.saveUser(user);
        return user;
    }

}
