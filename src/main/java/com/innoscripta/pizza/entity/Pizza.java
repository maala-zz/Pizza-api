package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pizza extends InnoscriptaEntity {
    public double price;
    public String description;
    public String image_url;

    @OneToMany(mappedBy = "pizza")
    public List<PizzaInOrder> pizzaInOrders;
}
