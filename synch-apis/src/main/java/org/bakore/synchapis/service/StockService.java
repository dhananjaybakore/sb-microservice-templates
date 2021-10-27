package org.bakore.synchapis.service;

import org.bakore.synchapis.model.Stock;
import org.bakore.synchapis.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StockService {
    private StockRepository stockRepository;
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }
    public Stock findBySymbol(String symbol) {
        return stockRepository
                .findById(symbol)
                .orElse(null);
    }
}
