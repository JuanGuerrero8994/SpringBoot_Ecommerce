package com.jgdev.eccomerce.infraestructure.adapters.presenters;

import com.jgdev.eccomerce.application.dto.AuthResponseDTO;
import com.jgdev.eccomerce.application.ports.ouput.AuthOutputPort;
import com.jgdev.eccomerce.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthPresenter implements AuthOutputPort,IPresenter<AuthResponseDTO<User>> {

    private AuthResponseDTO<User> content;


    @Override
    public void handle(AuthResponseDTO<User> response) {
        this.content = response;
    }

    @Override
    public AuthResponseDTO<User> getContent() {
        return content;
    }
}
