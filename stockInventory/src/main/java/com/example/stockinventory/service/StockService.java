package com.example.stockinventory.service;

import com.example.stockinventory.exception.InvalidStockDataException;
import com.example.stockinventory.model.Stock;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id);
    Stock updateStockPrice(Long id, BigDecimal newPrice) throws InvalidStockDataException;
    Stock createStock(Stock stock) throws InvalidStockDataException;
}
