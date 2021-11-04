package org.bakore.reactiveapis.config;

import org.bakore.reactiveapis.Stock;
import org.bakore.reactiveapis.service.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//Specify whether @Bean methods should get proxied in order to enforce bean lifecycle behavior, e.g.
@Configuration(proxyBeanMethods = false)
public class StockRouter {

    @Bean
    public RouterFunction<ServerResponse> route(StockService stockService) {
        return RouterFunctions
                .route(GET("/stock/{symbol}"),   request -> {
                            return ok().body(stockService.getStockBySymbol(request.pathVariable("symbol")), Stock.class);
                        });
    }

}
