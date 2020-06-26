package com.innoscripta.pizza.dto;

import java.util.UUID;

public class PizzaInOrderDto {
    public UUID id;
    public double price;
    public int quantity;
    public String name;

    public PizzaInOrderDto() {
    }

    public PizzaInOrderDto(UUID id, double price, int quantity, String name) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }
}
