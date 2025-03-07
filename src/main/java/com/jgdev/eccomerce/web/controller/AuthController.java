package com.jgdev.eccomerce.web.controller;

import com.jgdev.eccomerce.application.dto.AuthRequestDTO;
import com.jgdev.eccomerce.application.dto.AuthResponseDTO;
import com.jgdev.eccomerce.application.ports.input.AuthInputPort;
import com.jgdev.eccomerce.domain.model.User;
import com.jgdev.eccomerce.infraestructure.adapters.presenters.IPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthInputPort authenticatorInputPort;
    private final IPresenter<AuthResponseDTO<User>> authPresenter;  // Aquí especificas el tipo de T

    @Autowired
    public AuthController(AuthInputPort authInputPort, IPresenter<AuthResponseDTO<User>> authPresenter) {
        this.authenticatorInputPort = authInputPort;
        this.authPresenter = authPresenter;
    }

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody AuthRequestDTO request) {
        authenticatorInputPort.authenticate(request);

        AuthResponseDTO<User> response = authPresenter.getContent();  // Aquí también especificas el tipo de T

        if (response != null && response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

