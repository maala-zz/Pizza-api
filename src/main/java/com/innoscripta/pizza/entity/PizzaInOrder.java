package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;

@Entity
public class PizzaInOrder extends InnoscriptaEntity {

    @ManyToOne
    @JoinColumn(name="pizza_id")
    public Pizza pizza;

    @ManyToOne
    @JoinColumn(name="order_id")
    public OnlineOrder onlineOrder;

    public int quantity;

    public PizzaInOrder() {
    }

    public PizzaInOrder(Pizza pizza, OnlineOrder onlineOrder, int quantity) {
        this.pizza = pizza;
        this.onlineOrder = onlineOrder;
        this.quantity = quantity;
    }
}
