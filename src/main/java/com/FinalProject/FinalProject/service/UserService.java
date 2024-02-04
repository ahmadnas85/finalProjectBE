package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.User;
import com.FinalProject.FinalProject.model.UserRequest;

import java.util.List;

public interface UserService {
    void register(User user);

    void deleteUserById(Long userId);

    User getUserByUserName(String userName);

    List<User> getAllUsers();

    UserRequest getUserToLogin(UserRequest userRequest);

    User getUserToLogin(String username, String password);
}
