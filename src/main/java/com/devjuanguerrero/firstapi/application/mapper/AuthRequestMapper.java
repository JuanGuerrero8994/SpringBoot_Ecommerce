package com.devjuanguerrero.firstapi.application.mapper;

import com.devjuanguerrero.firstapi.application.dto.AuthRequestDTO;
import com.devjuanguerrero.firstapi.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthRequestMapper {
    public User toUser(AuthRequestDTO authRequestDTO) {
        User user = new User();
        user.setEmail(authRequestDTO.getEmail());
        user.setPasswordHash(authRequestDTO.getPassword());
        return user;
    }
}
