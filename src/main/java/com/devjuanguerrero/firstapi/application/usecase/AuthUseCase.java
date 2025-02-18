package com.devjuanguerrero.firstapi.application.usecase;

import com.devjuanguerrero.firstapi.application.dto.AuthRequestDTO;
import com.devjuanguerrero.firstapi.application.dto.AuthResponseDTO;
import com.devjuanguerrero.firstapi.application.mapper.AuthRequestMapper;
import com.devjuanguerrero.firstapi.application.mapper.AuthResponseMapper;
import com.devjuanguerrero.firstapi.application.ports.input.AuthInputPort;
import com.devjuanguerrero.firstapi.application.ports.ouput.AuthOutputPort;
import com.devjuanguerrero.firstapi.domain.model.User;
import com.devjuanguerrero.firstapi.infraestructure.adapter.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUseCase implements AuthInputPort {
    private final UserRepositoryImpl userRepository;
    private final AuthOutputPort authOutputPort;
    private final AuthRequestMapper authRequestMapper;
    private final AuthResponseMapper authResponseMapper;

    private final PasswordEncoder passwordEncoder;



    @Autowired
    public AuthUseCase(UserRepositoryImpl userRepository, AuthOutputPort authOutputPort, AuthRequestMapper authRequestMapper, AuthResponseMapper authResponseMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authOutputPort = authOutputPort;
        this.authRequestMapper = authRequestMapper;
        this.authResponseMapper = authResponseMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AuthResponseDTO<User> authenticate(AuthRequestDTO request) {
        User user = authRequestMapper.toUser(request);  // Convertimos DTO a dominio
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());

        if (foundUser.isPresent() && passwordEncoder.matches(request.getPassword(), foundUser.get().getPassword())) {
            AuthResponseDTO<User> response = authResponseMapper.toAuthResponseDTO(foundUser.get(), true, "Authentication success");
            authOutputPort.handle(response);  // Invoca el Output Port
            return response;
        } else {
            AuthResponseDTO<User> response = authResponseMapper.toAuthResponseDTO(null, false, "Incorrect credentials");
            authOutputPort.handle(response);  // Invoca el Output Port
            return response;
        }
    }
}