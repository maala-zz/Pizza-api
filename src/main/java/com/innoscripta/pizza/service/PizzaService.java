package com.innoscripta.pizza.service;

import com.innoscripta.pizza.dto.*;
import com.innoscripta.pizza.entity.Pizza;
import com.innoscripta.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PizzaService {

    //region Properties
    @Autowired
    private PizzaRepository pizzaRepository;
    //endregion

    //region Methods
    public ResponseEntity<List<PizzaDto>> getAll() {
        try {
            List<Pizza> pizzas = (List<Pizza>) pizzaRepository.findAll();

            List<PizzaDto> pizzaDtos = pizzas.stream()
                    .map(pizza -> new PizzaDto(pizza.id, pizza.price, pizza.description, pizza.image_url))
                    .collect(Collectors.toList());
            return new ResponseEntity<List<PizzaDto>>(pizzaDtos, HttpStatus.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<List<PizzaDto>>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public ResponseEntity<AddPizzaResponseDto> add(AddPizzaRequestDto pizzaDto) {
        try {
            Pizza pizza = new Pizza(pizzaDto.price, pizzaDto.description);
            Pizza result = pizzaRepository.save(pizza);
            return new ResponseEntity<AddPizzaResponseDto>(new AddPizzaResponseDto(result.id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<AddPizzaResponseDto>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public Pizza loadPizzaById(UUID pizzaId) {
        try {
            Pizza pizza = pizzaRepository.findPizzaById(pizzaId);
            return pizza;
        } catch (Exception ex) {
            return null;
        }
    }
    //endregion
}
