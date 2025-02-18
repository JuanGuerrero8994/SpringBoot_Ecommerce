package com.devjuanguerrero.firstapi.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor  // Constructor con tres parámetros
@ToString
@EqualsAndHashCode
public class AuthResponseDTO<T> {
    private boolean success;
    private String message;
    private T data;

    public AuthResponseDTO(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}