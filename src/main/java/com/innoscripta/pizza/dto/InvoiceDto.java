package com.innoscripta.pizza.dto;

import java.util.UUID;

public class InvoiceDto {
    public UUID id;
    public double deliveryCost;
    public double totalOrderCost;

    public InvoiceDto() {
    }

    public InvoiceDto(UUID id, double deliveryCost, double totalOrderCost) {
        this.id = id;
        this.deliveryCost = deliveryCost;
        this.totalOrderCost = totalOrderCost;
    }
}
