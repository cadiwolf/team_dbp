package com.eventos.eventos;

import com.eventos.eventos.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createOrder(OrderCreatedEvent order) {
        // Aquí podrías agregar lógica de negocio, validaciones, etc.
        eventPublisher.publishEvent(order);
    }
}
