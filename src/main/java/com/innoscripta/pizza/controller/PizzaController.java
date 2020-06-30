package com.innoscripta.pizza.controller;

import com.innoscripta.pizza.dto.AddPizzaRequestDto;
import com.innoscripta.pizza.dto.AddPizzaResponseDto;
import com.innoscripta.pizza.dto.PizzaDto;
import com.innoscripta.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    public PizzaService pizzaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PizzaDto>> getAll() {
        ResponseEntity<List<PizzaDto>> result = pizzaService.getAll();
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AddPizzaResponseDto> add(@RequestBody AddPizzaRequestDto pizzaDto) {
        ResponseEntity<AddPizzaResponseDto> result = pizzaService.add(pizzaDto);
        return result;
    }

}
