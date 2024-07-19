package com.example.stockinventory.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Stock {
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
