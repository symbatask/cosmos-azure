package com.development.cosmosdbapi;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.spring.autoconfigure.cosmos.CosmosProperties;
import com.development.cosmosdbapi.entity.Cart;
import com.development.cosmosdbapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@SpringBootApplication
public class CosmosDbApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CosmosDbApiApplication.class, args);
    }
}