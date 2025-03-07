package com.jgdev.eccomerce.application.ports.ouput;

import com.jgdev.eccomerce.application.dto.AuthResponseDTO;
import com.jgdev.eccomerce.domain.model.User;
import org.springframework.stereotype.Service;

public interface AuthOutputPort {
     void handle(AuthResponseDTO<User> response);
}