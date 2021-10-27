package org.bakore.synchapis.web;

import org.bakore.synchapis.model.Stock;
import org.bakore.synchapis.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.awt.print.Book;
import java.util.Collection;

@RestController
public class ApiController {

 private StockService stockService;

 @GetMapping("/{symbol}")
 public Stock findBySymbol(@PathVariable String symbol) {
  return stockService.findBySymbol(symbol);
 }
}
