package com.innoscripta.pizza.dto;

import java.util.UUID;

public class SignupResponseDto {
    public UUID userId;

    public SignupResponseDto(UUID userId) {
        this.userId = userId;
    }
}
