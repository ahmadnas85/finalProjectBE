package com.FinalProject.FinalProject.repository;


import com.FinalProject.FinalProject.model.User;

import java.util.List;

public interface UserRepository {


    void register(User user);

    void deleteUserById(Long userId);

    User getUserByUserName(String userName);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

    User findUserByUserNameAndPassword(String userName, String password);
}
