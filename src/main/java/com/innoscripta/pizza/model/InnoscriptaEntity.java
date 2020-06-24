package com.innoscripta.pizza.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
public class InnoscriptaEntity {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id", columnDefinition = "BINARY(16)")
    public UUID id;

    @Column( columnDefinition = "BINARY(16)" )
    public UUID createdBy;

    @Column( columnDefinition = "BINARY(16)" )
    public UUID deletedBy;

    public boolean isActive;


    @CreationTimestamp
    public Timestamp createdAt;

    public Timestamp deletedAt;

    @UpdateTimestamp
    public Timestamp updatedAt;
    //endregion


}
