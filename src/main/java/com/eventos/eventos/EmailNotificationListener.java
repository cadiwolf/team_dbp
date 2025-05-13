package com.eventos.eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("Enviando correo de confirmación a: " + event.getEmail());
    }
}