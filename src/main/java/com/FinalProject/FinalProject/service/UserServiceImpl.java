package com.FinalProject.FinalProject.service;

import com.FinalProject.FinalProject.model.User;
import com.FinalProject.FinalProject.model.UserRequest;
import com.FinalProject.FinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        if (userRepository.getUserByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Username" + user.getUserName() + " already exists");
        }
        if (userRepository.getUserByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        if (userRepository.getUserByPhone(user.getPhone()) != null) {
            throw new RuntimeException("Phone already exists");
        }
        userRepository.register(user);
    }
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteUserById(userId);
    }
    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public UserRequest getUserToLogin(UserRequest userRequest) {
        return null;
    }

    @Override
    public User getUserToLogin(String username, String password) {
        return userRepository.findUserByUserNameAndPassword(username, password);
    }
}
