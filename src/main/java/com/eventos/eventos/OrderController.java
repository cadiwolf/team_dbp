package com.eventos.eventos;

import com.eventos.eventos.OrderCreatedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreatedEvent order) {
        orderService.createOrder(order);
        return ResponseEntity.ok("Pedido recibido y evento publicado");
    }
}
