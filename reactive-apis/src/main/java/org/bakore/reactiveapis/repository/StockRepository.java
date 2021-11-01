package org.bakore.reactiveapis.repository;

import org.bakore.reactiveapis.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends ReactiveCrudRepository<Stock, String> {
}
