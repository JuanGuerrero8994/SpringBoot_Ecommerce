package com.jgdev.eccomerce.application.repository;

import com.jgdev.eccomerce.domain.model.User;
import com.jgdev.eccomerce.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthRepositoryImpl {

    private final UserRepository userRepository;

    @Autowired
    public AuthRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> authenticate(String email, String password) {
        // Llamamos al procedimiento almacenado desde el repositorio
        return userRepository.authenticateUser(email, password);
    }
}
