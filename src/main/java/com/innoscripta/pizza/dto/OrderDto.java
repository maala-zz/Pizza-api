package com.innoscripta.pizza.dto;

import com.innoscripta.pizza.entity.Invoice;
import com.innoscripta.pizza.entity.PizzaInOrder;

import java.util.List;

public class OrderDto {
    public String name;
    public String surname;
    public String address;
    public String orderSerialId;

    public InvoiceDto invoice;

    public List<PizzaInOrderDto> orderPizzas;
}