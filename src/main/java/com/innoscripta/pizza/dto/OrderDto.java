package com.innoscripta.pizza.dto;

import java.util.List;

public class OrderDto {
    public String name;
    public String surname;
    public String address;
    public String orderSerialId;

    public InvoiceDto invoice;

    public List<PizzaInOrderDto> orderPizzas;

    public OrderDto() {
    }

    public OrderDto(String name, String surname, String address, String orderSerialId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.orderSerialId = orderSerialId;
    }
}
