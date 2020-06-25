package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;

@Entity
public class Invoice extends InnoscriptaEntity {

    public double deliveryCost;

    public double totalOrderCost;

    @OneToOne
    @MapsId
    public OnlineOrder onlineOrder;

    public Invoice() {
    }

    public Invoice(double deliveryCost, double totalOrderCost) {
        this.deliveryCost = deliveryCost;
        this.totalOrderCost = totalOrderCost;
    }
}
