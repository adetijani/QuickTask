package com.example.stockinventory.controller;

import com.example.stockinventory.exception.InvalidStockDataException;
import com.example.stockinventory.model.Stock;
import com.example.stockinventory.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;


    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStockPrice(@PathVariable Long id, @RequestBody BigDecimal newPrice) throws InvalidStockDataException {
        Stock updatedStock = stockService.updateStockPrice(id, newPrice);
        return ResponseEntity.ok(updatedStock);
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) throws InvalidStockDataException {
        Stock createdStock = stockService.createStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }
}