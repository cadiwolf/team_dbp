package com.eventos.eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {
    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    private final StockService stockService;

    public InventoryUpdateListener(StockService stockService) {
        this.stockService = stockService;
    }

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        for (String product : event.getProducts()) {
            boolean reduced = stockService.reduceStock(product);
            if (reduced) {
                logger.info("Stock reducido para " + product + ". Stock actual: " + stockService.getStock(product));
            } else {
                logger.warn("No hay stock suficiente para " + product);
            }
        }
    }
}