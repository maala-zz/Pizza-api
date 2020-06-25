package com.innoscripta.pizza.dto;

import java.util.UUID;

public class PizzaDto {
    public UUID id;
    public double price;
    public String description;
    public String image_url;

    public PizzaDto() {
    }

    public PizzaDto(UUID id, double price, String description, String image_url) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
    }

}
