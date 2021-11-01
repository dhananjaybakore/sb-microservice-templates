package org.bakore.synchapis.web;

import org.bakore.synchapis.model.Stock;
import org.bakore.synchapis.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class ApiController {

 private StockService stockService;

 public ApiController(StockService stockService){
  this.stockService = stockService;
 }

 @GetMapping("/{symbol}")
 public Stock findBySymbol(@PathVariable String symbol) {
  return stockService.findBySymbol(symbol);
 }
}
