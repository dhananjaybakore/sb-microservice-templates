package org.bakore.reactiveapis.config;

import org.bakore.reactiveapis.Stock;
import org.bakore.reactiveapis.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StockRouterTest {


    private StockRouter router;

    @Mock
    private StockService stockService;

    @BeforeEach
    public void setup (){
        MockitoAnnotations.openMocks(this);
        this.router = new StockRouter(stockService);
    }

    @Test
    void givenStockSymbol_whenGetStockBySymbol_thenGetCorrectStock() {

        WebTestClient client = WebTestClient.bindToRouterFunction(router.route()).build();

        Stock stock = new Stock();
        stock.setSymbol("VHT");
        stock.setBuyIncrements(3.0);
        stock.setSellIncrements(3.0);
        stock.setStartBuyAtValue(245.0);
        stock.setStartSellAtValue(256.0);

        given(stockService.getStockBySymbol("VHT")).willReturn(Mono.just(stock));

        client.get().uri("/stock/VHT")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Stock.class)
                .isEqualTo(stock);

        verify(stockService, times(1)).getStockBySymbol("VHT");
    }
}