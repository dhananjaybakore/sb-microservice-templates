package org.bakore.reactiveapis.service;

import org.bakore.reactiveapis.Stock;
import org.bakore.reactiveapis.repository.StockRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StockService {
    private StockRepository stockRepository;
    public StockService(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Mono<Stock> getStockBySymbol(String symbol){
        return stockRepository.findById(symbol);
    }

    public Mono<Stock> saveStock(Stock stock){
        return stockRepository.save(stock);
    }

}
