package com.FinalProject.FinalProject.controller;

import com.FinalProject.FinalProject.model.User;
import com.FinalProject.FinalProject.model.UserRequest;
import com.FinalProject.FinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }
    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam Long userId) {
        userService.deleteUserById(userId);
    }
    @PostMapping("/login")
    public User login(@RequestBody UserRequest userRequest) {
        String username = userRequest.getUsername();
        String password = userRequest.getPassword();
        User authUser = userService.getUserToLogin(username, password);
        if (authUser != null) {
            return authUser;
        } else {
            return null;
        }
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
