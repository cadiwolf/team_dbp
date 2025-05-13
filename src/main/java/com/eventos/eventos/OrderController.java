package com.eventos.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreatedEvent order) {
        eventPublisher.publishEvent(order);
        return ResponseEntity.ok("Pedido recibido y evento publicado");
    }
}
