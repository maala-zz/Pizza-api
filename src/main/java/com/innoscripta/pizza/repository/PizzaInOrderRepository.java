package com.innoscripta.pizza.repository;

import com.innoscripta.pizza.entity.PizzaInOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PizzaInOrderRepository extends CrudRepository<PizzaInOrder, UUID> {
}
