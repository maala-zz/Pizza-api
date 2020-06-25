package com.innoscripta.pizza.dto;

import java.util.List;
import java.util.UUID;

public class AddOrderRequestDto {
    public String name;
    public String surname;
    public String address;
    public String orderSerialId;
    public double deliveryCost;
    public double totalOrderCost;
    public List<PizzaInCartDto> pizzasInCart;
}
