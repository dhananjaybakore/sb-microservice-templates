package org.bakore.reactiveapis.service;

import org.bakore.reactiveapis.Stock;
import org.bakore.reactiveapis.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


class StockServiceTest {

    @Mock
    StockRepository stockRepository;

    StockService stockService;

    @BeforeEach
    public void setup (){
        MockitoAnnotations.openMocks(this);
        this.stockService = new StockService(stockRepository);
    }

    @Test
    void givenSymbol_findStockDetails() {
        Stock stock = new Stock();
        stock.setSymbol("VHT");
        stock.setBuyIncrements(3.0);
        stock.setSellIncrements(3.0);
        stock.setStartBuyAtValue(245.0);
        stock.setStartSellAtValue(256.0);
        given(stockRepository.findById("VHT")).willReturn(Mono.just(stock));
        Mono<Stock> stockMono = stockService.getStockBySymbol("VHT");

        StepVerifier.create(stockMono)
                .assertNext(st -> {
                    assertEquals(st.getSymbol(), "VHT");
                    assertEquals(st.getBuyIncrements(),3.0);
                    assertEquals(st.getSellIncrements(),3.0);
                    assertEquals(st.getStartBuyAtValue(),245.0);
                    assertEquals(st.getStartSellAtValue(),256.0);
                })
                .expectComplete()
                .verify();
    }
}