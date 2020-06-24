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



    //endregion
}
