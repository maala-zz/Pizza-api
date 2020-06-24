package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;

@Entity
public class OnlineOrder extends InnoscriptaEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
