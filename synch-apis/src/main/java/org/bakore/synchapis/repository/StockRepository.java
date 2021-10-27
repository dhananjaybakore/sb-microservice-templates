package org.bakore.synchapis.repository;

import org.bakore.synchapis.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
}
