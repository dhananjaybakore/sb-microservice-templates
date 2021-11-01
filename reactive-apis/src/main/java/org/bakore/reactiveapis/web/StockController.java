package org.bakore.reactiveapis.web;

import org.bakore.reactiveapis.Stock;
import org.bakore.reactiveapis.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    private Mono<Stock> getStockBySymbol(@PathVariable String symbol){
        return stockService.getStockBySymbol(symbol);
    }
}
