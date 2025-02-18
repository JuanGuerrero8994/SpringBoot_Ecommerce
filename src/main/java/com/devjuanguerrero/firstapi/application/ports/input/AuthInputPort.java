package com.devjuanguerrero.firstapi.application.ports.input;

import com.devjuanguerrero.firstapi.application.dto.AuthRequestDTO;
import com.devjuanguerrero.firstapi.application.dto.AuthResponseDTO;
import com.devjuanguerrero.firstapi.domain.model.User;

public interface AuthInputPort {
    AuthResponseDTO<User> authenticate(AuthRequestDTO request);
}