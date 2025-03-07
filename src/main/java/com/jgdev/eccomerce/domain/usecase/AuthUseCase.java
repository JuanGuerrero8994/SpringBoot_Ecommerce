package com.jgdev.eccomerce.domain.usecase;


import com.jgdev.eccomerce.application.dto.AuthRequestDTO;
import com.jgdev.eccomerce.application.dto.AuthResponseDTO;
import com.jgdev.eccomerce.application.mapper.AuthMapper;
import com.jgdev.eccomerce.application.ports.input.AuthInputPort;
import com.jgdev.eccomerce.application.ports.ouput.AuthOutputPort;
import com.jgdev.eccomerce.domain.model.User;
import com.jgdev.eccomerce.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUseCase implements AuthInputPort {

    private final UserRepository userRepository;
    private final AuthOutputPort authOutputPort;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthUseCase(UserRepository userRepository, AuthOutputPort authOutputPort, AuthMapper authMapper,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authOutputPort = authOutputPort;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void authenticate(AuthRequestDTO request) {
        User user = authMapper.toUser(request);  // Convertimos DTO a dominio
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());

        AuthResponseDTO<User> response;

        if (foundUser.isPresent() && passwordEncoder.matches(request.getPassword(), foundUser.get().getPassword())) {
             response = authMapper.toAuthResponseDTO(foundUser.get(), true, "Authentication success");
        } else {
            response = authMapper.toAuthResponseDTO(null, false, "Incorrect credentials");
        }
        authOutputPort.handle(response);
    }
}