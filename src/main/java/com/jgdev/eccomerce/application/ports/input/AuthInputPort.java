package com.jgdev.eccomerce.application.ports.input;


import com.jgdev.eccomerce.application.dto.AuthRequestDTO;

public interface AuthInputPort {
    void authenticate(AuthRequestDTO request);
}