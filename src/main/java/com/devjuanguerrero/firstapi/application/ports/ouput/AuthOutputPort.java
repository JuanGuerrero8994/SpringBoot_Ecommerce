package com.devjuanguerrero.firstapi.application.ports.ouput;

import com.devjuanguerrero.firstapi.application.dto.AuthResponseDTO;
import com.devjuanguerrero.firstapi.domain.model.User;

public interface AuthOutputPort {
    void handle(AuthResponseDTO<User> response);
}