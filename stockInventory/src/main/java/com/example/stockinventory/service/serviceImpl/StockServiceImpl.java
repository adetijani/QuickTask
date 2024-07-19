package com.example.stockinventory.service.serviceImpl;

import com.example.stockinventory.exception.InvalidStockDataException;
import com.example.stockinventory.exception.StockNotFoundException;
import com.example.stockinventory.model.Stock;
import com.example.stockinventory.repository.StockRepository;
import com.example.stockinventory.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Stock updateStockPrice(Long id, BigDecimal newPrice) throws InvalidStockDataException {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidStockDataException("Invalid price data");
        }
        Stock stock = stockRepository.findById(id)
                .orElseThrow();
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(LocalDateTime.now());
        return stockRepository.save(stock);
    }

    @Override
    public Stock createStock(Stock stock) throws InvalidStockDataException {
        if (stock.getName() == null || stock.getCurrentPrice() == null) {
            throw new InvalidStockDataException("Stock name and price cannot be null");
        }
        stock.setCreateDate(LocalDateTime.now());
        stock.setLastUpdate(LocalDateTime.now());
        return stockRepository.save(stock);
    }
}
