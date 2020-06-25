package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OnlineOrder extends InnoscriptaEntity {

    public String name;
    public String surname;
    public String address;
    public String orderSerialId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @OneToMany(mappedBy = "onlineOrder")
    public List<PizzaInOrder> orderPizzas;

    @OneToOne(mappedBy = "onlineOrder", cascade = CascadeType.ALL)
    public Invoice invoice;

    public OnlineOrder() {
    }

    public OnlineOrder(String name, String surname, String address, String orderSerialId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.orderSerialId = orderSerialId;
        this.orderPizzas = new ArrayList<>();
    }
}
