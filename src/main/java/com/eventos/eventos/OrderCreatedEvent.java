package com.eventos.eventos;


import lombok.Data;

import java.util.List;

@Data
public class OrderCreatedEvent {
    private String orderId;
    private String email;
    private List<String> products;

    // Constructor, getters y setters
}