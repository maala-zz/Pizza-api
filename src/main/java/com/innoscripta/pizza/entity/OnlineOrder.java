package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class OnlineOrder extends InnoscriptaEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    @OneToMany(mappedBy = "onlineOrder")
    public List<PizzaInOrder> orderPizzas;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    public Invoice invoice;
}
