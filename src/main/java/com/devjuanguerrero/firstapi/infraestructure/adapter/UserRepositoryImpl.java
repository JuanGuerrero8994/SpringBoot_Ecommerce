package com.devjuanguerrero.firstapi.infraestructure.adapter;

import com.devjuanguerrero.firstapi.domain.model.User;
import com.devjuanguerrero.firstapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryImpl {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
