package com.innoscripta.pizza.entity;

import com.innoscripta.pizza.model.InnoscriptaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User extends InnoscriptaEntity {
    //region Properties

    @NotNull(message = "{NotNull.email}")
    @Size(min=8, max=50)
    public String email;

    public String address;
    public String password;
    public String telephone;
    public String name;

    @OneToMany(mappedBy = "user")
    public List<OnlineOrder> orders;

    public User(){

    }

    public User(String email, String address, String password, String telephone, String name) {
        this.email = email;
        this.address = address;
        this.password = password;
        this.telephone = telephone;
        this.name = name;
    }
//endregion
}
