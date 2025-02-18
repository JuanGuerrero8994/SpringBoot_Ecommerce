package com.devjuanguerrero.firstapi.web.controller;


import com.devjuanguerrero.firstapi.application.dto.AuthRequestDTO;
import com.devjuanguerrero.firstapi.application.ports.input.AuthInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthInputPort authenticatorInputPort;

    public AuthController(AuthInputPort authenticatorInputPort) {
        this.authenticatorInputPort = authenticatorInputPort;
    }

    @PostMapping("/login")
    public void authenticate(@RequestBody AuthRequestDTO request) {
        authenticatorInputPort.authenticate(request);
    }
}