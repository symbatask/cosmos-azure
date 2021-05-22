package com.development.cosmosdbapi.repository;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.development.cosmosdbapi.entity.Cart;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CartRepository extends ReactiveCosmosRepository<Cart, String> {
    Flux<Cart> findByUserID(String id);
    void deleteByUserID(String id);
}