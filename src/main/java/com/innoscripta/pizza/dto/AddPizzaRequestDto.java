package com.innoscripta.pizza.dto;

public class AddPizzaRequestDto {
    public double price;
    public String description;
    public String name;
    public String image_url;

    public AddPizzaRequestDto() {
    }

    public AddPizzaRequestDto(double price, String description, String image_url, String name) {
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.name = name;
    }
}
