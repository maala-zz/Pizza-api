package entity;

import model.InnoscriptaEntity;

import javax.persistence.*;

@Entity
public class User extends InnoscriptaEntity {
    //region Properties

    @Column(unique = true)
    public String email;

    public String address;
    public String password;
    public String telephone;

    //endregion
}
