package com.devjuanguerrero.firstapi.application.mapper;

import com.devjuanguerrero.firstapi.application.dto.AuthResponseDTO;
import com.devjuanguerrero.firstapi.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthResponseMapper {
    public AuthResponseDTO<User> toAuthResponseDTO(User user, boolean success, String message) {
        return new AuthResponseDTO<User>(success, message, user);
    }
}
