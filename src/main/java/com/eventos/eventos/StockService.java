package com.eventos.eventos;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockService {
    private final Map<String, Integer> stock = new HashMap<>();

    public StockService() {
        // Inicializa el stock de ejemplo
        stock.put("producto1", 10);
        stock.put("producto2", 5);
        stock.put("producto3", 20);
    }

    public boolean reduceStock(String product) {
        Integer current = stock.get(product);
        if (current != null && current > 0) {
            stock.put(product, current - 1);
            return true;
        }
        return false;
    }

    public int getStock(String product) {
        return stock.getOrDefault(product, 0);
    }

    public Map<String, Integer> getAllStock() {
        return stock;
    }
}