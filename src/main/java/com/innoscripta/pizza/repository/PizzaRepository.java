package com.innoscripta.pizza.repository;

import com.innoscripta.pizza.entity.Pizza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, UUID> {

    @Query("SELECT u FROM Pizza u WHERE u.id = :id")
    Pizza findPizzaById(@Param("id") UUID id);

}
