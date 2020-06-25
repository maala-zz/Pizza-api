package com.innoscripta.pizza.controller;

import com.innoscripta.pizza.dto.AddOrderRequestDto;
import com.innoscripta.pizza.dto.AddOrderResponseDto;
import com.innoscripta.pizza.dto.AddPizzaRequestDto;
import com.innoscripta.pizza.dto.AddPizzaResponseDto;
import com.innoscripta.pizza.service.OrderService;
import com.innoscripta.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AddOrderResponseDto> add(HttpServletRequest req, @RequestBody AddOrderRequestDto orderDto) {
        ResponseEntity<AddOrderResponseDto> result = orderService.add(req, orderDto);
        return result;
    }

}
