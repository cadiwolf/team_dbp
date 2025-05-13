package com.eventos.eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {
    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("Reduciendo stock para productos: " + event.getProducts());
    }
}
