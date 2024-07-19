package com.example.stockinventory.repository;

import com.example.stockinventory.model.Stock;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StockRepository {

    private final List<Stock> stocks = new ArrayList<>();
    private Long idCounter = 1L;

    public StockRepository() {
        // Initialize with some stocks
        Stock stock1 = new Stock();
        stock1.setId(idCounter++);
        stock1.setName("Apple");
        stock1.setCurrentPrice(new BigDecimal("150.00"));
        stock1.setCreateDate(LocalDateTime.now());
        stock1.setLastUpdate(LocalDateTime.now());
        stocks.add(stock1);

        Stock stock2 = new Stock();
        stock2.setId(idCounter++);
        stock2.setName("Google");
        stock2.setCurrentPrice(new BigDecimal("2800.00"));
        stock2.setCreateDate(LocalDateTime.now());
        stock2.setLastUpdate(LocalDateTime.now());
        stocks.add(stock2);
    }

    public List<Stock> findAll() {
        return stocks;
    }

    public Optional<Stock> findById(Long id) {
        return stocks.stream().filter(stock -> stock.getId().equals(id)).findFirst();
    }

    public Stock save(Stock stock) {
        if (stock.getId() == null) {
            stock.setId(idCounter++);
            stock.setCreateDate(LocalDateTime.now());
        }
        stock.setLastUpdate(LocalDateTime.now());
        stocks.removeIf(s -> s.getId().equals(stock.getId()));
        stocks.add(stock);
        return stock;
    }
}
