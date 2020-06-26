package com.innoscripta.pizza.service;

import com.innoscripta.pizza.dto.*;
import com.innoscripta.pizza.entity.*;
import com.innoscripta.pizza.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Component
public class OrderService {

    //region Properties
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PizzaInOrderRepository pizzaInOrderRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;
    //endregion

    //region Methods
    public ResponseEntity<AddOrderResponseDto> add(HttpServletRequest req, AddOrderRequestDto orderDto) {
        try {
            String bearerToken = req.getHeader("Authorization");
            final String token = jwtTokenUtil.fetchTokenWithoutBearerWord(bearerToken);
            UUID currentUserId = jwtTokenUtil.getUserId(token);
            OnlineOrder mappedOrder = new OnlineOrder(orderDto.name, orderDto.surname, orderDto.address, orderDto.orderSerialId);

            OnlineOrder order = orderRepository.save(mappedOrder);

            //region link order with user
            User user = userRepository.findUserById(currentUserId);
            order.user = user;
            user.orders.add(order);
            //endregion

            //region link order with pizzas
            if (orderDto.pizzasInCart != null) {
                for (PizzaInCartDto pizzaInCartDto : orderDto.pizzasInCart) {
                    Pizza pizza = pizzaRepository.findPizzaById(pizzaInCartDto.id);
                    PizzaInOrder pizzaOrder = new PizzaInOrder(pizza, order, pizzaInCartDto.quantity);
                    pizza.pizzaInOrders.add(pizzaOrder);
                    order.orderPizzas.add(pizzaOrder);
                    pizzaInOrderRepository.save(pizzaOrder);
                }
            }
            //endregion

            //region link order with invoice
            Invoice invoice = new Invoice(orderDto.deliveryCost, orderDto.totalOrderCost);
            invoice.onlineOrder = order;
            invoiceRepository.save(invoice);
            //endregion

            return new ResponseEntity<AddOrderResponseDto>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<AddOrderResponseDto>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public ResponseEntity<List<OrderDto>> getCurrentUserOrders(HttpServletRequest req) {
        try {
            String bearerToken = req.getHeader("Authorization");
            final String token = jwtTokenUtil.fetchTokenWithoutBearerWord(bearerToken);
            UUID currentUserId = jwtTokenUtil.getUserId(token);
            List<OnlineOrder> test = orderRepository.findByUserId(currentUserId);
            return new ResponseEntity<List<OrderDto>>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<List<OrderDto>>(HttpStatus.FAILED_DEPENDENCY);
        }
    }
    //endregion

}
