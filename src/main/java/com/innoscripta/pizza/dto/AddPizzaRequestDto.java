package com.innoscripta.pizza.dto;

import java.util.UUID;

public class AddPizzaRequestDto {
    public double price;
    public String description;
    public String image_url;

    public AddPizzaRequestDto() {
    }

    public AddPizzaRequestDto(double price, String description, String image_url) {
        this.price = price;
        this.description = description;
        this.image_url = image_url;
    }
}
