package com.innoscripta.pizza.dto;

import java.util.UUID;

public class AddPizzaResponseDto {
    public UUID pizzaId;

    public AddPizzaResponseDto() {
    }

    public AddPizzaResponseDto(UUID pizzaId) {
        this.pizzaId = pizzaId;
    }
}
