package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(int userId, String newUsername, String newPasswordHash) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(newUsername);
            user.setPasswordHash(newPasswordHash);
            return userRepository.save(user);
        } else {
            // Handle the case where the user with given userId doesn't exist
            return null;
        }
    }
    public User createUser(User user) {
        // You can add validation or business logic here before saving the user
        return userRepository.save(user);
    }

}