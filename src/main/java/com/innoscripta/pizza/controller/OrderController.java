package com.innoscripta.pizza.controller;

import com.innoscripta.pizza.dto.AddOrderRequestDto;
import com.innoscripta.pizza.dto.AddOrderResponseDto;
import com.innoscripta.pizza.dto.OrderDto;
import com.innoscripta.pizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getCurrentUserOrders(HttpServletRequest req) {
        ResponseEntity<List<OrderDto>> result = orderService.getCurrentUserOrders(req);
        return result;
    }

}
