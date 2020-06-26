package com.innoscripta.pizza.repository;

import com.innoscripta.pizza.entity.OnlineOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<OnlineOrder, UUID> {

    List<OnlineOrder> findByUserId(UUID userId);
}
