package com.jgdev.eccomerce.application.mapper;

import com.jgdev.eccomerce.application.dto.AuthRequestDTO;
import com.jgdev.eccomerce.application.dto.AuthResponseDTO;
import com.jgdev.eccomerce.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public User toUser(AuthRequestDTO authRequestDTO) {
        User user = new User();
        user.setEmail(authRequestDTO.getEmail());
        user.setPassword(authRequestDTO.getPassword());
        return user;
    }

    public AuthResponseDTO<User> toAuthResponseDTO(User user, boolean success, String message) {
        return new AuthResponseDTO<User>(success, message, user);
    }
}
